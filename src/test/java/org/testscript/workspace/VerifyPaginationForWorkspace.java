package org.testscript.workspace;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.generic.TestListener.class)

public class VerifyPaginationForWorkspace extends BaseTest {
	
	@Test(groups= {"mentor","regression"})
	
	public void verifyPaginationForWorkspace() throws InterruptedException, Exception{
		
		
		SignUpPageObj userLogin = new SignUpPageObj();	
		WorkspacePageObj workspacePageObj=new WorkspacePageObj();
		
		
		//Step1 : Login as Mentor 
		userLogin.userLogin(MENTOR);
		
		
		//Step2 : Verify Batch Updation
		workspacePageObj.verifyingPagination();
		
		//Step3 : Logout as Mentor
		userLogin.userLogout();
				
				
	}
	

}
