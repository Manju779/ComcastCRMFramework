package com.comcast.crm.testng.quickcreate;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductCreateInfoPage;
import com.comcast.crm.objectrepositoryutility.QuickCreatePage;

public class QuickCreateTest extends BaseClass {

	@Test
	public void quickCreateTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String productNameOpt = excelU.getDataFromExcel("QuickCreate", 1, 0);
		String productName = excelU.getDataFromExcel("QuickCreate", 1, 1) + javau.getRandonNumber();
		String productPrice = excelU.getDataFromExcel("QuickCreate", 1, 2);
		String productQty = excelU.getDataFromExcel("QuickCreate", 1, 3);
		String projectNameOpt = excelU.getDataFromExcel("QuickCreate", 2, 0);
		String projectName = excelU.getDataFromExcel("QuickCreate", 4, 1) + javau.getRandonNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to QuickCreate module");
		HomePage hp = new HomePage(driver);
		hp.navogateToQuickCreateDD(productNameOpt);

		QuickCreatePage qp = new QuickCreatePage(driver);
		qp.createProduct(productName, productPrice, productQty);

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg expected result");
		ProductCreateInfoPage pcp = new ProductCreateInfoPage(driver);
		String acproName = pcp.getHeaderText().getText();
		if (acproName.contains(productName)) {
			System.out.println(productName + "name is varified == PASS");
		} else {
			System.out.println(productName + "name is not varified == FAIL");
		}

		UtilityClassObject.getTest().log(Status.INFO, "Select the New Project and create");
		qp.navogateToNewProjectDD(projectNameOpt);
		UtilityClassObject.getTest().log(Status.INFO, projectNameOpt+ "Select the New Project");

		String startDate = javau.getSystemDate();
		String endDate = javau.getRequiredDare(30);

		qp.createProject(projectName, startDate, endDate);
		UtilityClassObject.getTest().log(Status.INFO, projectNameOpt+ startDate+ endDate+ "Select the New Project");
		
		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg expected result");
		ProductCreateInfoPage pcp1 = new ProductCreateInfoPage(driver);
		String acprojName = pcp1.getHeaderText1().getText();
		if (acprojName.contains(projectName)) {
			System.out.println(projectName + "name is varified == PASS");
		} else {
			System.out.println(projectName + "name is not varified == FAIL");
		}

		qp.deletePriJ();
		UtilityClassObject.getTest().log(Status.INFO, "Project deteted");
	}

}
