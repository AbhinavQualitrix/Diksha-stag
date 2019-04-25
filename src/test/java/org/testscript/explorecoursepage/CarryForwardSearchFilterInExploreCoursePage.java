package org.testscript.explorecoursepage;

import org.pageobjects.LibraryPageObj;

import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CarryForwardSearchFilterInExploreCoursePage extends BaseTest

	{
		@Test(groups= {"publicuser","sanity","regression1"})
		public void carryForwardSearchFilterInExploreCoursePage() throws Exception
		{
		
			LibraryPageObj libraryPage=new LibraryPageObj();
	
			
			//Step 1: carry gforward the search filter
			libraryPage.carryForwardSearchFilter();

	
}
}