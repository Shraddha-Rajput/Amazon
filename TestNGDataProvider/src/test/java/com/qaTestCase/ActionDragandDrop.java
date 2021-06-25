package com.qaTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionDragandDrop
{

	@Test
	public void dragAndDrop() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Testing Drivers\\Chrome_Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",drag);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		driver.close();
	}
}


	 


