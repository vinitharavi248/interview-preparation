package com.car_parking.car.controller;

import com.car_parking.car.dao.Cars;
import com.car_parking.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cars")

public class CarController {
    @Autowired
    private CarService serviceobj;

    @GetMapping
    public List<Cars> getAllCars() {

        return serviceobj.getAllCars();
    }

    @PostMapping
    public Cars create(@RequestBody Cars c) {

        return serviceobj.createCars(c);
    }

    @PutMapping("/{Car_id}")
    public Cars update(@RequestBody Cars c, @PathVariable int Car_id) {

        return serviceobj.updateCar(c, Car_id);
    }

    @DeleteMapping("/{Car_id}")
    public String delete(@PathVariable int Car_id) {

        return serviceobj.deleteCar(Car_id);
    }
}
//CarController.java
