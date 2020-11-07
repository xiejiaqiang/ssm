package com.entity.po.Example.mdse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TMdseSalesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMdseSalesExample() {
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

        public Criteria andPlatformidIsNull() {
            addCriterion("platformId is null");
            return (Criteria) this;
        }

        public Criteria andPlatformidIsNotNull() {
            addCriterion("platformId is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformidEqualTo(String value) {
            addCriterion("platformId =", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidNotEqualTo(String value) {
            addCriterion("platformId <>", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidGreaterThan(String value) {
            addCriterion("platformId >", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidGreaterThanOrEqualTo(String value) {
            addCriterion("platformId >=", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidLessThan(String value) {
            addCriterion("platformId <", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidLessThanOrEqualTo(String value) {
            addCriterion("platformId <=", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidLike(String value) {
            addCriterion("platformId like", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidNotLike(String value) {
            addCriterion("platformId not like", value, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidIn(List<String> values) {
            addCriterion("platformId in", values, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidNotIn(List<String> values) {
            addCriterion("platformId not in", values, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidBetween(String value1, String value2) {
            addCriterion("platformId between", value1, value2, "platformid");
            return (Criteria) this;
        }

        public Criteria andPlatformidNotBetween(String value1, String value2) {
            addCriterion("platformId not between", value1, value2, "platformid");
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

        public Criteria andSaleschannelIsNull() {
            addCriterion("salesChannel is null");
            return (Criteria) this;
        }

        public Criteria andSaleschannelIsNotNull() {
            addCriterion("salesChannel is not null");
            return (Criteria) this;
        }

        public Criteria andSaleschannelEqualTo(String value) {
            addCriterion("salesChannel =", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelNotEqualTo(String value) {
            addCriterion("salesChannel <>", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelGreaterThan(String value) {
            addCriterion("salesChannel >", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelGreaterThanOrEqualTo(String value) {
            addCriterion("salesChannel >=", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelLessThan(String value) {
            addCriterion("salesChannel <", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelLessThanOrEqualTo(String value) {
            addCriterion("salesChannel <=", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelLike(String value) {
            addCriterion("salesChannel like", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelNotLike(String value) {
            addCriterion("salesChannel not like", value, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelIn(List<String> values) {
            addCriterion("salesChannel in", values, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelNotIn(List<String> values) {
            addCriterion("salesChannel not in", values, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelBetween(String value1, String value2) {
            addCriterion("salesChannel between", value1, value2, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andSaleschannelNotBetween(String value1, String value2) {
            addCriterion("salesChannel not between", value1, value2, "saleschannel");
            return (Criteria) this;
        }

        public Criteria andDailypriceIsNull() {
            addCriterion("dailyPrice is null");
            return (Criteria) this;
        }

        public Criteria andDailypriceIsNotNull() {
            addCriterion("dailyPrice is not null");
            return (Criteria) this;
        }

        public Criteria andDailypriceEqualTo(BigDecimal value) {
            addCriterion("dailyPrice =", value, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceNotEqualTo(BigDecimal value) {
            addCriterion("dailyPrice <>", value, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceGreaterThan(BigDecimal value) {
            addCriterion("dailyPrice >", value, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dailyPrice >=", value, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceLessThan(BigDecimal value) {
            addCriterion("dailyPrice <", value, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dailyPrice <=", value, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceIn(List<BigDecimal> values) {
            addCriterion("dailyPrice in", values, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceNotIn(List<BigDecimal> values) {
            addCriterion("dailyPrice not in", values, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dailyPrice between", value1, value2, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andDailypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dailyPrice not between", value1, value2, "dailyprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceIsNull() {
            addCriterion("activityPrice is null");
            return (Criteria) this;
        }

        public Criteria andActivitypriceIsNotNull() {
            addCriterion("activityPrice is not null");
            return (Criteria) this;
        }

        public Criteria andActivitypriceEqualTo(BigDecimal value) {
            addCriterion("activityPrice =", value, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceNotEqualTo(BigDecimal value) {
            addCriterion("activityPrice <>", value, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceGreaterThan(BigDecimal value) {
            addCriterion("activityPrice >", value, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("activityPrice >=", value, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceLessThan(BigDecimal value) {
            addCriterion("activityPrice <", value, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("activityPrice <=", value, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceIn(List<BigDecimal> values) {
            addCriterion("activityPrice in", values, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceNotIn(List<BigDecimal> values) {
            addCriterion("activityPrice not in", values, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("activityPrice between", value1, value2, "activityprice");
            return (Criteria) this;
        }

        public Criteria andActivitypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("activityPrice not between", value1, value2, "activityprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceIsNull() {
            addCriterion("promotionPrice is null");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceIsNotNull() {
            addCriterion("promotionPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceEqualTo(BigDecimal value) {
            addCriterion("promotionPrice =", value, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceNotEqualTo(BigDecimal value) {
            addCriterion("promotionPrice <>", value, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceGreaterThan(BigDecimal value) {
            addCriterion("promotionPrice >", value, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionPrice >=", value, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceLessThan(BigDecimal value) {
            addCriterion("promotionPrice <", value, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotionPrice <=", value, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceIn(List<BigDecimal> values) {
            addCriterion("promotionPrice in", values, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceNotIn(List<BigDecimal> values) {
            addCriterion("promotionPrice not in", values, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionPrice between", value1, value2, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPromotionpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotionPrice not between", value1, value2, "promotionprice");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountIsNull() {
            addCriterion("preferentialAmount is null");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountIsNotNull() {
            addCriterion("preferentialAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountEqualTo(BigDecimal value) {
            addCriterion("preferentialAmount =", value, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountNotEqualTo(BigDecimal value) {
            addCriterion("preferentialAmount <>", value, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountGreaterThan(BigDecimal value) {
            addCriterion("preferentialAmount >", value, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preferentialAmount >=", value, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountLessThan(BigDecimal value) {
            addCriterion("preferentialAmount <", value, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preferentialAmount <=", value, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountIn(List<BigDecimal> values) {
            addCriterion("preferentialAmount in", values, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountNotIn(List<BigDecimal> values) {
            addCriterion("preferentialAmount not in", values, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preferentialAmount between", value1, value2, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preferentialAmount not between", value1, value2, "preferentialamount");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeIsNull() {
            addCriterion("preferentialType is null");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeIsNotNull() {
            addCriterion("preferentialType is not null");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeEqualTo(String value) {
            addCriterion("preferentialType =", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeNotEqualTo(String value) {
            addCriterion("preferentialType <>", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeGreaterThan(String value) {
            addCriterion("preferentialType >", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeGreaterThanOrEqualTo(String value) {
            addCriterion("preferentialType >=", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeLessThan(String value) {
            addCriterion("preferentialType <", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeLessThanOrEqualTo(String value) {
            addCriterion("preferentialType <=", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeLike(String value) {
            addCriterion("preferentialType like", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeNotLike(String value) {
            addCriterion("preferentialType not like", value, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeIn(List<String> values) {
            addCriterion("preferentialType in", values, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeNotIn(List<String> values) {
            addCriterion("preferentialType not in", values, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeBetween(String value1, String value2) {
            addCriterion("preferentialType between", value1, value2, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andPreferentialtypeNotBetween(String value1, String value2) {
            addCriterion("preferentialType not between", value1, value2, "preferentialtype");
            return (Criteria) this;
        }

        public Criteria andSalesskuIsNull() {
            addCriterion("salesSku is null");
            return (Criteria) this;
        }

        public Criteria andSalesskuIsNotNull() {
            addCriterion("salesSku is not null");
            return (Criteria) this;
        }

        public Criteria andSalesskuEqualTo(Long value) {
            addCriterion("salesSku =", value, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuNotEqualTo(Long value) {
            addCriterion("salesSku <>", value, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuGreaterThan(Long value) {
            addCriterion("salesSku >", value, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuGreaterThanOrEqualTo(Long value) {
            addCriterion("salesSku >=", value, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuLessThan(Long value) {
            addCriterion("salesSku <", value, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuLessThanOrEqualTo(Long value) {
            addCriterion("salesSku <=", value, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuIn(List<Long> values) {
            addCriterion("salesSku in", values, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuNotIn(List<Long> values) {
            addCriterion("salesSku not in", values, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuBetween(Long value1, Long value2) {
            addCriterion("salesSku between", value1, value2, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesskuNotBetween(Long value1, Long value2) {
            addCriterion("salesSku not between", value1, value2, "salessku");
            return (Criteria) this;
        }

        public Criteria andSalesstatusIsNull() {
            addCriterion("salesStatus is null");
            return (Criteria) this;
        }

        public Criteria andSalesstatusIsNotNull() {
            addCriterion("salesStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSalesstatusEqualTo(String value) {
            addCriterion("salesStatus =", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusNotEqualTo(String value) {
            addCriterion("salesStatus <>", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusGreaterThan(String value) {
            addCriterion("salesStatus >", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusGreaterThanOrEqualTo(String value) {
            addCriterion("salesStatus >=", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusLessThan(String value) {
            addCriterion("salesStatus <", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusLessThanOrEqualTo(String value) {
            addCriterion("salesStatus <=", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusLike(String value) {
            addCriterion("salesStatus like", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusNotLike(String value) {
            addCriterion("salesStatus not like", value, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusIn(List<String> values) {
            addCriterion("salesStatus in", values, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusNotIn(List<String> values) {
            addCriterion("salesStatus not in", values, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusBetween(String value1, String value2) {
            addCriterion("salesStatus between", value1, value2, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andSalesstatusNotBetween(String value1, String value2) {
            addCriterion("salesStatus not between", value1, value2, "salesstatus");
            return (Criteria) this;
        }

        public Criteria andMdseurlIsNull() {
            addCriterion("mdseUrl is null");
            return (Criteria) this;
        }

        public Criteria andMdseurlIsNotNull() {
            addCriterion("mdseUrl is not null");
            return (Criteria) this;
        }

        public Criteria andMdseurlEqualTo(String value) {
            addCriterion("mdseUrl =", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlNotEqualTo(String value) {
            addCriterion("mdseUrl <>", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlGreaterThan(String value) {
            addCriterion("mdseUrl >", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlGreaterThanOrEqualTo(String value) {
            addCriterion("mdseUrl >=", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlLessThan(String value) {
            addCriterion("mdseUrl <", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlLessThanOrEqualTo(String value) {
            addCriterion("mdseUrl <=", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlLike(String value) {
            addCriterion("mdseUrl like", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlNotLike(String value) {
            addCriterion("mdseUrl not like", value, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlIn(List<String> values) {
            addCriterion("mdseUrl in", values, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlNotIn(List<String> values) {
            addCriterion("mdseUrl not in", values, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlBetween(String value1, String value2) {
            addCriterion("mdseUrl between", value1, value2, "mdseurl");
            return (Criteria) this;
        }

        public Criteria andMdseurlNotBetween(String value1, String value2) {
            addCriterion("mdseUrl not between", value1, value2, "mdseurl");
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