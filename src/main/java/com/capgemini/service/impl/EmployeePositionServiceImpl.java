package com.capgemini.service.impl;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.EmployeePositionDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.EmployeePositionEntity;
import com.capgemini.mappers.AgencyMapper;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.mappers.EmployeePositionMapper;
import com.capgemini.service.AgencyService;
import com.capgemini.service.EmployeePositionService;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeePositionTO;
import com.capgemini.types.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeePositionServiceImpl implements EmployeePositionService {

    @Autowired
    private EmployeePositionDao employeePositionDao;

    @Override
    public void savePosition(EmployeePositionTO employeePositionTO) {
        employeePositionDao.savePosition(EmployeePositionMapper.toEmployeePositionEntity(employeePositionTO));
    }

    @Override
    public EmployeePositionTO getPosition(Long positionId) {
        return EmployeePositionMapper.toEmployeePositionTO(employeePositionDao.getPosition(positionId));
    }
}
