/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/24/2018

* Purpose: Login as Mentor ,Search a course and try to create an invite only batch for it.

*/

package org.testscripts;

import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchCourseCreateInviteOnlyBatch extends BaseTest
{
	@Test
	public void searchCourseCreateInviteOnlyBatch() throws Exception
	{
		
		SignUpObj userLogin = new SignUpObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		
		//Step1: Login as Mentor
		userLogin.userLoginDiksha(CREATOR);
		
		
		//Step2:Search the course and create invite only batch
		createMentorPageObj.createInviteOnlyBatch();
		
		//Step3:Logout as Mentor
		userLogin.userLogout();
		
		//Step4:Login as Invited Member
		userLogin.userLoginDiksha(REVIEWER);


		//Step5:Consume  the course for which you are invited
		createMentorPageObj.navigateToCourseAndSearch();
		
		//Step6:Logout as Invited Member
		userLogin.userLogout();
		
		//Step7: Login as Creator
		userLogin.userLoginDiksha(CREATOR);

		//Step8: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step9: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step10: Logout as Creator
		userLogin.userLogout();
	}
	
}
				