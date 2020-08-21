package com.bank.irce.ltgj.service;

import com.bank.irce.ltgj.common.ResponseData;
import com.bank.irce.ltgj.common.TradeException;
import com.bank.irce.ltgj.entity.AirmLtgjMasterBody;
import com.bank.irce.ltgj.entity.dto.*;

import java.io.IOException;
import java.util.Map;

public interface ArimFxgdService {

    /**
     * 获取模型信息对象
     *
     * @return 模型信息对象
     */
    ModelNoInfo getModelNo();

    /**
     * 拉取征信2.0报文重试(调用科技部接口)
     *
     * @param map
     * @return
     * @throws TradeException
     */
    Boolean callIrceDataService(Map map) throws TradeException;

    /**
     * 调外部数据---客户卡1.0特征加工
     *
     * @param sessionId 流水号
     * @param context   JOSN格式的
     * @param operTable 落表集合
     * @return 客户卡1.0入参
     * @throws TradeException
     */
    CustCard1ResVo getExternalDataCustCard1(String sessionId, String context, OperTable operTable) throws TradeException;


    /**
     * 调外部数据---客户卡2.0特征加工
     *
     * @param sessionId 流水号
     * @param str       报文JOSN
     * @param operTable 落表集合
     * @return 客户卡2.0入参
     * @throws TradeException
     */
    CustCard2ResVo getExternalDataCustCard2(String sessionId, String str, OperTable operTable) throws TradeException;

    /**
     * 获取客户卡1.0模型响应信息
     *
     * @param modelNoInfo
     * @param fxgdApplyInfo
     * @param operTable
     * @return
     */
    int getAirmAccessCust1Response(ModelNoInfo modelNoInfo, AirmLtgjMasterBody fxgdApplyInfo, OperTable operTable) throws IOException, TradeException;

    /**
     * 从数据库中获取响应的客户卡1.0模型
     * @param fxgdApplyInfo
     * @param modelNo
     * @param effectiveTime
     * @return
     */
    Custcard1ModelInvoke getCusctcard1CreditResult(AirmLtgjMasterBody fxgdApplyInfo, String modelNo, long effectiveTime);

    /**
     * 获取客户卡2.0模型响应信息
     *
     * @param modelNoInfo
     * @param fxgdApplyInfo
     * @param operTable
     * @return
     */
    int getAirmAccessCust2Response(ModelNoInfo modelNoInfo, AirmLtgjMasterBody fxgdApplyInfo, OperTable operTable) throws IOException, TradeException;

    /**
     * 从数据库中获取响应的客户卡2.0模型
     * @param fxgdApplyInfo
     * @param modelNo
     * @param effectiveTime
     * @return
     */
    Custcard2ModelInvoke getCustcard2CreditResult(AirmLtgjMasterBody fxgdApplyInfo, String modelNo, long effectiveTime);

    /**
     * 调客户卡1.0
     *
     * @param modelNo          模型编号
     * @param custCard1ResVo   客户卡1.0模型入参
     * @param creditApprovalVo 授信接口入参
     * @param operTable        落表集合
     * @return
     * @throws TradeException
     */
    int getAirmAccessCust1(ModelNoInfo modelNo, CustCard1ResVo custCard1ResVo, AirmLtgjMasterBody creditApprovalVo, OperTable operTable) throws TradeException;

    /**
     * 调客户卡2.0
     *
     * @param modelNo          模型编号
     * @param custCard2ResVo   客户卡2.0模型入参
     * @param creditApprovalVo 授信接口入参
     * @param operTable        落表集合
     * @return
     * @throws TradeException
     */
    int getAirmAccessCust2(ModelNoInfo modelNo, CustCard2ResVo custCard2ResVo, AirmLtgjMasterBody creditApprovalVo, OperTable operTable) throws TradeException;

    CustScore2Dto preprocessing(Map param, AirmLtgjMasterBody creditApprovalVo);

    AirmLtgjMasterBody productCard(ResponseData<Map> val1, ResponseData<Map> val2, AirmLtgjMasterBody airmLtgjMasterBody);

    Double getScoreJson(String bairongInfo);

    String getPbccAddr(AirmLtgjMasterBody airmLtgjMasterBody);

    String getFileName(String pbccAddr);
}

