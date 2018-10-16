/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 09/18/2018

* Purpose: Delete the created items from drafts and published.

*/
package org.testscripts;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpObj;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class DeleteTheCreatedContent extends BaseTest {
	
	@Test
	public void deleteTheCreatedContent() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		SignUpObj creatorLogin = new SignUpObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLoginDiksha(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(ALLMYCONTENT);
		
		//Step3: Delete the published items.
		creatorUserPageObj.deleteCreatedItems();
		
		//Step4: Navigate to WorkSpace
		GenericFunctions.captureScreenshotOnValidation();
			
		//Step5: Delete the draft items.
		
		
		//Step6: Logout as Creator
		creatorLogin.userLogout();
	}
	
}