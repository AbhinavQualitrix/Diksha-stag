package org.testscript.coursepage;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ApplyMultipleFiltersInCoursePage extends BaseTest
{
	//SUN-1633, SUN-1632, SUN-1510
	@Test(groups= {"coursepage","regression2"})
	public void applyMultipleFiltersInCoursePage() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		
		//Step 1 : Login As creator
		signupObj.userLogin(CREATOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying:SUN-1630");
		
		
		//Step 2 : navigate to Course Page, verify Filter option and apply filter one by one
		coursePageObj.applyMultipleFiltersInCoursePage(FILTER_NAME[0], FILTER_OPTION[0],FILTER_NAME[1], FILTER_OPTION[1]);
		
		
		coursePageObj.applyMultipleFiltersInCoursePage(FILTER_NAME[2], FILTER_OPTION[2],FILTER_NAME[3], FILTER_OPTION[3]);

		
		
		
		//Step 3 : Logout as creator
		signupObj.userLogout();
	}
	
	

}
