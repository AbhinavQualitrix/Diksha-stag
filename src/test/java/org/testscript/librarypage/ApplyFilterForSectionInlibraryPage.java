package org.testscript.librarypage;

import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.LibraryPage;
import org.pageobjects.LibraryPageObj;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ApplyFilterForSectionInlibraryPage extends BaseTest

	{
	LibraryPage objLibraryPage = PageFactory.initElements(driver, LibraryPage.class);


		@Test(groups= {"regression1"})
		public void applyFilterInFeaturedContentSectionInLibraryPage() throws Exception
		{
			LibraryPageObj libraryPage=new LibraryPageObj();
			SignUpPageObj userLogin = new SignUpPageObj();
			PublicUserPageObj publicUser = new PublicUserPageObj();
			
			//Step 1 : Login into Application as Public user	
			userLogin.userLogin(PUBLICUSER1);			
			
		libraryPage.filterForLibraryPageSections(VIEWALL_CATEGORY[0]);
		}
		
		
	
		@Test(groups= {"regression1"})
		public void applyFilterInTextbooksContentSectionInLibraryPage() throws Exception
		{
			LibraryPageObj libraryPage=new LibraryPageObj();
			SignUpPageObj userLogin = new SignUpPageObj();
			PublicUserPageObj publicUser = new PublicUserPageObj();
			
			//Step 1 : Login into Application as Public user	
			userLogin.userLogin(PUBLICUSER1);
			
		libraryPage.filterForLibraryPageSections(VIEWALL_CATEGORY[1]);
		}
		
		
	
		@Test(groups= {"regression1"})
		public void applyFilterInTeaching_MaterialContentSectionInLibraryPage() throws Exception
		{
			LibraryPageObj libraryPage=new LibraryPageObj();
			SignUpPageObj userLogin = new SignUpPageObj();
			PublicUserPageObj publicUser = new PublicUserPageObj();
			
			//Step 1 : Login into Application as Public user	
			userLogin.userLogin(PUBLICUSER1);
			
		libraryPage.filterForLibraryPageSections(VIEWALL_CATEGORY[2]);
}

		
		
		@Test(groups= {"regression1"})
		public void applyFilterInLearning_MaterialContentSectionInLibraryPage() throws Exception
		{
			LibraryPageObj libraryPage=new LibraryPageObj();
			SignUpPageObj userLogin = new SignUpPageObj();
			PublicUserPageObj publicUser = new PublicUserPageObj();
			
			//Step 1 : Login into Application as Public user	
			userLogin.userLogin(PUBLICUSER1);
			

		libraryPage.filterForLibraryPageSections(VIEWALL_CATEGORY[3]);
}

			
		@Test(groups= {"regression1"})
		public void applyFilterInPracticeAndTestMaterialContentSectionInLibraryPage() throws Exception
		{
			LibraryPageObj libraryPage=new LibraryPageObj();
			SignUpPageObj userLogin = new SignUpPageObj();
			PublicUserPageObj publicUser = new PublicUserPageObj();
			
			//Step 1 : Login into Application as Public user	
			userLogin.userLogin(PUBLICUSER1);
			
			
		libraryPage.filterForLibraryPageSections(VIEWALL_CATEGORY[4]);
}


}