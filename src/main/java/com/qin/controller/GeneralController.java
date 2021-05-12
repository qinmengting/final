package com.qin.controller;

import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.domain.ArtMember;
import com.qin.domain.Attendance;
import com.qin.domain.UserAuth;
import com.qin.service.ArtMemberService;
import com.qin.service.AttendanceService;
import com.qin.service.IUserAuthService;
import com.qin.util.ResponseUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GeneralController {
    @Autowired
    private ArtMemberService artMemberService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private IUserAuthService userAuthService;

    // 更新
    @GetMapping("/general/update/{id}")
    public Object updateMember(@PathVariable("id") Long id, ArtMember artMember) {
        int i = artMemberService.updateGeneral(id, artMember);
        if (i != 0 ) {
            return ResponseUtil.general_response("更新成功!");
        }
        else
            return  ResponseUtil.general_response("更新失败！");
    }

    @GetMapping("/general/queryAttendance/{studentId}")
    public Object queryAttendance(@PathVariable("studentId")String studentId, BaseQuery baseQuery) {
        DataVO<Attendance> vo = attendanceService.queryByStudentID(studentId, baseQuery);
        return vo;
    }

    @GetMapping("/general/queryAttendanceCount/{id}")
    public Object queryAttendanceCount(@PathVariable("id")Long id) {
        DataVO<ArtMember> vo = artMemberService.queryById(id);
        return vo;
    }

    @PostMapping("/general/add/{id}")
    public Object add(@PathVariable("id")Integer id,ArtMember artMember) {

        UserAuth userAuth = new UserAuth();
        userAuth.setId(id);
        userAuth.setUsername(artMember.getStudentId());
        userAuth.setPassword(artMember.getPassword());
        userAuth.setAdmin(false);
        int update = userAuthService.update(userAuth);
//        int i1 = userAuthService.updateById(id, artMember);
        int i = artMemberService.addGeneral(artMember);
        if (i != 0 ){
            return ResponseUtil.general_response("编辑信息成功！");
        }
        else
        return ResponseUtil.general_response("编辑信息失败！");
    }

}
