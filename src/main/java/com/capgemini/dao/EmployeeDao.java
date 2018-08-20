package com.capgemini.dao;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.EmployeeSearchCriteriaTO;

import java.util.List;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

    EmployeeEntity findEmployeeById(Long employeeId);

    void addEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity editEmployee(EmployeeEntity employeeEntity);

    void deleteEmployee(Long employeeId);

    EmployeeEntity deleteEmployee(EmployeeEntity employeeEntity);

    void addEmployeeToAgency(EmployeeEntity employeeEntity, AgencyEntity agencyEntity);

    EmployeeEntity removeEmployeeFromAgency(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAllEmployeeFromOneAgency(Long agencyId);

    List<EmployeeEntity> findAllEmployeeFromOneAgencyForSpecificCar(AgencyEntity agencyEntity, CarEntity carEntity);

    List<CarEntity> findCarByEmployee(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findEmployeesBySearchCriteria(EmployeeSearchCriteriaTO employeeSearchCriteriaTO,String queryAsString);

}
