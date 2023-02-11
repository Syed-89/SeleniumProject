package com.qa.luma.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.listeners.TestAllureListener;
import com.qa.luma.pages.CatalogSearch;
import com.qa.luma.pages.ProductDetails;
import com.qa.luma.pojo.CatalogSearchPojo;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({TestAllureListener.class})
public class ProductDetailsTestCases extends LaunchBrowser {

	ProductDetails productdetails;
	CatalogSearch catalogsearch;
	
	@BeforeClass
	public void setUp()
	{
		initBrowser();
		catalogsearch=new CatalogSearch();
		CatalogSearchPojo catalogsearchpojo=new CatalogSearchPojo("watch");
		catalogsearch.enterSearchKeyword(catalogsearchpojo);
		productdetails=catalogsearch.clickOnItem("Dash Digital Watch");
		productdetails=new ProductDetails();
		
		
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	//@DisplayName("Human-readable test name")
	@Description("Product item Price")
	public void verifyProductItemPrice()
	{
		
		String price=productdetails.getProductPrice();
		System.out.println(price);
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.CRITICAL)
	public void verifyClickOnAddToCart()
	{
		
		String successMsg=productdetails.clickOnAddToCart();
		assertEquals(successMsg, "You added Dash Digital Watch to your shopping cart.");
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.CRITICAL)
	public void verifyClickOnShowCart()
	{
		
		productdetails.clickOnShowCart();
		
	}
	
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	public void verifyCheckProductName()
	{
		
		String name=productdetails.checkProductName();
		System.out.println(name);
		Assert.assertEquals(name, "Dash Digital ");
	}
	
	@Test(priority=5)
	@Severity(SeverityLevel.CRITICAL)
	public void verifyClickProceedToCheckOut()
	{
		
		
		productdetails.clickOnProceedToCheckOut();
		
	}
	
	 
}
