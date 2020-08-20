package com.bank.irce.ltgj.entity.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

@ApiModel(value = "百融反欺诈规则入参")
@Data
public class BaiRongAntiFraudRuleDto implements Serializable {
    private String sessionid;
    private Integer	als_d7_cell_bank_allnum;
    private Integer	als_d7_cell_nbank_orgnum;
    private Integer	als_d7_id_bank_orgnum;
    private Integer	als_d7_id_nbank_orgnum;
    private Integer	als_m1_cell_bank_orgnum;
    private Integer	als_m1_cell_nbank_orgnum;
    private Integer	als_m1_id_bank_orgnum;
    private Integer	als_m1_id_nbank_orgnum;
    private double	als_m3_cell_avg_monnum;
    private Integer	als_m3_cell_max_monnum;
    private Integer	als_m3_cell_nbank_allnum;
    private Integer	als_m3_cell_nbank_orgnum;
    private double	als_m3_id_avg_monnum;
    private Integer	als_m3_id_max_monnum;
    private Integer	als_m3_id_nbank_allnum;
    private Integer	als_m3_id_nbank_orgnum;
    private Integer	ir_id_x_cell_cnt;
    private Integer	ir_id_x_mail_cnt;
    private Integer	ir_id_x_name_cnt;
    private double	scoreafrevoloan;
    private Integer	sl_id_nbank_bad_allnum;
    private Integer	sl_id_nbank_lost_allnum;
    private Integer	sl_id_nbank_overdue_allnum;
    private Integer	tl_cell_pdl_orgnum;
    private Integer	tl_id_pdl_orgnum;
    private Integer	tl_m1_cell_nobank_newallnum;
    private Integer	tl_m1_cell_nobank_neworgnum;
    private Integer	tl_m1_cell_nobank_passnum;
    private Integer	tl_m1_id_nobank_newallnum;
    private Integer	tl_m1_id_nobank_neworgnum;
    private Integer	tl_m1_id_nobank_passnum;
    private Integer	tl_m3_cell_nobank_newallnum;
    private Integer tl_m3_cell_nobank_neworgnum;
    private Integer	tl_m3_cell_nobank_passnum;
    private Integer	tl_m3_id_nobank_newallnum;
    private Integer	tl_m3_id_nobank_neworgnum;
    private Integer	tl_m3_id_nobank_passnum;

    public BaiRongAntiFraudRuleDto() {
    }

    public BaiRongAntiFraudRuleDto(String sessionid) {
        this.sessionid = sessionid;
        this.als_d7_cell_bank_allnum = -1;
        this.als_d7_cell_nbank_orgnum = -1;
        this.als_d7_id_bank_orgnum = -1;
        this.als_d7_id_nbank_orgnum = -1;
        this.als_m1_cell_bank_orgnum = -1;
        this.als_m1_cell_nbank_orgnum = -1;
        this.als_m1_id_bank_orgnum = -1;
        this.als_m1_id_nbank_orgnum = -1;
        this.als_m3_cell_avg_monnum = -1;
        this.als_m3_cell_max_monnum = -1;
        this.als_m3_cell_nbank_allnum = -1;
        this.als_m3_cell_nbank_orgnum = -1;
        this.als_m3_id_avg_monnum = -1;
        this.als_m3_id_max_monnum = -1;
        this.als_m3_id_nbank_allnum = -1;
        this.als_m3_id_nbank_orgnum = -1;
        this.ir_id_x_cell_cnt = -1;
        this.ir_id_x_mail_cnt = -1;
        this.ir_id_x_name_cnt = -1;
        this.scoreafrevoloan = -1;
        this.sl_id_nbank_bad_allnum = -1;
        this.sl_id_nbank_lost_allnum = -1;
        this.sl_id_nbank_overdue_allnum = -1;
        this.tl_cell_pdl_orgnum = -1;
        this.tl_id_pdl_orgnum = -1;
        this.tl_m1_cell_nobank_newallnum = -1;
        this.tl_m1_cell_nobank_neworgnum = -1;
        this.tl_m1_cell_nobank_passnum = -1;
        this.tl_m1_id_nobank_newallnum = -1;
        this.tl_m1_id_nobank_neworgnum = -1;
        this.tl_m1_id_nobank_passnum = -1;
        this.tl_m3_cell_nobank_newallnum = -1;
        this.tl_m3_cell_nobank_neworgnum = -1;
        this.tl_m3_cell_nobank_passnum = -1;
        this.tl_m3_id_nobank_newallnum = -1;
        this.tl_m3_id_nobank_neworgnum = -1;
        this.tl_m3_id_nobank_passnum = -1;
    }

