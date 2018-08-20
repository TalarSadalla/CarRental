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

    List<EmployeeTO> findEmployeesBySearchCriteria(EmployeeSearchCriteriaTO employeeSearchCriteriaTO, String queryAsString);

}
