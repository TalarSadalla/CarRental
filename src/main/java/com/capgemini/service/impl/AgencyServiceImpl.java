package com.capgemini.service.impl;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.AgencyMapper;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.AgencyService;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    AgencyDao agencyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public boolean addAgency(AgencyTO agencyTO) {
        if (agencyTO == null) return false;
        AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(agencyTO);
        agencyDao.addAgency(agencyEntity);
        return true;
    }

    @Override
    public AgencyTO saveAgency(AgencyTO agencyTO) {
        if (agencyTO == null) return null;
        AgencyEntity agencyEntity = agencyDao.save(AgencyMapper.toAgencyEntity(agencyTO));
        return AgencyMapper.toAgencyTO(agencyEntity);
    }

    @Override
    public AgencyTO findAgencyById(long agencyId) {
        AgencyTO agencyTO=AgencyMapper.toAgencyTO(agencyDao.findOne(agencyId));
        return agencyTO;
    }

    @Override
    public boolean deleteAgency(AgencyTO agencyTO) {
        if (agencyTO == null) return false;
        AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(agencyTO);
        agencyDao.delete(agencyEntity);
        return true;
    }

    @Override
    public AgencyTO editAgency(AgencyTO updatedAgency) {
        if (updatedAgency == null)
            return null;
        AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(updatedAgency);
        AgencyTO updatedAgencyTO = AgencyMapper.toAgencyTO(agencyDao.editAgency(agencyEntity));
        return updatedAgencyTO;
    }

    @Override
    public boolean addEmployeeToAgency(EmployeeTO employeeTO, AgencyTO agencyTO) {
        if (employeeTO == null || agencyTO == null)
            return false;

        employeeDao.addEmployeeToAgency(EmployeeMapper.toEmployeeEntity(employeeTO), AgencyMapper.toAgencyEntity(agencyTO));
        return true;
    }

    @Override
    public EmployeeTO deleteEmployeeFromAgency(EmployeeTO employeeTO) {
        if (employeeTO == null)
            return null;
        EmployeeEntity employeeEntity = employeeDao.removeEmployeeFromAgency(EmployeeMapper.toEmployeeEntity(employeeTO));
        EmployeeTO removedEmployeeTO = EmployeeMapper.toEmployeeTO(employeeEntity);

        return removedEmployeeTO;
    }

    @Override
    public List<EmployeeTO> findAllEmployeesInAgency(Long agencyId) {
        List<EmployeeEntity> employeeList=employeeDao.findAllEmployeeFromOneAgency(agencyId);
        return EmployeeMapper.map2TOs(employeeList);
    }

    @Override
    public List<EmployeeTO> findAllEmployeesInAgencyForSpecificCar(AgencyTO agencyTO, CarTO carTO) {
        List<EmployeeEntity> employeeList=employeeDao.findAllEmployeeFromOneAgencyForSpecificCar(AgencyMapper.toAgencyEntity(agencyTO), CarMapper.toCarEntity(carTO));
        return EmployeeMapper.map2TOs(employeeList);
    }
}
