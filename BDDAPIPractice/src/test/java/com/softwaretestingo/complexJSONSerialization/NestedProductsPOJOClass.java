package com.softwaretestingo.complexJSONSerialization;
public class NestedProductsPOJOClass 
{
	/**
	 *   "products": [
	 *   {
	 *   	"productId": 5,
	 *      "quantity": 1
	 *   },
	 *   {
	 *   	"productId": 1,
	 *      "quantity": 5
	 *   }
	 *   ]
	 */
	private int productId;
	private int quantity;
	
	//Getter & Setters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
