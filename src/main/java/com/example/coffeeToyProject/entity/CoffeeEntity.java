package com.example.coffeeToyProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String price;

    @Override
    public String toString() {
        return "CoffeeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public void patch(CoffeeEntity entity){
        if (entity.getName()!=null){
            this.name=entity.getName();
        }

        if(entity.getPrice()!=null){
            this.price=entity.getPrice();
        }
    }
}
