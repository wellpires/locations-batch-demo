package com.locations.batch.locationsbatch.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.locations.batch.locationsbatch.enums.AddressType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressComponentDTO {

	@JsonProperty("long_name")
	private String longName;

	private List<AddressType> types;

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public List<AddressType> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types.stream().map(AddressType::resolve).collect(Collectors.toList());
	}

	public boolean hasTypes(AddressType... addressTypesArray) {
		List<AddressType> addressTypes = Stream.of(addressTypesArray).collect(Collectors.toList());
		return types.stream().allMatch(item -> addressTypes.stream().anyMatch(item::equals));
	}

}
