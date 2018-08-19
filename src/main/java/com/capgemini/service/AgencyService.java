package com.capgemini.service;

import com.capgemini.types.AgencyTO;
import com.capgemini.types.BookTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

import java.util.List;
import java.util.Set;

public interface AgencyService {

    boolean addAgency(AgencyTO agencyTO);

    AgencyTO findAgencyById(AgencyTO agencyTO);

    boolean deleteAgency(AgencyTO agencyTO);

    AgencyTO editAgency(AgencyTO updatedAgency);

    boolean addEmployeeToAgency(EmployeeTO employeeTO, AgencyTO agencyTO);

    EmployeeTO deleteEmployeeFromAgency(EmployeeTO employeeTO);

    Set<EmployeeTO> findAllEmployeesInAgency(AgencyTO agencyTO);

    Set<EmployeeTO> findAllEmployeesInAgencyForSpecificCar(EmployeeTO employeeTO, AgencyTO agencyTO, CarTO carTO);

}
