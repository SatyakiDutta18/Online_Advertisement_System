package com.capgemini.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cname;
	private String userName;
	private String password;
	private String caddress;
	private String phone;

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int id, String cname, String userName, String password, String caddress, String phone) {
		super();
		this.id = id;
		this.cname = cname;
		this.userName = userName;
		this.password = password;
		this.caddress = caddress;
		this.phone = phone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCaddress() {
		return caddress;
	}


	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", cname=" + cname + ", userName=" + userName + ", password=" + password
				+ ", caddress=" + caddress + ", phone=" + phone + "]";
	}


	
}
