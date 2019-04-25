package org.testscript.profilepage;

import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class VerifyThatUserIsAbleUpdateLocationData extends BaseTest {


	@Test(groups= {"custordianuser","regression"})
	
	public void verifyThatUserIsAbleUpdateLocationData () throws InterruptedException, Exception {
	
		SignUpPageObj userLogin = new SignUpPageObj();
		ProfilePageObj profilePageObj=new ProfilePageObj();
		
		//Step1: Login as Custordian
		userLogin.userLogin(CUSTODIANUSER);
		
		//Step2 : Verify updating location data
		profilePageObj.verifyLocationUpdateForUser();
		
		//Step: Logout as  Custordian
		userLogin.userLogout();
		

	}
	
	
}
