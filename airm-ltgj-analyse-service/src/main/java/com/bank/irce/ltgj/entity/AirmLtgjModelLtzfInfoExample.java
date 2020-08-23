package com.bank.irce.ltgj.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AirmLtgjModelLtzfInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AirmLtgjModelLtzfInfoExample() {
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

        public Criteria andStoreIdIsNull() {
            addCriterion("STORE_ID is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("STORE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("STORE_ID =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("STORE_ID <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("STORE_ID >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_ID >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("STORE_ID <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("STORE_ID <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("STORE_ID like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("STORE_ID not like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<String> values) {
            addCriterion("STORE_ID in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<String> values) {
            addCriterion("STORE_ID not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("STORE_ID between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("STORE_ID not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("STORE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("STORE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("STORE_NAME =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("STORE_NAME <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("STORE_NAME >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_NAME >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("STORE_NAME <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("STORE_NAME <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("STORE_NAME like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("STORE_NAME not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("STORE_NAME in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("STORE_NAME not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("STORE_NAME between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("STORE_NAME not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeIsNull() {
            addCriterion("STORE_PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeIsNotNull() {
            addCriterion("STORE_PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeEqualTo(String value) {
            addCriterion("STORE_PROVINCE_CODE =", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeNotEqualTo(String value) {
            addCriterion("STORE_PROVINCE_CODE <>", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeGreaterThan(String value) {
            addCriterion("STORE_PROVINCE_CODE >", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_PROVINCE_CODE >=", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeLessThan(String value) {
            addCriterion("STORE_PROVINCE_CODE <", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("STORE_PROVINCE_CODE <=", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeLike(String value) {
            addCriterion("STORE_PROVINCE_CODE like", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeNotLike(String value) {
            addCriterion("STORE_PROVINCE_CODE not like", value, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeIn(List<String> values) {
            addCriterion("STORE_PROVINCE_CODE in", values, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeNotIn(List<String> values) {
            addCriterion("STORE_PROVINCE_CODE not in", values, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeBetween(String value1, String value2) {
            addCriterion("STORE_PROVINCE_CODE between", value1, value2, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("STORE_PROVINCE_CODE not between", value1, value2, "storeProvinceCode");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideIsNull() {
            addCriterion("STORE_CITY_CIDE is null");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideIsNotNull() {
            addCriterion("STORE_CITY_CIDE is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideEqualTo(String value) {
            addCriterion("STORE_CITY_CIDE =", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideNotEqualTo(String value) {
            addCriterion("STORE_CITY_CIDE <>", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideGreaterThan(String value) {
            addCriterion("STORE_CITY_CIDE >", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_CITY_CIDE >=", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideLessThan(String value) {
            addCriterion("STORE_CITY_CIDE <", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideLessThanOrEqualTo(String value) {
            addCriterion("STORE_CITY_CIDE <=", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideLike(String value) {
            addCriterion("STORE_CITY_CIDE like", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideNotLike(String value) {
            addCriterion("STORE_CITY_CIDE not like", value, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideIn(List<String> values) {
            addCriterion("STORE_CITY_CIDE in", values, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideNotIn(List<String> values) {
            addCriterion("STORE_CITY_CIDE not in", values, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideBetween(String value1, String value2) {
            addCriterion("STORE_CITY_CIDE between", value1, value2, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreCityCideNotBetween(String value1, String value2) {
            addCriterion("STORE_CITY_CIDE not between", value1, value2, "storeCityCide");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeIsNull() {
            addCriterion("STORE_ZONE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeIsNotNull() {
            addCriterion("STORE_ZONE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeEqualTo(String value) {
            addCriterion("STORE_ZONE_CODE =", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeNotEqualTo(String value) {
            addCriterion("STORE_ZONE_CODE <>", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeGreaterThan(String value) {
            addCriterion("STORE_ZONE_CODE >", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_ZONE_CODE >=", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeLessThan(String value) {
            addCriterion("STORE_ZONE_CODE <", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeLessThanOrEqualTo(String value) {
            addCriterion("STORE_ZONE_CODE <=", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeLike(String value) {
            addCriterion("STORE_ZONE_CODE like", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeNotLike(String value) {
            addCriterion("STORE_ZONE_CODE not like", value, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeIn(List<String> values) {
            addCriterion("STORE_ZONE_CODE in", values, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeNotIn(List<String> values) {
            addCriterion("STORE_ZONE_CODE not in", values, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeBetween(String value1, String value2) {
            addCriterion("STORE_ZONE_CODE between", value1, value2, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreZoneCodeNotBetween(String value1, String value2) {
            addCriterion("STORE_ZONE_CODE not between", value1, value2, "storeZoneCode");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailIsNull() {
            addCriterion("STORE_ADDRESS_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailIsNotNull() {
            addCriterion("STORE_ADDRESS_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailEqualTo(String value) {
            addCriterion("STORE_ADDRESS_DETAIL =", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailNotEqualTo(String value) {
            addCriterion("STORE_ADDRESS_DETAIL <>", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailGreaterThan(String value) {
            addCriterion("STORE_ADDRESS_DETAIL >", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_ADDRESS_DETAIL >=", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailLessThan(String value) {
            addCriterion("STORE_ADDRESS_DETAIL <", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("STORE_ADDRESS_DETAIL <=", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailLike(String value) {
            addCriterion("STORE_ADDRESS_DETAIL like", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailNotLike(String value) {
            addCriterion("STORE_ADDRESS_DETAIL not like", value, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailIn(List<String> values) {
            addCriterion("STORE_ADDRESS_DETAIL in", values, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailNotIn(List<String> values) {
            addCriterion("STORE_ADDRESS_DETAIL not in", values, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailBetween(String value1, String value2) {
            addCriterion("STORE_ADDRESS_DETAIL between", value1, value2, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andStoreAddressDetailNotBetween(String value1, String value2) {
            addCriterion("STORE_ADDRESS_DETAIL not between", value1, value2, "storeAddressDetail");
            return (Criteria) this;
        }

        public Criteria andSalesNameIsNull() {
            addCriterion("SALES_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSalesNameIsNotNull() {
            addCriterion("SALES_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSalesNameEqualTo(String value) {
            addCriterion("SALES_NAME =", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotEqualTo(String value) {
            addCriterion("SALES_NAME <>", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameGreaterThan(String value) {
            addCriterion("SALES_NAME >", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameGreaterThanOrEqualTo(String value) {
            addCriterion("SALES_NAME >=", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLessThan(String value) {
            addCriterion("SALES_NAME <", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLessThanOrEqualTo(String value) {
            addCriterion("SALES_NAME <=", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameLike(String value) {
            addCriterion("SALES_NAME like", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotLike(String value) {
            addCriterion("SALES_NAME not like", value, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameIn(List<String> values) {
            addCriterion("SALES_NAME in", values, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotIn(List<String> values) {
            addCriterion("SALES_NAME not in", values, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameBetween(String value1, String value2) {
            addCriterion("SALES_NAME between", value1, value2, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesNameNotBetween(String value1, String value2) {
            addCriterion("SALES_NAME not between", value1, value2, "salesName");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneIsNull() {
            addCriterion("SALES_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneIsNotNull() {
            addCriterion("SALES_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneEqualTo(String value) {
            addCriterion("SALES_PHONE =", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneNotEqualTo(String value) {
            addCriterion("SALES_PHONE <>", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneGreaterThan(String value) {
            addCriterion("SALES_PHONE >", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("SALES_PHONE >=", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneLessThan(String value) {
            addCriterion("SALES_PHONE <", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneLessThanOrEqualTo(String value) {
            addCriterion("SALES_PHONE <=", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneLike(String value) {
            addCriterion("SALES_PHONE like", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneNotLike(String value) {
            addCriterion("SALES_PHONE not like", value, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneIn(List<String> values) {
            addCriterion("SALES_PHONE in", values, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneNotIn(List<String> values) {
            addCriterion("SALES_PHONE not in", values, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneBetween(String value1, String value2) {
            addCriterion("SALES_PHONE between", value1, value2, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesPhoneNotBetween(String value1, String value2) {
            addCriterion("SALES_PHONE not between", value1, value2, "salesPhone");
            return (Criteria) this;
        }

        public Criteria andSalesIdIsNull() {
            addCriterion("SALES_ID is null");
            return (Criteria) this;
        }

        public Criteria andSalesIdIsNotNull() {
            addCriterion("SALES_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSalesIdEqualTo(String value) {
            addCriterion("SALES_ID =", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdNotEqualTo(String value) {
            addCriterion("SALES_ID <>", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdGreaterThan(String value) {
            addCriterion("SALES_ID >", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdGreaterThanOrEqualTo(String value) {
            addCriterion("SALES_ID >=", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdLessThan(String value) {
            addCriterion("SALES_ID <", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdLessThanOrEqualTo(String value) {
            addCriterion("SALES_ID <=", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdLike(String value) {
            addCriterion("SALES_ID like", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdNotLike(String value) {
            addCriterion("SALES_ID not like", value, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdIn(List<String> values) {
            addCriterion("SALES_ID in", values, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdNotIn(List<String> values) {
            addCriterion("SALES_ID not in", values, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdBetween(String value1, String value2) {
            addCriterion("SALES_ID between", value1, value2, "salesId");
            return (Criteria) this;
        }

        public Criteria andSalesIdNotBetween(String value1, String value2) {
            addCriterion("SALES_ID not between", value1, value2, "salesId");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameIsNull() {
            addCriterion("CMDTY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameIsNotNull() {
            addCriterion("CMDTY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameEqualTo(String value) {
            addCriterion("CMDTY_NAME =", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameNotEqualTo(String value) {
            addCriterion("CMDTY_NAME <>", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameGreaterThan(String value) {
            addCriterion("CMDTY_NAME >", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameGreaterThanOrEqualTo(String value) {
            addCriterion("CMDTY_NAME >=", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameLessThan(String value) {
            addCriterion("CMDTY_NAME <", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameLessThanOrEqualTo(String value) {
            addCriterion("CMDTY_NAME <=", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameLike(String value) {
            addCriterion("CMDTY_NAME like", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameNotLike(String value) {
            addCriterion("CMDTY_NAME not like", value, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameIn(List<String> values) {
            addCriterion("CMDTY_NAME in", values, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameNotIn(List<String> values) {
            addCriterion("CMDTY_NAME not in", values, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameBetween(String value1, String value2) {
            addCriterion("CMDTY_NAME between", value1, value2, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyNameNotBetween(String value1, String value2) {
            addCriterion("CMDTY_NAME not between", value1, value2, "cmdtyName");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceIsNull() {
            addCriterion("CMDTY_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceIsNotNull() {
            addCriterion("CMDTY_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceEqualTo(String value) {
            addCriterion("CMDTY_PRICE =", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceNotEqualTo(String value) {
            addCriterion("CMDTY_PRICE <>", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceGreaterThan(String value) {
            addCriterion("CMDTY_PRICE >", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceGreaterThanOrEqualTo(String value) {
            addCriterion("CMDTY_PRICE >=", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceLessThan(String value) {
            addCriterion("CMDTY_PRICE <", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceLessThanOrEqualTo(String value) {
            addCriterion("CMDTY_PRICE <=", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceLike(String value) {
            addCriterion("CMDTY_PRICE like", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceNotLike(String value) {
            addCriterion("CMDTY_PRICE not like", value, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceIn(List<String> values) {
            addCriterion("CMDTY_PRICE in", values, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceNotIn(List<String> values) {
            addCriterion("CMDTY_PRICE not in", values, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceBetween(String value1, String value2) {
            addCriterion("CMDTY_PRICE between", value1, value2, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andCmdtyPriceNotBetween(String value1, String value2) {
            addCriterion("CMDTY_PRICE not between", value1, value2, "cmdtyPrice");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNull() {
            addCriterion("LOAN_AMT is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNotNull() {
            addCriterion("LOAN_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtEqualTo(String value) {
            addCriterion("LOAN_AMT =", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotEqualTo(String value) {
            addCriterion("LOAN_AMT <>", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThan(String value) {
            addCriterion("LOAN_AMT >", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_AMT >=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThan(String value) {
            addCriterion("LOAN_AMT <", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThanOrEqualTo(String value) {
            addCriterion("LOAN_AMT <=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLike(String value) {
            addCriterion("LOAN_AMT like", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotLike(String value) {
            addCriterion("LOAN_AMT not like", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIn(List<String> values) {
            addCriterion("LOAN_AMT in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotIn(List<String> values) {
            addCriterion("LOAN_AMT not in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtBetween(String value1, String value2) {
            addCriterion("LOAN_AMT between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotBetween(String value1, String value2) {
            addCriterion("LOAN_AMT not between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanTermIsNull() {
            addCriterion("LOAN_TERM is null");
            return (Criteria) this;
        }

        public Criteria andLoanTermIsNotNull() {
            addCriterion("LOAN_TERM is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTermEqualTo(String value) {
            addCriterion("LOAN_TERM =", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotEqualTo(String value) {
            addCriterion("LOAN_TERM <>", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermGreaterThan(String value) {
            addCriterion("LOAN_TERM >", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermGreaterThanOrEqualTo(String value) {
            addCriterion("LOAN_TERM >=", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermLessThan(String value) {
            addCriterion("LOAN_TERM <", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermLessThanOrEqualTo(String value) {
            addCriterion("LOAN_TERM <=", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermLike(String value) {
            addCriterion("LOAN_TERM like", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotLike(String value) {
            addCriterion("LOAN_TERM not like", value, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermIn(List<String> values) {
            addCriterion("LOAN_TERM in", values, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotIn(List<String> values) {
            addCriterion("LOAN_TERM not in", values, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermBetween(String value1, String value2) {
            addCriterion("LOAN_TERM between", value1, value2, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andLoanTermNotBetween(String value1, String value2) {
            addCriterion("LOAN_TERM not between", value1, value2, "loanTerm");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("CATEGORY =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("CATEGORY <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("CATEGORY >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("CATEGORY <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("CATEGORY like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("CATEGORY not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("CATEGORY in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("CATEGORY not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("CATEGORY between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("CATEGORY not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("CLIENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("CLIENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("CLIENT_ID =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("CLIENT_ID <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("CLIENT_ID >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_ID >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("CLIENT_ID <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_ID <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("CLIENT_ID like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("CLIENT_ID not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("CLIENT_ID in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("CLIENT_ID not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("CLIENT_ID between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("CLIENT_ID not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("\"TYPE\" is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("\"TYPE\" is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("\"TYPE\" =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("\"TYPE\" <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("\"TYPE\" >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("\"TYPE\" >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("\"TYPE\" <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("\"TYPE\" <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("\"TYPE\" like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("\"TYPE\" not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("\"TYPE\" in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("\"TYPE\" not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("\"TYPE\" between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("\"TYPE\" not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andAccuracyIsNull() {
            addCriterion("ACCURACY is null");
            return (Criteria) this;
        }

        public Criteria andAccuracyIsNotNull() {
            addCriterion("ACCURACY is not null");
            return (Criteria) this;
        }

        public Criteria andAccuracyEqualTo(BigDecimal value) {
            addCriterion("ACCURACY =", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotEqualTo(BigDecimal value) {
            addCriterion("ACCURACY <>", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyGreaterThan(BigDecimal value) {
            addCriterion("ACCURACY >", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCURACY >=", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyLessThan(BigDecimal value) {
            addCriterion("ACCURACY <", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCURACY <=", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyIn(List<BigDecimal> values) {
            addCriterion("ACCURACY in", values, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotIn(List<BigDecimal> values) {
            addCriterion("ACCURACY not in", values, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCURACY between", value1, value2, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCURACY not between", value1, value2, "accuracy");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("BRAND_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("BRAND_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("BRAND_NAME =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("BRAND_NAME <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("BRAND_NAME >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_NAME >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("BRAND_NAME <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("BRAND_NAME <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("BRAND_NAME like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("BRAND_NAME not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("BRAND_NAME in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("BRAND_NAME not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("BRAND_NAME between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("BRAND_NAME not between", value1, value2, "brandName");
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

        public Criteria andDownPmtAmtIsNull() {
            addCriterion("DOWN_PMT_AMT is null");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtIsNotNull() {
            addCriterion("DOWN_PMT_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtEqualTo(String value) {
            addCriterion("DOWN_PMT_AMT =", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtNotEqualTo(String value) {
            addCriterion("DOWN_PMT_AMT <>", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtGreaterThan(String value) {
            addCriterion("DOWN_PMT_AMT >", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtGreaterThanOrEqualTo(String value) {
            addCriterion("DOWN_PMT_AMT >=", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtLessThan(String value) {
            addCriterion("DOWN_PMT_AMT <", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtLessThanOrEqualTo(String value) {
            addCriterion("DOWN_PMT_AMT <=", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtLike(String value) {
            addCriterion("DOWN_PMT_AMT like", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtNotLike(String value) {
            addCriterion("DOWN_PMT_AMT not like", value, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtIn(List<String> values) {
            addCriterion("DOWN_PMT_AMT in", values, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtNotIn(List<String> values) {
            addCriterion("DOWN_PMT_AMT not in", values, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtBetween(String value1, String value2) {
            addCriterion("DOWN_PMT_AMT between", value1, value2, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andDownPmtAmtNotBetween(String value1, String value2) {
            addCriterion("DOWN_PMT_AMT not between", value1, value2, "downPmtAmt");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("\"NAME\" is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("\"NAME\" is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("\"NAME\" =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("\"NAME\" <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("\"NAME\" >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("\"NAME\" >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("\"NAME\" <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("\"NAME\" <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("\"NAME\" like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("\"NAME\" not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("\"NAME\" in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("\"NAME\" not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("\"NAME\" between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("\"NAME\" not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNull() {
            addCriterion("ID_CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNotNull() {
            addCriterion("ID_CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoEqualTo(String value) {
            addCriterion("ID_CARD_NO =", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotEqualTo(String value) {
            addCriterion("ID_CARD_NO <>", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThan(String value) {
            addCriterion("ID_CARD_NO >", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO >=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThan(String value) {
            addCriterion("ID_CARD_NO <", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO <=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLike(String value) {
            addCriterion("ID_CARD_NO like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotLike(String value) {
            addCriterion("ID_CARD_NO not like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIn(List<String> values) {
            addCriterion("ID_CARD_NO in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotIn(List<String> values) {
            addCriterion("ID_CARD_NO not in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO not between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateIsNull() {
            addCriterion("ID_CARD_BEGIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateIsNotNull() {
            addCriterion("ID_CARD_BEGIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE =", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateNotEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE <>", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateGreaterThan(String value) {
            addCriterion("ID_CARD_BEGIN_DATE >", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE >=", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateLessThan(String value) {
            addCriterion("ID_CARD_BEGIN_DATE <", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE <=", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateLike(String value) {
            addCriterion("ID_CARD_BEGIN_DATE like", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateNotLike(String value) {
            addCriterion("ID_CARD_BEGIN_DATE not like", value, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateIn(List<String> values) {
            addCriterion("ID_CARD_BEGIN_DATE in", values, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateNotIn(List<String> values) {
            addCriterion("ID_CARD_BEGIN_DATE not in", values, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateBetween(String value1, String value2) {
            addCriterion("ID_CARD_BEGIN_DATE between", value1, value2, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_BEGIN_DATE not between", value1, value2, "idCardBeginDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateIsNull() {
            addCriterion("ID_CARD_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateIsNotNull() {
            addCriterion("ID_CARD_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE =", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE <>", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateGreaterThan(String value) {
            addCriterion("ID_CARD_END_DATE >", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE >=", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateLessThan(String value) {
            addCriterion("ID_CARD_END_DATE <", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE <=", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateLike(String value) {
            addCriterion("ID_CARD_END_DATE like", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotLike(String value) {
            addCriterion("ID_CARD_END_DATE not like", value, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateIn(List<String> values) {
            addCriterion("ID_CARD_END_DATE in", values, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotIn(List<String> values) {
            addCriterion("ID_CARD_END_DATE not in", values, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateBetween(String value1, String value2) {
            addCriterion("ID_CARD_END_DATE between", value1, value2, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_END_DATE not between", value1, value2, "idCardEndDate");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailIsNull() {
            addCriterion("ABODE_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailIsNotNull() {
            addCriterion("ABODE_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailEqualTo(String value) {
            addCriterion("ABODE_DETAIL =", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailNotEqualTo(String value) {
            addCriterion("ABODE_DETAIL <>", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailGreaterThan(String value) {
            addCriterion("ABODE_DETAIL >", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailGreaterThanOrEqualTo(String value) {
            addCriterion("ABODE_DETAIL >=", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailLessThan(String value) {
            addCriterion("ABODE_DETAIL <", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailLessThanOrEqualTo(String value) {
            addCriterion("ABODE_DETAIL <=", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailLike(String value) {
            addCriterion("ABODE_DETAIL like", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailNotLike(String value) {
            addCriterion("ABODE_DETAIL not like", value, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailIn(List<String> values) {
            addCriterion("ABODE_DETAIL in", values, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailNotIn(List<String> values) {
            addCriterion("ABODE_DETAIL not in", values, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailBetween(String value1, String value2) {
            addCriterion("ABODE_DETAIL between", value1, value2, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailNotBetween(String value1, String value2) {
            addCriterion("ABODE_DETAIL not between", value1, value2, "abodeDetail");
            return (Criteria) this;
        }

        public Criteria andNameFlagIsNull() {
            addCriterion("NAME_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andNameFlagIsNotNull() {
            addCriterion("NAME_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andNameFlagEqualTo(String value) {
            addCriterion("NAME_FLAG =", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagNotEqualTo(String value) {
            addCriterion("NAME_FLAG <>", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagGreaterThan(String value) {
            addCriterion("NAME_FLAG >", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_FLAG >=", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagLessThan(String value) {
            addCriterion("NAME_FLAG <", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagLessThanOrEqualTo(String value) {
            addCriterion("NAME_FLAG <=", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagLike(String value) {
            addCriterion("NAME_FLAG like", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagNotLike(String value) {
            addCriterion("NAME_FLAG not like", value, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagIn(List<String> values) {
            addCriterion("NAME_FLAG in", values, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagNotIn(List<String> values) {
            addCriterion("NAME_FLAG not in", values, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagBetween(String value1, String value2) {
            addCriterion("NAME_FLAG between", value1, value2, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andNameFlagNotBetween(String value1, String value2) {
            addCriterion("NAME_FLAG not between", value1, value2, "nameFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagIsNull() {
            addCriterion("ID_CARD_NO_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagIsNotNull() {
            addCriterion("ID_CARD_NO_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagEqualTo(String value) {
            addCriterion("ID_CARD_NO_FLAG =", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagNotEqualTo(String value) {
            addCriterion("ID_CARD_NO_FLAG <>", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagGreaterThan(String value) {
            addCriterion("ID_CARD_NO_FLAG >", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO_FLAG >=", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagLessThan(String value) {
            addCriterion("ID_CARD_NO_FLAG <", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO_FLAG <=", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagLike(String value) {
            addCriterion("ID_CARD_NO_FLAG like", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagNotLike(String value) {
            addCriterion("ID_CARD_NO_FLAG not like", value, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagIn(List<String> values) {
            addCriterion("ID_CARD_NO_FLAG in", values, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagNotIn(List<String> values) {
            addCriterion("ID_CARD_NO_FLAG not in", values, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO_FLAG between", value1, value2, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardNoFlagNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO_FLAG not between", value1, value2, "idCardNoFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagIsNull() {
            addCriterion("ID_CARD_IN_DATE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagIsNotNull() {
            addCriterion("ID_CARD_IN_DATE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagEqualTo(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG =", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagNotEqualTo(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG <>", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagGreaterThan(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG >", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG >=", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagLessThan(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG <", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG <=", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagLike(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG like", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagNotLike(String value) {
            addCriterion("ID_CARD_IN_DATE_FLAG not like", value, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagIn(List<String> values) {
            addCriterion("ID_CARD_IN_DATE_FLAG in", values, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagNotIn(List<String> values) {
            addCriterion("ID_CARD_IN_DATE_FLAG not in", values, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagBetween(String value1, String value2) {
            addCriterion("ID_CARD_IN_DATE_FLAG between", value1, value2, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andIdCardInDateFlagNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_IN_DATE_FLAG not between", value1, value2, "idCardInDateFlag");
            return (Criteria) this;
        }

        public Criteria andNameModifyIsNull() {
            addCriterion("NAME_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andNameModifyIsNotNull() {
            addCriterion("NAME_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andNameModifyEqualTo(String value) {
            addCriterion("NAME_MODIFY =", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyNotEqualTo(String value) {
            addCriterion("NAME_MODIFY <>", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyGreaterThan(String value) {
            addCriterion("NAME_MODIFY >", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_MODIFY >=", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyLessThan(String value) {
            addCriterion("NAME_MODIFY <", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyLessThanOrEqualTo(String value) {
            addCriterion("NAME_MODIFY <=", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyLike(String value) {
            addCriterion("NAME_MODIFY like", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyNotLike(String value) {
            addCriterion("NAME_MODIFY not like", value, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyIn(List<String> values) {
            addCriterion("NAME_MODIFY in", values, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyNotIn(List<String> values) {
            addCriterion("NAME_MODIFY not in", values, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyBetween(String value1, String value2) {
            addCriterion("NAME_MODIFY between", value1, value2, "nameModify");
            return (Criteria) this;
        }

        public Criteria andNameModifyNotBetween(String value1, String value2) {
            addCriterion("NAME_MODIFY not between", value1, value2, "nameModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyIsNull() {
            addCriterion("ID_CARD_NO_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyIsNotNull() {
            addCriterion("ID_CARD_NO_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyEqualTo(String value) {
            addCriterion("ID_CARD_NO_MODIFY =", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyNotEqualTo(String value) {
            addCriterion("ID_CARD_NO_MODIFY <>", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyGreaterThan(String value) {
            addCriterion("ID_CARD_NO_MODIFY >", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO_MODIFY >=", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyLessThan(String value) {
            addCriterion("ID_CARD_NO_MODIFY <", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_NO_MODIFY <=", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyLike(String value) {
            addCriterion("ID_CARD_NO_MODIFY like", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyNotLike(String value) {
            addCriterion("ID_CARD_NO_MODIFY not like", value, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyIn(List<String> values) {
            addCriterion("ID_CARD_NO_MODIFY in", values, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyNotIn(List<String> values) {
            addCriterion("ID_CARD_NO_MODIFY not in", values, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO_MODIFY between", value1, value2, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardNoModifyNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_NO_MODIFY not between", value1, value2, "idCardNoModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyIsNull() {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyIsNotNull() {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY =", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyNotEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY <>", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyGreaterThan(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY >", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY >=", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyLessThan(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY <", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY <=", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyLike(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY like", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyNotLike(String value) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY not like", value, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyIn(List<String> values) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY in", values, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyNotIn(List<String> values) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY not in", values, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyBetween(String value1, String value2) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY between", value1, value2, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardBeginDateModifyNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_BEGIN_DATE_MODIFY not between", value1, value2, "idCardBeginDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyIsNull() {
            addCriterion("ID_CARD_END_DATE_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyIsNotNull() {
            addCriterion("ID_CARD_END_DATE_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY =", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyNotEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY <>", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyGreaterThan(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY >", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY >=", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyLessThan(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY <", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY <=", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyLike(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY like", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyNotLike(String value) {
            addCriterion("ID_CARD_END_DATE_MODIFY not like", value, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyIn(List<String> values) {
            addCriterion("ID_CARD_END_DATE_MODIFY in", values, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyNotIn(List<String> values) {
            addCriterion("ID_CARD_END_DATE_MODIFY not in", values, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyBetween(String value1, String value2) {
            addCriterion("ID_CARD_END_DATE_MODIFY between", value1, value2, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andIdCardEndDateModifyNotBetween(String value1, String value2) {
            addCriterion("ID_CARD_END_DATE_MODIFY not between", value1, value2, "idCardEndDateModify");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNull() {
            addCriterion("BANK_CARD_NO is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNotNull() {
            addCriterion("BANK_CARD_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoEqualTo(String value) {
            addCriterion("BANK_CARD_NO =", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotEqualTo(String value) {
            addCriterion("BANK_CARD_NO <>", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThan(String value) {
            addCriterion("BANK_CARD_NO >", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_CARD_NO >=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThan(String value) {
            addCriterion("BANK_CARD_NO <", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThanOrEqualTo(String value) {
            addCriterion("BANK_CARD_NO <=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLike(String value) {
            addCriterion("BANK_CARD_NO like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotLike(String value) {
            addCriterion("BANK_CARD_NO not like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIn(List<String> values) {
            addCriterion("BANK_CARD_NO in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotIn(List<String> values) {
            addCriterion("BANK_CARD_NO not in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoBetween(String value1, String value2) {
            addCriterion("BANK_CARD_NO between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotBetween(String value1, String value2) {
            addCriterion("BANK_CARD_NO not between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNull() {
            addCriterion("BANK_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNotNull() {
            addCriterion("BANK_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneEqualTo(String value) {
            addCriterion("BANK_PHONE =", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotEqualTo(String value) {
            addCriterion("BANK_PHONE <>", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThan(String value) {
            addCriterion("BANK_PHONE >", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_PHONE >=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThan(String value) {
            addCriterion("BANK_PHONE <", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThanOrEqualTo(String value) {
            addCriterion("BANK_PHONE <=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLike(String value) {
            addCriterion("BANK_PHONE like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotLike(String value) {
            addCriterion("BANK_PHONE not like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIn(List<String> values) {
            addCriterion("BANK_PHONE in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotIn(List<String> values) {
            addCriterion("BANK_PHONE not in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneBetween(String value1, String value2) {
            addCriterion("BANK_PHONE between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotBetween(String value1, String value2) {
            addCriterion("BANK_PHONE not between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNull() {
            addCriterion("BANK_ACCOUNT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNotNull() {
            addCriterion("BANK_ACCOUNT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameEqualTo(String value) {
            addCriterion("BANK_ACCOUNT_NAME =", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotEqualTo(String value) {
            addCriterion("BANK_ACCOUNT_NAME <>", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThan(String value) {
            addCriterion("BANK_ACCOUNT_NAME >", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT_NAME >=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThan(String value) {
            addCriterion("BANK_ACCOUNT_NAME <", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT_NAME <=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLike(String value) {
            addCriterion("BANK_ACCOUNT_NAME like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotLike(String value) {
            addCriterion("BANK_ACCOUNT_NAME not like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIn(List<String> values) {
            addCriterion("BANK_ACCOUNT_NAME in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotIn(List<String> values) {
            addCriterion("BANK_ACCOUNT_NAME not in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT_NAME between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT_NAME not between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeIsNull() {
            addCriterion("ABODE_STATE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeIsNotNull() {
            addCriterion("ABODE_STATE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeEqualTo(String value) {
            addCriterion("ABODE_STATE_CODE =", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeNotEqualTo(String value) {
            addCriterion("ABODE_STATE_CODE <>", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeGreaterThan(String value) {
            addCriterion("ABODE_STATE_CODE >", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ABODE_STATE_CODE >=", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeLessThan(String value) {
            addCriterion("ABODE_STATE_CODE <", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeLessThanOrEqualTo(String value) {
            addCriterion("ABODE_STATE_CODE <=", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeLike(String value) {
            addCriterion("ABODE_STATE_CODE like", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeNotLike(String value) {
            addCriterion("ABODE_STATE_CODE not like", value, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeIn(List<String> values) {
            addCriterion("ABODE_STATE_CODE in", values, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeNotIn(List<String> values) {
            addCriterion("ABODE_STATE_CODE not in", values, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeBetween(String value1, String value2) {
            addCriterion("ABODE_STATE_CODE between", value1, value2, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeStateCodeNotBetween(String value1, String value2) {
            addCriterion("ABODE_STATE_CODE not between", value1, value2, "abodeStateCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeIsNull() {
            addCriterion("ABODE_CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeIsNotNull() {
            addCriterion("ABODE_CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeEqualTo(String value) {
            addCriterion("ABODE_CITY_CODE =", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeNotEqualTo(String value) {
            addCriterion("ABODE_CITY_CODE <>", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeGreaterThan(String value) {
            addCriterion("ABODE_CITY_CODE >", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ABODE_CITY_CODE >=", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeLessThan(String value) {
            addCriterion("ABODE_CITY_CODE <", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeLessThanOrEqualTo(String value) {
            addCriterion("ABODE_CITY_CODE <=", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeLike(String value) {
            addCriterion("ABODE_CITY_CODE like", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeNotLike(String value) {
            addCriterion("ABODE_CITY_CODE not like", value, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeIn(List<String> values) {
            addCriterion("ABODE_CITY_CODE in", values, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeNotIn(List<String> values) {
            addCriterion("ABODE_CITY_CODE not in", values, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeBetween(String value1, String value2) {
            addCriterion("ABODE_CITY_CODE between", value1, value2, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeCityCodeNotBetween(String value1, String value2) {
            addCriterion("ABODE_CITY_CODE not between", value1, value2, "abodeCityCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeIsNull() {
            addCriterion("ABODE_ZONE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeIsNotNull() {
            addCriterion("ABODE_ZONE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeEqualTo(String value) {
            addCriterion("ABODE_ZONE_CODE =", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeNotEqualTo(String value) {
            addCriterion("ABODE_ZONE_CODE <>", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeGreaterThan(String value) {
            addCriterion("ABODE_ZONE_CODE >", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ABODE_ZONE_CODE >=", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeLessThan(String value) {
            addCriterion("ABODE_ZONE_CODE <", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeLessThanOrEqualTo(String value) {
            addCriterion("ABODE_ZONE_CODE <=", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeLike(String value) {
            addCriterion("ABODE_ZONE_CODE like", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeNotLike(String value) {
            addCriterion("ABODE_ZONE_CODE not like", value, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeIn(List<String> values) {
            addCriterion("ABODE_ZONE_CODE in", values, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeNotIn(List<String> values) {
            addCriterion("ABODE_ZONE_CODE not in", values, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeBetween(String value1, String value2) {
            addCriterion("ABODE_ZONE_CODE between", value1, value2, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeZoneCodeNotBetween(String value1, String value2) {
            addCriterion("ABODE_ZONE_CODE not between", value1, value2, "abodeZoneCode");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressIsNull() {
            addCriterion("ABODE_DETAIL_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressIsNotNull() {
            addCriterion("ABODE_DETAIL_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressEqualTo(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS =", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressNotEqualTo(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS <>", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressGreaterThan(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS >", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS >=", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressLessThan(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS <", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS <=", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressLike(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS like", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressNotLike(String value) {
            addCriterion("ABODE_DETAIL_ADDRESS not like", value, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressIn(List<String> values) {
            addCriterion("ABODE_DETAIL_ADDRESS in", values, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressNotIn(List<String> values) {
            addCriterion("ABODE_DETAIL_ADDRESS not in", values, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressBetween(String value1, String value2) {
            addCriterion("ABODE_DETAIL_ADDRESS between", value1, value2, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andAbodeDetailAddressNotBetween(String value1, String value2) {
            addCriterion("ABODE_DETAIL_ADDRESS not between", value1, value2, "abodeDetailAddress");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNull() {
            addCriterion("MARITAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("MARITAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(String value) {
            addCriterion("MARITAL_STATUS =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(String value) {
            addCriterion("MARITAL_STATUS <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(String value) {
            addCriterion("MARITAL_STATUS >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MARITAL_STATUS >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(String value) {
            addCriterion("MARITAL_STATUS <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("MARITAL_STATUS <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLike(String value) {
            addCriterion("MARITAL_STATUS like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotLike(String value) {
            addCriterion("MARITAL_STATUS not like", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<String> values) {
            addCriterion("MARITAL_STATUS in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<String> values) {
            addCriterion("MARITAL_STATUS not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(String value1, String value2) {
            addCriterion("MARITAL_STATUS between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("MARITAL_STATUS not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeIsNull() {
            addCriterion("MOUTH_INCOME is null");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeIsNotNull() {
            addCriterion("MOUTH_INCOME is not null");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeEqualTo(String value) {
            addCriterion("MOUTH_INCOME =", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeNotEqualTo(String value) {
            addCriterion("MOUTH_INCOME <>", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeGreaterThan(String value) {
            addCriterion("MOUTH_INCOME >", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("MOUTH_INCOME >=", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeLessThan(String value) {
            addCriterion("MOUTH_INCOME <", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeLessThanOrEqualTo(String value) {
            addCriterion("MOUTH_INCOME <=", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeLike(String value) {
            addCriterion("MOUTH_INCOME like", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeNotLike(String value) {
            addCriterion("MOUTH_INCOME not like", value, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeIn(List<String> values) {
            addCriterion("MOUTH_INCOME in", values, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeNotIn(List<String> values) {
            addCriterion("MOUTH_INCOME not in", values, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeBetween(String value1, String value2) {
            addCriterion("MOUTH_INCOME between", value1, value2, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andMouthIncomeNotBetween(String value1, String value2) {
            addCriterion("MOUTH_INCOME not between", value1, value2, "mouthIncome");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityIsNull() {
            addCriterion("SOCIAL_IDENTITY is null");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityIsNotNull() {
            addCriterion("SOCIAL_IDENTITY is not null");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityEqualTo(String value) {
            addCriterion("SOCIAL_IDENTITY =", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityNotEqualTo(String value) {
            addCriterion("SOCIAL_IDENTITY <>", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityGreaterThan(String value) {
            addCriterion("SOCIAL_IDENTITY >", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("SOCIAL_IDENTITY >=", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityLessThan(String value) {
            addCriterion("SOCIAL_IDENTITY <", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityLessThanOrEqualTo(String value) {
            addCriterion("SOCIAL_IDENTITY <=", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityLike(String value) {
            addCriterion("SOCIAL_IDENTITY like", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityNotLike(String value) {
            addCriterion("SOCIAL_IDENTITY not like", value, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityIn(List<String> values) {
            addCriterion("SOCIAL_IDENTITY in", values, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityNotIn(List<String> values) {
            addCriterion("SOCIAL_IDENTITY not in", values, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityBetween(String value1, String value2) {
            addCriterion("SOCIAL_IDENTITY between", value1, value2, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andSocialIdentityNotBetween(String value1, String value2) {
            addCriterion("SOCIAL_IDENTITY not between", value1, value2, "socialIdentity");
            return (Criteria) this;
        }

        public Criteria andStudentFlagIsNull() {
            addCriterion("STUDENT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andStudentFlagIsNotNull() {
            addCriterion("STUDENT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andStudentFlagEqualTo(String value) {
            addCriterion("STUDENT_FLAG =", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagNotEqualTo(String value) {
            addCriterion("STUDENT_FLAG <>", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagGreaterThan(String value) {
            addCriterion("STUDENT_FLAG >", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_FLAG >=", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagLessThan(String value) {
            addCriterion("STUDENT_FLAG <", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_FLAG <=", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagLike(String value) {
            addCriterion("STUDENT_FLAG like", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagNotLike(String value) {
            addCriterion("STUDENT_FLAG not like", value, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagIn(List<String> values) {
            addCriterion("STUDENT_FLAG in", values, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagNotIn(List<String> values) {
            addCriterion("STUDENT_FLAG not in", values, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagBetween(String value1, String value2) {
            addCriterion("STUDENT_FLAG between", value1, value2, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andStudentFlagNotBetween(String value1, String value2) {
            addCriterion("STUDENT_FLAG not between", value1, value2, "studentFlag");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoIsNull() {
            addCriterion("APPLY_PHONE_NO is null");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoIsNotNull() {
            addCriterion("APPLY_PHONE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoEqualTo(String value) {
            addCriterion("APPLY_PHONE_NO =", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoNotEqualTo(String value) {
            addCriterion("APPLY_PHONE_NO <>", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoGreaterThan(String value) {
            addCriterion("APPLY_PHONE_NO >", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_PHONE_NO >=", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoLessThan(String value) {
            addCriterion("APPLY_PHONE_NO <", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoLessThanOrEqualTo(String value) {
            addCriterion("APPLY_PHONE_NO <=", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoLike(String value) {
            addCriterion("APPLY_PHONE_NO like", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoNotLike(String value) {
            addCriterion("APPLY_PHONE_NO not like", value, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoIn(List<String> values) {
            addCriterion("APPLY_PHONE_NO in", values, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoNotIn(List<String> values) {
            addCriterion("APPLY_PHONE_NO not in", values, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoBetween(String value1, String value2) {
            addCriterion("APPLY_PHONE_NO between", value1, value2, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneNoNotBetween(String value1, String value2) {
            addCriterion("APPLY_PHONE_NO not between", value1, value2, "applyPhoneNo");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsIsNull() {
            addCriterion("APPLY_PHONE_OS is null");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsIsNotNull() {
            addCriterion("APPLY_PHONE_OS is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsEqualTo(String value) {
            addCriterion("APPLY_PHONE_OS =", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsNotEqualTo(String value) {
            addCriterion("APPLY_PHONE_OS <>", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsGreaterThan(String value) {
            addCriterion("APPLY_PHONE_OS >", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_PHONE_OS >=", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsLessThan(String value) {
            addCriterion("APPLY_PHONE_OS <", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsLessThanOrEqualTo(String value) {
            addCriterion("APPLY_PHONE_OS <=", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsLike(String value) {
            addCriterion("APPLY_PHONE_OS like", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsNotLike(String value) {
            addCriterion("APPLY_PHONE_OS not like", value, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsIn(List<String> values) {
            addCriterion("APPLY_PHONE_OS in", values, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsNotIn(List<String> values) {
            addCriterion("APPLY_PHONE_OS not in", values, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsBetween(String value1, String value2) {
            addCriterion("APPLY_PHONE_OS between", value1, value2, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyPhoneOsNotBetween(String value1, String value2) {
            addCriterion("APPLY_PHONE_OS not between", value1, value2, "applyPhoneOs");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeIsNull() {
            addCriterion("APPLY_WZF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeIsNotNull() {
            addCriterion("APPLY_WZF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeEqualTo(String value) {
            addCriterion("APPLY_WZF_TIME =", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeNotEqualTo(String value) {
            addCriterion("APPLY_WZF_TIME <>", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeGreaterThan(String value) {
            addCriterion("APPLY_WZF_TIME >", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_WZF_TIME >=", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeLessThan(String value) {
            addCriterion("APPLY_WZF_TIME <", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeLessThanOrEqualTo(String value) {
            addCriterion("APPLY_WZF_TIME <=", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeLike(String value) {
            addCriterion("APPLY_WZF_TIME like", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeNotLike(String value) {
            addCriterion("APPLY_WZF_TIME not like", value, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeIn(List<String> values) {
            addCriterion("APPLY_WZF_TIME in", values, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeNotIn(List<String> values) {
            addCriterion("APPLY_WZF_TIME not in", values, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeBetween(String value1, String value2) {
            addCriterion("APPLY_WZF_TIME between", value1, value2, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andApplyWzfTimeNotBetween(String value1, String value2) {
            addCriterion("APPLY_WZF_TIME not between", value1, value2, "applyWzfTime");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("UNIT_NAME =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("UNIT_NAME <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("UNIT_NAME >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("UNIT_NAME <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("UNIT_NAME like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("UNIT_NAME not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("UNIT_NAME in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("UNIT_NAME not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("UNIT_NAME between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("UNIT_NAME not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNull() {
            addCriterion("EMP_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNotNull() {
            addCriterion("EMP_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneEqualTo(String value) {
            addCriterion("EMP_PHONE =", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotEqualTo(String value) {
            addCriterion("EMP_PHONE <>", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThan(String value) {
            addCriterion("EMP_PHONE >", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_PHONE >=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThan(String value) {
            addCriterion("EMP_PHONE <", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThanOrEqualTo(String value) {
            addCriterion("EMP_PHONE <=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLike(String value) {
            addCriterion("EMP_PHONE like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotLike(String value) {
            addCriterion("EMP_PHONE not like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIn(List<String> values) {
            addCriterion("EMP_PHONE in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotIn(List<String> values) {
            addCriterion("EMP_PHONE not in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneBetween(String value1, String value2) {
            addCriterion("EMP_PHONE between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotBetween(String value1, String value2) {
            addCriterion("EMP_PHONE not between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeIsNull() {
            addCriterion("EMP_PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeIsNotNull() {
            addCriterion("EMP_PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeEqualTo(String value) {
            addCriterion("EMP_PROVINCE_CODE =", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeNotEqualTo(String value) {
            addCriterion("EMP_PROVINCE_CODE <>", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeGreaterThan(String value) {
            addCriterion("EMP_PROVINCE_CODE >", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_PROVINCE_CODE >=", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeLessThan(String value) {
            addCriterion("EMP_PROVINCE_CODE <", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("EMP_PROVINCE_CODE <=", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeLike(String value) {
            addCriterion("EMP_PROVINCE_CODE like", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeNotLike(String value) {
            addCriterion("EMP_PROVINCE_CODE not like", value, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeIn(List<String> values) {
            addCriterion("EMP_PROVINCE_CODE in", values, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeNotIn(List<String> values) {
            addCriterion("EMP_PROVINCE_CODE not in", values, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeBetween(String value1, String value2) {
            addCriterion("EMP_PROVINCE_CODE between", value1, value2, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("EMP_PROVINCE_CODE not between", value1, value2, "empProvinceCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeIsNull() {
            addCriterion("EMP_CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeIsNotNull() {
            addCriterion("EMP_CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeEqualTo(String value) {
            addCriterion("EMP_CITY_CODE =", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeNotEqualTo(String value) {
            addCriterion("EMP_CITY_CODE <>", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeGreaterThan(String value) {
            addCriterion("EMP_CITY_CODE >", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_CITY_CODE >=", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeLessThan(String value) {
            addCriterion("EMP_CITY_CODE <", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeLessThanOrEqualTo(String value) {
            addCriterion("EMP_CITY_CODE <=", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeLike(String value) {
            addCriterion("EMP_CITY_CODE like", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeNotLike(String value) {
            addCriterion("EMP_CITY_CODE not like", value, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeIn(List<String> values) {
            addCriterion("EMP_CITY_CODE in", values, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeNotIn(List<String> values) {
            addCriterion("EMP_CITY_CODE not in", values, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeBetween(String value1, String value2) {
            addCriterion("EMP_CITY_CODE between", value1, value2, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpCityCodeNotBetween(String value1, String value2) {
            addCriterion("EMP_CITY_CODE not between", value1, value2, "empCityCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeIsNull() {
            addCriterion("EMP_ZONE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeIsNotNull() {
            addCriterion("EMP_ZONE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeEqualTo(String value) {
            addCriterion("EMP_ZONE_CODE =", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeNotEqualTo(String value) {
            addCriterion("EMP_ZONE_CODE <>", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeGreaterThan(String value) {
            addCriterion("EMP_ZONE_CODE >", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_ZONE_CODE >=", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeLessThan(String value) {
            addCriterion("EMP_ZONE_CODE <", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeLessThanOrEqualTo(String value) {
            addCriterion("EMP_ZONE_CODE <=", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeLike(String value) {
            addCriterion("EMP_ZONE_CODE like", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeNotLike(String value) {
            addCriterion("EMP_ZONE_CODE not like", value, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeIn(List<String> values) {
            addCriterion("EMP_ZONE_CODE in", values, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeNotIn(List<String> values) {
            addCriterion("EMP_ZONE_CODE not in", values, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeBetween(String value1, String value2) {
            addCriterion("EMP_ZONE_CODE between", value1, value2, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpZoneCodeNotBetween(String value1, String value2) {
            addCriterion("EMP_ZONE_CODE not between", value1, value2, "empZoneCode");
            return (Criteria) this;
        }

        public Criteria andEmpAddrIsNull() {
            addCriterion("EMP_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andEmpAddrIsNotNull() {
            addCriterion("EMP_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAddrEqualTo(String value) {
            addCriterion("EMP_ADDR =", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrNotEqualTo(String value) {
            addCriterion("EMP_ADDR <>", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrGreaterThan(String value) {
            addCriterion("EMP_ADDR >", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrGreaterThanOrEqualTo(String value) {
            addCriterion("EMP_ADDR >=", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrLessThan(String value) {
            addCriterion("EMP_ADDR <", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrLessThanOrEqualTo(String value) {
            addCriterion("EMP_ADDR <=", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrLike(String value) {
            addCriterion("EMP_ADDR like", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrNotLike(String value) {
            addCriterion("EMP_ADDR not like", value, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrIn(List<String> values) {
            addCriterion("EMP_ADDR in", values, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrNotIn(List<String> values) {
            addCriterion("EMP_ADDR not in", values, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrBetween(String value1, String value2) {
            addCriterion("EMP_ADDR between", value1, value2, "empAddr");
            return (Criteria) this;
        }

        public Criteria andEmpAddrNotBetween(String value1, String value2) {
            addCriterion("EMP_ADDR not between", value1, value2, "empAddr");
            return (Criteria) this;
        }

        public Criteria andAuthNumberIsNull() {
            addCriterion("AUTH_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andAuthNumberIsNotNull() {
            addCriterion("AUTH_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNumberEqualTo(String value) {
            addCriterion("AUTH_NUMBER =", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberNotEqualTo(String value) {
            addCriterion("AUTH_NUMBER <>", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberGreaterThan(String value) {
            addCriterion("AUTH_NUMBER >", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_NUMBER >=", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberLessThan(String value) {
            addCriterion("AUTH_NUMBER <", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberLessThanOrEqualTo(String value) {
            addCriterion("AUTH_NUMBER <=", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberLike(String value) {
            addCriterion("AUTH_NUMBER like", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberNotLike(String value) {
            addCriterion("AUTH_NUMBER not like", value, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberIn(List<String> values) {
            addCriterion("AUTH_NUMBER in", values, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberNotIn(List<String> values) {
            addCriterion("AUTH_NUMBER not in", values, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberBetween(String value1, String value2) {
            addCriterion("AUTH_NUMBER between", value1, value2, "authNumber");
            return (Criteria) this;
        }

        public Criteria andAuthNumberNotBetween(String value1, String value2) {
            addCriterion("AUTH_NUMBER not between", value1, value2, "authNumber");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIsNull() {
            addCriterion("OUT_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIsNotNull() {
            addCriterion("OUT_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdEqualTo(String value) {
            addCriterion("OUT_ORDER_ID =", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotEqualTo(String value) {
            addCriterion("OUT_ORDER_ID <>", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdGreaterThan(String value) {
            addCriterion("OUT_ORDER_ID >", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_ORDER_ID >=", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLessThan(String value) {
            addCriterion("OUT_ORDER_ID <", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLessThanOrEqualTo(String value) {
            addCriterion("OUT_ORDER_ID <=", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLike(String value) {
            addCriterion("OUT_ORDER_ID like", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotLike(String value) {
            addCriterion("OUT_ORDER_ID not like", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIn(List<String> values) {
            addCriterion("OUT_ORDER_ID in", values, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotIn(List<String> values) {
            addCriterion("OUT_ORDER_ID not in", values, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdBetween(String value1, String value2) {
            addCriterion("OUT_ORDER_ID between", value1, value2, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotBetween(String value1, String value2) {
            addCriterion("OUT_ORDER_ID not between", value1, value2, "outOrderId");
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

        public Criteria andTotalAmtIsNull() {
            addCriterion("TOTAL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmtIsNotNull() {
            addCriterion("TOTAL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmtEqualTo(String value) {
            addCriterion("TOTAL_AMT =", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtNotEqualTo(String value) {
            addCriterion("TOTAL_AMT <>", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtGreaterThan(String value) {
            addCriterion("TOTAL_AMT >", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtGreaterThanOrEqualTo(String value) {
            addCriterion("TOTAL_AMT >=", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtLessThan(String value) {
            addCriterion("TOTAL_AMT <", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtLessThanOrEqualTo(String value) {
            addCriterion("TOTAL_AMT <=", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtLike(String value) {
            addCriterion("TOTAL_AMT like", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtNotLike(String value) {
            addCriterion("TOTAL_AMT not like", value, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtIn(List<String> values) {
            addCriterion("TOTAL_AMT in", values, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtNotIn(List<String> values) {
            addCriterion("TOTAL_AMT not in", values, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtBetween(String value1, String value2) {
            addCriterion("TOTAL_AMT between", value1, value2, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andTotalAmtNotBetween(String value1, String value2) {
            addCriterion("TOTAL_AMT not between", value1, value2, "totalAmt");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNull() {
            addCriterion("USER_NO is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("USER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("USER_NO =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("USER_NO <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("USER_NO >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NO >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("USER_NO <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("USER_NO <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("USER_NO like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("USER_NO not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("USER_NO in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("USER_NO not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("USER_NO between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("USER_NO not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlIsNull() {
            addCriterion("NOTYFY_URL is null");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlIsNotNull() {
            addCriterion("NOTYFY_URL is not null");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlEqualTo(String value) {
            addCriterion("NOTYFY_URL =", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlNotEqualTo(String value) {
            addCriterion("NOTYFY_URL <>", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlGreaterThan(String value) {
            addCriterion("NOTYFY_URL >", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("NOTYFY_URL >=", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlLessThan(String value) {
            addCriterion("NOTYFY_URL <", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlLessThanOrEqualTo(String value) {
            addCriterion("NOTYFY_URL <=", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlLike(String value) {
            addCriterion("NOTYFY_URL like", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlNotLike(String value) {
            addCriterion("NOTYFY_URL not like", value, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlIn(List<String> values) {
            addCriterion("NOTYFY_URL in", values, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlNotIn(List<String> values) {
            addCriterion("NOTYFY_URL not in", values, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlBetween(String value1, String value2) {
            addCriterion("NOTYFY_URL between", value1, value2, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andNotyfyUrlNotBetween(String value1, String value2) {
            addCriterion("NOTYFY_URL not between", value1, value2, "notyfyUrl");
            return (Criteria) this;
        }

        public Criteria andMerNameIsNull() {
            addCriterion("MER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerNameIsNotNull() {
            addCriterion("MER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerNameEqualTo(String value) {
            addCriterion("MER_NAME =", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotEqualTo(String value) {
            addCriterion("MER_NAME <>", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameGreaterThan(String value) {
            addCriterion("MER_NAME >", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameGreaterThanOrEqualTo(String value) {
            addCriterion("MER_NAME >=", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameLessThan(String value) {
            addCriterion("MER_NAME <", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameLessThanOrEqualTo(String value) {
            addCriterion("MER_NAME <=", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameLike(String value) {
            addCriterion("MER_NAME like", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotLike(String value) {
            addCriterion("MER_NAME not like", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameIn(List<String> values) {
            addCriterion("MER_NAME in", values, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotIn(List<String> values) {
            addCriterion("MER_NAME not in", values, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameBetween(String value1, String value2) {
            addCriterion("MER_NAME between", value1, value2, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotBetween(String value1, String value2) {
            addCriterion("MER_NAME not between", value1, value2, "merName");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagIsNull() {
            addCriterion("CURRENT_STORE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagIsNotNull() {
            addCriterion("CURRENT_STORE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagEqualTo(String value) {
            addCriterion("CURRENT_STORE_FLAG =", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagNotEqualTo(String value) {
            addCriterion("CURRENT_STORE_FLAG <>", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagGreaterThan(String value) {
            addCriterion("CURRENT_STORE_FLAG >", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENT_STORE_FLAG >=", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagLessThan(String value) {
            addCriterion("CURRENT_STORE_FLAG <", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagLessThanOrEqualTo(String value) {
            addCriterion("CURRENT_STORE_FLAG <=", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagLike(String value) {
            addCriterion("CURRENT_STORE_FLAG like", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagNotLike(String value) {
            addCriterion("CURRENT_STORE_FLAG not like", value, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagIn(List<String> values) {
            addCriterion("CURRENT_STORE_FLAG in", values, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagNotIn(List<String> values) {
            addCriterion("CURRENT_STORE_FLAG not in", values, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagBetween(String value1, String value2) {
            addCriterion("CURRENT_STORE_FLAG between", value1, value2, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentStoreFlagNotBetween(String value1, String value2) {
            addCriterion("CURRENT_STORE_FLAG not between", value1, value2, "currentStoreFlag");
            return (Criteria) this;
        }

        public Criteria andSaleAddressIsNull() {
            addCriterion("SALE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andSaleAddressIsNotNull() {
            addCriterion("SALE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andSaleAddressEqualTo(String value) {
            addCriterion("SALE_ADDRESS =", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotEqualTo(String value) {
            addCriterion("SALE_ADDRESS <>", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressGreaterThan(String value) {
            addCriterion("SALE_ADDRESS >", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressGreaterThanOrEqualTo(String value) {
            addCriterion("SALE_ADDRESS >=", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressLessThan(String value) {
            addCriterion("SALE_ADDRESS <", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressLessThanOrEqualTo(String value) {
            addCriterion("SALE_ADDRESS <=", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressLike(String value) {
            addCriterion("SALE_ADDRESS like", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotLike(String value) {
            addCriterion("SALE_ADDRESS not like", value, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressIn(List<String> values) {
            addCriterion("SALE_ADDRESS in", values, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotIn(List<String> values) {
            addCriterion("SALE_ADDRESS not in", values, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressBetween(String value1, String value2) {
            addCriterion("SALE_ADDRESS between", value1, value2, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andSaleAddressNotBetween(String value1, String value2) {
            addCriterion("SALE_ADDRESS not between", value1, value2, "saleAddress");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoIsNull() {
            addCriterion("BIZ_LICENCE_NO is null");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoIsNotNull() {
            addCriterion("BIZ_LICENCE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NO =", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoNotEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NO <>", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoGreaterThan(String value) {
            addCriterion("BIZ_LICENCE_NO >", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoGreaterThanOrEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NO >=", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoLessThan(String value) {
            addCriterion("BIZ_LICENCE_NO <", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoLessThanOrEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NO <=", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoLike(String value) {
            addCriterion("BIZ_LICENCE_NO like", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoNotLike(String value) {
            addCriterion("BIZ_LICENCE_NO not like", value, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoIn(List<String> values) {
            addCriterion("BIZ_LICENCE_NO in", values, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoNotIn(List<String> values) {
            addCriterion("BIZ_LICENCE_NO not in", values, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoBetween(String value1, String value2) {
            addCriterion("BIZ_LICENCE_NO between", value1, value2, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNoNotBetween(String value1, String value2) {
            addCriterion("BIZ_LICENCE_NO not between", value1, value2, "bizLicenceNo");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameIsNull() {
            addCriterion("BIZ_LICENCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameIsNotNull() {
            addCriterion("BIZ_LICENCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NAME =", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameNotEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NAME <>", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameGreaterThan(String value) {
            addCriterion("BIZ_LICENCE_NAME >", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameGreaterThanOrEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NAME >=", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameLessThan(String value) {
            addCriterion("BIZ_LICENCE_NAME <", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameLessThanOrEqualTo(String value) {
            addCriterion("BIZ_LICENCE_NAME <=", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameLike(String value) {
            addCriterion("BIZ_LICENCE_NAME like", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameNotLike(String value) {
            addCriterion("BIZ_LICENCE_NAME not like", value, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameIn(List<String> values) {
            addCriterion("BIZ_LICENCE_NAME in", values, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameNotIn(List<String> values) {
            addCriterion("BIZ_LICENCE_NAME not in", values, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameBetween(String value1, String value2) {
            addCriterion("BIZ_LICENCE_NAME between", value1, value2, "bizLicenceName");
            return (Criteria) this;
        }

        public Criteria andBizLicenceNameNotBetween(String value1, String value2) {
            addCriterion("BIZ_LICENCE_NAME not between", value1, value2, "bizLicenceName");
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