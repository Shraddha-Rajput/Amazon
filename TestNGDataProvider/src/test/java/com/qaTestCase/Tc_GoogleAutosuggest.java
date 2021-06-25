package com.qaTestCase;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Pages.Tc_10SearchEngineCapturePages;
import com.qa.TestBased.BasedTest;
import com.qa.Utility.ExcelUtility;

public class Tc_GoogleAutosuggest extends BasedTest
{

	@Test(dataProvider="getData")
	public void googleSearch(String searchItem) throws InterruptedException {

		
		Tc_10SearchEngineCapturePages gpage=new Tc_10SearchEngineCapturePages(driver);
		SoftAssert asa= new SoftAssert();
		gpage.getSearchTextField().sendKeys(searchItem);
		Thread.sleep(3000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		System.out.println("Autosuggest list is "+list.size());

		asa.assertEquals(list.size(),9);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(((WebElement)list.get(i)).getText());
		}

		gpage.getClickSearchButton().click();

		String tittle=driver.getTitle();
		
		//Assert.assertEquals(title,searchItem);
		Assert.assertEquals("its is erroe",tittle,searchItem);
		if(tittle.contains(searchItem))
		{
			Reporter.log("Title is same as search",true);
		}
		else
		{
			Reporter.log("Title is not same",true);

		}
		driver.navigate().back();

	}

	@DataProvider
	public String[][] getData() throws IOException
	{
		String xFile="E:\\testing\\TestNGDataProvider\\src\\test\\java\\com\\qa\\TestData\\InputData.xlsx";
		String xSheet="Sheet2";
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				data[i-1][j]= ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data; 
	}
}


