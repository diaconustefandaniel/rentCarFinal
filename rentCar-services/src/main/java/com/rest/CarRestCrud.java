package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/car")
public class CarRestCrud {

	@Autowired
	private CarService carService;
	
	@Autowired
	private BookingService bookingService;
	
	@POST
	@Path("")
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveCar(Car ourCar) {

		int status = 200;
		/*Car myCar=new Car();
		myCar.setName("Wolgwagen Golf 6");
		myCar.setStatus(true);*/

		System.out.println(ourCar);
		
		try {
			carService.save(ourCar);
			status = 200;

		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(ourCar).build();
		return res;
	}
	
	@GET
	@Path("{param1}")
	@Produces("application/json")
	public Response getCar(@PathParam("param1") String param1)
	{
		Long id=Long.parseLong(param1);
		int status=200;
		Car myCar=null;
		//Long id=1L;
		
		try{
			myCar=carService.getCarById(id);
			if(myCar==null)
				status=204;
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(myCar).build();
		return res;

	}
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	public Response deleteCar(@PathParam("id") String param1)
	{
		Long id=Long.parseLong(param1);
		int status=200;
		//Long id=1L;
		
		try{
			carService.deleteCar(id);
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
	public Response getAllCars()
	{
		List<Car> allCustomers=new ArrayList<Car>();
		int status=200;		
		try{
			allCustomers=carService.findAllCars();
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(allCustomers).build();
		return res;
	}
	
	@POST
	@Path("{carId}/booking")
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveCar(@PathParam("carId") String carId,  Booking ourBooking) {

		int status = 200;
		Long id=Long.parseLong(carId);
		/*Car myCar=new Car();
		myCar.setName("Wolgwagen Golf 6");
		myCar.setStatus(true);*/

		System.out.println(ourBooking);
		
		try {
			Car thisCar=carService.getCarById(id);
			ourBooking.setCar(thisCar);
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
	@Path("{carId}/booking/{bookingId}")
	@Produces("application/json")
	public Response getBooking(@PathParam("carId") String carId,@PathParam("bookingId") String bookingId)
	{
		Booking booking=null;
		Long id=Long.parseLong(bookingId);
		int status=200;		
		try{
			 booking=bookingService.getBookingById(id);
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(booking).build();
		return res;
	}
	
	@GET
	@Path("{carId}/booking")
	@Produces("application/json")
	public Response getAllBookingForThisCar(@PathParam("carId") String carId)
	{
		List<Booking> allBooking=new ArrayList<Booking>();
		Long id=Long.parseLong(carId);
		int status=200;		
		try{
			allBooking=bookingService.findAllBookingsForThisCar(id);
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(allBooking).build();
		return res;
	}
	
	@GET
	@Path("booking")
	@Produces("application/json")
	public Response getAllBooking(@PathParam("carId") String carId)
	{
		List<Booking> allBooking=new ArrayList<Booking>();
		int status=200;		
		try{
			allBooking=bookingService.findAllBookings();
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).entity(allBooking).build();
		return res;
	}
	
	@DELETE
	@Path("{carId}/booking/{bookingId}")
	@Produces("application/json")
	public Response deleteBooking(@PathParam("carId") String carId,@PathParam("bookingId") String bookingId)
	{
		Long idCar=Long.parseLong(carId);
		Long idBooking=Long.parseLong(bookingId);
		int status=200;
		//Long id=1L;
		
		try{
			bookingService.deleteBooking(idBooking);
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).build();
		return res;
	}
	
	@DELETE
	@Path("{carId}/booking/")
	@Produces("application/json")
	public Response deleteAllBookingForThisCar(@PathParam("carId") String carId)
	{
		Long idCar=Long.parseLong(carId);
		int status=200;
		//Long id=1L;
		
		try{
			bookingService.deleteBookingForThisCar(idCar);
		} catch (Exception e) {
			status = 404;
			e.getStackTrace();
		}
		Response res = Response.status(status).build();
		return res;
	}
	
	
	
	
}
