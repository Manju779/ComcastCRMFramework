package com.comcast.crm.generic.baseutility;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage1;

public class BaseClass1 {

	public DatabaseUtility dbU=new DatabaseUtility();
	public FileUtility fileU=new FileUtility();
	public ExcelUtility excelU=new ExcelUtility();
	public JavaUtility javau=new JavaUtility();
	public WebDriverUtility webu=new WebDriverUtility();
	public WebDriver driver=null;
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("Connect to database, Report config");
		dbU.getDbconnection();
	}
	
	@Parameters("BROWSER")
	@BeforeClass
	public void configBC(String browser) throws Throwable {
		System.out.println("Launch the browser");
		
		String BROWSER = browser;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("Login to App");
		String URL = fileU.getDataFromPropertiesFile("url");
		String USER = fileU.getDataFromPropertiesFile("username");
		String PASS = fileU.getDataFromPropertiesFile("password");
		
		LoginPage1 lp=new LoginPage1(driver);
		lp.loginToApp(URL,USER, PASS);
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("Logout");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("close the browser");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("Clodse Db Connection, Report Backup");
		dbU.closeDbconnection();
	}
}
