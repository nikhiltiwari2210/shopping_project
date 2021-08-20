package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.shopping.dao.CustomerSearchDAO;
import com.shopping.dao.dbutil.MySqlDbConnection;
import com.shopping.exeception.BusinessException;
import com.shopping.model.Customer;
import com.shopping.model.Product;

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
			throw new BusinessException("Internal error occured, please wait");
		}
     return c;
	}

	public int checkLoginDetails(String customer_email, String customer_password) throws BusinessException {
		int c=0;
		try(Connection connection = MySqlDbConnection.getConnection()){
			String sql = "Select customer_firstname,customer_lastname,customer_email,customer_password from customer_login where customer_email=? and customer_password=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,customer_email);
			preparedStatement.setString(2,customer_password);
			
			c = preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return 1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please wait");
		}
		return c;
	}

	public int employeeLoginDetails(String employee_username, String employee_password) throws BusinessException {
		int c=0;
		try(Connection connection = MySqlDbConnection.getConnection()){
			String sql = "Select employee_username,employee_password from employee_login where employee_username=? and employee_password=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,employee_username);
			preparedStatement.setString(2,employee_password);
			
			c = preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return 1;
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please wait");
		}
		return c;
	}

	@Override
	public List<Product> getProductByName(String p_name) throws BusinessException {
		List<Product> playerList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "SELECT p_id,p_name, p_price, p_manufacture FROM shopping_project.product where p_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,p_name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setP_id(resultSet.getInt("p_id"));
				product.setP_name(resultSet.getString("p_name"));
				product.setP_price(resultSet.getDouble("p_price"));
				product.setP_manufacture(resultSet.getString("p_manufacture"));
				
				playerList.add(product);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("No Customer is present by name " + p_name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please wait");
		}
		return playerList;
	}

	@Override
	public Product getProductById(int p_id) throws BusinessException {
		Product product = null;

		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "SELECT p_id,p_name, p_price, p_manufacture FROM shopping_project.product where p_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, p_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				product = new Product();
				product.setP_id(resultSet.getInt("p_id"));
				product.setP_name(resultSet.getString("p_name"));
				product.setP_price(resultSet.getDouble("p_price"));
				product.setP_manufacture(resultSet.getString("p_manufacture"));			
			} else {
				throw new BusinessException("Entered Product id " + p_id + " doesn't exits");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please wait");
		}
		return product;
	}

	@Override
	public List<Product> getProductByCountry(String p_manufacture) throws BusinessException {
		List<Product> playerList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "SELECT p_id,p_name, p_price, p_manufacture FROM shopping_project.product where p_manufacture=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,p_manufacture);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setP_id(resultSet.getInt("p_id"));
				product.setP_name(resultSet.getString("p_name"));
				product.setP_price(resultSet.getDouble("p_price"));
				product.setP_manufacture(resultSet.getString("p_manufacture"));
				
				playerList.add(product);
			}
			if (playerList.size() == 0) {
				throw new BusinessException("No Country is present by the name " + p_manufacture);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please contact admin");
		}
		return playerList;
	}

	@Override
	public List<Product> getProductAllDetails(Product product) throws BusinessException {
		List<Product> productDetails=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="SELECT p_id,p_name, p_price, p_manufacture FROM shopping_project.product";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				product=new Product();
				product.setP_id(resultSet.getInt("p_id"));
				product.setP_name(resultSet.getString("p_name"));
				product.setP_price(resultSet.getDouble("p_price"));
				product.setP_manufacture(resultSet.getString("p_manufacture"));
				
				productDetails.add(product);
				}
			}catch(ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, please wait");
		}
		return productDetails;
	}

	@Override
	public int addproduct(Product product) throws BusinessException {
		int n=0;
		try(Connection connection=MySqlDbConnection.getConnection()) {
			String sql="Insert into shopping_project.product(p_id,p_name,p_price,p_manufacture) values (?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,product.getP_id());
			preparedStatement.setString(2,product.getP_name());
			preparedStatement.setDouble(3,product.getP_price());
			preparedStatement.setString(4,product.getP_manufacture());
			
			n=preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured, please wait");
		}
		return n;
	}

	@Override
	public int deleteProductById(int p_id) throws BusinessException {
		int c=0;	
		try(Connection connection=MySqlDbConnection.getConnection()) {
			String sql="Delete from shopping_project.product where p_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,p_id);
			c=preparedStatement.executeUpdate();
		}catch(ClassNotFoundException | SQLException e) {
				log.warn(e);
				throw new BusinessException("Internal Errored Occured");
			}
			return c;
	}

	@Override
	public List<Customer> getAllCustomerDetails(Customer customer) throws BusinessException {
		List<Customer> customers=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
	    String sql="Select customer_firstname,customer_lastname,customer_email,customer_password from shopping_project.customer_login;";	
	    PreparedStatement preparedStatement=connection.prepareStatement(sql);
	    ResultSet resultSet=preparedStatement.executeQuery();
	    
	    while(resultSet.next()) {
	    	customer=new Customer();
	    	customer.setCustomer_firstname(resultSet.getString("customer_firstname"));
	    	customer.setCustomer_lastname(resultSet.getString("customer_lastname"));
	    	customer.setCustomer_email(resultSet.getString("customer_email"));
	    	customer.setCustomer_password(resultSet.getString("customer_password"));
	    	customers.add(customer);
	     }
		}catch(ClassNotFoundException | SQLException e) {
			log.warn(e);
			throw new BusinessException("Internal error occured, please wait");
		}
		return customers;
	}
	
}
	