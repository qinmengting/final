package com.qin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIsNull() {
            addCriterion("activity_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIsNotNull() {
            addCriterion("activity_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTimeEqualTo(Date value) {
            addCriterion("activity_time =", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotEqualTo(Date value) {
            addCriterion("activity_time <>", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeGreaterThan(Date value) {
            addCriterion("activity_time >", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_time >=", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeLessThan(Date value) {
            addCriterion("activity_time <", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_time <=", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIn(List<Date> values) {
            addCriterion("activity_time in", values, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotIn(List<Date> values) {
            addCriterion("activity_time not in", values, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeBetween(Date value1, Date value2) {
            addCriterion("activity_time between", value1, value2, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_time not between", value1, value2, "activityTime");
            return (Criteria) this;
        }

        public Criteria andSubgroupIsNull() {
            addCriterion("subgroup is null");
            return (Criteria) this;
        }

        public Criteria andSubgroupIsNotNull() {
            addCriterion("subgroup is not null");
            return (Criteria) this;
        }

        public Criteria andSubgroupEqualTo(String value) {
            addCriterion("subgroup =", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupNotEqualTo(String value) {
            addCriterion("subgroup <>", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupGreaterThan(String value) {
            addCriterion("subgroup >", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupGreaterThanOrEqualTo(String value) {
            addCriterion("subgroup >=", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupLessThan(String value) {
            addCriterion("subgroup <", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupLessThanOrEqualTo(String value) {
            addCriterion("subgroup <=", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupLike(String value) {
            addCriterion("subgroup like", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupNotLike(String value) {
            addCriterion("subgroup not like", value, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupIn(List<String> values) {
            addCriterion("subgroup in", values, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupNotIn(List<String> values) {
            addCriterion("subgroup not in", values, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupBetween(String value1, String value2) {
            addCriterion("subgroup between", value1, value2, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupNotBetween(String value1, String value2) {
            addCriterion("subgroup not between", value1, value2, "subgroup");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminIsNull() {
            addCriterion("subgroup_admin is null");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminIsNotNull() {
            addCriterion("subgroup_admin is not null");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminEqualTo(String value) {
            addCriterion("subgroup_admin =", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminNotEqualTo(String value) {
            addCriterion("subgroup_admin <>", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminGreaterThan(String value) {
            addCriterion("subgroup_admin >", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminGreaterThanOrEqualTo(String value) {
            addCriterion("subgroup_admin >=", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminLessThan(String value) {
            addCriterion("subgroup_admin <", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminLessThanOrEqualTo(String value) {
            addCriterion("subgroup_admin <=", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminLike(String value) {
            addCriterion("subgroup_admin like", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminNotLike(String value) {
            addCriterion("subgroup_admin not like", value, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminIn(List<String> values) {
            addCriterion("subgroup_admin in", values, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminNotIn(List<String> values) {
            addCriterion("subgroup_admin not in", values, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminBetween(String value1, String value2) {
            addCriterion("subgroup_admin between", value1, value2, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andSubgroupAdminNotBetween(String value1, String value2) {
            addCriterion("subgroup_admin not between", value1, value2, "subgroupAdmin");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdIsNull() {
            addCriterion("admin_student_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdIsNotNull() {
            addCriterion("admin_student_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdEqualTo(String value) {
            addCriterion("admin_student_id =", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdNotEqualTo(String value) {
            addCriterion("admin_student_id <>", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdGreaterThan(String value) {
            addCriterion("admin_student_id >", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("admin_student_id >=", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdLessThan(String value) {
            addCriterion("admin_student_id <", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdLessThanOrEqualTo(String value) {
            addCriterion("admin_student_id <=", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdLike(String value) {
            addCriterion("admin_student_id like", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdNotLike(String value) {
            addCriterion("admin_student_id not like", value, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdIn(List<String> values) {
            addCriterion("admin_student_id in", values, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdNotIn(List<String> values) {
            addCriterion("admin_student_id not in", values, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdBetween(String value1, String value2) {
            addCriterion("admin_student_id between", value1, value2, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andAdminStudentIdNotBetween(String value1, String value2) {
            addCriterion("admin_student_id not between", value1, value2, "adminStudentId");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIsNull() {
            addCriterion("applicant_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIsNotNull() {
            addCriterion("applicant_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantNameEqualTo(String value) {
            addCriterion("applicant_name =", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotEqualTo(String value) {
            addCriterion("applicant_name <>", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThan(String value) {
            addCriterion("applicant_name >", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_name >=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThan(String value) {
            addCriterion("applicant_name <", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThanOrEqualTo(String value) {
            addCriterion("applicant_name <=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLike(String value) {
            addCriterion("applicant_name like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotLike(String value) {
            addCriterion("applicant_name not like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIn(List<String> values) {
            addCriterion("applicant_name in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotIn(List<String> values) {
            addCriterion("applicant_name not in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameBetween(String value1, String value2) {
            addCriterion("applicant_name between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotBetween(String value1, String value2) {
            addCriterion("applicant_name not between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIsNull() {
            addCriterion("applicant_phone is null");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIsNotNull() {
            addCriterion("applicant_phone is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneEqualTo(String value) {
            addCriterion("applicant_phone =", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotEqualTo(String value) {
            addCriterion("applicant_phone <>", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThan(String value) {
            addCriterion("applicant_phone >", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_phone >=", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThan(String value) {
            addCriterion("applicant_phone <", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThanOrEqualTo(String value) {
            addCriterion("applicant_phone <=", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLike(String value) {
            addCriterion("applicant_phone like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotLike(String value) {
            addCriterion("applicant_phone not like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIn(List<String> values) {
            addCriterion("applicant_phone in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotIn(List<String> values) {
            addCriterion("applicant_phone not in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneBetween(String value1, String value2) {
            addCriterion("applicant_phone between", value1, value2, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotBetween(String value1, String value2) {
            addCriterion("applicant_phone not between", value1, value2, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andActivityInformationIsNull() {
            addCriterion("activity_information is null");
            return (Criteria) this;
        }

        public Criteria andActivityInformationIsNotNull() {
            addCriterion("activity_information is not null");
            return (Criteria) this;
        }

        public Criteria andActivityInformationEqualTo(String value) {
            addCriterion("activity_information =", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationNotEqualTo(String value) {
            addCriterion("activity_information <>", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationGreaterThan(String value) {
            addCriterion("activity_information >", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationGreaterThanOrEqualTo(String value) {
            addCriterion("activity_information >=", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationLessThan(String value) {
            addCriterion("activity_information <", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationLessThanOrEqualTo(String value) {
            addCriterion("activity_information <=", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationLike(String value) {
            addCriterion("activity_information like", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationNotLike(String value) {
            addCriterion("activity_information not like", value, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationIn(List<String> values) {
            addCriterion("activity_information in", values, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationNotIn(List<String> values) {
            addCriterion("activity_information not in", values, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationBetween(String value1, String value2) {
            addCriterion("activity_information between", value1, value2, "activityInformation");
            return (Criteria) this;
        }

        public Criteria andActivityInformationNotBetween(String value1, String value2) {
            addCriterion("activity_information not between", value1, value2, "activityInformation");
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