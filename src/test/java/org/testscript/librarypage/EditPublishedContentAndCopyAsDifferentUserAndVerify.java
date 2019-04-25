/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 04/05/2019

 * Purpose: Open a published Content,edit it and open the same content as a different user,copy it.Only live content should get copied.

 */

package org.testscript.librarypage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.LibraryPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;

public class EditPublishedContentAndCopyAsDifferentUserAndVerify extends BaseTest {

	//SUN-1618:Blocked
	@Test(groups = { "libraryPage", "regression2"})
	public void editPublishedContentAndCopyAsDifferentUserAndVerify() throws Exception {

		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		LibraryPageObj libraryPageObj = new LibraryPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1618");
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
		
		//Step3: Navigate to All my activity and Search
		creatorUserPageObj.navigateToAllMyContentAndSearch(objListOFTestDataForSunbird,BOOK);
		
		//Step4: Create new Book
		String contentName = creatorUserPageObj.editBook();
		
		//Step5: Save and send resource for review
		creatorUserPageObj.saveAndSendEdittedBookForReview();
		
		//Step6: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(BOOK,objListOFTestDataForSunbird);

		//Step7: Logout as Creator
		creatorLogin.userLogout();

		// Step5:Login as Public user
		creatorLogin.userLogin(MENTOR);

		// Step6:Search for the content
		creatorUserPageObj.navigateToLibraryAndSearchContent(contentName);

		// Step7:Verify share icon is available(needs to validate:blocked due to issue)
		libraryPageObj.copyContentAndVerify(contentName);

		// Step8:Logout as public user
		creatorLogin.userLogout();

	}

}