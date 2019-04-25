package org.testscript.explorecoursepage;

import org.pageobjects.LibraryPageObj;

import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifySignInPopupInExploreCourseEnrollButton extends BaseTest

	{
		//MT done
		@Test(groups= {"publicuser","sanity","regression2"})
		public void verifySignInPopupInExploreCourseEnrollButton() throws Exception
		{
		
			LibraryPageObj libraryPage=new LibraryPageObj();
	
			libraryPage.validateSignInPopupOnClickOnEnroll();

	
}
}