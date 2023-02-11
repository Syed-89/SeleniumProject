package com.qa.luma.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.utils.WaitUtil;

import io.qameta.allure.Step;

public class ProductDetails extends LaunchBrowser{
	
	
	@FindBy(xpath="//div[@class='price-box price-final_price']")
	WebElement itemPrice;
	
	@FindBy(xpath="//button[@id='product-addtocart-button']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//div[@class='message-success success message']")
	WebElement successMsg;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement showCart;
	
	@FindBy(xpath="//a[normalize-space()='Dash Digital Watch']")
	WebElement productName;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	WebElement checkOutButton;
	
	public ProductDetails() {
		PageFactory.initElements(driver, this);
	}

	@Step("Getting the Productprice...")
	public String getProductPrice()
	{
		String price=itemPrice.getText();
		return price;
	}
	
	@Step("Clicking on the AddToCart...")
	public String clickOnAddToCart()
	{
		
		addToCartButton.click();
		WaitUtil.waitForElement(successMsg, 20);
		String message=successMsg.getText();
		
		return message;
	}

	@Step("Clicking on the ShowCart...")
	public void clickOnShowCart()
	{
		WaitUtil.waitForElement(showCart, 30);
		showCart.click();
		
	}
	
	@Step("Verifying the ProductName...")
	public String checkProductName()
	{
		
		WaitUtil.waitForElement(productName, 30);
		String itemName=productName.getText();
		return itemName;
		
	}
	
	@Step("Clicking on the ProceedToCheckOut...")
	public void clickOnProceedToCheckOut()
	{
		
		checkOutButton.click();
		
	}
	
	/*
	 * public void clickOnAddtoCart() {
	 * 
	 * checkOutButton.click();
	 * 
	 * 
	 * }
	 */
}
