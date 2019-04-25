package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;

import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifySetAndResetOfFiltersOnCoursePage extends BaseTest
{
	//SUN-1633, SUN-1632, SUN-1510, SUN-1509, SUN-1508
	@Test(groups= {"coursepage","regression2"})
	public void verifySetAndResetOfFiltersOnCoursePage() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		
		//Step 1 : Login As creator
		signupObj.userLogin(CREATOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying:SUN-1632");
		
		//Step 2 : navigate to Course Page, verify Filter option and apply filter one by one
		coursePageObj.applyParameterizedFilterAndVerifyContent(FILTER_NAME[0], FILTER_OPTION[0]);
		
		coursePageObj.applyParameterizedFilterAndVerifyContent(FILTER_NAME[1], FILTER_OPTION[1]);
		
		coursePageObj.applyParameterizedFilterAndVerifyContent(FILTER_NAME[2], FILTER_OPTION[2]);
		
		coursePageObj.applyParameterizedFilterAndVerifyContent(FILTER_NAME[3], FILTER_OPTION[3]);
		
		coursePageObj.applyParameterizedFilterAndVerifyContent(FILTER_NAME[4], FILTER_OPTION[4]);
		
		coursePageObj.applyParameterizedFilterAndVerifyContent(FILTER_NAME[5], null);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying:SUN-1633");
		
		coursePageObj.verifyFilterSelectedOrNot();
		
		//Step 3 : navigate to course page ,search and verify Filters and View All
		coursePageObj.navigateToCoursePage();
		
		//Step 3 : Logout as creator
		signupObj.userLogout();
	}
	
	

}
