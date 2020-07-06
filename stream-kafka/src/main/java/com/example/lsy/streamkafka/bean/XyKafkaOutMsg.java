package com.example.lsy.streamkafka.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * xy_kafka_out_msg
 * @author 
 */
@Data
public class XyKafkaOutMsg implements Serializable {
    private Long id;

    /**
     * 档案号
     */
    private Long fwBh;

    /**
     * 处理标记 0 失败 1 成功
     */
    private Byte dealFlag;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtUpdate;

    private static final long serialVersionUID = 1L;
}