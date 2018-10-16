/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/27/2018

* Purpose: As a Creator edit uploaded PDF,as a Reviewer Publish it and as a User Consume it.

*/
package org.testscripts;

import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class EditUploadedContent extends BaseTest
{
	@Test
	public void editUploadedContent() throws Exception
	{
		SignUpObj creatorLogin = new SignUpObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		//Step1:Login as content creator
		
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step2:Navigate to workspace and Search
		
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
		creatorUserPageObj.navigateToAllMyContentAndSearch(objListOFTestDataForSunbird,UPLOADCONTENT);
		
		//Step3:Upload content
		
		creatorUserPageObj.uploadNewContent(PDF);
		
		//Step4:Logout as creator
		
		creatorLogin.userLogout();
		
		//Step5:Login as Reviewer
		
		creatorLogin.userLoginDiksha(REVIEWER);
		
		//Step6:Go to workspace and publish content Mp4
		
		creatorUserPageObj.goToWorkspaceAndPublishEdittedContent("content");
		
		//Step7:Logout as reviewer
		
		creatorLogin.userLogout();
		
		//Step8:Login as Public user
		
		creatorLogin.userLoginDiksha(PUBLICUSERS_S);	
				
		//Step9:Go to workspace and publish content Mp4
				
		creatorUserPageObj.navigateToLibraryAndSearchEdittedContent("content");
		
		//Step10:Logout as Public user
		
		creatorLogin.userLogout();
		
		
	}
}

