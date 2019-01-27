package com.qa.crossbrowser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.listneres.ListenersImplement;


@Listeners(ListenersImplement.class)
public class CrossBrowserDemo {
	Properties or;
	@BeforeTest
	public void setUp() throws Exception
	{
	    or = new Properties();
		FileInputStream fis = new FileInputStream("C:\\SwatToolsNew\\SeleniumPracticeDummy\\src\\com\\qa\\objectrepo\\or.properties");
		or.load(fis);
		
	}
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void verifyTitle(String browserName) throws InterruptedException
	
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\u6064273\\Downloads\\DelliWorkspace\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\u6064273\\Downloads\\DelliWorkspace\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		String title =driver.getTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours" ,"Test case is not matching with the expected");
		//System.out.println("The test case is succesfully passed");
		Thread.sleep(3000);
		driver.findElement(By.name(or.getProperty("login_username"))).sendKeys("mercury568");
		driver.findElement(By.name(or.getProperty("login_pwd"))).sendKeys("mercury@568");
		driver.findElement(By.xpath(or.getProperty("login_sgnBtn"))).click();
		driver.quit();
		}
	
	
	

}
