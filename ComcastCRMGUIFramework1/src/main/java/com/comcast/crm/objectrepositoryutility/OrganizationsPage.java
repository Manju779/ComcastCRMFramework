package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver; 
	public OrganizationsPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search_field")
	private WebElement searchfieldDD;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	
	public WebElement getSearchfieldDD() {
		return searchfieldDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
}
