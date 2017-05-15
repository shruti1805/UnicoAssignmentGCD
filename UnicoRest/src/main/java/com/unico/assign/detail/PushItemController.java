package com.unico.assign.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import com.unico.assign.jms.MessageReceiver;
import com.unico.assign.jms.MessageSender;
import com.unico.security.UnicoSecurity;

/**
 * 
 * PushItemController creates @RestController which exposes the service metadata for 
 * access by REST-based clients
 * 
 * @author Shruti Mahapatra
 *
 */

@RestController
public class PushItemController  {
	
	@Autowired
	PushItemService pushItemService;
	@Autowired
	MessageSender messageSender;
	@Autowired
	MessageReceiver messageReceiver;

	@RequestMapping(method= RequestMethod.POST,value="/push/{num1}/{num2}")
	public String addItem(@RequestBody PushItem pushItem, @PathVariable int num1, @PathVariable int num2) {
		
		messageSender.sendMessage(num1 +", " +num2);
		
		pushItemService.addItem(pushItem, num1, num2);
		
		return (num1 +", " +num2 +" Successfully Added");
	}
	
	@RequestMapping("/getAllItems/list")
	public List<PushItem> getList(){
		
		return pushItemService.getList();
	}	
}
