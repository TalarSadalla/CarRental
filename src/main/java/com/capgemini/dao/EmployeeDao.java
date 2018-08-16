package com.capgemini.dao;

import com.capgemini.domain.BookEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

import java.util.List;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

    EmployeeEntity findEmployeeById(Long employeeId);

    EmployeeEntity addEmployee (EmployeeEntity employeeEntity);

    EmployeeEntity editEmployee(EmployeeEntity employeeEntity);

    void deleteEmployee(Long employeeId);

    void deleteEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity addEmployeeToAgency(EmployeeEntity employeeEntity);

    void removeEmployeeFromAgency(Long employeeId);

    void removeEmployeeFromAgency(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAllEmployeeFromOneAgencyForSpecificCar(CarEntity carEntity);

}
