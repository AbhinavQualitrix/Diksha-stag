/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/24/2018

* Purpose: Create course as Mentor and try to create open batch for it,public user should consume it,mentor can check the stats.

*/

package org.testscripts;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class ConsumeOpenCourseByPublicUser extends BaseTest
{
	@Test
	public void consumeOpenCourseByPublicUser() throws Exception
	{
		
		
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpObj userLogin = new SignUpObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	
		
		//Step1: Login as Mentor
		
		userLogin.userLoginDiksha(CREATOR);
		
		
		//Step2: Navigate to WorkSpace
		
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		
		//Step3: Create new Course
		
		creatorUserPageObj.createCourseForOpenBatch(objListOFTestDataForSunbird);
		
		
		//Step4: Save and Send for Review
		
		creatorUserPageObj.saveAndSendCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(2000);
		//GenericFunctions.refreshWebPage();
	
		
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);

		
		//Step6: Logout as Mentor
		
		userLogin.userLogout();
		GenericFunctions.waitWebDriver(3000);
		
		
		//Step7: Login as Reviewer
		
		userLogin.userLoginDiksha(REVIEWER);
		
		
		//Step8: Search the course which was submitted for review
		
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReviewForOpenbatch(COURSE,objListOFTestDataForSunbird);
		
		
		//Step9:Publish the Course
		
		creatorUserPageObj.publishAndSearchForOpenBatch(COURSE,objListOFTestDataForSunbird);
		
		
		//Step10: Logout as Reviewer		
		
		userLogin.userLogout();	
		
		
		//Step11:Login as Mentor
		
		userLogin.userLoginDiksha(CREATOR);
		
		
		//Step12:Search the course created by same user
		
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		
		//Sttep13:create invite only batch
		
		createMentorPageObj.createOpenBatch();
		
		
		//Step14:Logout as Mentor
		
		userLogin.userLogout();	
		GenericFunctions.waitWebDriver(3000);
		
		
		//Step15:Login as Public user
		
		userLogin.userLoginDiksha(PUBLICUSERS_S);
		
		
		//Step16:Search for the course
		
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		
		//Step17:Enroll for the open batch
		
		createMentorPageObj.enrollForOpenBatch();
		GenericFunctions.waitWebDriver(3000);
		
		
		
		//Step18:Logout as public user
		
		userLogin.userLogout();	
		GenericFunctions.waitWebDriver(2000);
		
		
		//Step19:Login as Mentor
		
		userLogin.userLoginDiksha(CREATOR);
		
		
		//Step20:Search the course and check the stats
		
		
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		createMentorPageObj.viewCourseStats();
		
		//Step21:Logout as Mentor
		
		userLogin.userLogout();
				
		
		
		
		
		
		
	}
	
	
}
