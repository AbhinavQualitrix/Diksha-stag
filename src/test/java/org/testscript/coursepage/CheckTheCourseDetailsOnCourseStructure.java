package org.testscript.coursepage;


import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;
import org.pageobjects.ExplorePageobj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;


public class CheckTheCourseDetailsOnCourseStructure extends BaseTest{
	
	//SUN-2204
	@Test(groups= {"regression1"})
	public void checkTheCourseDetailsOnCourseStructure() throws Exception {

		ExplorePageobj explorePageObj = new ExplorePageobj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test Case SUN-2204");
		
				
		//Step 1: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);
		
		//Step 2:Open the application ,navigate to explore page
		explorePageObj.navigateToCourse();
		
		//Step 3:Open the application ,navigate to explore page
		explorePageObj.navigateToTOCInExploreCoursePage();
		
		
		//Step 4:Logout as Reviewer
		creatorLogin.userLogout();
		
	}

}
