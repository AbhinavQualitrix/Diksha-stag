/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 08/01/2018

* Purpose: Create Collection as creator and publish as reviewer and consume as Public user.

*/
package org.testscripts;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class CreateCollectionAndVerify extends BaseTest {
	
	@Test
	public void createCollectionAndVerify() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		SignUpObj creatorLogin = new SignUpObj();
		
		//Step1: Login as Creator
		
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step2: Navigate to WorkSpace
		
		creatorUserPageObj.navigateToWorkspace(COLLECTION);
		
		//Step3: Create new Course
		creatorUserPageObj.createCollection(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		
		creatorUserPageObj.saveAndSendCourseForReviewAfterEdit(objListOFTestDataForSunbird);
		//GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COLLECTION,objListOFTestDataForSunbird);
		

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLoginDiksha(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(COLLECTION,objListOFTestDataForSunbird);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.CoursePublishAndSearch(objListOFTestDataForSunbird);
		System.out.println("Created - "+objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./collectionNumbers.txt"));
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		
		
		//Step11: Login as Public User
		creatorLogin.userLoginDiksha(PUBLICUSERS_S);

		//Step12: Search the course with Name
		GenericFunctions.waitWebDriver(2000);
		createMentorPageObj.navigateToLibraryAndSearchForCollection();

		//Step 13: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step14: Login as Creator
		creatorLogin.userLoginDiksha(CREATOR);

		//Step15: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step16: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step17: Logout as Creator
		creatorLogin.userLogout();
		
	}

}