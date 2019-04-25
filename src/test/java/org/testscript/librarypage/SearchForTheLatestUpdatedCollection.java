package org.testscript.librarypage;


import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class SearchForTheLatestUpdatedCollection  extends BaseTest {

	@Test(groups= {"librarypage", "regression2"})
	public void searchForTheLatestUpdatedCollection() throws Exception
	{
		
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericFunctions = new GenericFunctions();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step2: Navigate to WorkSpace,create new Collection,save and send for review.
		creatorUserPageObj.createCollection();
		GenericFunctions.refreshWebPage();

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		creatorUserPageObj.goToWorkspaceForCollection("collection");
		
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


