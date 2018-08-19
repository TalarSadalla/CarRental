package com.capgemini.service.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.EmployeeService;
import com.capgemini.types.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;

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
    public EmployeeTO findEmployeeById(EmployeeTO employeeTO) {
        EmployeeEntity employeeEntity=EmployeeMapper.toEmployeeEntity(employeeTO);
        return EmployeeMapper.toEmployeeTO(employeeDao.findEmployeeById(employeeEntity.getId()));
    }

    @Override
    public EmployeeTO saveEmployee(EmployeeTO employeeTO) {
        if (employeeTO == null) return null;
        EmployeeEntity employeeEntity= employeeDao.save(EmployeeMapper.toEmployeeEntity(employeeTO));
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
    deleteEmployeeById(employeeId);
    return true;
    }

    @Override
    public EmployeeTO editEmployee(EmployeeTO employeeTO) {
        if (employeeTO == null) return null;
        EmployeeEntity employeeEntity = employeeDao.update(EmployeeMapper.toEmployeeEntity(employeeTO));
        return EmployeeMapper.toEmployeeTO(employeeEntity);
    }
}
