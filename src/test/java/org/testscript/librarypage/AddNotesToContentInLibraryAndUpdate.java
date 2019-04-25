/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 04/03/2019

 * Purpose: Create Notes in a course as invited member and try to verify it,and search it also.

 */

package org.testscript.librarypage;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class AddNotesToContentInLibraryAndUpdate extends BaseTest {

	// SUN-1614(need to check once)
	@Test(groups = { "mentor", "regression1" })
	public void addNotesToContentInLibraryAndUpdate() throws Exception {

		

		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1614");

		// Step1:Login as Public user
		userLogin.userLogin(REVIEWER);

		// Step2:Navigate to library and click first content
		creatorUserPageObj.navigateToLibraryAndclickFirstContent();

		// Step3:Add notes and save it
		coursePageObj.takeNoteOptionAvailable(objListOFTestDataForSunbird);
		
		// Step4:Verify the content in view all section
		String notesName = coursePageObj.verifyNotesinViewAll(objListOFTestDataForSunbird);

		// Step4:search the notes and verify it.
		coursePageObj.searchTheCreatedNote(notesName);

		// Step5:search the notes and verify it.
		coursePageObj.updateTheCreatedNote();

		// Step6:Verify the updated content in view all section
		coursePageObj.verifyUpdatedNotesinViewAll(objListOFTestDataForSunbird);

		// Step7:Logout as public user
		userLogin.userLogout();

	}
}
