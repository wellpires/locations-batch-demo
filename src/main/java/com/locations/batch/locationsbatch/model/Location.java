package com.locations.batch.locationsbatch.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.locations.batch.locationsbatch.enums.QualityStatus;

@Entity
public class Location {

	@Id
	private String id;
	private String name;
	private Double evaluation;
	private Long phoneNumber;
	private String state;
	private String city;
	private String district;
	private String street;
	private BigDecimal latitude;
	private BigDecimal longitude;
	@Enumerated(EnumType.STRING)
	private QualityStatus status;

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
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

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public QualityStatus getStatus() {
		return status;
	}

	public void setStatus(QualityStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Location [id=").append(id).append(", name=").append(name)
				.append(", evaluation=").append(evaluation).append(", phoneNumber=").append(phoneNumber)
				.append(", state=").append(state).append(", city=").append(city).append(", district=").append(district)
				.append(", street=").append(street).append(", latitude=").append(latitude).append(", longitude=")
				.append(longitude).append(", status=").append(status).append("]").toString();
	}

}
