package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
	
	WebDriver driver;  
	public DocumentsPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "add")
	private WebElement addFolderBtn;
	
	@FindBy(name = "folderName")
	private WebElement folderNameEdt;
	
	@FindBy(name = "folderDesc")
	private WebElement folderDescEdt;
	
	@FindBy(name = "save")
	private WebElement saveBtn;
	

	public void addFolder(String folderName, String description)
	{
		addFolderBtn.click();
		folderNameEdt.sendKeys(folderName);
		folderDescEdt.sendKeys(description);
		saveBtn.click();
	}
	
	@FindBy(xpath = "//input[@name='show']")
	private WebElement viewEmptyFoldersBtn;
	
	public WebElement getViewEmptyFoldersBtn() {
		return viewEmptyFoldersBtn;
	}
}
