package com.example.tddwithspringboot.web;



import com.example.tddwithspringboot.domain.Car;
import com.example.tddwithspringboot.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {

	private final CarService carService;

	public CarsController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars/{name}")
	public Car getCar(@PathVariable String name) {
		Car car = this.carService.getCarDetails(name);
		if (car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}

}