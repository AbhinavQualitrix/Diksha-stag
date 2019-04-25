/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 08/03/2018

* Purpose: Create Lesson plan as creator and publish as reviewer and consume as Public user.

*/
package org.testscript.librarypage;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;



@Test(groups={"creator","regression2","smoke"})
public class SearchForTheLatestUpdatedlessonplan extends BaseTest {	
	
	
	public void searchForTheLatestUpdatedlessonplan() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		//Step1: Login as Creator
		
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		
		creatorUserPageObj.navigateToWorkspace(LESSONPLAN);
		
		//Step3: Create new Lesson Plan
		creatorUserPageObj.createNewLessonPlan(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		
		creatorUserPageObj.saveAndSendNewLessonPlanForReview();
		GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(LESSONPLAN,objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(LESSONPLAN,objListOFTestDataForSunbird);
		
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.LessonPlanPublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		

		//Step 7: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step 8: Navigate to WorkSpace-All my content
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 9: Delete the Created item
		String newResourceAdded =  creatorUserPageObj.updateTheContentAndSendForReview();

		//Step10: Search the course with Name
		createMentorPageObj.navigateToLibraryAndSearchForBook();

		//Step 11: Search for the latest updated content in library
		creatorUserPageObj.verifyTheNonAvailabilityOfAddedResource(newResourceAdded);

		//Step 12: Logout as Creator
		creatorLogin.userLogout();
		
	}

}
