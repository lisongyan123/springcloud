package com.bank.irce.ltgj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.entity.AirmLtgjMasterBody;
import com.bank.irce.ltgj.entity.dto.*;
import com.bank.irce.ltgj.feign.IrceDataService;
import com.bank.irce.ltgj.service.ArimFxgdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "联通购机")
@RestController
public class AirmLtgjController {

    @Autowired
    IrceDataService irceDataService;

    @Autowired
    private ArimFxgdService arimFxgdService;

    @ApiOperation("联通购机授信业务接口")
    @PostMapping("/user/evaluateCredit")
    public AirmLtgjMasterBody evaluateCredit(@RequestBody AirmLtgjMasterBody airmLtgjMasterBody) throws Exception {
        Double scoreconson = 0.0;
        JSONObject scoreJson = new JSONObject();
        try{
            scoreconson = getScoreJson(airmLtgjMasterBody);
        }catch (Exception e){
            scoreconson = 0.0;
        }
        if(scoreconson >= 755) {
            airmLtgjMasterBody.setCreditCode("0");
            return airmLtgjMasterBody;
        }
        String baironginfo = airmLtgjMasterBody.getBairongScoreInfo();
        String sessionId = airmLtgjMasterBody.getSessionId();
        // 获取文件名称
        String fileName = getFileName(JSON.parseObject(baironginfo).get("FILE_NAME").toString());
        // 调用科技部接口
        ConfirmReadDto confirmReadDto = new ConfirmReadDto(sessionId, fileName, Constant.BAIRONG_CHANNELCODE, Constant.BAIRONG_CHANNELDESC);

        ModelNoInfo modelNoInfo = arimFxgdService.getModelNo();
        // 落表变量声明
        OperTable operTable = new OperTable();
        // 获取客户卡的分数
        int cust1Score = arimFxgdService.getAirmAccessCust1Response(modelNoInfo, airmLtgjMasterBody, operTable);
        int cust2Score = 0;
        try {
            //客户卡2中抛出移仓不应该影响流程执行
            cust2Score = arimFxgdService.getAirmAccessCust2Response(modelNoInfo, airmLtgjMasterBody, operTable);
        } catch (Exception e) {}
        AirmLtgjMasterBody airmLtgjMaster = new AirmLtgjMasterBody();
        try{
            airmLtgjMaster = arimFxgdService.productCard(cust1Score,cust2Score,airmLtgjMasterBody);
        } catch (Exception e) {
            airmLtgjMaster.setBairongScoreInfo("-888");
        }
        try {
            scoreconson = getScoreJson(airmLtgjMaster);
        } catch (Exception e) {
            throw new Exception("取不到这scoreconson字段");
        }
        if(scoreconson >= 755) {
            airmLtgjMaster.setCreditCode("0");
        } else {
            airmLtgjMaster.setCreditCode("1");
        }
        return airmLtgjMaster;
    }

    public Double getScoreJson(AirmLtgjMasterBody airmLtgjMasterBody) {
        String bairongInfo = airmLtgjMasterBody.getBairongScoreInfo();
        BairongInfo bairong = JSONObject.parseObject(bairongInfo,BairongInfo.class);
        JSONObject returnBody = (JSONObject) JSONObject.toJSON(bairong.getReturnBody());
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
}
