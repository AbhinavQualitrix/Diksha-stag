package org.testscript.coursepage;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
  

public class OpenBatchCreationBySubOrg extends BaseTest {
	
	
	

	@Test(groups= {"coursepage","regression1"})
	public void openBatchCreationBySubOrg() throws Exception
	{

	List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
	objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

	SignUpPageObj creatorLogin = new SignUpPageObj();
	CreateMentorPageObj createMentorPageObj= new CreateMentorPageObj();
	CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();


	//Step1: Login as Creator
	creatorLogin.userLogin(SUBORGMENTOR);
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1538");

	//Step2: Navigate to WorkSpace
	creatorUserPageObj.navigateToWorkspace(COURSE);

	//Step3: Create new Course
	String createdCourse=creatorUserPageObj.createCourseForOpenBatch(objListOFTestDataForSunbird);

	//Step4: Save and Send for Review
	creatorUserPageObj.saveAndSendNewCourseForReview(objListOFTestDataForSunbird);

	//Step5: Check for course in review submissions 
	creatorUserPageObj.reviewInSubmissions(createdCourse,objListOFTestDataForSunbird);

	//Step6: Logout as Creator
	creatorLogin.userLogout();

	//Step7: Login as Reviewer
	creatorLogin.userLogin(BOOKREVIEWER);

	//Step8: Search the course which was submitted for review
	creatorUserPageObj.searchInUpForReviewForOpenbatch(COURSE,objListOFTestDataForSunbird);

	//Step9:Publish the Course
	creatorUserPageObj.publishAndSearch(COURSE, objListOFTestDataForSunbird);

	// Logout as Reviewer
	creatorLogin.userLogout();

	//Login as Course mentor
	creatorLogin.userLogin(SUBORGMENTOR);

	//Step11: Search the course with Name
	GenericFunctions.waitWebDriver(2000);
	createMentorPageObj.navigateToCourseAndSearchForOpenBatch();

	// Now as course mentor search for the created course on Course page
	//Step13:create open  batch
	createMentorPageObj.createOpenBatch();

	//Step14:Logout as Mentor
	creatorLogin.userLogout();	
	}
}
