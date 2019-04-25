package org.testscript.explorecoursepage;

import org.pageobjects.LibraryPageObj;

import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchContentWithFiltersInExploreCoursePage extends BaseTest

	{
		

		@Test(groups= {"publicuser","sanity1","regression2"})
		public void searchContentWithFiltersInExploreCoursePage() throws Exception
		{
		
			LibraryPageObj libraryPage=new LibraryPageObj();
	
			libraryPage.searchContentWithFilter();

	
}
}