package com.qin.dal.mapper;

import com.qin.domain.Activity;
import com.qin.domain.ActivityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ActivityMapper {
    long countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}