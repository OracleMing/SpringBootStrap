package com.wxm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 60)
public class JavaWeb {

	public static void main(String[] args) {
		SpringApplication.run(JavaWeb.class, args);
	}
}
