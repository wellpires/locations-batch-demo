package com.locations.batch.locationsbatch.dto;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationMapDTO {

	private List<AddressDTO> results;

	public List<AddressDTO> getResults() {
		return results;
	}

	public void setResults(List<AddressDTO> results) {
		this.results = results;
	}

	public AddressDTO getFirstResult() {
		AddressDTO firstAddressDTO = null;
		if (!CollectionUtils.isEmpty(results)) {
			firstAddressDTO = results.stream().findFirst().orElseGet(AddressDTO::new);
		}
		return firstAddressDTO;

	}

}
