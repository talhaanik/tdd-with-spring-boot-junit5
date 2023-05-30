package com.example.tddwithspringboot.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,String> {

	Car findByName(String name);

}