package com.qin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.common.query.AttendanceQuery;
import com.qin.dal.mapper.AttendanceMapper;
import com.qin.domain.Attendance;
import com.qin.domain.AttendanceExample;
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

    @Override
    public DataVO<Attendance> queryByParams(AttendanceQuery attendanceQuery) {
        PageHelper.startPage(attendanceQuery.getPage(),attendanceQuery.getLimit());
        AttendanceExample ex = new AttendanceExample();
        AttendanceExample.Criteria cr = ex.createCriteria();
        if (attendanceQuery.getAccountName() !=null && attendanceQuery.getAccountName() != ""){
            cr.andAccountNameEqualTo(attendanceQuery.getAccountName());
        }
        if (attendanceQuery.getStudentId() !=null && attendanceQuery.getStudentId() != ""){
            cr.andStudentIdEqualTo(attendanceQuery.getStudentId());
        }
        if (attendanceQuery.getSubgroup() !=null && attendanceQuery.getSubgroup() != ""){
            cr.andSubgroupEqualTo(attendanceQuery.getSubgroup());
        }
        List<Attendance> attendances = attendanceMapper.selectByExample(ex);
        PageInfo<Object> pageInfo = new PageInfo(attendances,attendanceQuery.getLimit());
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(attendanceMapper.countByExample(ex));
        dataVO.setData(pageInfo.getList());
        return dataVO;
    }

    @Override
    public int deleteById(Long id) {
        //删除考勤记录
        int i = attendanceMapper.deleteByPrimaryKey(id);
        //用户考勤记录-1
        Attendance attendance = attendanceMapper.selectByPrimaryKey(id);
        String studentId = attendance.getStudentId();
        artMemberService.deleteCountByStudentId(studentId);
        return i;
    }

    @Override
    public int updateAttendance(Attendance attendance) {
        AttendanceExample ex = new AttendanceExample();
        AttendanceExample.Criteria cr = ex.createCriteria();
        cr.andIdEqualTo(attendance.getId());
        int i = attendanceMapper.updateByExample(attendance, ex);
        return i;
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

    @Override
    public DataVO<Attendance> queryByStudentID(String studentId, BaseQuery baseQuery) {
        PageHelper.startPage(baseQuery.getPage(),baseQuery.getLimit());
        AttendanceExample ex = new AttendanceExample();
        AttendanceExample.Criteria cr = ex.createCriteria();
        cr.andStudentIdEqualTo(studentId);
        List<Attendance> attendances = attendanceMapper.selectByExample(ex);
        PageInfo<Object> pageInfo = new PageInfo(attendances,baseQuery.getLimit());
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(attendanceMapper.countByExample(ex));
        dataVO.setData(pageInfo.getList());
        return dataVO;
    }
}
