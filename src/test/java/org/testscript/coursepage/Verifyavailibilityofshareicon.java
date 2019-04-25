/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 04/03/2019

 * Purpose: Open a published course and verify share icon is available.

 */

package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;

public class Verifyavailibilityofshareicon extends BaseTest {
	
	//SUN-1638
	@Test(groups = { "coursepage", "regression1" })
	public void verifyavailibilityofshareicon() throws Exception {

		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1638");
		
		// Step1:Login as Mentor
		userLogin.userLogin(MENTOR);

		// Step2:navigate to published section
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		// Step2:Enroll for the open batch
		String contentName = coursePageObj.getContentNameFromPublishedBucket();

		// Step3:Search for the course
		createMentorPageObj.navigateToCourseAndSearch(contentName);

		// Step4:Verify share icon is available
		coursePageObj.verifyAvailabilityOfShareIcon();

		// Step5:Logout as public user
		userLogin.userLogout();

	}

}