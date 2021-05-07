package com.qin.common.query;

import com.qin.common.base.BaseQuery;

public class AttendanceQuery extends BaseQuery {

    private String accountName;

    private String studentId;

    private String subgroup;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public AttendanceQuery(Integer page, Integer limit, String accountName, String studentId, String subgroup) {
        super(page, limit);
        this.accountName = accountName;
        this.studentId = studentId;
        this.subgroup = subgroup;
    }

    public AttendanceQuery(String accountName, String studentId, String subgroup) {
        this.accountName = accountName;
        this.studentId = studentId;
        this.subgroup = subgroup;
    }

    public AttendanceQuery(Integer page, Integer limit) {
        super(page, limit);
    }

    public AttendanceQuery() {
    }
}
