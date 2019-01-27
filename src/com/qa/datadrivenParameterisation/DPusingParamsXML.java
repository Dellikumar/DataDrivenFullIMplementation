package com.qa.datadrivenParameterisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DPusingParamsXML {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\u6064273\\Downloads\\DelliWorkspace\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Parameters({"fname","lname","add1","add2"})
	@Test
	public void runTestCaseWithData(String fname,String lname ,String add1,String add2) throws InterruptedException
	{
		driver.findElement(By.name("firstname")).clear();
		  driver.findElement(By.name("firstname")).sendKeys(fname);
		  driver.findElement(By.name("lastname")).clear();
		  driver.findElement(By.name("lastname")).sendKeys(lname);
		  driver.findElement(By.name("address1")).clear();
		  driver.findElement(By.name("address1")).sendKeys(add1);
		  driver.findElement(By.name("address2")).clear();
		  driver.findElement(By.name("address2")).sendKeys(add2);

}
}
