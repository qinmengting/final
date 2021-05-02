package com.qin.service.impl;

import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.convert.ArtMemberConvertMapper;
import com.qin.dal.mapper.ArtMemberMapper;
import com.qin.domain.ArtMember;
import com.qin.domain.ArtMemberExample;
import com.qin.service.ArtMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return artMembers;

    }

    @Override
    public DataVO<ArtMemberVO> findAll() {
        List<ArtMemberVO> memberVOS = queryAll();
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(countAllMembers());
        dataVO.setData(memberVOS);
        return dataVO;
    }

    @Override
    public int countAllMembers() {
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        int l = (int) artMemberMapper.countByExample(ex);
        return l;
    }

    @Override
    public Object queryMembers() {
        return null;
    }
}
