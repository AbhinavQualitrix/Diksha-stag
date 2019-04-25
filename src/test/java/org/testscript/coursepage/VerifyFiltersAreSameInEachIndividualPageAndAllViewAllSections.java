package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyFiltersAreSameInEachIndividualPageAndAllViewAllSections extends BaseTest 
{

	@Test(groups= {"newfeature","regression2"})
	public void verifyEveryViewAllSectionForAllThePagesAfterLogin() throws Exception	
	{

		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();


		//Login As Any User
		signupObj.userLogin(CREATOR);

		//Click on Course Section and verify View All For all the sections
		workspacePageObj.verifyViewAllForAllTheSectionsOfCoursePage();
		
		//Logout as Any User
		signupObj.userLogout();
		
	}
}

