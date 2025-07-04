package com.example.coffeeToyProject.repository;

import com.example.coffeeToyProject.entity.CoffeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CoffeeRepository extends CrudRepository<CoffeeEntity,Long> {

    @Override
    public ArrayList<CoffeeEntity> findAll();
}
