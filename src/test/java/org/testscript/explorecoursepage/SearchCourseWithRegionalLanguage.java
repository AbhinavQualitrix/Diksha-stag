package org.testscript.explorecoursepage;

import org.testng.annotations.Test;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;

public class SearchCourseWithRegionalLanguage extends BaseTest {
	// Sun-2065
	@Test(groups = { "regression1" })
	public void searchCouseWithRegionalLang() throws Exception {

		CoursePageObj courseobj = new CoursePageObj();
		SignUpPageObj signupObj = new SignUpPageObj();

		driver.get(APP_URL + "/explore-course");
		courseobj.SearchCouseWithRegionalLang();
	}

}
