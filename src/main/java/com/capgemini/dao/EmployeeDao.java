package com.capgemini.dao;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.BookEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

    EmployeeEntity findEmployeeById(Long employeeId);

    void addEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity editEmployee(EmployeeEntity employeeEntity);

    void deleteEmployee(Long employeeId);

    EmployeeEntity deleteEmployee(EmployeeEntity employeeEntity);

    void addEmployeeToAgency(EmployeeEntity employeeEntity, AgencyEntity agencyEntity);

    EmployeeEntity removeEmployeeFromAgency(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAllEmployeeFromOneAgency(AgencyEntity agencyEntity);

    List<EmployeeEntity> findAllEmployeeFromOneAgencyForSpecificCar(CarEntity carEntity);

    List<CarEntity> findCarByEmployee(EmployeeEntity employeeEntity, CarEntity carEntity);

    void addCarToEmployee(CarEntity carEntity, EmployeeEntity employeeEntity);

}
