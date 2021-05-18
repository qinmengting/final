package com.qin.service;

import com.qin.domain.ScoreProportion;

public interface ScoreService {
    /**
     * 设置分团的分数比例
     * @param scoreProportion
     * @return
     */
    public int addScoreBySubgroup(ScoreProportion scoreProportion);

//    public int addById(Long id, ScoreProportion scoreProportion);

}
