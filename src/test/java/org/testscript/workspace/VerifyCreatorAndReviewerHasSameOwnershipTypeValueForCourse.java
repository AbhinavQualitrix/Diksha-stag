package org.testscript.workspace;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class VerifyCreatorAndReviewerHasSameOwnershipTypeValueForCourse extends BaseTest
{
	//TC_630
	@Test(groups= {"newfeature","regression1"})
	public void verifyCreatorAndReviewerHasSameOwnershipTypeValueForCourse() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step 2 : navigate to workspace to create COURSE
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step 3 : Create Course
		String courseName=creatorUserPageObj.createCourse(objListOFTestDataForSunbird);

		//Step 4 : Save and Send for Review
		String selectedOwnershipValue=creatorUserPageObj.saveAndSendNewCourseForReview(objListOFTestDataForSunbird);

		//Step 5 : Logout as Creator
		signupObj.userLogout();

		//Step 6 : Login as Content Creator
		signupObj.userLogin(REVIEWER);

		//Step 7 : Navigate to Up For Review
		genericMethods.navigateToWorkspaceFeatures(UP_FOR_REVIEW);

		//Step 5 : Click  and open the created content from Up For Review section
		workspacePageObj.openTheCreatedContentFromUpForReview(courseName);

		//Step 6 :  Check the OWNERSHIP field value
		workspacePageObj.verifyownershipTypeValueOfTheContent(null,selectedOwnershipValue);

		//Step 7 :Logout as Reviewer
		signupObj.userLogout();

	}
}


