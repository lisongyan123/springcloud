package com.bank.irce.ltgj.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustOtherInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustOtherInfoExample() {
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

        public Criteria andCurMarriageStatusCdIsNull() {
            addCriterion("CUR_MARRIAGE_STATUS_CD is null");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdIsNotNull() {
            addCriterion("CUR_MARRIAGE_STATUS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdEqualTo(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD =", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdNotEqualTo(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD <>", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdGreaterThan(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD >", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdGreaterThanOrEqualTo(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD >=", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdLessThan(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD <", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdLessThanOrEqualTo(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD <=", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdLike(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD like", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdNotLike(String value) {
            addCriterion("CUR_MARRIAGE_STATUS_CD not like", value, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdIn(List<String> values) {
            addCriterion("CUR_MARRIAGE_STATUS_CD in", values, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdNotIn(List<String> values) {
            addCriterion("CUR_MARRIAGE_STATUS_CD not in", values, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdBetween(String value1, String value2) {
            addCriterion("CUR_MARRIAGE_STATUS_CD between", value1, value2, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andCurMarriageStatusCdNotBetween(String value1, String value2) {
            addCriterion("CUR_MARRIAGE_STATUS_CD not between", value1, value2, "curMarriageStatusCd");
            return (Criteria) this;
        }

        public Criteria andAddrDescIsNull() {
            addCriterion("ADDR_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAddrDescIsNotNull() {
            addCriterion("ADDR_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDescEqualTo(String value) {
            addCriterion("ADDR_DESC =", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescNotEqualTo(String value) {
            addCriterion("ADDR_DESC <>", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescGreaterThan(String value) {
            addCriterion("ADDR_DESC >", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescGreaterThanOrEqualTo(String value) {
            addCriterion("ADDR_DESC >=", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescLessThan(String value) {
            addCriterion("ADDR_DESC <", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescLessThanOrEqualTo(String value) {
            addCriterion("ADDR_DESC <=", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescLike(String value) {
            addCriterion("ADDR_DESC like", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescNotLike(String value) {
            addCriterion("ADDR_DESC not like", value, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescIn(List<String> values) {
            addCriterion("ADDR_DESC in", values, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescNotIn(List<String> values) {
            addCriterion("ADDR_DESC not in", values, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescBetween(String value1, String value2) {
            addCriterion("ADDR_DESC between", value1, value2, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrDescNotBetween(String value1, String value2) {
            addCriterion("ADDR_DESC not between", value1, value2, "addrDesc");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdIsNull() {
            addCriterion("ADDR_USAG_ECD is null");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdIsNotNull() {
            addCriterion("ADDR_USAG_ECD is not null");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdEqualTo(String value) {
            addCriterion("ADDR_USAG_ECD =", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdNotEqualTo(String value) {
            addCriterion("ADDR_USAG_ECD <>", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdGreaterThan(String value) {
            addCriterion("ADDR_USAG_ECD >", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdGreaterThanOrEqualTo(String value) {
            addCriterion("ADDR_USAG_ECD >=", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdLessThan(String value) {
            addCriterion("ADDR_USAG_ECD <", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdLessThanOrEqualTo(String value) {
            addCriterion("ADDR_USAG_ECD <=", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdLike(String value) {
            addCriterion("ADDR_USAG_ECD like", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdNotLike(String value) {
            addCriterion("ADDR_USAG_ECD not like", value, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdIn(List<String> values) {
            addCriterion("ADDR_USAG_ECD in", values, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdNotIn(List<String> values) {
            addCriterion("ADDR_USAG_ECD not in", values, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdBetween(String value1, String value2) {
            addCriterion("ADDR_USAG_ECD between", value1, value2, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andAddrUsagEcdNotBetween(String value1, String value2) {
            addCriterion("ADDR_USAG_ECD not between", value1, value2, "addrUsagEcd");
            return (Criteria) this;
        }

        public Criteria andMobileNumIsNull() {
            addCriterion("MOBILE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andMobileNumIsNotNull() {
            addCriterion("MOBILE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andMobileNumEqualTo(String value) {
            addCriterion("MOBILE_NUM =", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotEqualTo(String value) {
            addCriterion("MOBILE_NUM <>", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumGreaterThan(String value) {
            addCriterion("MOBILE_NUM >", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE_NUM >=", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumLessThan(String value) {
            addCriterion("MOBILE_NUM <", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumLessThanOrEqualTo(String value) {
            addCriterion("MOBILE_NUM <=", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumLike(String value) {
            addCriterion("MOBILE_NUM like", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotLike(String value) {
            addCriterion("MOBILE_NUM not like", value, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumIn(List<String> values) {
            addCriterion("MOBILE_NUM in", values, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotIn(List<String> values) {
            addCriterion("MOBILE_NUM not in", values, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumBetween(String value1, String value2) {
            addCriterion("MOBILE_NUM between", value1, value2, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andMobileNumNotBetween(String value1, String value2) {
            addCriterion("MOBILE_NUM not between", value1, value2, "mobileNum");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNull() {
            addCriterion("COMP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNotNull() {
            addCriterion("COMP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompNameEqualTo(String value) {
            addCriterion("COMP_NAME =", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotEqualTo(String value) {
            addCriterion("COMP_NAME <>", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThan(String value) {
            addCriterion("COMP_NAME >", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_NAME >=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThan(String value) {
            addCriterion("COMP_NAME <", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThanOrEqualTo(String value) {
            addCriterion("COMP_NAME <=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLike(String value) {
            addCriterion("COMP_NAME like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotLike(String value) {
            addCriterion("COMP_NAME not like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameIn(List<String> values) {
            addCriterion("COMP_NAME in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotIn(List<String> values) {
            addCriterion("COMP_NAME not in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameBetween(String value1, String value2) {
            addCriterion("COMP_NAME between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotBetween(String value1, String value2) {
            addCriterion("COMP_NAME not between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andWorkStateIsNull() {
            addCriterion("WORK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkStateIsNotNull() {
            addCriterion("WORK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStateEqualTo(String value) {
            addCriterion("WORK_STATE =", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotEqualTo(String value) {
            addCriterion("WORK_STATE <>", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateGreaterThan(String value) {
            addCriterion("WORK_STATE >", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_STATE >=", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLessThan(String value) {
            addCriterion("WORK_STATE <", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLessThanOrEqualTo(String value) {
            addCriterion("WORK_STATE <=", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateLike(String value) {
            addCriterion("WORK_STATE like", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotLike(String value) {
            addCriterion("WORK_STATE not like", value, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateIn(List<String> values) {
            addCriterion("WORK_STATE in", values, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotIn(List<String> values) {
            addCriterion("WORK_STATE not in", values, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateBetween(String value1, String value2) {
            addCriterion("WORK_STATE between", value1, value2, "workState");
            return (Criteria) this;
        }

        public Criteria andWorkStateNotBetween(String value1, String value2) {
            addCriterion("WORK_STATE not between", value1, value2, "workState");
            return (Criteria) this;
        }

        public Criteria andDutyCdIsNull() {
            addCriterion("DUTY_CD is null");
            return (Criteria) this;
        }

        public Criteria andDutyCdIsNotNull() {
            addCriterion("DUTY_CD is not null");
            return (Criteria) this;
        }

        public Criteria andDutyCdEqualTo(String value) {
            addCriterion("DUTY_CD =", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdNotEqualTo(String value) {
            addCriterion("DUTY_CD <>", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdGreaterThan(String value) {
            addCriterion("DUTY_CD >", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdGreaterThanOrEqualTo(String value) {
            addCriterion("DUTY_CD >=", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdLessThan(String value) {
            addCriterion("DUTY_CD <", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdLessThanOrEqualTo(String value) {
            addCriterion("DUTY_CD <=", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdLike(String value) {
            addCriterion("DUTY_CD like", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdNotLike(String value) {
            addCriterion("DUTY_CD not like", value, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdIn(List<String> values) {
            addCriterion("DUTY_CD in", values, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdNotIn(List<String> values) {
            addCriterion("DUTY_CD not in", values, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdBetween(String value1, String value2) {
            addCriterion("DUTY_CD between", value1, value2, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andDutyCdNotBetween(String value1, String value2) {
            addCriterion("DUTY_CD not between", value1, value2, "dutyCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdIsNull() {
            addCriterion("TITLE_CD is null");
            return (Criteria) this;
        }

        public Criteria andTitleCdIsNotNull() {
            addCriterion("TITLE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andTitleCdEqualTo(String value) {
            addCriterion("TITLE_CD =", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdNotEqualTo(String value) {
            addCriterion("TITLE_CD <>", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdGreaterThan(String value) {
            addCriterion("TITLE_CD >", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE_CD >=", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdLessThan(String value) {
            addCriterion("TITLE_CD <", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdLessThanOrEqualTo(String value) {
            addCriterion("TITLE_CD <=", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdLike(String value) {
            addCriterion("TITLE_CD like", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdNotLike(String value) {
            addCriterion("TITLE_CD not like", value, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdIn(List<String> values) {
            addCriterion("TITLE_CD in", values, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdNotIn(List<String> values) {
            addCriterion("TITLE_CD not in", values, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdBetween(String value1, String value2) {
            addCriterion("TITLE_CD between", value1, value2, "titleCd");
            return (Criteria) this;
        }

        public Criteria andTitleCdNotBetween(String value1, String value2) {
            addCriterion("TITLE_CD not between", value1, value2, "titleCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdIsNull() {
            addCriterion("OCCUPATION_CD is null");
            return (Criteria) this;
        }

        public Criteria andOccupationCdIsNotNull() {
            addCriterion("OCCUPATION_CD is not null");
            return (Criteria) this;
        }

        public Criteria andOccupationCdEqualTo(String value) {
            addCriterion("OCCUPATION_CD =", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdNotEqualTo(String value) {
            addCriterion("OCCUPATION_CD <>", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdGreaterThan(String value) {
            addCriterion("OCCUPATION_CD >", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdGreaterThanOrEqualTo(String value) {
            addCriterion("OCCUPATION_CD >=", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdLessThan(String value) {
            addCriterion("OCCUPATION_CD <", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdLessThanOrEqualTo(String value) {
            addCriterion("OCCUPATION_CD <=", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdLike(String value) {
            addCriterion("OCCUPATION_CD like", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdNotLike(String value) {
            addCriterion("OCCUPATION_CD not like", value, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdIn(List<String> values) {
            addCriterion("OCCUPATION_CD in", values, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdNotIn(List<String> values) {
            addCriterion("OCCUPATION_CD not in", values, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdBetween(String value1, String value2) {
            addCriterion("OCCUPATION_CD between", value1, value2, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andOccupationCdNotBetween(String value1, String value2) {
            addCriterion("OCCUPATION_CD not between", value1, value2, "occupationCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdIsNull() {
            addCriterion("EDUCATION_LEVEL_cd is null");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdIsNotNull() {
            addCriterion("EDUCATION_LEVEL_cd is not null");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdEqualTo(String value) {
            addCriterion("EDUCATION_LEVEL_cd =", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdNotEqualTo(String value) {
            addCriterion("EDUCATION_LEVEL_cd <>", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdGreaterThan(String value) {
            addCriterion("EDUCATION_LEVEL_cd >", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdGreaterThanOrEqualTo(String value) {
            addCriterion("EDUCATION_LEVEL_cd >=", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdLessThan(String value) {
            addCriterion("EDUCATION_LEVEL_cd <", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdLessThanOrEqualTo(String value) {
            addCriterion("EDUCATION_LEVEL_cd <=", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdLike(String value) {
            addCriterion("EDUCATION_LEVEL_cd like", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdNotLike(String value) {
            addCriterion("EDUCATION_LEVEL_cd not like", value, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdIn(List<String> values) {
            addCriterion("EDUCATION_LEVEL_cd in", values, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdNotIn(List<String> values) {
            addCriterion("EDUCATION_LEVEL_cd not in", values, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdBetween(String value1, String value2) {
            addCriterion("EDUCATION_LEVEL_cd between", value1, value2, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andEducationLevelCdNotBetween(String value1, String value2) {
            addCriterion("EDUCATION_LEVEL_cd not between", value1, value2, "educationLevelCd");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumIsNull() {
            addCriterion("WORK_YEAR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumIsNotNull() {
            addCriterion("WORK_YEAR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumEqualTo(BigDecimal value) {
            addCriterion("WORK_YEAR_NUM =", value, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumNotEqualTo(BigDecimal value) {
            addCriterion("WORK_YEAR_NUM <>", value, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumGreaterThan(BigDecimal value) {
            addCriterion("WORK_YEAR_NUM >", value, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_YEAR_NUM >=", value, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumLessThan(BigDecimal value) {
            addCriterion("WORK_YEAR_NUM <", value, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WORK_YEAR_NUM <=", value, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumIn(List<BigDecimal> values) {
            addCriterion("WORK_YEAR_NUM in", values, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumNotIn(List<BigDecimal> values) {
            addCriterion("WORK_YEAR_NUM not in", values, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_YEAR_NUM between", value1, value2, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andWorkYearNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORK_YEAR_NUM not between", value1, value2, "workYearNum");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdIsNull() {
            addCriterion("CORP_PROPERTY_CD is null");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdIsNotNull() {
            addCriterion("CORP_PROPERTY_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdEqualTo(String value) {
            addCriterion("CORP_PROPERTY_CD =", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdNotEqualTo(String value) {
            addCriterion("CORP_PROPERTY_CD <>", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdGreaterThan(String value) {
            addCriterion("CORP_PROPERTY_CD >", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdGreaterThanOrEqualTo(String value) {
            addCriterion("CORP_PROPERTY_CD >=", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdLessThan(String value) {
            addCriterion("CORP_PROPERTY_CD <", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdLessThanOrEqualTo(String value) {
            addCriterion("CORP_PROPERTY_CD <=", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdLike(String value) {
            addCriterion("CORP_PROPERTY_CD like", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdNotLike(String value) {
            addCriterion("CORP_PROPERTY_CD not like", value, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdIn(List<String> values) {
            addCriterion("CORP_PROPERTY_CD in", values, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdNotIn(List<String> values) {
            addCriterion("CORP_PROPERTY_CD not in", values, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdBetween(String value1, String value2) {
            addCriterion("CORP_PROPERTY_CD between", value1, value2, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCorpPropertyCdNotBetween(String value1, String value2) {
            addCriterion("CORP_PROPERTY_CD not between", value1, value2, "corpPropertyCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdIsNull() {
            addCriterion("COMP_INDUSTRY_CLASS_CD is null");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdIsNotNull() {
            addCriterion("COMP_INDUSTRY_CLASS_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdEqualTo(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD =", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdNotEqualTo(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD <>", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdGreaterThan(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD >", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD >=", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdLessThan(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD <", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdLessThanOrEqualTo(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD <=", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdLike(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD like", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdNotLike(String value) {
            addCriterion("COMP_INDUSTRY_CLASS_CD not like", value, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdIn(List<String> values) {
            addCriterion("COMP_INDUSTRY_CLASS_CD in", values, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdNotIn(List<String> values) {
            addCriterion("COMP_INDUSTRY_CLASS_CD not in", values, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdBetween(String value1, String value2) {
            addCriterion("COMP_INDUSTRY_CLASS_CD between", value1, value2, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCompIndustryClassCdNotBetween(String value1, String value2) {
            addCriterion("COMP_INDUSTRY_CLASS_CD not between", value1, value2, "compIndustryClassCd");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysIsNull() {
            addCriterion("CURR_OVRD_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysIsNotNull() {
            addCriterion("CURR_OVRD_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysEqualTo(String value) {
            addCriterion("CURR_OVRD_DAYS =", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysNotEqualTo(String value) {
            addCriterion("CURR_OVRD_DAYS <>", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysGreaterThan(String value) {
            addCriterion("CURR_OVRD_DAYS >", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysGreaterThanOrEqualTo(String value) {
            addCriterion("CURR_OVRD_DAYS >=", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysLessThan(String value) {
            addCriterion("CURR_OVRD_DAYS <", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysLessThanOrEqualTo(String value) {
            addCriterion("CURR_OVRD_DAYS <=", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysLike(String value) {
            addCriterion("CURR_OVRD_DAYS like", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysNotLike(String value) {
            addCriterion("CURR_OVRD_DAYS not like", value, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysIn(List<String> values) {
            addCriterion("CURR_OVRD_DAYS in", values, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysNotIn(List<String> values) {
            addCriterion("CURR_OVRD_DAYS not in", values, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysBetween(String value1, String value2) {
            addCriterion("CURR_OVRD_DAYS between", value1, value2, "currOvrdDays");
            return (Criteria) this;
        }

        public Criteria andCurrOvrdDaysNotBetween(String value1, String value2) {
            addCriterion("CURR_OVRD_DAYS not between", value1, value2, "currOvrdDays");
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