package com.qin.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Attendance {
    private Long id;

    private String accountName;

    private String studentId;

    private String subgroup;

    private Date gmtCreate;

    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup == null ? null : subgroup.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Attendance(Long id, String accountName, String studentId, String subgroup, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.accountName = accountName;
        this.studentId = studentId;
        this.subgroup = subgroup;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    public Attendance() {
    }
}