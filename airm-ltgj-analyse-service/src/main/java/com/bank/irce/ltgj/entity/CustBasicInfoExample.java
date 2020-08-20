package com.bank.irce.ltgj.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustBasicInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustBasicInfoExample() {
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

        public Criteria andIdenValidDtIsNull() {
            addCriterion("IDEN_VALID_DT is null");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtIsNotNull() {
            addCriterion("IDEN_VALID_DT is not null");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtEqualTo(String value) {
            addCriterion("IDEN_VALID_DT =", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtNotEqualTo(String value) {
            addCriterion("IDEN_VALID_DT <>", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtGreaterThan(String value) {
            addCriterion("IDEN_VALID_DT >", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtGreaterThanOrEqualTo(String value) {
            addCriterion("IDEN_VALID_DT >=", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtLessThan(String value) {
            addCriterion("IDEN_VALID_DT <", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtLessThanOrEqualTo(String value) {
            addCriterion("IDEN_VALID_DT <=", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtLike(String value) {
            addCriterion("IDEN_VALID_DT like", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtNotLike(String value) {
            addCriterion("IDEN_VALID_DT not like", value, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtIn(List<String> values) {
            addCriterion("IDEN_VALID_DT in", values, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtNotIn(List<String> values) {
            addCriterion("IDEN_VALID_DT not in", values, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtBetween(String value1, String value2) {
            addCriterion("IDEN_VALID_DT between", value1, value2, "idenValidDt");
            return (Criteria) this;
        }

        public Criteria andIdenValidDtNotBetween(String value1, String value2) {
            addCriterion("IDEN_VALID_DT not between", value1, value2, "idenValidDt");
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

        public Criteria andGenderCdIsNull() {
            addCriterion("GENDER_CD is null");
            return (Criteria) this;
        }

        public Criteria andGenderCdIsNotNull() {
            addCriterion("GENDER_CD is not null");
            return (Criteria) this;
        }

        public Criteria andGenderCdEqualTo(String value) {
            addCriterion("GENDER_CD =", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdNotEqualTo(String value) {
            addCriterion("GENDER_CD <>", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdGreaterThan(String value) {
            addCriterion("GENDER_CD >", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdGreaterThanOrEqualTo(String value) {
            addCriterion("GENDER_CD >=", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdLessThan(String value) {
            addCriterion("GENDER_CD <", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdLessThanOrEqualTo(String value) {
            addCriterion("GENDER_CD <=", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdLike(String value) {
            addCriterion("GENDER_CD like", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdNotLike(String value) {
            addCriterion("GENDER_CD not like", value, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdIn(List<String> values) {
            addCriterion("GENDER_CD in", values, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdNotIn(List<String> values) {
            addCriterion("GENDER_CD not in", values, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdBetween(String value1, String value2) {
            addCriterion("GENDER_CD between", value1, value2, "genderCd");
            return (Criteria) this;
        }

        public Criteria andGenderCdNotBetween(String value1, String value2) {
            addCriterion("GENDER_CD not between", value1, value2, "genderCd");
            return (Criteria) this;
        }

        public Criteria andBirthDtIsNull() {
            addCriterion("BIRTH_DT is null");
            return (Criteria) this;
        }

        public Criteria andBirthDtIsNotNull() {
            addCriterion("BIRTH_DT is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDtEqualTo(String value) {
            addCriterion("BIRTH_DT =", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtNotEqualTo(String value) {
            addCriterion("BIRTH_DT <>", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtGreaterThan(String value) {
            addCriterion("BIRTH_DT >", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTH_DT >=", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtLessThan(String value) {
            addCriterion("BIRTH_DT <", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtLessThanOrEqualTo(String value) {
            addCriterion("BIRTH_DT <=", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtLike(String value) {
            addCriterion("BIRTH_DT like", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtNotLike(String value) {
            addCriterion("BIRTH_DT not like", value, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtIn(List<String> values) {
            addCriterion("BIRTH_DT in", values, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtNotIn(List<String> values) {
            addCriterion("BIRTH_DT not in", values, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtBetween(String value1, String value2) {
            addCriterion("BIRTH_DT between", value1, value2, "birthDt");
            return (Criteria) this;
        }

        public Criteria andBirthDtNotBetween(String value1, String value2) {
            addCriterion("BIRTH_DT not between", value1, value2, "birthDt");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(BigDecimal value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(BigDecimal value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(BigDecimal value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(BigDecimal value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<BigDecimal> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<BigDecimal> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGE not between", value1, value2, "age");
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