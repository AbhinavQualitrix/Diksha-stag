/*
 * 
 */
package org.testscript.workspace;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;

public class VerifySortByInAllMyContentForCreator extends BaseTest 
{

	//SUN-1529
	@Test(groups={"workspace","regression2"})
	public void verifyContentIsSortedAsPerTheAppliedFilter() throws Exception {

		SignUpPageObj userLogin = new SignUpPageObj();
		AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
		GenericFunctions genericFunctions = new GenericFunctions();
		
		//Login As Content Creator
		userLogin.userLogin(CREATOR);

		//Navigate to All My Content in Workspace
		genericFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1529");

		// Click on allMyContent and select sortBy dropdown options and verify contents
		AllMyContentPageObj.allMyContentSortByDropdown();
		
	}
}
