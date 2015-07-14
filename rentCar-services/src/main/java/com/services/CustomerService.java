package com.services;

import java.util.List;

import com.models.Customer;

public interface CustomerService {

	Customer save(Customer c1);
	
	Customer getCustomerById(Long id);

	void deleteCustomer(Long id);

	List<Customer> findAllCustomers();

}
