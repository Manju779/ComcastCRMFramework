package com.comcast.crm.testng.orgtest;

import org.testng.annotations.Test;
import com.comcast.crm.generic.baseutility.BaseClass1;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTestPcb extends BaseClass1 {

	@Test(groups = "smakeTest")
	public void createOrganizationTest() throws Throwable {
		// Read Test Script data from Excel File
		String orgName = excelU.getDataFromExcel("Org", 1, 2) + javau.getRandonNumber();

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

	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		// Read Test Script data from Excel File
		String orgName = excelU.getDataFromExcel("Org", 7, 2) + javau.getRandonNumber();
		String phone = excelU.getDataFromExcel("Org", 7, 3);

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Click on Create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// Enter all the details and create new organization
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName, phone);

		// Verify Header phone number info expected result
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actphone = oip.getHeaderMsg1().getText();
		if (actphone.equals(phone)) {
			System.out.println(phone + "Information is varified == PASS");
		} else {
			System.out.println(phone + "Information is not varified == FAIL");
		}
	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithTypeTest() throws Throwable {

		// Read Test Script data from Excel File
		String orgName = excelU.getDataFromExcel("Org", 4, 2) + javau.getRandonNumber();
		String industry = excelU.getDataFromExcel("Org", 4, 3);
		String type = excelU.getDataFromExcel("Org", 4, 4);

		// Navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// Click on Create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// Enter all the details and create new organization
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName, industry, type);

		// Verify the dropdown industry and type
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actindustry = oip.getIndustry().getText();
		if (actindustry.equals(industry)) {
			System.out.println(industry + "Information is Verified===Pass");
		} else {
			System.out.println(industry + "Information is not Verified===Fail");
		}

		String acttype = oip.getType().getText();
		if (acttype.equals(type)) {
			System.out.println(orgName + "Information is Verified===Pass");
		} else {
			System.out.println(orgName + "Information is not Verified===Fail");
		}
	}
}
