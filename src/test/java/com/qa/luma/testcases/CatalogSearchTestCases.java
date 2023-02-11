package com.qa.luma.testcases;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.luma.browser.LaunchBrowser;
import com.qa.luma.pages.CatalogSearch;
import com.qa.luma.pojo.CatalogSearchPojo;
import com.qa.luma.utils.ReadExcel;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CatalogSearchTestCases extends LaunchBrowser {

	CatalogSearchPojo catalogsearchpojo;
	CatalogSearch catalogsearch;
	
	@BeforeClass
	public void setUp()
	{
		initBrowser();
		catalogsearch=new CatalogSearch();
		
	}

	
	@DataProvider
	public Object[][] getSearchKeyword()
	{
		
		Object[][] searchKeyword=ReadExcel.getdata("Keyword");
		return searchKeyword;
		
	}
	
	@Test(priority=1,dataProvider="getSearchKeyword")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyEnterSearchKeyword(String keyword)
	{
		catalogsearchpojo=new CatalogSearchPojo(keyword);
		catalogsearch=catalogsearch.enterSearchKeyword(catalogsearchpojo);	
		
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	public void verifyGetProductPrices()
	{
		
		List<Double> priceList=catalogsearch.getProductPrice();
		for(Double prices:priceList)
		{
			
			
			System.out.println(prices);
			
		}
		
		
		
	}
	
	@DataProvider
	public Object[][] getItemName()
	{
		
		Object[][] productName=ReadExcel.getdata("itemName");
		return productName;
		
	}
	/*
	 * @Test(priority=3,dataProvider="getItemName") public void verifyOnItem(String
	 * productName) {
	 * 
	 * catalogsearch.clickOnItem(productName);
	 * 
	 * }
	 */
	

	 
	 
	}
	
