package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyUserIsAbleToClearAllNotesTaken extends BaseTest 
{	
	//SUN-1500
	@Test(groups= {"regression1","coursepage"})
	public void verifyUserIsAbleToClearAllNotesTaken() throws Exception
	{
		
		SignUpPageObj userLogin = new SignUpPageObj();
		WorkspacePageObj workspaceObj = new WorkspacePageObj();
		
		//Login as user who is enrolled 
		userLogin.userLogin(PUBLICUSER1);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1500");
		
		//Open any Content where user is enrolled
		String url=workspaceObj.getContentFromMyCourses();
		
		//Verify Take Note Option for content
		workspaceObj.verifyNotesOptionInContent(url);
	}
	

}
