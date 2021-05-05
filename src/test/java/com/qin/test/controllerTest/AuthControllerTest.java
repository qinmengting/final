package com.qin.test.controllerTest;

import com.qin.controller.UserAuthController;
import com.qin.domain.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthControllerTest {
    @Autowired
    private UserAuthController controller;

    @Test
    public void test01(){
        PageHelper helper = new PageHelper();
        helper.setLimit(10);
        helper.setPage(1);
        Object auths = controller.getUserAuths(helper);
        System.out.println(auths);
    }
}
