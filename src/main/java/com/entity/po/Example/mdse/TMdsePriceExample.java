package com.entity.po.Example.mdse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TMdsePriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMdsePriceExample() {
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

        public Criteria andBuyingpriceIsNull() {
            addCriterion("buyingPrice is null");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIsNotNull() {
            addCriterion("buyingPrice is not null");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceEqualTo(BigDecimal value) {
            addCriterion("buyingPrice =", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotEqualTo(BigDecimal value) {
            addCriterion("buyingPrice <>", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceGreaterThan(BigDecimal value) {
            addCriterion("buyingPrice >", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buyingPrice >=", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceLessThan(BigDecimal value) {
            addCriterion("buyingPrice <", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buyingPrice <=", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIn(List<BigDecimal> values) {
            addCriterion("buyingPrice in", values, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotIn(List<BigDecimal> values) {
            addCriterion("buyingPrice not in", values, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyingPrice between", value1, value2, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buyingPrice not between", value1, value2, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceIsNull() {
            addCriterion("retailPrice is null");
            return (Criteria) this;
        }

        public Criteria andRetailpriceIsNotNull() {
            addCriterion("retailPrice is not null");
            return (Criteria) this;
        }

        public Criteria andRetailpriceEqualTo(BigDecimal value) {
            addCriterion("retailPrice =", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceNotEqualTo(BigDecimal value) {
            addCriterion("retailPrice <>", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceGreaterThan(BigDecimal value) {
            addCriterion("retailPrice >", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retailPrice >=", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceLessThan(BigDecimal value) {
            addCriterion("retailPrice <", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retailPrice <=", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceIn(List<BigDecimal> values) {
            addCriterion("retailPrice in", values, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceNotIn(List<BigDecimal> values) {
            addCriterion("retailPrice not in", values, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailPrice between", value1, value2, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailPrice not between", value1, value2, "retailprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceIsNull() {
            addCriterion("floorprice is null");
            return (Criteria) this;
        }

        public Criteria andFloorpriceIsNotNull() {
            addCriterion("floorprice is not null");
            return (Criteria) this;
        }

        public Criteria andFloorpriceEqualTo(BigDecimal value) {
            addCriterion("floorprice =", value, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceNotEqualTo(BigDecimal value) {
            addCriterion("floorprice <>", value, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceGreaterThan(BigDecimal value) {
            addCriterion("floorprice >", value, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("floorprice >=", value, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceLessThan(BigDecimal value) {
            addCriterion("floorprice <", value, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("floorprice <=", value, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceIn(List<BigDecimal> values) {
            addCriterion("floorprice in", values, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceNotIn(List<BigDecimal> values) {
            addCriterion("floorprice not in", values, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floorprice between", value1, value2, "floorprice");
            return (Criteria) this;
        }

        public Criteria andFloorpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floorprice not between", value1, value2, "floorprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceIsNull() {
            addCriterion("tradePrice is null");
            return (Criteria) this;
        }

        public Criteria andTradepriceIsNotNull() {
            addCriterion("tradePrice is not null");
            return (Criteria) this;
        }

        public Criteria andTradepriceEqualTo(BigDecimal value) {
            addCriterion("tradePrice =", value, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceNotEqualTo(BigDecimal value) {
            addCriterion("tradePrice <>", value, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceGreaterThan(BigDecimal value) {
            addCriterion("tradePrice >", value, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tradePrice >=", value, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceLessThan(BigDecimal value) {
            addCriterion("tradePrice <", value, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tradePrice <=", value, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceIn(List<BigDecimal> values) {
            addCriterion("tradePrice in", values, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceNotIn(List<BigDecimal> values) {
            addCriterion("tradePrice not in", values, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tradePrice between", value1, value2, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andTradepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tradePrice not between", value1, value2, "tradeprice");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("profit is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("profit is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(BigDecimal value) {
            addCriterion("profit =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(BigDecimal value) {
            addCriterion("profit <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(BigDecimal value) {
            addCriterion("profit >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("profit >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(BigDecimal value) {
            addCriterion("profit <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("profit <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<BigDecimal> values) {
            addCriterion("profit in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<BigDecimal> values) {
            addCriterion("profit not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit not between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitmarginIsNull() {
            addCriterion("profitMargin is null");
            return (Criteria) this;
        }

        public Criteria andProfitmarginIsNotNull() {
            addCriterion("profitMargin is not null");
            return (Criteria) this;
        }

        public Criteria andProfitmarginEqualTo(String value) {
            addCriterion("profitMargin =", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginNotEqualTo(String value) {
            addCriterion("profitMargin <>", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginGreaterThan(String value) {
            addCriterion("profitMargin >", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginGreaterThanOrEqualTo(String value) {
            addCriterion("profitMargin >=", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginLessThan(String value) {
            addCriterion("profitMargin <", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginLessThanOrEqualTo(String value) {
            addCriterion("profitMargin <=", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginLike(String value) {
            addCriterion("profitMargin like", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginNotLike(String value) {
            addCriterion("profitMargin not like", value, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginIn(List<String> values) {
            addCriterion("profitMargin in", values, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginNotIn(List<String> values) {
            addCriterion("profitMargin not in", values, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginBetween(String value1, String value2) {
            addCriterion("profitMargin between", value1, value2, "profitmargin");
            return (Criteria) this;
        }

        public Criteria andProfitmarginNotBetween(String value1, String value2) {
            addCriterion("profitMargin not between", value1, value2, "profitmargin");
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