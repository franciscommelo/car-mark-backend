package com.example.carmark.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;


@Entity // This tells Hibernate to make a table out of this class
@Data // This tells lombok to generate getters, setters, and constructors
@AllArgsConstructor // This tells lombok to generate a constructor that takes all fields
@NoArgsConstructor // This tells lombok to generate a default constructor
public class Car {

    @Id // This tells Hibernate to use this as the primary key
    @GeneratedValue(strategy = AUTO) // This tells Hibernate to generate an id for us
    private Long id;
    private String make;
    private String model;
    private String color;
    private int year;
    private int price;
    private int mileage;
    private String description;
    private String image;

}
