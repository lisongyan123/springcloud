package com.bank.irce.ltgj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.bank.irce.ltgj.common.*;
import com.bank.irce.ltgj.entity.*;
import com.bank.irce.ltgj.entity.AirmLtgjMasterBody;
import com.bank.irce.ltgj.entity.dto.*;
import com.bank.irce.ltgj.feign.AirmGsdAccessModel;
import com.bank.irce.ltgj.feign.IrceDataService;
import com.bank.irce.ltgj.mapper.AirmLogInfoMapper;
import com.bank.irce.ltgj.mapper.Custcard1ModelInvokeMapper;
import com.bank.irce.ltgj.mapper.Custcard2ModelInvokeMapper;
import com.bank.irce.ltgj.mapper.FxgdMasterAduitCreditMapper;
import com.bank.irce.ltgj.method.CreditMapping;
import com.bank.irce.ltgj.method.CustScoreFeat1;
import com.bank.irce.ltgj.method.CustScoreFeat2;
import com.bank.irce.ltgj.service.ArimFxgdService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/14
 */
@Slf4j
@Service
public class ArimFxgdServiceImpl implements ArimFxgdService {

    @Autowired
    private IrceDataService irceDataService;

    @Resource
    private FxgdMasterAduitCreditMapper masterAduitCreditMapper;

    @Autowired
    private AirmGsdAccessModel accessModel;

    @Resource
    private Custcard1ModelInvokeMapper custcard1ModelInvokeMapper;

    @Resource
    private Custcard2ModelInvokeMapper custcard2ModelInvokeMapper;

    @Resource
    private AirmLogInfoMapper airmLogInfoMapper;

    /**
     * 获取模型信息对象
     *
     * @return 模型信息对象
     */
    @Override
    public ModelNoInfo getModelNo() {
        ModelNoInfo modelNoInfo = new ModelNoInfo(PropertiesUtil.modelInfo);
        return modelNoInfo;
    }

    public Double getScoreJson(String bairongInfo) {
        BairongInfo bairong = JSONObject.parseObject(bairongInfo,BairongInfo.class);
        JSONObject returnBody = (JSONObject) JSONObject.toJSON(JSONObject.toJSONString(bairong.getReturnBody()));
        JSONObject scoreJson = (JSONObject) returnBody.get("Score");
        Double scoreconson = (Double) scoreJson.get("scoreconson");
        return scoreconson;
    }

    /**
     * 获取征信报文拉取路径
     *
     * @param
     * @return
     */
    public String getFileName(String pbccAddr) {
        String fileName = "";
        int i = pbccAddr.indexOf("|");
        if(i == -1){
            fileName =  pbccAddr;
        } else {
            fileName = pbccAddr.substring(0, i);
        }

        if (!fileName.contains("ORI")) {
            fileName = pbccAddr.substring(i + 1, pbccAddr.length());
        }
        return fileName;
    }

