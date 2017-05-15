package com.unico.assign.jms;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.unico.assign.detail.PushItem;
import com.unico.assign.detail.PushItemService;

/**
 * 
 * MessageReceiver recieves message from JMS queue
 * 
 * @author Shruti Mahapatra
 *
 */
 
@Component
public class MessageReceiver {
    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
 
    private static final String ORDER_RESPONSE_QUEUE = "unico-response";
     
    @Autowired
    PushItemService pushItemService;
     
     
    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<PushItem> message) throws JMSException {
    	System.out.println("Messagereceiver---------------------------r");
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        LOG.info("Application : headers received : {}", headers);
         
//        InventoryResponse response = message.getPayload();
//        LOG.info("Application : response received : {}",response);
        
        LOG.info("Application : response received : {}",message.getPayload());
        
        pushItemService.getList(); 
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
