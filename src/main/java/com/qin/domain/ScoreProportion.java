package com.qin.domain;

import java.util.Date;

public class ScoreProportion {
    private Long id;

    private String subgroup;

    private Double attendanceProp;

    private Double usuallyProp;

    private Double workProp;

    private Integer totalAttendance;

    private String remark;

    private Date gmtCreate;

    private Date gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup == null ? null : subgroup.trim();
    }

    public Double getAttendanceProp() {
        return attendanceProp;
    }

    public void setAttendanceProp(Double attendanceProp) {
        this.attendanceProp = attendanceProp;
    }

    public Double getUsuallyProp() {
        return usuallyProp;
    }

    public void setUsuallyProp(Double usuallyProp) {
        this.usuallyProp = usuallyProp;
    }

    public Double getWorkProp() {
        return workProp;
    }

    public void setWorkProp(Double workProp) {
        this.workProp = workProp;
    }

    public Integer getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(Integer totalAttendance) {
        this.totalAttendance = totalAttendance;
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

    public ScoreProportion(Long id, String subgroup, Double attendanceProp, Double usuallyProp, Double workProp, Integer totalAttendance, String remark, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.subgroup = subgroup;
        this.attendanceProp = attendanceProp;
        this.usuallyProp = usuallyProp;
        this.workProp = workProp;
        this.totalAttendance = totalAttendance;
        this.remark = remark;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    public ScoreProportion() {
    }

    @Override
    public String toString() {
        return "ScoreProportion{" +
                "id=" + id +
                ", subgroup='" + subgroup + '\'' +
                ", attendanceProp=" + attendanceProp +
                ", usuallyProp=" + usuallyProp +
                ", workProp=" + workProp +
                ", totalAttendance=" + totalAttendance +
                ", remark='" + remark + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                '}';
    }
}