package com.qin.controller;

import com.alibaba.fastjson.JSON;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.domain.ArtMember;
import com.qin.service.ArtMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtMemberController {
    @Autowired
    private ArtMemberService artMemberService;

    @RequestMapping("/member/queryAll")
    public Object queryAll() {
        DataVO<ArtMemberVO> all = artMemberService.findAll();
        String s = JSON.toJSONString(all);
        return s;
    }
}