    /**
     * 调用科技部接口获取报文
     *
     * @param
     * @return
     */
    public String getContext(String sessionId, ConfirmReadDto confirmReadDto, OperTable operTable) throws TradeException {
        LoggerUtil.logBusinessFile("下载报文请求参数 " + confirmReadDto);
        Map map = irceDataService.confirmRead(confirmReadDto);
        LoggerUtil.logBusinessFile("下载报文响应参数 >>>>>" + sessionId + ":" + Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data.msg")).orElse("下载报告"));
        if (!callIrceDataService(map)) {
            confirmReadDto.setSessionid(RandomNumber.getRandom());
            LoggerUtil.logBusinessFile("下载报文请求参数（重试） : " + confirmReadDto);
            map = irceDataService.confirmRead(confirmReadDto);
            LoggerUtil.logBusinessFile("下载报文响应参数（重试）>>>>>" + Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data.msg")).orElse("下载报告"));
            if (!callIrceDataService(map)) {
                throw new TradeException(StateCode.ER_VERIFY_ERROR.getCode(), ModelConstant.ER_IRCE_DATA);
            }
        }
        operTable.getEdmpAccessLog().add(new EdmpAccessLog("科技部接口", Constant.RESP_SUSECC, JSON.toJSONString(confirmReadDto), JSON.toJSONString(map), "P0003", "平安无抵押风险共担", sessionId));
        String context = Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data.context")).orElse(Constant.DEFAULT_PARAMS).toString();
        return context;
    }

    /**
     * 征信报文下载重试
     *
     * @param map
     * @return
     * @throws
     */
    public Boolean callIrceDataService(Map map) throws TradeException {

        if ("WB006".equals(map.getOrDefault("errorCode", "").toString())) {
            return false;
        }
        if ("".equals(Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data")).orElse("").toString())
                || "".equals(Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data.code")).orElse("").toString())
                || "".equals(Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data.context")).orElse("").toString())
                || Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data.context")).orElse("").toString().length() == 0) {
            log.info("下载征信报文" + Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data")).orElse("").toString());
            throw new TradeException(StateCode.ER_VERIFY_ERROR.getCode(), ModelConstant.ER_IRCE_DATA);
        }
        if (0 != Integer.parseInt(Optional.ofNullable(JSONPath.eval(JSONObject.parseObject(JSON.toJSONString(map)), "$data.code")).orElse("-1").toString())) {
            return false;
        }
        return true;
    }

    public String getPbccAddr(AirmLtgjMasterBody airmLtgjMasterBody) {
        AuthorizationInfo authorizationInfo = JSONObject.parseObject(airmLtgjMasterBody.getAuthorizationInfo(),AuthorizationInfo.class);
        String addr = authorizationInfo.getPbccAddr();
        return addr;
    }

    public AirmLtgjMasterBody productCard(ResponseData<Map> val1,ResponseData<Map> val2, AirmLtgjMasterBody airmLtgjMasterBody) {
        String result = airmLtgjMasterBody.getCreditResult();
        Function<String,CreditResult> jsonParse = (param) -> JSONObject.parseObject(param,CreditResult.class);
        CreditResult creditResult = jsonParse.apply(result);
        if(airmLtgjMasterBody.getCreditCode().equals("2")) {
            creditResult.setQueryType("00000000111");
        }
        result = JSONObject.toJSONString(creditResult);
        airmLtgjMasterBody.setCreditCode(result);
        return airmLtgjMasterBody;
    }

    /**
     * 客户卡1.0特征加工
     *
     * @param sessionId 流水号
     * @param context   JOSN格式的
     * @param operTable 落表集合
     * @return
     * @throws TradeException
     */
    @Override
    public CustCard1ResVo getExternalDataCustCard1(String sessionId, String context, OperTable operTable) throws TradeException {
        try {
            if (Constant.DEFAULT_PARAMS.equals(context)) {
                return new CustCard1ResVo(sessionId);
            }
            //调外部数据---客户卡1.0特征加工
            JSONObject jsonObject = JSON.parseObject(context);
            if (CollectionUtils.isEmpty(jsonObject)) {
                return new CustCard1ResVo();
            }
            CustCard1ResVo mapAntiFraud = CustScoreFeat1.creditFeat(jsonObject);
            LoggerUtil.logBusinessFile("客户卡1.0特征 >>>>>" + mapAntiFraud);
            return mapAntiFraud;
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.logBusinessErrorFile(e, sessionId);
            airmLogInfoMapper.insert(new AirmLogInfo(sessionId, "ArimFxgdServiceImpl.getExternalDataCustCard1", e.getMessage()));
            return null;
        }
    }

    /**
     * 获取客户卡1.0模型响应信息
     *
     * @param modelNoInfo
     * @param fxgdApplyInfo
     * @param operTable
     * @return
     */
    @Override
    public int getAirmAccessCust1Response(ModelNoInfo modelNoInfo, AirmLtgjMasterBody fxgdApplyInfo, OperTable operTable) throws IOException, TradeException {
        String addr = getPbccAddr(fxgdApplyInfo);
        if (Objects.nonNull(fxgdApplyInfo.getAuthorizationInfo())) {
            // 为""默认值处理
            if ("".equals(fxgdApplyInfo.getAuthorizationInfo()) || "".equals(addr)) {
                // 客户卡1.0特征加工
                CustCard1ResVo custCard1ResVo = getExternalDataCustCard1(fxgdApplyInfo.getSessionId(), Constant.DEFAULT_PARAMS, operTable);
                // 调用客户1.0模型
                return getAirmAccessCust1(modelNoInfo, custCard1ResVo, fxgdApplyInfo, operTable);
            }
            //为null查询模型调用表
            if (Objects.isNull(addr)) {
                return defaultHandlerCusctcard1(fxgdApplyInfo, modelNoInfo, operTable);
            }
            // 否则授权信息中带有地址，这重新获取
            // 获取征信报文
            String context = operTable.getContext();
            // 客户卡1.0特征加工
            CustCard1ResVo custCard1ResVo = getExternalDataCustCard1(fxgdApplyInfo.getSessionId(), context, operTable);
            // 调用客户1.0模型
            return getAirmAccessCust1(modelNoInfo, custCard1ResVo, fxgdApplyInfo, operTable);
        }
        return defaultHandlerCusctcard1(fxgdApplyInfo, modelNoInfo, operTable);
    }

    private int defaultHandlerCusctcard1(AirmLtgjMasterBody fxgdApplyInfo, ModelNoInfo modelNoInfo, OperTable operTable) throws IOException, TradeException {
        // 从数据库中数据近期模型的调用记录
        Custcard1ModelInvoke creditResult = getCusctcard1CreditResult(fxgdApplyInfo, modelNoInfo.getCustScore1No(), Constant.THIRTY_DAYS_MILLIS);
        // 判断是否在有效期内，不在需要重新调用模型，参数全部设为默认值
        if (Objects.isNull(creditResult)) {
            CustCard1ResVo custCard1ResVo = getExternalDataCustCard1(fxgdApplyInfo.getSessionId(), Constant.DEFAULT_PARAMS, operTable);
            return getAirmAccessCust1(modelNoInfo, custCard1ResVo, fxgdApplyInfo, operTable);
        }
        return creditResult.getCustScore1();
    }

    public String getIdNo(AirmLtgjMasterBody fxgdApplyInfo) {
        Function<String,CustBasicInfo> jsonParse = (param) -> JSONObject.parseObject(param,CustBasicInfo.class);
        // 获取证件号码
        CustBasicInfo custBasicInfo = jsonParse.apply(fxgdApplyInfo.getCustBasicInfo());
        String idNo = custBasicInfo.getCertNo();
        return idNo;
    }

    /**
     * 从数据库中获取响应的客户卡1.0模型
     *
     * @param fxgdApplyInfo
     * @return
     */
    public Custcard1ModelInvoke getCusctcard1CreditResult(AirmLtgjMasterBody fxgdApplyInfo, String modelNo, long effectiveTime){
        try {
            String idNo = getIdNo(fxgdApplyInfo);
            // 获取最近一次申请的sessionId
            FxgdMasterAduitCredit fxgdMasterAduitCredit = masterAduitCreditMapper.queryMasterAuditCreditByCreNo(idNo);
            if(Objects.isNull(fxgdMasterAduitCredit)){
                return null;
            }
            if((System.currentTimeMillis() - fxgdMasterAduitCredit.getApplyTime()) >  effectiveTime){
                return null;
            }
            // 通过sessionId查询模型调用信息
            Custcard1ModelInvoke custcard1ModelInvoke = custcard1ModelInvokeMapper.selectOne(Wrappers.<Custcard1ModelInvoke>lambdaQuery().eq(Custcard1ModelInvoke::getSessionId, fxgdMasterAduitCredit.getSessionId()));
            return custcard1ModelInvoke;
        } catch (Exception ex){
            ex.printStackTrace();
            LoggerUtil.logBusinessErrorFile(ex, fxgdApplyInfo.getSessionId());
            airmLogInfoMapper.insert(new AirmLogInfo(fxgdApplyInfo.getSessionId(), "ArimFxgdServiceImpl.getCusctcard1CreditResult", ex.getMessage()));
            return null;
        }
    }

    /**
     * 客户卡2.0响应
     *
     * @param modelNoInfo
     * @param fxgdApplyInfo
     * @param operTable
     * @return
     */
    @Override
    public int getAirmAccessCust2Response(ModelNoInfo modelNoInfo, AirmLtgjMasterBody fxgdApplyInfo, OperTable operTable) throws IOException, TradeException {
        String addr = getPbccAddr(fxgdApplyInfo);
        if (Objects.nonNull(fxgdApplyInfo.getAuthorizationInfo())) {
            // 为""默认值处理
            if ("".equals(fxgdApplyInfo.getAuthorizationInfo()) || "".equals(addr)) {
                // 客户卡2.0特征加工
                CustCard2ResVo custCard2ResVo = getExternalDataCustCard2(fxgdApplyInfo.getSessionId(), Constant.DEFAULT_PARAMS, operTable);
                // 调用客户2.0模型
                return getAirmAccessCust2(modelNoInfo, custCard2ResVo, fxgdApplyInfo, operTable);
            }
            //为null查询模型调用表
            if (Objects.isNull(addr)) {
                return defaultHandlerCusctcard2(fxgdApplyInfo, modelNoInfo, operTable);
            }
            // 否则授权信息中带有地址，这重新获取
            // 获取征信报文
            String context = operTable.getContext();
            // 客户卡2.0特征加工
            CustCard2ResVo custCard2ResVo = getExternalDataCustCard2(fxgdApplyInfo.getSessionId(), context, operTable);
            // 调用客户2.0模型
            return getAirmAccessCust2(modelNoInfo, custCard2ResVo, fxgdApplyInfo, operTable);
        }
        return defaultHandlerCusctcard2(fxgdApplyInfo, modelNoInfo, operTable);
    }

    /**
     * 客户卡2.0的默认吃力方法，从数据库中获取模型的记录结果
     * @param fxgdApplyInfo
     * @param modelNoInfo
     * @param operTable
     * @return
     * @throws IOException
     * @throws TradeException
     */
    private int defaultHandlerCusctcard2(AirmLtgjMasterBody fxgdApplyInfo, ModelNoInfo modelNoInfo, OperTable operTable) throws IOException, TradeException {
        // 从数据库中数据近期模型的调用记录
        Custcard2ModelInvoke creditResult = getCustcard2CreditResult(fxgdApplyInfo, modelNoInfo.getCustScore2No(), Constant.THIRTY_DAYS_MILLIS);
        // 判断是否在有效期内，不在需要重新调用模型，参数全部设为默认值
        if (Objects.isNull(creditResult)) {
            CustCard2ResVo custCard2ResVo = getExternalDataCustCard2(fxgdApplyInfo.getSessionId(), Constant.DEFAULT_PARAMS, operTable);
            return getAirmAccessCust2(modelNoInfo, custCard2ResVo, fxgdApplyInfo, operTable);
        }
        return creditResult.getCustScore2();
    }

    /**
     * 从数据库中获取响应的客户卡2.0模型
     *
     * @param fxgdApplyInfo
     * @return
     */
    @Override
    public Custcard2ModelInvoke getCustcard2CreditResult(AirmLtgjMasterBody fxgdApplyInfo, String modelNo, long effectiveTime){
        try {
            // 获取证件号码
            String idNo = getIdNo(fxgdApplyInfo);
            // 获取最近一次申请的sessionId
            FxgdMasterAduitCredit fxgdMasterAduitCredit = masterAduitCreditMapper.queryMasterAuditCreditByCreNo(idNo);
            if(Objects.isNull(fxgdMasterAduitCredit)){
                return null;
            }
            if((System.currentTimeMillis() - fxgdMasterAduitCredit.getApplyTime()) >  effectiveTime){
                return null;
            }
            // 通过sessionId查询模型调用信息
            Custcard2ModelInvoke custcard2ModelInvoke = custcard2ModelInvokeMapper.selectOne(Wrappers.<Custcard2ModelInvoke>lambdaQuery().eq(Custcard2ModelInvoke::getSessionId, fxgdMasterAduitCredit.getSessionId()));
            return custcard2ModelInvoke;
        } catch (Exception ex){
            ex.printStackTrace();
            LoggerUtil.logBusinessErrorFile(ex, fxgdApplyInfo.getSessionId());
            airmLogInfoMapper.insert(new AirmLogInfo(fxgdApplyInfo.getSessionId(), "ArimFxgdServiceImpl.getCustcard2CreditResult", ex.getMessage()));
            return null;
        }
    }


    /**
     * 客户卡2.0特征加工
     *
     * @param str
     * @param
     * @return
     * @throws TradeException
     */
    @Override
    public CustCard2ResVo getExternalDataCustCard2(String sessionId, String str, OperTable operTable) throws TradeException {
        try {
            if (Constant.DEFAULT_PARAMS.equals(str)) {
                return new CustCard2ResVo();
            }
            //调外部数据客户卡2.0指标加工指标加工
            JSONObject jsonObject = JSON.parseObject(str);
            if (CollectionUtils.isEmpty(jsonObject)) {
                return new CustCard2ResVo();
            }
            //加工征信2.0报文
            CreditMappingResVo creditMappingResVo = CreditMapping.creditMapping(jsonObject);
            //将征信2.0指标映射到1.0对象中
            JSONObject oneJSonObject = MappingUtil.getOneJSonObject();
            MappingUtil.mappingObjectToMap(creditMappingResVo, oneJSonObject);
            ResponseData<JSONObject> responseData = ResponseData.ok(oneJSonObject);
            CustCard2ResVo custCard2ResVo = CustScoreFeat2.handleSupplementCustomerCardTraits(responseData.getData());
            LoggerUtil.logBusinessFile("客户卡2.0指标 >>>>>" + custCard2ResVo);
            return custCard2ResVo;
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.logBusinessErrorFile(e, sessionId);
            airmLogInfoMapper.insert(new AirmLogInfo(sessionId, "ArimFxgdServiceImpl.getExternalDataCustCard2", e.getMessage()));
            return null;
        }
    }

    /**
     * 调用客户卡1.0
     *
     * @param
     * @param creditApprovalVo
     * @return
     * @throws TradeException
     */
    @Override
    public int getAirmAccessCust1(ModelNoInfo modelNo, CustCard1ResVo custCard1ResVo, AirmLtgjMasterBody creditApprovalVo, OperTable operTable) throws TradeException {
        try {
            if (custCard1ResVo == null) {
                Map score = new HashMap();
                return -1;
            }
            CustScore1Dto custScore1Dto = new CustScore1Dto(custCard1ResVo, creditApprovalVo);
            LoggerUtil.logBusinessFile("调用客户卡1.0请求参数" + custScore1Dto);
            //调用客户卡1.0
            ResponseData<Map> score1 = accessModel.getScore1(custScore1Dto);
            LoggerUtil.logBusinessFile("调用客户卡1.0响应参数 >>>>>" + score1);
            Custcard1ModelInvoke antiFraudModel = new Custcard1ModelInvoke(creditApprovalVo.getCustId(),creditApprovalVo.getSessionId(), Constant.RESP_SUSECC,creditApprovalVo.getAppNo(), custScore1Dto, score1);
            //添加模型调用流水表
            custcard1ModelInvokeMapper.insert(antiFraudModel);
            return Integer.parseInt(score1.getData().getOrDefault("score", "-1").toString());
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.logBusinessErrorFile(e, creditApprovalVo.getSessionId());
            airmLogInfoMapper.insert(new AirmLogInfo(creditApprovalVo.getSessionId(), "ArimFxgdServiceImpl.getAirmAccessCust1", e.getMessage()));
            return -1;
        }
    }

    /**
     *  调用客户卡2.0
     *
     * @param
     * @param creditApprovalVo
     * @return
     * @throws TradeException
     */
    @Override
    public int getAirmAccessCust2(ModelNoInfo modelNo, CustCard2ResVo custCard2ResVo, AirmLtgjMasterBody creditApprovalVo, OperTable operTable) throws TradeException {
        try {
            if (custCard2ResVo == null) {
                return -1;
            }
            //预处理逻辑
            Map map = MapUtil.objectToMap(custCard2ResVo);
            CustScore2Dto custScore2Dto = preprocessing(map, creditApprovalVo);
            LoggerUtil.logBusinessFile("调用客户卡2.0请求参数" + custScore2Dto);
            //调用客户卡2.0
            ResponseData<Integer> score2 = accessModel.getScore2(custScore2Dto);
            LoggerUtil.logBusinessFile("调用客户卡2.0响应参数 >>>>>" + score2);
            Custcard2ModelInvoke antiFraudModel = new Custcard2ModelInvoke(creditApprovalVo.getCustId(), creditApprovalVo.getSessionId(), Constant.RESP_SUSECC, creditApprovalVo.getAppNo(), custScore2Dto, score2);
            //添加模型调用流水表
            custcard2ModelInvokeMapper.insert(antiFraudModel);
            return Integer.parseInt(score2.getData().toString());
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.logBusinessErrorFile(e, creditApprovalVo.getSessionId());
            airmLogInfoMapper.insert(new AirmLogInfo(creditApprovalVo.getSessionId(), "ArimFxgdServiceImpl.getAirmAccessCust2", e.getMessage()));

            return -1;
        }
    }

    // 客户卡2.0预处理逻辑
    public CustScore2Dto preprocessing(Map param, AirmLtgjMasterBody creditApprovalVo) {
        //时间差特征衍生
        if ("-99988".equals(param.get("rh_lncd_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_lncd_op_old_dt_year").toString()) || "-99988".equals(param.get("rh_lncd_op_max_dt_month").toString()) || "-99988".equals(param.get("rh_lncd_op_old_dt_month").toString())) {
            param.put("sub_time_feature_1", "NaN");
        } else {
            param.put("sub_time_feature_1", (new BigDecimal("-99988".equals(param.get("rh_lncd_op_max_dt_year").toString()) ? "0" : param.get("rh_lncd_op_max_dt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_lncd_op_old_dt_year").toString()) ? "0" : param.get("rh_lncd_op_old_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_lncd_op_max_dt_month").toString()) ? "0" : param.get("rh_lncd_op_max_dt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_lncd_op_old_dt_month").toString()) ? "0" : param.get("rh_lncd_op_old_dt_month").toString())))));
        }

        if ("-99988".equals(param.get("rh_lncd_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_lncd_op_min_dt_year").toString()) || "-99988".equals(param.get("rh_lncd_op_max_dt_month").toString()) || "-99988".equals(param.get("rh_lncd_op_min_dt_month").toString())) {
            param.put("sub_time_feature_2", "NaN");
        } else {
            param.put("sub_time_feature_2", (new BigDecimal("-99988".equals(param.get("rh_lncd_op_max_dt_year").toString()) ? "0" : param.get("rh_lncd_op_max_dt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_lncd_op_min_dt_year").toString()) ? "0" : param.get("rh_lncd_op_min_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_lncd_op_max_dt_month").toString()) ? "0" : param.get("rh_lncd_op_max_dt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_lncd_op_min_dt_month").toString()) ? "0" : param.get("rh_lncd_op_min_dt_month").toString())))));
        }

        if ("-99988".equals(param.get("rh_stlncd_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_stlncd_op_min_dt_year").toString()) || "-99988".equals(param.get("rh_stlncd_op_max_dt_month").toString()) || "-99988".equals(param.get("rh_stlncd_op_min_dt_month").toString())) {
            param.put("sub_time_feature_3", "NaN");
        } else {
            param.put("sub_time_feature_3", (new BigDecimal("-99988".equals(param.get("rh_stlncd_op_max_dt_year").toString()) ? "0" : param.get("rh_stlncd_op_max_dt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_stlncd_op_min_dt_year").toString()) ? "0" : param.get("rh_stlncd_op_min_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_stlncd_op_max_dt_month").toString()) ? "0" : param.get("rh_stlncd_op_max_dt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_stlncd_op_min_dt_month").toString()) ? "0" : param.get("rh_stlncd_op_min_dt_month").toString())))));
        }

        if ("-99988".equals(param.get("rh_stlncd_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_stlncd_op_old_dt_year").toString()) || "-99988".equals(param.get("rh_stlncd_op_max_dt_month").toString()) || "-99988".equals(param.get("rh_stlncd_op_old_dt_month").toString())) {
            param.put("sub_time_feature_4", "NaN");
        } else {
            param.put("sub_time_feature_4", (new BigDecimal("-99988".equals(param.get("rh_stlncd_op_max_dt_year").toString()) ? "0" : param.get("rh_stlncd_op_max_dt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_stlncd_op_old_dt_year").toString()) ? "0" : param.get("rh_stlncd_op_old_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_stlncd_op_max_dt_month").toString()) ? "0" : param.get("rh_stlncd_op_max_dt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_stlncd_op_old_dt_month").toString()) ? "0" : param.get("rh_stlncd_op_old_dt_month").toString())))));
        }

        if ("-99988".equals(param.get("rh_crc_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_cr_op_min_dt_year").toString()) || "-99988".equals(param.get("rh_crc_op_max_dt_month").toString()) || "-99988".equals(param.get("rh_cr_op_min_dt_month").toString())) {
            param.put("sub_time_feature_5", "NaN");
        } else {
            param.put("sub_time_feature_5", (new BigDecimal("-99988".equals(param.get("rh_crc_op_max_dt_year").toString()) ? "0" : param.get("rh_crc_op_max_dt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_cr_op_min_dt_year").toString()) ? "0" : param.get("rh_cr_op_min_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_crc_op_max_dt_month").toString()) ? "0" : param.get("rh_crc_op_max_dt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_cr_op_min_dt_month").toString()) ? "0" : param.get("rh_cr_op_min_dt_month").toString())))));
        }

        if ("-99988".equals(param.get("rh_ln_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_ln_op_min_dt_year").toString()) || "-99988".equals(param.get("rh_ln_op_max_dt_month").toString()) || "-99988".equals(param.get("rh_ln_op_min_dt_month").toString())) {
            param.put("sub_time_feature_6", "NaN");
        } else {
            param.put("sub_time_feature_6", (new BigDecimal("-99988".equals(param.get("rh_ln_op_max_dt_year").toString()) ? "0" : param.get("rh_ln_op_max_dt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_ln_op_min_dt_year").toString()) ? "0" : param.get("rh_ln_op_min_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_ln_op_max_dt_month").toString()) ? "0" : param.get("rh_ln_op_max_dt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_ln_op_min_dt_month").toString()) ? "0" : param.get("rh_ln_op_min_dt_month").toString())))));
        }
        if ("-99988".equals(param.get("rh_carln_rct_paydt_year").toString()) || "-99988".equals(param.get("rh_carln_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_carln_rct_paydt_month").toString()) || "-99988".equals(param.get("rh_carln_op_max_dt_month").toString())) {
            param.put("sub_time_feature_7", "NaN");
        } else {
            param.put("sub_time_feature_7", (new BigDecimal("-99988".equals(param.get("rh_carln_rct_paydt_year").toString()) ? "0" : param.get("rh_carln_rct_paydt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_carln_op_max_dt_year").toString()) ? "0" : param.get("rh_carln_op_max_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_carln_rct_paydt_month").toString()) ? "0" : param.get("rh_carln_rct_paydt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_carln_op_max_dt_month").toString()) ? "0" : param.get("rh_carln_op_max_dt_month").toString())))));
        }
        if ("-99988".equals(param.get("rh_hsln_rct_paydt_year").toString()) || "-99988".equals(param.get("rh_hsln_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_hsln_rct_paydt_month").toString()) || "-99988".equals(param.get("rh_hsln_op_max_dt_month").toString())) {
            param.put("sub_time_feature_8", "NaN");
        } else {
            param.put("sub_time_feature_8", (new BigDecimal("-99988".equals(param.get("rh_hsln_rct_paydt_year").toString()) ? "0" : param.get("rh_hsln_rct_paydt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_hsln_op_max_dt_year").toString()) ? "0" : param.get("rh_hsln_op_max_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_hsln_rct_paydt_month").toString()) ? "0" : param.get("rh_hsln_rct_paydt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_hsln_op_max_dt_month").toString()) ? "0" : param.get("rh_hsln_op_max_dt_month").toString())))));
        }
        if ("-99988".equals(param.get("rh_opln_rct_paydt_year").toString()) || "-99988".equals(param.get("rh_oprln_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_opln_rct_paydt_month").toString()) || "-99988".equals(param.get("rh_oprln_op_max_dt_month").toString())) {
            param.put("sub_time_feature_9", "NaN");
        } else {
            param.put("sub_time_feature_9", (new BigDecimal("-99988".equals(param.get("rh_opln_rct_paydt_year").toString()) ? "0" : param.get("rh_opln_rct_paydt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_oprln_op_max_dt_year").toString()) ? "0" : param.get("rh_oprln_op_max_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_opln_rct_paydt_month").toString()) ? "0" : param.get("rh_opln_rct_paydt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_oprln_op_max_dt_month").toString()) ? "0" : param.get("rh_oprln_op_max_dt_month").toString())))));
        }
        if ("-99988".equals(param.get("rh_agln_rct_paydt_year").toString()) || "-99988".equals(param.get("rh_agln_op_max_dt_year").toString()) || "-99988".equals(param.get("rh_agln_rct_paydt_month").toString()) || "-99988".equals(param.get("rh_agln_op_max_dt_month").toString())) {
            param.put("sub_time_feature_10", "NaN");
        } else {
            param.put("sub_time_feature_10", (new BigDecimal("-99988".equals(param.get("rh_agln_rct_paydt_year").toString()) ? "0" : param.get("rh_agln_rct_paydt_year").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_agln_op_max_dt_year").toString()) ? "0" : param.get("rh_agln_op_max_dt_year").toString())).multiply(new BigDecimal(12)).add(new BigDecimal("-99988".equals(param.get("rh_agln_rct_paydt_month").toString()) ? "0" : param.get("rh_agln_rct_paydt_month").toString()).subtract(new BigDecimal("-99988".equals(param.get("rh_agln_op_max_dt_month").toString()) ? "0" : param.get("rh_agln_op_max_dt_month").toString())))));
        }
        //处理industry变量
        switch (param.getOrDefault("industry", "").toString()) {
            case "":
                param.put("industry", BigDecimal.valueOf(0));
                break;
            case "-99988":
                param.put("industry", BigDecimal.valueOf(0));
                break;
            case "NaN":
                param.put("industry", BigDecimal.valueOf(0));
                break;
            case "A":
                param.put("industry", BigDecimal.valueOf(1));
                break;
            case "B":
                param.put("industry", BigDecimal.valueOf(2));
                break;
            case "C":
                param.put("industry", BigDecimal.valueOf(3));
                break;
            case "D":
                param.put("industry", BigDecimal.valueOf(4));
                break;
            case "E":
                param.put("industry", BigDecimal.valueOf(5));
                break;
            case "F":
                param.put("industry", BigDecimal.valueOf(6));
                break;
            case "G":
                param.put("industry", BigDecimal.valueOf(7));
                break;
            case "H":
                param.put("industry", BigDecimal.valueOf(8));
                break;
            case "I":
                param.put("industry", BigDecimal.valueOf(9));
                break;
            case "J":
                param.put("industry", BigDecimal.valueOf(10));
                break;
            case "K":
                param.put("industry", BigDecimal.valueOf(11));
                break;
            case "L":
                param.put("industry", BigDecimal.valueOf(12));
                break;
            case "M":
                param.put("industry", BigDecimal.valueOf(13));
                break;
            case "N":
                param.put("industry", BigDecimal.valueOf(14));
                break;
            case "O":
                param.put("industry", BigDecimal.valueOf(15));
                break;
            case "P":
                param.put("industry", BigDecimal.valueOf(16));
                break;
            case "Q":
                param.put("industry", BigDecimal.valueOf(17));
                break;
            case "R":
                param.put("industry", BigDecimal.valueOf(18));
                break;
            case "S":
                param.put("industry", BigDecimal.valueOf(19));
                break;
            case "T":
                param.put("industry", BigDecimal.valueOf(20));
                break;
        }
        //处理异常值并且填充平均值
        Properties max = PropertiesUtil.max;
        Properties min = PropertiesUtil.min;
        Properties mean = PropertiesUtil.mean;
        Set<Object> objects = max.keySet();
        for (Object key : objects) {
            if (param.get(key) == null || "NaN".equals(param.get(key).toString()) || "-99988".equals(param.get(key).toString()) || param.get(key).toString().isEmpty() || "".equals(param.get(key).toString())) {
                param.put(key.toString(), mean.getProperty(key.toString()));
            } else if (param.get(key).toString().compareTo(max.getProperty(key.toString())) >= 0) {
                param.put(key.toString(), max.getProperty(key.toString()));
            } else if (new BigDecimal(param.get(key).toString()).compareTo(new BigDecimal(min.getProperty(key.toString()))) <= 0) {
                param.put(key.toString(), min.getProperty(key.toString()));
            }
        }
        CustScore2Dto custScore2Dto = JSONObject.parseObject(JSONObject.toJSONString(param), CustScore2Dto.class);
        custScore2Dto.setSessionid(creditApprovalVo.getSessionId());
        return custScore2Dto;
    }
}

