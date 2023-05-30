package com.example.tddwithspringboot.web;

import com.example.tddwithspringboot.domain.Car;
import com.example.tddwithspringboot.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class CarsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar_WithName_ReturnsCar() throws Exception {
        when(this.carService.getCarDetails("prius")).thenReturn(new Car("prius", "hybrid"));
        this.mockMvc.perform(get("/cars/{name}", "prius"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("prius"))
                .andExpect(jsonPath("type").value("hybrid"));
    }

    @Test
    public void getCar_NotFound_Returns404() throws Exception {
        when(this.carService.getCarDetails(any())).thenReturn(null);
        this.mockMvc.perform(get("/cars/{name}", "prius"))
                .andExpect(status().isNotFound());
    }
}