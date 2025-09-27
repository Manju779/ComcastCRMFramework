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
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage1;

public class BaseClass {

	public DatabaseUtility dbU=new DatabaseUtility();
	public FileUtility fileU=new FileUtility();
	public ExcelUtility excelU=new ExcelUtility();
	public JavaUtility javau=new JavaUtility();
	public WebDriverUtility webu=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups = {"smakeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("Connect to database, Report config");
		dbU.getDbconnection();
	}
	
	@BeforeClass(groups = {"smakeTest","regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("Launch the browser");
		//String BROWSER = fileU.getDataFromPropertiesFile("browser");
		String BROWSER = System.getProperty("browser", fileU.getDataFromPropertiesFile("browser"));
		
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
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups = {"smakeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("Login to App");
		//String URL = fileU.getDataFromPropertiesFile("url");
		//String USER = fileU.getDataFromPropertiesFile("username");
		//String PASS = fileU.getDataFromPropertiesFile("password");
		
		String URL = System.getProperty("url", fileU.getDataFromPropertiesFile("url"));
		String USER = System.getProperty("username", fileU.getDataFromPropertiesFile("username"));
		String PASS = System.getProperty("password",fileU.getDataFromPropertiesFile("password"));
		
		LoginPage1 lp=new LoginPage1(UtilityClassObject.getDriver());
		lp.loginToApp(URL,USER, PASS);
	}
	
	@AfterMethod(groups = {"smakeTest","regressionTest"})
	public void configAM() {
		System.out.println("Logout");
		HomePage hp=new HomePage(UtilityClassObject.getDriver());
		hp.logout();
	}
	
	@AfterClass(groups = {"smakeTest","regressionTest"})
	public void configAC() {
		System.out.println("close the browser");
		UtilityClassObject.getDriver().quit();
	}
	
	@AfterSuite(groups = {"smakeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("Clodse Db Connection, Report Backup");
		dbU.closeDbconnection();
	}
}
