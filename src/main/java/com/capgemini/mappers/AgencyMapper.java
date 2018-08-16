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
        Set<AgencyTO> startAgencyTOSet = AgencyMapper.map2TOs(agencyEntity.getStartAgencyEntitySet());
        Set<AgencyTO> endAgencyTOSet = AgencyMapper.map2TOs(agencyEntity.getEndAgencyEntitySet());
        return new AgencyTOBuilder().withId(agencyEntity.getId()).withAddressId(addressTOs).withStartAgencyTO(startAgencyTOSet).withEndAgencyTO(endAgencyTOSet).withContact(agencyEntity.getContact())
                .build();
    }

    public static AgencyEntity toAgencyEntity(AgencyTO agencyTO) {
        if (agencyTO == null)
            return null;
        AgencyEntity agencyEntity=new AgencyEntity();
        AddressEntity addressEntity = AddressMapper.toAddressEntity(agencyTO.getAddressTO());
        agencyEntity.setAddressEntity(addressEntity);
        agencyEntity.setContact(agencyTO.getContact());
        Set<AgencyEntity> startAgencyEntitySet = AgencyMapper.map2Entities(agencyTO.getStartAgencyTOSet());
        Set<AgencyEntity> endAgencyEntitySet = AgencyMapper.map2Entities(agencyTO.getEndAgencyTOSet());
        agencyEntity.setStartAgencyEntitySet(startAgencyEntitySet);
        agencyEntity.setEndAgencyEntitySet(endAgencyEntitySet);
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
