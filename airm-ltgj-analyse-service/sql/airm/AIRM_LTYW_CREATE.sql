-- 联通业务创建脚本

-- 0.请求响应信息表
CREATE TABLE "AIRM"."AIRM_LTGJ_MASTER_ADUIT_CREDIT" (
    --请求--
                                                SESSION_ID VARCHAR2(24),
                                                APP_NO VARCHAR2(100),
                                                BUSINESS_TYPE_CD VARCHAR2(100),
                                                BUSINESS_TYPE_NAME VARCHAR2(100),
                                                APPLY_TIME VARCHAR2(100),
                                                CUST_SOURCE VARCHAR2(10),
                                                CHANNEL_SOURCE VARCHAR2(30),
                                                CUST_ID VARCHAR2(100),
                                                CUST_BASIC_INFO VARCHAR2(4000),
                                                CUST_OTHER_INFO VARCHAR2(4000),
                                                DEVICE_STATUS_INFO VARCHAR2(1600),
                                                ONLINE_CHECK_INFO VARCHAR2(800),
                                                AUTHORIZATION_INFO VARCHAR2(800),
                                                BAIRONG_SCORE_INFO CLOB,
                                                OTHER_INFO VARCHAR2(1000),
                                                LTZF_INFO CLOB,
                                                LTDSJ_INFO CLOB,

                                                CREDIT_NO VARCHAR2(100),
                                                CUST_NAME VARCHAR2(80),
                                                CERT_NO VARCHAR2(32),
                                                CERT_TYPE VARCHAR2(20),
                                                CREDIT_TIMESTAMP VARCHAR2(100),
                                                STATE_CODE VARCHAR2(50),
                                                CREDIT_CODE VARCHAR2(5),
                                                CREDIT_RESULT VARCHAR2(800),
                                                OTHER_RESULT VARCHAR2(500)
);
--请求--
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."SESSION_ID" IS '唯一流水号';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."APP_NO" IS '申请编号';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."BUSINESS_TYPE_CD" IS '业务品种代码';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."BUSINESS_TYPE_NAME" IS '业务品牌名称';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."APPLY_TIME" IS '申请时间';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CUST_SOURCE" IS '来源系统';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CHANNEL_SOURCE" IS '来源渠道';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CUST_ID" IS '客户编号';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CUST_BASIC_INFO" IS '客户基本信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CUST_OTHER_INFO" IS '客户其他信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."DEVICE_STATUS_INFO" IS '设备状态信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."ONLINE_CHECK_INFO" IS '联网核查信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."AUTHORIZATION_INFO" IS '外部数据授权信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."BAIRONG_SCORE_INFO" IS '百荣信用分信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."OTHER_INFO" IS '其他信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."LTZF_INFO" IS '联通支付信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."LTDSJ_INFO" IS '联通大数据信息';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CREDIT_NO" IS '授信编号';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CUST_NAME" IS '客户姓名';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CERT_NO" IS '证件号';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CERT_TYPE" IS '证件类型';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CREDIT_TIMESTAMP" IS '申请编号';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."STATE_CODE" IS '响应状态码';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CREDIT_CODE" IS '授信结果标识';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."CREDIT_RESULT" IS '授信结果详情';
COMMENT ON COLUMN "AIRM_LTGJ_MASTER_ADUIT_CREDIT"."OTHER_RESULT" IS '其他结果详情';



-- 模型调用流水表: AIRM_LTGJ_MODEL_INVOKE_HISTORY
CREATE TABLE "AIRM"."AIRM_LTGJ_MODEL_INVOKE_HISTORY" (
                                                         "ID" NUMBER(10) NOT NULL ,
                                                         "SESSION_ID" VARCHAR2(255) ,
                                                         "MODEL_NAME" VARCHAR2(255) ,
                                                         "MODEL_NO" VARCHAR2(100) ,
                                                         "REQUEST_PARAMS" CLOB ,
                                                         "RESPONSE_PARAMS" CLOB ,
                                                         "MODEL_RESULT" VARCHAR2(255) ,
                                                         "REQUEST_TIME" VARCHAR2(255)
);

create sequence AIRM_LTGJ_MODEL_INVOKE_HISTORY_SEQ
　　increment by 1
　　start with 1
　　nomaxvalue
　　nocycle
　　cache 20 ;
create trigger AIRM_LTGJ_MODEL_INVOKE_HISTORY_UID before insert on AIRM_LTGJ_MODEL_INVOKE_HISTORY for each row when (new.ID is null)begin
    select AIRM_LTGJ_MODEL_INVOKE_HISTORY_SEQ.nextval into:new.ID  from dual;end;
