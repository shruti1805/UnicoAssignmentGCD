package com.unico.assign.detail;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * PushItemService invokes the database CRUD operations
 * 
 * @author Shruti Mahapatra
 *
 */

@Service
public class PushItemService {

	@Autowired
	PushItemDAO pushItemDBConnectivity;

	public Logger logger =  LogManager.getLogger(PushItemService.class); 
	
	public List<PushItem> getList(){
		
		List<PushItem> pushItem = new ArrayList<> ();
		pushItemDBConnectivity.findAll().forEach(pushItem :: add);
		
		return pushItem;	
	}

	public void addItem(PushItem pushItem, Integer number1, Integer number2) {
		pushItem.setNum1(number1);
		pushItem.setNum2(number2);
		logger.debug("Adding numbers in database :" +number1 +" " + number2);
		pushItemDBConnectivity.save(pushItem);		
	}
}
