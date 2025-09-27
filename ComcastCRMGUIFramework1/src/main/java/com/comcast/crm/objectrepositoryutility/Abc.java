package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Abc {
	
	WebDriver driver;  
	public Abc(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "All Events & Todos")
	private WebElement allEventslink;
	
	@FindBy(linkText = "All Events & Todos")
	private WebElement allEventslink1;

}
