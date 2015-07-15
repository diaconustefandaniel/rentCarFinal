package com.tests;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class CarTest {

	@Test
	public void testSaveCar(){
		
		Client client=Client.create();     
		WebResource webResourceTest =client.resource("http://localhost:8080/rentCar-web/rest/car");
		ClientResponse response=webResourceTest.type(MediaType.APPLICATION_JSON).post(ClientResponse.class);
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testGetCar(){
		
		Client client=Client.create();     
		WebResource webResourceTest =client.resource("http://localhost:8080/rentCar-web/rest/car/1");
		ClientResponse response=webResourceTest.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testDeleteCar(){
		
		Client client=Client.create();     
		WebResource webResourceTest =client.resource("http://localhost:8080/rentCar-web/rest/car/1");
		ClientResponse response=webResourceTest.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testAllCustomers()
	{
		Client client=Client.create();     
		WebResource webResourceTest =client.resource("http://localhost:8080/rentCar-web/rest/car/");
		ClientResponse response=webResourceTest.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Assert.assertEquals(200, response.getStatus());
	}
	
	
}
