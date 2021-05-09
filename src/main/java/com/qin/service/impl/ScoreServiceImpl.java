package com.qin.service.impl;

import com.qin.dal.mapper.ScoreProportionMapper;
import com.qin.domain.ScoreProportion;
import com.qin.domain.ScoreProportionExample;
import com.qin.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreProportionMapper scoreProportionMapper;

    @Override
    public int addScoreBySubgroup(ScoreProportion scoreProportion) {
        ScoreProportionExample ex = new ScoreProportionExample();
        ScoreProportionExample.Criteria cr = ex.createCriteria();
        cr.andSubgroupEqualTo(scoreProportion.getSubgroup());
        //找到对应分团进行更新
        List<ScoreProportion> list = scoreProportionMapper.selectByExample(ex);
        ScoreProportion proportion = list.get(0);
        if (scoreProportion.getAttendanceProp()!=null){
            proportion.setAttendanceProp(scoreProportion.getAttendanceProp());
        }
        if (scoreProportion.getTotalAttendance()!=null){
            proportion.setTotalAttendance(scoreProportion.getTotalAttendance());
        }
        if (scoreProportion.getUsuallyProp()!=null){
            proportion.setUsuallyProp(scoreProportion.getUsuallyProp());
        }
        if (scoreProportion.getWorkProp()!=null){
            proportion.setWorkProp(scoreProportion.getWorkProp());
        }
        if (scoreProportion.getRemark()!=null){
            proportion.setSubgroup(scoreProportion.getRemark());
        }
        int i = scoreProportionMapper.updateByExample(proportion, ex);
        return i;
    }
}
