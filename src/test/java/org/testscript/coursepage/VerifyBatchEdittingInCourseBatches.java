package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;

import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;


public class VerifyBatchEdittingInCourseBatches extends BaseTest{
	
	//SUN-1546
	@Test(groups= {"regression1","coursepage"})
	public void verifyBatchEdittingInCourseBatches() throws Exception {
		
		 SignUpPageObj signUpLogin = new SignUpPageObj();
		 CoursePageObj coursePageObj = new CoursePageObj();
		
		 ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-1546");
		 
		 // Login as Mentor
		 signUpLogin.userLogin(MENTOR);
		
	     // Navigate to Ongoing Batch
	     
	      coursePageObj.navigateToWorkspaceAndSelectBatches("Ongoing Courses");
		
		  // Update ongoing Batch		
	      coursePageObj.navigateToOngoingCourseSearchAndUpdate();
	      
	      
	   	  //Step 6 : Logout as Mentor
	      signUpLogin.userLogout();
		  
	}
}
