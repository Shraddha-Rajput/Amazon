package com.qaTestCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BasedTest

{
protected	WebDriver driver;
	
	@Parameters({"Browser","url"})
	
	@BeforeClass
    public void setUp(String Browser, String url)
	{
	
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\Testing Drivers\\Chrome_Driver//chromedriver.exe");
		driver= new ChromeDriver();
		
	}
	else if(Browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver","E:\\testing\\TestNgProject\\drivers\\msedgedriver.exe");
		driver= new EdgeDriver();
		
	}
	
	
	driver.manage().window().maximize();
	driver.get(url);
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
		
	
	}
	
	public  void captureScreenshot(WebDriver driver ,String tname) throws IOException
	{
		TakesScreenshot screenShot =(TakesScreenshot) driver;
		File Source = screenShot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		FileUtils.copyFile(Source, new File(Dest));
	}

}







