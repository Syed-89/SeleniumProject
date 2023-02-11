package com.qa.luma.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.listeners.TestAllureListener;
import com.qa.luma.pages.SignIn;
import com.qa.luma.pojo.SignInPojo;
import com.qa.luma.utils.ReadExcel;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({TestAllureListener.class})
public class SignInTestCases extends LaunchBrowser {

	private SignIn signin;
	private SignInPojo signinpojo;
	
	
	@BeforeClass
	public void setUp()
	{
		initBrowser();	
		signin=new SignIn();
		
	}
	
	@DataProvider
	public Object[][] getLoginDetails()
	{
		Object[][] loginDetails=ReadExcel.getdata("Userdetails");	
		return loginDetails;
		
	}
	
	
	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignInLink()
	{
		
		Assert.assertTrue(signin.signInLink());
		
	}

	
	@Test(priority=2,dataProvider="getLoginDetails")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyLogin(String email, String password)
	{
		signinpojo=new SignInPojo(email, password);
		signin.validLogin(signinpojo);
		
	}
	@Test(priority=3)
	public void verifyLoggedInUserName()
	{
		
		
	 String userName=signin.getUserName();
	 System.out.println(userName);
	 Assert.assertEquals(userName, "Welcome, Alen Paul!");
		
		
	}
	
	@Test(priority=4)
	public void verifySignOut()
	{
		
	String signOutMsg=signin.signOut();
	assertEquals(signOutMsg, "You are signed out");
		
	}
	
	
	

	 
}
