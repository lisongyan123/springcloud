package com.bank.irce.ltgj.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
*@Description
*@Authorzhuolin
*@Date2020/3/3118:47
*@Version1.0
*/
@ApiModel(value="联网核查信息")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OnlineCheckInfoVo implements Serializable{

}

