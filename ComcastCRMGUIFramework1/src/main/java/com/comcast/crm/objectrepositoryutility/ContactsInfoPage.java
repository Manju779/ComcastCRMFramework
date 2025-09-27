package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	WebDriver driver; 
	public ContactsInfoPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg1;
	
	public WebElement getHeaderMsg1() {
		return headerMsg1;
	}
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement headerMsg2;
	
	public WebElement getHeaderMsg2() {
		return headerMsg2;
	}
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement SupportStartDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement SupportEndDate;
	
	public WebElement getSupportStartDate() {
		return SupportStartDate;
	}

	public WebElement getSupportEndDate() {
		return SupportEndDate;
	}

}
