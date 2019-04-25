package org.pageobjects;

import java.util.List;
import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.LibraryPage;
import org.page.ProfilePage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

public class ProfilePageObj extends BaseTest {



	ProfilePage profilePage= PageFactory.initElements(driver, ProfilePage.class);
	UploadOrgPage uploadOrgPage = PageFactory.initElements(driver, UploadOrgPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	LibraryPage libraryPage = PageFactory.initElements(driver, LibraryPage.class);
	CreateMentorPage createMentorPage = PageFactory.initElements(driver, CreateMentorPage.class);
	
	static Logger log =  Logger.getLogger(ProfilePageObj.class.getName());
	Actions action = new Actions(driver);
	//List<TestDataForDiksha> objListOFTestDataForSunbird = null;
	GenericFunctions generic = new GenericFunctions();
	JavascriptExecutor executor = (JavascriptExecutor) driver;







	/*
	 * purpose : To verify that user does not get Location Update option
	 * @params : 
	 * @return :
	 */
	public void verifyLocationOption()
	{


		//objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the location update option");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			uploadOrgPage.dropdown.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconProfile);
			createUserPage.profileIconProfile.click();
			
			
			/*GenericFunctions.waitWebDriver(2000);
			profilePage.qBookCreator.click();
			GenericFunctions.waitWebDriver(2000);
			profilePage.profile.click();
			GenericFunctions.waitWebDriver(1000);*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(profilePage.profileContainer);
			if(generic.isElementPresent(profilePage.profileContainer))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "user verified the disability of location update sucessfully");

			}
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the disability of location update");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify the disability of location update" + e.getStackTrace());
			Assert.fail("Failed to verify the disability of location update" + e.getLocalizedMessage());
		}




	}
	
	/*
	 * purpose : To verify that Dashboard Option should be visible only to Admin
	 * @params : 
	 * @return :
	 */
	public void verifyDashboardOption()
	{


		
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the Dashboard option");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			uploadOrgPage.dropdown.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(uploadOrgPage.clickAdminDashboardIcon);
			if(uploadOrgPage.clickAdminDashboardIcon.isDisplayed());
			{
				uploadOrgPage.clickAdminDashboardIcon.click();
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "user verified the availability of Dashboard to admin sucessfully");

			}
			GenericFunctions.waitWebDriver(2000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the availability of Dashboard Option");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify the availability of Dashboard Option" + e.getStackTrace());
			Assert.fail("Failed to verify the availability of Dashboard Option" + e.getLocalizedMessage());
		}




	}
	
	
	/*
	 * purpose : Verify Non Availability of Dashboard Option for public user
	 */
	public void verifyDashboardOptionForPublicuser()
	{


		
		try  {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the Dashboard option for public user");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			uploadOrgPage.dropdown.click();
			GenericFunctions.waitWebDriver(4000);
			try
			{
				if(generic.isElementPresent(uploadOrgPage.clickAdminDashboardIcon))
				{
					Assert.fail("Failed to verify unavailability of Dashboard Option");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the unavailability of Dashboard Option");
				}
			}
			catch(Exception ex)
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is not having Dashboard feature");
				System.out.println("USer is not having Dashboard feature "+ex.getLocalizedMessage());
			}
			
			GenericFunctions.waitWebDriver(2000);

		}
		catch(Exception e)
		{
			Assert.fail("Failed to verify the unavailability of Dashboard Option");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify the unavailability of Dashboard Option" + e.getStackTrace());
		}
	
	
	
	
	}
	
	/*
	 * purpose : To verify profile information of the logged-in user
	 */
	
	public void verifyUserProfileInformation() throws InterruptedException, Exception 
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify profile information of the logged in User");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			uploadOrgPage.dropdown.click();
			GenericFunctions.waitWebDriver(2000);
			uploadOrgPage.clickProfileIcon.click();
			GenericFunctions.waitWebDriver(2000);
			String profileIcon = profilePage.profileIcon.getText().trim().toLowerCase();
			String userName = profilePage.profileUserName.getText().trim().toLowerCase();
			String assignedRole=profilePage.assignedUserRole.getText().trim().toLowerCase();
									
			if(userName.contains(profileIcon)&&profilePage.profileUserName.isDisplayed()&&
					profilePage.profileUserId.isDisplayed()&&assignedRole.equalsIgnoreCase(userName))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "All the information on Profile page is displayed correctly");
			
			}
			
			
		}
		catch (Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To Verify The User Profile Information");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed To Verify The User Profile Information" + e.getStackTrace());
			Assert.fail("Failed To Verify The User Profile Information" + e.getLocalizedMessage());
		}	
		
		}
	

	public void verifyUserProfileDashBoard() throws InterruptedException, Exception 
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify profile DashBoard of the logged in User");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(profilePage.profileIcon);
			profilePage.profileIcon.click();
			GenericFunctions.waitWebDriver(2000);
			if(profilePage.dashBoard.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User Profile DashBoard Is successfuly Verified");
			}
			profilePage.dashBoard.click();
			GenericFunctions.waitWebDriver(1000);
			profilePage.firstLink.click();
			GenericFunctions.waitForElementToAppear(profilePage.dikshaReportHeader);
			String firstLinkText = profilePage.dikshaReportHeader.getText().trim();
			Assert.assertEquals(firstLinkText, "DIKSHA Usage Report", "Title text is not same as expected");
			ExtentTestManager.getTest().log(LogStatus.PASS, "User has successfuly verifIed the data in title "+firstLinkText);
			GenericFunctions.waitWebDriver(2000);	
			profilePage.secondLink.click();
			String secondLinkText = profilePage.qrSummaryHeader.getText().trim();
			Assert.assertEquals(secondLinkText, "QR Code Exception: Summary", "Title text is not same as expected");
			ExtentTestManager.getTest().log(LogStatus.PASS, "User has successfuly verifIed the data in title "+secondLinkText);
			GenericFunctions.waitWebDriver(2000);
			profilePage.thirdLink.click();
			String thirdLinkText = profilePage.qrDetailsHeader.getText().trim();
			Assert.assertEquals(thirdLinkText, "QR Code Exception: Details", "Title text is not same as expected");
			ExtentTestManager.getTest().log(LogStatus.PASS, "User has successfuly verifIed the data in title "+thirdLinkText);
			GenericFunctions.waitWebDriver(2000);
			profilePage.fourthLink.click();
			String fourthLinkText = profilePage.etbSummaryHeader.getText().trim();
			Assert.assertEquals(fourthLinkText, "ETB Creation Status: Summary", "Title text is not same as expected");
			ExtentTestManager.getTest().log(LogStatus.PASS, "User has successfuly verifIed the data in title "+fourthLinkText);
			GenericFunctions.waitWebDriver(2000);
			profilePage.fifthLink.click();
			String fifthLinkText = profilePage.etbDetailsHeader.getText().trim();
			Assert.assertEquals(fifthLinkText, "ETB Creation Status: Details", "Title text is not same as expected");
			ExtentTestManager.getTest().log(LogStatus.PASS, "User has successfuly verifIed the data in title "+fifthLinkText);	
			if(profilePage.firstLink.isDisplayed()&&profilePage.secondLink.isDisplayed()&&
					profilePage.thirdLink.isDisplayed()&&profilePage.fourthLink.isDisplayed()&&profilePage.fifthLink.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "All the mentioned fields Of Logde In User are available In Logde In User DashBoard");
			
			}
			
			
		}
		catch (Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To Verify The User Profile DashBoard");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed To Verify The User Profile DashBoard" + e.getStackTrace());
			Assert.fail("Failed To Verify The User Profile DashBoard" + e.getLocalizedMessage());
		}	
		
		}


	public  void verifyAssigningMultipleRolesToUser() 
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying SUN-1122 ");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to assign multiple roles to the same user");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(profilePage.profileName);
			
			profilePage.profileName.click();
			GenericFunctions.waitWebDriver(1000);
			
			profilePage.profile.click();
			GenericFunctions.waitWebDriver(1000);
			
			libraryPage.searchInLibrary.sendKeys("flag reviewer");
			GenericFunctions.waitWebDriver(1000);
			
			libraryPage.clickSearch.click();
			GenericFunctions.waitWebDriver(1000);
			
			profilePage.editUserDetails.click();
			GenericFunctions.waitWebDriver(1000);
			
			profilePage.dropDown.click();
			GenericFunctions.waitWebDriver(1000);
			
			profilePage.courseMentorDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			
			profilePage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			profilePage.editUserDetails.click();
			GenericFunctions.waitWebDriver(1000);
			

			if(generic.isElementPresent(profilePage.courseMentorOption))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Verified assigning multiple roles to same user");	
			}
			
			GenericFunctions.waitWebDriver(1000);
			profilePage.closeIcon.click();
			
		}
		
		catch(Exception e){
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to assign multiple roles to same user");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Failed to assign multiple roles to same user" + e.getStackTrace());
				Assert.fail("Failed to assign multiple roles to same user" + e.getLocalizedMessage());
					
			}
		}
		
		
		
}
	
	/*
	 * Purpose: Removing assigned roles of the user
	 */
	
