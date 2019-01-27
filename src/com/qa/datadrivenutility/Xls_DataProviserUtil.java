package com.qa.datadrivenutility;

import java.util.ArrayList;

public class Xls_DataProviserUtil {
	static Xls_Reader reader;
	
	public static  ArrayList<Object[]> getTestDataFromExcel()
	{
		ArrayList<Object[]> mydata = new ArrayList<>();
		 reader = new Xls_Reader("C:\\Users\\u6064273\\Desktop\\Half_ebay_DataProvider.xlsx");
		
		int rowscount=reader.getRowCount("registerpage");
		
		for (int rowNum=2;rowNum<=rowscount;rowNum++)
		{
		String FirstName = reader.getCellData("registerpage", "FirstName", rowNum);
		String LastName=reader.getCellData("registerpage", "LastName", rowNum);
		String Address1=reader.getCellData("registerpage", "Address1", rowNum);
		String Address2=reader.getCellData("registerpage", "Address2", rowNum);
		
		Object[] a = {FirstName,LastName,Address1,Address2};
		mydata.add(a);
}
		return mydata;
		
	}

}
