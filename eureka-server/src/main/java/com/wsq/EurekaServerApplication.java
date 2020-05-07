package com.wsq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wsq
 * @version 1.0
 * @date 2020/5/6 11:08
 */
@SpringBootApplication
@EnableEurekaServer    //标记为eureka server    访问 http://localhost:8761
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
