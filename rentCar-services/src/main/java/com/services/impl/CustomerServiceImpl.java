package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Customer;
import com.repository.CustomerRepository;
import com.services.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer c1) {

		return this.customerRepository.save(c1);

	}

	public Customer getCustomerById(Long id) {
		
		return this.customerRepository.findOne(id);
	}

	public void deleteCustomer(Long id) {
		
		 this.customerRepository.delete(id);
	}

	public List<Customer> findAllCustomers() {
		
		return this.customerRepository.findAll();
	}

}
