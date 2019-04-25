package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;

import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;

import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyMentorAbleToPreviewTheCourseWithoutCreatingAnyBatch extends BaseTest 
{
	//SUN-1537
	@Test(groups= {"regression2","coursepage"})
	public void verifyMentorCanReadPreviewCourseContentSuccessfully() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();

		
		//Login as Mentor
		userLogin.userLogin(MENTOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1537");
		
		//Search a course and verify consuming without creating batch
		coursePageObj.searchACourseWhereLogggedInUserIsNotCreatorOfIt();
	}
}
