package com.wsq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

/**
 * https://blog.csdn.net/m0_37739193/article/details/83001176?utm_medium=distribute.pc_relevant_right.none-task-blog-BlogCommendFromMachineLearnPai2-5.nonecase&depth_1-utm_source=distribute.pc_relevant_right.none-task-blog-BlogCommendFromMachineLearnPai2-5.nonecase
 * @author wsq
 * @version 1.0
 * @date 2020/5/12 11:52
 */
@SpringBootApplication
@EnableJms
public class ActivemqApplicaiton {
   /* @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("test");
    }*/
    public static void main(String[] args) {
        SpringApplication.run(ActivemqApplicaiton.class,args);
    }
}
