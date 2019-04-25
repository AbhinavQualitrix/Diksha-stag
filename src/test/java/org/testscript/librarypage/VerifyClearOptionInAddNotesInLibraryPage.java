/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 04/04/2019

 * Purpose: Check after enetering the data in take notes,if clicked on clear button ,all data should reset.

 */

package org.testscript.librarypage;




import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyClearOptionInAddNotesInLibraryPage extends BaseTest {
	
	//SUN-1612
	@Test(groups = { "mentor", "regression2", "sanity2" })
	public void verifyClearOptionInAddNotesInLibraryPage() throws Exception {

		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1612");

		
		// Step5:Login as Public user
		userLogin.userLogin(REVIEWER);

		// Step6:Navigate to library and click first content
		creatorUserPageObj.navigateToLibraryAndclickFirstContent();
		
		// Step7:add and clear the content in notes
		coursePageObj.checkclearOptionInTakeNotes();

		// Step10:Logout as public user
		userLogin.userLogout();

	}
}
