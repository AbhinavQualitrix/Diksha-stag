package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyViewAllOptionUnderOpenForEnrollmentCourseCategory extends BaseTest
{
	//TC_555 and TC_556
	@Test(groups= {"newfeature","regression2"})
	public void verifyViewAllOptionUnderOpenForEnrollmentCourses() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		GenericFunctions genericMethods = new GenericFunctions();
		PublicUserPageObj publicUserPageObj = new PublicUserPageObj();
		
		//Login as Any USer
		signupObj.userLogin(CREATOR);
		
		//Click on Course Tab , Verify View all Under Open For Enrollment section
		workspacePageObj.verifyViewAllOptionInCourse();
		
		//Logout as User
		signupObj.userLogout();
	}
	

	

}
