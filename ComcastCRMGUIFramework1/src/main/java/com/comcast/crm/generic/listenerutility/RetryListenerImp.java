package com.comcast.crm.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryListenerImp implements IRetryAnalyzer {

	int count=0;
	int limitCount=5;
	public boolean retry(ITestResult result)
	{
		if(count<limitCount)
		{
			count++;
			return true;
		}
		return false;
	}
}
