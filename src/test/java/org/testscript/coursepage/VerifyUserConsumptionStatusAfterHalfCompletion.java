/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Abhinav kumar singh
 * Date: 30 Mar 2019
 * Purpose: Create a New Course with 4 resources and invite only batch for it.As invited member check the course resume from where left.
 */


package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import java.util.List;
import org.generic.ExtentTestManager;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CoursePageObj;

import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.ExplorePageobj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;


public class VerifyUserConsumptionStatusAfterHalfCompletion extends BaseTest
{
	//SUN-1620
	@Test(priority=1, groups={"coursepage","regression1"})
	public void verifyUserConsumptionStatusAfterHalfCompletion() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExplorePageobj explorePageObj = new ExplorePageobj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test Case SUN-1620");

		/*//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step3: Create new Course
		coursePageObj.createCourseForOpenBatchWithResourcesFromDifferentContributors(objListOFTestDataForSunbird);

		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendNewCourseForReview(objListOFTestDataForSunbird);

		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		//Step6: Logout as Creator
		creatorLogin.userLogout();

		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReviewForOpenbatch(COURSE,objListOFTestDataForSunbird);

		//Step9: Publish the Course
		creatorUserPageObj.publishAndSearch(COURSE, objListOFTestDataForSunbird);

		//Step10: Logout as Reviewer
		creatorLogin.userLogout();

		//Step11: Login as Public User
		creatorLogin.userLogin(MENTOR);

		//Step12:Open the application ,navigate to explore page
		explorePageObj.navigateToCourseAndSearchForOpenBatch();

		//Step13: create an open Ongoing batch with start date only.
		coursePageObj.createInviteOnlyBatch();

		//Step14:Logout as Reviewer
		creatorLogin.userLogout();
*/
		//Step15: Login as Public User
		creatorLogin.userLogin(REVIEWER);

		//Step16:Open the application ,navigate to explore page
		explorePageObj.navigateToCourseAndSearchForOpenBatch();

		//Step17:Open the application ,navigate to explore page
		explorePageObj.checkInTOCAndConsume();

		//Step18:Open the application ,navigate to explore page
		coursePageObj.resumeTheCourseAfterHalfconsumptionAndVerify();

		//Step19:Logout as Reviewer
		creatorLogin.userLogout();

		//Step20: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step21: Navigate to WorkSpace-All my content
		creatorUserPageObj.navigateToWorkspace(ALL_MY_CONTENT);

		//Step22: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step23: Logout as Creator
		creatorLogin.userLogout();










	}

}