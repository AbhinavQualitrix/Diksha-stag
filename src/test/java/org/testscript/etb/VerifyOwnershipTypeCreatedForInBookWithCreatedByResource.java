package org.testscript.etb;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.BookEditorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;


public class VerifyOwnershipTypeCreatedForInBookWithCreatedByResource extends BaseTest{
	
	@Test(groups= {"regression1"})
	public void verifyOwnershipTypeCreatedForInBookWithCreatedByResource() throws Exception{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		BookEditorPageObj bookEditorPageObj = new BookEditorPageObj();
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		
		//Step 1:Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to workspace to Create a book
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step 3:create new book
		creatorUserPageObj.createNewBook(objListOFTestDataForSunbird);
		
		//Step 4:vrify the resource type content is created by
		bookEditorPageObj.verifyOwnershipTypeInResourceTypeContent();
		
		//Step 5:add credit and ownershiptype in editform 
		bookEditorPageObj.editAndSaveBookForCreatedFor();
		
		//Step 6:add credit and ownershiptype in editform 
		bookEditorPageObj.verifyOwnerInEditSection();
		
		//Step 7:Logout as Creator
		signupObj.userLogout();
		
		
		
	}

}
