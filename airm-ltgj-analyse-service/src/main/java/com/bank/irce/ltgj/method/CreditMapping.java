package com.bank.irce.ltgj.method;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bank.irce.ltgj.common.LoggerUtil;
import com.bank.irce.ltgj.common.MapUtil;
import com.bank.irce.ltgj.common.SimpleEncapsulationUtil;
import com.bank.irce.ltgj.entity.dto.CreditMappingResVo;
import com.bank.irce.ltgj.entity.dto.ValidateConstant;

import java.math.BigDecimal;
import java.util.*;

public class CreditMapping {

    public static CreditMappingResVo creditMapping(JSONObject params) throws Exception {
        /**
         *  开发人员：张卓林
         *  时间：2020.2.19
         */
        //征信2.0结果加工实体
        CreditMappingResVo creditMappingResVo = new CreditMappingResVo();
        creditMappingResVo.init();
        try {
            CreditMappingResVo po = new CreditMappingResVo();
            po.init();
            JSONObject result = new JSONObject(MapUtil.objectToMap(po));
            //查询原因
            String queryreason = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING,  "Document", "PRH", "PA01", "PA01B", "PA01BD02").toString();
            MapUtil.setValueToJSonObject(result, "queryReason", queryreason, new String[]{"01", "02", "03", "08", "19"}, new String[]{"1", "2", "3", "5", "6", queryreason});
            //信用报告生成时间
            result.put("reportCreateTime", SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING, "Document", "PRH", "PA01", "PA01A", "PA01AR01").toString());
            //出生日期
            result.put("birthday", SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING, "Document", "PIM", "PB01", "PB01A", "PB01AR01").toString());
            //学位
            String edudegree = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING, "Document", "PIM", "PB01", "PB01A", "PB01AD03").toString();
            MapUtil.setValueToJSonObject(result, "eduderee", edudegree, new String[]{"0", "5"}, new String[]{"5", "9", edudegree});
            //学历
            String eduLevel = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING, "Document", "PIM", "PB01", "PB01A", "PB01AD02").toString();
            MapUtil.setValueToJSonObject(result, "eduLevel", eduLevel, new String[]{"10", "20", "30", "40", "60", "91", "90", "99"}, new String[]{"5", "4", "3", "2", "2", "1", "0", "0", ""});
            //性别
            String gender = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING, "Document", "PIM", "PB01", "PB01A", "PB01AD01").toString();
            MapUtil.setValueToJSonObject(result, "gender", gender, new String[]{"0", "1", "2", "9"}, new String[]{"X", "1", "2", "0", "NaN"});
            //婚姻状况
            String maritalState = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING, "Document", "PMM", "PB02", "PB020D01").toString();
            if (!ValidateConstant.VALUE_TYPE_STRING_DEFAULT_VALUE.equals(maritalState)) {
                MapUtil.setValueToJSonObject(result, "maritalState", maritalState, new String[]{"91"}, new String[]{"1", maritalState.substring(0, 1)});
            } else {
                MapUtil.setValueToJSonObject(result, "maritalState", maritalState, new String[]{"NaN"}, new String[]{"NaN"});
            }
            List<Map> pb04s = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST, "Document", "POM", "PB04");
            for (Map pb04 : pb04s) {
                try {
                    ((List) (result.get("employer"))).add(SimpleEncapsulationUtil.iteratorAttrByType(pb04, ValidateConstant.VALUE_TYPE_STRING, "PB040Q01").toString());
                    ((List) (result.get("professionalTime"))).add(SimpleEncapsulationUtil.iteratorAttrByType(pb04, ValidateConstant.VALUE_TYPE_DATE, "PB040R02"));
                    MapUtil.setValueToList((List) (result.get("duty")), SimpleEncapsulationUtil.iteratorAttrByType(pb04, ValidateConstant.VALUE_TYPE_INT, "PB040D05").toString(), new String[]{"1", "2", "3", "4", "9"}, new String[]{"3", "2", "1", "0", "null", ""});
                    MapUtil.setValueToList((List) (result.get("industry")), SimpleEncapsulationUtil.iteratorAttrByType(pb04, ValidateConstant.VALUE_TYPE_STRING, "PB040D03").toString(), new String[]{"F", "G", "H", "I", "9"}, new String[]{"H", "F", "I", "G", "Z", SimpleEncapsulationUtil.iteratorAttrByType(pb04, ValidateConstant.VALUE_TYPE_STRING, "PB040D03").toString()});
                    MapUtil.setValueToList((List) (result.get("occupation")), SimpleEncapsulationUtil.iteratorAttrByType(pb04, ValidateConstant.VALUE_TYPE_STRING_DEFAULT_VALUE, "PB040D04").toString(), new String[]{"0", "1", "3", "4", "5", "6", "X", "Y", "Z"}, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "NULL", ""});
                    ((List) (result.get("startYear"))).add(SimpleEncapsulationUtil.iteratorAttrByType(pb04, ValidateConstant.VALUE_TYPE_DATE, "PB040R01").toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile(e.getMessage());;
                }
            }
            //缴费状态
            List<Map> pf05s = new ArrayList<>();
            Object object = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_STRING, "Document", "PHF", "PF05");
            if (object instanceof Map) {
                pf05s.add((Map) object);
            } else if (object instanceof List) {
                pf05s = (List<Map>) object;
            }
            for (Map pf05 : pf05s) {
                try {
                    Map<String, Object> pf05a = (Map<String, Object>) pf05.get("PF05A");
                    MapUtil.setValueToList((List) (result.get("accfundState")), SimpleEncapsulationUtil.iteratorAttrByType(pf05, ValidateConstant.VALUE_TYPE_INT, "PF05A", "PF05AD01").toString(), new String[]{"1", "2", "3"}, new String[]{"001", "002", "003", ""});
                    ((List) (result.get("compercent"))).add(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pf05, ValidateConstant.VALUE_TYPE_INT, "PF05A", "PF05AQ02").toString()));
                    ((List) (result.get("firstmonth"))).add(SimpleEncapsulationUtil.iteratorAttrByType(pf05, ValidateConstant.VALUE_TYPE_DATE, "PF05A", "PF05AR02").toString());
                    ((List) (result.get("ownpercent"))).add(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pf05, ValidateConstant.VALUE_TYPE_INT, "PF05A", "PF05AQ03").toString()));
                    ((List) (result.get("pay"))).add(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pf05, ValidateConstant.VALUE_TYPE_INT, "PF05A", "PF05AJ01").toString()));
                    ((List) (result.get("tomonth"))).add(SimpleEncapsulationUtil.iteratorAttrByType(pf05, ValidateConstant.VALUE_TYPE_DATE, "PF05A", "PF05AR03").toString());
                    ((List) (result.get("gettime"))).add(SimpleEncapsulationUtil.iteratorAttrByType(pf05, ValidateConstant.VALUE_TYPE_DATE, "PF05A", "PF05AR04").toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile(e.getMessage());;
                }
            }

            List<Map> pb03s = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST, "Document", "PRM", "PB03");
            for (Map pb03 : pb03s) {
                ((List) (result.get("address"))).add(SimpleEncapsulationUtil.iteratorAttrByType(pb03, ValidateConstant.VALUE_TYPE_STRING, "PB030Q01"));
                MapUtil.setValueToList((List) (result.get("residencetype")), SimpleEncapsulationUtil.iteratorAttrByType(pb03, ValidateConstant.VALUE_TYPE_INT, "PB030D01").toString(), new String[]{"11", "12"}, new String[]{"1", "5", SimpleEncapsulationUtil.iteratorAttrByType(pb03, ValidateConstant.VALUE_TYPE_INT, "PB030D01").toString()});
            }
            result.put("score", Integer.valueOf(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PSM", "PC01", "PC010Q01").toString()));
            result.put("scoreLevel", Integer.valueOf(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PSM", "PC01", "PC010Q02").toString()));
            List<Map> pc02AHs = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST, "Document", "PCO", "PC02", "PC02A", "PC02AH");


            List<String> first_mon = new ArrayList<>();
            List<String> first_lopenmon = new ArrayList<>();
            List<String> firsts_lopenmon = new ArrayList<>();
            for (Map pc02AH : pc02AHs) {
                try {

                    String pc02ad01 = pc02AH.getOrDefault("PC02AD01", 0).toString();
                    if (pc02AH.getOrDefault("PC02AD02", 0).toString().equals("1")) {
                        first_mon.add(pc02AH.getOrDefault("PC02AR01", 0).toString());
                    }
                    if (pc02ad01.equals("21")) {
                        first_lopenmon.add(pc02AH.getOrDefault("PC02AR01", 0).toString());
                        //贷记卡账户数
                        result.put("loancardcount", Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pc02AH, ValidateConstant.VALUE_TYPE_INT, "PC02AS03").toString()));
                    }
                    if (pc02ad01.equals("22")) {
                        firsts_lopenmon.add(SimpleEncapsulationUtil.iteratorAttrByType(pc02AH, ValidateConstant.VALUE_TYPE_DATE, "PC02AR01").toString());
                        //准贷记卡账户数
                        result.put("slcount", Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pc02AH, ValidateConstant.VALUE_TYPE_DATE, "PC02AS03").toString()));
                    }
                    if (pc02ad01.equals("19")) {
                        //其他贷款笔数
                        result.put("otherloancount", Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pc02AH, ValidateConstant.VALUE_TYPE_DATE, "PC02AS03").toString()));
                    }
                    if (pc02ad01.equals("12")) {
                        //个人商用房（包括商住两用）贷款笔数
                        result.put("perbusinesshouseloancount", Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pc02AH, ValidateConstant.VALUE_TYPE_DATE, "PC02AS03").toString()));
                    }
                    if (pc02ad01.equals("11")) {
                        //个人住房贷款笔数
                        result.put("perhouseloancount", Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pc02AH, ValidateConstant.VALUE_TYPE_DATE, "PC02AS03").toString()));
                    }
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile(e.getMessage());;
                }
            }
            Collections.sort(first_mon);
            Collections.sort(first_lopenmon);
            Collections.sort(firsts_lopenmon);
            //首笔贷款发放月份
            if (first_mon.size() > 0) {
                result.put("firstloanopenmonth", first_mon.get(0));
            } else {
                result.put("firstloanopenmonth", "");
            }
            //首张贷记卡发卡月份
            if (first_lopenmon.size() > 0) {
                result.put("firstlopenmonth", first_lopenmon.get(0));
            } else {
                result.put("firstlopenmonth", "");
            }
            //首张准贷记卡发卡月份
            if (firsts_lopenmon.size() > 0) {
                result.put("firstslopenmonth", firsts_lopenmon.get(0));
            } else {
                result.put("firstslopenmonth", "");
            }

            List<Map> pc02KHs = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST, "Document", "PCO", "PC02", "PC02K", "PC02KH");
            int pc02KJ01 = 0;
            int pc02KJ02 = 0;

            for (Map pc02KH : pc02KHs) {
                if (pc02KH.getOrDefault("PC02KD02", 0).toString().equals("1")) {
                    if (pc02KH.getOrDefault("PC02KD01", 0).toString().equals("1") || pc02KH.getOrDefault("PC02KD01", 0).toString().equals("2")) {
                        pc02KJ01 = Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pc02KH, ValidateConstant.VALUE_TYPE_INT, "PC02KJ01").toString()) + pc02KJ01;
                        pc02KJ02 = Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(pc02KH, ValidateConstant.VALUE_TYPE_INT, "PC02KJ02").toString()) + pc02KJ02;
                    }
                }
            }
            //担保金额
            result.put("guaransumamount", new BigDecimal(pc02KJ01));
            //担保本金余额
            result.put("guaransumbalance", new BigDecimal(pc02KJ02));
            //最近6个月平均使用额度
            result.put("ul6musedavgamount", new BigDecimal(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PCO", "PC02", "PC02E", "PC02EJ03").toString()) +
                    Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PCO", "PC02", "PC02F", "PC02FJ03").toString()) +
                    Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PCO", "PC02", "PC02G", "PC02GJ03").toString())));
            //笔数/账户数
            result.put("ulaccountcount", Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PCO", "PC02", "PC02E", "PC02ES02").toString()) +
                    Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PCO", "PC02", "PC02F", "PC02FS02").toString()) +
                    Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PCO", "PC02", "PC02G", "PC02GS02").toString()));

            /**
             * 负责内容：1-40
             */


            /**
             *  开发人员：张羽
             *  时间：2020.2.19
             */
       /* Map<String, Object> pda =  (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PDA");
        Map<String, Object> pcr =  (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PCR");
        Map<String, Object> pc02D = (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PCO", "PC02", "PC02D");
        Map<String, Object> pc02E = (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PCO", "PC02", "PC02E");
        Map<String, Object> pc02F = (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PCO", "PC02", "PC02F");
        Map<String, Object> pc02G = (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PCO", "PC02", "PC02G");
        Map<String, Object> pc02H = (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PCO", "PC02", "PC02H");
        Map<String, Object> pc02I = (Map<String, Object>)SimpleEncapsulationUtil.SimpleEncapsulationUtil.iteratorAttrByTypeAndRegex(params,"4", null,"Document", "PCO", "PC02", "PC02I");*/
            String pc02EJ02 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02E", "PC02EJ02").toString();
            String pc02FJ02 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02F", "PC02FJ02").toString();
            String pc02GJ02 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02G", "PC02GJ02").toString();

            String pc02EJ01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02E", "PC02EJ01").toString();
            String pc02FJ01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02F", "PC02FJ01").toString();
            String pc02GJ01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02G", "PC02GJ01").toString();

            String pc02ES01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02E", "PC02ES01").toString();
            String pc02FS01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02F", "PC02FS01").toString();
            String pc02GS01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02G", "PC02GS01").toString();
            //余额
            result.put("ulbalance", new BigDecimal(pc02EJ02).add(new BigDecimal(pc02FJ02)).add(new BigDecimal(pc02GJ02)));
            //授信总额
            result.put("ulcreditlimit", new BigDecimal(pc02EJ01).add(new BigDecimal(pc02FJ01)).add(new BigDecimal(pc02GJ01)));
            //贷款法人机构数
            result.put("ulfinancecorpcount", Integer.parseInt(pc02ES01) + Integer.parseInt(pc02FS01) + Integer.parseInt(pc02GS01));
            String pc02HJ05 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02H", "PC02HJ05").toString();
            String pc02HS02 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02H", "PC02HS02").toString();
            String pc02HJ01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02H", "PC02HJ01").toString();
            String pc02HJ02 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02H", "PC02HJ02").toString();
            String pc02HJ04 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02H", "PC02HJ04").toString();
            //最近6个月平均使用额度（贷记卡）
            result.put("ulc6musedavgamount", new BigDecimal(pc02HJ05));
            //账户数
            result.put("ulcaccountcount", Integer.parseInt(pc02HS02));
            //授信总额
            result.put("ulccreditlimit", new BigDecimal(pc02HJ01));
            //单家行最高授信额度
            result.put("ulcmaxcreperorg", new BigDecimal(pc02HJ02));
            //已用额度
            result.put("ulcusedcre", new BigDecimal(pc02HJ04));

            String pc02IS02 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02I", "PC02IS02").toString();
            String pc02IJ01 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02I", "PC02IJ01").toString();
            String pc02IJ04 = SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PCO", "PC02", "PC02I", "PC02IJ04").toString();
            //准贷记卡账户数
            result.put("uslcaccountcount", Integer.parseInt(pc02IS02));
            //准贷记卡授信总额
            result.put("uslccreditlimit", new BigDecimal(pc02IJ01));
            //透支余额
            result.put("uslcusedcre", new BigDecimal(pc02IJ04));

            //贷款逾期笔数/账户数
            int lscount = 0;
            //贷记卡逾期笔数/账户数
            int lcscount = 0;
            //准贷记卡60天以上透支 笔数/账户数
            int slscount = 0;
            //贷款逾期单月最高逾期总额/单月最高透支总额
            BigDecimal lshighestoverdueamountpermon = new BigDecimal(0);
            //贷记卡逾期单月最高逾期总额/单月最高透支总额
            BigDecimal lcshighestoverdueamountpermon = new BigDecimal(0);
            //准贷记卡60天以上透支单月最高逾期总额/单月最高透支总额
            BigDecimal slshighestoverdueamountpermon = new BigDecimal(0);
            //贷款逾期最长逾期月数/最长透支月数
            int lsmaxduration = 0;
            //贷记卡逾期 最长逾期月数/最长透支月数
            int lcsmaxduration = 0;
            //准贷记卡60天以上透支最长逾期月数/最长透支月数
            int slsmaxduration = 0;
            //贷款逾期月份数
            int lsmonths = 0;
            //贷记卡逾期月份数
            int lcsmonths = 0;
            //准贷记卡60天以上透支月份数
            int slsmonths = 0;
            List<Map> pc02DH = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST,  "Document", "PCO", "PC02", "PC02D", "PC02DH");
            for (Map pc02DHs : pc02DH) {
                String pc02DD01 = SimpleEncapsulationUtil.iteratorAttrByType(pc02DHs, ValidateConstant.VALUE_TYPE_STRING,  "PC02DD01").toString();
                String pc02DS02 = SimpleEncapsulationUtil.iteratorAttrByType(pc02DHs, ValidateConstant.VALUE_TYPE_INT,  "PC02DS02").toString();
                String pc02DJ01 = SimpleEncapsulationUtil.iteratorAttrByType(pc02DHs, ValidateConstant.VALUE_TYPE_INT,  "PC02DJ01").toString();
                String pc02DS04 = SimpleEncapsulationUtil.iteratorAttrByType(pc02DHs, ValidateConstant.VALUE_TYPE_INT,  "PC02DS04").toString();
                String pc02DS03 = SimpleEncapsulationUtil.iteratorAttrByType(pc02DHs, ValidateConstant.VALUE_TYPE_INT,  "PC02DS03").toString();
                if ("1".equals(pc02DD01) || "2".equals(pc02DD01) || "3".equals(pc02DD01)) {
                    lscount += Integer.parseInt(pc02DS02);
                    lshighestoverdueamountpermon = new BigDecimal(pc02DJ01).add(lshighestoverdueamountpermon);
                    lsmaxduration += Integer.parseInt(pc02DS04);
                    lsmonths += Integer.parseInt(pc02DS03);
                } else if ("4".equals(pc02DD01)) {
                    lcscount = Integer.parseInt(pc02DS02);
                    lcshighestoverdueamountpermon = new BigDecimal(pc02DJ01);
                    lcsmaxduration = Integer.parseInt(pc02DS04);
                    lcsmonths = Integer.parseInt(pc02DS03);
                } else if ("5".equals(pc02DD01)) {
                    slscount = Integer.parseInt(pc02DS02);
                    slshighestoverdueamountpermon = new BigDecimal(pc02DJ01);
                    slsmaxduration = Integer.parseInt(pc02DS04);
                    slsmonths = Integer.parseInt(pc02DS03);
                }
            }
            //担保贷款到期日期
            List<String> dnxx_enddateList = new ArrayList<>();
            //担保贷款本金余额
            List<BigDecimal> guaranteebalanceList = new ArrayList<>();
            List<Map> pd03 = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST,  "Document", "PCR", "PD03");
            for (Map pd03s : pd03) {
                String pd03AR02 = SimpleEncapsulationUtil.iteratorAttrByType(pd03s, ValidateConstant.VALUE_TYPE_DATE,   "PD03A", "PD03AR02").toString();
                String pD03AD03 = SimpleEncapsulationUtil.iteratorAttrByType(pd03s, ValidateConstant.VALUE_TYPE_STRING,   "PD03A", "PD03AD03").toString();
                BigDecimal pd03AJ02 = new BigDecimal(SimpleEncapsulationUtil.iteratorAttrByType(pd03s, ValidateConstant.VALUE_TYPE_INT,   "PD03A", "PD03AJ02").toString());
                if ("2".equals(pD03AD03)) {
                    dnxx_enddateList.add(pd03AR02);
                    guaranteebalanceList.add(pd03AJ02);
                }
            }
            //授信额度
            List<String> loancard_credit_amtList = new ArrayList<>();
            List<String> standardLoancard_credit_amtList = new ArrayList<>();
            //币种
            List<String> loancard_xxkmx_currencyList = new ArrayList<>();
            List<String> standardLoancard_xxkmx_currencyList = new ArrayList<>();
            //当前逾期金额
            List<BigDecimal> loancard_xxkmx_curroverdueamountList = new ArrayList<>();
            //发卡机构
            List<String> loancard_xxkmx_financeorgList = new ArrayList<>();
            List<String> standardLoancard_xxkmx_financeorgList = new ArrayList<>();
            //24个月还款状态
            List<String> loancard_xxkmx_latest24state = new ArrayList<>();
            List<String> standardLoancard_xxkmx_latest24state = new ArrayList<>();
            //最近6个月平均使用额度/最近6个月平均透支余额
            List<BigDecimal> latest6monthusedavgamountList = new ArrayList<>();
            List<BigDecimal> latest6_month_used_avg_amountList = new ArrayList<>();
            List<Map> pd01 = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST,  "Document", "PDA", "PD01");
            for (Map pd01s : pd01) {
                Map<String, Object> pd01D = (Map<String, Object>) SimpleEncapsulationUtil.iteratorAttrByType(pd01s, ValidateConstant.VALUE_TYPE_MAP,   "PD01D");
                List<Map> pd01DH = new ArrayList<>();
                if (pd01D != null && pd01D.containsKey("PD01DH")) {
                    if (pd01D.get("PD01DH") instanceof Map) {
                        pd01DH.add((Map) pd01D.get("PD01DH"));
                    } else {
                        pd01DH = MapUtil.returnList(pd01D, "PD01DH");
                    }
                }
                String pd01AD01 = SimpleEncapsulationUtil.iteratorAttrByType(pd01s, ValidateConstant.VALUE_TYPE_STRING,   "PD01A", "PD01AD01").toString();
                if ("R2".equals(pd01AD01) || "R3".equals(pd01AD01)) {
                    String pd01AJ02 = SimpleEncapsulationUtil.iteratorAttrByType(pd01s, ValidateConstant.VALUE_TYPE_INT,   "PD01A", "PD01AJ02").toString();
                    String pd01AD04 = SimpleEncapsulationUtil.iteratorAttrByType(pd01s, ValidateConstant.VALUE_TYPE_STRING,   "PD01A", "PD01AD04").toString();
                    BigDecimal pd01CJ06 = new BigDecimal(SimpleEncapsulationUtil.iteratorAttrByType(pd01s,ValidateConstant.VALUE_TYPE_INT,    "PD01C", "PD01CJ06").toString());
                    String pd01AI02 = SimpleEncapsulationUtil.iteratorAttrByType(pd01s, ValidateConstant.VALUE_TYPE_STRING,   "PD01A", "PD01AI02").toString();
                    BigDecimal pd01CJ12 = new BigDecimal(SimpleEncapsulationUtil.iteratorAttrByType(pd01s, ValidateConstant.VALUE_TYPE_INT,   "PD01C", "PD01CJ12").toString());
                    BigDecimal pd01CJ13 = new BigDecimal(SimpleEncapsulationUtil.iteratorAttrByType(pd01s, ValidateConstant.VALUE_TYPE_INT,   "PD01C", "PD01CJ13").toString());
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Map pd01DHs : pd01DH) {
                        String pd01DD01 = pd01DHs.getOrDefault("PD01DD01", "-").toString();
                        stringBuilder.append(pd01DD01);
                    }
                    if ("R2".equals(pd01AD01)) {
                        loancard_credit_amtList.add(pd01AJ02);
                        loancard_xxkmx_currencyList.add(pd01AD04);
                        loancard_xxkmx_curroverdueamountList.add(pd01CJ06);
                        loancard_xxkmx_financeorgList.add(pd01AI02);
                        loancard_xxkmx_latest24state.add(stringBuilder.toString());
                        latest6monthusedavgamountList.add(pd01CJ12);
                    } else if ("R3".equals(pd01AD01)) {
                        standardLoancard_credit_amtList.add(pd01AJ02);
                        standardLoancard_xxkmx_currencyList.add(pd01AD04);
                        standardLoancard_xxkmx_financeorgList.add(pd01AI02);
                        standardLoancard_xxkmx_latest24state.add(stringBuilder.toString());
                        latest6_month_used_avg_amountList.add(pd01CJ13);
                    }
                    stringBuilder.setLength(0);
                }
            }

            creditMappingResVo = (CreditMappingResVo) MapUtil.mapToObject(result, CreditMappingResVo.class);
            creditMappingResVo.initCreditMappingPoSecond(lscount, lcscount, slscount, lshighestoverdueamountpermon, lcshighestoverdueamountpermon,
                    slshighestoverdueamountpermon, lsmaxduration, lcsmaxduration, slsmaxduration, lsmonths, lcsmonths, slsmonths, dnxx_enddateList,
                    guaranteebalanceList, loancard_credit_amtList, standardLoancard_credit_amtList, loancard_xxkmx_currencyList,
                    standardLoancard_xxkmx_currencyList, loancard_xxkmx_curroverdueamountList,
                    loancard_xxkmx_financeorgList, standardLoancard_xxkmx_financeorgList, loancard_xxkmx_latest24state,
                    standardLoancard_xxkmx_latest24state, latest6monthusedavgamountList, latest6_month_used_avg_amountList);
            /**
             * 负责内容：41-82
             */


            /**
             *  开发人员：潘宇
             *  时间：2020.2.19
             */
            // 初始化集合
            int ii = 1;
            String pD01CJ14 = null;
            String pD01CJ15 = null;
            List due_amt = new ArrayList();
            List credit_amt = new ArrayList();
            List<Map> pd01s = (List<Map>) SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_LIST,  "Document", "PDA", "PD01");
            for (Map pb03 : pb03s) {
                //居住状况中的信息更新日期
                creditMappingResVo.getResidencetime().add(pb03.getOrDefault("PB030R01", "").toString());
            }
            for (Map pd1 : pd01s) {
                try {
                    Map pdsa = MapUtil.returnMap(pd1, "PD01A");
                    Map pdsb = MapUtil.returnMap(pd1, "PD01B");
                    Map pdsc = MapUtil.returnMap(pd1, "PD01C");
                    Map pdsf = MapUtil.returnMap(pd1, "PD01F");
                    //最大使用额度/最大透支余额
                    pD01CJ14 = pdsc.getOrDefault("PD01CJ14", "0").toString();
                    pD01CJ15 = pdsc.getOrDefault("PD01CJ15", "0").toString();
                    String pd01AD01 = pdsa.getOrDefault("PD01AD01", "").toString();
                    if ("D1".equals(pd01AD01) || "R1".equals(pd01AD01) || "R4".equals(pd01AD01)) {
                        ii++;
                        //账户编号
                        //Integer acct_num = Integer.parseInt(pdsa.getOrDefault("PD01AI01", "0").toString());
                        Map pdsds = MapUtil.returnMap(pd1, "PD01D");
                        List<Map> pdsdhs = new ArrayList<>();
                        if (pdsds != null && pdsds.containsKey("PD01DH")) {
                            if (pdsds.get("PD01DH") instanceof Map) {
                                pdsdhs.add((Map) pdsds.get("PD01DH"));
                            } else {
                                pdsdhs = MapUtil.returnList(pdsds, "PD01DH");
                            }
                        }
                        StringBuffer repay_24m = new StringBuffer();
                        for (Map psdh : pdsdhs) {
                            repay_24m.append(psdh.getOrDefault("PD01DD01", "-").toString());
                        }
                        //24个月还款状态
                        creditMappingResVo.getLatest24state().add(repay_24m.toString());
                    }
                    //贷记卡
                    if ("R2".equals(pd01AD01)) {
                        //账户状态
                        creditMappingResVo.getLoancard_state().add(pdsb.getOrDefault("PD01BD01", "NaN").toString());
                        //发卡日期
                        creditMappingResVo.getAwardCreditInfo_opendate().add(pdsa.getOrDefault("PD01AR01", "").toString());
                        //共享额度
                        creditMappingResVo.getLr_sharecreditlimitamount().add(pdsa.getOrDefault("PD01AJ03", "0").toString());
                        //已用额度/透支余额
                        creditMappingResVo.getSr_usedcreditlimitamount().add(pdsb.getOrDefault("PD01BJ01", "0").toString());
                        //最大使用额度/最大透支余额
                        creditMappingResVo.getUsedhighestamount_88().add(pD01CJ14);
                    }
                    //准贷记卡
                    if ("R3".equals(pd01AD01)) {
                        //账户状态
                        creditMappingResVo.getStandardLoancard_state().add(pdsb.getOrDefault("PD01BD01", "NaN").toString());
                        //发卡日期
                        creditMappingResVo.getSl_awardCreditInfo_opendate().add(pdsa.getOrDefault("PD01AR01", "").toString());
                        //逾期180天以上未归还贷款本金
                        creditMappingResVo.getOverdueover180amount().add(pdsc.getOrDefault("PD01CJ11", "0").toString());
                        //共享额度
                        creditMappingResVo.getSr_sharecreditlimitamount().add(pdsa.getOrDefault("PD01AJ03", "0").toString());
                        //已用额度/透支余额
                        creditMappingResVo.getLr_usedcreditlimitamount().add(pdsb.getOrDefault("PD01BJ01", "0").toString());
                        //最大使用额度/最大透支余额
                        creditMappingResVo.getUsedhighestamount_89().add(pD01CJ15);
                    }
                    if ("D1".equals(pd01AD01))
                        drr(credit_amt, due_amt, creditMappingResVo, pdsa, "D1", pdsc, pdsb, pdsf, pdsa);
                    if ("R1".equals(pd01AD01))
                        drr(credit_amt, due_amt, creditMappingResVo, pdsa, "R1", pdsc, pdsb, pdsf, pdsa);
                    if ("R4".equals(pd01AD01))
                        drr(credit_amt, due_amt, creditMappingResVo, pdsa, "R4", pdsc, pdsb, pdsf, pdsa);
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile(e.getMessage());
                }
            }
            //最近1个月本人查询次数
            creditMappingResVo.setLast1m_self_query_cnt(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT, "Document", "PQO", "PC05", "PC05B", "PC05BS05").toString()));
            //最近2年特约商户实名审查查询次数
            creditMappingResVo.setLast2y_merc_realname_query_cnt(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PQO", "PC05", "PC05B", "PC05BS08").toString()));
            //最近2年贷后管理查询次数
            creditMappingResVo.setLast2y_post_loan_mag_query_cnt(Integer.parseInt(SimpleEncapsulationUtil.iteratorAttrByType(params, ValidateConstant.VALUE_TYPE_INT,  "Document", "PQO", "PC05", "PC05B", "PC05BS06").toString()));

            List<Map> ph01s = MapUtil.returnList(params, "Document", "POQ", "PH01");
            for (Map pb01 : ph01s) {
                try {
                    //查询原因
                    String qreason = pb01.getOrDefault("PH010Q03", "NaN").toString();
                    if ("01".equals(qreason)) {
                        creditMappingResVo.getRdqueryreason().add("1");
                    } else if ("02".equals(qreason)) {
                        creditMappingResVo.getRdqueryreason().add("2");
                    } else if ("03".equals(qreason)) {
                        creditMappingResVo.getRdqueryreason().add("3");
                    } else if ("08".equals(qreason)) {
                        creditMappingResVo.getRdqueryreason().add("5");
                    } else if ("19".equals(qreason)) {
                        creditMappingResVo.getRdqueryreason().add("6");
                    } else {
                        creditMappingResVo.getRdqueryreason().add(qreason);
                    }
                    //查询时间
                    creditMappingResVo.getRdquerydate().add(pb01.getOrDefault("PH010R01", "").toString());
                    //查询操作员
                    creditMappingResVo.getRdquerier().add(pb01.getOrDefault("PH010Q02", "NaN").toString());
                } catch (Exception e) {
                    LoggerUtil.logBusinessErrorFile(e.getMessage());
                }
            }
            //合同金额
            if (due_amt != null && due_amt.size() > 0) {
                creditMappingResVo.getCreditlimitamount().addAll(due_amt);
            } else {
                creditMappingResVo.getCreditlimitamount().addAll(credit_amt);
            }

        } catch (Exception e) {
            LoggerUtil.logBusinessErrorFile(e.getMessage());;
        }
        /**
         * 负责内容：83-117
         */
        return creditMappingResVo;
    }
    public static void drr(List credit_amt, List due_amt, CreditMappingResVo creditMappingPo, Map pds, String id, Map pdsc, Map pdsb, Map pdsf, Map pdsa) {
        //担保方式
        creditMappingPo.getGuaranteetype().add(pdsa.get("PD01AD07").toString());
        //还款期数
        creditMappingPo.getPaymentcyc().add(pdsa.getOrDefault("PD01AS01", "NaN").toString());
        //类型
        if (pdsf.get("PD01FH") instanceof List) {
            List pd01FHS = Arrays.asList(((List) pdsf.get("PD01FH")).toArray());
            StringBuffer sb = new StringBuffer();
            for (Object obj : pd01FHS) {
                JSONObject jo = JSON.parseObject(JSON.toJSONString(obj));
                sb.append(jo.getOrDefault("PD01FD01", "") + "-");
            }
            creditMappingPo.getSpecialtrade_type().add(sb.toString());
        } else {
            Map pdfh = MapUtil.returnMap(pdsf, "PD01FH");
            creditMappingPo.getSpecialtrade_type().add(pdfh.getOrDefault("PD01FD01", "NaN").toString());
        }
        //本金余额
        creditMappingPo.getLoanid().add(pdsb.getOrDefault("PD01BJ01", "0").toString());
        //五级分类
        creditMappingPo.getClass5state().add(pdsb.getOrDefault("PD01BD03", "NaN").toString());
        //合同金额
        due_amt.add(pds.getOrDefault("PD01AJ01", "0"));
        credit_amt.add(pds.getOrDefault("PD01AJ02", "0"));
        //币种
        creditMappingPo.getCurrency().add(pds.getOrDefault("PD01AD04", "NaN").toString());
        //当前逾期金额
        creditMappingPo.getCurroverdueamount().add(pdsc.getOrDefault("PD01CJ06", "0").toString());
        //到期日期
        creditMappingPo.getEnddate().add(pds.getOrDefault("PD01AR02", "").toString());
        //贷款机构
        creditMappingPo.getFinanceorg().add(pds.getOrDefault("PD01AI02", "NaN").toString());
        //账户状态
        if ("R4".equals(id)) {
            if (pdsb.getOrDefault("PD01BD01", "").toString().equals("5")) {
                creditMappingPo.getLoaninfo_state().add("51");
            } else {
                creditMappingPo.getLoaninfo_state().add(pdsb.getOrDefault("PD01BD01", "NaN").toString());
            }
        } else {
            creditMappingPo.getLoaninfo_state().add(pdsb.getOrDefault("PD01BD01", "NaN").toString());
        }
        //贷款种类细分
        creditMappingPo.getLoaninfo_type().add(pds.getOrDefault("PD01AD03", "NaN").toString());
        //发放日期
        creditMappingPo.getOpendate().add(pds.getOrDefault("PD01AR01", "").toString());
        //还款频率
        creditMappingPo.getPaymentrating().add(pds.getOrDefault("PD01AD06", "NaN").toString());
        creditMappingPo.getRecentpaydate().add(pdsb.getOrDefault("PD01BR02", "NaN").toString());
        //剩余还款期数
        creditMappingPo.getRemainpaymentcyc().add(pdsc.getOrDefault("PD01CS01", "0").toString());
        //本月应还款
        creditMappingPo.getScheduledpaymentamount().add(pdsc.getOrDefault("PD01CJ04", "0").toString());
    }


}
