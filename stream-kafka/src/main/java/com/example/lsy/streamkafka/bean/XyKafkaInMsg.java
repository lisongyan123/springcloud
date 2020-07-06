package com.example.lsy.streamkafka.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * xy_kafka_in_msg
 * @author 
 */
@Data
public class XyKafkaInMsg implements Serializable {
    private Long id;

    /**
     * 档案号
     */
    private Long fwBh;

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