package com.comcast.crm.testng.documents;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewDocumentPage;
import com.comcast.crm.objectrepositoryutility.DocumentsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreatingNewDocumentTest extends BaseClass {

	@Test
	public void creatingNewDocumentTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String titleName = excelU.getDataFromExcel("Doc", 3, 2) + javau.getRandonNumber();
		String folderName = excelU.getDataFromExcel("Doc", 3, 3);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to document module");
		HomePage hp = new HomePage(driver);
		hp.getDocumentslink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on Create new document button");
		CreatingNewDocumentPage cndp = new CreatingNewDocumentPage(driver);
		cndp.getCreateNewDocBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and Create new document");
		cndp.createNewDocs(titleName, folderName);
		UtilityClassObject.getTest().log(Status.INFO, titleName+ folderName+ "new document created");

		UtilityClassObject.getTest().log(Status.INFO, "Verify Header msg expected result");
		String actTitleName = cndp.getHeaderText().getText();
		if (actTitleName.contains(titleName)) {
			System.out.println(titleName + "name is varified == PASS");
		} else {
			System.out.println(titleName + "name is not varified == FAIL");
		}
	}

	@Test
	public void documentsFolderCreationAndDeletion() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String folderName = excelU.getDataFromExcel("Doc", 1, 2) + javau.getRandonNumber();
		String description = excelU.getDataFromExcel("Doc", 1, 3);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to documents module");
		HomePage hp = new HomePage(driver);
		hp.getDocumentslink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Enter all the details and create folder");
		DocumentsPage dp = new DocumentsPage(driver);
		dp.addFolder(folderName, description);
		UtilityClassObject.getTest().log(Status.INFO, folderName+ description+ "folder Created");
		
		Thread.sleep(5000);
		UtilityClassObject.getTest().log(Status.INFO, "Click on View empty folder");
		dp.getViewEmptyFoldersBtn().click();
		Thread.sleep(5000);

		UtilityClassObject.getTest().log(Status.INFO, "Select and delete the folder");
		driver.findElement(By.xpath("//td[text()='" + folderName + "']/following-sibling::td/a")).click();

		// Alert alert = driver.switchTo().alert();
		// alert.accept();
	}

}