public void verifyRemovalOfExistingRole() {

	try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying SUN-1121 ");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to remove existing roles of the user");
		GenericFunctions.waitWebDriver(1000);
	
		profilePage.editUserDetails.click();
		GenericFunctions.waitWebDriver(1000);
		
		GenericFunctions.waitForElementToAppear(profilePage.deleteIcon);
	
	    profilePage.deleteIcon.click();
	    GenericFunctions.waitWebDriver(1000);
	    
	    profilePage.saveButton.click();
	    GenericFunctions.waitWebDriver(1000);
	    
	  
		
		boolean status = generic.isElementPresent(profilePage.courseMentorOption);
		
			Assert.assertEquals(status, false,"Failed to remove existing roles of the user"); 
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified to remove existing roles of the user");	
		
	
	}
	
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify removing multiple roles of same user");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Failed to verify removing multiple roles of same user" + e.getStackTrace());
		Assert.fail("Failed to verify removing multiple roles of same user " + e.getLocalizedMessage());
	
}	
	
	
}
/*
 * Purpose : User is trying to search for the course [SUN-1542 and SUN-1543]
 */
	
public String VerifyAddedMentorsAreAbleToMoniterCourseBatchProgress(){
	
	String savedCourseName,batchName = null;
	List<TestDataForDiksha> objListOFTestDataForSunbird1 = null;
	objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

	try {
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying SUN-1543");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
		createUserPage.headerCourse.click();
		GenericFunctions.waitWebDriver(1000);
		
		createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName()
				+ GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toUpperCase());
		
		createUserPage.searchIcon.click();
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppear(createMentorPage.getCourseName);
		savedCourseName = createMentorPage.getCourseName.getText().trim();
		System.out.println(savedCourseName);
		GenericFunctions.waitWebDriver(2000);
		createMentorPage.getCourseName.click();
		GenericFunctions.waitWebDriver(3000);
		
		GenericFunctions.waitWebDriver(1000);
		GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
		createMentorPage.addIcon.click();
		GenericFunctions.waitWebDriver(1000);
		batchName=objListOFTestDataForSunbird1.get(0).getCourseName()
				+ GenericFunctions.testDataIncrementer("./testData/batchName.txt");
		createMentorPage.nameOfBatch.sendKeys(batchName);
		createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName());

		// Added on 31/07/2018
		createMentorPage.startDate.click();
		GenericFunctions.waitWebDriver(1000);
		createMentorPage.startDateCalendar.click();
		GenericFunctions.waitWebDriver(1000);

		// Added on 08/09/2018
		createMentorPage.endDate.click();
		GenericFunctions.waitWebDriver(1000);
		createMentorPage.endDateCalendar.click();
		GenericFunctions.waitWebDriver(1000);
		
		createMentorPage.mentorDropdown.click();
		createMentorPage.mentorsInBatch.click();
		GenericFunctions.waitWebDriver(1000);

		// Added on 08/09/2018
		createMentorPage.selectMentorsInBatch.click();
		GenericFunctions.waitWebDriver(1000);
		
