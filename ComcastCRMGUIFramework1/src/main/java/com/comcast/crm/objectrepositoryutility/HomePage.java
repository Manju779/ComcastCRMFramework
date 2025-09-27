package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
WebDriver driver;  
	public HomePage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Organizations1")
	private WebElement orglink1;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Calendar")
	private WebElement calendarlink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitieslink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentslink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignslink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singOutlink;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	public WebElement getCalendarlink() {
		return calendarlink;
	}
	
	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}
	
	public WebElement getDocumentslink() {
		return documentslink;
	}
	
	@FindBy(id = "qccombo")
	private WebElement QuickCreateDD;
	
	public void navogateToQuickCreateDD(String productNameOpt)
	{
		QuickCreateDD.click();
		Select sel =new Select(QuickCreateDD);
		sel.selectByVisibleText(productNameOpt);
	}
	
	public void navigateToCampaignsPage() {
		Actions act=new Actions(driver);
		act.moveToElement(morelink).perform();
		campaignslink.click();
	}
	
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		singOutlink.click();
	}
	
	
}
