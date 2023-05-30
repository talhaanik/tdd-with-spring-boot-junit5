package com.example.tddwithspringboot;


import com.example.tddwithspringboot.domain.Car;
import com.example.tddwithspringboot.domain.CarRepository;
import com.example.tddwithspringboot.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

	@Autowired
	private CarService service;

	@MockBean
	private CarRepository repository;

	@Test
	public void getCar_ReturnsCachedValue() throws Exception {
		given(repository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));
		service.getCarDetails("prius");
		service.getCarDetails("prius");
		verify(repository, times(1)).findByName("prius");
	}
}