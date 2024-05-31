package com.softwaretestingo.complexJSONSerialization;
import java.util.List;
public class ParentAddNewCartPOJOClass 
{
	/**
	 * {
	 *   "userId": 5,
	 *   "date": "2020-02-03",
	 *   "products": [
	 *   {
	 *   	"productId": 5,
	 *      "quantity": 1
	 *   },
	 *   {
	 *      "productId": 1,
	 *      "quantity": 5
	 *   }
	 *   ]
	 * }
	 */
	
	private int userId;
	private String date;
	private List<NestedProductsPOJOClass> products;
	
	//Getters & Setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<NestedProductsPOJOClass> getProducts() {
		return products;
	}
	public void setProducts(List<NestedProductsPOJOClass> products) {
		this.products = products;
	}
}