package com.qa.luma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.pojo.SignInPojo;
import com.qa.luma.utils.WaitUtil;

import io.qameta.allure.Step;

public class SignIn extends LaunchBrowser{
	
    @FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signInLink;
  
    @FindBy(xpath="//input[@id='email']")
    WebElement email;

    @FindBy(xpath="//input[@name='login[password]']")
    WebElement password;
   
    @FindBy(xpath="//fieldset[@class='fieldset login']//button[@id='send2']")
    WebElement loginButton;
    
    @FindBy(xpath="//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Alen Paul!']")
	WebElement username;
    
    @FindBy(xpath="//div[@class='message-error error message']")
    WebElement errormsg;
    
    @FindBy(xpath="//li[@class='customer-welcome']")
    WebElement customerMenu;
    
    @FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    WebElement signOutLink;
    
    @FindBy(xpath="//span[@class='base']")
    WebElement signOutMsg;
    	

    public SignIn()
    {
     	PageFactory.initElements(driver, this);	
    }    
    
    @Step("Verifying the SignIn link is displayed...")
    public boolean signInLink()
    {
    	
    	return signInLink.isDisplayed();
    	
    }
    @Step("Verfying the login with valid credientials...")
	public void validLogin(SignInPojo user)
	{
		signInLink.click();
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        loginButton.click();
	}
    
    public String signOut()
    {
    	WaitUtil.waitForElement(customerMenu, 20);
    	customerMenu.click();
    	signOutLink.click();
    	String message=signOutMsg.getText();
    	
    	return message;
    	
    }
    
	/*
	 * @Step("Verfying the login with invalid credientials...") public String
	 * invalidLogin(SignInPojo user) { signInLink.click();
	 * email.sendKeys(user.getEmail()); password.sendKeys(user.getPassword());
	 * loginButton.click(); String msg=errormsg.getText();
	 * 
	 * return msg; }
	 */
    
    @Step("getting logged in username...")
    public String getUserName()
    {
    	WaitUtil.waitForElement(username, 20);
    	String name=username.getText();
    	
    	return name;
    }
}
