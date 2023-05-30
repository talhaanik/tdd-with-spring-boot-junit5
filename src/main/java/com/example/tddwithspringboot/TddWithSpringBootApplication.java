package com.example.tddwithspringboot;

import com.example.tddwithspringboot.domain.Car;
import com.example.tddwithspringboot.domain.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TddWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddWithSpringBootApplication.class, args);
    }

//@Bean
    public CommandLineRunner apprunner(CarRepository repository) {
        return args -> {
            repository.save(new Car("prius", "hybrid"));
        };
    }
}
