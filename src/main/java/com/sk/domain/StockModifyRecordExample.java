package com.sk.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockModifyRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockModifyRecordExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeIsNull() {
            addCriterion("product_bar_code is null");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeIsNotNull() {
            addCriterion("product_bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeEqualTo(String value) {
            addCriterion("product_bar_code =", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeNotEqualTo(String value) {
            addCriterion("product_bar_code <>", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeGreaterThan(String value) {
            addCriterion("product_bar_code >", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_bar_code >=", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeLessThan(String value) {
            addCriterion("product_bar_code <", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeLessThanOrEqualTo(String value) {
            addCriterion("product_bar_code <=", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeLike(String value) {
            addCriterion("product_bar_code like", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeNotLike(String value) {
            addCriterion("product_bar_code not like", value, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeIn(List<String> values) {
            addCriterion("product_bar_code in", values, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeNotIn(List<String> values) {
            addCriterion("product_bar_code not in", values, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeBetween(String value1, String value2) {
            addCriterion("product_bar_code between", value1, value2, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andProductBarCodeNotBetween(String value1, String value2) {
            addCriterion("product_bar_code not between", value1, value2, "productBarCode");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andModifyCountIsNull() {
            addCriterion("modify_count is null");
            return (Criteria) this;
        }

        public Criteria andModifyCountIsNotNull() {
            addCriterion("modify_count is not null");
            return (Criteria) this;
        }

        public Criteria andModifyCountEqualTo(Integer value) {
            addCriterion("modify_count =", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountNotEqualTo(Integer value) {
            addCriterion("modify_count <>", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountGreaterThan(Integer value) {
            addCriterion("modify_count >", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("modify_count >=", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountLessThan(Integer value) {
            addCriterion("modify_count <", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountLessThanOrEqualTo(Integer value) {
            addCriterion("modify_count <=", value, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountIn(List<Integer> values) {
            addCriterion("modify_count in", values, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountNotIn(List<Integer> values) {
            addCriterion("modify_count not in", values, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountBetween(Integer value1, Integer value2) {
            addCriterion("modify_count between", value1, value2, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("modify_count not between", value1, value2, "modifyCount");
            return (Criteria) this;
        }

        public Criteria andModifyTypeIsNull() {
            addCriterion("modify_type is null");
            return (Criteria) this;
        }

        public Criteria andModifyTypeIsNotNull() {
            addCriterion("modify_type is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTypeEqualTo(String value) {
            addCriterion("modify_type =", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeNotEqualTo(String value) {
            addCriterion("modify_type <>", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeGreaterThan(String value) {
            addCriterion("modify_type >", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("modify_type >=", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeLessThan(String value) {
            addCriterion("modify_type <", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeLessThanOrEqualTo(String value) {
            addCriterion("modify_type <=", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeLike(String value) {
            addCriterion("modify_type like", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeNotLike(String value) {
            addCriterion("modify_type not like", value, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeIn(List<String> values) {
            addCriterion("modify_type in", values, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeNotIn(List<String> values) {
            addCriterion("modify_type not in", values, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeBetween(String value1, String value2) {
            addCriterion("modify_type between", value1, value2, "modifyType");
            return (Criteria) this;
        }

        public Criteria andModifyTypeNotBetween(String value1, String value2) {
            addCriterion("modify_type not between", value1, value2, "modifyType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }
    }

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