package com.qin.service.impl;

import com.qin.dal.mapper.ArtUserMapper;
import com.qin.domain.ArtUser;
import com.qin.domain.ArtUserExample;
import com.qin.service.ArtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtUserServiceImpl implements ArtUserService {
    @Autowired
    private ArtUserMapper artUserMapper;

    @Override
    public ArtUser userLogin(ArtUser artUser) {
        if (checkUser(artUser)==null){
            return null;
        }
        else {
            return checkUser(artUser);
        }
    }

    @Override
    public ArtUser checkUser(ArtUser artUser) {
        ArtUserExample ex = new ArtUserExample();
        ArtUserExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(artUser.getUsername());
        cr.andPasswordEqualTo(artUser.getPassword());
        List<ArtUser> users = artUserMapper.selectByExample(ex);
        if (users.get(0)==null) {
            return null;
        }
        else {
            return artUser;
        }
    }

}
