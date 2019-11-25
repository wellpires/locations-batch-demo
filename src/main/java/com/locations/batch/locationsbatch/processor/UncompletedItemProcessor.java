package com.locations.batch.locationsbatch.processor;

import java.net.URI;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

		client.getForEntity(uriBuilt, String.class);

		return null;
	}

}