    public static void main(String[] args) {
        String a = "4.0";
        System.out.println(Double.parseDouble(a));
    }
    public BaiRongAntiFraudRuleDto(JSONObject map, String sessionId) {
        this.sessionid = sessionId;
        this.als_d7_cell_bank_allnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.d7.cell.bank.allnum")).orElse("-1").toString());
        this.als_d7_cell_nbank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.d7.cell.nbank.orgnum")).orElse("-1").toString());
        this.als_d7_id_bank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.d7.id.bank.orgnum")).orElse("-1").toString());
        this.als_d7_id_nbank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.d7.cell.nbank.orgnum")).orElse("-1").toString());
        this.als_m1_cell_bank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m1.cell.bank.orgnum")).orElse("-1").toString());
        this.als_m1_cell_nbank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m1.cell.nbank.orgnum")).orElse("-1").toString());
        this.als_m1_id_bank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m1.id.bank.orgnum")).orElse("-1").toString());
        this.als_m1_id_nbank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m1.id.nbank.orgnum")).orElse("-1").toString());
        this.als_m3_cell_avg_monnum = Double.parseDouble(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.cell.avg_monnum")).orElse("-1").toString());
        this.als_m3_cell_max_monnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.cell.max_monnum")).orElse("-1").toString());
        this.als_m3_cell_nbank_allnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.cell.nbank.allnum")).orElse("-1").toString());
        this.als_m3_cell_nbank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.cell.nbank.orgnum")).orElse("-1").toString());
        this.als_m3_id_avg_monnum = Double.parseDouble(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.id.avg_monnum")).orElse("-1").toString());
        this.als_m3_id_max_monnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.id.max_monnum")).orElse("-1").toString());
        this.als_m3_id_nbank_allnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.id.nbank.allnum")).orElse("-1").toString());
        this.als_m3_id_nbank_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$ApplyLoanStr.m3.id.nbank.orgnum")).orElse("-1").toString());
        this.ir_id_x_cell_cnt = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$InfoRelation.id_x_cell_cnt")).orElse("-1").toString());
        this.ir_id_x_mail_cnt = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$InfoRelation.id_x_mail_cnt")).orElse("-1").toString());
        this.ir_id_x_name_cnt = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$InfoRelation.id_x_name_cnt")).orElse("-1").toString());
        this.scoreafrevoloan =  Double.parseDouble(Optional.ofNullable(JSONPath.eval(map,"$Score.scoreafrevoloan")).orElse("-1").toString());
        this.sl_id_nbank_bad_allnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$SpecialList_c.id.nbank_bad_allnum")).orElse("-1").toString());
        this.sl_id_nbank_lost_allnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$SpecialList_c.id.nbank_lost_allnum")).orElse("-1").toString());
        this.sl_id_nbank_overdue_allnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$SpecialList_c.id.nbank_overdue_allnum")).orElse("-1").toString());
        this.tl_cell_pdl_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.cell_pdl_orgnum")).orElse("-1").toString());
        this.tl_id_pdl_orgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.id_pdl_orgnum")).orElse("-1").toString());
        this.tl_m1_cell_nobank_newallnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m1.cell.nobank.newallnum")).orElse("-1").toString());
        this.tl_m1_cell_nobank_neworgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m1.cell.nobank.newallnum")).orElse("-1").toString());
        this.tl_m1_cell_nobank_passnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m1.cell.nobank.passnum")).orElse("-1").toString());
        this.tl_m1_id_nobank_newallnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m1.id.nobank.neworgnum")).orElse("-1").toString());
        this.tl_m1_id_nobank_neworgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m1.id.nobank.neworgnum")).orElse("-1").toString());
        this.tl_m1_id_nobank_passnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m1.id.nobank.passnum")).orElse("-1").toString());
        this.tl_m3_cell_nobank_newallnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m3.cell.nobank.neworgnum")).orElse("-1").toString());
        this.tl_m3_cell_nobank_neworgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m3.cell.nobank.neworgnum")).orElse("-1").toString());
        this.tl_m3_cell_nobank_passnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m3.cell.nobank.passnum")).orElse("-1").toString());
        this.tl_m3_id_nobank_newallnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m3.id.nobank.neworgnum")).orElse("-1").toString());
        this.tl_m3_id_nobank_neworgnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m3.id.nobank.neworgnum")).orElse("-1").toString());
        this.tl_m3_id_nobank_passnum = Integer.parseInt(Optional.ofNullable(JSONPath.eval(map,"$TotalLoan.m3.id.nobank.passnum")).orElse("-1").toString());
    }
}
