package com.rent.rent.controller;

import com.rent.rent.repository.carRepository;
import com.rent.rent.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //The answer will be Json
public class CarController {

    @Autowired
    private carRepository carRepository;

    //Show all Cars
    @GetMapping(value = "/car")
    public Iterable<Car> listcars(){
        return carRepository.findAll();
    }

    //Show one car
    @GetMapping(value = "/car/{id}") //Call this methode only for a get request
    public Car displayCar(@PathVariable int id){
        return carRepository.findById(id).get();
    }

    //Add car
    @PostMapping(value = {"/car/"})
    public Car saveCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    //Update car
    @PutMapping(value = {"/car/{id}"})
    public Car updateCar(@RequestBody Car car, @PathVariable int id) {
        return carRepository.findById(id).map(isCar -> {
           isCar.setModele(car.getModele());
           isCar.setBrand(car.getBrand());
           isCar.setColor(car.getColor());
           isCar.setPrice(car.getPrice());
           isCar.setImage(car.getImage());

           return carRepository.save(car);
        }).orElseGet(()-> {
           car.setId(id);
           return carRepository.save(car);
        });
    }

    //Delete one product
    @DeleteMapping(value = "/car/{id}")
    public Boolean deleteCar(@PathVariable int id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
}