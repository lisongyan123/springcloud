package com.bank.irce.ltgj.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/21
 */
@Data
@TableName(value = "AIRM_FXGD_VEHICLE_LIST")
@KeySequence(value = "MODEL_INVOKE_HISTORY_ID_SEQ")
public class VehicleList {

    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    private String appNo;
    private String sessionId;

    private BigDecimal purchasePrice;
    private String registerDate;
    private Integer vehicleAge;
    private String licensePlateNo;

}
