-- 行内黑名单
CREATE TABLE FANQIZHA_BLACKLIST (
    IDEN_NUM VARCHAR2(100) PRIMARY KEY,
    IDEN_TYPE_CD VARCHAR2(100),
    RECORD_START_DT VARCHAR2(100),
    RECORD_DELETE_DT VARCHAR2(100),
    SOURCE_TABLE VARCHAR2(100)
);

COMMENT ON COLUMN "FANQIZHA_BLACKLIST"."IDEN_TYPE_CD" IS '证件类型';
COMMENT ON COLUMN "FANQIZHA_BLACKLIST"."IDEN_NUM" IS '证件号码(key)';
COMMENT ON COLUMN "FANQIZHA_BLACKLIST"."RECORD_START_DT" IS '进入黑名单日期';
COMMENT ON COLUMN "FANQIZHA_BLACKLIST"."RECORD_DELETE_DT" IS '移出黑名单日期';
COMMENT ON COLUMN "FANQIZHA_BLACKLIST"."SOURCE_TABLE" IS '来源表名';