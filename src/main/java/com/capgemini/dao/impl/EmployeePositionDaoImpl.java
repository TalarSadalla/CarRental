package com.capgemini.dao.impl;

import com.capgemini.dao.EmployeePositionDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.EmployeePositionEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeePositionDaoImpl extends AbstractDao<EmployeePositionEntity, Long> implements EmployeePositionDao {

    @Override
    public void savePosition(EmployeePositionEntity employeePositionEntity) {
        save(employeePositionEntity);
    }

    @Override
    public EmployeePositionEntity getPosition(Long positionId){
        return findOne(positionId);
    }

}
