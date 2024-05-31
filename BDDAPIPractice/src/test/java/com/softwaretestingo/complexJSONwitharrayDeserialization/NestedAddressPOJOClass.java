package com.softwaretestingo.complexJSONwitharrayDeserialization;

public class NestedAddressPOJOClass 
{
	private String city;
	private String street;
	private String number;
	private String zipcode;
	private NestedGeoLocationPOJOClass geolocation;
	
	//Getter and Setters
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public NestedGeoLocationPOJOClass getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(NestedGeoLocationPOJOClass geolocation) {
		this.geolocation = geolocation;
	}
}