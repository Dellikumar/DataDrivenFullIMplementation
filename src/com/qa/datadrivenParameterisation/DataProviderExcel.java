package com.qa.datadrivenParameterisation;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.datadrivenutility.Xls_DataProviserUtil;

public class DataProviderExcel {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\u6064273\\Downloads\\DelliWorkspace\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
	}
	@DataProvider
	public Iterator<Object[]> getRequireData()
	{
		ArrayList<Object[]> val = Xls_DataProviserUtil.getTestDataFromExcel();
		  return val.iterator();
	}
	@Test(dataProvider="getRequireData")
	public void runTestCaseWithData(String FirstName,String LastName,String Address1, String Address2) throws InterruptedException
	{
		driver.findElement(By.name("firstname")).clear();
		  driver.findElement(By.name("firstname")).sendKeys(FirstName);
		  driver.findElement(By.name("lastname")).clear();
		  driver.findElement(By.name("lastname")).sendKeys(LastName);
		  driver.findElement(By.name("address1")).clear();
		  driver.findElement(By.name("address1")).sendKeys(Address1);
		  driver.findElement(By.name("address2")).clear();
		  driver.findElement(By.name("address2")).sendKeys(Address2);
		 
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
