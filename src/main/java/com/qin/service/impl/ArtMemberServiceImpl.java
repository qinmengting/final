package com.qin.service.impl;

import com.github.pagehelper.PageInfo;
import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.common.VO.DataVO;
import com.qin.common.base.BaseQuery;
import com.qin.common.convert.ArtMemberConvertMapper;
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
        artMemberMapper.insert(artMember);
        return 0;
    }
}
