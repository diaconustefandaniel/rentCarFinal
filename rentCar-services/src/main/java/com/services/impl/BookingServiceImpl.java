package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Booking;
import com.repository.BookingRepository;
import com.repository.CarRepository;
import com.services.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;

	public Booking save(Booking b1) {
		// TODO Auto-generated method stub
		return bookingRepository.save(b1);
	}

	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		return bookingRepository.findOne(id);
	}

	public void deleteBooking(Long id) {
		bookingRepository.delete(id);
		// TODO Auto-generated method stub
		
	}

	public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	public List<Booking> findAllBookingsForThisCar(Long id) {
		// TODO Auto-generated method stub
		return bookingRepository.findAllBookingForThisCar(id);
	}

	public void deleteBookingForThisCar(Long idCar) {
		bookingRepository.deleteAllBookingForThisCar(idCar);
		
	}
	
	

}
