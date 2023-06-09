package com.capgemini.main.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="cust_id")
	private int cid;
	@OneToOne(cascade = CascadeType.ALL)
	private Product pid;
	 private int quantity;
	
	@NotEmpty(message = "OrderDate Should  Not Be Empty!" )
	private String odate;
	
	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Orders(int id,String odate, int cid, Product pid,int quantity) {
		super();
		this.id = id;
		this.odate = odate;
		this.cid = cid;
		this.pid = pid;
		this.quantity =quantity;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public Product getPid() {
		return pid;
	}


	public void setPid(Product pid) {
		this.pid = pid;
	}


	public String getOdate() {
		return odate;
	}


	public void setOdate(String odate) {
		this.odate = odate;
	}

	

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Orders [id=" + id + ", cid=" + cid + ", pid=" + pid + ", quantity=" + quantity + ", odate=" + odate
				+ "]";
	}


	
	
	

}