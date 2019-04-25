package org.testscript.workspace;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ContentValidationInUpForReviewSearchWithFilter extends BaseTest
{
	//92_93_94_96a_b
	@Test(groups= {"reviewer","regression2"})
	public void contentValidationInUpForReviewSearchWithFilter() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		GenericFunctions genericnFunctions = new GenericFunctions();
		
		//Login as Content creator
		userLogin.userLogin(REVIEWER);

		//Navigate to workspace to create Resource
		//creatorUserPageObj.navigateToWorkspace(RESOURCE);
		genericnFunctions.navigateToWorkspaceFeatures(UP_FOR_REVIEW);
		
		//Click on Up for review and search and verify contents 
		contentReourcePageObj.validateUpForReivew();

		//Click on Up for review verify contents based Applied
		contentReourcePageObj.contentFilterApply_Reset();
		
		//Verify the Resetting of applied filters and the contents
		contentReourcePageObj.resetAppliedFilters();
		
		//Logout as Reviewer
		userLogin.userLogout();
	}

}
