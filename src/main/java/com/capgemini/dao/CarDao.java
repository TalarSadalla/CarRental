package com.capgemini.dao;

import com.capgemini.domain.BookEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

import java.util.List;

public interface CarDao extends Dao<CarEntity, Long> {

    CarEntity addCar(CarEntity carEntity);

    void deleteCar (CarEntity carEntity);

    void deleteCarById(Long carId);

    CarEntity editCar(CarEntity carEntity);

    List<CarEntity> findByTypeAndBrand(String type, String brand);

    List<CarEntity> findByType(String type);
}
