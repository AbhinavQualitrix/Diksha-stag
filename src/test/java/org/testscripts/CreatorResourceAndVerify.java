/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/31/2018

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

public class CreatorResourceAndVerify extends BaseTest {
	
	@Test
	public void creatorResourceAndVerify() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpObj creatorLogin = new SignUpObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step3: Create new Course
		creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendResouceForReview();
		//GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLoginDiksha(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step11: Login as Creator
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step12: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
				
		//Step13: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();
		
		//Step14: Logout as Creator
		creatorLogin.userLogout();
		
		
		
	}

}