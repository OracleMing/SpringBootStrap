package com.wxm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10 * 60)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JavaWeb {

    public static void main(String[] args) {
        SpringApplication.run(JavaWeb.class, args);
    }
}
