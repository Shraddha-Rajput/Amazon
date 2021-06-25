package com.qaTestCase;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.TestBased.BasedTest;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class DemoTakesScreenshot
{
	
WebDriver driver;


@BeforeClass
public void setUp()
{


	System.setProperty("webdriver.chrome.driver","D:\\Testing Drivers\\Chrome_Driver//chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("https://www.amazon.in/");
	
}
@AfterClass
public void teardown()
{
	driver.close();
}


	
	
	@Test(priority=1)
	public  void screenshotofElement() throws IOException
	{
		File Source=driver.findElement(By.id("nav-logo-sprites")).getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"AmazonLogo.png";
		FileUtils.copyFile(Source, new File(Dest));
	}
	@Test(priority=2)
	public  void screenshotofDriver() throws IOException
	{
		TakesScreenshot screenShot =(TakesScreenshot) driver;
		File Source = screenShot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+"AmazonPage.png";
		FileUtils.copyFile(Source, new File(Dest));
	
	}
	@Test(priority=3)
	public  void screenshotofFullPage() throws IOException
	{AShot SShot = new AShot();
	Screenshot  Source =SShot.shootingStrategy(ShootingStrategies.viewportPasting(3000)).takeScreenshot(driver);
	String Dest = System.getProperty("user.dir")+"/Screenshots/"+"AmazonFullPage.jpg";
		
	ImageIO.write(Source.getImage(),"jpg", new File(Dest));
	}
	
}
