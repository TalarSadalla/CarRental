package com.capgemini.dao.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

    @Override
    public CarEntity addCar(CarEntity carEntity) {
        save(carEntity);
        return carEntity;
    }

    @Override
    public void deleteCar(CarEntity carEntity) {
    delete(carEntity);
    }

    @Override
    public void deleteCarById(Long carId) {
        delete(carId);
    }

    @Override
    public CarEntity editCar(CarEntity carEntity) {
      return update(carEntity);
    }

    @Override
    public List<CarEntity> findByTypeAndBrand(String type, String brand) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.carType) like concat(upper(:type), '%') AND upper(car.brand) like concat(upper(:brand), '%')", CarEntity.class);
        query.setParameter("type", type);
        query.setParameter("brand", brand);
        return query.getResultList();
    }

    @Override
    public List<CarEntity> findByType(String type) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.carType) like concat(upper(:type), '%')", CarEntity.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarRentByMoreThan(long numberOfClients) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car " +
                        "where car.id in (select rental.car.id from RentalEntity rental " +
                        "group by rental.car.id " +
                        "having count(distinct rental.clientEntity.id) > :numberOfClients)", CarEntity.class
        );
        query.setParameter("numberOfClients", numberOfClients);
        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarRentedInPeriod(Date beginOfRental, Date endOfRental) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car join car.rentals cr where cr.startDate >= :from and cr.endDate <= :to",
                CarEntity.class);
        query.setParameter("from", beginOfRental);
        query.setParameter("to", endOfRental);
        return query.getResultList();
    }

}
