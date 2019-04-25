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

public class AddNotesToContentInLibraryAndSearch extends BaseTest {
	
	//SUN-1615(need to check once)
	@Test(groups = { "mentor", "regression1" })
	public void addNotesToContentInLibraryAndSearch() throws Exception {


		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1615");
		

		// Step1:Login as Public user
		userLogin.userLogin(REVIEWER);

		// Step2:Navigate to library and click first content
		creatorUserPageObj.navigateToLibraryAndclickFirstContent();

		// Step3:Add notes and save it
		coursePageObj.takeNoteOptionAvailable(objListOFTestDataForSunbird);

		// Step4:Verify the added content in view all section
		String notesName = coursePageObj.verifyNotesinViewAll(objListOFTestDataForSunbird);

		// Step5:search the notes and verify it.
		coursePageObj.searchTheCreatedNote(notesName);

		// Step6:Logout as public user
		userLogin.userLogout();

	}
}
