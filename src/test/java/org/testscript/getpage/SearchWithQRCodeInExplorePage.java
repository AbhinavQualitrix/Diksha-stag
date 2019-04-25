package org.testscript.getpage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;
import org.pageobjects.PublicUserPageObj;
import org.startup.BaseTest;


public class SearchWithQRCodeInExplorePage extends BaseTest
{

	//SUN-1105, SUN-1104, SUN-1103
	@Test(groups= {"regression1","publicuser"})

	public void searchWithQRCodeInExplorePage() throws Exception
	{	
		
		PublicUserPageObj publicUserPageObj = new PublicUserPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1105");
		
		//Go to Explore page
		publicUserPageObj.goToExplorePage();
		
		//Enter QR code and search
		publicUserPageObj.searchWithQRcode();
		
		//Again	search with QR code in result page and verify the contents
		publicUserPageObj .verifyRedirectDialcodeAndSearch();
		
	}

}







