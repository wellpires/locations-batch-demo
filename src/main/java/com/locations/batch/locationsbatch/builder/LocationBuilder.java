package com.locations.batch.locationsbatch.builder;

import java.util.Optional;

import com.locations.batch.locationsbatch.enums.QualityStatus;
import com.locations.batch.locationsbatch.model.Location;

public class LocationBuilder {

	private String id;
	private String name;
	private Double evaluation;
	private Long phoneNumber;
	private String state;
	private String city;
	private String district;
	private String street;
	private QualityStatus status;
	private Double latitude;
	private Double longitude;

	public LocationBuilder id(String id) {
		this.id = id;
		return this;
	}

	public LocationBuilder name(String name) {
		this.name = name;
		return this;
	}

	public LocationBuilder evaluation(Double evaluation) {
		this.evaluation = evaluation;
		this.status = QualityStatus.defineQuality(evaluation);
		return this;
	}

	public LocationBuilder phoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public LocationBuilder state(String state) {
		this.state = state;
		return this;
	}

	public LocationBuilder city(String city) {
		this.city = city;
		return this;
	}

	public LocationBuilder district(String district) {
		this.district = district;
		return this;
	}

	public LocationBuilder street(String street) {
		this.street = street;
		return this;
	}

	public LocationBuilder status(QualityStatus status) {
		this.status = status;
		return this;
	}

	public LocationBuilder latitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}

	public LocationBuilder longitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	public Location build() {
		Location location = new Location();
		location.setId(id);
		location.setName(name);
		location.setEvaluation(evaluation);
		location.setPhoneNumber(phoneNumber);
		location.setState(state);
		location.setCity(city);
		location.setDistrict(district);
		location.setStreet(street);
		location.setStatus(status);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		return location;
	}

	public Optional<Location> buildOptional() {
		return Optional.ofNullable(build());
	}

}
