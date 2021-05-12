package com.qin.controller;

import com.qin.common.VO.DataVO;
import com.qin.common.query.ArtMemberQuery;
import com.qin.common.query.AttendanceQuery;
import com.qin.domain.ArtMember;
import com.qin.domain.Attendance;
import com.qin.service.ArtMemberService;
import com.qin.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubAdminController {

    @Autowired
    private ArtMemberService artMemberService;

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/sub/queryByParams/{subgroup}")
    public Object queryByParams(@PathVariable("subgroup")String subgroup, ArtMemberQuery artMemberQuery){
        DataVO<ArtMember> vo = artMemberService.queryBySelect(artMemberQuery);
        return vo;
    }

    @GetMapping("/sub/queryAttendanceByParams/{subgroup}")
    public Object queryAttendanceByParams(@PathVariable("subgroup")String subgroup, AttendanceQuery artMemberQuery){
        DataVO<Attendance> vo = attendanceService.queryByParams(artMemberQuery);
        return vo;
    }


}
