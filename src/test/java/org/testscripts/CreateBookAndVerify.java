/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 08/02/2018

* Purpose: Create Book as creator and publish as reviewer and consume as Public user.

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

public class CreateBookAndVerify extends BaseTest {
	
	@Test
	public void createBookAndVerify() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		
		//Step1: Login as Creator
		SignUpObj creatorLogin = new SignUpObj();
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step2: Navigate to WorkSpace
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step3: Create new Course
		creatorUserPageObj.createNewBook(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendNewBookForReview();
		
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(BOOK,objListOFTestDataForSunbird);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLoginDiksha(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReview(BOOK,objListOFTestDataForSunbird);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.BookPublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		
		
		//Step11: Login as Public User
		creatorLogin.userLoginDiksha(PUBLICUSERS_S);

		//Step12: Search the course with Name
		createMentorPageObj.navigateToLibraryAndSearchForBook();

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