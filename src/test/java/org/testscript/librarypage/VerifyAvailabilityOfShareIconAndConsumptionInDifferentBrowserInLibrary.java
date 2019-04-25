/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 04/03/2019

 * Purpose: Open a published course and verify share icon is available.

 */

package org.testscript.librarypage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.LibraryPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;

public class VerifyAvailabilityOfShareIconAndConsumptionInDifferentBrowserInLibrary extends BaseTest {
	
	//SUN-1617(need to validate once)
	@Test(groups = { "librarypage", "regression2" })
	public void verifyAvailabilityOfShareIconAndConsumptionInDifferentBrowserInLibrary() throws Exception {

		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		LibraryPageObj libraryPageObj = new LibraryPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1617");
		
		// Step1:Login as Public user
		userLogin.userLogin(REVIEWER);

		// Step2:navigate to library and click on first content
		creatorUserPageObj.navigateToLibraryAndclickFirstContent();

		// Step3:Verify share icon is available
		 String contentName = coursePageObj.verifyAvailabilityOfShareIcon();
		
		// Step4:Share the content and play in other browser
		libraryPageObj.shareContentAndConsumeInDifferentBrowser(contentName);

		// Step5:Logout as public user
		userLogin.userLogout();

	}

}