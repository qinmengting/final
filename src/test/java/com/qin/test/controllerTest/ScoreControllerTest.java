package com.qin.test.controllerTest;

import com.alibaba.fastjson.JSON;
import com.qin.controller.ScoreController;
import com.qin.domain.ArtMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScoreControllerTest {
    @Autowired
    private ScoreController scoreController;

    @Test
    public void addTest() {
        ArtMember artMember = new ArtMember();
        Long id = 1L;
        artMember.setId(1L);
        artMember.setAttendanceScore(99.0);
        artMember.setUsuallyScore(80.0);
        artMember.setWorkScore(95.0);
        String s = JSON.toJSONString(artMember);
        scoreController.updateScore(id,artMember);
    }
}
