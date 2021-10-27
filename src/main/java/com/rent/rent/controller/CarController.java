package com.rent.rent.controller;

import com.rent.rent.dao.carDao;
import com.rent.rent.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //The answer will be Json
public class CarController {

    @Autowired
    private carDao carDao;

    //Show all Cars
    @GetMapping(value = "/cars")
    public List<Car> listcars(){
        return carDao.findAll();
    }

    //Show one car
    @GetMapping(value = "/car/{id}") //Call this methode only for a get request
    public Car displayCar(@PathVariable int id){
        return carDao.findById(id);
    }

    //Add car
    @PostMapping(value = {"/car/add"})
    public Car saveCar(@RequestBody Car car) {
        return carDao.save(car);
    }

    //Update car
    @PostMapping(value = {"/car/update"})
    public Car updateCar(@RequestBody Car car) {
        return carDao.update(car);
    }

    //Delete one product
    @DeleteMapping(value = "/car/delete/{id}")
    public void deleteCar(@PathVariable int id) {
        Car car = carDao.findById(id);
        carDao.delete(car);
    }
}