package com.rent.rent.dao;

import com.rent.rent.model.Car;

import java.util.List;

public interface carDao {
    public List<Car> findAll();

    public Car findById(int id);

    public void delete(Car car);

    public Car save(Car car);

    public Car update(Car car);
}
