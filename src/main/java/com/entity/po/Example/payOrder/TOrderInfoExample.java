package com.entity.po.Example.payOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TOrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("orderNo is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderNo =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderNo <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderNo >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderNo >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderNo <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderNo <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderNo like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderNo not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderNo in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderNo not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderNo between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderNo not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andMdsenoIsNull() {
            addCriterion("mdseNo is null");
            return (Criteria) this;
        }

        public Criteria andMdsenoIsNotNull() {
            addCriterion("mdseNo is not null");
            return (Criteria) this;
        }

        public Criteria andMdsenoEqualTo(String value) {
            addCriterion("mdseNo =", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoNotEqualTo(String value) {
            addCriterion("mdseNo <>", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoGreaterThan(String value) {
            addCriterion("mdseNo >", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoGreaterThanOrEqualTo(String value) {
            addCriterion("mdseNo >=", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoLessThan(String value) {
            addCriterion("mdseNo <", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoLessThanOrEqualTo(String value) {
            addCriterion("mdseNo <=", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoLike(String value) {
            addCriterion("mdseNo like", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoNotLike(String value) {
            addCriterion("mdseNo not like", value, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoIn(List<String> values) {
            addCriterion("mdseNo in", values, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoNotIn(List<String> values) {
            addCriterion("mdseNo not in", values, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoBetween(String value1, String value2) {
            addCriterion("mdseNo between", value1, value2, "mdseno");
            return (Criteria) this;
        }

        public Criteria andMdsenoNotBetween(String value1, String value2) {
            addCriterion("mdseNo not between", value1, value2, "mdseno");
            return (Criteria) this;
        }

        public Criteria andCustnameIsNull() {
            addCriterion("custName is null");
            return (Criteria) this;
        }

        public Criteria andCustnameIsNotNull() {
            addCriterion("custName is not null");
            return (Criteria) this;
        }

        public Criteria andCustnameEqualTo(String value) {
            addCriterion("custName =", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotEqualTo(String value) {
            addCriterion("custName <>", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameGreaterThan(String value) {
            addCriterion("custName >", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameGreaterThanOrEqualTo(String value) {
            addCriterion("custName >=", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLessThan(String value) {
            addCriterion("custName <", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLessThanOrEqualTo(String value) {
            addCriterion("custName <=", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLike(String value) {
            addCriterion("custName like", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotLike(String value) {
            addCriterion("custName not like", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameIn(List<String> values) {
            addCriterion("custName in", values, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotIn(List<String> values) {
            addCriterion("custName not in", values, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameBetween(String value1, String value2) {
            addCriterion("custName between", value1, value2, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotBetween(String value1, String value2) {
            addCriterion("custName not between", value1, value2, "custname");
            return (Criteria) this;
        }

        public Criteria andNumbernoIsNull() {
            addCriterion("numberNo is null");
            return (Criteria) this;
        }

        public Criteria andNumbernoIsNotNull() {
            addCriterion("numberNo is not null");
            return (Criteria) this;
        }

        public Criteria andNumbernoEqualTo(String value) {
            addCriterion("numberNo =", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoNotEqualTo(String value) {
            addCriterion("numberNo <>", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoGreaterThan(String value) {
            addCriterion("numberNo >", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoGreaterThanOrEqualTo(String value) {
            addCriterion("numberNo >=", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoLessThan(String value) {
            addCriterion("numberNo <", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoLessThanOrEqualTo(String value) {
            addCriterion("numberNo <=", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoLike(String value) {
            addCriterion("numberNo like", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoNotLike(String value) {
            addCriterion("numberNo not like", value, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoIn(List<String> values) {
            addCriterion("numberNo in", values, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoNotIn(List<String> values) {
            addCriterion("numberNo not in", values, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoBetween(String value1, String value2) {
            addCriterion("numberNo between", value1, value2, "numberno");
            return (Criteria) this;
        }

        public Criteria andNumbernoNotBetween(String value1, String value2) {
            addCriterion("numberNo not between", value1, value2, "numberno");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andOrderamountIsNull() {
            addCriterion("orderAmount is null");
            return (Criteria) this;
        }

        public Criteria andOrderamountIsNotNull() {
            addCriterion("orderAmount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderamountEqualTo(BigDecimal value) {
            addCriterion("orderAmount =", value, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountNotEqualTo(BigDecimal value) {
            addCriterion("orderAmount <>", value, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountGreaterThan(BigDecimal value) {
            addCriterion("orderAmount >", value, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orderAmount >=", value, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountLessThan(BigDecimal value) {
            addCriterion("orderAmount <", value, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orderAmount <=", value, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountIn(List<BigDecimal> values) {
            addCriterion("orderAmount in", values, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountNotIn(List<BigDecimal> values) {
            addCriterion("orderAmount not in", values, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderAmount between", value1, value2, "orderamount");
            return (Criteria) this;
        }

        public Criteria andOrderamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderAmount not between", value1, value2, "orderamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountIsNull() {
            addCriterion("actPayAmount is null");
            return (Criteria) this;
        }

        public Criteria andActpayamountIsNotNull() {
            addCriterion("actPayAmount is not null");
            return (Criteria) this;
        }

        public Criteria andActpayamountEqualTo(BigDecimal value) {
            addCriterion("actPayAmount =", value, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountNotEqualTo(BigDecimal value) {
            addCriterion("actPayAmount <>", value, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountGreaterThan(BigDecimal value) {
            addCriterion("actPayAmount >", value, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actPayAmount >=", value, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountLessThan(BigDecimal value) {
            addCriterion("actPayAmount <", value, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actPayAmount <=", value, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountIn(List<BigDecimal> values) {
            addCriterion("actPayAmount in", values, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountNotIn(List<BigDecimal> values) {
            addCriterion("actPayAmount not in", values, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actPayAmount between", value1, value2, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andActpayamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actPayAmount not between", value1, value2, "actpayamount");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeIsNull() {
            addCriterion("discountType is null");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeIsNotNull() {
            addCriterion("discountType is not null");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeEqualTo(String value) {
            addCriterion("discountType =", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeNotEqualTo(String value) {
            addCriterion("discountType <>", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeGreaterThan(String value) {
            addCriterion("discountType >", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeGreaterThanOrEqualTo(String value) {
            addCriterion("discountType >=", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeLessThan(String value) {
            addCriterion("discountType <", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeLessThanOrEqualTo(String value) {
            addCriterion("discountType <=", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeLike(String value) {
            addCriterion("discountType like", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeNotLike(String value) {
            addCriterion("discountType not like", value, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeIn(List<String> values) {
            addCriterion("discountType in", values, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeNotIn(List<String> values) {
            addCriterion("discountType not in", values, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeBetween(String value1, String value2) {
            addCriterion("discountType between", value1, value2, "discounttype");
            return (Criteria) this;
        }

        public Criteria andDiscounttypeNotBetween(String value1, String value2) {
            addCriterion("discountType not between", value1, value2, "discounttype");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(String value) {
            addCriterion("orderStatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(String value) {
            addCriterion("orderStatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(String value) {
            addCriterion("orderStatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(String value) {
            addCriterion("orderStatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(String value) {
            addCriterion("orderStatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(String value) {
            addCriterion("orderStatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLike(String value) {
            addCriterion("orderStatus like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotLike(String value) {
            addCriterion("orderStatus not like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<String> values) {
            addCriterion("orderStatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<String> values) {
            addCriterion("orderStatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(String value1, String value2) {
            addCriterion("orderStatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(String value1, String value2) {
            addCriterion("orderStatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoIsNull() {
            addCriterion("logisticsNo is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoIsNotNull() {
            addCriterion("logisticsNo is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoEqualTo(String value) {
            addCriterion("logisticsNo =", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotEqualTo(String value) {
            addCriterion("logisticsNo <>", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoGreaterThan(String value) {
            addCriterion("logisticsNo >", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoGreaterThanOrEqualTo(String value) {
            addCriterion("logisticsNo >=", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoLessThan(String value) {
            addCriterion("logisticsNo <", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoLessThanOrEqualTo(String value) {
            addCriterion("logisticsNo <=", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoLike(String value) {
            addCriterion("logisticsNo like", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotLike(String value) {
            addCriterion("logisticsNo not like", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoIn(List<String> values) {
            addCriterion("logisticsNo in", values, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotIn(List<String> values) {
            addCriterion("logisticsNo not in", values, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoBetween(String value1, String value2) {
            addCriterion("logisticsNo between", value1, value2, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotBetween(String value1, String value2) {
            addCriterion("logisticsNo not between", value1, value2, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgIsNull() {
            addCriterion("invoiceFlg is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgIsNotNull() {
            addCriterion("invoiceFlg is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgEqualTo(String value) {
            addCriterion("invoiceFlg =", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgNotEqualTo(String value) {
            addCriterion("invoiceFlg <>", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgGreaterThan(String value) {
            addCriterion("invoiceFlg >", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgGreaterThanOrEqualTo(String value) {
            addCriterion("invoiceFlg >=", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgLessThan(String value) {
            addCriterion("invoiceFlg <", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgLessThanOrEqualTo(String value) {
            addCriterion("invoiceFlg <=", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgLike(String value) {
            addCriterion("invoiceFlg like", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgNotLike(String value) {
            addCriterion("invoiceFlg not like", value, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgIn(List<String> values) {
            addCriterion("invoiceFlg in", values, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgNotIn(List<String> values) {
            addCriterion("invoiceFlg not in", values, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgBetween(String value1, String value2) {
            addCriterion("invoiceFlg between", value1, value2, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoiceflgNotBetween(String value1, String value2) {
            addCriterion("invoiceFlg not between", value1, value2, "invoiceflg");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIsNull() {
            addCriterion("invoiceType is null");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIsNotNull() {
            addCriterion("invoiceType is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeEqualTo(String value) {
            addCriterion("invoiceType =", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotEqualTo(String value) {
            addCriterion("invoiceType <>", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeGreaterThan(String value) {
            addCriterion("invoiceType >", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoiceType >=", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLessThan(String value) {
            addCriterion("invoiceType <", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLessThanOrEqualTo(String value) {
            addCriterion("invoiceType <=", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLike(String value) {
            addCriterion("invoiceType like", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotLike(String value) {
            addCriterion("invoiceType not like", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIn(List<String> values) {
            addCriterion("invoiceType in", values, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotIn(List<String> values) {
            addCriterion("invoiceType not in", values, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeBetween(String value1, String value2) {
            addCriterion("invoiceType between", value1, value2, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotBetween(String value1, String value2) {
            addCriterion("invoiceType not between", value1, value2, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNull() {
            addCriterion("orderDate is null");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNotNull() {
            addCriterion("orderDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdateEqualTo(Date value) {
            addCriterionForJDBCDate("orderDate =", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("orderDate <>", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThan(Date value) {
            addCriterionForJDBCDate("orderDate >", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("orderDate >=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThan(Date value) {
            addCriterionForJDBCDate("orderDate <", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("orderDate <=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateIn(List<Date> values) {
            addCriterionForJDBCDate("orderDate in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("orderDate not in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("orderDate between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("orderDate not between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderquantityIsNull() {
            addCriterion("orderQuantity is null");
            return (Criteria) this;
        }

        public Criteria andOrderquantityIsNotNull() {
            addCriterion("orderQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andOrderquantityEqualTo(Long value) {
            addCriterion("orderQuantity =", value, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityNotEqualTo(Long value) {
            addCriterion("orderQuantity <>", value, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityGreaterThan(Long value) {
            addCriterion("orderQuantity >", value, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityGreaterThanOrEqualTo(Long value) {
            addCriterion("orderQuantity >=", value, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityLessThan(Long value) {
            addCriterion("orderQuantity <", value, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityLessThanOrEqualTo(Long value) {
            addCriterion("orderQuantity <=", value, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityIn(List<Long> values) {
            addCriterion("orderQuantity in", values, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityNotIn(List<Long> values) {
            addCriterion("orderQuantity not in", values, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityBetween(Long value1, Long value2) {
            addCriterion("orderQuantity between", value1, value2, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andOrderquantityNotBetween(Long value1, Long value2) {
            addCriterion("orderQuantity not between", value1, value2, "orderquantity");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIsNull() {
            addCriterion("purchasePrice is null");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIsNotNull() {
            addCriterion("purchasePrice is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceEqualTo(BigDecimal value) {
            addCriterion("purchasePrice =", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotEqualTo(BigDecimal value) {
            addCriterion("purchasePrice <>", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceGreaterThan(BigDecimal value) {
            addCriterion("purchasePrice >", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchasePrice >=", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceLessThan(BigDecimal value) {
            addCriterion("purchasePrice <", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchasePrice <=", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIn(List<BigDecimal> values) {
            addCriterion("purchasePrice in", values, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotIn(List<BigDecimal> values) {
            addCriterion("purchasePrice not in", values, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchasePrice between", value1, value2, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchasePrice not between", value1, value2, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceIsNull() {
            addCriterion("purchaseSource is null");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceIsNotNull() {
            addCriterion("purchaseSource is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceEqualTo(String value) {
            addCriterion("purchaseSource =", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceNotEqualTo(String value) {
            addCriterion("purchaseSource <>", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceGreaterThan(String value) {
            addCriterion("purchaseSource >", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceGreaterThanOrEqualTo(String value) {
            addCriterion("purchaseSource >=", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceLessThan(String value) {
            addCriterion("purchaseSource <", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceLessThanOrEqualTo(String value) {
            addCriterion("purchaseSource <=", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceLike(String value) {
            addCriterion("purchaseSource like", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceNotLike(String value) {
            addCriterion("purchaseSource not like", value, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceIn(List<String> values) {
            addCriterion("purchaseSource in", values, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceNotIn(List<String> values) {
            addCriterion("purchaseSource not in", values, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceBetween(String value1, String value2) {
            addCriterion("purchaseSource between", value1, value2, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andPurchasesourceNotBetween(String value1, String value2) {
            addCriterion("purchaseSource not between", value1, value2, "purchasesource");
            return (Criteria) this;
        }

        public Criteria andOrderchannelIsNull() {
            addCriterion("orderChannel is null");
            return (Criteria) this;
        }

        public Criteria andOrderchannelIsNotNull() {
            addCriterion("orderChannel is not null");
            return (Criteria) this;
        }

        public Criteria andOrderchannelEqualTo(String value) {
            addCriterion("orderChannel =", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelNotEqualTo(String value) {
            addCriterion("orderChannel <>", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelGreaterThan(String value) {
            addCriterion("orderChannel >", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelGreaterThanOrEqualTo(String value) {
            addCriterion("orderChannel >=", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelLessThan(String value) {
            addCriterion("orderChannel <", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelLessThanOrEqualTo(String value) {
            addCriterion("orderChannel <=", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelLike(String value) {
            addCriterion("orderChannel like", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelNotLike(String value) {
            addCriterion("orderChannel not like", value, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelIn(List<String> values) {
            addCriterion("orderChannel in", values, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelNotIn(List<String> values) {
            addCriterion("orderChannel not in", values, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelBetween(String value1, String value2) {
            addCriterion("orderChannel between", value1, value2, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andOrderchannelNotBetween(String value1, String value2) {
            addCriterion("orderChannel not between", value1, value2, "orderchannel");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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