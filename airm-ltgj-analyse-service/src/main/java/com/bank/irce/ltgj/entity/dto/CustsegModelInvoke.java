package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.common.DateUtil;
import com.bank.irce.ltgj.common.ResponseData;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Map;
import java.util.Objects;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/21
 */
@Data
@TableName(value = "AIRM_FXGD_MODEL_INVOKE_CUSTSEG")
@KeySequence(value = "MODEL_INVOKE_HISTORY_ID_SEQ")
public class CustsegModelInvoke {
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String appNo;
    private String sessionId;
    private String custId;

    /**
     * 来源：客户卡模型
     */
    private Integer cust_score;
    /**
     * 来源：资质卡模型
     */
    @TableField("PROD_SCORE")
    private Integer prodscore;
    /**
     * 来源：资质卡特征加工
     */
    private Double varifieldincome_val;
    /**
     * 来源：资质卡特征加工
     */
    @TableField("FINAL_CUST_LEVEL")
    private String finalcustlevel;
    /**
     * 来源：资质卡特征加工
     */
    @TableField("APPLY_AMT")
    private Double applyAmt;
    /**
     * 来源：授信接口的百融信用分部分
     */
    private Double scorerevoloan;

    @TableField("REFUSE_CODE")
    private Integer refusecode;
    private String custSeg;

    private String modelResult;
    private String createTime;

    public CustsegModelInvoke() {
    }

    public CustsegModelInvoke(String custId, String sessionId, String modelResult, String appNo, CustomerStrategyDTO customerStrategyDTO, ResponseData<Map> mapResponseData) {
        this.sessionId = sessionId;
        this.modelResult = modelResult;
        this.createTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.appNo = appNo;
        this.custId = custId;
        if (Objects.nonNull(customerStrategyDTO)) {
            BeanUtils.copyProperties(customerStrategyDTO, this);
        }
        if (Objects.nonNull(mapResponseData)) {
            this.refusecode = Integer.parseInt(mapResponseData.getData().get("refusecode").toString());
            this.custSeg = mapResponseData.getData().get("cust_seg").toString();

        }
    }
}
