package com.qa.datadrivenParameterisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.datadrivenutility.Xls_Reader;

public class DataDrivendemo {
	
	Xls_Reader reader;
	int rowsCount;
	
	
	@Test

	public static void main (String args[])throws Exception {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\u6064273\\Downloads\\DelliWorkspace\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		
		
		
			//connecting to excel
			Xls_Reader reader = new Xls_Reader("C:\\SwatToolsNew\\SeleniumPracticeDummy\\src\\com\\qa\\testData\\Half_ebay_RegisterPage.xlsx");
			  int rowsCount = reader.getRowCount("registerpage");
			  
			//write a column to excel sheet
			  
			  reader.addColumn("registerpage", "status");
			  reader.addSheet("Homepage");
			  if(!reader.isSheetExist("Homepage"))
			  {
				  reader.addSheet("Homepage");
			  }
			  for(int row = 2;row<=rowsCount;row++)
					
				{
			
			System.out.println("The no of rows present in register page is " +rowsCount);
	     rowsCount = reader.getRowCount("registerpage");
			
		//Reading data from excel sheet
		String FName= reader.getCellData("registerpage", "FirstName", row);
		System.out.println(FName);
		
		String LName= reader.getCellData("registerpage", "LastName", row);
		System.out.println(LName);
		
		String Address1= reader.getCellData("registerpage", "Address1", row);
		System.out.println(Address1);
		
		String Address2= reader.getCellData("registerpage", "Address2", row);
		System.out.println(Address2);
		
		String City= reader.getCellData("registerpage", "City", row);
		System.out.println(City);
		
		String State= reader.getCellData("registerpage", "State", row);
		System.out.println(State);
		
		String Postal= reader.getCellData("registerpage", "Postal", row);
		System.out.println(Postal);
		
		String Email= reader.getCellData("registerpage", "Email", row);
		System.out.println(Email);
		
		String ReEnterEmail= reader.getCellData("registerpage", "ReEnterEmail", row);
		System.out.println(ReEnterEmail);
		
		//webdriver instance creation
		
		
		driver.findElement(By.name("firstname")).clear();
		  driver.findElement(By.name("firstname")).sendKeys(FName);
		  driver.findElement(By.name("lastname")).clear();
		  driver.findElement(By.name("lastname")).sendKeys(LName);
		  driver.findElement(By.name("address1")).clear();
		  driver.findElement(By.name("address1")).sendKeys(Address1);
		  driver.findElement(By.name("address2")).clear();
		  driver.findElement(By.name("address2")).sendKeys(Address2);
		  
		  Select s = new Select(driver.findElement(By.xpath("//*[@name='state']")));
		  s.selectByVisibleText(State);
		  driver.findElement(By.name("zip")).clear();
		  driver.findElement(By.name("zip")).sendKeys(Postal);
		  driver.findElement(By.name("email")).clear();
		  driver.findElement(By.name("email")).sendKeys(Email);
		  driver.findElement(By.name("retype_email")).clear();
		  driver.findElement(By.name("retype_email")).sendKeys(ReEnterEmail);
		  Thread.sleep(2000);
		 // reader.setCellData("registerpage", "status", row, "pass");
		  
		}
			  driver.quit();
	}
	
		  
		 


	}


