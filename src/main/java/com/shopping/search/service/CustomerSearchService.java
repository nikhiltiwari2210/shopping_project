package com.shopping.search.service;

import java.util.List;

import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;
import com.shopping.model.Product;

public interface CustomerSearchService {

	 public int createAccount(Customer customer) throws BusinessException;
	 public int checkLoginDetails(String customer_email, String customer_password) throws BusinessException;
	 public int employeeLoginDetails(String employee_username, String employee_password) throws BusinessException;
	 
	 public List<Product>getProductByName(String p_name) throws BusinessException;
	// public List<Product>getProductById(int p_id) throws BusinessException;
	 public List<Product>getProductByCountry(String p_manufacture) throws BusinessException;
	 public List<Product>getProductAllDetails(Product product) throws BusinessException;
	 
	 public int addproduct(Product product) throws BusinessException;
	 public int deleteproduct(Product product) throws BusinessException;
	 public List<Customer> getAllCustomerDetails(Customer customer) throws BusinessException;
}