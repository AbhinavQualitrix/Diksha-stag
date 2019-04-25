package org.testscript.explorecoursepage;

import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyUserRedirectionToLoginPage extends BaseTest
{
	@Test(groups= {"newfeature","regression2"})
	public void verifyUserNavigationToLoginPage()
	{
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		
		//Click on Sign-In link and verify user redirection
		workspacePageObj.verifyUserRedirectsToLoginPageFromExploreCourse();
		
	}

}
