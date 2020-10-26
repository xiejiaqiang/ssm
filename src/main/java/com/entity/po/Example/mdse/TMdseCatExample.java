package com.entity.po.Example.mdse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMdseCatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMdseCatExample() {
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

        public Criteria andMdsecatnoIsNull() {
            addCriterion("mdseCatNo is null");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoIsNotNull() {
            addCriterion("mdseCatNo is not null");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoEqualTo(String value) {
            addCriterion("mdseCatNo =", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoNotEqualTo(String value) {
            addCriterion("mdseCatNo <>", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoGreaterThan(String value) {
            addCriterion("mdseCatNo >", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoGreaterThanOrEqualTo(String value) {
            addCriterion("mdseCatNo >=", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoLessThan(String value) {
            addCriterion("mdseCatNo <", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoLessThanOrEqualTo(String value) {
            addCriterion("mdseCatNo <=", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoLike(String value) {
            addCriterion("mdseCatNo like", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoNotLike(String value) {
            addCriterion("mdseCatNo not like", value, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoIn(List<String> values) {
            addCriterion("mdseCatNo in", values, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoNotIn(List<String> values) {
            addCriterion("mdseCatNo not in", values, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoBetween(String value1, String value2) {
            addCriterion("mdseCatNo between", value1, value2, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnoNotBetween(String value1, String value2) {
            addCriterion("mdseCatNo not between", value1, value2, "mdsecatno");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameIsNull() {
            addCriterion("mdseCatName is null");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameIsNotNull() {
            addCriterion("mdseCatName is not null");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameEqualTo(String value) {
            addCriterion("mdseCatName =", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameNotEqualTo(String value) {
            addCriterion("mdseCatName <>", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameGreaterThan(String value) {
            addCriterion("mdseCatName >", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameGreaterThanOrEqualTo(String value) {
            addCriterion("mdseCatName >=", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameLessThan(String value) {
            addCriterion("mdseCatName <", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameLessThanOrEqualTo(String value) {
            addCriterion("mdseCatName <=", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameLike(String value) {
            addCriterion("mdseCatName like", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameNotLike(String value) {
            addCriterion("mdseCatName not like", value, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameIn(List<String> values) {
            addCriterion("mdseCatName in", values, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameNotIn(List<String> values) {
            addCriterion("mdseCatName not in", values, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameBetween(String value1, String value2) {
            addCriterion("mdseCatName between", value1, value2, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andMdsecatnameNotBetween(String value1, String value2) {
            addCriterion("mdseCatName not between", value1, value2, "mdsecatname");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Long value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Long value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Long value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Long value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Long value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Long value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Long> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Long> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Long value1, Long value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Long value1, Long value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreationtimeIsNull() {
            addCriterion("creationTime is null");
            return (Criteria) this;
        }

        public Criteria andCreationtimeIsNotNull() {
            addCriterion("creationTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreationtimeEqualTo(Date value) {
            addCriterion("creationTime =", value, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeNotEqualTo(Date value) {
            addCriterion("creationTime <>", value, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeGreaterThan(Date value) {
            addCriterion("creationTime >", value, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creationTime >=", value, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeLessThan(Date value) {
            addCriterion("creationTime <", value, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeLessThanOrEqualTo(Date value) {
            addCriterion("creationTime <=", value, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeIn(List<Date> values) {
            addCriterion("creationTime in", values, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeNotIn(List<Date> values) {
            addCriterion("creationTime not in", values, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeBetween(Date value1, Date value2) {
            addCriterion("creationTime between", value1, value2, "creationtime");
            return (Criteria) this;
        }

        public Criteria andCreationtimeNotBetween(Date value1, Date value2) {
            addCriterion("creationTime not between", value1, value2, "creationtime");
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