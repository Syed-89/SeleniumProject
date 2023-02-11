package com.qa.luma.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.pojo.CatalogSearchPojo;
import com.qa.luma.utils.WaitUtil;

import io.qameta.allure.Step;

public class CatalogSearch extends LaunchBrowser {
	
	@FindBy(xpath="//input[@id='search']")
	WebElement searchField;

	
	@FindBy(xpath="//div[@class='price-box price-final_price']")
	List<WebElement> productPrice;
	
	
	public CatalogSearch()
	{
		
		PageFactory.initElements(driver, this);
	}
    
	@Step("Verifying the Search Product Field...")
    public CatalogSearch enterSearchKeyword(CatalogSearchPojo catalogsearch)
	{	
      searchField.sendKeys(catalogsearch.getSearchItem(),Keys.ENTER);
	  return new CatalogSearch();
	}
	
	@Step("Getting the product priceList")
	public List<Double> getProductPrice() { 
	
	List<Double> price=new ArrayList<Double>();
	List<WebElement>result=productPrice;
	
	  for(WebElement searchResult:result) 
	  
	  {
	  
	  price.add(Double.parseDouble(searchResult.getText().replace("$","")));
	  
	  }
	  
	  return price;
	  
	  
	  }
	 
 public ProductDetails clickOnItem(String productName) {
		  
		  By item=By.xpath("//img[@alt='"+productName+"']");
		  WaitUtil.waitForElement(item, 30); driver.findElement(item).click();
		  
		  return new ProductDetails();
		  
		  
		  }
		 
	

		
		
	}




