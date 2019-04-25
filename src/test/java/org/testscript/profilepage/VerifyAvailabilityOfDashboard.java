package org.testscript.profilepage;

import org.generic.ExtentTestManager;
import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;

import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyAvailabilityOfDashboard extends BaseTest
{
	@Test(groups= {"admin","regression2","profilepage"})
	public void verifyAvailabilityOfDashboard() throws Exception {
		
		SignUpPageObj userLogin = new SignUpPageObj();
		ProfilePageObj profilePageObj = new ProfilePageObj();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1123");
		
		//Login as Admin
		userLogin.userLogin(ADMIN);
		
		//Verify Admin DashBoard option for Admin
		profilePageObj.verifyDashboardOption();
		
		//Logout as Admin
		userLogin.userLogout();
		
		//Login as public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Verify Dashboard option for Public user
		profilePageObj.verifyDashboardOptionForPublicuser();
		
		//Logout as Public user
		userLogin.userLogout();
		
		
	
		
		}
	

}
