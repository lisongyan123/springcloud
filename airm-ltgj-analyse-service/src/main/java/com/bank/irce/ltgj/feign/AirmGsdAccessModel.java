package com.bank.irce.ltgj.feign;

import com.bank.irce.ltgj.common.ResponseData;
import com.bank.irce.ltgj.entity.dto.*;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Api(tags = "模型调用接口")
@Component
@FeignClient(name = "airm-fxgd-appr-model10-1-10-15")
public interface AirmGsdAccessModel {

    //授信反欺诈模型
    @PostMapping(value = "/antifraud/zhengxinRule")
    ResponseData<Map> queryAntiFraudCredit(@RequestBody CreditAntiFraudDto params);
    //客户卡1.0
    @PostMapping(value = "/cust/getCustScore1")
    ResponseData<Map> getScore1(@RequestBody CustScore1Dto params);
    //客户卡2.0
    @PostMapping(value = "/cust/getCustScore2")
    ResponseData getScore2(@RequestBody CustScore2Dto params);
    //反欺诈模型(百融)
    @PostMapping(value = "/antifraud/bairongRule2")
    ResponseData<Map> queryAntiFraudBRRule(@RequestBody BaiRongAntiFraudRuleDto params);
    //反欺诈模型(天御)
    @PostMapping(value = "/antifraud/tianyuRule")
    ResponseData<Map> queryAntiFraudTYRule(@RequestBody TianYuAntiFraudRuleDto params);
    /**
     * 百度反欺诈模型
     * @param baiduModelDTO
     * @return
     */
    @PostMapping(value = "/antifraud/baiduRule")
    ResponseData<Map> queryBaiduRRule(@RequestBody BaiduModelDTO baiduModelDTO);
    /**
     *资质卡模型
     * @param qualificationsCardModelDTO
     * @return
     */
    @PostMapping(value = "/strategy/prodScore")
    ResponseData<Map> queryQualificationsCardResult(@RequestBody QualificationsCardModelDTO qualificationsCardModelDTO);
    /**
     * 客户分群策略模型
     * @return
     */
    @PostMapping(value = "/strategy/custSeg")
    ResponseData<Map> queryCustomerStrategyResult(@RequestBody CustomerStrategyDTO customerStrategyDTO);

}
