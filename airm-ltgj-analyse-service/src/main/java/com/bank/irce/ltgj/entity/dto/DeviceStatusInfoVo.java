
package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author zhuolin
 * @Date 2020/3/31 18:47
 * @Version 1.0
 */
@ApiModel(value = "设备状态信息")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceStatusInfoVo implements Serializable {

}
