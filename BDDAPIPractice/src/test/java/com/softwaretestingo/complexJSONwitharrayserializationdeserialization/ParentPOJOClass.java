package com.softwaretestingo.complexJSONwitharrayserializationdeserialization;

import java.util.List;

public class ParentPOJOClass 
{
	/**
	 * {
	 * 		"status": "SUCCESS",
	 * 		"message": "Here you go! You've received 2\n        users.",
	 * 		"users": [
	 * 			{
	 * 				"id": 1,
	 * 				"email": "michael@simpson.com",
	 * 		        "username": "michaelsimpson",
	 * 	            "password": "@K(5UejhL&",
	 * 				"name": {
	 * 					"firstname": "Michael",
	 * 					"lastname": "Simpson"
	 * 					},
	 * 				"address": {
	 * 					"city": "Joelton",
	 * 					"street": "Angela Spring",
	 * 			        "number": "868",
	 * 					"zipcode": "75070",
	 * 		            "geolocation": {
	 * 						"lat": 19.7091875,
	 *                      "long": -14.782061
	 *                      }
	 *                  },
	 *              "phone": "562.548.9768x73853"
	 * 			},
	 * 			{
	 * 				"id": 2,
	 * 				"email": "april@boyd.com",
	 * 				"username": "aprilboyd",
	 * 				"password": "k8WR_hX0+m",	
	 * 				"name": {
	 * 					"firstname": "April",
	 * 					"lastname": "Boyd"
	 * 					},
	 * 				"address": {
	 * 					"city": "Ericchester",
	 * 					"street": "Johnson Mountains",
	 * 					"number": "5522",
	 * 					"zipcode": "87835",
	 * 					"geolocation": {	
	 * 							"lat": 39.2711365,
	 * 							"long": -56.601702
	 * 							}
	 * 			},
	 * 		        "phone": "9329508218"
	 * 		}
	 * 	]
	 * }
	 */
	
	private String status;
	private String message;
	private List<NestedUserPOJOClass> users;
	
	//Getter and Setters
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<NestedUserPOJOClass> getUsers() {
		return users;
	}
	public void setUsers(List<NestedUserPOJOClass> users) {
		this.users = users;
	}
	
	
}