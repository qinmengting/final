package com.qin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Builder
@Data
@Component
public class ArtMember {
    private Long id;

    private String studentId = "";

    private String username = studentId;

    private String password = "123456";

    private Byte accountType;

    private String accountName;

    private String mobile;

    private String school;

    private String subgroup;

    private Byte sex;

    private String teacher;

    private Byte specialtyType;

    private Date joinTime;

    private Byte inGroupTime;

    private Integer attendanceCount;

    private String remark;

    private Date gmtCreate;

    private Date gmtModify;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public Byte getSpecialtyType() {
        return specialtyType;
    }

    public void setSpecialtyType(Byte specialtyType) {
        this.specialtyType = specialtyType;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getJoinTime() {
        return joinTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Byte getInGroupTime() {
        return inGroupTime;
    }

    public void setInGroupTime(Byte inGroupTime) {
        this.inGroupTime = inGroupTime;
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

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public ArtMember(Long id, String studentId, String username, String password, Byte accountType, String accountName, String mobile, String school, String subgroup, Byte sex, String teacher, Byte specialtyType, Date joinTime, Byte inGroupTime, Integer attendanceCount, String remark, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        this.accountName = accountName;
        this.mobile = mobile;
        this.school = school;
        this.subgroup = subgroup;
        this.sex = sex;
        this.teacher = teacher;
        this.specialtyType = specialtyType;
        this.joinTime = joinTime;
        this.inGroupTime = inGroupTime;
        this.attendanceCount = attendanceCount;
        this.remark = remark;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    public ArtMember() {
    }

    @Override
    public String toString() {
        return "ArtMember{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", accountName='" + accountName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", school='" + school + '\'' +
                ", subgroup='" + subgroup + '\'' +
                ", sex=" + sex +
                ", teacher='" + teacher + '\'' +
                ", specialtyType=" + specialtyType +
                ", joinTime=" + joinTime +
                ", inGroupTime=" + inGroupTime +
                ", attendanceCount=" + attendanceCount +
                ", remark='" + remark + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                '}';
    }

    public Integer getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(Integer attendanceCount) {
        this.attendanceCount = attendanceCount;
    }
}