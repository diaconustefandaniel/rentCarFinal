/*package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Booking;
import com.models.Car;
import com.services.BookingService;
import com.services.CarService;

@Component
@Path("/car/{carId}")
public class BookingRestCrud {

	@Autowired
	private BookingService bookingService;
	
	@POST
	@Path("/booking")
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveCar(@PathParam("carId") String carId,  Booking ourBooking) {

		int status = 200;
		Car myCar=new Car();
		myCar.setName("Wolgwagen Golf 6");
		myCar.setStatus(true);

		System.out.println(ourBooking);
		
		try {
			bookingService.save(ourBooking);
			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(ourBooking).build();
		return res;
	}
	
	@GET
	@Path("/booking")
	@Produces("application/json")
	public Response getAllCars()
	{
		List<Booking> allCustomers=new ArrayList<Booking>();
		int status=200;		
		try{
			allCustomers=bookingService.findAllBookings();
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(allCustomers).build();
		return res;
	}
	
	
}
*/