package com.locations.batch.locationsbatch.processor;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.locations.batch.locationsbatch.builder.LocationBuilder;
import com.locations.batch.locationsbatch.dto.LocationDTO;
import com.locations.batch.locationsbatch.model.Location;

@Component
public class LocationItemProcessor implements ItemProcessor<LocationDTO, Location> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Location process(LocationDTO locationDTO) throws Exception {

		logger.info("Processando utilizando a abstração ItemProcessor");

		String phoneNumber = locationDTO.getPhoneNumber();
		Long newPhoneNumber = 0l;
		if (NumberUtils.isCreatable(phoneNumber)) {
			newPhoneNumber = Long.parseLong(phoneNumber);
		}

		String nameUpperCase = locationDTO.getName().toUpperCase();
		return new LocationBuilder().id(locationDTO.getId()).name(nameUpperCase).evaluation(locationDTO.getEvaluation())
				.phoneNumber(newPhoneNumber).state(locationDTO.getState()).city(locationDTO.getCity())
				.district(locationDTO.getDistrict()).street(locationDTO.getStreet()).latitude(locationDTO.getLatitude())
				.longitude(locationDTO.getLongitude()).build();
	}

}
