package org.testscript.workspace;

import org.generic.GenericFunctions;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyMentorFromAnySubOrgCanSearchMembersOnlyFromRespectiveSubOrg extends BaseTest 
{

	//TC_593
	@Test(groups= {"newfeature","regression"})
	public void verifyMentorFromAnySubOrgCanSearchMembersOnlyFromRespectiveSubOrg() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		GenericFunctions genericMethods = new GenericFunctions();
		PublicUserPageObj publicUserPageObj = new PublicUserPageObj();
		
		
		//Login As Creator
		signupObj.userLogin(CREATOR);
		
		//Navigate to Course Section and search for any course
		
		
	}//NEED TO BE TAKEN LATER


}
