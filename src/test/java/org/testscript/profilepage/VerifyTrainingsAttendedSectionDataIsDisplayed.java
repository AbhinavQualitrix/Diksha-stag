package org.testscript.profilepage;

import org.generic.ExtentTestManager;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.LibraryPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyTrainingsAttendedSectionDataIsDisplayed extends BaseTest
{
	//SUN-2855
	@Test(groups= {"regression2","profilepage"})
	public void verifyTrainingsAttendedSectionDataIsCorrectlyDisplayed() throws  Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
		LibraryPageObj libraryPageObj = new LibraryPageObj();
		
		//Login as Any User
		userLogin.userLogin(PUBLICUSER1);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-2855");
		//Go to Profile page
		createUserPageObj.goToProfilePage();
		
		//Check the Training Attended Section and verify all completed course batches are available in the list
		libraryPageObj.verifyTrainingsAttendedSection();
	}


}