/////////////////////////
		createMentorPage.selectSubOrgMentorsInBatch.click();
		GenericFunctions.waitWebDriver(1000);
		
			createMentorPage.mentorDropdown.click();
		createMentorPage.membersInBatch.click();
		
		GenericFunctions.waitWebDriver(2000);
	
		createMentorPage.selectSubOrgMembersInBatch.click();
		GenericFunctions.waitWebDriver(1000);
		
		GenericFunctions.waitWebDriver(1000);
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.selectMembersInBatch);
		executor.executeScript("arguments[0].click();", createMentorPage.selectMembersInBatch);

		//////////////////////////
		

		GenericFunctions.waitWebDriver(1000);
		createMentorPage.memberDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		createMentorPage.buttonCreate.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Invite only batch for a course is created sucessfully");
		GenericFunctions.waitWebDriver(4000);
	
	
	}
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that mentors are able to moniter Course batch progress");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Failed to verify that mentors are able to moniter Course batch progress" + e.getStackTrace());
		Assert.fail("Failed to verify that mentors are able to moniter Course batch progress" + e.getLocalizedMessage());

	}
	
	return batchName;
	
}

/*
 * Purpose: Verify that root mentor and sub-org mentor are able to moniter Course batch progress
 */


public void viewCourseStatsForMentors(String batchName) {
	try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying SUN-1542");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to view the course stats");
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(1000);
		GenericFunctions.waitForElementToAppear(createMentorPage.viewCourseDashboard);
		createMentorPage.viewCourseDashboard.click();
		GenericFunctions.waitWebDriver(1000);
		
		createMentorPage.selectBatchDropdown.click();
		GenericFunctions.waitWebDriver(1000);
		
		createMentorPage.searchCourseBatch.sendKeys(batchName);
		GenericFunctions.waitWebDriver(1000);
		
		createMentorPage.selectFirstBatch.click();
		GenericFunctions.waitWebDriver(1000);
		
		
		GenericFunctions.waitForElementToAppear(createMentorPage.courseDashboard);
		if (createMentorPage.courseDashboard.isDisplayed()&&createMentorPage.status.isDisplayed()) {
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"USer is able to Verify Course Stats of course  batch" + createMentorPage.batchCourseName.getText());
		}
		// createMentorPage.fromBeginning.click();
		GenericFunctions.waitWebDriver(3000);
	} catch (Exception e) {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to view the course stats");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method viewCourseStats" + e.getMessage());
		Assert.fail("Failed to view the course stat, Exception" + e.getLocalizedMessage());

	}
}


