package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AnnouncementCreationsPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;


public class AccessOnAllPagesAfterLogin extends BaseTest
{
	//Maintenance Done- 09th nov
	@Test(groups= {"regression2","publicuser"})
	public void verify_PageAccessOnLogin() throws Exception
	{	
		SignUpPageObj userLogin = new SignUpPageObj();
		AnnouncementCreationsPageObj announcementCreationPageObj = new AnnouncementCreationsPageObj();
		
		
		//Login as Content creator
		userLogin.userLogin(CREATOR);

		//Navigate to Course page
		announcementCreationPageObj.navigateToCoursePage();
		
		//Navigate to Library page
		announcementCreationPageObj.navigateToLibraryPage();
		
		//Navigate to Profile page
		announcementCreationPageObj.navigateToProfilePage();
		
		//User sign out
		userLogin.userLogout();
	}

}







