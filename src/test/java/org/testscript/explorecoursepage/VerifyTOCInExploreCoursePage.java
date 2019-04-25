package org.testscript.explorecoursepage;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.generic.ExtentTestManager;
import org.pageobjects.ExplorePageobj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyTOCInExploreCoursePage extends BaseTest{
	
	//SUN-2823
	@Test(groups= {"regression1"})
	public void verifyTOCInExploreCoursePage() throws Exception {

		ExplorePageobj explorePageObj = new ExplorePageobj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test Case SUN-2823");
		
		//Step 1:Open the application ,navigate to explore page
		explorePageObj.navigateToExploreCoursePage();
		
		//Step 2:Open the application ,navigate to explore page
		explorePageObj.navigateToTOCInExploreCoursePage();
		
	}

}
