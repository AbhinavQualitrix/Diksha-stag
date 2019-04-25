package org.testscript.workspace;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

@Listeners(org.generic.TestListener.class)

public class VerifyBatchUpdation extends BaseTest {

	@Test(groups= {"mentor","regression"})
	
	public void verifyBatchUpdation() throws InterruptedException, Exception {
		
		SignUpPageObj userLogin = new SignUpPageObj();	
	WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		 GenericFunctions genericFunctions= new GenericFunctions();
		 
		//Step1 : Login as Mentor
		userLogin.userLogin(MENTOR);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"User is verifying SUN-1674"); 
		
		//Step2:
		genericFunctions.navigateToWorkspaceFeatures(COURSE_BATCHES);
		
		//Step3 : Verify Batch Updation for Ongoing Courses
		workspacePageObj.verifyBatchEditingFromOngoingCoursesSectionAssignedToMe();
		
		//Step4 : Verify Batch Updation for Upcoming Courses
		workspacePageObj.verifyBatchEditingFromUpcomingCoursesSectionAssignedToMe();
		
		//Step5 : Logout as Mentor
		userLogin.userLogout();
		
		
		

	}
	
		
		
		
		
	
}
