package com.capgemini.service.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public boolean addCar(CarTO carTO) {
        if (carTO == null) return false;
        carDao.addCar(CarMapper.toCarEntity(carTO));
        return true;
    }

    @Override
    public CarTO saveCar(CarTO carTO) {
        if (carTO == null) return null;
       CarEntity carEntity= carDao.save(CarMapper.toCarEntity(carTO));
        return CarMapper.toCarTO(carEntity);
    }

    @Override
    public boolean deleteCar(CarTO carTO) {
        if (carTO == null) return false;
        carDao.deleteCar(CarMapper.toCarEntity(carTO));
        return true;
    }

    @Override
    public boolean deleteCarById(Long carId) {
        carDao.deleteCarById(carId);
        return true;
    }

    @Override
    public CarTO editCar(CarTO carTO) {
        if (carTO == null) return null;
        CarEntity carEntity = carDao.update(CarMapper.toCarEntity(carTO));
        return CarMapper.toCarTO(carEntity);
    }

    @Override
    public CarTO findCarById(Long id) {
        CarEntity foundCar=carDao.findOne(id);
        return CarMapper.toCarTO(foundCar);
    }

    @Override
    public boolean addCarToEmployee(CarTO carTO, EmployeeTO employeeTO) {
        if (carTO == null || employeeTO == null) return false;
        EmployeeEntity employeeEntity=EmployeeMapper.toEmployeeEntity(employeeTO);
        CarEntity carEntity=CarMapper.toCarEntity(carTO);
        employeeEntity.getCarEntitySet().add(CarMapper.toCarEntity(carTO));
        employeeDao.update(employeeEntity);
        carDao.update(carEntity);
        return true;
    }

    @Override
    public List<CarTO> findCarByTypeAndBrand(CarTO carTO) {
        if (carTO == null) return null;
        CarEntity carEntity=CarMapper.toCarEntity(carTO);
        List<CarEntity> carList=carDao.findByTypeAndBrand(carEntity.getCarType(),carEntity.getBrand());
        return CarMapper.map2TOs(carList);
    }

    @Override
    public List<CarTO> findCarByType(CarTO carTO) {
        if (carTO == null) return null;
        CarEntity carEntity=CarMapper.toCarEntity(carTO);
        List<CarEntity> carList=carDao.findByType(carEntity.getCarType());
        return CarMapper.map2TOs(carList);
    }

    @Override
    public List<CarTO> findCarByEmployee(EmployeeTO employeeTO) {
        if (employeeTO == null) return null;
        EmployeeEntity employeeEntity=EmployeeMapper.toEmployeeEntity(employeeTO);
        List<CarEntity> carList=employeeDao.findCarByEmployee(employeeEntity);

        return CarMapper.map2TOs( carList);
    }

    @Override
    public List<CarTO> findCarRentByMoreThan(long numberOfClients) {
        return CarMapper.map2TOs(carDao.findCarRentByMoreThan(numberOfClients));
    }

    @Override
    public List<CarTO> findCarRentedInPeriod(Date beginOfRental, Date endOfRental) {
        return CarMapper.map2TOs(carDao.findCarRentedInPeriod(beginOfRental,endOfRental));
    }
}
