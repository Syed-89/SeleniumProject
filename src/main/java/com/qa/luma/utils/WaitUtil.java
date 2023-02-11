package com.qa.luma.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.luma.browser.LaunchBrowser;

public class WaitUtil extends LaunchBrowser {

	
private static WebDriverWait wait;
	
	
	
	
	public static void waitForElement(WebElement element, int time)
	{
		try
		{
			
			wait= new WebDriverWait(driver,Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(element));
			
			
			
		}
		
		catch(Exception e)
		{
			
			System.out.println("Some error occured while waiting for the element"+ element.toString());
			e.printStackTrace();
			
		}
	}
	
	public static void waitForElement(By Locator, int time)
	{
		try
		{
			
			wait= new WebDriverWait(driver,Duration.ofSeconds(time));
			wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
			
			
			
		}
		
		catch(Exception e)
		{
			
			System.out.println("Some error occured while waiting for the element"+ Locator.toString());
			e.printStackTrace();
			
		}
	}
		
		
		public static void waitForAlert(int time)
		{
			
			wait= new WebDriverWait(driver,Duration.ofSeconds(time));
			wait.until(ExpectedConditions.alertIsPresent()).accept();
			
			
		}
		
		
	
}
