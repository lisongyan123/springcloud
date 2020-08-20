package com.bank.irce.ltgj.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuthorizationInfoExample() {
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

        public Criteria andAuthSignIsNull() {
            addCriterion("AUTH_SIGN is null");
            return (Criteria) this;
        }

        public Criteria andAuthSignIsNotNull() {
            addCriterion("AUTH_SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andAuthSignEqualTo(String value) {
            addCriterion("AUTH_SIGN =", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotEqualTo(String value) {
            addCriterion("AUTH_SIGN <>", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignGreaterThan(String value) {
            addCriterion("AUTH_SIGN >", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_SIGN >=", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignLessThan(String value) {
            addCriterion("AUTH_SIGN <", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignLessThanOrEqualTo(String value) {
            addCriterion("AUTH_SIGN <=", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignLike(String value) {
            addCriterion("AUTH_SIGN like", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotLike(String value) {
            addCriterion("AUTH_SIGN not like", value, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignIn(List<String> values) {
            addCriterion("AUTH_SIGN in", values, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotIn(List<String> values) {
            addCriterion("AUTH_SIGN not in", values, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignBetween(String value1, String value2) {
            addCriterion("AUTH_SIGN between", value1, value2, "authSign");
            return (Criteria) this;
        }

        public Criteria andAuthSignNotBetween(String value1, String value2) {
            addCriterion("AUTH_SIGN not between", value1, value2, "authSign");
            return (Criteria) this;
        }

        public Criteria andCustAuthedIsNull() {
            addCriterion("CUST_AUTHED is null");
            return (Criteria) this;
        }

        public Criteria andCustAuthedIsNotNull() {
            addCriterion("CUST_AUTHED is not null");
            return (Criteria) this;
        }

        public Criteria andCustAuthedEqualTo(String value) {
            addCriterion("CUST_AUTHED =", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedNotEqualTo(String value) {
            addCriterion("CUST_AUTHED <>", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedGreaterThan(String value) {
            addCriterion("CUST_AUTHED >", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_AUTHED >=", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedLessThan(String value) {
            addCriterion("CUST_AUTHED <", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedLessThanOrEqualTo(String value) {
            addCriterion("CUST_AUTHED <=", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedLike(String value) {
            addCriterion("CUST_AUTHED like", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedNotLike(String value) {
            addCriterion("CUST_AUTHED not like", value, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedIn(List<String> values) {
            addCriterion("CUST_AUTHED in", values, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedNotIn(List<String> values) {
            addCriterion("CUST_AUTHED not in", values, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedBetween(String value1, String value2) {
            addCriterion("CUST_AUTHED between", value1, value2, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andCustAuthedNotBetween(String value1, String value2) {
            addCriterion("CUST_AUTHED not between", value1, value2, "custAuthed");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNull() {
            addCriterion("LOGIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("LOGIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(String value) {
            addCriterion("LOGIN_ID =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(String value) {
            addCriterion("LOGIN_ID <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(String value) {
            addCriterion("LOGIN_ID >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(String value) {
            addCriterion("LOGIN_ID <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLike(String value) {
            addCriterion("LOGIN_ID like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotLike(String value) {
            addCriterion("LOGIN_ID not like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<String> values) {
            addCriterion("LOGIN_ID in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<String> values) {
            addCriterion("LOGIN_ID not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(String value1, String value2) {
            addCriterion("LOGIN_ID between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_ID not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andPbccAddrIsNull() {
            addCriterion("PBCC_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andPbccAddrIsNotNull() {
            addCriterion("PBCC_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andPbccAddrEqualTo(String value) {
            addCriterion("PBCC_ADDR =", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrNotEqualTo(String value) {
            addCriterion("PBCC_ADDR <>", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrGreaterThan(String value) {
            addCriterion("PBCC_ADDR >", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrGreaterThanOrEqualTo(String value) {
            addCriterion("PBCC_ADDR >=", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrLessThan(String value) {
            addCriterion("PBCC_ADDR <", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrLessThanOrEqualTo(String value) {
            addCriterion("PBCC_ADDR <=", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrLike(String value) {
            addCriterion("PBCC_ADDR like", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrNotLike(String value) {
            addCriterion("PBCC_ADDR not like", value, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrIn(List<String> values) {
            addCriterion("PBCC_ADDR in", values, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrNotIn(List<String> values) {
            addCriterion("PBCC_ADDR not in", values, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrBetween(String value1, String value2) {
            addCriterion("PBCC_ADDR between", value1, value2, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andPbccAddrNotBetween(String value1, String value2) {
            addCriterion("PBCC_ADDR not between", value1, value2, "pbccAddr");
            return (Criteria) this;
        }

        public Criteria andCustScoreIsNull() {
            addCriterion("CUST_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andCustScoreIsNotNull() {
            addCriterion("CUST_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andCustScoreEqualTo(BigDecimal value) {
            addCriterion("CUST_SCORE =", value, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreNotEqualTo(BigDecimal value) {
            addCriterion("CUST_SCORE <>", value, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreGreaterThan(BigDecimal value) {
            addCriterion("CUST_SCORE >", value, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CUST_SCORE >=", value, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreLessThan(BigDecimal value) {
            addCriterion("CUST_SCORE <", value, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CUST_SCORE <=", value, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreIn(List<BigDecimal> values) {
            addCriterion("CUST_SCORE in", values, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreNotIn(List<BigDecimal> values) {
            addCriterion("CUST_SCORE not in", values, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUST_SCORE between", value1, value2, "custScore");
            return (Criteria) this;
        }

        public Criteria andCustScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUST_SCORE not between", value1, value2, "custScore");
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