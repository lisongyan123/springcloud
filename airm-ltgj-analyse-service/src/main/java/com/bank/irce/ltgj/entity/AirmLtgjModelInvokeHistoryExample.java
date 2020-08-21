package com.bank.irce.ltgj.entity;

import java.util.ArrayList;
import java.util.List;

public class AirmLtgjModelInvokeHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AirmLtgjModelInvokeHistoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andModelNameIsNull() {
            addCriterion("MODEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("MODEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("MODEL_NAME =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("MODEL_NAME <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("MODEL_NAME >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("MODEL_NAME <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("MODEL_NAME like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("MODEL_NAME not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("MODEL_NAME in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("MODEL_NAME not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("MODEL_NAME between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("MODEL_NAME not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNoIsNull() {
            addCriterion("MODEL_NO is null");
            return (Criteria) this;
        }

        public Criteria andModelNoIsNotNull() {
            addCriterion("MODEL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andModelNoEqualTo(String value) {
            addCriterion("MODEL_NO =", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoNotEqualTo(String value) {
            addCriterion("MODEL_NO <>", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoGreaterThan(String value) {
            addCriterion("MODEL_NO >", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_NO >=", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoLessThan(String value) {
            addCriterion("MODEL_NO <", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoLessThanOrEqualTo(String value) {
            addCriterion("MODEL_NO <=", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoLike(String value) {
            addCriterion("MODEL_NO like", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoNotLike(String value) {
            addCriterion("MODEL_NO not like", value, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoIn(List<String> values) {
            addCriterion("MODEL_NO in", values, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoNotIn(List<String> values) {
            addCriterion("MODEL_NO not in", values, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoBetween(String value1, String value2) {
            addCriterion("MODEL_NO between", value1, value2, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelNoNotBetween(String value1, String value2) {
            addCriterion("MODEL_NO not between", value1, value2, "modelNo");
            return (Criteria) this;
        }

        public Criteria andModelResultIsNull() {
            addCriterion("MODEL_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andModelResultIsNotNull() {
            addCriterion("MODEL_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andModelResultEqualTo(String value) {
            addCriterion("MODEL_RESULT =", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultNotEqualTo(String value) {
            addCriterion("MODEL_RESULT <>", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultGreaterThan(String value) {
            addCriterion("MODEL_RESULT >", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_RESULT >=", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultLessThan(String value) {
            addCriterion("MODEL_RESULT <", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultLessThanOrEqualTo(String value) {
            addCriterion("MODEL_RESULT <=", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultLike(String value) {
            addCriterion("MODEL_RESULT like", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultNotLike(String value) {
            addCriterion("MODEL_RESULT not like", value, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultIn(List<String> values) {
            addCriterion("MODEL_RESULT in", values, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultNotIn(List<String> values) {
            addCriterion("MODEL_RESULT not in", values, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultBetween(String value1, String value2) {
            addCriterion("MODEL_RESULT between", value1, value2, "modelResult");
            return (Criteria) this;
        }

        public Criteria andModelResultNotBetween(String value1, String value2) {
            addCriterion("MODEL_RESULT not between", value1, value2, "modelResult");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("REQUEST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("REQUEST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(String value) {
            addCriterion("REQUEST_TIME =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(String value) {
            addCriterion("REQUEST_TIME <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(String value) {
            addCriterion("REQUEST_TIME >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_TIME >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(String value) {
            addCriterion("REQUEST_TIME <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_TIME <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLike(String value) {
            addCriterion("REQUEST_TIME like", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotLike(String value) {
            addCriterion("REQUEST_TIME not like", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<String> values) {
            addCriterion("REQUEST_TIME in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<String> values) {
            addCriterion("REQUEST_TIME not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(String value1, String value2) {
            addCriterion("REQUEST_TIME between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(String value1, String value2) {
            addCriterion("REQUEST_TIME not between", value1, value2, "requestTime");
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