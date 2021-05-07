package com.qin.service.impl;

import com.qin.common.VO.ArtMemberVO;
import com.qin.common.convert.ArtMemberConvertMapper;
import com.qin.dal.mapper.ArtMemberMapper;
import com.qin.dal.mapper.AttendanceMapper;
import com.qin.domain.ArtMember;
import com.qin.domain.ArtMemberExample;
import com.qin.domain.Attendance;
import com.qin.service.ArtMemberService;
import com.qin.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private ArtMemberService artMemberService;

    @Override
    public int addAttendance(List<ArtMemberVO> vos) {
        List<Attendance> attendances = new ArrayList<Attendance>();
        for (ArtMemberVO vo : vos) {
            //在attendances集合中添加一条attendance；
            Attendance attendance = new Attendance();
            attendance.setAccountName(vo.getAccountName());
            attendance.setStudentId(vo.getStudentId());
            attendance.setSubgroup(vo.getSubgroup());
            attendances.add(attendance);
        }
        artMemberService.updateCount(vos);
        addList(attendances);
        return 0;
    }

    @Override
    public void addList(List<Attendance> list) {
        for (Attendance attendance : list) {
            attendanceMapper.insert(attendance);
        }
    }

    public AttendanceMapper getAttendanceMapper() {
        return attendanceMapper;
    }

    public void setAttendanceMapper(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    public AttendanceServiceImpl(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    public AttendanceServiceImpl() {
    }
}
