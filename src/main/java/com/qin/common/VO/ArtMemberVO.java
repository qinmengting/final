package com.qin.common.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ArtMemberVO {

    private Long id;

    private String username;

    private String password;

    private String accountName;

    private String accountType;

    private String mobile;

    private String studentId;

    private String school;

    private String subgroup;

    private String sex;

    private String teacher;

    private String specialtyType;

    private Date joinTime;

    private Byte inGroupTime;

    private String remark;

    private Integer attendanceCount;

    private Integer performanceCount;

    private Double attendanceScore;

    private Double usuallyScore;

    private Double workScore;

    private Double totalScore;

    public Integer getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(Integer attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public Integer getPerformanceCount() {
        return performanceCount;
    }

    public void setPerformanceCount(Integer performanceCount) {
        this.performanceCount = performanceCount;
    }

    public Double getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(Double attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public Double getUsuallyScore() {
        return usuallyScore;
    }

    public void setUsuallyScore(Double usuallyScore) {
        this.usuallyScore = usuallyScore;
    }

    public Double getWorkScore() {
        return workScore;
    }

    public void setWorkScore(Double workScore) {
        this.workScore = workScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSpecialtyType() {
        return specialtyType;
    }

    public void setSpecialtyType(String specialtyType) {
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
        this.remark = remark;
    }

    public ArtMemberVO() {
    }

    public ArtMemberVO(Long id, String username, String password, String accountName, String accountType, String mobile, String studentId, String school, String subgroup, String sex, String teacher, String specialtyType, Date joinTime, Byte inGroupTime, String remark, Integer attendanceCount, Integer performanceCount, Double attendanceScore, Double usuallyScore, Double workScore, Double totalScore) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountName = accountName;
        this.accountType = accountType;
        this.mobile = mobile;
        this.studentId = studentId;
        this.school = school;
        this.subgroup = subgroup;
        this.sex = sex;
        this.teacher = teacher;
        this.specialtyType = specialtyType;
        this.joinTime = joinTime;
        this.inGroupTime = inGroupTime;
        this.remark = remark;
        this.attendanceCount = attendanceCount;
        this.performanceCount = performanceCount;
        this.attendanceScore = attendanceScore;
        this.usuallyScore = usuallyScore;
        this.workScore = workScore;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "ArtMemberVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", mobile='" + mobile + '\'' +
                ", studentId='" + studentId + '\'' +
                ", school='" + school + '\'' +
                ", subgroup='" + subgroup + '\'' +
                ", sex='" + sex + '\'' +
                ", teacher='" + teacher + '\'' +
                ", specialtyType='" + specialtyType + '\'' +
                ", joinTime=" + joinTime +
                ", inGroupTime=" + inGroupTime +
                ", remark='" + remark + '\'' +
                ", attendanceCount=" + attendanceCount +
                ", performanceCount=" + performanceCount +
                ", attendanceScore=" + attendanceScore +
                ", usuallyScore=" + usuallyScore +
                ", workScore=" + workScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
