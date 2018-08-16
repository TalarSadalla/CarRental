package com.capgemini.dao.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
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
        update(carEntity);
        return carEntity;
    }

    @Override
    public List<CarEntity> findByTypeAndBrand(String type, String brand) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.type) like concat(upper(:type), '%') AND upper(car.brand) like concat(upper(:brand), '%')", CarEntity.class);
        query.setParameter("type", type);
        query.setParameter("brand", brand);
        return query.getResultList();
    }

    @Override
    public CarEntity addCarToEmployee(CarEntity carEntity) {
    return null;
    }

    @Override
    public List<CarEntity> findCarByEmployee(EmployeeEntity employeeEntity) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where employeeEntity.id member of car.carEntitySet '%')", CarEntity.class);
        query.setParameter("employeeEntity", employeeEntity);
        return query.getResultList();
    }
}
