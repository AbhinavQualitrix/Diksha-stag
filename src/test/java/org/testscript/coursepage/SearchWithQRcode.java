package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;


public class SearchWithQRcode extends BaseTest
{


	//SUN-1635, SUN-2063,SUN-2067

	@Test(groups= {"regression1","publicuser"})

	public void searchWithQRcode() throws Exception
	{	
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUserPageObj = new PublicUserPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1635/SUN-2063/SUN-2067");
		
		//Login as Content creator
		userLogin.userLogin(PUBLICUSER1);

		//Enter QR code and search
		publicUserPageObj.searchWithQRcode();
		
		//User sign out
		userLogin.userLogout();
	}

}







