package com.qin.controller;

import com.alibaba.fastjson.JSON;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.query.AttendanceQuery;
import com.qin.domain.Attendance;
import com.qin.domain.UserAuth;
import com.qin.service.AttendanceService;
import com.qin.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value = "/attendance/add",method = RequestMethod.POST)
    public Object addAttendance (@RequestBody List<ArtMemberVO> vos) {
        attendanceService.addAttendance(vos);
        return ResponseUtil.general_response("添加考勤成功");
    }

    @RequestMapping("/attendance/queryByParams")
    public Object queryByParams(AttendanceQuery attendanceQuery) {
        DataVO<Attendance> vo = attendanceService.queryByParams(attendanceQuery);
        return vo;
    }

    // 删除
    @DeleteMapping("/attendance/delete/{id}")
    public Object deleteAttendance(@PathVariable("id") Long id) {
        attendanceService.deleteById(id);
        return ResponseUtil.general_response("attendance delete success!");
    }

    // 编辑
    @PutMapping("/attendance/update/{id}")
    public Object updateAttendance(@PathVariable("id") Long id, @RequestBody Attendance attendance) {
        attendance.setId(id);
        int i = attendanceService.updateAttendance(attendance);
        if (i != 0) {
            return ResponseUtil.general_response("attendance update success!");
        }
        else
            return ResponseUtil.general_response("更新失败");
    }
}
