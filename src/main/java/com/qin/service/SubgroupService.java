package com.qin.service;

import com.qin.common.VO.BarVO;
import com.qin.common.VO.SectorVO;

import java.util.List;

public interface SubgroupService {
    /**
     * 柱状图数据
     * @return
     */
    public BarVO getBarVO();

    /**
     * 饼图数据
     * @return
     */
    public List<SectorVO> getSectorVO();
}
