package com.bank.irce.ltgj.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditResultExample() {
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

        public Criteria andCreditLimitIsNull() {
            addCriterion("CREDIT_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIsNotNull() {
            addCriterion("CREDIT_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LIMIT =", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LIMIT <>", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThan(BigDecimal value) {
            addCriterion("CREDIT_LIMIT >", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LIMIT >=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThan(BigDecimal value) {
            addCriterion("CREDIT_LIMIT <", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREDIT_LIMIT <=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIn(List<BigDecimal> values) {
            addCriterion("CREDIT_LIMIT in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotIn(List<BigDecimal> values) {
            addCriterion("CREDIT_LIMIT not in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_LIMIT between", value1, value2, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREDIT_LIMIT not between", value1, value2, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonIsNull() {
            addCriterion("REFUSE_REASON is null");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonIsNotNull() {
            addCriterion("REFUSE_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonEqualTo(String value) {
            addCriterion("REFUSE_REASON =", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotEqualTo(String value) {
            addCriterion("REFUSE_REASON <>", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonGreaterThan(String value) {
            addCriterion("REFUSE_REASON >", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REFUSE_REASON >=", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonLessThan(String value) {
            addCriterion("REFUSE_REASON <", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonLessThanOrEqualTo(String value) {
            addCriterion("REFUSE_REASON <=", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonLike(String value) {
            addCriterion("REFUSE_REASON like", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotLike(String value) {
            addCriterion("REFUSE_REASON not like", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonIn(List<String> values) {
            addCriterion("REFUSE_REASON in", values, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotIn(List<String> values) {
            addCriterion("REFUSE_REASON not in", values, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonBetween(String value1, String value2) {
            addCriterion("REFUSE_REASON between", value1, value2, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotBetween(String value1, String value2) {
            addCriterion("REFUSE_REASON not between", value1, value2, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIsNull() {
            addCriterion("QUERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIsNotNull() {
            addCriterion("QUERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQueryTypeEqualTo(String value) {
            addCriterion("QUERY_TYPE =", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotEqualTo(String value) {
            addCriterion("QUERY_TYPE <>", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeGreaterThan(String value) {
            addCriterion("QUERY_TYPE >", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_TYPE >=", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLessThan(String value) {
            addCriterion("QUERY_TYPE <", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLessThanOrEqualTo(String value) {
            addCriterion("QUERY_TYPE <=", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLike(String value) {
            addCriterion("QUERY_TYPE like", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotLike(String value) {
            addCriterion("QUERY_TYPE not like", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIn(List<String> values) {
            addCriterion("QUERY_TYPE in", values, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotIn(List<String> values) {
            addCriterion("QUERY_TYPE not in", values, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeBetween(String value1, String value2) {
            addCriterion("QUERY_TYPE between", value1, value2, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotBetween(String value1, String value2) {
            addCriterion("QUERY_TYPE not between", value1, value2, "queryType");
            return (Criteria) this;
        }

        public Criteria andReserveIsNull() {
            addCriterion("RESERVE is null");
            return (Criteria) this;
        }

        public Criteria andReserveIsNotNull() {
            addCriterion("RESERVE is not null");
            return (Criteria) this;
        }

        public Criteria andReserveEqualTo(String value) {
            addCriterion("RESERVE =", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotEqualTo(String value) {
            addCriterion("RESERVE <>", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThan(String value) {
            addCriterion("RESERVE >", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveGreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE >=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThan(String value) {
            addCriterion("RESERVE <", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLessThanOrEqualTo(String value) {
            addCriterion("RESERVE <=", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveLike(String value) {
            addCriterion("RESERVE like", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotLike(String value) {
            addCriterion("RESERVE not like", value, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveIn(List<String> values) {
            addCriterion("RESERVE in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotIn(List<String> values) {
            addCriterion("RESERVE not in", values, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveBetween(String value1, String value2) {
            addCriterion("RESERVE between", value1, value2, "reserve");
            return (Criteria) this;
        }

        public Criteria andReserveNotBetween(String value1, String value2) {
            addCriterion("RESERVE not between", value1, value2, "reserve");
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