package org.testscript.profilepage;
	

import org.generic.ExtentTestManager;
import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyOrgAdminCanSearchUsersAndPublicUserCannotSearchUsers extends BaseTest 
{
	
	
	//SUN-1601-R

	@Test(groups = { "profile", "regression1" })
	public void toVerifyOrgAdminWithUser() throws Exception {

		SignUpPageObj userLogin = new SignUpPageObj();
		ProfilePageObj profilePageObj = new ProfilePageObj();

		
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO,
	  			"User is trying to verifying SUN-1601");
		
       // Step1:Login as Admin
		userLogin.userLogin(ADMIN);

		// Step2:
		profilePageObj.toCheckOrgAdminForUser();

	    // Step3:Logout as admin
		userLogin.userLogout();

		// Step4:Login as Public user
		userLogin.userLogin(TENANTORGADMIN);

		// Step5:Enter qr code and consume content
		profilePageObj.toCheckTenantOrgAdminForUser();

		// Step6:Logout as public user
		userLogin.userLogout();
		

		// Step7:Login as Public user
		userLogin.userLogin(PUBLICUSER1);

		// Step8:Enter qr code and consume content
		profilePageObj.toCheckContentByUser();

		// Step9:Logout as public user
		userLogin.userLogout();
		

	}
}