/*
 * Purpose : To verify that user is able to update the location data
 */
		
    public void verifyLocationUpdateForUser() {

	try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying SUN-1600 ");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to update the location data");
		GenericFunctions.waitWebDriver(4000);
		
		//GenericFunctions.waitForElementToAppear(profilePage.profileIcon);
		GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
		
		uploadOrgPage.dropdown.click();
		GenericFunctions.waitWebDriver(1000);
		
		profilePage.profile.click();
		GenericFunctions.waitWebDriver(1000);
		
		if(profilePage.district.isDisplayed()&&profilePage.state.isDisplayed())
		{
			
			GenericFunctions.waitWebDriver(1000);
			
			profilePage.editButton.click();
			GenericFunctions.waitWebDriver(1000);
			
			profilePage.stateDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			
			profilePage.stateName.click();
			GenericFunctions.waitWebDriver(1000);
			
			
			profilePage.districtDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.scrollTillEndOfPage();
			GenericFunctions.scrollToElement(profilePage.districtName);
			
			
			profilePage.districtName.click();
			GenericFunctions.waitWebDriver(2000);
			
			profilePage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);
			
	
		}
		
		if(profilePage.selectedDistrict.isDisplayed()&&profilePage.selectedState.isDisplayed())
		{
			Assert.assertTrue(true, "Failed to update the location data");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified upadating the location data");	
		}
	
	}
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to update the location data");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Failed to update the location data" + e.getStackTrace());
		Assert.fail("Failed to update the location data " + e.getLocalizedMessage());
		
	}

}
    
    
    public void languageVerify() 
	{
		try {
				ExtentTestManager.getTest().log(LogStatus.INFO,"User is trying to verify languages");
				if(profilePage.selectlanguage.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS," Language Setting Option is Available : " + profilePage.selectlanguage.getText());
			
				}
				GenericFunctions.waitForElementToAppearOnScreen(profilePage.qBookCreator);
				profilePage.qBookCreator.click();
				//GenericFunctions.WaitForFrameAndSwitchToIt(profilePage.profile);
				GenericFunctions.waitWebDriver(2000);
				profilePage.profile.click();
				GenericFunctions.waitForElementToAppear(profilePage.selectlanguage);
				profilePage.selectlanguage.click();
				GenericFunctions.waitWebDriver(2000);
				profilePage.hindiLanguage.click();
				GenericFunctions.waitWebDriver(2000);
				profilePage.searchTextBox.sendKeys("?????");
				GenericFunctions.waitWebDriver(1000);
				profilePage.searchButton.click();
				GenericFunctions.waitWebDriver(1000);
				if(profilePage.hindiContent.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS," Searched hindi content is Available : " );
					
				}
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(profilePage.clickOnLanguageDropdwon);
				profilePage.clickOnLanguageDropdwon.click();
				GenericFunctions.waitWebDriver(1000);
				profilePage.urduLanguage.click();
				GenericFunctions.waitWebDriver(1000);
				profilePage.searchTextBox.clear();
				GenericFunctions.waitWebDriver(1000);
				profilePage.searchTextBox.sendKeys("????");
				GenericFunctions.waitWebDriver(2000);
				profilePage.urduSearchButton.click();
				GenericFunctions.waitWebDriver(2000);
				if(profilePage.urduContent.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS," Searched urdu content is Available : " );
					
				}
				profilePage.selectLanguageInUrdu.click();
				GenericFunctions.waitWebDriver(1000);
				profilePage.englishLanguage.click();
				GenericFunctions.waitWebDriver(1000);
				profilePage.searchTextBox.clear();
				GenericFunctions.waitWebDriver(1000);
				profilePage.searchTextBox.sendKeys("course");
				GenericFunctions.waitWebDriver(1000);
				profilePage.searchButton.click();
				GenericFunctions.waitWebDriver(1000);
				if(profilePage.englishContent.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS," Searched english content is Available : " );
					
				}
				ExtentTestManager.getTest().log(LogStatus.PASS,"User has able to search the containt by selected language ");

	} 
	catch (Exception e) 
	{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search conatint by selected language");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			System.out.println("Failed to search conatint by selected language");
			Assert.fail("Failed to search conatint by selected language");
	}
	
	
	}


    /*
     * purpose: To verify root org admin can verify the searched user
     * */
      
      public void  toCheckOrgAdminForUser ()
      {

        try
        {
      	GenericFunctions.waitWebDriver(2000);
      	ExtentTestManager.getTest().log(LogStatus.INFO,
      			"User is trying to verify the searched content as a Org admin");
      	GenericFunctions.waitWebDriver(1000);
      	GenericFunctions.waitForElementToAppear(profilePage.bookCreator);
      	
      	profilePage.bookCreator.click();
         
      	profilePage.profile.click();
      //	GenericFunctions.waitWebDriver(1000);
      //	GenericFunctions.waitForElementToAppear(createUserPage.searchInUser);
      	profilePage.searchInUser.sendKeys("creator");
      	profilePage.searchButton.click();
      	
      	profilePage.creatorContent.isDisplayed();
      	{
      		Assert.assertTrue(true);
      		
      		ExtentTestManager.getTest().log(LogStatus.PASS,
      	  			"User is passed to verify the content as org admin");
      	}
        }

      	 catch (Exception e)
        {
      	ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the content as org admin ");
      	ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
      	log.error("Failed to verify the content as org admin" + e.getStackTrace());
      	Assert.fail("Failed to verify the content as org admin" + e.getLocalizedMessage());
      }
    }
      
      public void  toCheckTenantOrgAdminForUser ()
        {

          try
          {
        	GenericFunctions.waitWebDriver(2000);
        	ExtentTestManager.getTest().log(LogStatus.INFO,
        			"User is trying to verify watermark text as tenant org admin");
        	//GenericFunctions.waitWebDriver(1000);
        	//GenericFunctions.waitForElementToAppear(createUserPage.bookCreator);
        	
        	profilePage.bookCreator.click();
           
        	profilePage.profile.click();
        	GenericFunctions.waitWebDriver(1000);
        	//GenericFunctions.waitForElementToAppear(createUserPage.searchInUser);
        	
        	
        	String watermarktext=profilePage.searchInUser.getText();
        	System.out.println(watermarktext);
        	
        }
          catch (Exception e)
          {
        	  ExtentTestManager.getTest().log(LogStatus.FAIL, "User is failed to verify watermark text as tenant org admin");
        	  ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
        	  log.error("User is failed to verify watermark text as tenant org admin" + e.getStackTrace());
        	  Assert.fail("User is failed to verify watermark text as tenant org admin" + e.getLocalizedMessage());
          }
        }
      public void  toCheckContentByUser()
      {
    	  try
    	  {
    		  GenericFunctions.waitWebDriver(2000);
    		  ExtentTestManager.getTest().log(LogStatus.INFO,
    				  "User is trying to verify the water mark text as a public user");
    		  GenericFunctions.waitWebDriver(1000);
    		  //GenericFunctions.waitForElementToAppear(createUserPage.enterQRcodeButton);

    		  profilePage.bookCreator.click();

    		  profilePage.profile.click();

    		  String watermarktext=profilePage.searchInAll.getText();

    		  System.out.println(watermarktext);

    		  profilePage.searchInAll.sendKeys("Book");

    		  profilePage.searchButton.click();
    		  GenericFunctions.waitForElementToAppear(profilePage.bookContent);

    		  if(profilePage.bookContent.isDisplayed())
    		  {
    			  Assert.assertTrue(true);
    			  ExtentTestManager.getTest().log(LogStatus.INFO,
    					  "User is trying to verify the searched content as a public user");

    		  }



    	  }
    	  catch (Exception e) {
    		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed toverify the searched content as a public user");
    		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
    		  log.error("Failed to verify the searched content as a public user" + e.getStackTrace());
    		  Assert.fail("Failed to verify the searched content as a public user" + e.getLocalizedMessage());
    	  }


      }



}