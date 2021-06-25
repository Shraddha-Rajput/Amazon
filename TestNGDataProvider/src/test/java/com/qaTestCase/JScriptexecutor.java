package com.qaTestCase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JScriptexecutor
{@Test
	
	public void ScrollBy() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","D:\\Testing Drivers\\Chrome_Driver//chromedriver.exe");
WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();
driver.get("https://www.amazon.in/");


JavascriptExecutor js = (JavascriptExecutor )driver;
for(int i =0;i<=5;i++)
{
js.executeScript("window.scrollBy(0,500)");// top to bottom
Thread.sleep(3000);

}
for(int i =5;i>=1;i--)
{
js.executeScript("window.scrollBy(0,-500)"); //bottom to top
Thread.sleep(3000);

}



driver.close();

	}
}
