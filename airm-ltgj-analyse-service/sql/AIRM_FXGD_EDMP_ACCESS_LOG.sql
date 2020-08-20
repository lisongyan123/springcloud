-- 产品卡调用流水表
CREATE TABLE "AIRM_FXGD_EDMP_ACCESS_LOG" (
                                                        SESSION_ID VARCHAR2(100),
                                                        CUST_ID VARCHAR2(100),
                                                        APP_NO VARCHAR2(100),
                                                        CREDIT_NO VARCHAR2(100),
                                                        CUST_NAME VARCHAR2(80),
                                                        CERT_NO VARCHAR2(32),
                                                        CERT_TYPE VARCHAR2(20),
                                                        CREDIT_TIMESTAMP NUMBER,
                                                        STATE_CODE VARCHAR2(50),
                                                        CREDIT_CODE VARCHAR2(5),
                                                        CREDIT_RESULT VARCHAR2(400),
                                                        OTHER_RESULT VARCHAR2(500)
);

COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."SESSION_ID" IS '唯一流水号';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."CUST_ID" IS '客户编号';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."APP_NO" IS '申请编号';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."CUST_NAME" IS '客户姓名';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."CERT_NO" IS '证件号';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."CERT_TYPE" IS '证件类型';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."CREDIT_TIMESTAMP" IS '申请编号';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."STATE_CODE" IS '响应状态码';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."CREDIT_CODE" IS '授信结果标识';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."CREDIT_RESULT" IS '授信结果详情';
COMMENT ON COLUMN "AIRM_LTGJ_REQUEST_BODY"."OTHER_RESULT" IS '其他结果详情';
