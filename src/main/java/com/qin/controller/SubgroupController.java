package com.qin.controller;

import com.qin.common.VO.BarVO;
import com.qin.common.VO.SectorVO;
import com.qin.service.SubgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubgroupController {
    @Autowired
    private SubgroupService subgroupService;

    @RequestMapping("/barVO")
    public BarVO getBarVO(){
        BarVO barVO = subgroupService.getBarVO();
        return barVO;
    }

    @RequestMapping("/sectorVO")
    public List<SectorVO> getSectorVO() {
        List<SectorVO> sectorVO = subgroupService.getSectorVO();
        return sectorVO;
    }
}
