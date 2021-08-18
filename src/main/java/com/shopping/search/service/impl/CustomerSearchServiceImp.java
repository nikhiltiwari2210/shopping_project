package com.shopping.search.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.shopping.dao.CustomerSearchDAO;
import com.shopping.dao.dbutil.MySqlDbConnection;
import com.shopping.dao.impl.CustomerSearchDAOImpl;
import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;
import com.shopping.search.service.CustomerSearchService;

public class CustomerSearchServiceImp implements CustomerSearchService {

	private static Logger log = Logger.getLogger(CustomerSearchDAOImpl.class);
	private CustomerSearchDAO customerSearchDAO=new CustomerSearchDAOImpl();
	
	@Override
	public int createAccount(Customer customer) throws BusinessException {
		int a=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Insert into shopping_project.customer_login(customer_firstname,customer_lastname,customer_email,customer_password) values (?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,customer.getCustomer_firstname());
			preparedStatement.setString(2,customer.getCustomer_lastname());
			preparedStatement.setString(3,customer.getCustomer_email());
			preparedStatement.setString(4,customer.getCustomer_password());
		}catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact admin");
		}
		return a;
	}

}
