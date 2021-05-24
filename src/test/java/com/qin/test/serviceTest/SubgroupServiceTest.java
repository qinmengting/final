package com.qin.test.serviceTest;

import com.qin.common.VO.BarVO;
import com.qin.common.VO.SectorVO;
import com.qin.service.SubgroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SubgroupServiceTest {
    @Autowired
    private SubgroupService subgroupService;

    @Test
    public void test01(){
        BarVO barVO = subgroupService.getBarVO();
        System.out.println(barVO);
    }

    @Test
    public void test02() {
        List<SectorVO> sectorVO = subgroupService.getSectorVO();
        System.out.println(sectorVO);
    }
}
