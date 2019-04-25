/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 04/04/2019

 * Purpose: Check after enetering the data in take notes,if clicked on clear button ,all data should reset.

 */

package org.testscript.coursepage;




import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyClearOptionInAddNotesInCoursePage extends BaseTest {
	
	//SUN-1623
	@Test(groups = { "coursepage", "regression1"})
	public void verifyClearOptionInAddNotesInCoursePage() throws Exception {

		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1623");

		// Step1:Login as Public user
		userLogin.userLogin(MENTOR);

		// Step2:Enroll for the open batch
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		// Step3:Enroll for the open batch
		String contentName = coursePageObj.getContentNameFromPublishedBucket();

		// Step4:Logout as public user
		userLogin.userLogout();

		// Step5:Login as Public user
		userLogin.userLogin(REVIEWER);

		// Step6:Search for the course
		createMentorPageObj.navigateToCourseAndSearch(contentName);

		// Step7:add and clear the content in notes
		coursePageObj.checkclearOptionInTakeNotes();

		

	}
}
