package com.capgemini.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pname;
	
	private double price;
	
	//private int quantity;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String pname, double price) {
		super();
		this.pname = pname;
		this.price = price;
		//this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", price=" + price + "]";
	}

//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
//	}
	
	
	
	

}
