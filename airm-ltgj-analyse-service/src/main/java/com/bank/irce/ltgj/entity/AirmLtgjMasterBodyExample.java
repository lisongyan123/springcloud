package com.bank.irce.ltgj.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AirmLtgjMasterBodyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AirmLtgjMasterBodyExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSessionIdIsNull() {
            addCriterion("SESSION_ID is null");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNotNull() {
            addCriterion("SESSION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSessionIdEqualTo(String value) {
            addCriterion("SESSION_ID =", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotEqualTo(String value) {
            addCriterion("SESSION_ID <>", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThan(String value) {
            addCriterion("SESSION_ID >", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("SESSION_ID >=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThan(String value) {
            addCriterion("SESSION_ID <", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThanOrEqualTo(String value) {
            addCriterion("SESSION_ID <=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLike(String value) {
            addCriterion("SESSION_ID like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotLike(String value) {
            addCriterion("SESSION_ID not like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIn(List<String> values) {
            addCriterion("SESSION_ID in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotIn(List<String> values) {
            addCriterion("SESSION_ID not in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdBetween(String value1, String value2) {
            addCriterion("SESSION_ID between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotBetween(String value1, String value2) {
            addCriterion("SESSION_ID not between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andAppNoIsNull() {
            addCriterion("APP_NO is null");
            return (Criteria) this;
        }

        public Criteria andAppNoIsNotNull() {
            addCriterion("APP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAppNoEqualTo(String value) {
            addCriterion("APP_NO =", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotEqualTo(String value) {
            addCriterion("APP_NO <>", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoGreaterThan(String value) {
            addCriterion("APP_NO >", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoGreaterThanOrEqualTo(String value) {
            addCriterion("APP_NO >=", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLessThan(String value) {
            addCriterion("APP_NO <", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLessThanOrEqualTo(String value) {
            addCriterion("APP_NO <=", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoLike(String value) {
            addCriterion("APP_NO like", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotLike(String value) {
            addCriterion("APP_NO not like", value, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoIn(List<String> values) {
            addCriterion("APP_NO in", values, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotIn(List<String> values) {
            addCriterion("APP_NO not in", values, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoBetween(String value1, String value2) {
            addCriterion("APP_NO between", value1, value2, "appNo");
            return (Criteria) this;
        }

        public Criteria andAppNoNotBetween(String value1, String value2) {
            addCriterion("APP_NO not between", value1, value2, "appNo");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdIsNull() {
            addCriterion("BUSINESS_TYPE_CD is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdIsNotNull() {
            addCriterion("BUSINESS_TYPE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_CD =", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_CD <>", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE_CD >", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_CD >=", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdLessThan(String value) {
            addCriterion("BUSINESS_TYPE_CD <", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_CD <=", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdLike(String value) {
            addCriterion("BUSINESS_TYPE_CD like", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdNotLike(String value) {
            addCriterion("BUSINESS_TYPE_CD not like", value, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdIn(List<String> values) {
            addCriterion("BUSINESS_TYPE_CD in", values, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdNotIn(List<String> values) {
            addCriterion("BUSINESS_TYPE_CD not in", values, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE_CD between", value1, value2, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeCdNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE_CD not between", value1, value2, "businessTypeCd");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameIsNull() {
            addCriterion("BUSINESS_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameIsNotNull() {
            addCriterion("BUSINESS_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_NAME =", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_NAME <>", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE_NAME >", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_NAME >=", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameLessThan(String value) {
            addCriterion("BUSINESS_TYPE_NAME <", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE_NAME <=", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameLike(String value) {
            addCriterion("BUSINESS_TYPE_NAME like", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameNotLike(String value) {
            addCriterion("BUSINESS_TYPE_NAME not like", value, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameIn(List<String> values) {
            addCriterion("BUSINESS_TYPE_NAME in", values, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameNotIn(List<String> values) {
            addCriterion("BUSINESS_TYPE_NAME not in", values, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE_NAME between", value1, value2, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNameNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE_NAME not between", value1, value2, "businessTypeName");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("APPLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("APPLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(BigDecimal value) {
            addCriterion("APPLY_TIME =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(BigDecimal value) {
            addCriterion("APPLY_TIME <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(BigDecimal value) {
            addCriterion("APPLY_TIME >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("APPLY_TIME >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(BigDecimal value) {
            addCriterion("APPLY_TIME <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("APPLY_TIME <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<BigDecimal> values) {
            addCriterion("APPLY_TIME in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<BigDecimal> values) {
            addCriterion("APPLY_TIME not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APPLY_TIME between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("APPLY_TIME not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andCustSourceIsNull() {
            addCriterion("CUST_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andCustSourceIsNotNull() {
            addCriterion("CUST_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andCustSourceEqualTo(String value) {
            addCriterion("CUST_SOURCE =", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotEqualTo(String value) {
            addCriterion("CUST_SOURCE <>", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceGreaterThan(String value) {
            addCriterion("CUST_SOURCE >", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_SOURCE >=", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceLessThan(String value) {
            addCriterion("CUST_SOURCE <", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceLessThanOrEqualTo(String value) {
            addCriterion("CUST_SOURCE <=", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceLike(String value) {
            addCriterion("CUST_SOURCE like", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotLike(String value) {
            addCriterion("CUST_SOURCE not like", value, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceIn(List<String> values) {
            addCriterion("CUST_SOURCE in", values, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotIn(List<String> values) {
            addCriterion("CUST_SOURCE not in", values, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceBetween(String value1, String value2) {
            addCriterion("CUST_SOURCE between", value1, value2, "custSource");
            return (Criteria) this;
        }

        public Criteria andCustSourceNotBetween(String value1, String value2) {
            addCriterion("CUST_SOURCE not between", value1, value2, "custSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceIsNull() {
            addCriterion("CHANNEL_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andChannelSourceIsNotNull() {
            addCriterion("CHANNEL_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSourceEqualTo(String value) {
            addCriterion("CHANNEL_SOURCE =", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceNotEqualTo(String value) {
            addCriterion("CHANNEL_SOURCE <>", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceGreaterThan(String value) {
            addCriterion("CHANNEL_SOURCE >", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_SOURCE >=", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceLessThan(String value) {
            addCriterion("CHANNEL_SOURCE <", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_SOURCE <=", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceLike(String value) {
            addCriterion("CHANNEL_SOURCE like", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceNotLike(String value) {
            addCriterion("CHANNEL_SOURCE not like", value, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceIn(List<String> values) {
            addCriterion("CHANNEL_SOURCE in", values, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceNotIn(List<String> values) {
            addCriterion("CHANNEL_SOURCE not in", values, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceBetween(String value1, String value2) {
            addCriterion("CHANNEL_SOURCE between", value1, value2, "channelSource");
            return (Criteria) this;
        }

        public Criteria andChannelSourceNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_SOURCE not between", value1, value2, "channelSource");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoIsNull() {
            addCriterion("CUST_BASIC_INFO is null");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoIsNotNull() {
            addCriterion("CUST_BASIC_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoEqualTo(String value) {
            addCriterion("CUST_BASIC_INFO =", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoNotEqualTo(String value) {
            addCriterion("CUST_BASIC_INFO <>", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoGreaterThan(String value) {
            addCriterion("CUST_BASIC_INFO >", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_BASIC_INFO >=", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoLessThan(String value) {
            addCriterion("CUST_BASIC_INFO <", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoLessThanOrEqualTo(String value) {
            addCriterion("CUST_BASIC_INFO <=", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoLike(String value) {
            addCriterion("CUST_BASIC_INFO like", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoNotLike(String value) {
            addCriterion("CUST_BASIC_INFO not like", value, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoIn(List<String> values) {
            addCriterion("CUST_BASIC_INFO in", values, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoNotIn(List<String> values) {
            addCriterion("CUST_BASIC_INFO not in", values, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoBetween(String value1, String value2) {
            addCriterion("CUST_BASIC_INFO between", value1, value2, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustBasicInfoNotBetween(String value1, String value2) {
            addCriterion("CUST_BASIC_INFO not between", value1, value2, "custBasicInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoIsNull() {
            addCriterion("CUST_OTHER_INFO is null");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoIsNotNull() {
            addCriterion("CUST_OTHER_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoEqualTo(String value) {
            addCriterion("CUST_OTHER_INFO =", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoNotEqualTo(String value) {
            addCriterion("CUST_OTHER_INFO <>", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoGreaterThan(String value) {
            addCriterion("CUST_OTHER_INFO >", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_OTHER_INFO >=", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoLessThan(String value) {
            addCriterion("CUST_OTHER_INFO <", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoLessThanOrEqualTo(String value) {
            addCriterion("CUST_OTHER_INFO <=", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoLike(String value) {
            addCriterion("CUST_OTHER_INFO like", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoNotLike(String value) {
            addCriterion("CUST_OTHER_INFO not like", value, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoIn(List<String> values) {
            addCriterion("CUST_OTHER_INFO in", values, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoNotIn(List<String> values) {
            addCriterion("CUST_OTHER_INFO not in", values, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoBetween(String value1, String value2) {
            addCriterion("CUST_OTHER_INFO between", value1, value2, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andCustOtherInfoNotBetween(String value1, String value2) {
            addCriterion("CUST_OTHER_INFO not between", value1, value2, "custOtherInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoIsNull() {
            addCriterion("DEVICE_STATUS_INFO is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoIsNotNull() {
            addCriterion("DEVICE_STATUS_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoEqualTo(String value) {
            addCriterion("DEVICE_STATUS_INFO =", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoNotEqualTo(String value) {
            addCriterion("DEVICE_STATUS_INFO <>", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoGreaterThan(String value) {
            addCriterion("DEVICE_STATUS_INFO >", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_STATUS_INFO >=", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoLessThan(String value) {
            addCriterion("DEVICE_STATUS_INFO <", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_STATUS_INFO <=", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoLike(String value) {
            addCriterion("DEVICE_STATUS_INFO like", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoNotLike(String value) {
            addCriterion("DEVICE_STATUS_INFO not like", value, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoIn(List<String> values) {
            addCriterion("DEVICE_STATUS_INFO in", values, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoNotIn(List<String> values) {
            addCriterion("DEVICE_STATUS_INFO not in", values, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoBetween(String value1, String value2) {
            addCriterion("DEVICE_STATUS_INFO between", value1, value2, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusInfoNotBetween(String value1, String value2) {
            addCriterion("DEVICE_STATUS_INFO not between", value1, value2, "deviceStatusInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoIsNull() {
            addCriterion("ONLINE_CHECK_INFO is null");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoIsNotNull() {
            addCriterion("ONLINE_CHECK_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoEqualTo(String value) {
            addCriterion("ONLINE_CHECK_INFO =", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoNotEqualTo(String value) {
            addCriterion("ONLINE_CHECK_INFO <>", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoGreaterThan(String value) {
            addCriterion("ONLINE_CHECK_INFO >", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ONLINE_CHECK_INFO >=", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoLessThan(String value) {
            addCriterion("ONLINE_CHECK_INFO <", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoLessThanOrEqualTo(String value) {
            addCriterion("ONLINE_CHECK_INFO <=", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoLike(String value) {
            addCriterion("ONLINE_CHECK_INFO like", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoNotLike(String value) {
            addCriterion("ONLINE_CHECK_INFO not like", value, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoIn(List<String> values) {
            addCriterion("ONLINE_CHECK_INFO in", values, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoNotIn(List<String> values) {
            addCriterion("ONLINE_CHECK_INFO not in", values, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoBetween(String value1, String value2) {
            addCriterion("ONLINE_CHECK_INFO between", value1, value2, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andOnlineCheckInfoNotBetween(String value1, String value2) {
            addCriterion("ONLINE_CHECK_INFO not between", value1, value2, "onlineCheckInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoIsNull() {
            addCriterion("AUTHORIZATION_INFO is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoIsNotNull() {
            addCriterion("AUTHORIZATION_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoEqualTo(String value) {
            addCriterion("AUTHORIZATION_INFO =", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoNotEqualTo(String value) {
            addCriterion("AUTHORIZATION_INFO <>", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoGreaterThan(String value) {
            addCriterion("AUTHORIZATION_INFO >", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORIZATION_INFO >=", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoLessThan(String value) {
            addCriterion("AUTHORIZATION_INFO <", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoLessThanOrEqualTo(String value) {
            addCriterion("AUTHORIZATION_INFO <=", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoLike(String value) {
            addCriterion("AUTHORIZATION_INFO like", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoNotLike(String value) {
            addCriterion("AUTHORIZATION_INFO not like", value, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoIn(List<String> values) {
            addCriterion("AUTHORIZATION_INFO in", values, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoNotIn(List<String> values) {
            addCriterion("AUTHORIZATION_INFO not in", values, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoBetween(String value1, String value2) {
            addCriterion("AUTHORIZATION_INFO between", value1, value2, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andAuthorizationInfoNotBetween(String value1, String value2) {
            addCriterion("AUTHORIZATION_INFO not between", value1, value2, "authorizationInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoIsNull() {
            addCriterion("BAIRONG_SCORE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoIsNotNull() {
            addCriterion("BAIRONG_SCORE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoEqualTo(String value) {
            addCriterion("BAIRONG_SCORE_INFO =", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoNotEqualTo(String value) {
            addCriterion("BAIRONG_SCORE_INFO <>", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoGreaterThan(String value) {
            addCriterion("BAIRONG_SCORE_INFO >", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoGreaterThanOrEqualTo(String value) {
            addCriterion("BAIRONG_SCORE_INFO >=", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoLessThan(String value) {
            addCriterion("BAIRONG_SCORE_INFO <", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoLessThanOrEqualTo(String value) {
            addCriterion("BAIRONG_SCORE_INFO <=", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoLike(String value) {
            addCriterion("BAIRONG_SCORE_INFO like", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoNotLike(String value) {
            addCriterion("BAIRONG_SCORE_INFO not like", value, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoIn(List<String> values) {
            addCriterion("BAIRONG_SCORE_INFO in", values, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoNotIn(List<String> values) {
            addCriterion("BAIRONG_SCORE_INFO not in", values, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoBetween(String value1, String value2) {
            addCriterion("BAIRONG_SCORE_INFO between", value1, value2, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andBairongScoreInfoNotBetween(String value1, String value2) {
            addCriterion("BAIRONG_SCORE_INFO not between", value1, value2, "bairongScoreInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIsNull() {
            addCriterion("OTHER_INFO is null");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIsNotNull() {
            addCriterion("OTHER_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andOtherInfoEqualTo(String value) {
            addCriterion("OTHER_INFO =", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotEqualTo(String value) {
            addCriterion("OTHER_INFO <>", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoGreaterThan(String value) {
            addCriterion("OTHER_INFO >", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_INFO >=", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLessThan(String value) {
            addCriterion("OTHER_INFO <", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLessThanOrEqualTo(String value) {
            addCriterion("OTHER_INFO <=", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoLike(String value) {
            addCriterion("OTHER_INFO like", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotLike(String value) {
            addCriterion("OTHER_INFO not like", value, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoIn(List<String> values) {
            addCriterion("OTHER_INFO in", values, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotIn(List<String> values) {
            addCriterion("OTHER_INFO not in", values, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoBetween(String value1, String value2) {
            addCriterion("OTHER_INFO between", value1, value2, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andOtherInfoNotBetween(String value1, String value2) {
            addCriterion("OTHER_INFO not between", value1, value2, "otherInfo");
            return (Criteria) this;
        }

        public Criteria andCreditNoIsNull() {
            addCriterion("CREDIT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCreditNoIsNotNull() {
            addCriterion("CREDIT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCreditNoEqualTo(String value) {
            addCriterion("CREDIT_NO =", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotEqualTo(String value) {
            addCriterion("CREDIT_NO <>", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoGreaterThan(String value) {
            addCriterion("CREDIT_NO >", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_NO >=", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLessThan(String value) {
            addCriterion("CREDIT_NO <", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_NO <=", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoLike(String value) {
            addCriterion("CREDIT_NO like", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotLike(String value) {
            addCriterion("CREDIT_NO not like", value, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoIn(List<String> values) {
            addCriterion("CREDIT_NO in", values, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotIn(List<String> values) {
            addCriterion("CREDIT_NO not in", values, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoBetween(String value1, String value2) {
            addCriterion("CREDIT_NO between", value1, value2, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCreditNoNotBetween(String value1, String value2) {
            addCriterion("CREDIT_NO not between", value1, value2, "creditNo");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNull() {
            addCriterion("CERT_NO is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("CERT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("CERT_NO =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("CERT_NO <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("CERT_NO >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NO >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("CERT_NO <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("CERT_NO <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("CERT_NO like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("CERT_NO not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("CERT_NO in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("CERT_NO not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("CERT_NO between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("CERT_NO not between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(String value) {
            addCriterion("CERT_TYPE =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(String value) {
            addCriterion("CERT_TYPE <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(String value) {
            addCriterion("CERT_TYPE >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(String value) {
            addCriterion("CERT_TYPE <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLike(String value) {
            addCriterion("CERT_TYPE like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotLike(String value) {
            addCriterion("CERT_TYPE not like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<String> values) {
            addCriterion("CERT_TYPE in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<String> values) {
            addCriterion("CERT_TYPE not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(String value1, String value2) {
            addCriterion("CERT_TYPE between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(String value1, String value2) {
            addCriterion("CERT_TYPE not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampIsNull() {
            addCriterion("CREDIT_TIMESTAMP is null");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampIsNotNull() {
            addCriterion("CREDIT_TIMESTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TIMESTAMP =", value, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TIMESTAMP <>", value, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_TIMESTAMP >", value, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TIMESTAMP >=", value, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampLessThan(BigDecimal value) {
            addCriterion("CREDIT_TIMESTAMP <", value, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_TIMESTAMP <=", value, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampIn(List<BigDecimal> values) {
            addCriterion("CREDIT_TIMESTAMP in", values, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_TIMESTAMP not in", values, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_TIMESTAMP between", value1, value2, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreditTimestampNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_TIMESTAMP not between", value1, value2, "creditTimestamp");
            return (Criteria) this;
        }

        public Criteria andStateCodeIsNull() {
            addCriterion("STATE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andStateCodeIsNotNull() {
            addCriterion("STATE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andStateCodeEqualTo(String value) {
            addCriterion("STATE_CODE =", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeNotEqualTo(String value) {
            addCriterion("STATE_CODE <>", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeGreaterThan(String value) {
            addCriterion("STATE_CODE >", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("STATE_CODE >=", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeLessThan(String value) {
            addCriterion("STATE_CODE <", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeLessThanOrEqualTo(String value) {
            addCriterion("STATE_CODE <=", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeLike(String value) {
            addCriterion("STATE_CODE like", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeNotLike(String value) {
            addCriterion("STATE_CODE not like", value, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeIn(List<String> values) {
            addCriterion("STATE_CODE in", values, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeNotIn(List<String> values) {
            addCriterion("STATE_CODE not in", values, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeBetween(String value1, String value2) {
            addCriterion("STATE_CODE between", value1, value2, "stateCode");
            return (Criteria) this;
        }

        public Criteria andStateCodeNotBetween(String value1, String value2) {
            addCriterion("STATE_CODE not between", value1, value2, "stateCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("CREDIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("CREDIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("CREDIT_CODE =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("CREDIT_CODE <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("CREDIT_CODE >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_CODE >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("CREDIT_CODE <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_CODE <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("CREDIT_CODE like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("CREDIT_CODE not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("CREDIT_CODE in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("CREDIT_CODE not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("CREDIT_CODE between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("CREDIT_CODE not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditResultIsNull() {
            addCriterion("CREDIT_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andCreditResultIsNotNull() {
            addCriterion("CREDIT_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditResultEqualTo(String value) {
            addCriterion("CREDIT_RESULT =", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotEqualTo(String value) {
            addCriterion("CREDIT_RESULT <>", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultGreaterThan(String value) {
            addCriterion("CREDIT_RESULT >", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_RESULT >=", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultLessThan(String value) {
            addCriterion("CREDIT_RESULT <", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_RESULT <=", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultLike(String value) {
            addCriterion("CREDIT_RESULT like", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotLike(String value) {
            addCriterion("CREDIT_RESULT not like", value, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultIn(List<String> values) {
            addCriterion("CREDIT_RESULT in", values, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotIn(List<String> values) {
            addCriterion("CREDIT_RESULT not in", values, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultBetween(String value1, String value2) {
            addCriterion("CREDIT_RESULT between", value1, value2, "creditResult");
            return (Criteria) this;
        }

        public Criteria andCreditResultNotBetween(String value1, String value2) {
            addCriterion("CREDIT_RESULT not between", value1, value2, "creditResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultIsNull() {
            addCriterion("OTHER_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andOtherResultIsNotNull() {
            addCriterion("OTHER_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andOtherResultEqualTo(String value) {
            addCriterion("OTHER_RESULT =", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultNotEqualTo(String value) {
            addCriterion("OTHER_RESULT <>", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultGreaterThan(String value) {
            addCriterion("OTHER_RESULT >", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_RESULT >=", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultLessThan(String value) {
            addCriterion("OTHER_RESULT <", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultLessThanOrEqualTo(String value) {
            addCriterion("OTHER_RESULT <=", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultLike(String value) {
            addCriterion("OTHER_RESULT like", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultNotLike(String value) {
            addCriterion("OTHER_RESULT not like", value, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultIn(List<String> values) {
            addCriterion("OTHER_RESULT in", values, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultNotIn(List<String> values) {
            addCriterion("OTHER_RESULT not in", values, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultBetween(String value1, String value2) {
            addCriterion("OTHER_RESULT between", value1, value2, "otherResult");
            return (Criteria) this;
        }

        public Criteria andOtherResultNotBetween(String value1, String value2) {
            addCriterion("OTHER_RESULT not between", value1, value2, "otherResult");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}