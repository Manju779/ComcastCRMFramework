package com.comcast.crm.testng.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smakeTest")
	public void createOrganizationTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String orgName = excelU.getDataFromExcel("Org", 1, 2) + javau.getRandonNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to organization module");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new organization button");
		OrganizationsPage op = new OrganizationsPage(UtilityClassObject.getDriver());
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new organization");
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(UtilityClassObject.getDriver());
		cop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName+ "organization created");

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg expected result");
		OrganizationsInfoPage oip = new OrganizationsInfoPage(UtilityClassObject.getDriver());
		String actorgName = oip.getHeaderMsg().getText();
		boolean status = actorgName.contains(orgName);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String orgName = excelU.getDataFromExcel("Org", 7, 2) + javau.getRandonNumber();
		String phone = excelU.getDataFromExcel("Org", 7, 3);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to organization module");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new organization button");
		OrganizationsPage op = new OrganizationsPage(UtilityClassObject.getDriver());
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new organization");
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(UtilityClassObject.getDriver());
		cop.createOrg(orgName, phone);
		UtilityClassObject.getTest().log(Status.INFO, orgName+ phone+ "organization created");

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header phone number info expected result");
		OrganizationsInfoPage oip = new OrganizationsInfoPage(UtilityClassObject.getDriver());
		String actphone = oip.getHeaderMsg1().getText();
		Assert.assertEquals(actphone, phone);
	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithTypeTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String orgName = excelU.getDataFromExcel("Org", 4, 2) + javau.getRandonNumber();
		String industry = excelU.getDataFromExcel("Org", 4, 3);
		String type = excelU.getDataFromExcel("Org", 4, 4);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to organization module");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new organization button");
		OrganizationsPage op = new OrganizationsPage(UtilityClassObject.getDriver());
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new organization");
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(UtilityClassObject.getDriver());
		cop.createOrg(orgName, industry, type);
		UtilityClassObject.getTest().log(Status.INFO, orgName+ industry+ type+ "organization created");

		UtilityClassObject.getTest().log(Status.INFO, "Verify the dropdown industry and type");
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actindustry = oip.getIndustry().getText();
		Assert.assertEquals(actindustry, industry);

		String acttype = oip.getType().getText();
		Assert.assertEquals(acttype, type);
	}
}
