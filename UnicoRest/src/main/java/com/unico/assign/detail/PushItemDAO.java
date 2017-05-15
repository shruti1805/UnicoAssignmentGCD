package com.unico.assign.detail;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * PushItemDAO is an interface for generic CRUD operations  
 * like save, insert, update and delete
 * 
 * @author Shruti Mahapatra
 *
 */

public interface PushItemDAO extends CrudRepository <PushItem, String> {
}




