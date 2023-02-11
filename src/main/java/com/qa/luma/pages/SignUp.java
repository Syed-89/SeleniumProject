package com.qa.luma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.pojo.SignUpPojo;
import com.qa.luma.utils.WaitUtil;

import io.qameta.allure.Step;

public class SignUp extends LaunchBrowser {
	
	@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement createAccountLink;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement confirmPassword;

	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement createAccountBtn;
	
	@FindBy(xpath="//div[@class='message-success success message']")
	WebElement msg;
	
	
	public SignUp()
	{	
		PageFactory.initElements(driver, this);	
	}
	
	
	@Step("Verifying the SignUp link is displayed...")
	public boolean signUpLink()
	{
		
		return createAccountLink.isDisplayed();
		
	}
	
	@Step("verifying the the CreateAnAccount...")
	public String createAnAccount(SignUpPojo signup)
	{
		
		createAccountLink.click();
		firstName.sendKeys(signup.getFirstName());
		lastName.sendKeys(signup.getLastName());
		email.sendKeys(signup.getEmail());
		password.sendKeys(signup.getPassword());
		confirmPassword.sendKeys(signup.getConfirmPassword());
		createAccountBtn.click();
		WaitUtil.waitForElement(msg,30);
		String text=msg.getText();
		//System.out.println(text);
		return text;
		
	}

}
