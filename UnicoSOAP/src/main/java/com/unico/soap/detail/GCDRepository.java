package com.unico.soap.detail;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * /**
 * GCDRepository invokes the database CRUD operations
 * 
 * @author Shruti Mahapatra
 *
 */

@Component
public class GCDRepository {
	
	@Autowired
	GCDdao gCDdbConnectivity;
	static int id =1;

	public Logger logger =  LogManager.getLogger(GCDRepository.class); 
	GCDnum gcdnum = new GCDnum();

	@PostConstruct
	public void initData(){	}

	public int calculateGCD(int num1, int num2) {
		BigInteger b1 = BigInteger.valueOf(num1);
		BigInteger b2 = BigInteger.valueOf(num2);
		BigInteger  gcd = b1.gcd(b2);
		
		gcdnum.setId(id);	
		gcdnum.setNum1(gcd.intValue());	
		
		gCDdbConnectivity.save(gcdnum);	
		
		logger.debug("GCD Calculated - " + gcd.intValue());
		id=id+1;
		return gcd.intValue();
	}

	public int gcdSum(){
		int sumGcd =0;
		List<GCDnum> gCDAddList = new ArrayList<GCDnum> ();

		gCDdbConnectivity.findAll().forEach(gCDAddList :: add);

		for(int i=0; i< gCDAddList.size(); i++){
			sumGcd = sumGcd + gCDAddList.get(i).getNum1();
		}
		
		logger.debug("GCD Sum - " + sumGcd);
		return sumGcd;	
	}
	
	public String gcdReturnList(){
		List<GCDnum> gCDnumList = new ArrayList<> ();
		List<Integer> list1 = new ArrayList<Integer>(); 
		
		gCDdbConnectivity.findAll().forEach(gCDnumList :: add);
		
		for(int i=0; i< gCDnumList.size(); i++)
			list1.add(gCDnumList.get(i).getNum1());
		
		logger.debug("GCD List - " + list1.toString());
		
		return list1.toString();
	}
}
