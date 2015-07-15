package com.services;

import java.util.List;

import com.models.Car;
import com.models.Customer;

public interface CarService {

	Car save(Car c1);

	Car getCarById(Long id);

	void deleteCar(Long id);

	List<Car> findAllCars();

}
