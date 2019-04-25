package org.testscript.workspace;

import org.generic.ExtentTestManager;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class StateFrameworkVerification extends BaseTest
{
	//SUN1667
	@Test(groups= {"CreatorRJ","regression"})
	public void stateFrameworkVerification() throws InterruptedException, Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		WorkspacePageObj workspaceobj=new WorkspacePageObj();
		CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
		
		//step1:Login As RJ Framework Creator
		userLogin.userLogin(CREATORRJ);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User is verifying : SUN-1667");
				
		createUserPageObj.navigateToWorkspace(UPLOADCONTENT);
		
		//step2:Navigate Workspace
		workspaceobj.stateFramework(MP4);
		
		//step3:Verify State from RJ Framework
		workspaceobj.stateFrameworkVeification("State (Uttar Pradesh)");
		
		//step4:Logout
		//userLogin.userLogout();
	}
	

}
