package com.capgemini.mappers;

import com.capgemini.domain.AddressEntity;
import com.capgemini.domain.ClientEntity;
import com.capgemini.types.AddressTO;
import com.capgemini.types.ClientTO.ClientTOBuilder;
import com.capgemini.types.ClientTO;

import java.util.Set;
import java.util.stream.Collectors;

;

public class ClientMapper {

	public static ClientTO toClientTO(ClientEntity clientEntity) {
		if (clientEntity == null)
			return null;

		Set<ClientTO> clientTOs = map2TOs(clientEntity.getClientEntitySet());
		AddressTO addressTOs = AddressMapper.toAddressTO(clientEntity.getAddressEntity());
		return new ClientTOBuilder().withId(clientEntity.getId())
				.withName(clientEntity.getName()).withSurname(clientEntity.getSurname())
				.withEmail(clientEntity.getEmail()).withPhoneNumber(clientEntity.getPhoneNumber())
				.withCreditCardNumber(clientEntity.getCreditCardNumber()).withDateOfBirth(clientEntity.getDateOfBirth())
				.withClientTO(clientTOs).withAddressTO(addressTOs)
				.build();

	}

	public static ClientEntity toClientEntity(ClientTO clientTO) {
		if (clientTO == null)
			return null;
		Set<ClientEntity> clientEntities = map2Entities(clientTO.getClientTOSet());
		AddressEntity addressTOs = AddressMapper.toAddressEntity(clientTO.getAddressTO());
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setName(clientTO.getName());
		clientEntity.setSurname(clientTO.getSurname());
		clientEntity.setEmail(clientTO.getEmail());
		clientEntity.setPhoneNumber(clientTO.getPhoneNumber());
		clientEntity.setDateOfBirth(clientTO.getDateOfBirth());
		clientEntity.setCreditCardNumber(clientTO.getCreditCardNumber());
		clientEntity.setClientEntitySet(clientEntities);
		clientEntity.setAddressEntity(addressTOs);
		return clientEntity;
	}

	public static Set<ClientTO> map2TOs(Set<ClientEntity> clientEntities) {
		return clientEntities.stream().map(ClientMapper::toClientTO).collect(Collectors.toSet());
	}

	public static Set<ClientEntity> map2Entities(Set<ClientTO> clientTOs) {
		return clientTOs.stream().map(ClientMapper::toClientEntity).collect(Collectors.toSet());
	}

}
