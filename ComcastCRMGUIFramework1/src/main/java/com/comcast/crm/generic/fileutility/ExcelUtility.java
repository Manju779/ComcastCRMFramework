package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./testScriptData/testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowcount(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./testScriptData/testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	public void setDataintoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./testScriptData/testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		
		
		FileOutputStream fos=new FileOutputStream("./testScriptData/testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
	}

}
