/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 05/18/2018
 * Purpose: To verify Library search- with filter
 */

package org.testscript.librarypage;


import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.LibraryPageObj;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class VerifyConsumptionOfOldContentAndNewContent  extends BaseTest
{
	@Test(groups= {"publicuser","sanity1","regression2"})
	public void verifyConsumptionOfOldContentAndNewContent() throws Exception 
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		LibraryPageObj libraryPageObj = new LibraryPageObj();
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		//Step 1: Login as Mentor
		userLogin.userLogin(CREATOR);
		
		//Step11: Navigate to WorkSpace

		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
		
		List<String> SearchableContents = libraryPageObj.getFirstAndLastPublishedContent();

		//Step 2: search in library
		//Search for old book, Resource, Upload content
		//Collection and lesson plan
		libraryPageObj.librarySearchforOldAndNewContents(SearchableContents);

		//Step 3: search in library
		//Search for  new book, Resource, Upload content
		//Collection and lesson plan
		//libraryPageObj.librarySearch();

		//Step 4:Logout as Public user
		userLogin.userLogout();

	}	

}
