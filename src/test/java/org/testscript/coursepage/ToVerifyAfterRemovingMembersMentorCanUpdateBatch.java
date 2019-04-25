package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ToVerifyAfterRemovingMembersMentorCanUpdateBatch extends BaseTest
{
	//SUN-2112 , SUN-2106, SUN-2099, SUN-2118
	@Test(groups= {"courspage","regression1"})
	public void verifyMentorCanUpdateUpcomingBatchAfterRemovingMembers() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		
		//Step 1 : Login As Mentor
		signupObj.userLogin(SUBORG_MENTOR);
		
		//Step 2 : Navigate to course tab , and search for a course
		createMentorPageObj.navigateToCourseAndSearch("CourseA");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-2112");
		
		//Step 3 : Create IO batch with all mandatories and search members and mentors from different sub org
		String contentUrl=coursePageObj.createIOBatchWithMentorsAndMembersFromDifferentSubOrg();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-2106");
		
		//Step 4 : Edit the created Batch by adding and removing members
		coursePageObj.addMembersToBatch(contentUrl);
		
		//Logout as Mentor
		signupObj.userLogout();
	}
	
}
