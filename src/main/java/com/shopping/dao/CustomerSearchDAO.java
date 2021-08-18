package com.shopping.dao;

import java.util.List;

import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;


public interface CustomerSearchDAO {
	
	public int createAccount(Customer customer) throws BusinessException; 
}
