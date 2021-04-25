package com.qin.test;

import com.qin.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
class BaseApplicationTest {

    @Before
    public void init() {
        System.out.println("-------测试开始-------");
    }

    @After
    public void after() {
        System.out.println("-------测试结束-------");
    }

}
