package com.tests;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.tests.BaseServicesTest;
import com.models.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class PersonTest extends BaseServicesTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testSave(){
		Person p = new Person();
		p.setName("TTT");
		Person newPErson = this.personService.savePerson(p);
		Person found = this.personService.getById(newPErson.getId());
		Assert.assertEquals("TTT", found.getName());
	}
	
	@Test
	public void testSavePayment()
	{
		
		Client client=Client.create();     
		WebResource webResourceTest =client.resource("http://localhost:8080/rentCar-web/rest/payment/daniel");
		//WebResource webResourceTest = webResource.path("/payment/daniel");
	    // String responseString = webResourceTest.type(MediaType.APPLICATION_JSON).get(Person.class);
	    //Assert.assertEquals("Request fulfilled.", responseString);
	    
	    ClientResponse response = webResourceTest.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	    Assert.assertEquals(200, response.getStatus());
	}
}