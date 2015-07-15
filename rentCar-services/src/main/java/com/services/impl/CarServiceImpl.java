package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Car;
import com.models.Customer;
import com.repository.CarRepository;
import com.repository.CustomerRepository;
import com.services.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	
	public Car save(Car c1) {
		// TODO Auto-generated method stub
		return carRepository.save(c1);
	}

	public Car getCarById(Long id) {
		// TODO Auto-generated method stub
		return carRepository.findOne(id);
	}

	public void deleteCar(Long id) {
		carRepository.delete(id);
		// TODO Auto-generated method stub
		
	}

	public List<Car> findAllCars() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

}
