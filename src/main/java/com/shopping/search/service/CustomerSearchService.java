package com.shopping.search.service;

import java.util.List;

import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;

public interface CustomerSearchService {

	 public int createAccount(Customer customer) throws BusinessException;
}