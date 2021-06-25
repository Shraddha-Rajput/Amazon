package com.qaTestCase;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.AmazonPages;
import com.qa.TestBased.BasedTest;
import com.qa.Utility.ExcelUtility;

public class TcAmazon extends BasedTest
{
	@Test(dataProvider="getData")
	public void SearchItem(String Category, String Itemname) throws InterruptedException, IOException
	{
	    AmazonPages amazon= new AmazonPages(driver);
		List<WebElement>options=amazon.getcategorybox().getOptions();
		Reporter.log("total number of options are:" + options.size(),true);
		//Thread.sleep(3000);

		
		// Assert.assertTrue(options.size()<=50);
		 
		// Assert.assertEquals(options.size(),50);
		 amazon.getcategorybox().selectByVisibleText(Category);
		 amazon.getsearchtextbox().clear();
		 amazon.getsearchtextbox().sendKeys(Itemname);
		 amazon.getmagnifierbutton().click();
		 
		 //Thread.sleep(3000);
		 
		 List <WebElement> booklist=AmazonPages.getsearchboxItem();
			List<WebElement> bookprice=AmazonPages.getPrices();
			
			Reporter.log("total no.of.items in category list is "+ booklist.size()+" and price list is"+bookprice.size());
			Assert.assertTrue(booklist.size()<=50);
			
			for(int i=0;i<booklist.size();i++) 
			{
				
				Reporter.log(booklist.get(i).getText()+" price is --> "+bookprice.get(i).getText(),true);
			}
			
			
			
			
			
			String title = driver.getTitle();
			if(title == Itemname) 
			{

				Reporter.log("title matched",true);
				Assert.assertTrue(true);
			}
			else
			{

				captureScreenshot(driver," SearchItem");
				Reporter.log("title not matched",true);
				Assert.assertTrue(false);
			}
			/*
			 * Object obj=(Object)Price; String s=(String)obj; int i=Integer.parseInt(s);
			 * i++;
			 */
			}
			
	
         @DataProvider
             public String[][] getData() throws IOException
        	 {
        	     String xFile ="E:\\testing\\TestNGDataProvider\\src\\test\\java\\com\\qa\\TestData\\InputData.xlsx";           
        	     String xSheet ="Sheet1";
        	     int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
        	     int cellCount= ExcelUtility.getCellCount(xFile, xSheet,rowCount);
        	     String[][] data=  new String[rowCount][cellCount];
        	  for(int  i=1;i<=rowCount;i++)
        	  { 
        		  for(int j=0;j<cellCount;j++)
        		  
        		  {
        			  data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
        			  
        		  }
        		 
        	  }
        	  return data;
        }

	}





