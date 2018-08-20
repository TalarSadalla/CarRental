package com.capgemini.service.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.EmployeeService;
import com.capgemini.types.EmployeeSearchCriteriaTO;
import com.capgemini.types.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public boolean addEmployee(EmployeeTO employeeTO) {
        if (employeeTO == null) return false;
        employeeDao.addEmployee(EmployeeMapper.toEmployeeEntity(employeeTO));
        return true;
    }

    @Override
    public EmployeeTO findEmployeeById(Long employeeId) {
        return EmployeeMapper.toEmployeeTO(employeeDao.findEmployeeById(employeeId));
    }

    @Override
    public EmployeeTO saveEmployee(EmployeeTO employeeTO) {
        if (employeeTO == null) return null;
        EmployeeEntity employeeEntity = employeeDao.save(EmployeeMapper.toEmployeeEntity(employeeTO));
        return EmployeeMapper.toEmployeeTO(employeeEntity);
    }

    @Override
    public boolean deleteEmployee(EmployeeTO employeeTO) {
        if (employeeTO == null) return false;
        employeeDao.deleteEmployee(EmployeeMapper.toEmployeeEntity(employeeTO));
        return true;
    }

    @Override
    public boolean deleteEmployeeById(Long employeeId) {
        employeeDao.deleteEmployee(employeeId);
        return true;
    }

    @Override
    public EmployeeTO editEmployee(EmployeeTO employeeTO) {
        if (employeeTO == null) return null;
        EmployeeEntity employeeEntity = employeeDao.update(EmployeeMapper.toEmployeeEntity(employeeTO));
        return EmployeeMapper.toEmployeeTO(employeeEntity);
    }

    @Override
    public List<EmployeeTO> findEmployeesBySearchCriteria(EmployeeSearchCriteriaTO employeeSearchCriteriaTO, String queryAsString) {
        StringBuilder query = new StringBuilder();
        query.append("select e from EmployeeEntity e where ");
        boolean canAddAndFlag = false;
        Long carId = employeeSearchCriteriaTO.getCarId();
        if (carId != null) {
            canAddAndFlag = true;
            query.append(":car member of e.carEntitySet");
        }

        Long agencyId = employeeSearchCriteriaTO.getAgencyId();
        if (agencyId != null) {
            if (canAddAndFlag) {
                query.append(" and ");
            }
            canAddAndFlag = true;
            query.append("e.agencyEntity=:agency");
        }

        Long positionId = employeeSearchCriteriaTO.getEmployeePositionId();
        if (positionId != null) {
            if (canAddAndFlag) {
                query.append(" and ");
            }
            canAddAndFlag = true;
            query.append("e.employeePositionEntity=:position ");
        }

        if (canAddAndFlag) {
            return EmployeeMapper.map2TOs(employeeDao.findEmployeesBySearchCriteria(employeeSearchCriteriaTO, query.toString()));
        } else {
            return new ArrayList<>();
        }
    }
}
