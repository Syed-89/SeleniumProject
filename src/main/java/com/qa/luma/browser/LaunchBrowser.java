package com.qa.luma.browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import com.qa.luma.utils.FileSystem;




public class LaunchBrowser {

	protected static WebDriver driver;
	protected static Properties pro;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	FileSystem filesystem=new FileSystem();
	
	public LaunchBrowser()
	{
	    pro=new Properties();	
		FileInputStream fls;
		try {
			fls = new FileInputStream("C:\\Users\\Syed Danish\\eclipse-workspace\\SeleniumProject\\src\\main\\java\\com\\qa\\luma\\configuration\\config.properties");
			pro.load(fls);
		
		}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
}

	@BeforeSuite
	public void deleteExistingReports()
	{
		
		filesystem.deleteOldReports();
		
	}
	

	public static WebDriver initBrowser()
	{
		
		String browserName=pro.getProperty("BrowserName");
		if(browserName.equals("chrome"))
		{
			
			
			driver= new ChromeDriver();
			 
		
			
		}
		
		else
		{
			
			System.out.println("No browser found");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("Url"));
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	  @AfterClass
	  public static void tearDown() {
	  
	  driver.quit();
	  
	  
	  }
	 
}
