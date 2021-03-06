CREATE TABLE "AIRM_FXGD_MODEL_INVOKE_CUST2" (
    "ID" NUMBER(20) PRIMARY KEY,
    "APP_NO" VARCHAR2(100),
	"CUST_ID" VARCHAR2(60),
    "SESSION_ID" VARCHAR2(100),
    "QUERYREASON" NUMBER(20,10),
    "GENDER" NUMBER(20,10),
    "MARITALSTATE" NUMBER(20,10),
    "EDULEVEL" NUMBER(20,10),
    "EDUDEGREE" NUMBER(20,10),
    "RESIDENCETYPE" NUMBER(20,10),
    "OCCUPATION" NUMBER(20,10),
    "INDUSTRY" NUMBER(20,10),
    "DUTY" NUMBER(20,10),
    "ACCFUND_STATE" NUMBER(20,10),
    "ACCFUND_PAY" NUMBER(20,10),
    "OWNPRENT" NUMBER(20,10),
    "COMPRENT" NUMBER(20,10),
    "APPLY_AGE" NUMBER(20,10),
    "RESIDENCE_PROVINCE_NUM" NUMBER(20,10),
    "RESIDENCE_TYPE_NUM" NUMBER(20,10),
    "INDUSTRY_NUM" NUMBER(20,10),
    "RH_BS_ACCF_CUR_MON" NUMBER(20,10),
    "RH_BS_ACCF_HIS_MON" NUMBER(20,10),
    "RH_BS_ACCF_BASE" NUMBER(20,10),
    "RH_BS_INDUSTRY_MAT" NUMBER(20,10),
    "RH_BS_WORK_LAST_STA" NUMBER(20,10),
    "RH_LNCD_NUM" NUMBER(20,10),
    "RH_LNCD_UC_NUM" NUMBER(20,10),
    "RH_LNCD_NR_NUM" NUMBER(20,10),
    "RH_LNCD_NOPEN_NUM" NUMBER(20,10),
    "RH_LNCD_CANCEL_NUM" NUMBER(20,10),
    "RH_LNCD_OC_NUM" NUMBER(20,10),
    "RH_LNCD_SUM_CR_LMT" NUMBER(20,10),
    "RH_LNCD_AVG_CR_LMT" NUMBER(20,10),
    "RH_LNCD_MN_CR_LMT" NUMBER(20,10),
    "RH_LNCD_UC_LMT_MAX" NUMBER(20,10),
    "RH_LNCD_UC_LMT_MIN" NUMBER(20,10),
    "RH_LNCD_SUM_SD_LMT" NUMBER(20,10),
    "RH_LNCD_AVG_SD_LMT" NUMBER(20,10),
    "RH_LNCD_MN_SD_LMT" NUMBER(20,10),
    "RH_LNCD_MAX_SD_LMT" NUMBER(20,10),
    "RH_LNCD_MIN_SD_LMT" NUMBER(20,10),
    "RH_LNCD_SUM_NR_CR_LMT" NUMBER(20,10),
    "RH_LNCD_NR_AVG_CR_LMT" NUMBER(20,10),
    "RH_LNCD_NR_MN_CR_LMT" NUMBER(20,10),
    "RH_LNCD_MAX_NR_CR_LMT" NUMBER(20,10),
    "RH_LNCD_NR_MIN_CR_LMT" NUMBER(20,10),
    "RH_LNCD_SUM_NR_SD_LMT" NUMBER(20,10),
    "RH_LNCD_NR_AVG_SD_LMT" NUMBER(20,10),
    "RH_LNCD_NR_MN_SD_LMT" NUMBER(20,10),
    "RH_LNCD_MAX_NR_SD_LMT" NUMBER(20,10),
    "RH_LNCD_NR_MIN_SD_LMT" NUMBER(20,10),
    "RH_LNCD_SUM_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_MN_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_MAX_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_MIN_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_SUM_NR_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_NR_AVG_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_NR_MN_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_MAX_NR_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_NR_MIN_UD_CR_LMT" NUMBER(20,10),
    "RH_LNCD_UC_MAX_AMT_PRO" NUMBER(20,10),
    "RH_LNCD_AVG_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_LNCD_MN_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_LNCD_SUM_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_LNCD_MAX_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_MIN_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_AVG_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_MN_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_SUM_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_MAX_NR_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_LNCD_NR_AVG_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_LNCD_NR_MN_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_LNCD_SUM_NR_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_LNCD_MAX_NR_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_NR_MIN_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_NR_AVG_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_NR_MN_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_SUM_NR_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_LNCD_AVG_M6AVG_UD_AMT" NUMBER(20,10),
    "RH_LNCD_MAX_M6AVG_UD_AMT" NUMBER(20,10),
    "RH_LNCD_AVG_MAX_UD_AMT" NUMBER(20,10),
    "RH_LNCD_MAX_MAX_UD_AMT" NUMBER(20,10),
    "RH_LNCD_SUM_MAX_UD_AMT" NUMBER(20,10),
    "RH_LNCD_AVG_CURDEF_AMT" NUMBER(20,10),
    "RH_LNCD_MAX_CURDEF_AMT" NUMBER(20,10),
    "RH_LNCD_OVD_CT_2Y_RP" NUMBER(20,10),
    "RH_LNCD_OVD_CT_3Y_RP" NUMBER(20,10),
    "RH_M24_LNCD_OVD_MAX_PERD" NUMBER(20,10),
    "RH_LNCD_MAX_SD_LMT_M6" NUMBER(20,10),
    "RH_LNCD_SUM_NR_CR_LMT_M6" NUMBER(20,10),
    "RH_LNCD_NR_AVG_CR_LMT_M6" NUMBER(20,10),
    "RH_LNCD_NR_MN_CR_LMT_M6" NUMBER(20,10),
    "RH_LNCD_MN_CR_LMT_M12" NUMBER(20,10),
    "RH_LNCD_NR_MN_CR_LMT_M12" NUMBER(20,10),
    "RH_LNCD_LIM_ORG_DS_NUM" NUMBER(20,10),
    "RH_LNCD_OD180AMT_SUM_AMT" NUMBER(20,10),
    "RH_LNCD_MID_OVD_NUM" NUMBER(20,10),
    "RH_LNCD_PER_NUM" NUMBER(20,10),
    "RH_LNCD_OLD_AGE" NUMBER(20,10),
    "RH_LNCD_DETAIL_MAX_AGE" NUMBER(20,10),
    "RH_STLNCD_NR_NUM" NUMBER(20,10),
    "RH_STLNCD_NOPEN_NUM" NUMBER(20,10),
    "RH_STLNCD_CANCEL_NUM" NUMBER(20,10),
    "RH_STLNCD_OC_NUM" NUMBER(20,10),
    "RH_STLNCD_AVG_CR_LMT" NUMBER(20,10),
    "RH_STLNCD_MN_CR_LMT" NUMBER(20,10),
    "RH_STLNCD_MN_SD_LMT" NUMBER(20,10),
    "RH_STLNCD_NR_MN_CR_LMT" NUMBER(20,10),
    "RH_STLNCD_NR_MAX_CR_LMT" NUMBER(20,10),
    "RH_STLNCD_NR_SUM_SD_LMT" NUMBER(20,10),
    "RH_STLNCD_NR_AVG_SD_LMT" NUMBER(20,10),
    "RH_STLNCD_NR_MN_SD_LMT" NUMBER(20,10),
    "RH_STLNCD_MN_UD_CR_LMT" NUMBER(20,10),
    "RH_STLNCD_NR_SUM_UD_CR_LMT" NUMBER(20,10),
    "RH_STLNCD_NR_MIN_UD_CR_LMT" NUMBER(20,10),
    "RH_STLNCD_UC_MAX_AMT_PRO" NUMBER(20,10),
    "RH_STLNCD_MN_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_SUM_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_SUM_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_NR_MAX_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_NR_AVG_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_NR_MN_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_NR_SUM_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_NR_MAX_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_NR_AVG_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_NR_SUM_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_STLNCD_AVG_MAX_UD_AMT" NUMBER(20,10),
    "RH_STLNCD_MAX_MAX_UD_AMT" NUMBER(20,10),
    "RH_STLNCD_SUM_MAX_UD_AMT" NUMBER(20,10),
    "RH_STLNCD_OVD_CT_2Y_RP" NUMBER(20,10),
    "RH_STLNCD_NONPMF_CT_2Y_RP" NUMBER(20,10),
    "RH_STLNCD_NR_SUM_CR_LMT_M6" NUMBER(20,10),
    "RH_STLNCD_OD180AMT_SUM_AMT" NUMBER(20,10),
    "RH_CRC_NR_MN_CR_LMT" NUMBER(20,10),
    "RH_CRC_MN_UD_CR_LMT" NUMBER(20,10),
    "RH_CRC_UC_MAX_AMT_PRO" NUMBER(20,10),
    "RH_CRC_UC_MIN_AMT_PRO" NUMBER(20,10),
    "RH_CRC_AVG_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_CRC_MN_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_CRC_MAX_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_CRC_MIN_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_CRC_MAX_NR_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_CRC_NR_MIN_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_CRC_NR_AVG_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_CRC_NR_MN_UD_CR_LMT_PR" NUMBER(20,10),
    "RH_CRC_MAX_NR_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_CRC_NR_MIN_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_CRC_NR_MN_UD_SD_LMT_PR" NUMBER(20,10),
    "RH_CRC_MIN_AGE" NUMBER(20,10),
    "RH_CRC_UC_MAX_AGE" NUMBER(20,10),
    "RH_CRC_AVG_MAX_UD_AMT" NUMBER(20,10),
    "RH_CRC_SUM_MAX_UD_AMT" NUMBER(20,10),
    "RH_CRC_OVD_CT_2Y_RP" NUMBER(20,10),
    "RH_CRC_OVD_CT_3Y_RP" NUMBER(20,10),
    "RH_CRC_MAX_SD_LMT_M6" NUMBER(20,10),
    "RH_CRC_SUM_NR_CR_LMT_M6" NUMBER(20,10),
    "RH_CRC_NR_AVG_CR_LMT_M6" NUMBER(20,10),
    "RH_CRC_NR_MN_CR_LMT_M6" NUMBER(20,10),
    "RH_CRC_SUM_NR_CR_LMT_M12" NUMBER(20,10),
    "RH_CRC_OD180AMT_SUM_AMT" NUMBER(20,10),
    "RH_CRC_MAX_AGE" NUMBER(20,10),
    "RH_LN_NUM" NUMBER(20,10),
    "RH_LN_NR_NUM" NUMBER(20,10),
    "RH_LN_CLEAR_NUM" NUMBER(20,10),
    "RH_LN_MAX_AMT" NUMBER(20,10),
    "RH_LN_AVG_AMT" NUMBER(20,10),
    "RH_LN_MAX_BAL" NUMBER(20,10),
    "RH_LN_AVG_BAL" NUMBER(20,10),
    "RH_LN_MIN_BAL_PR" NUMBER(20,10),
    "RH_LN_MAX_BAL_PR" NUMBER(20,10),
    "RH_LN_TYPE_NUM" NUMBER(20,10),
    "RH_LN_ST_FLAG" NUMBER(20,10),
    "RH_LN_ST_ADVA" NUMBER(20,10),
    "RH_LN_ST_ADVP" NUMBER(20,10),
    "RH_LN_ST_OTH" NUMBER(20,10),
    "RH_LN_UC_MAX_AGE" NUMBER(20,10),
    "RH_IF_HOUSELN" NUMBER(20,10),
    "RH_LN_AVG_BAL_M6" NUMBER(20,10),
    "RH_LN_MIN_BAL_PR_M6" NUMBER(20,10),
    "RH_LN_SUM_AMT_M12" NUMBER(20,10),
    "RH_LN_MAX_AMT_M12" NUMBER(20,10),
    "RH_LN_AVG_AMT_M12" NUMBER(20,10),
    "RH_LN_SUM_BAL_M12" NUMBER(20,10),
    "RH_LN_MAX_BAL_M12" NUMBER(20,10),
    "RH_5STATE_NR_NUM" NUMBER(20,10),
    "RH_5STATE_GOOD_PR" NUMBER(20,10),
    "RH_LN_OVD_CUR_AMT_RP" NUMBER(20,10),
    "RH_LN_OVD_MAX_2Y_RP" NUMBER(20,10),
    "RH_LN_NONPMF_CT_2Y_RP" NUMBER(20,10),
    "RH_CARLN_NUM" NUMBER(20,10),
    "RH_CARLN_SUM_AMT" NUMBER(20,10),
    "RH_CARLN_AVG_AMT" NUMBER(20,10),
    "RH_CARLN_MIN_BAL_PR" NUMBER(20,10),
    "RH_CARLN_ST_ADVA" NUMBER(20,10),
    "RH_CARLN_CURODAMT" NUMBER(20,10),
    "RH_HSLN_SUM_AMT" NUMBER(20,10),
    "RH_HSLN_MAX_AMT" NUMBER(20,10),
    "RH_HSLN_AVG_AMT" NUMBER(20,10),
    "RH_HSLN_SUM_BAL" NUMBER(20,10),
    "RH_HSLN_AVG_BAL" NUMBER(20,10),
    "RH_HSLN_MIN_BAL_PR" NUMBER(20,10),
    "RH_HSLN_MAX_BAL_PR" NUMBER(20,10),
    "RH_OPLN_NUM" NUMBER(20,10),
    "RH_OPLN_NR_NUM" NUMBER(20,10),
    "RH_OPLN_CLEAR_NUM" NUMBER(20,10),
    "RH_OPLN_MAX_AMT" NUMBER(20,10),
    "RH_OPLN_MAX_BAL" NUMBER(20,10),
    "RH_OPLN_AVG_BAL" NUMBER(20,10),
    "RH_OPLN_MIN_BAL_PR" NUMBER(20,10),
    "RH_OPLN_ST_ADVA" NUMBER(20,10),
    "RH_AGLN_MAX_BAL" NUMBER(20,10),
    "RH_LN_BAL_NUM" NUMBER(20,10),
    "RH_LN_AVG_PAY_AMT" NUMBER(20,10),
    "RH_LONGLN_SUM_PAY_AMT" NUMBER(20,10),
    "RH_HSLN_SUM_NUM" NUMBER(20,10),
    "RH_LN_M12_OVD_SUM_NUM" NUMBER(20,10),
    "RH_PERBUSHSLNCT_RP" NUMBER(20,10),
    "RH_PERHSLNCT_RP" NUMBER(20,10),
    "RH_OTLNCT_RP" NUMBER(20,10),
    "RH_LN_MAX_AGE" NUMBER(20,10),
    "RH_LNCD_MAX_AGE" NUMBER(20,10),
    "RH_LNCD_OVD_NUM" NUMBER(20,10),
    "RH_SUM_OVD_NUM" NUMBER(20,10),
    "RH_LN_OVD_MON" NUMBER(20,10),
    "RH_LN_OVD_HGST_AMT" NUMBER(20,10),
    "RH_LN_OVD_DUR" NUMBER(20,10),
    "RH_LNCD_OVD_MON" NUMBER(20,10),
    "RH_LNCD_OVD_HGST_AMT" NUMBER(20,10),
    "RH_LNCD_OVD_DUR" NUMBER(20,10),
    "RH_SUM_OVD_MON" NUMBER(20,10),
    "RH_MAX_OVD_MON" NUMBER(20,10),
    "RH_AVG_OVD_MON" NUMBER(20,10),
    "RH_SUM_OVD_HGST_AMT" NUMBER(20,10),
    "RH_MAX_OVD_HGST_AMT" NUMBER(20,10),
    "RH_AVG_OVD_HGST_AMT" NUMBER(20,10),
    "RH_MN_OVD_HGST_AMT" NUMBER(20,10),
    "RH_SUM_OVD_DUR" NUMBER(20,10),
    "RH_MAX_OVD_DUR" NUMBER(20,10),
    "RH_UC_LN_BAL" NUMBER(20,10),
    "RH_UC_LN_AMT" NUMBER(20,10),
    "RH_UC_LN_M6AVG_AMT" NUMBER(20,10),
    "RH_LN_CORG_NUM" NUMBER(20,10),
    "RH_LN_ORG_NUM" NUMBER(20,10),
    "RH_LNCD_UD_AMT" NUMBER(20,10),
    "RH_LNCD_UC_UD_PRO" NUMBER(20,10),
    "RH_M6_LNCD_UD_PRO" NUMBER(20,10),
    "RH_LNCD_UC_MAX_LMT_PRO" NUMBER(20,10),
    "RH_CR_SUM_BAL" NUMBER(20,10),
    "RH_LN_BAL_PRAL" NUMBER(20,10),
    "RH_CD_BAL_PRAL" NUMBER(20,10),
    "RH_CR_LIM_AMT" NUMBER(20,10),
    "RH_LN_AMT_PRAL" NUMBER(20,10),
    "RH_CD_AMT_PRAL" NUMBER(20,10),
    "RH_GR_SUM_AMT" NUMBER(20,10),
    "RH_GR_TOL_BAL" NUMBER(20,10),
    "RH_CR_NUM" NUMBER(20,10),
    "RH_LNCD_CR_UC_NUM_PRO" NUMBER(20,10),
    "RH_CR_BAL_PRO" NUMBER(20,10),
    "RH_CRC_UD_PRO" NUMBER(20,10),
    "RH_CR_OVD_MAX_AMT" NUMBER(20,10),
    "RH_CR_CATE_NUM" NUMBER(20,10),
    "RH_LN_BAL_PRO" NUMBER(20,10),
    "RH_M6_CR_OVD_MON" NUMBER(20,10),
    "RH_M24_CR_OVD_MON" NUMBER(20,10),
    "RH_M12_CR_OVD_MON" NUMBER(20,10),
    "RH_CR_UC_MIN_AGE" NUMBER(20,10),
    "RH_LN_AVG_BAL_AMT" NUMBER(20,10),
    "RH_M24_CR_OVD_NUM" NUMBER(20,10),
    "RH_LN_Y2_QY_NUM" NUMBER(20,10),
    "RH_CRC_Y2_QY_NUM" NUMBER(20,10),
    "RH_GUAR_Y2_QY_NUM" NUMBER(20,10),
    "RH_LN_QY_LST_INTE" NUMBER(20,10),
    "RH_CRC_QY_LST_INTE" NUMBER(20,10),
    "RH_LN_QY_FST_INTE" NUMBER(20,10),
    "RH_CRC_QY_FST_INTE" NUMBER(20,10),
    "RH_PSTLN_Y2_QY_NUM" NUMBER(20,10),
    "RH_MERCH_Y2_QY_NUM" NUMBER(20,10),
    "RH_SELF_M1_QY_NUM" NUMBER(20,10),
    "RH_CR_Y2_QY_NUM" NUMBER(20,10),
    "RH_LN_CR_Y2_QY_PRO" NUMBER(20,10),
    "RH_CRC_CR_Y2_QY_PRO" NUMBER(20,10),
    "RH_CR_Y2_QYF_NUM" NUMBER(20,10),
    "RH_CRC_Y2_QYF_NUM" NUMBER(20,10),
    "RH_CRC_M12_QYF_NUM" NUMBER(20,10),
    "RH_CR_Y2_QYF_PRO" NUMBER(20,10),
    "RH_LN_Y2_QYF_PRO" NUMBER(20,10),
    "RH_CRC_Y2_QYF_PRO" NUMBER(20,10),
    "RH_CRC_CR_Y2_QYF_PRO" NUMBER(20,10),
    "RH_CRC_CR_M6_QYF_PRO" NUMBER(20,10),
    "RH_CRC_CR_M12_QYF_PRO" NUMBER(20,10),
    "RH_LN_CR_Y2_QYF_PRO" NUMBER(20,10),
    "RH_LN_CR_M12_QYF_PRO" NUMBER(20,10),
    "RH_LN_Y2_QY_ORG_NUM" NUMBER(20,10),
    "RH_CRC_Y2_QY_ORG_NUM" NUMBER(20,10),
    "RH_GUAR_Y2_QY_ORG_NUM" NUMBER(20,10),
    "RH_CR_Y2_QY_ORG_NUM" NUMBER(20,10),
    "RH_LN_CR_Y2_QY_ORG_PRO" NUMBER(20,10),
    "RH_CRC_CR_Y2_QY_ORG_PRO" NUMBER(20,10),
    "RH_LN_CR_M12_QY_ORG_PRO" NUMBER(20,10),
    "RH_CR_Y2_QYF_ORG_NUM" NUMBER(20,10),
    "RH_LN_Y2_QYF_ORG_NUM" NUMBER(20,10),
    "RH_CRC_Y2_QYF_ORG_NUM" NUMBER(20,10),
    "RH_CR_Y2_QYF_ORG_PRO" NUMBER(20,10),
    "RH_LN_Y2_QYF_ORG_PRO" NUMBER(20,10),
    "RH_CRC_Y2_QYF_ORG_PRO" NUMBER(20,10),
    "RH_CRC_CR_Y2_QYF_ORG_PRO" NUMBER(20,10),
    "RH_LN_CR_Y2_QYF_ORG_PRO" NUMBER(20,10),
    "RH_M3_QY_NUM"  			NUMBER(20,10),
    "RH_LNCD_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_LNCD_OP_OLD_DT_TIMESTAMP" NUMBER(20,10),
    "RH_STLNCD_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_STLNCD_OP_OLD_DT_TIMESTAMP" NUMBER(20,10),
    "RH_CRC_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_LN_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_LN_RCT_PAYDT_TIMESTAMP" NUMBER(20,10),
    "RH_CARLN_RCT_PAYDT_TIMESTAMP" NUMBER(20,10),
    "RH_CARLN_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_HSLN_RCT_PAYDT_TIMESTAMP" NUMBER(20,10),
    "RH_HSLN_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_OPLN_RCT_PAYDT_TIMESTAMP" NUMBER(20,10),
    "RH_OPRLN_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_AGLN_RCT_PAYDT_TIMESTAMP" NUMBER(20,10),
    "RH_AGLN_OP_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_LN_OP_OLD_DT_TIMESTAMP" NUMBER(20,10),
    "RH_LN_OP_MIN_DT_TIMESTAMP" NUMBER(20,10),
    "RH_LNCD_OP_MIN_DT_TIMESTAMP" NUMBER(20,10),
    "RH_STLNCD_OP_MIN_DT_TIMESTAMP" NUMBER(20,10),
    "RH_CR_OP_MIN_DT_TIMESTAMP" NUMBER(20,10),
    "RH_QY_MAX_DT_TIMESTAMP" NUMBER(20,10),
    "RH_LN_OP_MAX_DT_YEAR" NUMBER(20,10),
    "RH_LN_RCT_PAYDT_YEAR" NUMBER(20,10),
    "RH_AGLN_OP_MAX_DT_YEAR" NUMBER(20,10),
    "RH_LN_OP_OLD_DT_YEAR" NUMBER(20,10),
    "RH_LN_OP_MIN_DT_YEAR" NUMBER(20,10),
    "RH_LNCD_OP_MIN_DT_YEAR" NUMBER(20,10),
    "RH_QY_MAX_DT_YEAR" NUMBER(20,10),
    "RH_LNCD_OP_MAX_DT_MONTH" NUMBER(20,10),
    "RH_LNCD_OP_OLD_DT_MONTH" NUMBER(20,10),
    "RH_LN_RCT_PAYDT_MONTH" NUMBER(20,10),
    "RH_LN_OP_MIN_DT_MONTH" NUMBER(20,10),
    "RH_LNCD_OP_MIN_DT_MONTH" NUMBER(20,10),
    "RH_STLNCD_OP_MIN_DT_MONTH" NUMBER(20,10),
    "RH_QY_MAX_DT_MONTH" NUMBER(20,10),
    "RH_LNCD_OP_MAX_DT_DAY" NUMBER(20,10),
    "RH_LNCD_OP_OLD_DT_DAY" NUMBER(20,10),
    "RH_STLNCD_OP_MAX_DT_DAY" NUMBER(20,10),
    "RH_STLNCD_OP_OLD_DT_DAY" NUMBER(20,10),
    "RH_LN_OP_MAX_DT_DAY" NUMBER(20,10),
    "RH_LN_RCT_PAYDT_DAY" NUMBER(20,10),
    "RH_CARLN_OP_MAX_DT_DAY" NUMBER(20,10),
    "RH_HSLN_RCT_PAYDT_DAY" NUMBER(20,10),
    "RH_HSLN_OP_MAX_DT_DAY" NUMBER(20,10),
    "RH_OPLN_RCT_PAYDT_DAY" NUMBER(20,10),
    "RH_OPRLN_OP_MAX_DT_DAY" NUMBER(20,10),
    "RH_AGLN_OP_MAX_DT_DAY" NUMBER(20,10),
    "RH_LN_OP_OLD_DT_DAY" NUMBER(20,10),
    "RH_QY_MAX_DT_DAY" NUMBER(20,10),
    "RH_LNCD_OP_MAX_DT_WEEK" NUMBER(20,10),
    "RH_LNCD_OP_OLD_DT_WEEK" NUMBER(20,10),
    "RH_STLNCD_OP_MAX_DT_WEEK" NUMBER(20,10),
    "RH_LN_OP_MAX_DT_WEEK" NUMBER(20,10),
    "RH_LN_RCT_PAYDT_WEEK" NUMBER(20,10),
    "RH_CARLN_OP_MAX_DT_WEEK" NUMBER(20,10),
    "RH_HSLN_RCT_PAYDT_WEEK" NUMBER(20,10),
    "RH_OPRLN_OP_MAX_DT_WEEK" NUMBER(20,10),
    "RH_AGLN_OP_MAX_DT_WEEK" NUMBER(20,10),
    "RH_LN_OP_OLD_DT_WEEK" NUMBER(20,10),
    "RH_QY_MAX_DT_WEEK" NUMBER(20,10),
    "SUB_TIME_FEATURE_1" NUMBER(20,10),
    "SUB_TIME_FEATURE_2" NUMBER(20,10),
    "SUB_TIME_FEATURE_3" NUMBER(20,10),
    "SUB_TIME_FEATURE_4" NUMBER(20,10),
    "SUB_TIME_FEATURE_5" NUMBER(20,10),
    "SUB_TIME_FEATURE_6" NUMBER(20,10),
    "SUB_TIME_FEATURE_7" NUMBER(20,10),
    "SUB_TIME_FEATURE_8" NUMBER(20,10),
    "SUB_TIME_FEATURE_9" NUMBER(20,10),
    "SUB_TIME_FEATURE_10" NUMBER(20,10),
    "SCORE" NUMBER (15),
	  "MODEL_RESULT" VARCHAR2(255 BYTE) ,
    "CREATE_TIME" VARCHAR2(255 BYTE)
)
TABLESPACE "FENQILE"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT;





COMMENT ON COLUMN "FENQILE"."AIRM_FXGD_MODEL_INVOKE_CUST2"."ID" IS '主键';
COMMENT ON COLUMN "FENQILE"."AIRM_FXGD_MODEL_INVOKE_CUST2"."SESSION_ID" IS '唯一流水号';
COMMENT ON COLUMN "FENQILE"."AIRM_FXGD_MODEL_INVOKE_CUST2"."APP_NO" IS '申请编号';
COMMENT ON COLUMN "FENQILE"."AIRM_FXGD_MODEL_INVOKE_CUST2"."MODEL_RESULT" IS '响应标识';
COMMENT ON COLUMN "FENQILE"."AIRM_FXGD_MODEL_INVOKE_CUST2"."CREATE_TIME" IS '调用时间';
