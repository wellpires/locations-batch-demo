package com.locations.batch.locationsbatch.dto;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.locations.batch.locationsbatch.enums.AddressType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

	@JsonProperty("address_components")
	private List<AddressComponentDTO> addressComponentsDTO;

	public List<AddressComponentDTO> getAddressComponentsDTO() {
		return addressComponentsDTO;
	}

	public void setAddressComponentsDTO(List<AddressComponentDTO> addressComponentsDTO) {
		this.addressComponentsDTO = addressComponentsDTO;
	}

	public AddressComponentDTO findAddressComponentByType(AddressType... addressTypes) {

		if (CollectionUtils.isEmpty(addressComponentsDTO)) {
			return new AddressComponentDTO();
		}

		return addressComponentsDTO.stream().filter(item -> item.hasTypes(addressTypes)).findFirst()
				.orElseGet(() -> null);
	}

}
