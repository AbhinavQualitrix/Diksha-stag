package org.testscript.librarypage;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyInTextbooksListSearchTheContentAndApplyFilters extends BaseTest
{
	@Test(groups= {"newfeature","regression2"})
	public void verifyUserCanSearchAndApplyFiltersForTextbooksInLibrary() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		
		//Login as Any User
		signupObj.userLogin(CREATOR);
		
		
	}
}
