package com.qin.service;

import com.qin.domain.ArtMember;
import com.qin.domain.UserAuth;

public interface IUserAuthService extends AbstractIService<UserAuth> {

    UserAuth login(String username, String password);

    int insertUser(UserAuth userAuth);

    int updateUser(UserAuth userAuth);

    int updateById(Integer id, ArtMember artMember);
}
