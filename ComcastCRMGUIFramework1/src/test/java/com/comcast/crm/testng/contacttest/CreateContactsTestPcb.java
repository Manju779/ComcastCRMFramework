package com.comcast.crm.testng.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.generic.baseutility.BaseClass1;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SwitchToWindowPage;

public class CreateContactsTestPcb extends BaseClass1 {

	@Test(groups = "smakeTest")
	public void createContactTest() throws Throwable {
		// Read Test Script data from Excel File
		String lastName = excelU.getDataFromExcel("Con", 1, 2) + javau.getRandonNumber();

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// Click on Create organization button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewConBtn().click();

		// Enter all the details and create new organization
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createNewContact(lastName);
		ccp.getSaveBtn().click();

		// Verify Header contact info expected result
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actlastName = cip.getHeaderMsg().getText();
		if (actlastName.equals(lastName)) {
			System.out.println(lastName + "Information is created===Pass");
		} else {
			System.out.println(lastName + "Information is not created===Fail");
		}
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		// Read Test Script data from Excel File
		String orgName = excelU.getDataFromExcel("Con", 7, 2) + javau.getRandonNumber();
		String lastName = excelU.getDataFromExcel("Con", 7, 3) + javau.getRandonNumber();

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Click on Create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// Enter all the details and create new organization
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName);

		// Verify Header msg expected result
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		if (actorgName.contains(orgName)) {
			System.out.println(orgName + "name is varified == PASS");
		} else {
			System.out.println(orgName + "name is not varified == FAIL");
		}

		// navigate to the contactmodule
		hp.getContactlink().click();

		// Click on Create organization button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewConBtn().click();

		// Enter all the details and create new organization
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createNewContact(lastName);
		ccp.getOrgicon().click();

		// switch to chiled window
		webu.switchToTabOnURL(driver, "module=Accounts");

		SwitchToWindowPage sw = new SwitchToWindowPage(driver);
		sw.getSearchText().sendKeys(orgName);
		sw.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window

		webu.switchToTabOnURL(driver, "Contacts&action");

		ccp.getSaveBtn().click();

		// Verify Header msg expected result
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String HeaderInfo = cip.getHeaderMsg1().getText();
		if (HeaderInfo.contains(lastName)) {
			System.out.println(lastName + " Header verified===Pass");
		} else {
			System.out.println(lastName + " Header not verified===Fail");
		}

		// Verify Header organization name info expected result
		actorgName = cip.getHeaderMsg2().getText();
		if (actorgName.trim().equals(orgName)) {
			System.out.println(orgName + " Information is created===Pass");
		} else {
			System.out.println(orgName + " Information is not created===Fail");
		}
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDataTest() throws Throwable {
		// Read Test Script data from Excel File
		String lastName = excelU.getDataFromExcel("Con", 4, 2) + javau.getRandonNumber();

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// Click on Create organization button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewConBtn().click();

		String startDate = javau.getSystemDate();
		String endDate = javau.getRequiredDare(30);

		// Enter all the details and create new organization
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createNewContact(lastName);

		ccp.getSupportStartDate().clear();
		ccp.getSupportStartDate().sendKeys(startDate);

		ccp.getSupportEndDate().clear();
		ccp.getSupportEndDate().sendKeys(endDate);

		ccp.getSaveBtn().click();

		// Verify Startdate and EndDate
		ContactsInfoPage cip = new ContactsInfoPage(driver);

		String actstartDate = cip.getSupportStartDate().getText();
		if (actstartDate.equals(startDate)) {
			System.out.println(startDate + "Information is created===Pass");
		} else {
			System.out.println(startDate + "Information is not created===Fail");
		}

		String actendtDate = cip.getSupportEndDate().getText();
		if (actendtDate.equals(endDate)) {
			System.out.println(endDate + "Information is created===Pass");
		} else {
			System.out.println(endDate + "Information is not created===Fail");
		}
	}
}
