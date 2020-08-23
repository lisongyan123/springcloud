package com.bank.irce.ltgj.entity;

import java.util.ArrayList;
import java.util.List;

public class AirmLtgjModelLtdsjInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AirmLtgjModelLtdsjInfoExample() {
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

        public Criteria andModel1IsNull() {
            addCriterion("MODEL1 is null");
            return (Criteria) this;
        }

        public Criteria andModel1IsNotNull() {
            addCriterion("MODEL1 is not null");
            return (Criteria) this;
        }

        public Criteria andModel1EqualTo(String value) {
            addCriterion("MODEL1 =", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1NotEqualTo(String value) {
            addCriterion("MODEL1 <>", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1GreaterThan(String value) {
            addCriterion("MODEL1 >", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL1 >=", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1LessThan(String value) {
            addCriterion("MODEL1 <", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1LessThanOrEqualTo(String value) {
            addCriterion("MODEL1 <=", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1Like(String value) {
            addCriterion("MODEL1 like", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1NotLike(String value) {
            addCriterion("MODEL1 not like", value, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1In(List<String> values) {
            addCriterion("MODEL1 in", values, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1NotIn(List<String> values) {
            addCriterion("MODEL1 not in", values, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1Between(String value1, String value2) {
            addCriterion("MODEL1 between", value1, value2, "model1");
            return (Criteria) this;
        }

        public Criteria andModel1NotBetween(String value1, String value2) {
            addCriterion("MODEL1 not between", value1, value2, "model1");
            return (Criteria) this;
        }

        public Criteria andModel2IsNull() {
            addCriterion("MODEL2 is null");
            return (Criteria) this;
        }

        public Criteria andModel2IsNotNull() {
            addCriterion("MODEL2 is not null");
            return (Criteria) this;
        }

        public Criteria andModel2EqualTo(String value) {
            addCriterion("MODEL2 =", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2NotEqualTo(String value) {
            addCriterion("MODEL2 <>", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2GreaterThan(String value) {
            addCriterion("MODEL2 >", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL2 >=", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2LessThan(String value) {
            addCriterion("MODEL2 <", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2LessThanOrEqualTo(String value) {
            addCriterion("MODEL2 <=", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2Like(String value) {
            addCriterion("MODEL2 like", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2NotLike(String value) {
            addCriterion("MODEL2 not like", value, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2In(List<String> values) {
            addCriterion("MODEL2 in", values, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2NotIn(List<String> values) {
            addCriterion("MODEL2 not in", values, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2Between(String value1, String value2) {
            addCriterion("MODEL2 between", value1, value2, "model2");
            return (Criteria) this;
        }

        public Criteria andModel2NotBetween(String value1, String value2) {
            addCriterion("MODEL2 not between", value1, value2, "model2");
            return (Criteria) this;
        }

        public Criteria andModel3IsNull() {
            addCriterion("MODEL3 is null");
            return (Criteria) this;
        }

        public Criteria andModel3IsNotNull() {
            addCriterion("MODEL3 is not null");
            return (Criteria) this;
        }

        public Criteria andModel3EqualTo(String value) {
            addCriterion("MODEL3 =", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3NotEqualTo(String value) {
            addCriterion("MODEL3 <>", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3GreaterThan(String value) {
            addCriterion("MODEL3 >", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL3 >=", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3LessThan(String value) {
            addCriterion("MODEL3 <", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3LessThanOrEqualTo(String value) {
            addCriterion("MODEL3 <=", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3Like(String value) {
            addCriterion("MODEL3 like", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3NotLike(String value) {
            addCriterion("MODEL3 not like", value, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3In(List<String> values) {
            addCriterion("MODEL3 in", values, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3NotIn(List<String> values) {
            addCriterion("MODEL3 not in", values, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3Between(String value1, String value2) {
            addCriterion("MODEL3 between", value1, value2, "model3");
            return (Criteria) this;
        }

        public Criteria andModel3NotBetween(String value1, String value2) {
            addCriterion("MODEL3 not between", value1, value2, "model3");
            return (Criteria) this;
        }

        public Criteria andModel4IsNull() {
            addCriterion("MODEL4 is null");
            return (Criteria) this;
        }

        public Criteria andModel4IsNotNull() {
            addCriterion("MODEL4 is not null");
            return (Criteria) this;
        }

        public Criteria andModel4EqualTo(String value) {
            addCriterion("MODEL4 =", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4NotEqualTo(String value) {
            addCriterion("MODEL4 <>", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4GreaterThan(String value) {
            addCriterion("MODEL4 >", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL4 >=", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4LessThan(String value) {
            addCriterion("MODEL4 <", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4LessThanOrEqualTo(String value) {
            addCriterion("MODEL4 <=", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4Like(String value) {
            addCriterion("MODEL4 like", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4NotLike(String value) {
            addCriterion("MODEL4 not like", value, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4In(List<String> values) {
            addCriterion("MODEL4 in", values, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4NotIn(List<String> values) {
            addCriterion("MODEL4 not in", values, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4Between(String value1, String value2) {
            addCriterion("MODEL4 between", value1, value2, "model4");
            return (Criteria) this;
        }

        public Criteria andModel4NotBetween(String value1, String value2) {
            addCriterion("MODEL4 not between", value1, value2, "model4");
            return (Criteria) this;
        }

        public Criteria andModel5IsNull() {
            addCriterion("MODEL5 is null");
            return (Criteria) this;
        }

        public Criteria andModel5IsNotNull() {
            addCriterion("MODEL5 is not null");
            return (Criteria) this;
        }

        public Criteria andModel5EqualTo(String value) {
            addCriterion("MODEL5 =", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5NotEqualTo(String value) {
            addCriterion("MODEL5 <>", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5GreaterThan(String value) {
            addCriterion("MODEL5 >", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL5 >=", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5LessThan(String value) {
            addCriterion("MODEL5 <", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5LessThanOrEqualTo(String value) {
            addCriterion("MODEL5 <=", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5Like(String value) {
            addCriterion("MODEL5 like", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5NotLike(String value) {
            addCriterion("MODEL5 not like", value, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5In(List<String> values) {
            addCriterion("MODEL5 in", values, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5NotIn(List<String> values) {
            addCriterion("MODEL5 not in", values, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5Between(String value1, String value2) {
            addCriterion("MODEL5 between", value1, value2, "model5");
            return (Criteria) this;
        }

        public Criteria andModel5NotBetween(String value1, String value2) {
            addCriterion("MODEL5 not between", value1, value2, "model5");
            return (Criteria) this;
        }

        public Criteria andModel6IsNull() {
            addCriterion("MODEL6 is null");
            return (Criteria) this;
        }

        public Criteria andModel6IsNotNull() {
            addCriterion("MODEL6 is not null");
            return (Criteria) this;
        }

        public Criteria andModel6EqualTo(String value) {
            addCriterion("MODEL6 =", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6NotEqualTo(String value) {
            addCriterion("MODEL6 <>", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6GreaterThan(String value) {
            addCriterion("MODEL6 >", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL6 >=", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6LessThan(String value) {
            addCriterion("MODEL6 <", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6LessThanOrEqualTo(String value) {
            addCriterion("MODEL6 <=", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6Like(String value) {
            addCriterion("MODEL6 like", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6NotLike(String value) {
            addCriterion("MODEL6 not like", value, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6In(List<String> values) {
            addCriterion("MODEL6 in", values, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6NotIn(List<String> values) {
            addCriterion("MODEL6 not in", values, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6Between(String value1, String value2) {
            addCriterion("MODEL6 between", value1, value2, "model6");
            return (Criteria) this;
        }

        public Criteria andModel6NotBetween(String value1, String value2) {
            addCriterion("MODEL6 not between", value1, value2, "model6");
            return (Criteria) this;
        }

        public Criteria andModel7IsNull() {
            addCriterion("MODEL7 is null");
            return (Criteria) this;
        }

        public Criteria andModel7IsNotNull() {
            addCriterion("MODEL7 is not null");
            return (Criteria) this;
        }

        public Criteria andModel7EqualTo(String value) {
            addCriterion("MODEL7 =", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7NotEqualTo(String value) {
            addCriterion("MODEL7 <>", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7GreaterThan(String value) {
            addCriterion("MODEL7 >", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL7 >=", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7LessThan(String value) {
            addCriterion("MODEL7 <", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7LessThanOrEqualTo(String value) {
            addCriterion("MODEL7 <=", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7Like(String value) {
            addCriterion("MODEL7 like", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7NotLike(String value) {
            addCriterion("MODEL7 not like", value, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7In(List<String> values) {
            addCriterion("MODEL7 in", values, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7NotIn(List<String> values) {
            addCriterion("MODEL7 not in", values, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7Between(String value1, String value2) {
            addCriterion("MODEL7 between", value1, value2, "model7");
            return (Criteria) this;
        }

        public Criteria andModel7NotBetween(String value1, String value2) {
            addCriterion("MODEL7 not between", value1, value2, "model7");
            return (Criteria) this;
        }

        public Criteria andModel8IsNull() {
            addCriterion("MODEL8 is null");
            return (Criteria) this;
        }

        public Criteria andModel8IsNotNull() {
            addCriterion("MODEL8 is not null");
            return (Criteria) this;
        }

        public Criteria andModel8EqualTo(String value) {
            addCriterion("MODEL8 =", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8NotEqualTo(String value) {
            addCriterion("MODEL8 <>", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8GreaterThan(String value) {
            addCriterion("MODEL8 >", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL8 >=", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8LessThan(String value) {
            addCriterion("MODEL8 <", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8LessThanOrEqualTo(String value) {
            addCriterion("MODEL8 <=", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8Like(String value) {
            addCriterion("MODEL8 like", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8NotLike(String value) {
            addCriterion("MODEL8 not like", value, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8In(List<String> values) {
            addCriterion("MODEL8 in", values, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8NotIn(List<String> values) {
            addCriterion("MODEL8 not in", values, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8Between(String value1, String value2) {
            addCriterion("MODEL8 between", value1, value2, "model8");
            return (Criteria) this;
        }

        public Criteria andModel8NotBetween(String value1, String value2) {
            addCriterion("MODEL8 not between", value1, value2, "model8");
            return (Criteria) this;
        }

        public Criteria andModel9IsNull() {
            addCriterion("MODEL9 is null");
            return (Criteria) this;
        }

        public Criteria andModel9IsNotNull() {
            addCriterion("MODEL9 is not null");
            return (Criteria) this;
        }

        public Criteria andModel9EqualTo(String value) {
            addCriterion("MODEL9 =", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9NotEqualTo(String value) {
            addCriterion("MODEL9 <>", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9GreaterThan(String value) {
            addCriterion("MODEL9 >", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL9 >=", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9LessThan(String value) {
            addCriterion("MODEL9 <", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9LessThanOrEqualTo(String value) {
            addCriterion("MODEL9 <=", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9Like(String value) {
            addCriterion("MODEL9 like", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9NotLike(String value) {
            addCriterion("MODEL9 not like", value, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9In(List<String> values) {
            addCriterion("MODEL9 in", values, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9NotIn(List<String> values) {
            addCriterion("MODEL9 not in", values, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9Between(String value1, String value2) {
            addCriterion("MODEL9 between", value1, value2, "model9");
            return (Criteria) this;
        }

        public Criteria andModel9NotBetween(String value1, String value2) {
            addCriterion("MODEL9 not between", value1, value2, "model9");
            return (Criteria) this;
        }

        public Criteria andModel10IsNull() {
            addCriterion("MODEL10 is null");
            return (Criteria) this;
        }

        public Criteria andModel10IsNotNull() {
            addCriterion("MODEL10 is not null");
            return (Criteria) this;
        }

        public Criteria andModel10EqualTo(String value) {
            addCriterion("MODEL10 =", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10NotEqualTo(String value) {
            addCriterion("MODEL10 <>", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10GreaterThan(String value) {
            addCriterion("MODEL10 >", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL10 >=", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10LessThan(String value) {
            addCriterion("MODEL10 <", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10LessThanOrEqualTo(String value) {
            addCriterion("MODEL10 <=", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10Like(String value) {
            addCriterion("MODEL10 like", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10NotLike(String value) {
            addCriterion("MODEL10 not like", value, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10In(List<String> values) {
            addCriterion("MODEL10 in", values, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10NotIn(List<String> values) {
            addCriterion("MODEL10 not in", values, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10Between(String value1, String value2) {
            addCriterion("MODEL10 between", value1, value2, "model10");
            return (Criteria) this;
        }

        public Criteria andModel10NotBetween(String value1, String value2) {
            addCriterion("MODEL10 not between", value1, value2, "model10");
            return (Criteria) this;
        }

        public Criteria andModel11IsNull() {
            addCriterion("MODEL11 is null");
            return (Criteria) this;
        }

        public Criteria andModel11IsNotNull() {
            addCriterion("MODEL11 is not null");
            return (Criteria) this;
        }

        public Criteria andModel11EqualTo(String value) {
            addCriterion("MODEL11 =", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11NotEqualTo(String value) {
            addCriterion("MODEL11 <>", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11GreaterThan(String value) {
            addCriterion("MODEL11 >", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL11 >=", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11LessThan(String value) {
            addCriterion("MODEL11 <", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11LessThanOrEqualTo(String value) {
            addCriterion("MODEL11 <=", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11Like(String value) {
            addCriterion("MODEL11 like", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11NotLike(String value) {
            addCriterion("MODEL11 not like", value, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11In(List<String> values) {
            addCriterion("MODEL11 in", values, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11NotIn(List<String> values) {
            addCriterion("MODEL11 not in", values, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11Between(String value1, String value2) {
            addCriterion("MODEL11 between", value1, value2, "model11");
            return (Criteria) this;
        }

        public Criteria andModel11NotBetween(String value1, String value2) {
            addCriterion("MODEL11 not between", value1, value2, "model11");
            return (Criteria) this;
        }

        public Criteria andModel12IsNull() {
            addCriterion("MODEL12 is null");
            return (Criteria) this;
        }

        public Criteria andModel12IsNotNull() {
            addCriterion("MODEL12 is not null");
            return (Criteria) this;
        }

        public Criteria andModel12EqualTo(String value) {
            addCriterion("MODEL12 =", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12NotEqualTo(String value) {
            addCriterion("MODEL12 <>", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12GreaterThan(String value) {
            addCriterion("MODEL12 >", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL12 >=", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12LessThan(String value) {
            addCriterion("MODEL12 <", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12LessThanOrEqualTo(String value) {
            addCriterion("MODEL12 <=", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12Like(String value) {
            addCriterion("MODEL12 like", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12NotLike(String value) {
            addCriterion("MODEL12 not like", value, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12In(List<String> values) {
            addCriterion("MODEL12 in", values, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12NotIn(List<String> values) {
            addCriterion("MODEL12 not in", values, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12Between(String value1, String value2) {
            addCriterion("MODEL12 between", value1, value2, "model12");
            return (Criteria) this;
        }

        public Criteria andModel12NotBetween(String value1, String value2) {
            addCriterion("MODEL12 not between", value1, value2, "model12");
            return (Criteria) this;
        }

        public Criteria andModel13IsNull() {
            addCriterion("MODEL13 is null");
            return (Criteria) this;
        }

        public Criteria andModel13IsNotNull() {
            addCriterion("MODEL13 is not null");
            return (Criteria) this;
        }

        public Criteria andModel13EqualTo(String value) {
            addCriterion("MODEL13 =", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13NotEqualTo(String value) {
            addCriterion("MODEL13 <>", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13GreaterThan(String value) {
            addCriterion("MODEL13 >", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL13 >=", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13LessThan(String value) {
            addCriterion("MODEL13 <", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13LessThanOrEqualTo(String value) {
            addCriterion("MODEL13 <=", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13Like(String value) {
            addCriterion("MODEL13 like", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13NotLike(String value) {
            addCriterion("MODEL13 not like", value, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13In(List<String> values) {
            addCriterion("MODEL13 in", values, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13NotIn(List<String> values) {
            addCriterion("MODEL13 not in", values, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13Between(String value1, String value2) {
            addCriterion("MODEL13 between", value1, value2, "model13");
            return (Criteria) this;
        }

        public Criteria andModel13NotBetween(String value1, String value2) {
            addCriterion("MODEL13 not between", value1, value2, "model13");
            return (Criteria) this;
        }

        public Criteria andModel14IsNull() {
            addCriterion("MODEL14 is null");
            return (Criteria) this;
        }

        public Criteria andModel14IsNotNull() {
            addCriterion("MODEL14 is not null");
            return (Criteria) this;
        }

        public Criteria andModel14EqualTo(String value) {
            addCriterion("MODEL14 =", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14NotEqualTo(String value) {
            addCriterion("MODEL14 <>", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14GreaterThan(String value) {
            addCriterion("MODEL14 >", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL14 >=", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14LessThan(String value) {
            addCriterion("MODEL14 <", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14LessThanOrEqualTo(String value) {
            addCriterion("MODEL14 <=", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14Like(String value) {
            addCriterion("MODEL14 like", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14NotLike(String value) {
            addCriterion("MODEL14 not like", value, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14In(List<String> values) {
            addCriterion("MODEL14 in", values, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14NotIn(List<String> values) {
            addCriterion("MODEL14 not in", values, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14Between(String value1, String value2) {
            addCriterion("MODEL14 between", value1, value2, "model14");
            return (Criteria) this;
        }

        public Criteria andModel14NotBetween(String value1, String value2) {
            addCriterion("MODEL14 not between", value1, value2, "model14");
            return (Criteria) this;
        }

        public Criteria andModel15IsNull() {
            addCriterion("MODEL15 is null");
            return (Criteria) this;
        }

        public Criteria andModel15IsNotNull() {
            addCriterion("MODEL15 is not null");
            return (Criteria) this;
        }

        public Criteria andModel15EqualTo(String value) {
            addCriterion("MODEL15 =", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15NotEqualTo(String value) {
            addCriterion("MODEL15 <>", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15GreaterThan(String value) {
            addCriterion("MODEL15 >", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL15 >=", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15LessThan(String value) {
            addCriterion("MODEL15 <", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15LessThanOrEqualTo(String value) {
            addCriterion("MODEL15 <=", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15Like(String value) {
            addCriterion("MODEL15 like", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15NotLike(String value) {
            addCriterion("MODEL15 not like", value, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15In(List<String> values) {
            addCriterion("MODEL15 in", values, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15NotIn(List<String> values) {
            addCriterion("MODEL15 not in", values, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15Between(String value1, String value2) {
            addCriterion("MODEL15 between", value1, value2, "model15");
            return (Criteria) this;
        }

        public Criteria andModel15NotBetween(String value1, String value2) {
            addCriterion("MODEL15 not between", value1, value2, "model15");
            return (Criteria) this;
        }

        public Criteria andModel16IsNull() {
            addCriterion("MODEL16 is null");
            return (Criteria) this;
        }

        public Criteria andModel16IsNotNull() {
            addCriterion("MODEL16 is not null");
            return (Criteria) this;
        }

        public Criteria andModel16EqualTo(String value) {
            addCriterion("MODEL16 =", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16NotEqualTo(String value) {
            addCriterion("MODEL16 <>", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16GreaterThan(String value) {
            addCriterion("MODEL16 >", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL16 >=", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16LessThan(String value) {
            addCriterion("MODEL16 <", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16LessThanOrEqualTo(String value) {
            addCriterion("MODEL16 <=", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16Like(String value) {
            addCriterion("MODEL16 like", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16NotLike(String value) {
            addCriterion("MODEL16 not like", value, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16In(List<String> values) {
            addCriterion("MODEL16 in", values, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16NotIn(List<String> values) {
            addCriterion("MODEL16 not in", values, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16Between(String value1, String value2) {
            addCriterion("MODEL16 between", value1, value2, "model16");
            return (Criteria) this;
        }

        public Criteria andModel16NotBetween(String value1, String value2) {
            addCriterion("MODEL16 not between", value1, value2, "model16");
            return (Criteria) this;
        }

        public Criteria andModel17IsNull() {
            addCriterion("MODEL17 is null");
            return (Criteria) this;
        }

        public Criteria andModel17IsNotNull() {
            addCriterion("MODEL17 is not null");
            return (Criteria) this;
        }

        public Criteria andModel17EqualTo(String value) {
            addCriterion("MODEL17 =", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17NotEqualTo(String value) {
            addCriterion("MODEL17 <>", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17GreaterThan(String value) {
            addCriterion("MODEL17 >", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL17 >=", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17LessThan(String value) {
            addCriterion("MODEL17 <", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17LessThanOrEqualTo(String value) {
            addCriterion("MODEL17 <=", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17Like(String value) {
            addCriterion("MODEL17 like", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17NotLike(String value) {
            addCriterion("MODEL17 not like", value, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17In(List<String> values) {
            addCriterion("MODEL17 in", values, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17NotIn(List<String> values) {
            addCriterion("MODEL17 not in", values, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17Between(String value1, String value2) {
            addCriterion("MODEL17 between", value1, value2, "model17");
            return (Criteria) this;
        }

        public Criteria andModel17NotBetween(String value1, String value2) {
            addCriterion("MODEL17 not between", value1, value2, "model17");
            return (Criteria) this;
        }

        public Criteria andModel18IsNull() {
            addCriterion("MODEL18 is null");
            return (Criteria) this;
        }

        public Criteria andModel18IsNotNull() {
            addCriterion("MODEL18 is not null");
            return (Criteria) this;
        }

        public Criteria andModel18EqualTo(String value) {
            addCriterion("MODEL18 =", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18NotEqualTo(String value) {
            addCriterion("MODEL18 <>", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18GreaterThan(String value) {
            addCriterion("MODEL18 >", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL18 >=", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18LessThan(String value) {
            addCriterion("MODEL18 <", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18LessThanOrEqualTo(String value) {
            addCriterion("MODEL18 <=", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18Like(String value) {
            addCriterion("MODEL18 like", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18NotLike(String value) {
            addCriterion("MODEL18 not like", value, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18In(List<String> values) {
            addCriterion("MODEL18 in", values, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18NotIn(List<String> values) {
            addCriterion("MODEL18 not in", values, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18Between(String value1, String value2) {
            addCriterion("MODEL18 between", value1, value2, "model18");
            return (Criteria) this;
        }

        public Criteria andModel18NotBetween(String value1, String value2) {
            addCriterion("MODEL18 not between", value1, value2, "model18");
            return (Criteria) this;
        }

        public Criteria andModel19IsNull() {
            addCriterion("MODEL19 is null");
            return (Criteria) this;
        }

        public Criteria andModel19IsNotNull() {
            addCriterion("MODEL19 is not null");
            return (Criteria) this;
        }

        public Criteria andModel19EqualTo(String value) {
            addCriterion("MODEL19 =", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19NotEqualTo(String value) {
            addCriterion("MODEL19 <>", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19GreaterThan(String value) {
            addCriterion("MODEL19 >", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL19 >=", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19LessThan(String value) {
            addCriterion("MODEL19 <", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19LessThanOrEqualTo(String value) {
            addCriterion("MODEL19 <=", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19Like(String value) {
            addCriterion("MODEL19 like", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19NotLike(String value) {
            addCriterion("MODEL19 not like", value, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19In(List<String> values) {
            addCriterion("MODEL19 in", values, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19NotIn(List<String> values) {
            addCriterion("MODEL19 not in", values, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19Between(String value1, String value2) {
            addCriterion("MODEL19 between", value1, value2, "model19");
            return (Criteria) this;
        }

        public Criteria andModel19NotBetween(String value1, String value2) {
            addCriterion("MODEL19 not between", value1, value2, "model19");
            return (Criteria) this;
        }

        public Criteria andModel20IsNull() {
            addCriterion("MODEL20 is null");
            return (Criteria) this;
        }

        public Criteria andModel20IsNotNull() {
            addCriterion("MODEL20 is not null");
            return (Criteria) this;
        }

        public Criteria andModel20EqualTo(String value) {
            addCriterion("MODEL20 =", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20NotEqualTo(String value) {
            addCriterion("MODEL20 <>", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20GreaterThan(String value) {
            addCriterion("MODEL20 >", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL20 >=", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20LessThan(String value) {
            addCriterion("MODEL20 <", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20LessThanOrEqualTo(String value) {
            addCriterion("MODEL20 <=", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20Like(String value) {
            addCriterion("MODEL20 like", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20NotLike(String value) {
            addCriterion("MODEL20 not like", value, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20In(List<String> values) {
            addCriterion("MODEL20 in", values, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20NotIn(List<String> values) {
            addCriterion("MODEL20 not in", values, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20Between(String value1, String value2) {
            addCriterion("MODEL20 between", value1, value2, "model20");
            return (Criteria) this;
        }

        public Criteria andModel20NotBetween(String value1, String value2) {
            addCriterion("MODEL20 not between", value1, value2, "model20");
            return (Criteria) this;
        }

        public Criteria andModel21IsNull() {
            addCriterion("MODEL21 is null");
            return (Criteria) this;
        }

        public Criteria andModel21IsNotNull() {
            addCriterion("MODEL21 is not null");
            return (Criteria) this;
        }

        public Criteria andModel21EqualTo(String value) {
            addCriterion("MODEL21 =", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21NotEqualTo(String value) {
            addCriterion("MODEL21 <>", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21GreaterThan(String value) {
            addCriterion("MODEL21 >", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL21 >=", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21LessThan(String value) {
            addCriterion("MODEL21 <", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21LessThanOrEqualTo(String value) {
            addCriterion("MODEL21 <=", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21Like(String value) {
            addCriterion("MODEL21 like", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21NotLike(String value) {
            addCriterion("MODEL21 not like", value, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21In(List<String> values) {
            addCriterion("MODEL21 in", values, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21NotIn(List<String> values) {
            addCriterion("MODEL21 not in", values, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21Between(String value1, String value2) {
            addCriterion("MODEL21 between", value1, value2, "model21");
            return (Criteria) this;
        }

        public Criteria andModel21NotBetween(String value1, String value2) {
            addCriterion("MODEL21 not between", value1, value2, "model21");
            return (Criteria) this;
        }

        public Criteria andModel22IsNull() {
            addCriterion("MODEL22 is null");
            return (Criteria) this;
        }

        public Criteria andModel22IsNotNull() {
            addCriterion("MODEL22 is not null");
            return (Criteria) this;
        }

        public Criteria andModel22EqualTo(String value) {
            addCriterion("MODEL22 =", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22NotEqualTo(String value) {
            addCriterion("MODEL22 <>", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22GreaterThan(String value) {
            addCriterion("MODEL22 >", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL22 >=", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22LessThan(String value) {
            addCriterion("MODEL22 <", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22LessThanOrEqualTo(String value) {
            addCriterion("MODEL22 <=", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22Like(String value) {
            addCriterion("MODEL22 like", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22NotLike(String value) {
            addCriterion("MODEL22 not like", value, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22In(List<String> values) {
            addCriterion("MODEL22 in", values, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22NotIn(List<String> values) {
            addCriterion("MODEL22 not in", values, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22Between(String value1, String value2) {
            addCriterion("MODEL22 between", value1, value2, "model22");
            return (Criteria) this;
        }

        public Criteria andModel22NotBetween(String value1, String value2) {
            addCriterion("MODEL22 not between", value1, value2, "model22");
            return (Criteria) this;
        }

        public Criteria andModel23IsNull() {
            addCriterion("MODEL23 is null");
            return (Criteria) this;
        }

        public Criteria andModel23IsNotNull() {
            addCriterion("MODEL23 is not null");
            return (Criteria) this;
        }

        public Criteria andModel23EqualTo(String value) {
            addCriterion("MODEL23 =", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23NotEqualTo(String value) {
            addCriterion("MODEL23 <>", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23GreaterThan(String value) {
            addCriterion("MODEL23 >", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL23 >=", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23LessThan(String value) {
            addCriterion("MODEL23 <", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23LessThanOrEqualTo(String value) {
            addCriterion("MODEL23 <=", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23Like(String value) {
            addCriterion("MODEL23 like", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23NotLike(String value) {
            addCriterion("MODEL23 not like", value, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23In(List<String> values) {
            addCriterion("MODEL23 in", values, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23NotIn(List<String> values) {
            addCriterion("MODEL23 not in", values, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23Between(String value1, String value2) {
            addCriterion("MODEL23 between", value1, value2, "model23");
            return (Criteria) this;
        }

        public Criteria andModel23NotBetween(String value1, String value2) {
            addCriterion("MODEL23 not between", value1, value2, "model23");
            return (Criteria) this;
        }

        public Criteria andModel24IsNull() {
            addCriterion("MODEL24 is null");
            return (Criteria) this;
        }

        public Criteria andModel24IsNotNull() {
            addCriterion("MODEL24 is not null");
            return (Criteria) this;
        }

        public Criteria andModel24EqualTo(String value) {
            addCriterion("MODEL24 =", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24NotEqualTo(String value) {
            addCriterion("MODEL24 <>", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24GreaterThan(String value) {
            addCriterion("MODEL24 >", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL24 >=", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24LessThan(String value) {
            addCriterion("MODEL24 <", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24LessThanOrEqualTo(String value) {
            addCriterion("MODEL24 <=", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24Like(String value) {
            addCriterion("MODEL24 like", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24NotLike(String value) {
            addCriterion("MODEL24 not like", value, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24In(List<String> values) {
            addCriterion("MODEL24 in", values, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24NotIn(List<String> values) {
            addCriterion("MODEL24 not in", values, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24Between(String value1, String value2) {
            addCriterion("MODEL24 between", value1, value2, "model24");
            return (Criteria) this;
        }

        public Criteria andModel24NotBetween(String value1, String value2) {
            addCriterion("MODEL24 not between", value1, value2, "model24");
            return (Criteria) this;
        }

        public Criteria andModel25IsNull() {
            addCriterion("MODEL25 is null");
            return (Criteria) this;
        }

        public Criteria andModel25IsNotNull() {
            addCriterion("MODEL25 is not null");
            return (Criteria) this;
        }

        public Criteria andModel25EqualTo(String value) {
            addCriterion("MODEL25 =", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25NotEqualTo(String value) {
            addCriterion("MODEL25 <>", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25GreaterThan(String value) {
            addCriterion("MODEL25 >", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL25 >=", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25LessThan(String value) {
            addCriterion("MODEL25 <", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25LessThanOrEqualTo(String value) {
            addCriterion("MODEL25 <=", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25Like(String value) {
            addCriterion("MODEL25 like", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25NotLike(String value) {
            addCriterion("MODEL25 not like", value, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25In(List<String> values) {
            addCriterion("MODEL25 in", values, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25NotIn(List<String> values) {
            addCriterion("MODEL25 not in", values, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25Between(String value1, String value2) {
            addCriterion("MODEL25 between", value1, value2, "model25");
            return (Criteria) this;
        }

        public Criteria andModel25NotBetween(String value1, String value2) {
            addCriterion("MODEL25 not between", value1, value2, "model25");
            return (Criteria) this;
        }

        public Criteria andModel26IsNull() {
            addCriterion("MODEL26 is null");
            return (Criteria) this;
        }

        public Criteria andModel26IsNotNull() {
            addCriterion("MODEL26 is not null");
            return (Criteria) this;
        }

        public Criteria andModel26EqualTo(String value) {
            addCriterion("MODEL26 =", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26NotEqualTo(String value) {
            addCriterion("MODEL26 <>", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26GreaterThan(String value) {
            addCriterion("MODEL26 >", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL26 >=", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26LessThan(String value) {
            addCriterion("MODEL26 <", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26LessThanOrEqualTo(String value) {
            addCriterion("MODEL26 <=", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26Like(String value) {
            addCriterion("MODEL26 like", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26NotLike(String value) {
            addCriterion("MODEL26 not like", value, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26In(List<String> values) {
            addCriterion("MODEL26 in", values, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26NotIn(List<String> values) {
            addCriterion("MODEL26 not in", values, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26Between(String value1, String value2) {
            addCriterion("MODEL26 between", value1, value2, "model26");
            return (Criteria) this;
        }

        public Criteria andModel26NotBetween(String value1, String value2) {
            addCriterion("MODEL26 not between", value1, value2, "model26");
            return (Criteria) this;
        }

        public Criteria andModel27IsNull() {
            addCriterion("MODEL27 is null");
            return (Criteria) this;
        }

        public Criteria andModel27IsNotNull() {
            addCriterion("MODEL27 is not null");
            return (Criteria) this;
        }

        public Criteria andModel27EqualTo(String value) {
            addCriterion("MODEL27 =", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27NotEqualTo(String value) {
            addCriterion("MODEL27 <>", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27GreaterThan(String value) {
            addCriterion("MODEL27 >", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL27 >=", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27LessThan(String value) {
            addCriterion("MODEL27 <", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27LessThanOrEqualTo(String value) {
            addCriterion("MODEL27 <=", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27Like(String value) {
            addCriterion("MODEL27 like", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27NotLike(String value) {
            addCriterion("MODEL27 not like", value, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27In(List<String> values) {
            addCriterion("MODEL27 in", values, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27NotIn(List<String> values) {
            addCriterion("MODEL27 not in", values, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27Between(String value1, String value2) {
            addCriterion("MODEL27 between", value1, value2, "model27");
            return (Criteria) this;
        }

        public Criteria andModel27NotBetween(String value1, String value2) {
            addCriterion("MODEL27 not between", value1, value2, "model27");
            return (Criteria) this;
        }

        public Criteria andModel28IsNull() {
            addCriterion("MODEL28 is null");
            return (Criteria) this;
        }

        public Criteria andModel28IsNotNull() {
            addCriterion("MODEL28 is not null");
            return (Criteria) this;
        }

        public Criteria andModel28EqualTo(String value) {
            addCriterion("MODEL28 =", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28NotEqualTo(String value) {
            addCriterion("MODEL28 <>", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28GreaterThan(String value) {
            addCriterion("MODEL28 >", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL28 >=", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28LessThan(String value) {
            addCriterion("MODEL28 <", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28LessThanOrEqualTo(String value) {
            addCriterion("MODEL28 <=", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28Like(String value) {
            addCriterion("MODEL28 like", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28NotLike(String value) {
            addCriterion("MODEL28 not like", value, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28In(List<String> values) {
            addCriterion("MODEL28 in", values, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28NotIn(List<String> values) {
            addCriterion("MODEL28 not in", values, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28Between(String value1, String value2) {
            addCriterion("MODEL28 between", value1, value2, "model28");
            return (Criteria) this;
        }

        public Criteria andModel28NotBetween(String value1, String value2) {
            addCriterion("MODEL28 not between", value1, value2, "model28");
            return (Criteria) this;
        }

        public Criteria andModel29IsNull() {
            addCriterion("MODEL29 is null");
            return (Criteria) this;
        }

        public Criteria andModel29IsNotNull() {
            addCriterion("MODEL29 is not null");
            return (Criteria) this;
        }

        public Criteria andModel29EqualTo(String value) {
            addCriterion("MODEL29 =", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29NotEqualTo(String value) {
            addCriterion("MODEL29 <>", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29GreaterThan(String value) {
            addCriterion("MODEL29 >", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL29 >=", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29LessThan(String value) {
            addCriterion("MODEL29 <", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29LessThanOrEqualTo(String value) {
            addCriterion("MODEL29 <=", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29Like(String value) {
            addCriterion("MODEL29 like", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29NotLike(String value) {
            addCriterion("MODEL29 not like", value, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29In(List<String> values) {
            addCriterion("MODEL29 in", values, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29NotIn(List<String> values) {
            addCriterion("MODEL29 not in", values, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29Between(String value1, String value2) {
            addCriterion("MODEL29 between", value1, value2, "model29");
            return (Criteria) this;
        }

        public Criteria andModel29NotBetween(String value1, String value2) {
            addCriterion("MODEL29 not between", value1, value2, "model29");
            return (Criteria) this;
        }

        public Criteria andModel30IsNull() {
            addCriterion("MODEL30 is null");
            return (Criteria) this;
        }

        public Criteria andModel30IsNotNull() {
            addCriterion("MODEL30 is not null");
            return (Criteria) this;
        }

        public Criteria andModel30EqualTo(String value) {
            addCriterion("MODEL30 =", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30NotEqualTo(String value) {
            addCriterion("MODEL30 <>", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30GreaterThan(String value) {
            addCriterion("MODEL30 >", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30GreaterThanOrEqualTo(String value) {
            addCriterion("MODEL30 >=", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30LessThan(String value) {
            addCriterion("MODEL30 <", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30LessThanOrEqualTo(String value) {
            addCriterion("MODEL30 <=", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30Like(String value) {
            addCriterion("MODEL30 like", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30NotLike(String value) {
            addCriterion("MODEL30 not like", value, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30In(List<String> values) {
            addCriterion("MODEL30 in", values, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30NotIn(List<String> values) {
            addCriterion("MODEL30 not in", values, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30Between(String value1, String value2) {
            addCriterion("MODEL30 between", value1, value2, "model30");
            return (Criteria) this;
        }

        public Criteria andModel30NotBetween(String value1, String value2) {
            addCriterion("MODEL30 not between", value1, value2, "model30");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNull() {
            addCriterion("RESERVE1 is null");
            return (Criteria) this;
        }

        public Criteria andReserve1IsNotNull() {
            addCriterion("RESERVE1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve1EqualTo(String value) {
            addCriterion("RESERVE1 =", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotEqualTo(String value) {
            addCriterion("RESERVE1 <>", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThan(String value) {
            addCriterion("RESERVE1 >", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE1 >=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThan(String value) {
            addCriterion("RESERVE1 <", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1LessThanOrEqualTo(String value) {
            addCriterion("RESERVE1 <=", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Like(String value) {
            addCriterion("RESERVE1 like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotLike(String value) {
            addCriterion("RESERVE1 not like", value, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1In(List<String> values) {
            addCriterion("RESERVE1 in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotIn(List<String> values) {
            addCriterion("RESERVE1 not in", values, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1Between(String value1, String value2) {
            addCriterion("RESERVE1 between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve1NotBetween(String value1, String value2) {
            addCriterion("RESERVE1 not between", value1, value2, "reserve1");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNull() {
            addCriterion("RESERVE2 is null");
            return (Criteria) this;
        }

        public Criteria andReserve2IsNotNull() {
            addCriterion("RESERVE2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve2EqualTo(String value) {
            addCriterion("RESERVE2 =", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotEqualTo(String value) {
            addCriterion("RESERVE2 <>", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThan(String value) {
            addCriterion("RESERVE2 >", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE2 >=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThan(String value) {
            addCriterion("RESERVE2 <", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2LessThanOrEqualTo(String value) {
            addCriterion("RESERVE2 <=", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Like(String value) {
            addCriterion("RESERVE2 like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotLike(String value) {
            addCriterion("RESERVE2 not like", value, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2In(List<String> values) {
            addCriterion("RESERVE2 in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotIn(List<String> values) {
            addCriterion("RESERVE2 not in", values, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2Between(String value1, String value2) {
            addCriterion("RESERVE2 between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve2NotBetween(String value1, String value2) {
            addCriterion("RESERVE2 not between", value1, value2, "reserve2");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNull() {
            addCriterion("RESERVE3 is null");
            return (Criteria) this;
        }

        public Criteria andReserve3IsNotNull() {
            addCriterion("RESERVE3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve3EqualTo(String value) {
            addCriterion("RESERVE3 =", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotEqualTo(String value) {
            addCriterion("RESERVE3 <>", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThan(String value) {
            addCriterion("RESERVE3 >", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3GreaterThanOrEqualTo(String value) {
            addCriterion("RESERVE3 >=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThan(String value) {
            addCriterion("RESERVE3 <", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3LessThanOrEqualTo(String value) {
            addCriterion("RESERVE3 <=", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Like(String value) {
            addCriterion("RESERVE3 like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotLike(String value) {
            addCriterion("RESERVE3 not like", value, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3In(List<String> values) {
            addCriterion("RESERVE3 in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotIn(List<String> values) {
            addCriterion("RESERVE3 not in", values, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3Between(String value1, String value2) {
            addCriterion("RESERVE3 between", value1, value2, "reserve3");
            return (Criteria) this;
        }

        public Criteria andReserve3NotBetween(String value1, String value2) {
            addCriterion("RESERVE3 not between", value1, value2, "reserve3");
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