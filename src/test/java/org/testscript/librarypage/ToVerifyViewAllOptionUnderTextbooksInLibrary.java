package org.testscript.librarypage;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ToVerifyViewAllOptionUnderTextbooksInLibrary  extends BaseTest
{
	//TC_558 and TC_559
	@Test(groups= {"newfeature","regression2"})
	public void verifyViewAllOptionUnderTextbooksSectionInLibraryPage() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		
		//Login as Any USer
		signupObj.userLogin(CREATOR);
		
		//Click on Header Library , Verify view all option Under textbooks
		workspacePageObj.verifyViewAllOptionUnderTextbooksInLibrary();
		
		//Logout as User
		signupObj.userLogout();
	}

}
