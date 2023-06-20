package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.NotFoundException;
import com.example.persistence.CarRepo;
import com.example.persistence.entities.Car;

@Service
public class CarService {
	@Autowired
	private CarRepo carRepo;

	public List<Car> getAllCars() {
		return carRepo.findAll();
	}

	public Car getCar(Long id) {
		return carRepo.findById(id).orElseThrow(() -> new NotFoundException("Car", id));
	}

	public Car addCar(Car car) {
		return carRepo.save(car);
	}

	public void deleteCar(Long id) {
		carRepo.deleteById(id);
	}
}
