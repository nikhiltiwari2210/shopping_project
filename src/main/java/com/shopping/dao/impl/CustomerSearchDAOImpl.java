package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.shopping.dao.CustomerSearchDAO;
import com.shopping.dao.dbutil.MySqlDbConnection;
import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;

public class CustomerSearchDAOImpl  implements CustomerSearchDAO{
	
	private static Logger log = Logger.getLogger(CustomerSearchDAOImpl.class);

	@Override
	public int createAccount(Customer customer) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="Insert into shopping_project.customer_login(customer_firstname,customer_lastname,customer_email,customer_password) values (?,?,?,?)";			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,customer.getCustomer_firstname());
			preparedStatement.setString(2,customer.getCustomer_lastname());
			preparedStatement.setString(3,customer.getCustomer_email());
			preparedStatement.setString(4,customer.getCustomer_password());
			
			c=preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact admin");
		}
     return c;
	}

}
	