package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Person;
import com.repository.PersonRepository;
 
@Component
@Path("/payment")
public class PersonRestCrud {
 
 
	@Autowired
	private PersonRepository PersonRepository;
	
	@GET
	@Path("/daniel")
	@Produces("application/json")
	public Response savePayment() {
		
		int status=200;
		Person p1=new Person();
		p1.setName("daniel");
		
		Person pers=null;
		try{
		pers=PersonRepository.save(p1);
		if(pers==null)
			status=200;
		}
		catch(Exception e)
		{
			status=404;
			e.getStackTrace();
		}
		Response res=Response.status(status).entity(pers).build();
		return res;
 
	}
 
}