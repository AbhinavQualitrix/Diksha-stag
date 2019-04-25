/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Abhinav kumar singh
 * Date: 03/14/2019
 * Purpose:  Upload the Content type - Epub ,update it from published section  and send for reviewa.Search the content,updated changes should be there.
 */

package org.testscript.librarypage;


import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchForTheLatestUpdatedContent extends BaseTest
{
	@Test(groups={"creator","sanity","smoke","regression2"})//(priority=4, 
	public void searchForTheLatestUpdatedContent() throws Exception
	{
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genereicFunctions = new GenericFunctions();

		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to workspace and upload content-Epub and send the content for review
		creatorUserPageObj.uploadContentMp4(MP4);

		//Step 3:Logout as creator
		signupObj.userLogout();

		//Step 4:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 5:Go to workspace and publish content Epub
		creatorUserPageObj.goToWorkspace("epub");
	
		//Step 6 :Logout as Reviewer
		signupObj.userLogout();

		//Step 7: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 8: Navigate to WorkSpace-All my content
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 9: Delete the Created item
		String actual = creatorUserPageObj.updateTheUploadedContentAndSendForReview();
		
		//Step 10: Search for the latest updated content in library
		creatorUserPageObj.navigateToLibraryAndSearchContent("Content");

		//Step 11: Search for the latest updated content in library
		creatorUserPageObj.verifyTheUpdatedUploadedContent(actual);

		//Step 12: Logout as Creator
		signupObj.userLogout();
	}
}
