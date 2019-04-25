package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyCourseCanBeSharedAndUserCanAccessItViaSharedUrl extends BaseTest
{
	//SUN-1637
	@Test(groups= {"regression1","coursepage"})
	public void verifyCourseCanBeSharedViaUrl() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		
		//Login as Normal user
		userLogin.userLogin(PUBLICUSER1);
		
		//Share the course url
		String copiedUrl=coursePageObj.verifyCourseSharingViaUrl();
		
		//Open the copied link in different browser and verify
		coursePageObj.openTheCopiedLinkInDifferentBrowser(copiedUrl);
	}

}
