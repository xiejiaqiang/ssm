package com.entity.po.Example.mdse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMdseInfoExample {
    protected String orderByClause;

    protected BigDecimal retailPriceMin;

    protected BigDecimal retailPriceMax;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMdseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public BigDecimal getRetailPriceMin() {
        return retailPriceMin;
    }

    public void setRetailPriceMin(BigDecimal retailPriceMin) {
        this.retailPriceMin = retailPriceMin;
    }

    public BigDecimal getRetailPriceMax() {
        return retailPriceMax;
    }

    public void setRetailPriceMax(BigDecimal retailPriceMax) {
        this.retailPriceMax = retailPriceMax;
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

        public Criteria andMdsenameIsNull() {
            addCriterion("mdseName is null");
            return (Criteria) this;
        }

        public Criteria andMdsenameIsNotNull() {
            addCriterion("mdseName is not null");
            return (Criteria) this;
        }

        public Criteria andMdsenameEqualTo(String value) {
            addCriterion("mdseName =", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameNotEqualTo(String value) {
            addCriterion("mdseName <>", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameGreaterThan(String value) {
            addCriterion("mdseName >", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameGreaterThanOrEqualTo(String value) {
            addCriterion("mdseName >=", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameLessThan(String value) {
            addCriterion("mdseName <", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameLessThanOrEqualTo(String value) {
            addCriterion("mdseName <=", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameLike(String value) {
            addCriterion("mdseName like", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameNotLike(String value) {
            addCriterion("mdseName not like", value, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameIn(List<String> values) {
            addCriterion("mdseName in", values, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameNotIn(List<String> values) {
            addCriterion("mdseName not in", values, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameBetween(String value1, String value2) {
            addCriterion("mdseName between", value1, value2, "mdsename");
            return (Criteria) this;
        }

        public Criteria andMdsenameNotBetween(String value1, String value2) {
            addCriterion("mdseName not between", value1, value2, "mdsename");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andColourIsNull() {
            addCriterion("colour is null");
            return (Criteria) this;
        }

        public Criteria andColourIsNotNull() {
            addCriterion("colour is not null");
            return (Criteria) this;
        }

        public Criteria andColourEqualTo(String value) {
            addCriterion("colour =", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotEqualTo(String value) {
            addCriterion("colour <>", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourGreaterThan(String value) {
            addCriterion("colour >", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourGreaterThanOrEqualTo(String value) {
            addCriterion("colour >=", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLessThan(String value) {
            addCriterion("colour <", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLessThanOrEqualTo(String value) {
            addCriterion("colour <=", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLike(String value) {
            addCriterion("colour like", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotLike(String value) {
            addCriterion("colour not like", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourIn(List<String> values) {
            addCriterion("colour in", values, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotIn(List<String> values) {
            addCriterion("colour not in", values, "colour");
            return (Criteria) this;
        }

        public Criteria andColourBetween(String value1, String value2) {
            addCriterion("colour between", value1, value2, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotBetween(String value1, String value2) {
            addCriterion("colour not between", value1, value2, "colour");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andMdsecatIsNull() {
            addCriterion("mdseCat is null");
            return (Criteria) this;
        }

        public Criteria andMdsecatIsNotNull() {
            addCriterion("mdseCat is not null");
            return (Criteria) this;
        }

        public Criteria andMdsecatEqualTo(String value) {
            addCriterion("mdseCat =", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatNotEqualTo(String value) {
            addCriterion("mdseCat <>", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatGreaterThan(String value) {
            addCriterion("mdseCat >", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatGreaterThanOrEqualTo(String value) {
            addCriterion("mdseCat >=", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatLessThan(String value) {
            addCriterion("mdseCat <", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatLessThanOrEqualTo(String value) {
            addCriterion("mdseCat <=", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatLike(String value) {
            addCriterion("mdseCat like", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatNotLike(String value) {
            addCriterion("mdseCat not like", value, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatIn(List<String> values) {
            addCriterion("mdseCat in", values, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatNotIn(List<String> values) {
            addCriterion("mdseCat not in", values, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatBetween(String value1, String value2) {
            addCriterion("mdseCat between", value1, value2, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdsecatNotBetween(String value1, String value2) {
            addCriterion("mdseCat not between", value1, value2, "mdsecat");
            return (Criteria) this;
        }

        public Criteria andMdseskuIsNull() {
            addCriterion("mdseSku is null");
            return (Criteria) this;
        }

        public Criteria andMdseskuIsNotNull() {
            addCriterion("mdseSku is not null");
            return (Criteria) this;
        }

        public Criteria andMdseskuEqualTo(Byte value) {
            addCriterion("mdseSku =", value, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuNotEqualTo(Byte value) {
            addCriterion("mdseSku <>", value, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuGreaterThan(Byte value) {
            addCriterion("mdseSku >", value, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuGreaterThanOrEqualTo(Byte value) {
            addCriterion("mdseSku >=", value, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuLessThan(Byte value) {
            addCriterion("mdseSku <", value, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuLessThanOrEqualTo(Byte value) {
            addCriterion("mdseSku <=", value, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuIn(List<Byte> values) {
            addCriterion("mdseSku in", values, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuNotIn(List<Byte> values) {
            addCriterion("mdseSku not in", values, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuBetween(Byte value1, Byte value2) {
            addCriterion("mdseSku between", value1, value2, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdseskuNotBetween(Byte value1, Byte value2) {
            addCriterion("mdseSku not between", value1, value2, "mdsesku");
            return (Criteria) this;
        }

        public Criteria andMdsestatusIsNull() {
            addCriterion("mdseStatus is null");
            return (Criteria) this;
        }

        public Criteria andMdsestatusIsNotNull() {
            addCriterion("mdseStatus is not null");
            return (Criteria) this;
        }

        public Criteria andMdsestatusEqualTo(String value) {
            addCriterion("mdseStatus =", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusNotEqualTo(String value) {
            addCriterion("mdseStatus <>", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusGreaterThan(String value) {
            addCriterion("mdseStatus >", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusGreaterThanOrEqualTo(String value) {
            addCriterion("mdseStatus >=", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusLessThan(String value) {
            addCriterion("mdseStatus <", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusLessThanOrEqualTo(String value) {
            addCriterion("mdseStatus <=", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusLike(String value) {
            addCriterion("mdseStatus like", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusNotLike(String value) {
            addCriterion("mdseStatus not like", value, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusIn(List<String> values) {
            addCriterion("mdseStatus in", values, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusNotIn(List<String> values) {
            addCriterion("mdseStatus not in", values, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusBetween(String value1, String value2) {
            addCriterion("mdseStatus between", value1, value2, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andMdsestatusNotBetween(String value1, String value2) {
            addCriterion("mdseStatus not between", value1, value2, "mdsestatus");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andSeriesIsNull() {
            addCriterion("series is null");
            return (Criteria) this;
        }

        public Criteria andSeriesIsNotNull() {
            addCriterion("series is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesEqualTo(String value) {
            addCriterion("series =", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotEqualTo(String value) {
            addCriterion("series <>", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThan(String value) {
            addCriterion("series >", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThanOrEqualTo(String value) {
            addCriterion("series >=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThan(String value) {
            addCriterion("series <", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThanOrEqualTo(String value) {
            addCriterion("series <=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLike(String value) {
            addCriterion("series like", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotLike(String value) {
            addCriterion("series not like", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesIn(List<String> values) {
            addCriterion("series in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotIn(List<String> values) {
            addCriterion("series not in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesBetween(String value1, String value2) {
            addCriterion("series between", value1, value2, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotBetween(String value1, String value2) {
            addCriterion("series not between", value1, value2, "series");
            return (Criteria) this;
        }

        public Criteria andSellingpointIsNull() {
            addCriterion("sellingPoint is null");
            return (Criteria) this;
        }

        public Criteria andSellingpointIsNotNull() {
            addCriterion("sellingPoint is not null");
            return (Criteria) this;
        }

        public Criteria andSellingpointEqualTo(String value) {
            addCriterion("sellingPoint =", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointNotEqualTo(String value) {
            addCriterion("sellingPoint <>", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointGreaterThan(String value) {
            addCriterion("sellingPoint >", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointGreaterThanOrEqualTo(String value) {
            addCriterion("sellingPoint >=", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointLessThan(String value) {
            addCriterion("sellingPoint <", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointLessThanOrEqualTo(String value) {
            addCriterion("sellingPoint <=", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointLike(String value) {
            addCriterion("sellingPoint like", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointNotLike(String value) {
            addCriterion("sellingPoint not like", value, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointIn(List<String> values) {
            addCriterion("sellingPoint in", values, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointNotIn(List<String> values) {
            addCriterion("sellingPoint not in", values, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointBetween(String value1, String value2) {
            addCriterion("sellingPoint between", value1, value2, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andSellingpointNotBetween(String value1, String value2) {
            addCriterion("sellingPoint not between", value1, value2, "sellingpoint");
            return (Criteria) this;
        }

        public Criteria andPictureidIsNull() {
            addCriterion("pictureId is null");
            return (Criteria) this;
        }

        public Criteria andPictureidIsNotNull() {
            addCriterion("pictureId is not null");
            return (Criteria) this;
        }

        public Criteria andPictureidEqualTo(String value) {
            addCriterion("pictureId =", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidNotEqualTo(String value) {
            addCriterion("pictureId <>", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidGreaterThan(String value) {
            addCriterion("pictureId >", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidGreaterThanOrEqualTo(String value) {
            addCriterion("pictureId >=", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidLessThan(String value) {
            addCriterion("pictureId <", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidLessThanOrEqualTo(String value) {
            addCriterion("pictureId <=", value, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidIn(List<String> values) {
            addCriterion("pictureId in", values, "pictureid");
            return (Criteria) this;
        }

        public Criteria andNotIn(List<String> values) {
            addCriterion("pictureId not in", values, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidBetween(String value1, String value2) {
            addCriterion("pictureId between", value1, value2, "pictureid");
            return (Criteria) this;
        }

        public Criteria andPictureidNotBetween(String value1, String value2) {
            addCriterion("pictureId not between", value1, value2, "pictureid");
            return (Criteria) this;
        }

        public Criteria andParameter1IsNull() {
            addCriterion("parameter1 is null");
            return (Criteria) this;
        }

        public Criteria andParameter1IsNotNull() {
            addCriterion("parameter1 is not null");
            return (Criteria) this;
        }

        public Criteria andParameter1EqualTo(String value) {
            addCriterion("parameter1 =", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1NotEqualTo(String value) {
            addCriterion("parameter1 <>", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1GreaterThan(String value) {
            addCriterion("parameter1 >", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1GreaterThanOrEqualTo(String value) {
            addCriterion("parameter1 >=", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1LessThan(String value) {
            addCriterion("parameter1 <", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1LessThanOrEqualTo(String value) {
            addCriterion("parameter1 <=", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1Like(String value) {
            addCriterion("parameter1 like", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1NotLike(String value) {
            addCriterion("parameter1 not like", value, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1In(List<String> values) {
            addCriterion("parameter1 in", values, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1NotIn(List<String> values) {
            addCriterion("parameter1 not in", values, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1Between(String value1, String value2) {
            addCriterion("parameter1 between", value1, value2, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter1NotBetween(String value1, String value2) {
            addCriterion("parameter1 not between", value1, value2, "parameter1");
            return (Criteria) this;
        }

        public Criteria andParameter2IsNull() {
            addCriterion("parameter2 is null");
            return (Criteria) this;
        }

        public Criteria andParameter2IsNotNull() {
            addCriterion("parameter2 is not null");
            return (Criteria) this;
        }

        public Criteria andParameter2EqualTo(String value) {
            addCriterion("parameter2 =", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2NotEqualTo(String value) {
            addCriterion("parameter2 <>", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2GreaterThan(String value) {
            addCriterion("parameter2 >", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2GreaterThanOrEqualTo(String value) {
            addCriterion("parameter2 >=", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2LessThan(String value) {
            addCriterion("parameter2 <", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2LessThanOrEqualTo(String value) {
            addCriterion("parameter2 <=", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2Like(String value) {
            addCriterion("parameter2 like", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2NotLike(String value) {
            addCriterion("parameter2 not like", value, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2In(List<String> values) {
            addCriterion("parameter2 in", values, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2NotIn(List<String> values) {
            addCriterion("parameter2 not in", values, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2Between(String value1, String value2) {
            addCriterion("parameter2 between", value1, value2, "parameter2");
            return (Criteria) this;
        }

        public Criteria andParameter2NotBetween(String value1, String value2) {
            addCriterion("parameter2 not between", value1, value2, "parameter2");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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