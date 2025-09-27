package com.comcast.crm.objectrepositoryutility;
/**
 * @author SAMAR
 * Login Page POM Class
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Rule-1 Create a Separate java class
	//Rule-2 Object Creation
	
	WebDriver driver;  //Rule-3 Object Initialization
	
	public LoginPage(WebDriver driver) //This driver object is local for this constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule-4 Object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule-5 Provide Action
	/**
	 * Login to application using username and password
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
}
