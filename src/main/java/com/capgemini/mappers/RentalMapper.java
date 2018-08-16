package com.capgemini.mappers;

import com.capgemini.domain.*;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.CarTO;
import com.capgemini.types.ClientTO;
import com.capgemini.types.RentalTO;
import com.capgemini.types.RentalTO.RentalTOBuilder;

import java.util.Set;
import java.util.stream.Collectors;

;

public class RentalMapper {

    public static RentalTO toRentalTO(RentalEntity rentalEntity) {
        if (rentalEntity == null)
            return null;
        ClientTO clientTO = ClientMapper.toClientTO(rentalEntity.getClientEntity());
        CarTO carTO = CarMapper.toCarTO(rentalEntity.getCarEntity());
        AgencyTO startAgencyTO = AgencyMapper.toAgencyTO(rentalEntity.getStartAgencyEntity());
        AgencyTO endAgencyTO=AgencyMapper.toAgencyTO(rentalEntity.getEndAgencyEntity());
        return new RentalTOBuilder().withBeginDate(rentalEntity.getBeginDate())
                .withEndDate(rentalEntity.getEndDate()).withCarTO(carTO).withDClientTO(clientTO)
                .withStartAgencyTO(startAgencyTO)
                .withEndAgencyTO(endAgencyTO)
                .build();

    }

    public static RentalEntity toRentalEntity(RentalTO rentalTO) {
        if (rentalTO == null)
            return null;
        RentalEntity rentalEntity = new RentalEntity();
        ClientEntity clientEntity = ClientMapper.toClientEntity(rentalTO.getClientTO());
        CarEntity carEntity = CarMapper.toCarEntity(rentalTO.getCarTO());
        AgencyEntity startAgencyEntity = AgencyMapper.toAgencyEntity(rentalTO.getStartAgencyTO());
        AgencyEntity endAgencyEntity=AgencyMapper.toAgencyEntity(rentalTO.getEndAgencyTO());
        rentalEntity.setBeginDate(rentalTO.getBeginDate());
        rentalEntity.setEndDate(rentalTO.getEndDate());
        rentalEntity.setCarEntity(carEntity);
        rentalEntity.setClientEntity(clientEntity);
        rentalEntity.setStartAgencyEntity(startAgencyEntity);
        rentalEntity.setEndAgencyEntity(endAgencyEntity);
        return rentalEntity;
    }

    public static Set<RentalTO> map2TOs(Set<RentalEntity> rentalEntities) {
        return rentalEntities.stream().map(RentalMapper::toRentalTO).collect(Collectors.toSet());
    }

    public static Set<RentalEntity> map2Entities(Set<RentalTO> rentalTOs) {
        return rentalTOs.stream().map(RentalMapper::toRentalEntity).collect(Collectors.toSet());
    }

}
