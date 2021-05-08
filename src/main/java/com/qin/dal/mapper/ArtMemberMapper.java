package com.qin.dal.mapper;

import com.qin.domain.ArtMember;
import com.qin.domain.ArtMemberExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArtMemberMapper {
    long countByExample(ArtMemberExample example);

    int deleteByExample(ArtMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArtMember record);

    int insertSelective(ArtMember record);

    List<ArtMember> selectByExample(ArtMemberExample example);

    ArtMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArtMember record, @Param("example") ArtMemberExample example);

    int updateByExample(@Param("record") ArtMember record, @Param("example") ArtMemberExample example);

    int updateByPrimaryKeySelective(ArtMember record);

    int updateByPrimaryKey(ArtMember record);
}