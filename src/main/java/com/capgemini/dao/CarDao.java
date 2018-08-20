package com.capgemini.dao;

import com.capgemini.domain.CarEntity;

import java.util.Date;
import java.util.List;

public interface CarDao extends Dao<CarEntity, Long> {

    CarEntity addCar(CarEntity carEntity);

    void deleteCar (CarEntity carEntity);

    void deleteCarById(Long carId);

    CarEntity editCar(CarEntity carEntity);

    List<CarEntity> findByTypeAndBrand(String type, String brand);

    List<CarEntity> findByType(String type);

    /**
     * Find cars that are rented by different clients and more than requested value.
     * @param numberOfClients number of clients that has rent a car.
     * @return Cars rented by more than requested clients number.
     */
    List<CarEntity> findCarRentByMoreThan(long numberOfClients);

    /**
     * Find cars that was used in given period.
     * @param beginOfRental Date of beginning of rental period.
     * @param endOfRental Date of the end of rental period.
     * @return Cars rented in given period.
     */
    List<CarEntity> findCarRentedInPeriod(Date beginOfRental, Date endOfRental);
}
