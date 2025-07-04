package com.example.coffeeToyProject.api;

import com.example.coffeeToyProject.dto.CoffeeForm;
import com.example.coffeeToyProject.entity.CoffeeEntity;
import com.example.coffeeToyProject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ApiController {

    @Autowired
    CoffeeRepository coffeeRepository;

    @GetMapping("/menu")
    public List<CoffeeEntity> list(){

        return coffeeRepository.findAll();

    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<CoffeeEntity> show(@PathVariable Long id){

        CoffeeEntity coffeeEntity=coffeeRepository.findById(id).orElse(null);
        log.info(coffeeEntity.toString());

        if (coffeeEntity==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(coffeeEntity);
    }

    @PostMapping("/menu")
    public ResponseEntity<CoffeeEntity> create(@RequestBody CoffeeForm coffeeForm){

        log.info(coffeeForm.toString());

        CoffeeEntity entity=coffeeForm.toEntity();
        log.info(entity.toString());

        CoffeeEntity saved = coffeeRepository.save(entity);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @PatchMapping("/menu/{id}")
    public ResponseEntity<CoffeeEntity> update(@PathVariable Long id, @RequestBody CoffeeForm coffeeForm){

        log.info(coffeeForm.toString());
        CoffeeEntity target= coffeeRepository.findById(id).orElse(null);
        CoffeeEntity updateEntity=coffeeForm.toEntity();


        if (target==null | updateEntity.getId()!=id){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        target.patch(updateEntity);
        coffeeRepository.save(target);

        return ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<CoffeeEntity> delete(@PathVariable Long id){
        CoffeeEntity target=coffeeRepository.findById(id).orElse(null);

        if (target==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

}
