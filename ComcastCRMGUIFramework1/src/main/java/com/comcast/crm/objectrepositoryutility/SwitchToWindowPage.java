package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchToWindowPage {
	
	WebDriver driver; 
	public SwitchToWindowPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchText;

	@FindBy(name = "search")
	private WebElement searchBtn;
	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
