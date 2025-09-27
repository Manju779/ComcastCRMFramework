package com.comcast.crm.testng.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SwitchToWindowPage;

public class CreateContactsTest extends BaseClass {

	@Test(groups = "smakeTest")
	public void createContactTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String lastName = excelU.getDataFromExcel("Con", 1, 2) + javau.getRandonNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact module");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getContactlink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new contact button");
		ContactsPage cp = new ContactsPage(UtilityClassObject.getDriver());
		cp.getCreateNewConBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new contact");
		CreatingNewContactPage ccp = new CreatingNewContactPage(UtilityClassObject.getDriver());
		ccp.createNewContact(lastName);
		ccp.getSaveBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, lastName+ "create a new contact");

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header contact info expected result");
		ContactsInfoPage cip = new ContactsInfoPage(UtilityClassObject.getDriver());
		String actlastName = cip.getHeaderMsg().getText();
		Assert.assertEquals(actlastName, lastName);
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String orgName = excelU.getDataFromExcel("Con", 7, 2) + javau.getRandonNumber();
		String lastName = excelU.getDataFromExcel("Con", 7, 3) + javau.getRandonNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to organization module");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new organization button");
		OrganizationsPage op = new OrganizationsPage(UtilityClassObject.getDriver());
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new organization");
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(UtilityClassObject.getDriver());
		cop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName+"new organization is created");
		
		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg expected result");
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		boolean status = actorgName.contains(orgName);
		Assert.assertEquals(status, true);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to the contact module");
		hp.getContactlink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new contact button");
		ContactsPage cp = new ContactsPage(UtilityClassObject.getDriver());
		cp.getCreateNewConBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new contact");
		CreatingNewContactPage ccp = new CreatingNewContactPage(UtilityClassObject.getDriver());
		ccp.createNewContact(lastName);
		ccp.getOrgicon().click();

		UtilityClassObject.getTest().log(Status.INFO, "switch to chiled window");
		webu.switchToTabOnURL(UtilityClassObject.getDriver(), "module=Accounts");

		SwitchToWindowPage sw = new SwitchToWindowPage(UtilityClassObject.getDriver());
		sw.getSearchText().sendKeys(orgName);
		sw.getSearchBtn().click();
		UtilityClassObject.getDriver().findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		UtilityClassObject.getTest().log(Status.INFO, "switch to parent window");
		webu.switchToTabOnURL(UtilityClassObject.getDriver(), "Contacts&action");

		ccp.getSaveBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header phone info expected result");
		ContactsInfoPage cip = new ContactsInfoPage(UtilityClassObject.getDriver());
		String HeaderInfo = cip.getHeaderMsg1().getText();
		boolean status1 = HeaderInfo.contains(lastName);
		Assert.assertEquals(status1, true);

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header organization name info expected result");
		actorgName = cip.getHeaderMsg2().getText();
		SoftAssert softA=new SoftAssert();
		softA.assertEquals(actorgName.trim(), orgName);
		softA.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDataTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String lastName = excelU.getDataFromExcel("Con", 4, 2) + javau.getRandonNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact module");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getContactlink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new contact button");
		ContactsPage cp = new ContactsPage(UtilityClassObject.getDriver());
		cp.getCreateNewConBtn().click();

		String startDate = javau.getSystemDate();
		String endDate = javau.getRequiredDare(30);

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new contact");
		CreatingNewContactPage ccp = new CreatingNewContactPage(UtilityClassObject.getDriver());
		ccp.createNewContact(lastName);

		ccp.getSupportStartDate().clear();
		ccp.getSupportStartDate().sendKeys(startDate);

		ccp.getSupportEndDate().clear();
		ccp.getSupportEndDate().sendKeys(endDate);

		ccp.getSaveBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Verify Startdate and EndDate");
		ContactsInfoPage cip = new ContactsInfoPage(UtilityClassObject.getDriver());

		String actstartDate = cip.getSupportStartDate().getText();
		Assert.assertEquals(actstartDate, startDate);

		String actendtDate = cip.getSupportEndDate().getText();
		Assert.assertEquals(actendtDate, endDate);
	}
}
