package com.softwaretestingo.staticpayloadmocking;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class DealWithComplexJSON 
{
	// As We Don't have any API Who Can Give Us Response
	// So We Need to Start From Below Statement
	
	JsonPath js=new JsonPath(Payload.payloadforCourse());
	
	// Print No of courses returned by API
	@Test (priority = 0)
	public void printNumberOfCourses()
	{
		int noOfCourses = js.getInt("courses.size()");
		System.out.println("Total Number Of Courses: "+noOfCourses);
		System.out.println("-------------------------------");
	}
	
	// Print Purchase Amount
	// If the Attribute is present under a root element then the path will be rootelement.attribute
	@Test(priority = 1)
	public void printPurchaseAmount()
	{
		int totalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount is: "+totalPurchaseAmount);
		System.out.println("-------------------------------");
	}
	
	// Print Title of the first course
	//  If the Attribute is present under a Array then the path will be array[index].attribute
	@Test(priority = 2)
	public void firstCourseName()
	{
		String courseName= js.getString("courses[0].title");
		System.out.println("First Course Name: "+courseName);
		System.out.println("-------------------------------");
	}
	
	//Print All course titles and their respective Prices
	@Test(priority = 3)
	public void allCoursesTitlesAndPrice()
	{
		int size=js.getInt("courses.size()");
		for(int i=0;i<size;i++)
		{
			System.out.println("Course Name: "+js.getString("courses["+i+"].title"));
			System.out.println("Price: "+js.getInt("courses["+i+"].price"));
			System.out.println();
		}
		System.out.println("-------------------------------");
	}
	
	//Print no of copies sold by RPA Course
	@Test (priority = 4)
	public void totalRPACourseCopies()
	{
		int size=js.getInt("courses.size()");
		for(int i=0;i<size;i++)
		{
			String courseName=js.getString("courses["+i+"].title");
			if(courseName.equalsIgnoreCase("rpa"))
			{
				int copies=js.getInt("courses["+i+"].copies");
				System.out.println("Total Sold Copies: "+copies);
			}
		}
		System.out.println("-------------------------------");
	}
	
	//Verify if Sum of all Course prices matches with Purchase Amount
	@Test(priority = 5)
	public void comparePrice()
	{
		int totalPurchaseAmount=js.getInt("dashboard.purchaseAmount");
		int totalAmount=0;
		int size=js.getInt("courses.size()");
		for(int i=0;i<size;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			totalAmount = totalAmount + (price*copies);
		}
		if(totalPurchaseAmount==totalAmount)
		{
			System.out.println("Purcahse Amount & Total Amount Matched");
		}
		else
			System.out.println("Purcahse Amount & Total Amount Not Matched");
		System.out.println("-------------------------------");
	}
}
