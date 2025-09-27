package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreateInfoPage {

	WebDriver driver;
	public ProductCreateInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement HeaderText;
	
	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement HeaderText1;
	
	public WebElement getHeaderText1() {
		return HeaderText1;
	}
	
}
