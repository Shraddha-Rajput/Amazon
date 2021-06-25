package com.qa.Pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tc_10SearchEngineCapturePages {
	WebDriver driver;
	
	@FindBy(name="q")

	WebElement SearchTextField;
	
	public WebElement getSearchTextField() {
		return SearchTextField;
	}
	
	@FindBy(name="btnK")
	WebElement ClickSearchButton;
	
	public WebElement getClickSearchButton() {
		return ClickSearchButton;
	}
	
	@FindAll(@FindBy(className="sbct"))

	List<WebElement> ListElements;
	public List<WebElement> getListElements()
	{
		return ListElements;
	}

	public Tc_10SearchEngineCapturePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

}