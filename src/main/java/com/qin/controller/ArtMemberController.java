package com.qin.controller;

import com.alibaba.fastjson.JSON;
import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.domain.ArtMember;
import com.qin.service.ArtMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ArtMemberController {
    @Autowired
    private ArtMemberService artMemberService;

    @RequestMapping("/member/queryAll")
    public Object queryAll(BaseQuery baseQuery) {
        DataVO<ArtMemberVO> all = artMemberService.findAll(baseQuery);
        return all;
    }

    @RequestMapping("/member/add")
    public void addMember(HttpServletResponse response, HttpServletRequest request, @RequestBody ArtMemberDTO artMemberDTO) throws IOException {

        artMemberService.addMember(artMemberDTO);
        request.getRequestDispatcher("/allmembers");
    }
}
