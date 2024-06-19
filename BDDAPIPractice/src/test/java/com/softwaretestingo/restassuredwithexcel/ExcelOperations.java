package com.softwaretestingo.restassuredwithexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExcelOperations 
{
	/**
	 * Get Access to All Rows Of Sheet Access to Specific Row From All Rows Get
	 * Access To All Cells Of Row Access the Data From Excel into Arrays
	 */
	String path = System.getProperty("user.dir") + "\\src\\test\\java\\files" + "\\TestData.xlsx";
	FileInputStream fis;
	XSSFWorkbook wb;
	int sheetCount;

	@BeforeTest
	public void SetupFileInfo() throws IOException 
	{
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

		sheetCount = wb.getNumberOfSheets();
		System.out.println("Total Sheets: " + sheetCount);
	}

	// Get Access to All Rows Of Sheet
	// Access to Specific Row From All Rows
	// Get Access To All Cells Of Row
	@Test(priority = 0, description = "Print All Rows Values")
	public void ReadAllRows() 
	{
		for (int i = 0; i < sheetCount; i++) 
		{
			// Find Sheet1 From All Sheets
			if (wb.getSheetName(i).equalsIgnoreCase("Sheet1")) 
			{
				XSSFSheet sheet = wb.getSheetAt(i);

				// Print All Row Values
				for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++) 
				{
					String cellValue = sheet.getRow(j).getCell(i).toString();
					// System.out.println(sheet.getRow(j).getCell(i));
					if (true) 
					{
						// System.out.println("All Column Values");
						for (int k = 1; k < sheet.getRow(j).getLastCellNum(); k++) 
						{
							System.out.print(sheet.getRow(j).getCell(k) + " | ");
						}
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}

	@Test(priority = 1, description = "Access Specific Row, All Column Values")
	public void ReadAllColumnValuesOfARow() 
	{
		System.out.println("--------------------------------------------");
		for (int i = 0; i < sheetCount; i++) 
		{
			// Find Sheet1 From All Sheets
			if (wb.getSheetName(i).equalsIgnoreCase("Sheet1")) 
			{
				XSSFSheet sheet = wb.getSheetAt(i);

				// From The Sheet Find "Purchase" Cell
				for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++) 
				{
					String cellValue = sheet.getRow(j).getCell(i).toString();
					// System.out.println(sheet.getRow(j).getCell(i));
					if (cellValue.equalsIgnoreCase("Purchase")) 
					{
						// System.out.println("All Column Values");
						for (int k = 1; k < sheet.getRow(j).getLastCellNum(); k++) 
						{
							System.out.print(sheet.getRow(j).getCell(k) + " | ");
						}
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}

	// Access the Data From Excel into ArrayList
	@Test(priority = 2, description = "Access the Data From Excel into Arrays")
	public void ExcelDataIntoArrays() 
	{
		System.out.println("--------------------------------------------");
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < sheetCount; i++) 
		{
			// Find Sheet1 From All Sheets
			if (wb.getSheetName(i).equalsIgnoreCase("Sheet1")) 
			{
				XSSFSheet sheet = wb.getSheetAt(i);

				// From The Sheet Find "Purchase" Cell
				for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++) 
				{
					String cellValue = sheet.getRow(j).getCell(i).toString();
					if (cellValue.equalsIgnoreCase("Add Profile")) 
					{
						// Add Respective TestCase Valsues In ArrayList
						for (int k = 1; k < sheet.getRow(j).getLastCellNum(); k++) 
						{
							al.add(sheet.getRow(j).getCell(k).getStringCellValue());
						}
					}
				}
				System.out.println(al);
				System.out.println("--------------------------------------------");
			}
		}
	}

	// This Method Will Retrive The Data Based On Your TestCase Name & SheetName
	public ArrayList<String> getData(String testcaseName, String sheetName) throws IOException 
	{
		//Setup The File
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

		sheetCount = wb.getNumberOfSheets();
		
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < sheetCount; i++) 
		{
			// Find Sheet1 From All Sheets
			if (wb.getSheetName(i).equalsIgnoreCase(sheetName)) 
			{
				XSSFSheet sheet = wb.getSheetAt(i);
				
				for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) 
				{
					String cellValue = sheet.getRow(j).getCell(0).toString();
					if (cellValue.equalsIgnoreCase(testcaseName)) 
					{
						for (int k = 1; k < sheet.getRow(j).getLastCellNum(); k++) 
						{
							al.add(sheet.getRow(j).getCell(k).getStringCellValue());
						}
					}
				}
			}
		}
		// Finally We Return The ArrayList
		return al;
	}
}