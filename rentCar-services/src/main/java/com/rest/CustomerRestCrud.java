package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

	@POST
	@Path("")
	@Produces("application/json")
	public Response saveCustomer() {

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
	
	@GET
	@Path("{param1}")
	@Produces("application/json")
	public Response getCustomer(@PathParam("param1") String param1)
	{
		Long id=Long.parseLong(param1);
		int status=200;
		Customer c1=null;
		//Long id=1L;
		
		try{
			c1=customerService.getCustomerById(id);
			if(c1==null)
				status=204;
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(c1).build();
		return res;

	}
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	public Response deleteCustomer(@PathParam("id") String param1)
	{
		Long id=Long.parseLong(param1);
		int status=200;
		Customer c1=null;
		//Long id=1L;
		
		try{
			customerService.deleteCustomer(id);
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).build();
		return res;
	}
	
	@GET
	@Path("")
	@Produces("application/json")
	public Response getAllCustomers()
	{
		List<Customer> allCustomers=new ArrayList<Customer>();
		int status=200;		
		try{
			allCustomers=customerService.findAllCustomers();
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(allCustomers).build();
		return res;
	}
	
	

}
