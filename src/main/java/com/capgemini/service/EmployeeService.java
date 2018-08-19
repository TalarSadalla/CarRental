package com.capgemini.service;

import com.capgemini.types.BookTO;
import com.capgemini.types.EmployeeTO;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(EmployeeTO employeeTO);

    EmployeeTO findEmployeeById(EmployeeTO employeeTO);

    EmployeeTO saveEmployee(EmployeeTO employeeTO);

    boolean deleteEmployee(EmployeeTO employeeTO);

    boolean deleteEmployeeById(Long employeeId);

    EmployeeTO editEmployee(EmployeeTO employeeTO);

}
