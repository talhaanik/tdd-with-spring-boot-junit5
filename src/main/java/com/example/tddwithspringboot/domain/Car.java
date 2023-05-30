package com.example.tddwithspringboot.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String type;

	public Car(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Car() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}