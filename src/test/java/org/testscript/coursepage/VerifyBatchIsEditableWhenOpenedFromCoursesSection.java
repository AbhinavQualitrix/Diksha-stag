package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyBatchIsEditableWhenOpenedFromCoursesSection extends BaseTest
{
	//SUN-2109 , SUN-2108
	@Test(groups= {"coursepage","regression1"})
	public void verifyBatchIsEditableWhenOpenedFromCoursesSection() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		
		//Step 1 : Login As Mentor
		signupObj.userLogin(MENTOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-2109");
		//Step 2 : Navigate to Courses tab, Search a course having upcoming batch
		coursePageObj.verifyParameterizedCourseBatchIsEditable(UPCOMING_COURSE_BATCH,"upcoming");
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-2108");
		//Step 3 : Navigate to course tab , Search for course having ongoing batch
		coursePageObj.verifyParameterizedCourseBatchIsEditable(ONGOING_COURSE_BATCH,"ongoing");
		
		//Logout as Mentor
		signupObj.userLogout();
	}
	

}
