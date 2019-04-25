package org.testscript.explorepage;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ToVerifyViewAllButtonUnderLibraryOfExplorePage extends BaseTest
{
	/*@Test(groups= {"newfeature","regression2"})
	public void verifyViewAllButtonForAllTheContentSectionsInExploreLibrary()
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		
		//Navigate to Explore Page and verify View All Button under All categories of Library Page
		workspacePageObj.verifyViewAllInExploreLibraryPage();
		
	}*/
	
	@Test(groups= {"newfeature","regression2"})
	public void clickOnViewAllAndVerifyContents()
	{
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		
		
		//Click on ViewAll Under Featured Contents Category and verify Contents
	//	workspacePageObj.clickOnViewAllAndVerifyContents(VIEWALL_CATEGORY[0]);
		
		//Click on ViewAll Under Textbooks Category and verify Contents
		workspacePageObj.clickOnViewAllAndVerifyContents(VIEWALL_CATEGORY[1]);
		
		//Click on ViewAll Under Teaching material Category and verify Contents
		workspacePageObj.clickOnViewAllAndVerifyContents(VIEWALL_CATEGORY[2]);
		
		//Click on ViewAll Under Learning material Category and verify Contents
		workspacePageObj.clickOnViewAllAndVerifyContents(VIEWALL_CATEGORY[3]);
					
		//Click on ViewAll Under Practice and test material Category and verify Contents
		workspacePageObj.clickOnViewAllAndVerifyContents(VIEWALL_CATEGORY[4]);
	}
	

}
