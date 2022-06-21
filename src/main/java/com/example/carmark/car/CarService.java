package com.example.carmark.car;

import java.util.Collection;

public interface CarService {

    Car createCar(Car car);
    Collection<Car> getAllCars(int limit);
    Car getCarById(Long id);
    Car updateCar(Car car);
    boolean deleteCar(Long id);
    boolean deleteAllCars();
    boolean carExists(Long id);
    int getCarCount();
}
