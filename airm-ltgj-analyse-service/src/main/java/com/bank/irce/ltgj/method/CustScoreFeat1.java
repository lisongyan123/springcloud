package com.bank.irce.ltgj.method;

import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.common.DateUtil;
import com.bank.irce.ltgj.common.LoggerUtil;
import com.bank.irce.ltgj.common.SimpleEncapsulationUtil;
import com.bank.irce.ltgj.entity.dto.CustCard1ResVo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.bank.irce.ltgj.common.SimpleEncapsulationUtil.iteratorAttrByType;


public class CustScoreFeat1 {
    public static CustCard1ResVo creditFeat(JSONObject jsonObject) throws Exception {
        CustCard1ResVo custCard1ResVo = new CustCard1ResVo();
        //两年的毫秒值
        Long twoYearTime = 720 * 24 * 60 * 60 * 1000L;
        // 一年的毫秒值
        Long yearTime = 360 * 24 * 60 * 60 * 1000L;
        // 半年的毫秒值
        Long halfYearTime = 180 * 24 * 60 * 60 * 1000L;
        // 三个月的毫秒值
        Long threeMonths = 90 * 24 * 60 * 60 * 1000L;
        // 一个月的毫秒值
        Long oneMonths = 30 * 24 * 60 * 60 * 1000L;

        //获取 PA01AR01 报告时间
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = SimpleEncapsulationUtil.iteratorAttr(jsonObject, "", "Document", "PRH", "PA01", "PA01A", "PA01AR01").toString();
        Date date = new Date();
        if (!"".equals(dateString)) {
            date = format.parse(dateString);
        }
        List<Map> ph01s = (List<Map>) iteratorAttrByType(jsonObject, "5",  "Document", "POQ", "PH01");
        Set m12_cr_qyf = new HashSet();
        List<String> m12_cr_qyfList = new ArrayList<>();
        int rh_m12_crc_qy_num = 0;
        int rh_m12_ln_qy_num = 0;
        try {
            for (Map ph01 : ph01s) {
                // 获取 ph010R01 查询日期
                Date ph010R01 = new Date();
                if (!"".equals(ph01.getOrDefault("PH010R01", "").toString())) {
                    ph010R01 = format.parse(ph01.get("PH010R01").toString());
                }

                // 获取 ph010Q03 查询原因
                String ph010Q03 = ph01.getOrDefault("PH010Q03", "").toString();
                // 最近12个月所有产品审批查询数
//            if (("02".equals(ph010Q03) || "03".equals(ph010Q03)) && (date.getTime() - ph010R01.getTime()) <= yearTime){
//                custCard1ResVo.setRh_m12_cr_qy_num(custCard1ResVo.getRh_m12_cr_qy_num()+1);
//                //近12个月所有产品审批查询数
//                m12_cr_qyfList.add(ph01.getOrDefault("PH010Q02", "").toString());
//                //近12个月所有产品审批查询数(机构去重)
//                m12_cr_qyf.add(ph01.getOrDefault("PH010Q02", "").toString());
//            }

                // 最近12个月信用卡审批查询数
                if ("03".equals(ph010Q03) && (date.getTime() - ph010R01.getTime()) <= yearTime) {
                    rh_m12_crc_qy_num++;
                }

                // 最近12个月贷款审批查询数
                if ("02".equals(ph010Q03) && (date.getTime() - ph010R01.getTime()) <= yearTime) {
                    rh_m12_ln_qy_num++;
                }

                // 最近6个月信用卡审批查询数
//            if ("03".equals(ph010Q03) && (date.getTime() - ph010R01.getTime()) <= halfYearTime){
//                custCard1ResVo.setRh_m6_crc_qy_num(custCard1ResVo.getRh_m6_crc_qy_num()+1);
//            }

                // 最近6个月贷款审批查询数
//            if ("02".equals(ph010Q03) && (date.getTime() - ph010R01.getTime()) <= halfYearTime){
//                custCard1ResVo.setRh_m6_ln_qy_num(custCard1ResVo.getRh_m6_ln_qy_num()+1);
//            }

                // 最近6个月所有产品审批查询数
//            if (("02".equals(ph010Q03) || "03".equals(ph010Q03)) && (date.getTime() - ph010R01.getTime()) <= halfYearTime){
//                custCard1ResVo.setRh_m6_cr_qy_num(custCard1ResVo.getRh_m6_cr_qy_num()+1);
//            }
            }
            if (!ph01s.isEmpty()){
                custCard1ResVo.setRh_m12_crc_qy_num(rh_m12_crc_qy_num);
            }
            if (!ph01s.isEmpty()){
                custCard1ResVo.setRh_m12_ln_qy_num(rh_m12_ln_qy_num);
            }
        } catch (Exception e) {
            custCard1ResVo.setRh_m12_crc_qy_num(-999);
            custCard1ResVo.setRh_m12_ln_qy_num(-999);
        }
//        try {
//            //贷款汇总_法人机构数
//            custCard1ResVo.setRh_ln_corg_num(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject,"0", "Document", "PCO", "PC02", "PC02E", "PC02ES01").toString())
//                    + Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject,"0", "Document", "PCO", "PC02", "PC02F", "PC02FS01").toString())
//                    + Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject,"0", "Document", "PCO", "PC02", "PC02G", "PC02GS01").toString()));
//
//        }catch (Exception e){
//            LoggerUtil.logBusinessErrorFile(e.getMessage());;
//        }
//        try {
//            //所有产品 授信总额
//            custCard1ResVo.setRh_cr_lim_amt(new BigDecimal(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02E", "PC02EJ01").toString())
//                    .add(new BigDecimal(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02F", "PC02FJ01").toString()))
//                    .add(new BigDecimal(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02G", "PC02GJ01").toString()))
//                    .add(new BigDecimal(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02H", "PC02HJ01").toString()))
//                    .add(new BigDecimal(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02I", "PC02IJ01").toString())));
//        }catch (Exception e){
//            LoggerUtil.logBusinessErrorFile(e.getMessage());;
//        }
//        try {
//        //贷记卡汇总_最近6个月平均额度使用率
//        custCard1ResVo.setRh_m6_lncd_ud_pro(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject,"0", "Document", "PCO", "PC02", "PC02H", "PC02HJ01").toString())> 0
//                ? new BigDecimal(SimpleEncapsulationUtil.iteratorAttr(jsonObject,"0", "Document", "PCO", "PC02", "PC02H", "PC02HJ05").toString())
//                .divide(new BigDecimal(SimpleEncapsulationUtil.iteratorAttr(jsonObject,"0", "Document", "PCO", "PC02", "PC02H", "PC02HJ01").toString()),2,BigDecimal.ROUND_HALF_UP) : new BigDecimal(0) );
//        }catch (Exception e){
//            LoggerUtil.logBusinessErrorFile(e.getMessage());;
//        }
        try {
            //信用卡汇总_透支余额/信用额度
            custCard1ResVo.setRh_crc_ud_pro((Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02H", "PC02HJ01").toString())
                    + Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02I", "PC02IJ01").toString())) <= 0
                    ? new BigDecimal(-999) : new BigDecimal(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02H", "PC02HJ04").toString()) + Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02I", "PC02IJ04").toString())).divide(
                    new BigDecimal(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02H", "PC02HJ01").toString())
                            + Integer.parseInt(SimpleEncapsulationUtil.iteratorAttr(jsonObject, "0", "Document", "PCO", "PC02", "PC02I", "PC02IJ01").toString())), 2, BigDecimal.ROUND_HALF_UP));
        } catch (Exception e) {
            custCard1ResVo.setRh_crc_ud_pro(new BigDecimal(-999));
        }
        //所有产品开立距今最大时长
        List<Map> pd01s = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(jsonObject, "5", "", "Document", "PDA", "PD01");
        List allList = new ArrayList();
        List creatList = new ArrayList();
        List ln_uc_list = new ArrayList();
        List crc_ovd = new ArrayList();
        Set m12_cr_qyt = new HashSet();
        List<String> m12_cr_qytList = new ArrayList<>();
        String len = "1234567";
        String lenth = "N1234567G";
        int m6_cr_ovd = 0;
        int m24_cr_ovd = 0;
        for (Map pd01 : pd01s) {
            Map PD01A = new HashMap();
            if (pd01.get("PD01A") instanceof Map) {
                PD01A = (Map) pd01.get("PD01A");
            }
            String PD01AD01 = PD01A.getOrDefault("PD01AD01", "").toString();
            Date pd01AR01Date = new Date();
            if (!"".equals(PD01A.getOrDefault("PD01AR01", ""))) {
                try {
                    pd01AR01Date = format.parse(PD01A.get("PD01AR01").toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile(e.getMessage());;
                }
            }
            if ("D1".equals(PD01AD01) ||
                    "R1".equals(PD01AD01) ||
                    "R2".equals(PD01AD01) ||
                    "R3".equals(PD01AD01) ||
                    "R4".equals(PD01AD01)) {
                int i = DateUtil.getMothDiff(date, pd01AR01Date);
                allList.add(i);
                if (DateUtil.getMothDiff(date, pd01AR01Date) <= 12) {
                    //近12个月所有产品查询通过机构数(机构去重)
                    m12_cr_qyt.add(((Map) pd01.get("PD01A")).get("PD01AD01").toString());
                    //近12个月所有产品查询通过机构数
                    m12_cr_qytList.add(((Map) pd01.get("PD01A")).get("PD01AD01").toString());
                }
                Map pd01d = (Map) pd01.getOrDefault("PD01D", new HashMap<>());
                if (pd01d.keySet().size() > 0) {
                    List<Map> pd01dhs = new ArrayList<>();
                    try {
                        pd01dhs = (List<Map>) pd01d.getOrDefault("PD01DH", new ArrayList<Map>());
                    } catch (ClassCastException cce) {
                        pd01dhs.add((Map) pd01d.getOrDefault("PD01DH", new HashMap<>()));
                    }
//                    for (int k = 0; k < pd01dhs.size(); k++) {
//                        if (k==6) break;
//                        if (len.contains(pd01dhs.get(k).getOrDefault("PD01DD01", "").toString())) {
//                            m6_cr_ovd++;
//                        }
//                    }
                    for (Map pd01dh : pd01dhs) {
                        if (len.contains(pd01dh.getOrDefault("PD01DD01", "").toString())) {
                            m24_cr_ovd++;
                        }
                    }
                    if (!pd01d.isEmpty()){
                        custCard1ResVo.setRh_m24_cr_ovd_mon(m24_cr_ovd);
                    }
                }
            }
            //信用卡开立距今最大时长
            if ("R2".equals(PD01AD01) || "R3".equals(PD01AD01)) {
                try {
                    int j = DateUtil.getMothDiff(date, pd01AR01Date);
                    creatList.add(j);
                    Map pd01C = (Map) pd01.getOrDefault("PD01C", new HashMap<>());
                    //信用卡当前逾期金额
                    if (pd01C.keySet().size() > 0) {
                        custCard1ResVo.setRh_crc_ovd_amt(Integer.parseInt(pd01C.getOrDefault("PD01CJ06", 0).toString()));
                    }
                } catch (Exception e) {
                    custCard1ResVo.setRh_crc_ovd_amt(-999);
                }
                //过去24个月信用卡最大逾期期数
                Map pd01d = (Map) pd01.getOrDefault("PD01D", new HashMap<>());
                if (pd01d.size() > 0) {
                    List<Map> pd01DHs = new ArrayList<>();
                    try {
                        pd01DHs = (List<Map>) pd01d.getOrDefault("PD01DH", "");
                    } catch (ClassCastException cce) {
                        pd01DHs.add((Map) pd01d.getOrDefault("PD01DH", new HashMap<>()));
                    }
                    for (Map pd01DH : pd01DHs) {
                        String pd01DD01 = pd01DH.getOrDefault("PD01DD01", "").toString();
                        if (lenth.contains(pd01DD01)){
                            if ("N".equals(pd01DD01)){
                                crc_ovd.add("0");
                            }else if ("G".equals(pd01DD01)){
                                crc_ovd.add("8");
                            }else {
                                crc_ovd.add(pd01DD01);}}
                    }
                }
            }
            try {
                //贷款开立距今最小时长
                if ("D1".equals(PD01AD01) || "R1".equals(PD01AD01) || "R4".equals(PD01AD01)) {
                    int k = DateUtil.getMothDiff(date, pd01AR01Date);
                    ln_uc_list.add(k);
                    //是否有房贷
//                    if ("11".equals(PD01A.getOrDefault("PD01AD03", "")) || "12".equals(PD01A.getOrDefault("PD01AD03", "")) || "13".equals(PD01A.getOrDefault("PD01AD03", ""))) {
//                        custCard1ResVo.setRh_if_houseln(1);
//                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Collections.sort(allList);
        Collections.sort(creatList);
        Collections.sort(ln_uc_list);
        try {
            if (crc_ovd.size() > 0) {
                custCard1ResVo.setRh_m24_crc_ovd_max_perd(Integer.parseInt(Collections.max(crc_ovd).toString()));
            }
        } catch (Exception e) {
            custCard1ResVo.setRh_m24_crc_ovd_max_perd(-999);
        }
//        if (allList.size() > 1) {
//            custCard1ResVo.setRh_cr_uc_max_age(Integer.parseInt(allList.get(allList.size()-1).toString()));
//        }
        try {
            if (creatList.size() > 1) {
                custCard1ResVo.setRh_crc_uc_max_age(Integer.parseInt(creatList.get(creatList.size() - 1).toString()));
            }
        } catch (Exception e) {
            custCard1ResVo.setRh_crc_uc_max_age(-999);
        }
        try {
            if (ln_uc_list.size() > 0) {
                custCard1ResVo.setRh_ln_uc_min_age(Integer.parseInt(ln_uc_list.get(0).toString()));
            }
        } catch (Exception e) {
            custCard1ResVo.setRh_ln_uc_min_age(-999);
        }
        //custCard1ResVo.setRh_m6_cr_ovd_mon(m6_cr_ovd);

//        if (m12_cr_qyf.size()==0 && m12_cr_qyt.size()==0){
//            custCard1ResVo.setRh_m12_cr_qyf_num(-99998);
//            custCard1ResVo.setRh_m12_cr_qyf_org_num(-99998);
//        }else if (m12_cr_qyf.size()==0 && m12_cr_qyt.size()>0){
//            custCard1ResVo.setRh_m12_cr_qyf_num(-99999);
//            custCard1ResVo.setRh_m12_cr_qyf_org_num(-99999);
//        }else if (m12_cr_qyf.size()>0 && m12_cr_qyt.size()==0){
//            custCard1ResVo.setRh_m12_cr_qyf_num(99999);
//            custCard1ResVo.setRh_m12_cr_qyf_org_num(99999);
//        }else {
//            custCard1ResVo.setRh_m12_cr_qyf_num(m12_cr_qyfList.size()-m12_cr_qytList.size());
//            custCard1ResVo.setRh_m12_cr_qyf_org_num(m12_cr_qyf.size()-m12_cr_qyt.size());
//        }
        //添加征信客户卡模型指标
        //CreditCustomerCard creditCustomerCard = new CreditCustomerCard(custCard1ResVo,args);
        //creditCustomerCardMapper.insertCreditCustomerCard(creditCustomerCard);
        return custCard1ResVo;
    }
}
