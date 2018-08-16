package com.capgemini.service;

import com.capgemini.types.BookTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

import java.util.List;
import java.util.Set;

public interface CarService {
    boolean addCar(CarTO carTO);

    boolean deleteCar(CarTO carTO);

    CarTO editCar(CarTO carTO);

    boolean addCarToEmployee(CarTO carTO, EmployeeTO employeeTO);

    List<CarTO> findCarByTypeAndBrand(CarTO carTO);

    List<CarTO> findCarByEmployee(EmployeeTO employeeTO, CarTO carTO);
}
