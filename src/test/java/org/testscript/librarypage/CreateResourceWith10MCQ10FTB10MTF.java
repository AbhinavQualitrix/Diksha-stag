/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 03/21/2019

* Purpose: Create Question Set in Resource with 10 MCQ,10 FTB AND 10 MTF as creator and publish as reviewer.

*/
package org.testscript.librarypage;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.LibraryPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;


public class CreateResourceWith10MCQ10FTB10MTF extends BaseTest {
	
	@Test(groups={"creator","regression2","smoke"})
	public void createResourceWith10MCQ10FTB10MTF() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		LibraryPageObj libraryPageObj = new LibraryPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step3: Create new Course
		libraryPageObj.createQuestionsWith10MCQ10FTB10MTF(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendResouceForReview();
		//GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step11: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);

		//Step12: Search the course with Name
		libraryPageObj.navigateToLibraryAndSearchForResource();

		//Step 13: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step11: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step12: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step13: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step14: Logout as Creator
		creatorLogin.userLogout();
		
	}

}