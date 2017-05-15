package com.unico.soap.detail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * GCDnum creates model for GCD table
 * 
 * @author Shruti Mahapatra
 *
 */

@Entity
public class GCDnum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	private int num1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

}
