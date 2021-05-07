package com.qin.test.controllerTest;

import com.qin.common.VO.ArtMemberVO;
import com.qin.controller.AttendanceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AttendanceControllerTest {
    @Autowired
    private AttendanceController attendanceController;

    @Test
    public void test01() {
        List<ArtMemberVO> vos = new ArrayList<ArtMemberVO>();
        ArtMemberVO vo = new ArtMemberVO();
        ArtMemberVO vo1 = new ArtMemberVO();
        ArtMemberVO vo2 = new ArtMemberVO();
        vo.setAccountName("小秦");
        vo.setStudentId("1007171008");
        vo.setSubgroup("舞蹈团");
        vos.add(vo);
        vo1.setAccountName("成功");
        vo1.setSubgroup("打击乐团");
        vo1.setStudentId("1001171001");
        vos.add(vo1);
        vo2.setStudentId("1001171002");
        vo2.setAccountName("失败");
        vo2.setSubgroup("合唱团");
        vos.add(vo2);
        attendanceController.addAttendance(vos);
    }
}
