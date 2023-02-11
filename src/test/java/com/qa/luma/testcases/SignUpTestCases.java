package com.qa.luma.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.pages.SignUp;
import com.qa.luma.pojo.SignUpPojo;
import com.qa.luma.utils.ReadExcel;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SignUpTestCases extends LaunchBrowser {
	
	private SignUpPojo signuppojo;
	private SignUp signup;
	
	
	@BeforeClass
	public void setUp()
	{				
		initBrowser();
		signup=new SignUp();	
	}
	
	@DataProvider
	public Object[][] getSignUpDetails()
	{
		
		Object[][] signUpDetails=ReadExcel.getdata("signup");
		return signUpDetails;
			
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLink()
	{
		Assert.assertTrue(signup.signUpLink());
	}
	
	@Test(priority=2,dataProvider="getSignUpDetails")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyCreateAnAccount(String fname, String lname, String email, String password, String confirmPassword)
	{
    	signuppojo=new SignUpPojo(fname, lname, email, password, confirmPassword);
		String successMsg=signup.createAnAccount(signuppojo);
		Assert.assertEquals(successMsg, "Thank you for registering with Fake Online Clothing Store.");			
	}
	


}
