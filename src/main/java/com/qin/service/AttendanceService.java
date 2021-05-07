package com.qin.service;

import com.qin.common.VO.ArtMemberVO;
import com.qin.domain.Attendance;

import java.util.List;

public interface AttendanceService {
    /**
     * 添加考勤记录
     * @param vos
     * @return
     */
    public int addAttendance (List<ArtMemberVO> vos);

    /**
     * 遍历attendance集合，逐条添加
     * @param list
     */
    public void addList(List<Attendance> list);
}
