package com.qin.service.impl;

import com.github.pagehelper.PageInfo;
import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.common.convert.ArtMemberConvertMapper;
import com.qin.common.query.ArtMemberQuery;
import com.qin.dal.mapper.ArtMemberMapper;
import com.qin.domain.ArtMember;
import com.qin.domain.ArtMemberExample;
import com.qin.service.ArtMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.github.pagehelper.PageHelper;

import java.util.List;

@Service
public class ArtMemberServiceImpl implements ArtMemberService {
    @Autowired
    private ArtMemberMapper artMemberMapper;

    @Override
    public List<ArtMemberVO> queryAll() {
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        List<ArtMemberVO> artMembers = ArtMemberConvertMapper.INSTANCES.membersToVOs(members);
        for (ArtMemberVO member : artMembers) {
            if (member.getSex().equals("0")){
                member.setSex("男");
            }else {
                member.setSex("女");
            }
            if (member.getSpecialtyType().equals("0")) {
                member.setSpecialtyType("否");
            }else {
                member.setSpecialtyType("是");
            }
            if (member.getAccountType().equals("0")) {
                member.setAccountType("团长");
            } else if (member.getAccountType().equals("1")) {
                member.setAccountType("副团长");
            } else {
                member.setAccountType("团员");
            }
        }
        return artMembers;

    }

    @Override
    public DataVO<ArtMemberVO> findAll(BaseQuery baseQuery) {
        PageHelper.startPage(baseQuery.getPage(),baseQuery.getLimit());
        List<ArtMemberVO> memberVOS = queryAll();
        PageInfo pageInfo = new PageInfo(memberVOS,baseQuery.getLimit());
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(countAllMembers());
        dataVO.setData(pageInfo.getList());
        return dataVO;
    }

    @Override
    public long countAllMembers() {
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        long l =  artMemberMapper.countByExample(ex);
        return l;
    }

    @Override
    public Object queryMembers() {
        return null;
    }

    @Override
    public int addMember(ArtMemberDTO artMemberDTO) {
        ArtMember artMember = ArtMemberConvertMapper.INSTANCES.DTOtoMember(artMemberDTO);
        artMember.setPerformanceCount(0);
        artMember.setTotalScore(0.0);
        artMember.setWorkScore(0.0);
        artMember.setUsuallyScore(0.0);
        artMember.setAttendanceScore(0.0);
        artMember.setAttendanceCount(0);
        int i = artMemberMapper.insert(artMember);
        return i;
    }

    @Override
    public int update(ArtMemberDTO artMemberDTO) {
        return 0;
    }

    @Override
    public int updateById(Long id, ArtMemberDTO artMemberDTO) {
        //找到需要更新的成员
        ArtMember member = artMemberMapper.selectByPrimaryKey(id);

        //讲dto转换为member
        artMemberDTO.setId(id);
        String studentId = artMemberDTO.getStudentId();
        ArtMember artMember = ArtMemberConvertMapper.INSTANCES.DTOtoMember(artMemberDTO);
        artMember.setUsername(studentId);

        if (artMember.getStudentId()!=null && artMember.getStudentId()!=""){
            member.setStudentId(artMember.getStudentId());
        }
        else if (artMember.getPassword()!=null && artMember.getPassword()!=""){
            member.setPassword(artMember.getPassword());
        }
        else if (artMember.getAccountType()!=null){
            member.setAccountType(artMember.getAccountType());
        }
        else if (artMember.getAccountName()!=null && artMember.getAccountName()!=""){
            member.setAccountName(artMember.getAccountName());
        }
        else if (artMember.getMobile()!=null && artMember.getMobile()!=""){
            member.setMobile(artMember.getMobile());
        }
        else if (artMember.getSchool()!=null && artMember.getSchool()!=""){
            member.setSchool(artMember.getSchool());
        }
        else if (artMember.getSubgroup()!=null && artMember.getSubgroup()!=""){
            member.setSubgroup(artMember.getSubgroup());
        }
        else if (artMember.getTeacher()!=null && artMember.getTeacher()!=""){
            member.setTeacher(artMember.getTeacher());
        }
        else if (artMember.getSex()!=null){
            member.setSex(artMember.getSex());
        }
        else if (artMember.getSpecialtyType()!=null){
            member.setSpecialtyType(artMember.getSpecialtyType());
        }
        else if (artMember.getJoinTime()!=null){
            member.setJoinTime(artMember.getJoinTime());
        }
        else if (artMember.getInGroupTime()!=null){
            member.setInGroupTime(artMember.getInGroupTime());
        }
        else if (artMember.getRemark()!=null && artMember.getRemark()!=""){
            member.setRemark(artMember.getRemark());
        }

        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andIdEqualTo(id);
        int i = artMemberMapper.updateByExample(member, ex);
        return i;
    }

