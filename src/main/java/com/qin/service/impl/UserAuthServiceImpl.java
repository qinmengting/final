package com.qin.service.impl;

import com.qin.dal.UserAuthDao;
import com.qin.domain.ArtMember;
import com.qin.domain.UserAuth;
import com.qin.service.IUserAuthService;
import com.qin.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl extends BaseServiceImpl<UserAuth> implements IUserAuthService {
    @Autowired
    private UserAuthDao dao;

    private final String namespace = "com.qin.domain.UserAuth.";

    @Override
    public UserAuth login(String username, String password) {
        UserAuth currentUser = dao.checkLogin(username, password);
        if (currentUser == null) {
            throw new RuntimeException("帐号或密码错误!");
        }
        UserContext.setCurrentUser(currentUser);
        return currentUser;
    }

    @Override
    public int insertUser(UserAuth userAuth) {
        int i = dao.insertUser(userAuth);
        return i;
    }

    @Override
    public int updateUser(UserAuth userAuth) {
        int i = dao.updateUser(userAuth);
        return i;
    }

    @Override
    public int updateById(Integer id, ArtMember artMember) {
        UserAuth auth = dao.selectById(id);
        auth.setUsername(artMember.getStudentId());
        auth.setPassword(auth.getPassword());
        auth.setAdmin(false);
        int i = dao.updateUser(auth);
        return i;
    }
}
