package com.qin.common.DTO;

public class ArtMemberDTO {

    private Long id;

    private String studentId ;

    private String password ;

    private String username ;

    private Byte accountType;

    private String accountName;

    private String mobile;

    private String school;

    private String subgroup;

    private String teacher;

    private Byte sex;

    private Byte specialtyType;

    private String joinTime;

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.accountName = accountName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
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

    public ArtMemberDTO(Long id, String studentId, String password, String username, Byte accountType, String accountName, String mobile, String school, String subgroup, String teacher, Byte sex, Byte specialtyType, String joinTime, Byte inGroupTime, String remark, Integer attendanceCount, Integer performanceCount, Double attendanceScore, Double usuallyScore, Double workScore, Double totalScore) {
        this.id = id;
        this.studentId = studentId;
        this.password = password;
        this.username = username;
        this.accountType = accountType;
        this.accountName = accountName;
        this.mobile = mobile;
        this.school = school;
        this.subgroup = subgroup;
        this.teacher = teacher;
        this.sex = sex;
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
        return "ArtMemberDTO{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", accountType=" + accountType +
                ", accountName='" + accountName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", school='" + school + '\'' +
                ", subgroup='" + subgroup + '\'' +
                ", teacher='" + teacher + '\'' +
                ", sex=" + sex +
                ", specialtyType=" + specialtyType +
                ", joinTime='" + joinTime + '\'' +
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

    public ArtMemberDTO() {
    }
}
