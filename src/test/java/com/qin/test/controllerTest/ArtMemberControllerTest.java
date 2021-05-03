package com.qin.test.controllerTest;

import com.alibaba.fastjson.JSON;
import com.qin.common.DTO.ArtMemberDTO;
import com.qin.controller.ArtMemberController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static java.nio.file.Paths.get;

@SpringBootTest
public class ArtMemberControllerTest {
    @Autowired
    private ArtMemberController artMemberController;

    private MockMvc mockMvc;

    @Before
    public void before() {
        //可以对所有的controller来进行测试
        WebApplicationContext context = null;
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test01() throws Exception {
        ArtMemberDTO artMember = new ArtMemberDTO();
        artMember.setJoinTime("2020-9-10");
        artMember.setStudentId("1007170000");
        artMember.setAccountType((byte) 0);
        artMember.setMobile("18812340000");
        artMember.setSubgroup("舞蹈团");
        artMember.setSex((byte) 1);
        artMember.setPassword("0000000");
        artMember.setAccountName("张三");
        artMember.setSpecialtyType((byte) 0);
        artMember.setInGroupTime((byte) 2);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/member/add")
                        .content(JSON.toJSONString(artMember)))
               .andReturn();
    }
}
