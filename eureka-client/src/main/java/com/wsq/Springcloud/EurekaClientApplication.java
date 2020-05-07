package com.wsq.Springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wsq
 * @version 1.0
 * @date 2020/5/6 15:25
 */
@SpringBootApplication
@EnableEurekaClient   //标记为eureka client
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
