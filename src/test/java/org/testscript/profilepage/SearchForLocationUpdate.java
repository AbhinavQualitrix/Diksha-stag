package org.testscript.profilepage;

import org.generic.ExtentTestManager;
import org.pageobjects.ProfilePageObj;
//import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SearchForLocationUpdate extends BaseTest
{
	//SUN-1676
	@Test(groups= {"regression1"})
	public void searchForLocationUpdate() throws InterruptedException, Exception
	{

		SignUpPageObj userLogin = new SignUpPageObj();
		ProfilePageObj profilePageObj=new ProfilePageObj();

		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1676");

		//Step1:Login as State Tenant 
		userLogin.userLogin(STATE_TENANT);

		//Step2:Go to Profile
		profilePageObj.verifyLocationOption();

		//Step 3:Logout as creator
		userLogin.userLogout();
	}

}
