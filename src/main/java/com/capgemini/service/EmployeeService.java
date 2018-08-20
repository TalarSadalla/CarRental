package com.capgemini.service;

import com.capgemini.types.EmployeeSearchCriteriaTO;
import com.capgemini.types.EmployeeTO;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(EmployeeTO employeeTO);

    EmployeeTO findEmployeeById(Long employeeId);

    EmployeeTO saveEmployee(EmployeeTO employeeTO);

    boolean deleteEmployee(EmployeeTO employeeTO);

    boolean deleteEmployeeById(Long employeeId);

    EmployeeTO editEmployee(EmployeeTO employeeTO);

    /**
     * Function search for an employees that fulfill search criteria, which are
     * AgencyId, EmployeePositionId and carId
     * @param employeeSearchCriteriaTO consists of 3 arguments AgencyId, EmployeePositionId and carId
     * @return gives a list of Employees that fulfill criteria
     */
    List<EmployeeTO> findEmployeesBySearchCriteria(EmployeeSearchCriteriaTO employeeSearchCriteriaTO);

}
