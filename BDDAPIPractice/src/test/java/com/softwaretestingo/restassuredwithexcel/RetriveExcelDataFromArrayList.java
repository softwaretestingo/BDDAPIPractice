package com.softwaretestingo.restassuredwithexcel;
import java.io.IOException;
import java.util.ArrayList;
public class RetriveExcelDataFromArrayList 
{
	public static void main(String[] args) throws IOException 
	{
		ExcelOperations retriveData=new ExcelOperations();
		ArrayList data=retriveData.getData("Add Profile", "Sheet1");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
	}
}