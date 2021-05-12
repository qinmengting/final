package com.qin.service.impl;

import com.github.pagehelper.PageInfo;
import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.common.convert.ArtMemberConvertMapper;
import com.qin.common.query.ArtMemberQuery;
import com.qin.dal.mapper.ArtMemberMapper;
import com.qin.dal.mapper.ScoreProportionMapper;
import com.qin.domain.ArtMember;
import com.qin.domain.ArtMemberExample;
import com.qin.domain.ScoreProportion;
import com.qin.domain.ScoreProportionExample;
import com.qin.service.ArtMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.github.pagehelper.PageHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArtMemberServiceImpl implements ArtMemberService {
    @Autowired
    private ArtMemberMapper artMemberMapper;

    @Autowired
    private ScoreProportionMapper scoreProportionMapper;

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
        ArtMember artMember = ArtMemberConvertMapper.INSTANCES.DTOtoMember(artMemberDTO);
        artMember.setId(id);
        artMember.setUsername(artMember.getStudentId());
        artMember.setAttendanceCount(member.getAttendanceCount());
        artMember.setAttendanceScore(member.getAttendanceScore());
        artMember.setWorkScore(member.getWorkScore());
        artMember.setUsuallyScore(member.getUsuallyScore());
        artMember.setTotalScore(member.getUsuallyScore());
        artMember.setPerformanceCount(member.getPerformanceCount());
        int i = artMemberMapper.updateByPrimaryKey(artMember);

//        if (artMember.getStudentId()!=null && artMember.getStudentId()!=""){
//            member.setStudentId(artMember.getStudentId());
//        }
//        if (artMember.getPassword()!=null && artMember.getPassword()!=""){
//            member.setPassword(artMember.getPassword());
//        }
//        if (artMember.getAccountType()!=null){
//            member.setAccountType(artMember.getAccountType());
//        }
//        if (artMember.getAccountName()!=null && artMember.getAccountName()!=""){
//            member.setAccountName(artMember.getAccountName());
//        }
//        if (artMember.getMobile()!=null && artMember.getMobile()!=""){
//            member.setMobile(artMember.getMobile());
//        }
//        if (artMember.getSchool()!=null && artMember.getSchool()!=""){
//            member.setSchool(artMember.getSchool());
//        }
//        if (artMember.getSubgroup()!=null && artMember.getSubgroup()!=""){
//            member.setSubgroup(artMember.getSubgroup());
//        }
//        if (artMember.getTeacher()!=null && artMember.getTeacher()!=""){
//            member.setTeacher(artMember.getTeacher());
//        }
//        if (artMember.getSex()!=null){
//            member.setSex(artMember.getSex());
//        }
//        if (artMember.getSpecialtyType()!=null){
//            member.setSpecialtyType(artMember.getSpecialtyType());
//        }
//        if (artMember.getJoinTime()!=null){
//            member.setJoinTime(artMember.getJoinTime());
//        }
//        if (artMember.getInGroupTime()!=null){
//            member.setInGroupTime(artMember.getInGroupTime());
//        }
//        if (artMember.getRemark()!=null && artMember.getRemark()!=""){
//            member.setRemark(artMember.getRemark());
//        }
//        ArtMemberExample ex = new ArtMemberExample();
//        ArtMemberExample.Criteria cr = ex.createCriteria();
//        cr.andIdEqualTo(id);
//
//        int i = artMemberMapper.updateByExample(member,ex);
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
        if (artMemberQuery.getMobile() != null && artMemberQuery.getMobile() != ""){
            cr.andMobileEqualTo(artMemberQuery.getMobile());
        }
        if (artMemberQuery.getStudentId() != null && artMemberQuery.getStudentId() != ""){
            cr.andStudentIdEqualTo(artMemberQuery.getStudentId());
        }
        if (artMemberQuery.getSubgroup() != null && artMemberQuery.getSubgroup() != ""){
            cr.andSubgroupEqualTo(artMemberQuery.getSubgroup());
        }
        if (artMemberQuery.getSchool() != null && artMemberQuery.getSchool() != ""){
            cr.andSchoolEqualTo(artMemberQuery.getSchool())
;        }
        if (artMemberQuery.getTeacher() != null && artMemberQuery.getTeacher() != ""){
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

    @Override
    public int countAttendanceScore(ScoreProportion scoreProportion) {
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andSubgroupEqualTo(scoreProportion.getSubgroup());
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        for (ArtMember member : members) {
            Double score = (member.getAttendanceCount()*1.00)/(scoreProportion.getTotalAttendance()*1.00)*100;
            member.setAttendanceScore(score);
            artMemberMapper.updateByPrimaryKey(member);
        }
        return 0;
    }

    @Override
    public int updateScore(Long id, ArtMember artMember) {
        ArtMember member = artMemberMapper.selectByPrimaryKey(id);
        if (artMember.getAttendanceScore()!=null){
            member.setAttendanceScore(artMember.getAttendanceScore());
        }
        if (artMember.getUsuallyScore()!=null){
            member.setUsuallyScore(artMember.getUsuallyScore());
        }
        if (artMember.getWorkScore()!=null){
            member.setWorkScore(artMember.getWorkScore());
        }
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andIdEqualTo(id);
        int i = artMemberMapper.updateByExample(member,ex);
        return i;
    }

    @Override
    public int countTotalScore(Long id, ArtMember artMember) {
        //找到对应的成员
        ArtMember member = artMemberMapper.selectByPrimaryKey(id);

        ScoreProportionExample ex = new ScoreProportionExample();
        ScoreProportionExample.Criteria cr = ex.createCriteria();
        cr.andSubgroupEqualTo(artMember.getSubgroup());
        List<ScoreProportion> scoreProportions = scoreProportionMapper.selectByExample(ex);

        ScoreProportion proportion = null;
        if (scoreProportions!=null){
            proportion = scoreProportions.get(0);
        }
        //获得比例
        Double attendanceProp = proportion.getAttendanceProp();
        Double usuallyProp = proportion.getUsuallyProp();
        Double workProp = proportion.getWorkProp();
        //总考勤次数
        Integer totalAttendance = proportion.getTotalAttendance();

        //获得成绩
        Double attendanceScore = member.getAttendanceScore();
        Double usuallyScore = member.getUsuallyScore();
        Double workScore = member.getWorkScore();
        Integer count = member.getAttendanceCount();
        double newAttendanceScore = (count * 1.00) / (totalAttendance * 1.00) * 100;
        if (newAttendanceScore!=attendanceScore){
            member.setAttendanceScore(newAttendanceScore);
        }



        //计算总成绩
        double totalScore = attendanceProp * newAttendanceScore * 0.01 + usuallyProp * usuallyScore * 0.01 + workProp * workScore *0.01;
        member.setTotalScore(totalScore);

        ArtMemberExample example = new ArtMemberExample();
        ArtMemberExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        //更新总成绩
        artMemberMapper.updateByExample(member,example);

        return 0;
    }

    @Override
    public int updateGeneral(Long id, ArtMember artMember) {
        ArtMember member = artMemberMapper.selectByPrimaryKey(id);
        if (artMember.getStudentId()!=null && artMember.getStudentId() != ""){
            member.setStudentId(artMember.getStudentId());
        }
        if (artMember.getAccountName()!=null && artMember.getAccountName() != ""){
            member.setAccountName(artMember.getAccountName());
        }
        if (artMember.getMobile()!=null && artMember.getMobile() != ""){
            member.setMobile(artMember.getMobile());
        }
        if (artMember.getSchool()!=null && artMember.getSchool() != ""){
            member.setSchool(artMember.getSchool());
        }
        if (artMember.getSubgroup()!=null && artMember.getSubgroup() != ""){
            member.setSubgroup(artMember.getSubgroup());
        }
        if (artMember.getTeacher()!=null && artMember.getTeacher() != ""){
            member.setTeacher(artMember.getTeacher());
        }
        if (artMember.getSex()!=null){
            member.setSex(artMember.getSex());
        }
        if (artMember.getRemark()!=null && artMember.getRemark() != ""){
            member.setRemark(artMember.getRemark());
        }
        int i = artMemberMapper.updateByPrimaryKey(member);
        return i;
    }

    @Override
    public DataVO<ArtMember> queryById(Long id) {
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andIdEqualTo(id);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(artMemberMapper.countByExample(ex));
        dataVO.setData(members);
        return dataVO;
    }

    @Override
    public int addGeneral(ArtMember artMember) {
        String s = artMember.getStudentId();
        artMember.setUsername(s);
        int i = artMemberMapper.insert(artMember);
        return i;
    }
}
