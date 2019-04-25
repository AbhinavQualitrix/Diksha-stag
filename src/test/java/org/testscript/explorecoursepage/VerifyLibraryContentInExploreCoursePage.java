package org.testscript.explorecoursepage;

import org.pageobjects.LibraryPageObj;

import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyLibraryContentInExploreCoursePage extends BaseTest

	{
		
		@Test(groups= {"publicuser","sanity","regression1"})

		public void verifyLibraryContentInExploreCoursePage() throws Exception
		{
		
			LibraryPageObj libraryPage=new LibraryPageObj();
	
			//Step 1: validate library result
			libraryPage.validateResult();

	
}
}