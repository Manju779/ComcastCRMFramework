package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunityPage {
	
	WebDriver driver; 
	public CreatingNewOpportunityPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createNewOpp;
	
	@FindBy(name="potentialname")
	private WebElement oppNameEdt;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement selecticon;
	public WebElement getCreateNewOpp() {
		return createNewOpp;
	}

	public WebElement getOppNameEdt() {
		return oppNameEdt;
	}

	public WebElement getSelecticon() {
		return selecticon;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
