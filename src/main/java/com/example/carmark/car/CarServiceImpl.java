package com.example.carmark.car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Component
@Slf4j
@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {


   private final CarRepo carRepo;

    @Override
    public Car createCar(Car car) {
        log.info("Creating car: {}", car.getId());
        return carRepo.save(car);
    }

    @Override
    public Collection<Car> getAllCars(int limit) {
        log.info("Getting all cars");
        return carRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        log.info("Getting car by id: {}", id);
        return carRepo.findById(id).orElse(null);
    }

    @Override
    public Car updateCar(Car car) {
        log.info("Updating car: {}", car.getId());
        return carRepo.save(car);
    }

    @Override
    public boolean deleteCar(Long id) {
        log.info("Deleting car: {}", id);
        carRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAllCars() {
        log.info("Deleting all cars");
        carRepo.deleteAll();
        return true;
    }

    @Override
    public boolean carExists(Long id) {
        log.info("Checking if car exists: {}", id);
        return carRepo.existsById(id);
    }

    @Override
    public int getCarCount() {
        log.info("Getting car count");
        return (int) carRepo.count();
    }
}

