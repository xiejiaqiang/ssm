package com.entity.po.Example.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TGiftInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TGiftInfoExample() {
        oredCriteria = new ArrayList();
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
            criteria = new ArrayList();
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

        public Criteria andGiftnoIsNull() {
            addCriterion("giftNo is null");
            return (Criteria) this;
        }

        public Criteria andGiftnoIsNotNull() {
            addCriterion("giftNo is not null");
            return (Criteria) this;
        }

        public Criteria andGiftnoEqualTo(String value) {
            addCriterion("giftNo =", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoNotEqualTo(String value) {
            addCriterion("giftNo <>", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoGreaterThan(String value) {
            addCriterion("giftNo >", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoGreaterThanOrEqualTo(String value) {
            addCriterion("giftNo >=", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoLessThan(String value) {
            addCriterion("giftNo <", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoLessThanOrEqualTo(String value) {
            addCriterion("giftNo <=", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoLike(String value) {
            addCriterion("giftNo like", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoNotLike(String value) {
            addCriterion("giftNo not like", value, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoIn(List<String> values) {
            addCriterion("giftNo in", values, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoNotIn(List<String> values) {
            addCriterion("giftNo not in", values, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoBetween(String value1, String value2) {
            addCriterion("giftNo between", value1, value2, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnoNotBetween(String value1, String value2) {
            addCriterion("giftNo not between", value1, value2, "giftno");
            return (Criteria) this;
        }

        public Criteria andGiftnameIsNull() {
            addCriterion("giftName is null");
            return (Criteria) this;
        }

        public Criteria andGiftnameIsNotNull() {
            addCriterion("giftName is not null");
            return (Criteria) this;
        }

        public Criteria andGiftnameEqualTo(String value) {
            addCriterion("giftName =", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameNotEqualTo(String value) {
            addCriterion("giftName <>", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameGreaterThan(String value) {
            addCriterion("giftName >", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameGreaterThanOrEqualTo(String value) {
            addCriterion("giftName >=", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameLessThan(String value) {
            addCriterion("giftName <", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameLessThanOrEqualTo(String value) {
            addCriterion("giftName <=", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameLike(String value) {
            addCriterion("giftName like", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameNotLike(String value) {
            addCriterion("giftName not like", value, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameIn(List<String> values) {
            addCriterion("giftName in", values, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameNotIn(List<String> values) {
            addCriterion("giftName not in", values, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameBetween(String value1, String value2) {
            addCriterion("giftName between", value1, value2, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftnameNotBetween(String value1, String value2) {
            addCriterion("giftName not between", value1, value2, "giftname");
            return (Criteria) this;
        }

        public Criteria andGiftlinkIsNull() {
            addCriterion("giftLink is null");
            return (Criteria) this;
        }

        public Criteria andGiftlinkIsNotNull() {
            addCriterion("giftLink is not null");
            return (Criteria) this;
        }

        public Criteria andGiftlinkEqualTo(String value) {
            addCriterion("giftLink =", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkNotEqualTo(String value) {
            addCriterion("giftLink <>", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkGreaterThan(String value) {
            addCriterion("giftLink >", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkGreaterThanOrEqualTo(String value) {
            addCriterion("giftLink >=", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkLessThan(String value) {
            addCriterion("giftLink <", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkLessThanOrEqualTo(String value) {
            addCriterion("giftLink <=", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkLike(String value) {
            addCriterion("giftLink like", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkNotLike(String value) {
            addCriterion("giftLink not like", value, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkIn(List<String> values) {
            addCriterion("giftLink in", values, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkNotIn(List<String> values) {
            addCriterion("giftLink not in", values, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkBetween(String value1, String value2) {
            addCriterion("giftLink between", value1, value2, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftlinkNotBetween(String value1, String value2) {
            addCriterion("giftLink not between", value1, value2, "giftlink");
            return (Criteria) this;
        }

        public Criteria andGiftamountIsNull() {
            addCriterion("giftAmount is null");
            return (Criteria) this;
        }

        public Criteria andGiftamountIsNotNull() {
            addCriterion("giftAmount is not null");
            return (Criteria) this;
        }

        public Criteria andGiftamountEqualTo(BigDecimal value) {
            addCriterion("giftAmount =", value, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountNotEqualTo(BigDecimal value) {
            addCriterion("giftAmount <>", value, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountGreaterThan(BigDecimal value) {
            addCriterion("giftAmount >", value, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("giftAmount >=", value, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountLessThan(BigDecimal value) {
            addCriterion("giftAmount <", value, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("giftAmount <=", value, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountIn(List<BigDecimal> values) {
            addCriterion("giftAmount in", values, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountNotIn(List<BigDecimal> values) {
            addCriterion("giftAmount not in", values, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("giftAmount between", value1, value2, "giftamount");
            return (Criteria) this;
        }

        public Criteria andGiftamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("giftAmount not between", value1, value2, "giftamount");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andGiftimgIsNull() {
            addCriterion("giftImg is null");
            return (Criteria) this;
        }

        public Criteria andGiftimgIsNotNull() {
            addCriterion("giftImg is not null");
            return (Criteria) this;
        }

        public Criteria andGiftimgEqualTo(String value) {
            addCriterion("giftImg =", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgNotEqualTo(String value) {
            addCriterion("giftImg <>", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgGreaterThan(String value) {
            addCriterion("giftImg >", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgGreaterThanOrEqualTo(String value) {
            addCriterion("giftImg >=", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgLessThan(String value) {
            addCriterion("giftImg <", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgLessThanOrEqualTo(String value) {
            addCriterion("giftImg <=", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgLike(String value) {
            addCriterion("giftImg like", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgNotLike(String value) {
            addCriterion("giftImg not like", value, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgIn(List<String> values) {
            addCriterion("giftImg in", values, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgNotIn(List<String> values) {
            addCriterion("giftImg not in", values, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgBetween(String value1, String value2) {
            addCriterion("giftImg between", value1, value2, "giftimg");
            return (Criteria) this;
        }

        public Criteria andGiftimgNotBetween(String value1, String value2) {
            addCriterion("giftImg not between", value1, value2, "giftimg");
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