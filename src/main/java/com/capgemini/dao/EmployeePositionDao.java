package com.capgemini.dao;

import com.capgemini.domain.EmployeePositionEntity;
import com.capgemini.types.EmployeePositionTO;

public interface EmployeePositionDao extends Dao<EmployeePositionEntity, Long> {

    void savePosition(EmployeePositionEntity employeePositionEntity);

    EmployeePositionEntity getPosition(Long positionId);


}
