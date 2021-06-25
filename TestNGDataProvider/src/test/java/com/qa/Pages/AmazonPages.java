package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages
{
	WebDriver driver;

@FindBy(name="url")
WebElement categorybox;
public Select getcategorybox()
{
	Select category=new Select(categorybox);
	return category;	
}
	
@FindBy(id="twotabsearchtextbox")
WebElement searchtextbox;
public WebElement getsearchtextbox()
{
	return searchtextbox;	
}
@FindBy(id="nav-search-submit-button")
WebElement magnifierbutton;
public WebElement getmagnifierbutton()
{
	return magnifierbutton;		
}

@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
static
List<WebElement> searchboxItem;
public static List<WebElement> getsearchboxItem()
{
   return searchboxItem;

}

@FindAll(@FindBy(xpath="//span[@class='a-price-whole']")) 
static
List<WebElement> Prices;
public static List<WebElement> getPrices()
{
  return Prices;
}
	public AmazonPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
