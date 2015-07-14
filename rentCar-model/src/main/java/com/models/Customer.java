package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId;
	
	private String customerName;
	
	private String customerSurname;
	
	private long customerCnp;
	
	private String customerEmail;
	
	private long customerTel;
	
	public Customer() {
		super();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public long getCustomerCnp() {
		return customerCnp;
	}

	public void setCustomerCnp(long customerCnp) {
		this.customerCnp = customerCnp;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getCustomerTel() {
		return customerTel;
	}

	public void setCustomerTel(long customerTel) {
		this.customerTel = customerTel;
	}
	
	
}
