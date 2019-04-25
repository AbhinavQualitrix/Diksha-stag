package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;

public class VerifyPageLanguageTranslate extends BaseTest {
	// Sun-2065
	@Test(groups = { "coursepage","regression1" })
	public void verifyPageLanguageTranslate() throws Exception {

		CoursePageObj courseobj = new CoursePageObj();
		SignUpPageObj signupObj = new SignUpPageObj();

		signupObj.userLogin(CREATOR);
		courseobj.vaidatePageLangaugeTranslation();
	}

}
