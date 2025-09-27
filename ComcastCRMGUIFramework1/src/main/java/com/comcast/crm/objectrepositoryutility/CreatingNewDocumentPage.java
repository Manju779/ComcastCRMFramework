package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewDocumentPage {
	
	WebDriver driver;
	public CreatingNewDocumentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Document...']")
	private WebElement createNewDocBtn;
	
	public WebElement getCreateNewDocBtn() {
		return createNewDocBtn;
	}
	
	@FindBy(name = "notes_title")
	private WebElement docTitleEdt;
	
	@FindBy(name = "folderid")
	private WebElement folderNameDD;
	
	@FindBy(name = "filename")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createNewDocs(String titleName, String folderName) 
	{
		docTitleEdt.sendKeys(titleName);
		folderNameDD.click();
		Select sel =new Select(folderNameDD);
		sel.selectByVisibleText(folderName);
		chooseFileBtn.sendKeys("C:\\Users\\SAMAR\\Desktop\\Loading Issue.txt");
		saveBtn.click();
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement HeaderText;
	
	public WebElement getHeaderText() {
		return HeaderText;
	}
	
}
