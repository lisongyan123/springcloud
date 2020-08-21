package com.bank.irce.ltgj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * LTZF_INFO
 * @author 
 */
@Data
public class LtzfInfo implements Serializable {
    /**
     * 门店编码
     */
    private String storeId;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 门店省编码
     */
    private String storeProvinceCode;

    /**
     * 门店市编码
     */
    private String storeCityCide;

    /**
     * 门店区编码
     */
    private String storeZoneCode;

    /**
     * 门店详细地址
     */
    private String storeAddressDetail;

    /**
     * 营业员姓名
     */
    private String salesName;

    /**
     * 营业员电话号码
     */
    private String salesPhone;

    /**
     * 营业员编号
     */
    private String salesId;

    /**
     * 商品名称
     */
    private String cmdtyName;

    /**
     * 商品价格
     */
    private String cmdtyPrice;

    /**
     * 分期金额
     */
    private String loanAmt;

    /**
     * 分期数
     */
    private String loanTerm;

    /**
     * 商品类别
     */
    private String category;

    /**
     * 设备IMEI码
     */
    private String clientId;

    /**
     * 定位坐标系类型
     */
    private String type;

    /**
     * GPS经度
     */
    private String longitude;

    /**
     * GPS维度
     */
    private String latitude;

    /**
     * 定位精度
     */
    private BigDecimal accuracy;

    /**
     * 品牌
     */
    private String brandName;

    /**
     * 机型
     */
    private String modelName;

    /**
     * 首付款
     */
    private String downPmtAmt;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 身份证有效期(起)
     */
    private String idCardBeginDate;

    /**
     * 身份证有效期(止)
     */
    private String idCardEndDate;

    /**
     * 住址
     */
    private String abodeDetail;

    /**
     * 姓名是否修改
     */
    private String nameFlag;

    /**
     * 身份证号是否修改
     */
    private String idCardNoFlag;

    /**
     * 身份证有效期是否修改
     */
    private String idCardInDateFlag;

    /**
     * 修改后姓名
     */
    private String nameModify;

    /**
     * 修改后身份证号
     */
    private String idCardNoModify;

    /**
     * 修改后身份证有效期(起)
     */
    private String idCardBeginDateModify;

    /**
     * 修改后身份证有效期(止)
     */
    private String idCardEndDateModify;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 银行预留手机号
     */
    private String bankPhone;

    /**
     * 银行卡姓名
     */
    private String bankAccountName;

    /**
     * 居住地址省code
     */
    private String abodeStateCode;

    /**
     * 居住地址市code
     */
    private String abodeCityCode;

    /**
     * 居住地址区县code
     */
    private String abodeZoneCode;

    /**
     * 居住详细地址
     */
    private String abodeDetailAddress;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 月收入
     */
    private String mouthIncome;

    /**
     * 社会身份
     */
    private String socialIdentity;

    /**
     * 是否学生
     */
    private String studentFlag;

    /**
     * 申请人手机号
     */
    private String applyPhoneNo;

    /**
     * 用户申请沃支付使用的手机
     */
    private String applyPhoneOs;

    /**
     * 用户注册沃支付时间
     */
    private String applyWzfTime;

    /**
     * 公司名称
     */
    private String unitName;

    /**
     * 公司固话
     */
    private String empPhone;

    /**
     * 公司地址省code
     */
    private String empProvinceCode;

    /**
     * 公司地址市code
     */
    private String empCityCode;

    /**
     * 公司地址区县code
     */
    private String empZoneCode;

    /**
     * 公司详细地址
     */
    private String empAddr;

    /**
     * 征信流水号
     */
    private String authNumber;

    /**
     * 联通订单号
     */
    private String outOrderId;

    /**
     * 申请单号
     */
    private String appNo;

    /**
     * 总金额
     */
    private String totalAmt;

    /**
     * 沃支付用户号
     */
    private String userNo;

    /**
     * 通知地址
     */
    private String notyfyUrl;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 是否本门店办理
     */
    private String currentStoreFlag;

    /**
     * 销售地点
     */
    private String saleAddress;

    /**
     * 营业执照号
     */
    private String bizLicenceNo;

    /**
     * 营业执照名称
     */
    private String bizLicenceName;

    /**
     * 预留1
     */
    private String reserve1;

    /**
     * 预留2
     */
    private String reserve2;

    /**
     * 预留3
     */
    private String reserve3;

    /**
     * 联系人信息
     */
    private String contactList;

    private static final long serialVersionUID = 1L;
}