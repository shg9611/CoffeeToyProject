package com.example.coffeeToyProject.service;

import com.example.coffeeToyProject.dto.CoffeeForm;
import com.example.coffeeToyProject.entity.CoffeeEntity;
import com.example.coffeeToyProject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<CoffeeEntity> list(){
        return coffeeRepository.findAll();
    }

    public CoffeeEntity show(Long id){

        CoffeeEntity entity = coffeeRepository.findById(id).orElse(null);

        return entity;

    }

    public CoffeeEntity create(CoffeeForm coffeeForm) {

        CoffeeEntity entity = coffeeForm.toEntity();

        if (coffeeRepository.existsById(entity.getId())){
            return null;
        }
        return coffeeRepository.save(entity);

    }

    public CoffeeEntity update(Long id, CoffeeForm coffeeForm) {

        CoffeeEntity updateData = coffeeForm.toEntity();
        CoffeeEntity target=coffeeRepository.findById(id).orElse(null);

        log.info(updateData.toString());
        log.info(target.toString());

        if(updateData.getId() != null || target==null){
            return null;
        }

        target.patch(updateData);
        coffeeRepository.save(target);

        log.info(target.toString());
        return target;


    }

    public CoffeeEntity delete(Long id){

        CoffeeEntity target = coffeeRepository.findById(id).orElse(null);

        if (target==null){
            return null;
        }
        log.info(target.toString());

        coffeeRepository.delete(target);

        return target;
    }
}
