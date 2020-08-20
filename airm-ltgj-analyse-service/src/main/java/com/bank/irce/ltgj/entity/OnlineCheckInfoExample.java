package com.bank.irce.ltgj.entity;

import java.util.ArrayList;
import java.util.List;

public class OnlineCheckInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OnlineCheckInfoExample() {
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

        public Criteria andResultFlagIsNull() {
            addCriterion("RESULT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andResultFlagIsNotNull() {
            addCriterion("RESULT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andResultFlagEqualTo(String value) {
            addCriterion("RESULT_FLAG =", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotEqualTo(String value) {
            addCriterion("RESULT_FLAG <>", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagGreaterThan(String value) {
            addCriterion("RESULT_FLAG >", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT_FLAG >=", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagLessThan(String value) {
            addCriterion("RESULT_FLAG <", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagLessThanOrEqualTo(String value) {
            addCriterion("RESULT_FLAG <=", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagLike(String value) {
            addCriterion("RESULT_FLAG like", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotLike(String value) {
            addCriterion("RESULT_FLAG not like", value, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagIn(List<String> values) {
            addCriterion("RESULT_FLAG in", values, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotIn(List<String> values) {
            addCriterion("RESULT_FLAG not in", values, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagBetween(String value1, String value2) {
            addCriterion("RESULT_FLAG between", value1, value2, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andResultFlagNotBetween(String value1, String value2) {
            addCriterion("RESULT_FLAG not between", value1, value2, "resultFlag");
            return (Criteria) this;
        }

        public Criteria andTlrseqIsNull() {
            addCriterion("TLRSEQ is null");
            return (Criteria) this;
        }

        public Criteria andTlrseqIsNotNull() {
            addCriterion("TLRSEQ is not null");
            return (Criteria) this;
        }

        public Criteria andTlrseqEqualTo(String value) {
            addCriterion("TLRSEQ =", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqNotEqualTo(String value) {
            addCriterion("TLRSEQ <>", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqGreaterThan(String value) {
            addCriterion("TLRSEQ >", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqGreaterThanOrEqualTo(String value) {
            addCriterion("TLRSEQ >=", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqLessThan(String value) {
            addCriterion("TLRSEQ <", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqLessThanOrEqualTo(String value) {
            addCriterion("TLRSEQ <=", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqLike(String value) {
            addCriterion("TLRSEQ like", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqNotLike(String value) {
            addCriterion("TLRSEQ not like", value, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqIn(List<String> values) {
            addCriterion("TLRSEQ in", values, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqNotIn(List<String> values) {
            addCriterion("TLRSEQ not in", values, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqBetween(String value1, String value2) {
            addCriterion("TLRSEQ between", value1, value2, "tlrseq");
            return (Criteria) this;
        }

        public Criteria andTlrseqNotBetween(String value1, String value2) {
            addCriterion("TLRSEQ not between", value1, value2, "tlrseq");
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