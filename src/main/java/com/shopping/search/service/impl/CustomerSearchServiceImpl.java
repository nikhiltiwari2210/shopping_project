package com.shopping.search.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.shopping.dao.CustomerSearchDAO;
import com.shopping.dao.impl.CustomerSearchDAOImpl;
import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;
import com.shopping.model.Product;
import com.shopping.search.service.CustomerSearchService;

public class CustomerSearchServiceImpl implements CustomerSearchService {

	private static Logger log = Logger.getLogger(CustomerSearchService.class);
	private CustomerSearchDAO customerSearchDAO=new CustomerSearchDAOImpl();
	
	@Override
	public int createAccount(Customer customer) throws BusinessException {
		try {
			if(customerSearchDAO.createAccount(customer)==1) {
				log.info(customer);
			}
			}catch(BusinessException e) {
				log.error(e);
				throw new BusinessException("Internal error occured, please contact admin");
			}
			return 0;
	}

	@Override
	public int checkLoginDetails(String customer_email, String customer_password) throws BusinessException {
		int c=0;
		if(customer_password.matches(".*[0-9]{1,}.*") && customer_password.matches(".*[@!$#]{1,}.*") && customer_password.matches(".*[a-zA-Z]{1,}.*") && customer_email.endsWith("@gmail.com")) {
			c = CustomerSearchDAO.checkLoginDetails(customer_email,customer_password);
		}else {
			throw new BusinessException("Invalid Email or password");
		}
		return c;
	}

	@Override
	public int employeeLoginDetails(String employee_username, String employee_password) throws BusinessException {
		int c=0;
		if(employee_password.matches(".*[0-9]{1,}.*") && employee_password.matches(".*[@!$#]{1,}.*") && employee_password.matches(".*[a-zA-Z]{1,}.*") && employee_username.endsWith("@gmail.com")) {
			c=CustomerSearchDAO.employeeLoginDetails(employee_username,employee_password);
		}else {
			throw new BusinessException("Invalid Email or password");
		}
		return c;
	}

	@Override
	public List<Product> getProductByName(String p_name) throws BusinessException {
		List<Product> playerList=null;
		playerList=customerSearchDAO.getProductByName(p_name);
		return playerList;
	}

	@Override
	public List<Product> getProductByCountry(String p_manufacture) throws BusinessException {
		List<Product> playerList=null;		
		playerList=customerSearchDAO.getProductByCountry(p_manufacture);
		return playerList;
	}

	@Override
	public List<Product> getProductAllDetails(Product product) throws BusinessException {
			List<Product> productDetails = null;
			try {
				productDetails= customerSearchDAO.getProductAllDetails(product);
			//	log.info("Details of Available Products");
			}catch(BusinessException e) {
				log.info(e.getMessage());
			}
			return productDetails;
	}

	@Override
	public int addproduct(Product product) throws BusinessException {
		//int p=0;
		try {
			if(customerSearchDAO.addproduct(product)==1) {
				log.info(product);
			}
		}catch(BusinessException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact admin");
		}
		return 0;
	}

	@Override
	public int deleteProductById(int p_id) throws BusinessException {
		try {
			if(customerSearchDAO.deleteProductById(p_id)==1) {
				log.info(p_id);
			}
		}catch(BusinessException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact admin");
		}
		return 0;
	}

	@Override
	public List<Customer> getAllCustomerDetails(Customer customer) throws BusinessException {
		List<Customer> customers = null;
		try {
		customers= customerSearchDAO.getAllCustomerDetails(customer);
		System.out.println("Below are the available products");
		}catch(BusinessException e) {
			log.error(e.getMessage());
		}
		return customers;
	}

}
	