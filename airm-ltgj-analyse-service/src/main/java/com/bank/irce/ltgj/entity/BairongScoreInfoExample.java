package com.bank.irce.ltgj.entity;

import java.util.ArrayList;
import java.util.List;

public class BairongScoreInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BairongScoreInfoExample() {
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

        public Criteria andOutCodeIsNull() {
            addCriterion("OUT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOutCodeIsNotNull() {
            addCriterion("OUT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOutCodeEqualTo(String value) {
            addCriterion("OUT_CODE =", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeNotEqualTo(String value) {
            addCriterion("OUT_CODE <>", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeGreaterThan(String value) {
            addCriterion("OUT_CODE >", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_CODE >=", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeLessThan(String value) {
            addCriterion("OUT_CODE <", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeLessThanOrEqualTo(String value) {
            addCriterion("OUT_CODE <=", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeLike(String value) {
            addCriterion("OUT_CODE like", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeNotLike(String value) {
            addCriterion("OUT_CODE not like", value, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeIn(List<String> values) {
            addCriterion("OUT_CODE in", values, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeNotIn(List<String> values) {
            addCriterion("OUT_CODE not in", values, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeBetween(String value1, String value2) {
            addCriterion("OUT_CODE between", value1, value2, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutCodeNotBetween(String value1, String value2) {
            addCriterion("OUT_CODE not between", value1, value2, "outCode");
            return (Criteria) this;
        }

        public Criteria andOutDescIsNull() {
            addCriterion("OUT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOutDescIsNotNull() {
            addCriterion("OUT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOutDescEqualTo(String value) {
            addCriterion("OUT_DESC =", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescNotEqualTo(String value) {
            addCriterion("OUT_DESC <>", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescGreaterThan(String value) {
            addCriterion("OUT_DESC >", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_DESC >=", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescLessThan(String value) {
            addCriterion("OUT_DESC <", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescLessThanOrEqualTo(String value) {
            addCriterion("OUT_DESC <=", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescLike(String value) {
            addCriterion("OUT_DESC like", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescNotLike(String value) {
            addCriterion("OUT_DESC not like", value, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescIn(List<String> values) {
            addCriterion("OUT_DESC in", values, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescNotIn(List<String> values) {
            addCriterion("OUT_DESC not in", values, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescBetween(String value1, String value2) {
            addCriterion("OUT_DESC between", value1, value2, "outDesc");
            return (Criteria) this;
        }

        public Criteria andOutDescNotBetween(String value1, String value2) {
            addCriterion("OUT_DESC not between", value1, value2, "outDesc");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("SID is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("SID is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("SID =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("SID <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("SID >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("SID >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("SID <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("SID <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("SID like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("SID not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("SID in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("SID not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("SID between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("SID not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("SEND_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("SEND_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(String value) {
            addCriterion("SEND_TYPE =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(String value) {
            addCriterion("SEND_TYPE <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(String value) {
            addCriterion("SEND_TYPE >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_TYPE >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(String value) {
            addCriterion("SEND_TYPE <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(String value) {
            addCriterion("SEND_TYPE <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLike(String value) {
            addCriterion("SEND_TYPE like", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotLike(String value) {
            addCriterion("SEND_TYPE not like", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<String> values) {
            addCriterion("SEND_TYPE in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<String> values) {
            addCriterion("SEND_TYPE not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(String value1, String value2) {
            addCriterion("SEND_TYPE between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(String value1, String value2) {
            addCriterion("SEND_TYPE not between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
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