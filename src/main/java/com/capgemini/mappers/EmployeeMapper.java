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
		AgencyTO agencyTO = AgencyMapper.toAgencyTO(employeeEntity.getAgencyEntity());
		EmployeePositionTO employeePositionTO = EmployeePositionMapper.toEmployeePositionTO(employeeEntity.getEmployeePositionEntity());
		Set<CarTO> carTOs = CarMapper.map2TOs((List<CarEntity>) employeeEntity.getCarEntitySet());
		return new EmployeeTOBuilder().withId(employeeEntity.getId()).withName(employeeEntity.getName())
				.withSurname(employeeEntity.getSurname()).withDateOfBirth(employeeEntity.getDateOfBirth())
				.withAddressTO(addressTO).withAgencyTO(agencyTO).withEmployeePositionTO(employeePositionTO)
				.withCarSet(carTOs)
				.build();
	}

	public static EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {
		if (employeeTO == null)
			return null;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		AddressEntity addressEntity = AddressMapper.toAddressEntity(employeeTO.getAddressTO());
		AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(employeeTO.getAgencyTO());
		EmployeePositionEntity employeePositionEntity = EmployeePositionMapper.toEmployeePositionEntity(employeeTO.getEmployeePositionTO());
		Set<CarEntity> carEntities =  CarMapper.map2Entities((List<CarTO>) employeeTO.getCarTOSet());
		employeeEntity.setName(employeeTO.getName());
		employeeEntity.setSurname(employeeTO.getSurname());
		employeeEntity.setDateOfBirth(employeeTO.getDateOfBirth());
		employeeEntity.setAddressEntity(addressEntity);
		employeeEntity.setAgencyEntity(agencyEntity);
		employeeEntity.setEmployeePositionEntity(employeePositionEntity);
		employeeEntity.setCarEntitySet(carEntities);
		return employeeEntity;
	}

	public static Set<EmployeeTO> map2TOs(Set<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toSet());
	}

	public static Set<EmployeeEntity> map2Entities(Set<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toSet());
	}

}
