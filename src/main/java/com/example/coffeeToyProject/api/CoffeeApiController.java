package com.example.coffeeToyProject.api;

import com.example.coffeeToyProject.dto.CoffeeForm;
import com.example.coffeeToyProject.entity.CoffeeEntity;
import com.example.coffeeToyProject.repository.CoffeeRepository;
import com.example.coffeeToyProject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {


    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/menu")
    public List<CoffeeEntity> list(){

        return coffeeService.list();

    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<CoffeeEntity> show(@PathVariable Long id){

        CoffeeEntity coffeeEntity=coffeeService.show(id);
        return (coffeeEntity != null) ? ResponseEntity.status(HttpStatus.OK).body(coffeeEntity)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/menu")
    public ResponseEntity<CoffeeEntity> create(@RequestBody CoffeeForm coffeeForm){

        CoffeeEntity created = coffeeService.create(coffeeForm);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/menu/{id}")
    public ResponseEntity<CoffeeEntity> update(@PathVariable Long id, @RequestBody CoffeeForm coffeeForm){

        CoffeeEntity updated = coffeeService.update(id,coffeeForm);

        return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<CoffeeEntity> delete(@PathVariable Long id){
       CoffeeEntity deleted = coffeeService.delete(id);
        return (deleted != null) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

}