    @Override
    public int deletedById(Long id) {
        int i = artMemberMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public ArtMemberDTO selectById(Long id) {
        ArtMember artMember = artMemberMapper.selectByPrimaryKey(id);
        ArtMemberDTO artMemberDTO= ArtMemberConvertMapper.INSTANCES.memberToDTO(artMember);
        return artMemberDTO;
    }

    @Override
    public DataVO<ArtMember> queryBySelect(ArtMemberQuery artMemberQuery) {
        PageHelper.startPage(artMemberQuery.getPage(),artMemberQuery.getLimit());

        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();

        if (artMemberQuery.getAccountName() != null && artMemberQuery.getAccountName() != ""){
            cr.andAccountNameEqualTo(artMemberQuery.getAccountName());
        }
        else if (artMemberQuery.getMobile() != null && artMemberQuery.getMobile() != ""){
            cr.andMobileEqualTo(artMemberQuery.getMobile());
        }
        else if (artMemberQuery.getStudentId() != null && artMemberQuery.getStudentId() != ""){
            cr.andStudentIdEqualTo(artMemberQuery.getStudentId());
        }
        else if (artMemberQuery.getSubgroup() != null && artMemberQuery.getSubgroup() != ""){
            cr.andSubgroupEqualTo(artMemberQuery.getSubgroup());
        }
        else if (artMemberQuery.getSchool() != null && artMemberQuery.getSchool() != ""){
            cr.andSchoolEqualTo(artMemberQuery.getSchool())
;        }
        else if (artMemberQuery.getTeacher() != null && artMemberQuery.getTeacher() != ""){
            cr.andTeacherEqualTo(artMemberQuery.getTeacher());
        }
//        long count = artMemberMapper.countByExample(ex);

        List<ArtMember> members = artMemberMapper.selectByExample(ex);

//        List<ArtMemberVO> vos = ArtMemberConvertMapper.INSTANCES.membersToVOs(members);

        PageInfo<Object> pageInfo = new PageInfo(members,artMemberQuery.getLimit());
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(artMemberMapper.countByExample(ex));
        dataVO.setData(pageInfo.getList());
        return dataVO;
    }

    @Override
    public int updateCount(List<ArtMemberVO> vos) {
        for (ArtMemberVO vo : vos) {
            ArtMemberExample ex = new ArtMemberExample();
            ArtMemberExample.Criteria cr = ex.createCriteria();
            cr.andStudentIdEqualTo(vo.getStudentId());

            List<ArtMember> members = artMemberMapper.selectByExample(ex);
            ArtMember member = members.get(0);
            Integer count = member.getAttendanceCount() + 1;
            member.setAttendanceCount(count);
            int i = artMemberMapper.updateByExample(member, ex);
        }
        return 0;
    }

    @Override
    public int deleteCount(List<ArtMemberVO> vos) {
        for (ArtMemberVO vo : vos) {
            ArtMemberExample ex = new ArtMemberExample();
            ArtMemberExample.Criteria cr = ex.createCriteria();
            cr.andStudentIdEqualTo(vo.getStudentId());

            List<ArtMember> members = artMemberMapper.selectByExample(ex);
            ArtMember member = members.get(0);
            Integer count = member.getAttendanceCount() - 1;
            member.setAttendanceCount(count);
            int i = artMemberMapper.updateByExample(member, ex);
        }
        return 0;
    }

    @Override
    public int deleteCountByStudentId(String studentID) {
        //找到对应的成员
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andStudentIdEqualTo(studentID);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        ArtMember member = members.get(0);
        //更新
        Integer count = member.getAttendanceCount() - 1;
        member.setAttendanceCount(count);
        System.out.println(member);
        int i = artMemberMapper.updateByExample(member,ex);
        return 0;
    }

    @Override
    public int updateAttendanceCount(Long id,ArtMember artMember) {
        ArtMember member = artMemberMapper.selectByPrimaryKey(id);
        member.setAttendanceCount(artMember.getAttendanceCount());
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andIdEqualTo(id);
        int i = artMemberMapper.updateByExample(member, ex);
        return i;
    }
}
