package com.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Customer;
import com.repository.CustomerRepository;
import com.services.CustomerService;

@Component
@Path("/customer")
public class CustomerRestCrud {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	@POST
	@Path("")
	@Produces("application/json")
	public Response savePayment() {

		int status = 200;
		Customer c1 = new Customer();
		c1.setCustomerName("Vasile");
		c1.setCustomerEmail("myEmail.com");

		try {
			customerService.save(c1);

			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(c1).build();
		return res;

	}

}
