package com.qin.dal;

import com.qin.domain.Post;
import org.springframework.stereotype.Repository;

/**
 * 公告Post持久层
 * 继承AbstractBaseDao, 使用抽象模版设计模式
 */
@Repository
public class PostDao extends BaseRepository<Post> {
}
