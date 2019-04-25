package org.testscript.profilepage;

import org.page.ProfilePage;
import org.pageobjects.ProfilePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyAssigningMultipleRolestoSameUser extends BaseTest{
	
	@Test(groups= {"admin","regression1"})
	public void verifyAssigningMultipleRolestoSameUser() throws InterruptedException, Exception  
	{
		
		
		
		SignUpPageObj userLogin = new SignUpPageObj();
		ProfilePageObj profilePage=new ProfilePageObj();
		
		//Step1: Login as Admin
		userLogin.userLogin(ADMIN);
	
		
		//Step2: Assign multiple roles to same user
		profilePage.verifyAssigningMultipleRolesToUser();
		
		//Step3:  Remove existing roles of user
		profilePage.verifyRemovalOfExistingRole();
		
		//Step4 : Logout as admin
		userLogin.userLogout();
		
		
		
		
		
		
	}

}
