package com.rent.rent.dao;

import com.rent.rent.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class carDaoImpl implements carDao {

    public List<Car> cars = new ArrayList<>();

    public carDaoImpl(){
        cars.add(new Car(1, new String("Master"), new String("Renault"), new String("yellow"), 50, new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXMjs4cV87nu22LM9klvK49P60pUZMoYbgt7ezrByc8ad6PtidGbn9GJKvN1cajiJJeDg&usqp=CAU")));
        cars.add(new Car(10, new String("Ducato"), new String("Fiat"), new String("red"), 60, new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTU3IIya8F6A0Vd_hHzWyEim2NkHH7PhTsqG1JW5RfuBt__szBghbAeQBPW0wbSPrOXoVU&usqp=CAU")));
        cars.add(new Car(30, new String("Sprinter"), new String("Mercedes"), new String("light grey"), 100, new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBTueSHaoXL5_LtVSPLNrA8mZXGcQezMAV99yXBUXrdNWqrkQD4LOI5CjGJrhqyeDUqO0&usqp=CAU")));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                return cars.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == car.getId()) {
                cars.remove(i);
            }
        }
    }

    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public Car update(Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == car.getId()) {
                cars.set(i, car);
                return car;
            }
        }

        return null;
    }
}
