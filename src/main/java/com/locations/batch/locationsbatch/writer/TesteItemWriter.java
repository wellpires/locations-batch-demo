package com.locations.batch.locationsbatch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.locations.batch.locationsbatch.model.Location;

@Component
public class TesteItemWriter implements ItemWriter<Location> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void write(List<? extends Location> items) throws Exception {
		logger.info("itemWriter {}", items);
	}

}
