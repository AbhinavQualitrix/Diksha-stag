package org.testscript.profilepage;

import org.generic.ExtentTestManager;
import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyUserProfileDashBoard extends BaseTest
{
	//SUN-1124
	@Test(priority=1, groups={"creator","sanity","regression2","smoke"})
	public void verifyUserProfileDashBoard() throws InterruptedException, Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		ProfilePageObj profilePage=new ProfilePageObj();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test Case SUN-1125");
		
		//Step1: Login as Any Credential
		creatorLogin.userLogin(ADMIN);
		
		//Step2:Navigate to User Profile DashBoard
		profilePage.verifyUserProfileDashBoard();
		
		//Logout as user
		creatorLogin.userLogout();
	}

}
