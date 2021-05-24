package com.qin.dal.mapper;

import com.qin.domain.Subgroup;
import com.qin.domain.SubgroupExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubgroupMapper {
    long countByExample(SubgroupExample example);

    int deleteByExample(SubgroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Subgroup record);

    int insertSelective(Subgroup record);

    List<Subgroup> selectByExample(SubgroupExample example);

    Subgroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Subgroup record, @Param("example") SubgroupExample example);

    int updateByExample(@Param("record") Subgroup record, @Param("example") SubgroupExample example);

    int updateByPrimaryKeySelective(Subgroup record);

    int updateByPrimaryKey(Subgroup record);
}