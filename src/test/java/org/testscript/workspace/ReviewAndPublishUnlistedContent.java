package org.testscript.workspace;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ReviewAndPublishUnlistedContent extends BaseTest 
{
	// SUN-1863
	@Test(groups= {"regression2","workspace"})
	public void reviewAndPublishUnlistedContent() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		WorkspacePageObj workspaceObj = new WorkspacePageObj();
		GenericFunctions genericFunctions = new GenericFunctions();
		
		//Login as Content Creator
		userLogin.userLogin(CREATOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1863");
		
		//Navigate to Published Section
		genericFunctions.navigateToWorkspaceFeatures(SHAREDVIALINK);
		
		
	}

}
