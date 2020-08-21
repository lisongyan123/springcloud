package com.bank.irce.ltgj.controller;

import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.common.DateUtil;
import com.bank.irce.ltgj.common.LoggerUtil;
import com.bank.irce.ltgj.common.MapUtil;
import com.bank.irce.ltgj.common.ResponseData;
import com.bank.irce.ltgj.entity.AirmLtgjMasterBody;
import com.bank.irce.ltgj.entity.AirmLtgjModelInvokeHistory;
import com.bank.irce.ltgj.entity.LtdsjInfo;
import com.bank.irce.ltgj.entity.LtzfInfo;
import com.bank.irce.ltgj.entity.dto.*;
import com.bank.irce.ltgj.feign.AirmGsdAccessModel;
import com.bank.irce.ltgj.feign.IrceDataService;
import com.bank.irce.ltgj.mapper.AirmLtgjMasterBodyDao;
import com.bank.irce.ltgj.mapper.AirmLtgjModelInvokeHistoryDao;
import com.bank.irce.ltgj.mapper.LtdsjInfoDao;
import com.bank.irce.ltgj.mapper.LtzfInfoDao;
import com.bank.irce.ltgj.service.ArimFxgdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Api(tags = "联通购机")
@RestController
public class AirmLtgjController {

    @Autowired
    IrceDataService irceDataService;

    @Autowired
    ArimFxgdService arimFxgdService;

    @Resource
    AirmLtgjMasterBodyDao airmLtgjMasterBodyDao;

    @Resource
    AirmLtgjModelInvokeHistoryDao airmLtgjModelInvokeHistoryDao;

    @Resource
    LtzfInfoDao ltzfInfoDao;

    @Autowired
    AirmGsdAccessModel accessModel;

    @Resource
    LtdsjInfoDao ltdsjInfoDao;

    @Resource
    AirmGsdAccessModel airmGsdAccessModel;

    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("联通购机授信业务接口")
    @PostMapping("/user/evaluateCredit")
    public <T> AirmLtgjMasterBody evaluateCredit(@RequestBody AirmLtgjMasterBody airmLtgjMasterBody) throws Exception {
        Double scoreconson = -1.0;
        try{
            //获取百融信用分的scoreconson字段
            String bairongInfo = airmLtgjMasterBody.getBairongScoreInfo();
            //百融模型为-999表示第一次传
            if(bairongInfo != "-999") {
                scoreconson = arimFxgdService.getScoreJson(bairongInfo);
                if(scoreconson < 755) {
                    airmLtgjMasterBody.setCreditCode("1");
                    log.info("授信拒绝");
                    return airmLtgjMasterBody;
                }else if(scoreconson >= 755) {
                    airmLtgjMasterBody.setCreditCode("0");
                    return airmLtgjMasterBody;
                }
            }
        } catch (Exception e){
            LoggerUtil.logBusinessErrorFile(e, airmLtgjMasterBody.getSessionId());
            LoggerUtil.logBusinessFile("产品卡授信响应参数》》》" + airmLtgjMasterBody);
            log.info("系统拒绝");
        }
        String sessionId = airmLtgjMasterBody.getSessionId();
        String addr = null;
        try {
            addr = arimFxgdService.getPbccAddr(airmLtgjMasterBody);
        } catch (Exception e) {
            LoggerUtil.logBusinessErrorFile(e, airmLtgjMasterBody.getSessionId());
            LoggerUtil.logBusinessFile("产品卡授信响应参数》》》" + airmLtgjMasterBody);
            addr = null;
        }
        OperTable operTable = new OperTable();
        if(addr == null) {
            // 获取文件名称
            String fileName = arimFxgdService.getFileName(addr);
            // 调用科技部接口
            ConfirmReadDto confirmReadDto = new ConfirmReadDto(sessionId, fileName, Constant.BAIRONG_CHANNELCODE, Constant.BAIRONG_CHANNELDESC);
        }
        // 客户卡1.0特征加工
        CustCard1ResVo custCard1ResVo = arimFxgdService.getExternalDataCustCard1(airmLtgjMasterBody.getSessionId(), Constant.DEFAULT_PARAMS, operTable);
        //调用客户卡1
        CustScore1Dto custScore1Dto = new CustScore1Dto(custCard1ResVo, airmLtgjMasterBody);
        LoggerUtil.logBusinessFile("调用客户卡1.0请求参数" + custScore1Dto);
        //调用客户卡1.0
        ResponseData<Map> score1 = accessModel.getScore1(custScore1Dto);

        // 客户卡2.0特征加工
        CustCard2ResVo custCard2ResVo = arimFxgdService.getExternalDataCustCard2(airmLtgjMasterBody.getSessionId(), Constant.DEFAULT_PARAMS, operTable);
        //预处理逻辑
        Map map = MapUtil.objectToMap(custCard2ResVo);
        CustScore2Dto custScore2Dto = arimFxgdService.preprocessing(map, airmLtgjMasterBody);
        LoggerUtil.logBusinessFile("调用客户卡2.0请求参数" + custScore2Dto);
        //调用客户卡2.0
        ResponseData<Map> score2 = accessModel.getScore2(custScore2Dto);
        AirmLtgjMasterBody airmLtgjMaster = new AirmLtgjMasterBody();
        try{
            airmLtgjMaster = arimFxgdService.productCard(score1,score2,airmLtgjMasterBody);
            //产品流水落表
            airmLtgjModelInvokeHistoryDao.insert(new AirmLtgjModelInvokeHistory(airmLtgjMasterBody.getSessionId(),
                    DateUtil.getCurTimeStamp(),
                    JSONObject.toJSONString(airmLtgjMasterBody)));
            scoreconson = arimFxgdService.getScoreJson(airmLtgjMaster.getBairongScoreInfo());
        } catch (Exception e) {
            LoggerUtil.logBusinessErrorFile(e, airmLtgjMasterBody.getSessionId());
            LoggerUtil.logBusinessFile("产品卡授信响应参数》》》" + airmLtgjMaster);
            airmLtgjMaster.setBairongScoreInfo("-888");
            airmLtgjMaster.setCreditCode("1");
            log.info("系统拒绝");
        }
        if(scoreconson >= 755) {
            airmLtgjMaster.setCreditCode("0");
        } else {
            airmLtgjMaster.setCreditCode("1");
        }
        String ltzf = airmLtgjMaster.getLtzfInfo();
        String ltdsj = airmLtgjMaster.getLtdsjInfo();
        LtzfInfo ltzfInfo = JSONObject.parseObject(JSONObject.toJSONString(ltzf),LtzfInfo.class);
        LtdsjInfo ltdsjInfo = JSONObject.parseObject(JSONObject.toJSONString(ltdsj),LtdsjInfo.class);
        try{
            Assert.isTrue(ltzfInfoDao.insert(ltzfInfo) == 0,"联通支付落表失败");
            Assert.isTrue(ltdsjInfoDao.insert(ltdsjInfo) == 0,"联通大数据落表失败");
            Assert.isTrue(airmLtgjMasterBodyDao.insert(airmLtgjMaster) == 0,"请求响应落表失败");
        } catch (Exception e) {
            LoggerUtil.logBusinessFile("落表失败"
            );
        }
        return airmLtgjMaster;
    }
}
