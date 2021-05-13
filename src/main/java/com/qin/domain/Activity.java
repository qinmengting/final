package com.qin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Activity {
    private Long id;

    private Byte status;

    private String activityName;

    private String applicant;

    private String location;

    private Date activityTime;

    private String subgroup;

    private String subgroupAdmin;

    private String adminStudentId;

    private String applicantName;

    private String applicantPhone;

    private String activityInformation;

    private String remark;

    private Date gmtCreate;

    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getActivityTime() {
        return activityTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup == null ? null : subgroup.trim();
    }

    public String getSubgroupAdmin() {
        return subgroupAdmin;
    }

    public void setSubgroupAdmin(String subgroupAdmin) {
        this.subgroupAdmin = subgroupAdmin == null ? null : subgroupAdmin.trim();
    }

    public String getAdminStudentId() {
        return adminStudentId;
    }

    public void setAdminStudentId(String adminStudentId) {
        this.adminStudentId = adminStudentId == null ? null : adminStudentId.trim();
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName == null ? null : applicantName.trim();
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone == null ? null : applicantPhone.trim();
    }

    public String getActivityInformation() {
        return activityInformation;
    }

    public void setActivityInformation(String activityInformation) {
        this.activityInformation = activityInformation == null ? null : activityInformation.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}