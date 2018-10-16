/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 09/26/2018

* Purpose: Create Resource as creator and publish as reviewer.

*/
package org.testscripts;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CreateAllResource extends BaseTest {
	
	@Test
	public void createResourceAndVerify() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpObj creatorLogin = new SignUpObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step3: Create new Resource
		creatorUserPageObj.createResourceWithoutSave(objListOFTestDataForSunbird);
		
		//Step4: Create new Question
		creatorUserPageObj.createQuestionAndSave(objListOFTestDataForSunbird);
		
		//Step5: Create new Question
		creatorUserPageObj.createQuestionMCQWithoutSave(objListOFTestDataForSunbird);
		
		//Step6: Create new Question
		creatorUserPageObj.createQuestionFITBWithoutSave(objListOFTestDataForSunbird);
		
		//Step7: Create new Question
		creatorUserPageObj.createQuestionMTFWithoutSave(objListOFTestDataForSunbird);
		
		//Step8: Save and send resource for review
		creatorUserPageObj.saveAndSendResouceForReview();
		//GenericFunctions.refreshWebPage();
			
		//Step9: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);

		//Step10: Logout as Creator
		creatorLogin.userLogout();
		
		//Step11: Login as Reviewer
		creatorLogin.userLoginDiksha(REVIEWER);
		
		//Step12: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		
		//Step13:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step14: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step15: Login as Creator
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step16: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
				
		//Step17: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();
		
		//Step18: Logout as Creator
		creatorLogin.userLogout();
		
		
		
	}

}