package com.bank.irce.ltgj.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/7/15
 */
@Data
@TableName("FANQIZHA_BLACKLIST")
public class FanqizhaBlacklist {

    @TableId(value = "IDEN_NUM", type = IdType.INPUT)
    private String idenNum;
    @TableField(value = "IDEN_TYPE_CD")
    private String idenTypeCd;
    @TableField(value = "RECORD_START_DT")
    private String recordStartDt;
    @TableField(value = "RECORD_DELETE_DT")
    private String recordDeleteDt;
    @TableField(value = "SOURCE_TABLE")
    private String sourceTable;

}
