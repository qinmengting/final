package com.qin.test;

import com.qin.domain.Post;
import com.qin.service.IPostService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PostTest extends BaseApplicationTest {
    @Autowired
    IPostService service;
    @Test
    public void postDaoTest() {
       // List<Post> list = dao.selectAll();
        //System.out.println(list);
    }

    @Test
    public void postServiceTest() {
        Post post = service.listOneById(1);
        System.out.println(post);
    }
}
