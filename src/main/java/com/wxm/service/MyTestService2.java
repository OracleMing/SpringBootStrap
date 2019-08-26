package com.wxm.service;

import com.wxm.annotation.TestLogger;
import com.wxm.annotation.TestTimer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@TestLogger
public class MyTestService2 {
    private Logger logger = LoggerFactory.getLogger(MyTestService2.class);

    public String sayHello() {
        logger.info("invoking method sayHello......");
        return "Hello world!";
    }

    @TestTimer
    public int count() {
        logger.info("invoking method count......");
        return 10;
    }

}
