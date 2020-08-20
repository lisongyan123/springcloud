package com.bank.irce.ltgj.entity.dto;

import com.bank.irce.ltgj.entity.AirmLtgjMasterBody;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CustScore1Dto implements Serializable {

    private Integer rh_m24_crc_ovd_max_perd;

    private String sessionid;

    private Long rh_crc_uc_max_age;

    private Long rh_ln_uc_min_age;

    private BigDecimal rh_crc_ovd_amt;

    private BigDecimal rh_crc_ud_pro;

    private Integer rh_m24_cr_ovd_mon;

    private Integer rh_m12_crc_qy_num;



    private Integer rh_m12_ln_qy_num;

    public CustScore1Dto() {
    }

    public CustScore1Dto(CustCard1ResVo custCard1ResVo, AirmLtgjMasterBody airmLtgjMasterBody) {
        this.sessionid = airmLtgjMasterBody.getSessionId();
        this.rh_m24_crc_ovd_max_perd = custCard1ResVo.getRh_m24_crc_ovd_max_perd();
        this.rh_crc_uc_max_age = Long.parseLong(custCard1ResVo.getRh_crc_uc_max_age().toString());
        this.rh_ln_uc_min_age = Long.parseLong(custCard1ResVo.getRh_ln_uc_min_age().toString());
        this.rh_crc_ovd_amt = new BigDecimal(custCard1ResVo.getRh_crc_ovd_amt().toString());
        this.rh_crc_ud_pro = new BigDecimal(custCard1ResVo.getRh_crc_ud_pro().toString());
        this.rh_m24_cr_ovd_mon = Integer.parseInt(custCard1ResVo.getRh_m24_cr_ovd_mon().toString());
        this.rh_m12_crc_qy_num = Integer.parseInt(custCard1ResVo.getRh_m12_crc_qy_num().toString());
        this.rh_m12_ln_qy_num = Integer.parseInt(custCard1ResVo.getRh_m12_ln_qy_num().toString());
    }
}
