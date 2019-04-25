package org.testscript.librarypage;

import org.testng.annotations.Test;


import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;



public class VerifyAvailabilityOfDeletedContentInLibrary extends BaseTest {
	@Test(groups= {"regression2","creator"})
	public void verifyAvailabilityOfDeletedContentInLibrary() throws Exception {

		SignUpPageObj creator = new SignUpPageObj();
		AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
		SignUpPageObj userLogin = new SignUpPageObj();
		
		//Login as Creator
		creator.userLogin(CREATOR);
		
		// Click on workspace
		//CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
		AllMyContentPageObj.clickWorkspace();
		
		// Click filter icon
		AllMyContentPageObj.allMyContent();
				
		// Delete published BOOK
		String deletedContent = AllMyContentPageObj.deleteContent("CONTENT");
		
		// search in the library
		AllMyContentPageObj.searchInLibrary(deletedContent);
		
		//Logout as Creator
		userLogin.userLogout();
	}
}