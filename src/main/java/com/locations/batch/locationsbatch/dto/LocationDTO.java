package com.locations.batch.locationsbatch.dto;

import org.apache.commons.lang3.math.NumberUtils;

public class LocationDTO {

	private String id;
	private String name;
	private Double evaluation;
	private Double goodEvaluation;
	private Double badEvaluation;
	private String phoneNumber;
	private String state;
	private String city;
	private String district;
	private String street;
	private Long streetNumber;
	private Double latitude;
	private Double longitude;
	private String category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Double evaluation) {
		this.evaluation = evaluation;
	}

	public Double getGoodEvaluation() {
		return goodEvaluation;
	}

	public void setGoodEvaluation(Double goodEvaluation) {
		this.goodEvaluation = goodEvaluation;
	}

	public Double getBadEvaluation() {
		return badEvaluation;
	}

	public void setBadEvaluation(Double badEvaluation) {
		this.badEvaluation = badEvaluation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		if (NumberUtils.isCreatable(streetNumber.trim())) {
			this.streetNumber = Long.parseLong(streetNumber.replaceAll("[^0-9]+", ""));
		}
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
