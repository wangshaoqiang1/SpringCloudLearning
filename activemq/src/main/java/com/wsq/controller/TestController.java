package com.wsq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author wsq
 * @version 1.0
 * @date 2020/5/12 11:47
 */
@RestController
public class TestController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/sendMsg")
    public void sendMsg(String msg) {
        jmsTemplate.send("wsq", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(msg);
                return textMessage;
            }
        });
    }
}
