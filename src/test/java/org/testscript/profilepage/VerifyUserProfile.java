package org.testscript.profilepage;


import org.generic.ExtentTestManager;
import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyUserProfile  extends BaseTest
{
	//SUN-1125
	@Test(priority=1, groups={"creator","sanity","regression2","smoke"})
	public void verifyUserProfile() throws InterruptedException, Exception
	{

		SignUpPageObj creatorLogin = new SignUpPageObj();
		ProfilePageObj profilePage=new ProfilePageObj();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test Case SUN-1125");
		
		//Step1: Login as Any Credential
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate To User Profile and verify profile information
		profilePage.verifyUserProfileInformation();
		
	}

}
