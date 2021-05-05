package com.qin.test.serviceTest;

import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.domain.ArtMember;
import com.qin.service.ArtMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
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
//        DataVO<ArtMemberVO> all = artMemberService.findAll();
//        System.out.println(all);
    }

    @Test
    public void addTest() {

        ArtMemberDTO artMember = new ArtMemberDTO();
        artMember.setJoinTime("2020-9-10");
        artMember.setStudentId("1007171234");
        artMember.setAccountType((byte) 0);
        artMember.setMobile("18812341233");
        artMember.setSubgroup("舞蹈团");
        artMember.setSex((byte) 1);
        artMember.setPassword("123456789");
        artMember.setAccountName("小张");
        artMember.setSpecialtyType((byte) 0);
        artMember.setInGroupTime((byte) 2);
        artMemberService.addMember(artMember);
    }
}
