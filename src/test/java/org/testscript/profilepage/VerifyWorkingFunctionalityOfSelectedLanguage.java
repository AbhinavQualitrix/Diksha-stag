package org.testscript.profilepage;

import org.generic.ExtentTestManager;
import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyWorkingFunctionalityOfSelectedLanguage extends BaseTest
{
	//TC-SUN_1126
	@Test(groups= {"profilepage","regression1"})
	public void verifyWorkingFunctionalityOfSelectedLanguge() throws Exception
	{
		ProfilePageObj profilePage=new ProfilePageObj();
		SignUpPageObj userLogin = new SignUpPageObj();
		
		//Step1: Login as Public User
		
		userLogin.userLogin(PUBLICUSER1);
		ExtentTestManager.getTest().log(LogStatus.INFO,"User is verifying : SUN-1126");
		
		
		profilePage.languageVerify();
		
		
		
	}

}
