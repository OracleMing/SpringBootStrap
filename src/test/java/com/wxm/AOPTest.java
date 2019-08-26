package com.wxm;

import com.wxm.service.MyTestService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AOPTest {
    @Autowired
    MyTestService2 myTestService2;

    @Test
    public void test() {
        myTestService2.sayHello();
        myTestService2.count();
    }

}
