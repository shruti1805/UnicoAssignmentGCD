package com.unico.assign.jms;

import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
 
/**
 * 
 * MessagingConfiguration sets up configuration of JMS queue like URL, order-queue names
 * 
 * @author Shruti Mahapatra
 *
 */

@Configuration
public class MessagingConfiguration {
 
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
     
    private static final String ORDER_QUEUE = "unico-request";
 
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        return connectionFactory;
    }
     
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_QUEUE);
        return template;
    }
     
}
