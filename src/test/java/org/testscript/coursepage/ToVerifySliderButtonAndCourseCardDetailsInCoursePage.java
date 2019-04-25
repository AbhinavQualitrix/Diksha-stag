package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ToVerifySliderButtonAndCourseCardDetailsInCoursePage extends BaseTest
{
	//SUN-2068 and SUN-2061
	@Test(groups= {"coursepage","regression1"})
	public void toVerifySliderButtonAndCourseCardDetailsInCoursePage() throws Exception
	{
	SignUpPageObj signupObj = new SignUpPageObj();
	CoursePageObj coursePageObj = new CoursePageObj();
	
	
	//Step 1 : Login as Any User
	signupObj.userLogin(CREATOR);
	
	//Step 2 : 	Click on "Courses" tab and Check the "Slider" button
	coursePageObj.verifySliderButtonInMyCourses();
	
	//Step 3 : Go to Course Tab and verify each Course Card details 
	coursePageObj.verifyCourseCardDetailsInCoursePage();
	
	//Step 4 : Logout as Same user 
	signupObj.userLogout();
	
	
	}

}
