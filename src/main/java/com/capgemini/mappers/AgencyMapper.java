package com.capgemini.mappers;

import com.capgemini.domain.AddressEntity;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.types.AddressTO;
import com.capgemini.types.AgencyTO;
import com.capgemini.types.AgencyTO.AgencyTOBuilder;

import java.util.Set;
import java.util.stream.Collectors;

;

public class AgencyMapper {

    public static AgencyTO toAgencyTO(AgencyEntity agencyEntity) {
        if (agencyEntity == null)
            return null;
        AddressTO addressTOs = AddressMapper.toAddressTO(agencyEntity.getAddressEntity());
        return new AgencyTOBuilder().withId(agencyEntity.getId()).withAddressId(addressTOs).withContact(agencyEntity.getContact())
                .build();
    }

    public static AgencyEntity toAgencyEntity(AgencyTO agencyTO) {
        if (agencyTO == null)
            return null;
        AgencyEntity agencyEntity=new AgencyEntity();
        AddressEntity addressEntity = AddressMapper.toAddressEntity(agencyTO.getAddressTO());
        agencyEntity.setAddressEntity(addressEntity);
        agencyEntity.setContact(agencyTO.getContact());
        agencyEntity.setContact(agencyTO.getContact());
        return agencyEntity;
    }

    public static Set<AgencyTO> map2TOs(Set<AgencyEntity> agencyEntities) {
        return agencyEntities.stream().map(AgencyMapper::toAgencyTO).collect(Collectors.toSet());
    }

    public static Set<AgencyEntity> map2Entities(Set<AgencyTO> agencyTOs) {
        return agencyTOs.stream().map(AgencyMapper::toAgencyEntity).collect(Collectors.toSet());
    }

}
