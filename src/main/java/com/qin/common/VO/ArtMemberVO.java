package com.qin.common.VO;

import java.util.Date;

public class ArtMemberVO {

    private String username;

    private String password;

    private String accountName;

    private Byte accountType;

    private String mobile;

    private String studentId;

    private String subgroup;

    private Byte sex;

    private String teacher;

    private Byte specialtyType;

    private Date joinTime;

    private Byte inGroupTime;

    private String remark;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Byte getSpecialtyType() {
        return specialtyType;
    }

    public void setSpecialtyType(Byte specialtyType) {
        this.specialtyType = specialtyType;
    }

    public Date getJoinTime() {
        return joinTime;
    }

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
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ArtMemberVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType=" + accountType +
                ", mobile='" + mobile + '\'' +
                ", studentId='" + studentId + '\'' +
                ", subgroup='" + subgroup + '\'' +
                ", sex=" + sex +
                ", teacher='" + teacher + '\'' +
                ", specialtyType=" + specialtyType +
                ", joinTime=" + joinTime +
                ", inGroupTime=" + inGroupTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    public ArtMemberVO(String username, String password, String accountName, Byte accountType, String mobile, String studentId, String subgroup, Byte sex, String teacher, Byte specialtyType, Date joinTime, Byte inGroupTime, String remark) {
        this.username = username;
        this.password = password;
        this.accountName = accountName;
        this.accountType = accountType;
        this.mobile = mobile;
        this.studentId = studentId;
        this.subgroup = subgroup;
        this.sex = sex;
        this.teacher = teacher;
        this.specialtyType = specialtyType;
        this.joinTime = joinTime;
        this.inGroupTime = inGroupTime;
        this.remark = remark;
    }

    public ArtMemberVO() {
    }
}