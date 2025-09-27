package com.comcast.crm.testng.opportunities;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SwitchToWindowPage;

public class CreateOpportunitiesTest extends BaseClass {

	@Test
	public void createOpportunitiesTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String orgName = excelU.getDataFromExcel("Org", 1, 2) + javau.getRandonNumber();
		String oppName = excelU.getDataFromExcel("Oppo", 1, 2) + javau.getRandonNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization module");
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new Organization button");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new Organization");
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName);

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg expected result");
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actorgName = oip.getHeaderMsg().getText();
		if (actorgName.contains(orgName)) {
			System.out.println(orgName + "name is varified == PASS");
		} else {
			System.out.println(orgName + "name is not varified == FAIL");
		}

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Opportunities module");
		hp.getOpportunitieslink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create New Opportunity button");
		CreatingNewOpportunityPage cnp = new CreatingNewOpportunityPage(driver);
		cnp.getCreateNewOpp().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create new Opportunity");
		cnp.getOppNameEdt().sendKeys(oppName);
		cnp.getSelecticon().click();

		UtilityClassObject.getTest().log(Status.INFO, "switch to chiled window");
		webu.switchToTabOnURL(driver, "module=Accounts");

		SwitchToWindowPage sw = new SwitchToWindowPage(driver);
		sw.getSearchText().sendKeys(orgName);
		sw.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		UtilityClassObject.getTest().log(Status.INFO, "switch to parent window");
		webu.switchToTabOnURL(driver, "Contacts&action");
		cnp.getSaveBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg expected result");
		OpportunitiesInfoPage oip1 = new OpportunitiesInfoPage(driver);
		String HeaderInfo = oip1.getHeaderMsg1().getText();
		if (HeaderInfo.contains(oppName)) {
			System.out.println(oppName + " Header verified===Pass");
		} else {
			System.out.println(oppName + " Header not verified===Fail");
		}

	}

}
