package com.qin.controller;

import com.alibaba.fastjson.JSON;
import com.qin.common.VO.ArtMemberVO;
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
}
