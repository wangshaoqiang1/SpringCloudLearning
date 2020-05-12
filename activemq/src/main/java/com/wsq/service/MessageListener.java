package com.wsq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author wsq
 * @version 1.0
 * @date 2020/5/12 11:35
 */
@Component
public class MessageListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @JmsListener(destination = "${pos.mq}")
    public void receiveQueue(String text) {
        logger.info("收到消息:" + text);
    }
    }

