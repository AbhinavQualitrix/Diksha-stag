package org.testscript.explorecoursepage;

import org.testng.annotations.Test;
import org.pageobjects.CoursePageObj;
import org.pageobjects.ExplorePageobj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;

public class LanguageTranslateInExploreCourse extends BaseTest {
	
	@Test(groups = { "regression1" })
	public void languageTranslateInExploreCourse() throws Exception {
		ExplorePageobj explorePageObj = new ExplorePageobj();

		CoursePageObj courseobj = new CoursePageObj();
		SignUpPageObj signupObj = new SignUpPageObj();

		courseobj.LangaugeTranslation();
	}

}
