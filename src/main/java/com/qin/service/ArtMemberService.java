package com.qin.service;

import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.common.query.ArtMemberQuery;
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

    /**
     * 添加成员
     * @param artMemberDTO
     * @return
     */
    public int addMember(ArtMemberDTO artMemberDTO);

    /**
     * 修改成员信息
     * @param artMemberDTO
     * @return
     */
    public int update(ArtMemberDTO artMemberDTO);

    /**
     * 前端传参id，修改成员信息
     * @param id
     * @param artMemberDTO
     * @return
     */
    public int updateById(Long id, ArtMemberDTO artMemberDTO);

    /**
     * 删除成员信息
     * @param id
     * @return
     */
    public int deletedById(Long id);

    public ArtMemberDTO selectById(Long id);

    /**
     * 根据条件查询信息
     * @param artMemberQuery
     * @return
     */
    public DataVO<ArtMemberVO> queryBySelect(ArtMemberQuery artMemberQuery);

    /**
     * 考勤记录加1
     * @param vos
     * @return
     */
    public int updateCount(List<ArtMemberVO> vos);

    /**
     * 考勤记录减1
     * @param vos
     * @return
     */
    public int deleteCount(List<ArtMemberVO> vos);
}
