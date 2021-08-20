package com.shopping.model;

public class Product {

	private int p_id;
	private String p_name;
	private double p_price;
	private String p_manufacture;
	
	public Product(){
		//constructor
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public double getP_price() {
		return p_price;
	}

	public void setP_price(double p_price) {
		this.p_price = p_price;
	}

	public String getP_manufacture() {
		return p_manufacture;
	}

	public void setP_manufacture(String p_manufacture) {
		this.p_manufacture = p_manufacture;
	}

	@Override
	public String toString() {
		return "\n[p_id=" + p_id + ", p_name=" + p_name + ", p_price=" + p_price + ", p_manufacture="
				+ p_manufacture + "]";
	}

	public Product(int p_id, String p_name, double p_price, String p_manufacture) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_manufacture = p_manufacture;
	}

}
