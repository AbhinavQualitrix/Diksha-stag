package org.testscript.librarypage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class VerifyAvailabilityOfDeletedCollectionInLibrary extends BaseTest {
	@Test(groups= {"regression2","creator"})
	public void verifyAvailabilityOfDeletedCollectionInLibrary() throws Exception {

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
		String deletedContent = AllMyContentPageObj.deleteContent("COLLECTION");
		
		// search in the library
		AllMyContentPageObj.searchInLibrary(deletedContent);
		
		//Logout as Creator
		userLogin.userLogout();
	}
}