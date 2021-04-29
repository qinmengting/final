package com.qin.service;

import com.qin.domain.ArtUser;

public interface ArtUserService {
    /**
     * 登陆
     * @return
     */
    ArtUser userLogin(ArtUser artUser);

    /**
     * 检查是否存在该用户
     */
    ArtUser checkUser(ArtUser artUser);
}
