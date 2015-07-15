package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	@Query("select b from Booking b where b.car.id=:id")
	List<Booking> findAllBookingForThisCar(@Param("id") Long id);

	@Query("delete Booking b where b.car.id=:id")
	@Modifying
	void deleteAllBookingForThisCar(@Param("id") Long id);

}
