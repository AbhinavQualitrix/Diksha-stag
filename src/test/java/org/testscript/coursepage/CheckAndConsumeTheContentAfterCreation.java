/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Abhinav kumar singh
 * Date: 25 Mar 2019
 * Purpose: Create a New Course and validate it
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


public class CheckAndConsumeTheContentAfterCreation extends BaseTest
{
	//SUN-2202
	@Test(priority=1, groups={"coursepage","regression1"})
	public void checkAndConsumeTheContentAfterCreation() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExplorePageobj explorePageObj = new ExplorePageobj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test Case SUN-2202");

		//Step1: Login as Creator
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

		//Step14:Open the application ,navigate to explore page
		explorePageObj.checkInTOCAndConsume();

		//Step15:Logout as Reviewer
		creatorLogin.userLogout();

		//Step16: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step17: Navigate to WorkSpace-All my content
		creatorUserPageObj.navigateToWorkspace(ALL_MY_CONTENT);
		
		//Step18: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step19: Logout as Creator
		creatorLogin.userLogout();
		 
	




	
		
			
		
	}

}