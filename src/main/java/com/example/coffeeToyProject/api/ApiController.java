package com.example.coffeeToyProject.api;

import com.example.coffeeToyProject.entity.CoffeeEntity;
import com.example.coffeeToyProject.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    CoffeeRepository coffeeRepository;

    @GetMapping("/menu")
    public List<CoffeeEntity> list(){

        return coffeeRepository.findAll();

    }

}
