package com.shopping.model;

public class Customer {
	private int customer_id;
	private String customer_email;
	private String customer_firstname;
	private String customer_lastname;
	private String customer_password;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_firstname() {
		return customer_firstname;
	}

	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}

	public String getCustomer_lastname() {
		return customer_lastname;
	}

	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_email=" + customer_email + ", customer_firstname="
				+ customer_firstname + ", customer_lastname=" + customer_lastname + ", customer_password="
				+ customer_password + "]";
	}

	public Customer(int customer_id, String customer_email, String customer_firstname, String customer_lastname,
			String customer_password) {
		super();
		this.customer_id = customer_id;
		this.customer_email = customer_email;
		this.customer_firstname = customer_firstname;
		this.customer_lastname = customer_lastname;
		this.customer_password = customer_password;
	}
	
	
}
