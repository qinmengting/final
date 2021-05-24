package com.qin.service.impl;

import com.qin.common.VO.BarVO;
import com.qin.common.VO.SectorVO;
import com.qin.dal.mapper.ArtMemberMapper;
import com.qin.dal.mapper.SubgroupMapper;
import com.qin.domain.ArtMemberExample;
import com.qin.domain.Subgroup;
import com.qin.domain.SubgroupExample;
import com.qin.service.SubgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubgroupServiceImpl implements SubgroupService {
    @Autowired
    private SubgroupMapper subgroupMapper;

    @Autowired
    private ArtMemberMapper artMemberMapper;

    @Override
    public BarVO getBarVO() {
        BarVO barVO = new BarVO();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        SubgroupExample ex = new SubgroupExample();
        List<Subgroup> subgroups = subgroupMapper.selectByExample(ex);
        for (Subgroup subgroup : subgroups) {
            //查询分团的名字，并添加到names列表中
            String groupName = subgroup.getGroupName();
            names.add(groupName);
            //统计对应分团的人数
            ArtMemberExample example = new ArtMemberExample();
            ArtMemberExample.Criteria cr = example.createCriteria();
            cr.andSubgroupEqualTo(groupName);
            long count = artMemberMapper.countByExample(example);
            values.add((int) count);
        }
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }

    @Override
    public List<SectorVO> getSectorVO() {
        List<SectorVO> vos= new ArrayList<>();
        SubgroupExample ex = new SubgroupExample();
        List<Subgroup> subgroups = subgroupMapper.selectByExample(ex);
        for (Subgroup subgroup : subgroups) {
            SectorVO sectorVO = new SectorVO();
            //查询分团名字
            String groupName = subgroup.getGroupName();
            sectorVO.setName(groupName);
            //统计分团人数
            ArtMemberExample example = new ArtMemberExample();
            ArtMemberExample.Criteria cr = example.createCriteria();
            cr.andSubgroupEqualTo(groupName);
            long count = artMemberMapper.countByExample(example);
            sectorVO.setValue((int) count);
            vos.add(sectorVO);
        }
        return vos;
    }
}
