package com.wsq.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author wsq
 * @version 1.0
 * @date 2020/5/12 12:27
 */
@Component
@EnableScheduling
public class MqProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 2000)    // 每2s执行1次
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hello,activeMQ");
    }

}
