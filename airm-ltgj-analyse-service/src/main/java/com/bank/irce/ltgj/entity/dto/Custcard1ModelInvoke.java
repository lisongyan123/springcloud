package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.common.DateUtil;
import com.bank.irce.ltgj.common.ResponseData;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/21
 */
@Data
@TableName(value = "AIRM_FXGD_MODEL_INVOKE_CUST1")
@KeySequence(value = "MODEL_INVOKE_HISTORY_ID_SEQ")
public class Custcard1ModelInvoke {
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String appNo;
    private String sessionId;
    private String custId;

    @TableField("RH_M24_CRC_OVD_MAX_PERD")
    private Integer rh_m24_crc_ovd_max_perd;
    @TableField("RH_CRC_UC_MAX_AGE")
    private Long rh_crc_uc_max_age;
    @TableField("RH_LN_UC_MIN_AGE")
    private Long rh_ln_uc_min_age;
    @TableField("RH_CRC_OVD_AMT")
    private BigDecimal rh_crc_ovd_amt;
    @TableField("RH_CRC_UD_PRO")
    private BigDecimal rh_crc_ud_pro;
    @TableField("RH_M24_CR_OVD_MON")
    private Integer rh_m24_cr_ovd_mon;
    @TableField("RH_M12_CRC_QY_NUM")
    private Integer rh_m12_crc_qy_num;
    @TableField("RH_M12_LN_QY_NUM")
    private Integer rh_m12_ln_qy_num;

    @TableField("SCORE")
    private Integer custScore1;

    private String modelResult;
    private String createTime;

    public Custcard1ModelInvoke() {
    }

    public Custcard1ModelInvoke(String custId,String sessionId, String modelResult, String appNo, CustScore1Dto params, ResponseData<Map> mapResponseData) {
        this.sessionId = sessionId;
        this.modelResult = modelResult;
        this.createTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.appNo = appNo;
        this.custId = custId;
        if(Objects.nonNull(params)){
            BeanUtils.copyProperties(params, this);
        }
        if (Objects.nonNull(mapResponseData)){
            this.custScore1 = Integer.parseInt(mapResponseData.getData().get("score").toString());
        }
    }
}
