package com.qin.service;

import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.query.AttendanceQuery;
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

    /**
     * 根据条件查询考勤记录
     * @param attendanceQuery
     * @return
     */
    public DataVO<Attendance> queryByParams(AttendanceQuery attendanceQuery);

    /**
     * 根据记录id删除考勤记录，并将member的考勤记录数-1
     * @param id
     * @return
     */
    public int deleteById(Long id);

    public int updateAttendance(Attendance attendance);
}
