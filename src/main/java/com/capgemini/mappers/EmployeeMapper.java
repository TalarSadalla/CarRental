package com.capgemini.mappers;

import com.capgemini.domain.*;
import com.capgemini.types.*;
import com.capgemini.types.EmployeeTO.EmployeeTOBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

;

public class EmployeeMapper {

	public static EmployeeTO toEmployeeTO(EmployeeEntity employeeEntity) {
		if (employeeEntity == null)
			return null;
		AddressTO addressTO = AddressMapper.toAddressTO(employeeEntity.getAddressEntity());
		EmployeePositionTO employeePositionTO = EmployeePositionMapper.toEmployeePositionTO(employeeEntity.getEmployeePositionEntity());
		return new EmployeeTOBuilder().withId(employeeEntity.getId()).withName(employeeEntity.getName())
				.withSurname(employeeEntity.getSurname()).withDateOfBirth(employeeEntity.getDateOfBirth())
				.withAddressTO(addressTO).withAgencyTO(AgencyMapper.toAgencyTO(employeeEntity.getAgencyEntity())).withEmployeePositionTO(employeePositionTO)
				.build();
	}

	public static EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {
		if (employeeTO == null)
			return null;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		AddressEntity addressEntity = AddressMapper.toAddressEntity(employeeTO.getAddressTO());
		EmployeePositionEntity employeePositionEntity = EmployeePositionMapper.toEmployeePositionEntity(employeeTO.getEmployeePositionTO());
		employeeEntity.setId(employeeTO.getId());
		employeeEntity.setName(employeeTO.getName());
		employeeEntity.setSurname(employeeTO.getSurname());
		employeeEntity.setDateOfBirth(employeeTO.getDateOfBirth());
		employeeEntity.setAddressEntity(addressEntity);
		employeeEntity.setEmployeePositionEntity(employeePositionEntity);
		return employeeEntity;
	}

	public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
	}

	public static List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toList());
	}

}
