package com.locations.batch.locationsbatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.locations.batch.locationsbatch.model.Location;

@Component
public class UncompletedItemProcessor implements ItemProcessor<Location, Location> {

	@Override
	public Location process(Location item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
