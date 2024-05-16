package com.softwaretestingo.complexJSONwitharrayserializationdeserialization;
public class NestedUserPOJOClass 
{
	private int id;
	private String email;
	private String username;
	private String password;
	private NestedNamePOJOClass name;
	private NestedAddressPOJOClass address;
	private String phone;
	
	//Getter &  Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public NestedNamePOJOClass getName() {
		return name;
	}
	public void setName(NestedNamePOJOClass name) {
		this.name = name;
	}
	public NestedAddressPOJOClass getAddress() {
		return address;
	}
	public void setAddress(NestedAddressPOJOClass address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}