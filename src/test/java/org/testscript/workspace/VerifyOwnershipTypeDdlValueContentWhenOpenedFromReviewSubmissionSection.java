package org.testscript.workspace;

import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyOwnershipTypeDdlValueContentWhenOpenedFromReviewSubmissionSection extends BaseTest 
{
	//TC_639
	@Test(groups= {"newfeature","regression1"})
	public void verifyOwnershipTypeDdlValueContentWhenOpenedFromReviewSubmissionSection() throws  Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);
		
		
		 	
	}

}
