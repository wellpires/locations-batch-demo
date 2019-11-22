package com.locations.batch.locationsbatch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.locations.batch.locationsbatch.model.Location;
import com.locations.batch.locationsbatch.repository.LocationRepository;

@Component
public class LocationItemWriter implements ItemWriter<Location> {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void write(List<? extends Location> locations) throws Exception {
		
		locationRepository.saveAll(locations);
	}

}
