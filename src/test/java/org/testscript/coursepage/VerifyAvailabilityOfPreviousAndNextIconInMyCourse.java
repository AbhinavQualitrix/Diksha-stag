package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyAvailabilityOfPreviousAndNextIconInMyCourse extends BaseTest 
{

	//SUN-2062 
	@Test(groups= {"coursepage","regression1","smoke2"})
	public void verifyAvailabilityOfpreviousAndNextIconInMyCourse() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-2062");
		
		//Step 1 : Login As Mentor
		signupObj.userLogin(PUBLICUSER1);
		
		//Step 2 : Navigate to Courses tab, Search a course having upcoming batch
		coursePageObj.navigateToCourseAndClickOnMyCourse();
		
		//Step 3 :Logout as Mentor
		signupObj.userLogout();
	}
}
