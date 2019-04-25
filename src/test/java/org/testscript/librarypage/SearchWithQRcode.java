package org.testscript.librarypage;

import org.testng.annotations.Test;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;


public class SearchWithQRcode extends BaseTest
{
	
	@Test(groups= {"regression2","publicuser"})
	public void searchWithQRcode() throws Exception
	{	
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUserPageObj = new PublicUserPageObj();
		//Login as Content creator
		userLogin.userLogin(PUBLICUSER1);

		//Enter QR code and search
		publicUserPageObj.searchWithQRcode();
		
		//User sign out
		userLogin.userLogout();
	}

}







