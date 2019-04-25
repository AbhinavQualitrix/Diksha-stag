/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Abhinav kumar singh
 * Date: 03/14/2019
 * Purpose:  Upload the Content type - Epub ,update it from published section  and send for reviewa.Search the content,updated changes should be there.
 */

package org.testscript.librarypage;


import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class SearchForTheLatestUpdatedBook extends BaseTest
{
	@Test(groups={"librarypage","regression2"})//(priority=4, 
	public void searchForTheLatestUpdatedBook() throws Exception
	{
		
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		GenericFunctions genericFunctions = new GenericFunctions();
		
		//Step1: Login as Creator
		
		creatorLogin.userLogin(BOOKCREATOR);
		
		//Step2: Navigate to WorkSpace
		
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step3: Create new book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendBookForReview(objListOFTestDataForSunbird);
		
		GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(BOOK,objListOFTestDataForSunbird);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(BOOKREVIEWER);
		
		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReview(BOOK,objListOFTestDataForSunbird);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.publishAndSearch(BOOK,objListOFTestDataForSunbird);
		
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
