package com.example.carmark.car;

import com.example.carmark.Response;
import com.example.carmark.exception.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Map.of;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarServiceImpl carService;

    @RequestMapping("/")
    public ResponseEntity<Response> getAllCars() {
        List<Car> cars = (List<Car>) carService.getAllCars(50);


        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("cars", cars))
                .developerMessage("Success")
                .build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response> getCarById(@PathVariable("id") Long id) {

        Car car = carService.getCarById(id);

        if(car == null) throw new ApiRequestException("Car not found");

        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("car", car))
                .developerMessage("Success")
                .build());
    }


    @RequestMapping(value="/{id}", consumes = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<Response> updateCar(@PathVariable("id") Long id, @RequestBody Car car) {

    //    if(!carService.carExists(id)) throw new ApiRequestException("No car found with id: " + id);

        Car newCar = carService.getCarById(id);

            newCar.setId(id);
            newCar.setMake(car.getMake());
            newCar.setModel(car.getModel());
            newCar.setYear(car.getYear());
            newCar.setColor(car.getColor());
            newCar.setPrice(car.getPrice());
            newCar.setMileage(car.getMileage());
            newCar.setDescription(car.getDescription());
            newCar.setImage(car.getImage());

        carService.updateCar(car);

        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("car", newCar))
                .developerMessage("Success")
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCar(@PathVariable("id") Long id) {

        if(!carService.carExists(id)) throw new ApiRequestException("No car found with id: " + id);

        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("deleted", carService.deleteCar(id)))
                .developerMessage("Success")
                .build());
    }

    @RequestMapping("/deleteAll")
    public ResponseEntity<Response> deleteAllCars() {
        carService.deleteAllCars();
        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("car", null))
                .developerMessage("Success")
                .build());
    }

    @RequestMapping("/count")
    public ResponseEntity<Response> getCarCount() {
        int count = carService.getCarCount();
        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("count", count))
                .developerMessage("Success")
                .build());
    }

    @RequestMapping("/exists/{id}")
    public ResponseEntity<Response> carExists(@PathVariable("id") Long id) {
        boolean exists = carService.carExists(id);
        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("exists", exists))
                .developerMessage("Success")
                .build());
    }

    @PostMapping("/")
    public ResponseEntity<Response> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return ResponseEntity.ok(Response.builder()
                .message("Success")
                .status("200")
                .code("200")
                .data(of("car", createdCar))
                .developerMessage("Success")
                .build());
    }

}
