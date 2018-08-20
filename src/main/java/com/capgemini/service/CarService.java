package com.capgemini.service;

import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

import java.util.Date;
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

    List<CarTO> findCarByTypeAndBrand(CarTO carTO);

    List<CarTO> findCarByType(CarTO carTO);

    List<CarTO> findCarByEmployee(EmployeeTO employeeTO);

    /**
     * Find cars that are rented by different clients and more than requested value.
     * @param numberOfClients number of clients that has rent a car.
     * @return Cars rented by more than requested clients number.
     */
    List<CarTO> findCarRentByMoreThan(long numberOfClients);

    /**
     * Find cars that was used in given period.
     * @param beginOfRental Date of beginning of rental period.
     * @param endOfRental Date of the end of rental period.
     * @return Cars rented in given period.
     */
    List<CarTO> findCarRentedInPeriod(Date beginOfRental, Date endOfRental);
}
