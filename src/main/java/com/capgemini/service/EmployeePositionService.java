package com.capgemini.service;

import com.capgemini.types.AgencyTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeePositionTO;
import com.capgemini.types.EmployeeTO;

import java.util.List;

public interface EmployeePositionService {

void savePosition(EmployeePositionTO employeePositionTO);

EmployeePositionTO getPosition (Long positionId);

}
