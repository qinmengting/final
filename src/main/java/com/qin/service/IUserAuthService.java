package com.qin.service;

import com.qin.domain.UserAuth;

public interface IUserAuthService extends AbstractIService<UserAuth> {

    UserAuth login(String username, String password);
}
