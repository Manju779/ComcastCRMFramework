package com.comcast.crm.testng.calendar;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseutility.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CalendarPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CalendarChaneOwnerTest extends BaseClass {

	@Test
	public void chaneOwnerincalendarTest() throws Throwable {
		String SubjectName = "Disucssion";

		UtilityClassObject.getTest().log(Status.INFO, "Read Test Script data from Excel File");
		String ownerGroup = excelU.getDataFromExcel("Cal", 1, 0);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Calender module");
		HomePage hp = new HomePage(driver);
		hp.getCalendarlink().click();

		CalendarPage cp = new CalendarPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to All Events & Todos");
		cp.getAllEventslink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "select the Subject");
		driver.findElement(By.xpath("//a[text()='" + SubjectName + "']/../../td[1]")).click();
		
		UtilityClassObject.getTest().log(Status.INFO, "click on change owner button");
		cp.getChangeOwnerBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "select the owner and save");
		cp.selectoptions(ownerGroup);
	}
}
