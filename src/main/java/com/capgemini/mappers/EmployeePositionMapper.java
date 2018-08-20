package com.capgemini.mappers;

import com.capgemini.domain.EmployeePositionEntity;
import com.capgemini.types.EmployeePositionTO.EmployeePositionTOBuilder;
import com.capgemini.types.EmployeePositionTO;

import java.util.Set;
import java.util.stream.Collectors;

;

public class EmployeePositionMapper {

	public static EmployeePositionTO toEmployeePositionTO(EmployeePositionEntity employeePositionEntity) {
		if (employeePositionEntity == null)
			return null;

		return new EmployeePositionTOBuilder().withJobTitle(employeePositionEntity.getJobTitle())
				.build();

	}

	public static EmployeePositionEntity toEmployeePositionEntity(EmployeePositionTO employeePositionTO) {
		if (employeePositionTO == null)
			return null;
		EmployeePositionEntity employeePositionEntity = new EmployeePositionEntity();
		employeePositionEntity.setJobTitle(employeePositionTO.getJobTitle());
		return employeePositionEntity;
	}

	public static Set<EmployeePositionTO> map2TOs(Set<EmployeePositionEntity> employeePositionEntities) {
		return employeePositionEntities.stream().map(EmployeePositionMapper::toEmployeePositionTO).collect(Collectors.toSet());
	}

	public static Set<EmployeePositionEntity> map2Entities(Set<EmployeePositionTO> employeePositionTOs) {
		return employeePositionTOs.stream().map(EmployeePositionMapper::toEmployeePositionEntity).collect(Collectors.toSet());
	}

}
