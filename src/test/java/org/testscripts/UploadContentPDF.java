/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/27/2018

* Purpose: As a Creator Upload PDF,as a Reviewer Publish it and as a User Consume it.

*/
package org.testscripts;

import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentPDF extends BaseTest
{
	@Test
	public void uploadContentPDF() throws Exception
	{
		SignUpObj creatorLogin = new SignUpObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1:Login as content creator
		
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step2:Navigate to workspace and uplaod content-MP4
		
		creatorUserPageObj.uploadContent(PDF);
		
		//Step3:Logout as creator
		
		creatorLogin.userLogout();
		
		//Step4:Login as Reviewer
		
		creatorLogin.userLoginDiksha(REVIEWER);
		
		//Step5:Go to workspace and publish content Mp4
		
		creatorUserPageObj.goToWorkspaceAndPublish("content");
		
		//Step6:Logout as reviewer
		
		creatorLogin.userLogout();
		
		//Step7:Login as Public user
		
		creatorLogin.userLoginDiksha(PUBLICUSERS_S);	
				
		//Step8:Go to workspace and publish content Mp4
				
		creatorUserPageObj.navigateToLibraryAndSearchContent("content");
		
		//Step9:Logout as Public user
		
		creatorLogin.userLogout();
		
		//Step10: Login as Creator
		
		/*creatorLogin.userLoginDiksha(CREATOR);

		//Step11: Navigate to WorkSpace

		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step12: Delete the Created item

		creatorUserPageObj.deleteCreatedItems();

		//Step13: Logout as Creator

		creatorLogin.userLogout();*/
		
	}
}

