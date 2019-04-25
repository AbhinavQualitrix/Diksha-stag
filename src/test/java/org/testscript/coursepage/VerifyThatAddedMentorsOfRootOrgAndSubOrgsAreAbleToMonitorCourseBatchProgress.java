package org.testscript.coursepage;

import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

@Listeners(org.generic.TestListener.class)

public class VerifyThatAddedMentorsOfRootOrgAndSubOrgsAreAbleToMonitorCourseBatchProgress extends BaseTest{
	
	@Test(groups= {"mentor","regression"})
	
	public void verifyThatAddedMentorsOfRootOrgAndSubOrgsAreAbleToMonitorCourseBatchProgress() throws InterruptedException, Exception 
	
	{
	
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-1542");
		SignUpPageObj userLogin = new SignUpPageObj();
		CoursePageObj coursePageObj=new CoursePageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();

		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step2 : Create Invite-Only batch and add tenant org and Sub org mentors
		String batchName=coursePageObj.VerifyAddedMentorsAreAbleToMoniterCourseBatchProgress();
		
		//Step3 : Logout as Mentor
		userLogin.userLogout();
		
		//Step4 : Login as Root org mentor
		userLogin.userLogin(CREATOR);
		
		//Step5 : 
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		coursePageObj.viewCourseStatsForMentors(batchName);

	
		//Step6 : Logout as root org mentor
		userLogin.userLogout();
		
		//Step7 : Login as Sub org mentor
		userLogin.userLogin(SUBORGMENTOR);
		
		//Step8 :
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		
		coursePageObj.viewCourseStatsForMentors(batchName);

		
		//Step9 : Logout as Sub org mentor
		userLogin.userLogout();
		
		
	}
	

}
