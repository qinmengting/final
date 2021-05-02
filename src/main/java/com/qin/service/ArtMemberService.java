package com.qin.service;

import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.domain.ArtMember;

import java.util.List;

public interface ArtMemberService {
    /**
     * 查询所有成员
     * @return
     */
    public List<ArtMemberVO> queryAll();

    /**
     * 查询所有成员，返回dataVO格式
     * @return DataVO<ArtMemberVO>
     */
    public DataVO<ArtMemberVO> findAll(BaseQuery baseQuery);

    /**
     * 统计成员数
     * @return
     */

    public long countAllMembers();

    public Object queryMembers();

    public int addMember(ArtMemberDTO artMemberDTO);


}
