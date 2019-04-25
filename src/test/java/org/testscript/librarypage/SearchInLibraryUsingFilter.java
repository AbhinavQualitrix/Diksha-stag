/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/22/2018
* Purpose: To verify Library search - with filter
*/

package org.testscript.librarypage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import org.generic.ExtentTestManager;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;


public class SearchInLibraryUsingFilter extends BaseTest
{
	//SUN-1603
	@Test(groups= {"librarypage","regression2"})
	public void searchInLibraryUsingFilter() throws Exception
	{	
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1603");
		//Step 1 : Login in as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step 2 : Click on library
		//Click on filters
		publicUser.librarysearchFilter();
		
		//Step 3 :Logout as Public user
		userLogin.userLogout();
	}

}
