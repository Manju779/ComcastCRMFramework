package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class QuickCreatePage {
	WebDriver driver;
	public QuickCreatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(name = "unit_price")
	private WebElement productPriceEdt;
	
	@FindBy(name = "discontinued")
	private WebElement ProductActiveChekbox ;
	
	@FindBy(id = "qtyinstock")
	private WebElement qtyinstockEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public void createProduct(String productName, String productPrice, String productQty)
	{
		productNameEdt.sendKeys(productName);
		productPriceEdt.sendKeys(productPrice);
		ProductActiveChekbox.click();
		qtyinstockEdt.sendKeys(productQty);
		saveBtn.click();
	}
	
	@FindBy(id = "qccombo")
	private WebElement QuickCreateDD;
	
	public void navogateToNewProjectDD(String projectNameOpt)
	{
		QuickCreateDD.click();
		Select sel =new Select(QuickCreateDD);
		sel.selectByVisibleText(projectNameOpt);
	}
	
	@FindBy(name = "projectname")
	private WebElement projectNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn1;
	
	@FindBy(name="startdate")
	private WebElement StartDate;
	
	@FindBy(name="targetenddate")
	private WebElement EndDate;

	public void createProject(String projectName, String startDate, String endDate)
	{
		projectNameEdt.sendKeys(projectName);
		StartDate.sendKeys(startDate);
		EndDate.sendKeys(endDate);
		saveBtn.click();
	}
	
	@FindBy(xpath = "(//input[@name='Delete'])[1]")
	private WebElement deleteBtn;
	
	public void deletePriJ()
	{
	deleteBtn.click();
	Alert alert = driver.switchTo().alert();
	alert.accept();
	}
}
