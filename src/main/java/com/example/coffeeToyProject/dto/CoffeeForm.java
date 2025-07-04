package com.example.coffeeToyProject.dto;

import com.example.coffeeToyProject.entity.CoffeeEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoffeeForm {

    private Long id;
    private String name;
    private String price;

    public CoffeeEntity toEntity(){
        return new CoffeeEntity(id,name,price);
    }

    @Override
    public String toString() {
        return "CoffeeForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
