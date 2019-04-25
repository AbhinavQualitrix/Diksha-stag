package org.testscript.coursepage;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class ToCreateInviteOnlyBatchForRootOrgMentor extends BaseTest 
{
	
	
	
	//SUN-1539
	@Test(groups={"coursepage","regression1"})
	public void toCreateInviteOnlyBatchForRootOrgMentor() throws Exception
	{
		
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		CoursePageObj coursePageObj=new CoursePageObj();
		
		
		
		//Step1: Login as subOrg Mentor
		userLogin.userLogin(SUBORGMENTOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Step3: Create new Course
		
		 String courseName= creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		
		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendNewCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.refreshWebPage();
	
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		//Step6: Logout as subOrg Mentor
		userLogin.userLogout();
		
		//Step7: Login as  sub org Reviewer
		userLogin.userLogin(BOOKREVIEWER);
		
		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);
		
		//Step9:Publish the Course
	     creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);
		
		//Step10: Logout as  suborg Reviewer		
		userLogin.userLogout();	
		
		
		//Step11:Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step12:Search the course and create invite only batch
		coursePageObj.createInviteBatchByRootOrgMentor(courseName);
		
		//Step13:Logout as Mentor
		userLogin.userLogout();

}
}
