package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyBatchEditingWhenOpenedFromCourseBatches extends BaseTest
{
	//SUN-2110, SUN-2107, SUN-2113, SUN-2116, SUN-2114,SUN-2117
	@Test(groups= {"coursepage","regression1"})
	public void verifyBatchEditingWorksFineWhenOpenedCourseBatches() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		GenericFunctions generic = new GenericFunctions();
		
		//Step 1 : Login As Mentor
		signupObj.userLogin(MENTOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-2110");
		//Step 2 : Navigate to Course Batches section
		generic.navigateToWorkspaceFeatures(COURSE_BATCHES);
		
		//Step 3 : Select a course batch from Expired Courses section and verify editing of Batch
		coursePageObj.verifyBatchEditingFromExpiredCoursesSection();
		
		//Step 4 : Select a course batch from Ongoing Courses section and verify editing of Batch
		coursePageObj.verifyBatchEditingFromOngoingCoursesSection();
		
		//Step 5 : Select a course batch from Upcoming Courses section and verify editing of Batch
		coursePageObj.verifyBatchEditingFromUpcomingCoursesSection();
		
		//Step 6 : Logout as Mentor
		signupObj.userLogout();
	}
}

