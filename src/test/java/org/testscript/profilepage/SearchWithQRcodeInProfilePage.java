package org.testscript.profilepage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;


public class SearchWithQRcodeInProfilePage extends BaseTest
{
	//SUN-1590
	@Test(groups= {"regression2","publicuser"})
	public void searchWithQRcodeInProfilePage() throws Exception
	{	
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUserPageObj = new PublicUserPageObj();
		CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1590");
		
		//Login as Content creator
		userLogin.userLogin(PUBLICUSER1);
		
		//Go to Profile page
		createUserPageObj.goToProfilePage();

		//Enter QR code and search
		publicUserPageObj.searchWithQRcode();
		
		//User sign out
		userLogin.userLogout();
	}

}







