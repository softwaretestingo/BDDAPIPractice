package com.softwaretestingo.complexJSONwitharrayDeserialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NestedGeoLocationPOJOClass 
{
	private double lat;
	@JsonProperty("long")
    private double longitude;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}