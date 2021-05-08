package com.qin.dal.mapper;

import com.qin.domain.ScoreProportion;
import com.qin.domain.ScoreProportionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreProportionMapper {
    long countByExample(ScoreProportionExample example);

    int deleteByExample(ScoreProportionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScoreProportion record);

    int insertSelective(ScoreProportion record);

    List<ScoreProportion> selectByExample(ScoreProportionExample example);

    ScoreProportion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScoreProportion record, @Param("example") ScoreProportionExample example);

    int updateByExample(@Param("record") ScoreProportion record, @Param("example") ScoreProportionExample example);

    int updateByPrimaryKeySelective(ScoreProportion record);

    int updateByPrimaryKey(ScoreProportion record);
}