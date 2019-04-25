package org.testscript.librarypage;

import org.pageobjects.LibraryPageObj;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyViewAllSectionInLibraryPageBasedOnCount extends BaseTest

	{
		
		@Test(groups= {"publicuser","sanity1","regression2"})
		public void verifyViewAllSectionInLibraryPageBasedOnCount() throws Exception
		{
			LibraryPageObj libraryPage=new LibraryPageObj();
			SignUpPageObj userLogin = new SignUpPageObj();
			PublicUserPageObj publicUser = new PublicUserPageObj();
			
			//Step 1 : Login into Application as Public user	
			userLogin.userLogin(PUBLICUSER1);

		libraryPage.verifyViewAllSectionBasedOnContentCount();
}
		
		
		
}