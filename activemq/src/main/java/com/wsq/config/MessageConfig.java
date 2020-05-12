package com.wsq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author wsq
 * @version 1.0
 * @date 2020/5/12 11:39
 */
@Configuration
public class MessageConfig {

    @Value("${activemq.broker-url}")
    private String mqurl;

    @Value("${activemq.user}")
    private String mqusernam;

    @Value("${activemq.password}")
    private String mqpassword;

    /**
     * 配置 队列
     *
     * @return
     */
    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("wsq");
    }

    /**
     * 配置失败队列
     *
     * @return
     */
    @Bean
    public ActiveMQQueue fileQueue() {

        return new ActiveMQQueue("fileQueueOne");
    }

    /**
     * 消息重试配置项
     *
     * @return
     */
    @Bean
    public RedeliveryPolicy redeliveryPolicy() {
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setUseExponentialBackOff(false);//是否在每次失败重发是，增长等待时间
        redeliveryPolicy.setMaximumRedeliveryDelay(-1);//设置重发最大拖延时间，-1 表示没有拖延，只有setUseExponentialBackOff(true)时生效
        redeliveryPolicy.setMaximumRedeliveries(0);//重发次数
        redeliveryPolicy.setInitialRedeliveryDelay(1);//重发时间间隔
        redeliveryPolicy.setBackOffMultiplier(2);//第一次失败后重发前等待500毫秒，第二次500*2，依次递增
        redeliveryPolicy.setUseCollisionAvoidance(false);//是否避免消息碰撞
        return redeliveryPolicy;
    }

    //@Value("${spring.activemq.broker-url}")

    /**
     * 初始化 建立连接 工厂
     *
     * @param redeliveryPolicy
     * @return
     */
    @Bean
    public ActiveMQConnectionFactory factory(RedeliveryPolicy redeliveryPolicy) {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(mqusernam, mqpassword, mqurl);
        factory.setRedeliveryPolicy(redeliveryPolicy);
        factory.setTrustAllPackages(true);
        return factory;
    }

    /**
     * 配置 spring 连接模板
     *
     * @param factory
     * @return
     */
    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory factory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDeliveryMode(1);//设置持久化，1 非持久， 2 持久化
        jmsTemplate.setConnectionFactory(factory);
        /**
         SESSION_TRANSACTED = 0  事物提交并确认
         AUTO_ACKNOWLEDGE = 1    自动确认
         CLIENT_ACKNOWLEDGE = 2    客户端手动确认
         DUPS_OK_ACKNOWLEDGE = 3    自动批量确认
         INDIVIDUAL_ACKNOWLEDGE = 4    单条消息确认 activemq 独有
         */
        jmsTemplate.setSessionAcknowledgeMode(1);//消息确认模式
        return jmsTemplate;
    }

    /**
     * 配置监听 工厂
     *
     * @param factory
     * @return
     */
    @Bean("jmsListener")
    public DefaultJmsListenerContainerFactory listener(ActiveMQConnectionFactory factory) {
        DefaultJmsListenerContainerFactory listener = new DefaultJmsListenerContainerFactory();
        listener.setConnectionFactory(factory);
        listener.setConcurrency("1-10");//设置连接数
        listener.setRecoveryInterval(1000L);//重连间隔时间
        listener.setSessionAcknowledgeMode(1);
        return listener;
    }
}
