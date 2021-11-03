package com.rent.rent.repository;

import com.rent.rent.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carRepository extends CrudRepository<Car, Integer> {
}
