package org.testscripts;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentMP4 extends BaseTest
{
	@Test
	public void uploadContentMP4() throws Exception
	{
		SignUpObj signupObj = new SignUpObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1:Login as content creator
		
		signupObj.userLoginDiksha(CREATOR);
		
		//Step2:Navigate to workspace and uplaod content-MP4
		
		creatorUserPageObj.uploadContent(MP4);
		
		//Step3:Logout as creator
		
		signupObj.userLogout();
		
		//Step4:Login as Reviewer
		
		signupObj.userLoginDiksha(REVIEWER);
		
		//Step5:Go to workspace and publish content Mp4
		
		creatorUserPageObj.goToWorkspaceAndPublish("content");
		
		//Step6:Logout as reviewer
		
		signupObj.userLogout();
		
		//Step7:Login as Public user
		
		signupObj.userLoginDiksha(PUBLICUSERS_S);	
				
		//Step8:Go to workspace and publish content Mp4
				
		creatorUserPageObj.navigateToLibraryAndSearchContent("content");
		
		//Step9:Logout as Public user
		
		signupObj.userLogout();
		
		//Step10: Login as Creator
		
		signupObj.userLoginDiksha(CREATOR);

		//Step11: Navigate to WorkSpace
		
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step12: Delete the Created item
		
		creatorUserPageObj.deleteCreatedItems();

		//Step13: Logout as Creator
		
		signupObj.userLogout();
		
		
		
	}
}