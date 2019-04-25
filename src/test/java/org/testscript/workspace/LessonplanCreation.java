package org.testscript.workspace;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class LessonplanCreation extends BaseTest {

	@Test(groups={"creator","regression2","sanity1"})
	public void createLessonAndVerify() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(LESSONPLAN);

		//Step3: Create new Lesson plan
		String lessonName=creatorUserPageObj.createLessonPlan();

		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendNewLessonPlanForReview();
		GenericFunctions.refreshWebPage();

		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(lessonName,objListOFTestDataForSunbird);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
/*
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		creatorUserPageObj.goToWorkspace("lessonplan");


		//Step 9 : Reject the lesson plan from the existing list
		creatorUserPageObj.rejectTheContent("LESSONA");

		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();	


		//Logout as Creator
		creatorLogin.userLogin(CREATOR);

		//Navigate to Workspace and access All My Content

		creatorUserPageObj.navigateToWorkspace(ALL_MY_CONTENT);

		//Delete the contents which have created
		creatorUserPageObj.deleteCreatedItems();

		//Logout as Content Creator
		creatorLogin.userLogout();

*/
	}


}
