package com.unico.soap.detail; 

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import unico.assignment.soap.webservice.*;

/**
 * 
 * GCDEndPoint creates an endpoint which exposes the service metadata for 
 * access by SOAP-based clients
 * 
 * @author Shruti Mahapatra
 *
 */

@Endpoint
public class GCDEndPoint {
	private static final String NAMESPACE_URI = "http://unico/assignment/soap/webservice";
	
	private GCDRepository gcdRepository;
	
	public Logger logger =  LogManager.getLogger(GCDEndPoint.class); 
	
	@Autowired
	public GCDEndPoint(GCDRepository gcdRepository) {
		this.gcdRepository = gcdRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGCDRequest")
	@ResponsePayload
	public GetGCDResponse getGCD(@RequestPayload GetGCDRequest request) {
		GetGCDResponse response = new GetGCDResponse();
		int num1= request.getNum1();
		int num2 = request.getNum2();
		logger.debug(num1 + " " +num2);
		response.setNum2(gcdRepository.calculateGCD(num1, num2));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGCDSumRequest")
	@ResponsePayload
	public GetGCDSumResponse getGCDSum(@RequestPayload GetGCDSumRequest request) {
		GetGCDSumResponse response = new GetGCDSumResponse();
		response.setSum(gcdRepository.gcdSum());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGCDListRequest")
	@ResponsePayload
	public GetGCDListResponse getGCDList(@RequestPayload GetGCDListRequest request) {
		GetGCDListResponse response = new GetGCDListResponse();
		response.setGcdList(gcdRepository.gcdReturnList());
		return response;
	}
}