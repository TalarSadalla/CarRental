package com.capgemini.mappers;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.*;
import com.capgemini.types.CarTO.CarTOBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

;

public class CarMapper {

    public static CarTO toCarTO(CarEntity carEntity) {
        if (carEntity == null)
            return null;

        Set<CarTO> carTOs = map2TOs(carEntity.getCarEntitySet());
        AgencyTO agencyTO = AgencyMapper.toAgencyTO(carEntity.getAgencyEntity());
        Set<EmployeeTO> employeeTOs = (Set<EmployeeTO>) EmployeeMapper.map2TOs((List<EmployeeEntity>) carEntity.getEmployeeEntitySet());
        return new CarTOBuilder().withId(carEntity.getId()).withBrand(carEntity.getBrand())
                .withCarType(carEntity.getCarType()).withColor(carEntity.getColor())
                .withEngineCapacity(carEntity.getEngineCapacity()).withHorsepower(carEntity.getHorsepower())
                .withMilleage(carEntity.getMilleage()).withProductionYear(carEntity.getProductionYear())
                .withAgencyTO(agencyTO)
                .withCarTO(carTOs)
                .withEmployeeTO(employeeTOs)
                .build();

    }

    public static CarEntity toCarEntity(CarTO carTO) {
        if (carTO == null)
            return null;
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(carTO.getBrand());
        carEntity.setCarType(carTO.getCarType());
        carEntity.setColor(carTO.getColor());
        carEntity.setEngineCapacity(carTO.getEngineCapacity());
        carEntity.setHorsepower(carTO.getHorsepower());
        carEntity.setMilleage(carTO.getMilleage());
        carEntity.setProductionYear(carTO.getProductionYear());
        Set<CarEntity> carEntities = map2Entities(carTO.getCarTOSet());
        AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(carTO.getAgencyTO());
        Set<EmployeeEntity> employeeEntities= (Set<EmployeeEntity>) EmployeeMapper.map2Entities((List<EmployeeTO>) carTO.getEmployeeTOSet());
        carEntity.setAgencyEntity(agencyEntity);
        carEntity.setCarEntitySet(carEntities);
        carEntity.setEmployeeEntitySet(employeeEntities);
        return carEntity;
    }

    public static Set<CarTO> map2TOs(Set<CarEntity> carEntities) {
        return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toSet());
    }

    public static Set<CarEntity> map2Entities(Set<CarTO> carTOs) {
        return carTOs.stream().map(CarMapper::toCarEntity).collect(Collectors.toSet());
    }

}
