package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.entities.Car;
import com.example.services.CarService;
@RestController
@RequestMapping("/cars")
public class CarsController {
	@Autowired
	private CarService carService;
	
	@GetMapping
	public List<Car> getAllCars(){
		return carService.getAllCars();
	}
	
	@GetMapping("/{id}")
	public Car getCar(@PathVariable Long id) {
		return carService.getCar(id);
	} 
	
	@PostMapping
	public Car addCar(@RequestBody Car car) {
		return carService.addCar(car);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
	}
}
