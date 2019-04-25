package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyUserIsAbleToViewEditSearchAndDeleteTheNotes extends BaseTest
{
	//SUN-1501, SUN-1502, SUN-1503, SUN-1504
	@Test(groups= {"regression1","coursepage"})
	public void verifyViewEditSearchDeletingOfNotes() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		WorkspacePageObj workspaceObj = new WorkspacePageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		
		//Login with valid credentials
		userLogin.userLogin(REVIEWER);
		
		//Open any Content where user is enrolled
		String url=workspaceObj.getContentFromMyCourses();
		
		//Verify user is able to view all created notes
		coursePageObj.verifyMyNoteBookSection();
		
		//Verify editing of created notes
		coursePageObj.verifyEditingOfCreatedNotes();
		
		//Verify searching of created notes
		coursePageObj.searchCreatedNotes();
	}
	

}
