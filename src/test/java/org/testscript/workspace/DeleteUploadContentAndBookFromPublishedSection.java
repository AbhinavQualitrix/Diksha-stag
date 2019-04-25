package org.testscript.workspace;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class DeleteUploadContentAndBookFromPublishedSection extends BaseTest 
{
	//SUN-1536, SUN-1535
	@Test(groups= {"regression2","workspace"})
	public void deleteUploadContentAndBookFromPublishedSection() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		WorkspacePageObj workspaceObj = new WorkspacePageObj();
		GenericFunctions genericFunctions = new GenericFunctions();
		
		//Login as Content Creator
		userLogin.userLogin(CREATOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1536 and SUN-1535");
		
		//Navigate to Published Section
		genericFunctions.navigateToWorkspaceFeatures(PUBLISHED);
		
		//Delete upload content and verify 
		workspaceObj.findUploadContentFromPublishedSection(CONTENT_NAME[1]);
		
		//Navigate to Published Section
		genericFunctions.navigateToWorkspaceFeatures(PUBLISHED);
		
		//Delete upload content and verify 
		workspaceObj.findUploadContentFromPublishedSection(CONTENT_NAME[0]);
	}

}
