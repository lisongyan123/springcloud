package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.common.DateUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/23
 */
@TableName("AIRM_FXGD_LOG_INFO")
@Data
@KeySequence("MODEL_INVOKE_HISTORY_ID_SEQ")
@NoArgsConstructor
public class AirmLogInfo {

    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String sessionId;
    private String methodName;
    private String logMessage;
    private String createTime;
    private String businessName;

    public AirmLogInfo(String sessionId, String methodName, String logMessage){
        this.sessionId = sessionId;
        this.methodName = methodName;
        this.logMessage = logMessage;
        this.createTime = DateUtil.getNowyyyy_MM_dd_HH_mm_ss();
        this.businessName = Constant.BUSINESS_NAME;
    }
}
