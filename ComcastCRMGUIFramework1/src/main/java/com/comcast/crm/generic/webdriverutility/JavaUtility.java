package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandonNumber()
	{
		Random random=new Random();
		int randonNum = random.nextInt(5000);
		return randonNum;
	}
	
	public String getSystemDate()
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;	
	}
	
	public String getRequiredDare(int days)
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}

}
