/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date:  26 March 2019

* Purpose: 
*/

package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;


public class CreateAndVerifyTheBatchDetails extends BaseTest
{
	//SUN-2097
	@Test(groups={"coursepage","regression1"})
	public void createAndVerifyTheBatchDetails() throws Exception
	{
		
		
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		CoursePageObj coursePageObj=new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-2097");
	
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		
		//Step3: Create new Course
		creatorUserPageObj.createCourseForOpenBatch(objListOFTestDataForSunbird);
		
		
		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendNewCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.refreshWebPage();
	
		
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		
		//Step6: Logout as Mentor
		userLogin.userLogout();
		
		
		//Step7: Login as Reviewer
		userLogin.userLogin(REVIEWER);
		
		
		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReviewForOpenbatch(COURSE,objListOFTestDataForSunbird);
		
		
		//Step9:Publish the Course
		creatorUserPageObj.publishAndSearch(COURSE, objListOFTestDataForSunbird);
		
		
		//Step10: Logout as Reviewer		
		userLogin.userLogout();	
		
		
		//Step11:Login as Mentor
		userLogin.userLogin(MENTOR);
		
		
		//Step12:Search the course created by same user
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		
		//Sttep13:create open  batch
		createMentorPageObj.createOpenBatch();
		
		
		//Step14:Search for the course
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		
		//Step15:Enroll for the open batch
		createMentorPageObj.viewDetailsOfOpenBatch();
		
		//Step16 : Select a course batch from Ongoing Courses section and verify editing of Batch
		coursePageObj.verifyBatchDetailsFromOngoingCoursesSection();
		
		
		//Step17:Logout as public user
		userLogin.userLogout();	

		
		//Step18: Login as Creator
		userLogin.userLogin(MENTOR);

		//Step19: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step20: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step21: Logout as Creator
		userLogin.userLogout();
				
		
	
		
	}
	
	
}
