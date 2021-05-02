package com.qin.test;

import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.domain.ArtMember;
import com.qin.service.ArtMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class memberTest {
    @Autowired
    private ArtMemberService artMemberService;

    @Test
    public void queryAllTest(){
        List<ArtMemberVO> artMembers = artMemberService.queryAll();
        for (ArtMemberVO member : artMembers) {
            System.out.println(member);
        }
    }

    @Test
    public void findAllTest() {
        DataVO<ArtMemberVO> all = artMemberService.findAll();
        System.out.println(all);
    }
}
