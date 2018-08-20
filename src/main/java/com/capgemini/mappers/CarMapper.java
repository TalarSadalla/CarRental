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

        AgencyTO agencyTO = AgencyMapper.toAgencyTO(carEntity.getAgencyEntity());
        return new CarTOBuilder().withId(carEntity.getId()).withBrand(carEntity.getBrand())
                .withCarType(carEntity.getCarType()).withColor(carEntity.getColor())
                .withEngineCapacity(carEntity.getEngineCapacity()).withHorsepower(carEntity.getHorsepower())
                .withMilleage(carEntity.getMilleage()).withProductionYear(carEntity.getProductionYear())
                .withAgencyTO(agencyTO)
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
        AgencyEntity agencyEntity = AgencyMapper.toAgencyEntity(carTO.getAgencyTO());
        carEntity.setAgencyEntity(agencyEntity);
        return carEntity;
    }

    public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
        return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
    }

    public static List<CarEntity> map2Entities(List<CarTO> carTOs) {
        return carTOs.stream().map(CarMapper::toCarEntity).collect(Collectors.toList());
    }

}
