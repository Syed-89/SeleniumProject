package com.qa.luma.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.luma.browser.LaunchBrowser;

public class ReadExcel extends LaunchBrowser {

	public static String sheet_path= pro.getProperty("ExcelPath");
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static FileInputStream fls;
	
	
	public ReadExcel()
	{
		
	}
	
	public static Object[][] getdata(String sheetname){
	
	File src = new File(sheet_path);
    
	try {
	fls= new FileInputStream(src);
     }
     catch(FileNotFoundException e){
 			// TODO Auto-generated catch block
 			e.printStackTrace();
    	 
     }
	try {
		book=new XSSFWorkbook(fls);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	sheet=book.getSheet(sheetname);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0; i<sheet.getLastRowNum(); i++)
	{
		for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
		{
			
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			
		}
	}
	return data;
	}
	
}
