package com.services;

import java.util.List;

import com.models.Booking;


public interface BookingService {

	Booking save(Booking b1);

	Booking getBookingById(Long id);

	void deleteBooking(Long id);

	List<Booking> findAllBookings();

	List<Booking> findAllBookingsForThisCar(Long id);

	void deleteBookingForThisCar(Long idCar);

}
