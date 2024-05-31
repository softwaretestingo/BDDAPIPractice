package com.softwaretestingo.simpleJSONSerialization;
public class ParentAddComputerDetailsPOJOClass 
{
	/**
	 * {
	 * 	  "name": "Apple MacBook Pro 16",
	 *    "data": {
	 *    		     "year": 2019,
	 *    			 "price": 1849.99,
	 *               "CPU model": "Intel Core i9",
	 *               "Hard disk size": "1 TB"
	 *            }
	 * }
	 */
	
	private String name;
	private Data data;
	
	//Variables To Match Response
	private String id;
	private String createdAt;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	// Inner class for Data
	public static class Data 
	{
	
		/**
		 * "data": {
		 *      "year": 2019,
		 *      "price": 1849.99,
		 *      "CPU model": "Intel Core i9",
		 *      "Hard disk size": "1 TB"
		 *      }
		 */
		
		private int year;
		private double price;
		private String CPUmodel;
		private String Harddisksize;
		
		//Getters & Setters
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getCPUmodel() {
			return CPUmodel;
		}
		public void setCPUmodel(String cPUmodel) {
			CPUmodel = cPUmodel;
		}
		public String getHarddisksize() {
			return Harddisksize;
		}
		public void setHarddisksize(String harddisksize) {
			Harddisksize = harddisksize;
		}
	}
}