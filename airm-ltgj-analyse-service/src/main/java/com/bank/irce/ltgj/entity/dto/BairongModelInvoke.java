package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.common.DateUtil;
import com.bank.irce.ltgj.common.ResponseData;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/21
 */
@Data
@TableName(value = "AIRM_FXGD_MODEL_INVOKE_BAIRONG")
@KeySequence(value = "MODEL_INVOKE_HISTORY_ID_SEQ")
public class BairongModelInvoke {
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String appNo;
    private String sessionId;
    private String custId;

    @TableField("ALS_D7_CELL_BANK_ALLNUM")
    private Integer	als_d7_cell_bank_allnum;
    @TableField("ALS_D7_CELL_NBANK_ORGNUM")
    private Integer	als_d7_cell_nbank_orgnum;
    @TableField("ALS_D7_ID_BANK_ORGNUM")
    private Integer	als_d7_id_bank_orgnum;
    @TableField("ALS_D7_ID_NBANK_ORGNUM")
    private Integer	als_d7_id_nbank_orgnum;
    @TableField("ALS_M1_CELL_BANK_ORGNUM")
    private Integer	als_m1_cell_bank_orgnum;
    @TableField("ALS_M1_CELL_NBANK_ORGNUM")
    private Integer	als_m1_cell_nbank_orgnum;
    @TableField("ALS_M1_ID_BANK_ORGNUM")
    private Integer	als_m1_id_bank_orgnum;
    @TableField("ALS_M1_ID_NBANK_ORGNUM")
    private Integer	als_m1_id_nbank_orgnum;
    @TableField("ALS_M3_CELL_AVG_MONNUM")
    private double	als_m3_cell_avg_monnum;
    @TableField("ALS_M3_CELL_MAX_MONNUM")
    private Integer	als_m3_cell_max_monnum;
    @TableField("ALS_M3_CELL_NBANK_ALLNUM")
    private Integer	als_m3_cell_nbank_allnum;
    @TableField("ALS_M3_CELL_NBANK_ORGNUM")
    private Integer	als_m3_cell_nbank_orgnum;
    @TableField("ALS_M3_ID_AVG_MONNUM")
    private double	als_m3_id_avg_monnum;
    @TableField("ALS_M3_ID_MAX_MONNUM")
    private Integer	als_m3_id_max_monnum;
    @TableField("ALS_M3_ID_NBANK_ALLNUM")
    private Integer	als_m3_id_nbank_allnum;
    @TableField("ALS_M3_ID_NBANK_ORGNUM")
    private Integer	als_m3_id_nbank_orgnum;
    @TableField("IR_ID_X_CELL_CNT")
    private Integer	ir_id_x_cell_cnt;
    @TableField("IR_ID_X_MAIL_CNT")
    private Integer	ir_id_x_mail_cnt;
    @TableField("IR_ID_X_NAME_CNT")
    private Integer	ir_id_x_name_cnt;
    @TableField("SCOREAFREVOLOAN")
    private double	scoreafrevoloan;
    @TableField("SL_ID_NBANK_BAD_ALLNUM")
    private Integer	sl_id_nbank_bad_allnum;
    @TableField("SL_ID_NBANK_LOST_ALLNUM")
    private Integer	sl_id_nbank_lost_allnum;
    @TableField("SL_ID_NBANK_OVERDUE_ALLNUM")
    private Integer	sl_id_nbank_overdue_allnum;
    @TableField("TL_CELL_PDL_ORGNUM")
    private Integer	tl_cell_pdl_orgnum;
    @TableField("TL_ID_PDL_ORGNUM")
    private Integer	tl_id_pdl_orgnum;
    @TableField("TL_M1_CELL_NOBANK_NEWALLNUM")
    private Integer	tl_m1_cell_nobank_newallnum;
    @TableField("TL_M1_CELL_NOBANK_NEWORGNUM")
    private Integer	tl_m1_cell_nobank_neworgnum;
    @TableField("TL_M1_CELL_NOBANK_PASSNUM")
    private Integer	tl_m1_cell_nobank_passnum;
    @TableField("TL_M1_ID_NOBANK_NEWALLNUM")
    private Integer	tl_m1_id_nobank_newallnum;
    @TableField("TL_M1_ID_NOBANK_NEWORGNUM")
    private Integer	tl_m1_id_nobank_neworgnum;
    @TableField("TL_M1_ID_NOBANK_PASSNUM")
    private Integer	tl_m1_id_nobank_passnum;
    @TableField("TL_M3_CELL_NOBANK_NEWALLNUM")
    private Integer	tl_m3_cell_nobank_newallnum;
    @TableField("TL_M3_CELL_NOBANK_NEWORGNUM")
    private Integer tl_m3_cell_nobank_neworgnum;
    @TableField("TL_M3_CELL_NOBANK_PASSNUM")
    private Integer	tl_m3_cell_nobank_passnum;
    @TableField("TL_M3_ID_NOBANK_NEWALLNUM")
    private Integer	tl_m3_id_nobank_newallnum;
    @TableField("TL_M3_ID_NOBANK_NEWORGNUM")
    private Integer	tl_m3_id_nobank_neworgnum;
    @TableField("TL_M3_ID_NOBANK_PASSNUM")
    private Integer	tl_m3_id_nobank_passnum;

    private Integer afrResultBr2;
    private String afrResultBr2Info;

    private String modelResult;
    private String createTime;

    public BairongModelInvoke() {
    }

    public BairongModelInvoke(String custId,String sessionId, String modelResult, String appNo, BaiRongAntiFraudRuleDto params, ResponseData<Map> mapResponseData) {
        this.sessionId = sessionId;
        this.modelResult = modelResult;
        this.createTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.appNo = appNo;
        this.custId = custId;
        if(Objects.nonNull(params)){
            BeanUtils.copyProperties(params, this);
        }
        if (Objects.nonNull(mapResponseData)){
            this.afrResultBr2 = Integer.parseInt(mapResponseData.getData().get("afr_result_br2").toString());
            this.afrResultBr2Info = mapResponseData.getData().get("afr_result_br2_info").toString();
        }
    }

    public BairongModelInvoke(String custId,String sessionId, String modelResult, String appNo, BaiRongAntiFraudRuleDto params, BairongModelInvoke mapResponseData) {
        this.sessionId = sessionId;
        this.modelResult = modelResult;
        this.createTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.appNo = appNo;
        this.custId = custId;
        if(Objects.nonNull(params)){
            BeanUtils.copyProperties(params, this);
        }
        if (Objects.nonNull(mapResponseData)){
            this.afrResultBr2 = mapResponseData.getAfrResultBr2();
            this.afrResultBr2Info = mapResponseData.getAfrResultBr2Info();
        }
    }
}
