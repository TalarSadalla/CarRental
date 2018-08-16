package com.capgemini.mappers;

import com.capgemini.domain.AddressEntity;
import com.capgemini.types.AddressTO;
import com.capgemini.types.AddressTO.AddressTOBuilder;

import java.util.Set;
import java.util.stream.Collectors;

;

public class AddressMapper {

    public static AddressTO toAddressTO(AddressEntity addressEntity) {
        if (addressEntity == null)
            return null;

        return new AddressTOBuilder().withId(addressEntity.getId()).withCity(addressEntity.getCity()).withStreet(addressEntity.getCity()).withPostCode(addressEntity.getPostCode())
                .build();

    }

    public static AddressEntity toAddressEntity(AddressTO addressTO) {
        if (addressTO == null)
            return null;
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(addressTO.getCity());
        addressEntity.setStreet(addressTO.getStreet());
        addressEntity.setPostCode(addressTO.getPostCode());
        return addressEntity;
    }

    public static Set<AddressTO> map2TOs(Set<AddressEntity> addressEntities) {
        return addressEntities.stream().map(AddressMapper::toAddressTO).collect(Collectors.toSet());
    }

    public static Set<AddressEntity> map2Entities(Set<AddressTO> addressTOs) {
        return addressTOs.stream().map(AddressMapper::toAddressEntity).collect(Collectors.toSet());
    }

}
