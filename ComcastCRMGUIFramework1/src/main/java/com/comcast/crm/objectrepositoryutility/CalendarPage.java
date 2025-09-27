package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalendarPage {
	
	WebDriver driver;  
	public CalendarPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "All Events & Todos")
	private WebElement allEventslink;
	
	public WebElement getAllEventslink() {
		return allEventslink;
	}
	
	@FindBy(xpath = "(//input[@value='Change Owner'])[1]")
	private WebElement ChangeOwnerBtn;
	
	public WebElement getChangeOwnerBtn() {
		return ChangeOwnerBtn;
	}
	
	@FindBy(id = "group_checkbox")
	private WebElement selectGroupCheckbox;
	
	@FindBy(id = "lead_group_owner")
	private WebElement selectGroupOwnerDD;
	
	@FindBy(xpath = "//input[@value='Update Owner']")
	private WebElement UpdateOwnerBtn;

	public void selectoptions(String ownerGroup)
	{
		selectGroupCheckbox.click();
		Select sel= new Select(selectGroupOwnerDD);
		sel.selectByVisibleText(ownerGroup);
		UpdateOwnerBtn.click();
	}

}
