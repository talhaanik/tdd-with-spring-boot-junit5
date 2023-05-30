package com.example.tddwithspringboot.service;



import com.example.tddwithspringboot.domain.Car;
import com.example.tddwithspringboot.domain.CarRepository;
import com.example.tddwithspringboot.web.CarNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	private CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Cacheable("cars")
	public Car getCarDetails(String name) {
		Car car = carRepository.findByName(name);
		if(car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}
}