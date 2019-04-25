package org.testscript.workspace;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class ToCreateBookAndPreviewContents extends BaseTest 
{
	//SUN-1524
	@Test(invocationCount=1,groups= {"regression","workspace"})
	public void toCreateBookAndPreviewContents() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		
		//Step1: Login as Creator
		
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step3: Create new book
		workspacePageObj.toCreateBookAndPreviewContents(objListOFTestDataForSunbird);
		
		creatorLogin.userLogout();
		
		
}
}