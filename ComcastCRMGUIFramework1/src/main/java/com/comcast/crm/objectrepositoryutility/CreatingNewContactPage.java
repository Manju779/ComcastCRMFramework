package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	
	WebDriver driver; 
	public CreatingNewContactPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath ="//input[@name='account_name']/following-sibling::img")
	private WebElement Orgicon;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastName() {
		return lastNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgicon() {
		return Orgicon;
	}
	
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
	}
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDate;
	
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
	
	

}
