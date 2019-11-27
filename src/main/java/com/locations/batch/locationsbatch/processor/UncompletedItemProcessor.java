package com.locations.batch.locationsbatch.processor;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.locations.batch.locationsbatch.builder.LocationBuilder;
import com.locations.batch.locationsbatch.dto.AddressComponentDTO;
import com.locations.batch.locationsbatch.dto.LocationMapDTO;
import com.locations.batch.locationsbatch.enums.AddressType;
import com.locations.batch.locationsbatch.model.Location;

@Component
public class UncompletedItemProcessor implements ItemProcessor<Location, Location> {

	@Autowired
	private RestTemplate client;

	@Value("${api.maps.url}")
	private String httpUrl;

	@Value("${api.maps.api-key}")
	private String apiKey;

	@Override
	public Location process(Location item) throws Exception {

		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<>();
		queryParameters.add("latlng", item.getLatitude().toString().concat(",").concat(item.getLongitude().toString()));
		queryParameters.add("key", apiKey);

		URI uriBuilt = UriComponentsBuilder.fromHttpUrl(httpUrl).queryParams(queryParameters).build().toUri();

		LocationMapDTO locationMapDTO = client.getForEntity(uriBuilt, LocationMapDTO.class).getBody();

		String newCity = item.getCity();
		if (StringUtils.isBlank(newCity)) {
			newCity = findLongName(locationMapDTO, AddressType.ADMINISTRATIVE_AREA_LEVEL_1, AddressType.POLITICAL);
		}

		String newDistrict = item.getDistrict();
		if (StringUtils.isBlank(newDistrict)) {
			newDistrict = findLongName(locationMapDTO, AddressType.ADMINISTRATIVE_AREA_LEVEL_2, AddressType.POLITICAL);
		}

		String newStreet = item.getStreet();
		if (StringUtils.isBlank(newStreet)) {
			newStreet = findLongName(locationMapDTO, AddressType.ROUTE);
		}

		return new LocationBuilder().city(newCity).district(newDistrict).street(newStreet).modify(item);
	}

	private String findLongName(LocationMapDTO locationMapDTO, AddressType... addressTypes) {
		String longName = locationMapDTO.getResults().stream()
				.map(addressDTO -> addressDTO.findAddressComponentByType(addressTypes)).filter(Objects::nonNull)
				.findFirst().orElseGet(AddressComponentDTO::new).getLongName();
		return Optional.ofNullable(longName).orElseGet(() -> "NOT_FOUND");
	}

}
