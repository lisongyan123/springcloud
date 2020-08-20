-- 房产信息列表
CREATE TABLE AIRM_FXGD_HOUSE_LIST(
    ID NUMBER(20) PRIMARY KEY,
    APP_NO VARCHAR2(100),
    SESSION_ID VARCHAR2(100),

    OPEN_DATE VARCHAR2(8),
    END_DATE VARCHAR2(8),
    CREDIT_LIMIT_AMOUNT NUMBER(15,2),
    SCHEDULED_PAYMENT_AMOUNT NUMBER(15,2),
    LOAN_HOUSE_TERMS NUMBER(3,0),
    LOAN_AMT NUMBER(15,2),
    REPAY_TERMS NUMBER(3,0),
    LOAN_HOUSE_COUNT NUMBER(3,0)
);
