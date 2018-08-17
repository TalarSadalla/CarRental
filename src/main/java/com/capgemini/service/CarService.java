package com.capgemini.service;

import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

import java.util.List;
import java.util.Set;

public interface CarService {

    boolean addCar(CarTO carTO);

    CarTO saveCar(CarTO carTO);

    boolean deleteCar(CarTO carTO);

    boolean deleteCarById(Long carId);

    CarTO editCar(CarTO carTO);

    CarTO findCarById(Long id);

    boolean addCarToEmployee(CarTO carTO, EmployeeTO employeeTO);

    Set<CarTO> findCarByTypeAndBrand(CarTO carTO);

    Set<CarTO> findCarByType(CarTO carTO);

    Set<CarTO> findCarByEmployee(EmployeeTO employeeTO, CarTO carTO);
}
