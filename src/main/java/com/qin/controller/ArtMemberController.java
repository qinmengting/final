package com.qin.controller;

import com.alibaba.fastjson.JSON;
import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.common.convert.ArtMemberConvertMapper;
import com.qin.domain.ArtMember;
import com.qin.domain.UserAuth;
import com.qin.service.ArtMemberService;
import com.qin.service.IUserAuthService;
import com.qin.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ArtMemberController {
    @Autowired
    private ArtMemberService artMemberService;

    @Autowired
    private IUserAuthService userAuthService;

    @RequestMapping("/member/queryAll")
    public Object queryAll(BaseQuery baseQuery) {
        DataVO<ArtMemberVO> all = artMemberService.findAll(baseQuery);
        return all;
    }

    @RequestMapping("/member/add")
    public Object addMember(HttpServletResponse response, HttpServletRequest request, ArtMemberDTO artMemberDTO) throws IOException {

        /**
         * 添加到用户表中，只保留账号密码，默认非管理员
         */
        UserAuth auth = new UserAuth();
        boolean isAdmin = false;
        auth.setAdmin(isAdmin);
        auth.setUsername(artMemberDTO.getUsername());
        auth.setPassword(artMemberDTO.getPassword());
        int i1 = userAuthService.insertUser(auth);

        /**
         * 把用户名和学号一样
         */
        String username = artMemberDTO.getStudentId();
        artMemberDTO.setUsername(username);
        int i = artMemberService.addMember(artMemberDTO);
        /**
         * 返回状态消息
         */
        if (i != 0) {
            return ResponseUtil.general_response("添加成功!");
        }
        else {
            return ResponseUtil.general_response("添加失败！");
        }
    }

    // 更新
    @GetMapping("/member/update")
    public Object updateMember( @RequestBody ArtMemberDTO artMemberDTO) {
        Long id = artMemberDTO.getId();
        artMemberDTO.setId(id);
        int i = artMemberService.updateById(id, artMemberDTO);
        if (i != 0 ) {
            return ResponseUtil.general_response("更新成功!");
        }
        else
            return  ResponseUtil.general_response("更新失败！");
    }

    // 删除
    @DeleteMapping("/member/{id}")
    public Object deleteMember(@PathVariable("id") Long id) {
        artMemberService.deletedById(id);
        return ResponseUtil.general_response("member delete success!");
    }
}
