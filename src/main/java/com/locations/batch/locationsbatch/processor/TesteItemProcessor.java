package com.locations.batch.locationsbatch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.locations.batch.locationsbatch.model.Location;

@Component
public class TesteItemProcessor implements ItemProcessor<Location, Location> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Location process(Location item) throws Exception {
		logger.info("ItemProcessor {}", item.toString());
		return null;
	}

}
