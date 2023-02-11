package com.qa.luma.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.luma.browser.LaunchBrowser;

public class ActionUtil extends LaunchBrowser {
	
	
	public static void ClickOnElement(By locator)
	{
	 Actions action = new Actions(driver);
	 WebElement element=driver.findElement(locator);
	 action.moveToElement(element).doubleClick();
	}

}
