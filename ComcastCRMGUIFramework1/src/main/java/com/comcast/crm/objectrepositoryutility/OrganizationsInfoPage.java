package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {

	WebDriver driver; 
	public OrganizationsInfoPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Phone")
	private WebElement headerMsg1;
	
	@FindBy (id="dtlview_Industry")
	private WebElement industry;
	
	@FindBy(id="dtlview_Type")
	private WebElement type;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getHeaderMsg1() {
		return headerMsg1;
	}
	
	public WebElement getIndustry() {
		return industry;
	}
	
	public WebElement getType() {
		return type;
	}
	
	
}
