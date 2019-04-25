package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;


import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;



public class VerifyAvailabilityOfDeletedCourseInLibrary extends BaseTest {
	@Test(groups= {"regression2","coursepage"})
	public void verifyAvailabilityOfDeletedCourseInLibrary() throws Exception {

		SignUpPageObj creator = new SignUpPageObj();
		AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
		SignUpPageObj userLogin = new SignUpPageObj();
		
		//Login as Creator
		creator.userLogin(CREATOR);
		
		// Click on workspace
		AllMyContentPageObj.clickWorkspace();
		
		// Click filter icon
		AllMyContentPageObj.allMyContent();
				
		// Delete published BOOK
		String deletedContent = AllMyContentPageObj.deleteContent("COURSE");
		
		// search in the library
		AllMyContentPageObj.searchInLibrary(deletedContent);
		
		//Logout as Creator
		userLogin.userLogout();
	}
}