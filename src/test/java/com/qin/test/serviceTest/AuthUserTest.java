package com.qin.test.serviceTest;

import com.qin.domain.UserAuth;
import com.qin.service.IUserAuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthUserTest {

    @Autowired
    private IUserAuthService iUserAuthService;

    @Test
    public void testQuery() {
        UserAuth auth = iUserAuthService.listOneById(16);
        System.out.println(auth);
    }
}
