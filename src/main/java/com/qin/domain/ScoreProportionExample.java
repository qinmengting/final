package com.qin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreProportionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScoreProportionExample() {
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

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andAttendancePropIsNull() {
            addCriterion("attendance_prop is null");
            return (Criteria) this;
        }

        public Criteria andAttendancePropIsNotNull() {
            addCriterion("attendance_prop is not null");
            return (Criteria) this;
        }

        public Criteria andAttendancePropEqualTo(Double value) {
            addCriterion("attendance_prop =", value, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropNotEqualTo(Double value) {
            addCriterion("attendance_prop <>", value, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropGreaterThan(Double value) {
            addCriterion("attendance_prop >", value, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropGreaterThanOrEqualTo(Double value) {
            addCriterion("attendance_prop >=", value, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropLessThan(Double value) {
            addCriterion("attendance_prop <", value, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropLessThanOrEqualTo(Double value) {
            addCriterion("attendance_prop <=", value, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropIn(List<Double> values) {
            addCriterion("attendance_prop in", values, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropNotIn(List<Double> values) {
            addCriterion("attendance_prop not in", values, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropBetween(Double value1, Double value2) {
            addCriterion("attendance_prop between", value1, value2, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andAttendancePropNotBetween(Double value1, Double value2) {
            addCriterion("attendance_prop not between", value1, value2, "attendanceProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropIsNull() {
            addCriterion("usually_prop is null");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropIsNotNull() {
            addCriterion("usually_prop is not null");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropEqualTo(Double value) {
            addCriterion("usually_prop =", value, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropNotEqualTo(Double value) {
            addCriterion("usually_prop <>", value, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropGreaterThan(Double value) {
            addCriterion("usually_prop >", value, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropGreaterThanOrEqualTo(Double value) {
            addCriterion("usually_prop >=", value, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropLessThan(Double value) {
            addCriterion("usually_prop <", value, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropLessThanOrEqualTo(Double value) {
            addCriterion("usually_prop <=", value, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropIn(List<Double> values) {
            addCriterion("usually_prop in", values, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropNotIn(List<Double> values) {
            addCriterion("usually_prop not in", values, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropBetween(Double value1, Double value2) {
            addCriterion("usually_prop between", value1, value2, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andUsuallyPropNotBetween(Double value1, Double value2) {
            addCriterion("usually_prop not between", value1, value2, "usuallyProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropIsNull() {
            addCriterion("work_prop is null");
            return (Criteria) this;
        }

        public Criteria andWorkPropIsNotNull() {
            addCriterion("work_prop is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPropEqualTo(Double value) {
            addCriterion("work_prop =", value, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropNotEqualTo(Double value) {
            addCriterion("work_prop <>", value, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropGreaterThan(Double value) {
            addCriterion("work_prop >", value, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropGreaterThanOrEqualTo(Double value) {
            addCriterion("work_prop >=", value, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropLessThan(Double value) {
            addCriterion("work_prop <", value, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropLessThanOrEqualTo(Double value) {
            addCriterion("work_prop <=", value, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropIn(List<Double> values) {
            addCriterion("work_prop in", values, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropNotIn(List<Double> values) {
            addCriterion("work_prop not in", values, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropBetween(Double value1, Double value2) {
            addCriterion("work_prop between", value1, value2, "workProp");
            return (Criteria) this;
        }

        public Criteria andWorkPropNotBetween(Double value1, Double value2) {
            addCriterion("work_prop not between", value1, value2, "workProp");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceIsNull() {
            addCriterion("total_attendance is null");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceIsNotNull() {
            addCriterion("total_attendance is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceEqualTo(Integer value) {
            addCriterion("total_attendance =", value, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceNotEqualTo(Integer value) {
            addCriterion("total_attendance <>", value, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceGreaterThan(Integer value) {
            addCriterion("total_attendance >", value, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_attendance >=", value, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceLessThan(Integer value) {
            addCriterion("total_attendance <", value, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceLessThanOrEqualTo(Integer value) {
            addCriterion("total_attendance <=", value, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceIn(List<Integer> values) {
            addCriterion("total_attendance in", values, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceNotIn(List<Integer> values) {
            addCriterion("total_attendance not in", values, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceBetween(Integer value1, Integer value2) {
            addCriterion("total_attendance between", value1, value2, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andTotalAttendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("total_attendance not between", value1, value2, "totalAttendance");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
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