package org.testscript.workspace;

import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class UploadContentWithInvalidExternalUrl extends BaseTest
{
	//SUN-1526
	@Test(groups= {"regression2","workspace"})
	public void verifyIncorrectExternalUrlIsNotAccepted() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		
		
		//Login As Content Creator
		userLogin.userLogin(CREATOR);
		
		//Navigate to Workspace and upload content
		createUserPageObj.navigateToWorkspace(UPLOADCONTENT);
		
		//To verify uploading an youtube content with External Invalid Url
		workspacePageObj.uploadContentWithInvalidUrl();
	}

}
