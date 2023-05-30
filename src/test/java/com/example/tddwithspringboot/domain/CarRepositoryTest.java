package com.example.tddwithspringboot.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class CarRepositoryTest {
    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName_ReturnsCar() throws Exception {
        Car savedCar = testEntityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car = this.repository.findByName("prius");
        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());
    }
    @Test
    public void saveCarr() throws Exception {
        Car savedCar = repository.save(new Car("prius", "hybrid"));
        Car car = this.repository.findByName("prius");
        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());
    }
    @Test
    public void findOnlyCarName(){
        Car car = this.repository.findByName("prius");
        assertThat(car.getName()).isEqualTo("prius");
    }
}