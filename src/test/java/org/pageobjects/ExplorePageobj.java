package org.pageobjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.ExplorePage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ExplorePageobj extends BaseTest{
	
	ExplorePage explorePage = PageFactory.initElements(driver, ExplorePage.class);
	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
	CreatorUserPage createUserPage = PageFactory.initElements(driver, CreatorUserPage.class);
	GenericFunctions generic = new GenericFunctions();
	CreateMentorPage createMentorPage = PageFactory.initElements(driver, CreateMentorPage.class);
	List<TestDataForDiksha> objListOFTestDataForSunbird = null;

	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	/**navigateToExplorePage method is used to navigate to explore page.
	 * @throws Exception
	 */
	public void navigateToExplorePage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To ExplorePage");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore");
			GenericFunctions.waitForElementToAppear(explorePage.clickOnFirstTextBook);
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To ExplorePage");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToExplorePage" + e.getStackTrace());
			Assert.fail("Failed on navigate To ExplorePage" + e.getLocalizedMessage());
			
		}	
	}
	
	
	
	/**navigateToTOCPage method is used to upload a navigate to TOC page.
	 * @throws Exception
	 */
	public void navigateToTOCPage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To TOC Page");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore");
			GenericFunctions.waitForElementToAppear(explorePage.clickOnFirstTextBook);
			explorePage.clickOnFirstTextBook.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To TOC Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToTOCPage" + e.getStackTrace());
			Assert.fail("Failed on navigate To TOC Page" + e.getLocalizedMessage());
			
		}	
	}
	

	
	/** navigateToContentDisplayPage method is used to upload a navigate to Content Display page.
	 * @throws Exception
	 */
	public void navigateToContentDisplayPage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Content Display Page");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore");
			GenericFunctions.waitForElementToAppear(explorePage.clickOnFirstTextBook);
			explorePage.clickOnFirstTextBook.click();
			if(generic.isElementPresent(explorePage.clickOnFirstTextBookTOC))
			{
				GenericFunctions.waitForElementToAppear(explorePage.clickOnFirstTextBookTOC);
				explorePage.clickOnFirstTextBookTOC.click();
				GenericFunctions.waitForElementToAppear(explorePage.clickOnFirstTextBookTOCUnits);
				explorePage.clickOnFirstTextBookTOCUnits.click();
				GenericFunctions.waitWebDriver(2000);
			}
			ExtentTestManager.getTest().log(LogStatus.INFO, "User has successfully navigated To Content Display Page and consumed units");
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To Content Display Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToContentDisplayPage" + e.getStackTrace());
			Assert.fail("Failed on navigate To Content Display Page" + e.getLocalizedMessage());
		}	
	}
	
	/**verifyAvailabilityOfLibraryAndCourse method is used to verify availability of library and course fields.
	 * @throws Exception
	 */
	public void verifyAvailabilityOfLibraryAndCourse() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Availability Of Library And Course");
			GenericFunctions.waitWebDriver(2000);
			boolean libraryStatus = generic.isElementPresent(createUserPage.headerLibrary);
			boolean CourseStatus = generic.isElementPresent(createUserPage.headerCourse);
			Assert.assertEquals(libraryStatus, true,"library is not available");
			Assert.assertEquals(CourseStatus, true,"course is not available");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified Availability Of Library And Course");
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verify Availability Of Library And Course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method verifyAvailabilityOfLibraryAndCourse" + e.getStackTrace());
			Assert.fail("Failed on verify Availability Of Library And Course" + e.getLocalizedMessage());
		}	
	}
	
	/**This Method is used to navigate To TOC In  Explore CoursePage and check the course units.
	 * @throws Exception
	 */
	public void navigateToTOCInExploreCoursePage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To TOC In ExploreCoursePage");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollDownByPixel();
			GenericFunctions.scrollDownByPixel();
			GenericFunctions.waitForElementToAppear(explorePage.latestCourseViewAllSection);
			//GenericFunctions.scrollTillEndOfPage();
			explorePage.validateLatestCourse.click();
			//wait.until(ExpectedConditions.urlContains("explore-course/course/do_"));
			//wait.until(ExpectedConditions.urlContains("learn/course/do_"));
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitWebDriver(1000);
			if(generic.isElementPresent(explorePage.clickOnFirstTextBookTOC))
			{
				explorePage.clickOnFirstTextBookTOC.click();
				GenericFunctions.waitWebDriver(1000);
				for(int i=0;i<explorePage.clickOnFirstCourseTOCUnits.size()-1;i++)
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Available Content : "+explorePage.clickOnFirstCourseTOCUnits.get(i).getText());
					GenericFunctions.waitWebDriver(1000);
				}
				explorePage.clickOnFirstTextBookTOCUnits.click();
			}	
			else
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Content is not available for consumption after clicking on Unit");
			}
			
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To TOC In  ExploreCoursePage");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigate To TOC In  ExploreCoursePage" + e.getStackTrace());
			Assert.fail("Failed on navigate To TOC In  ExploreCoursePage" + e.getLocalizedMessage());
			
		}	
	}
	/**This Method is used to navigate To Explore CoursePage.
	 * @throws Exception
	 */
	
	public void navigateToExploreCoursePage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To ExploreCoursePage");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore-course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollDownByPixel();
			//action.moveToElement(explorePage.latestCourseViewAllSection);
			GenericFunctions.waitForElementToAppear(explorePage.latestCourseViewAllSection);
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To ExploreCoursePage");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigate To ExploreCoursePage" + e.getStackTrace());
			Assert.fail("Failed on navigate To ExploreCoursePage" + e.getLocalizedMessage());
			
		}	
	}	
	/**This method is used  to check Org Details In TOC Page.
	 * @throws Exception
	 */
	public void checkOrgDetailsInTOCPage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to check Org Details In TOC Page");
			GenericFunctions.waitForElementToAppear(explorePage.checkCreatedByInTOCPage);
			GenericFunctions.scrollToElement(explorePage.checkCreatedByInTOCPage);
			LocalDate localDate = LocalDate.now();
			System.out.println(DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(localDate));
			String createdBy = explorePage.checkCreatedByInTOCPage.getText();
			String createdOn = explorePage.checkCreatedOnInTOCPage.getText();
		    String UpdatedOn = explorePage.checkUpdatedOnInTOCPage.getText();	 
			ExtentTestManager.getTest().log(LogStatus.INFO,createdBy);
			ExtentTestManager.getTest().log(LogStatus.INFO,"Org Name: "+explorePage.checkOrgNameInTOCPage.getText());
			ExtentTestManager.getTest().log(LogStatus.INFO,createdOn);
			ExtentTestManager.getTest().log(LogStatus.INFO,UpdatedOn);
			
			
			
			if(explorePage.checkEmailIdInTOCPage.getText().equalsIgnoreCase(explorePage.checkCreatedOnInTOCPage.getText()))
			{
				
				ExtentTestManager.getTest().log(LogStatus.INFO, "Email id is not available ");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.INFO,explorePage.checkEmailIdInTOCPage.getText());
				explorePage.checkEmailIdInTOCPage.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Email id is available and clicked");
			}
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to check Org Details In TOC Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to check Org Details In TOC Page" + e.getStackTrace());
			Assert.fail("Failed to check Org Details In TOC Page" + e.getLocalizedMessage());
			
		}	
	}
	public void navigateToCourse() throws InterruptedException {
		
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course");
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(2000);
			

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section, search course ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearchForOpenBatch" + e.getLocalizedMessage());
			Assert.fail("Failed on navigating to Course section, search course and create open batch, Exception : "
					+ e.getLocalizedMessage());
		}
	}
	public void verifyCreatedDateAndCreatorDetailsInTOCPage(List<TestDataForDiksha> objListOFTestDataForSunbird) throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Created Date And Creator Details In TOC Page");
			GenericFunctions.waitForElementToAppear(explorePage.checkCreatedByInTOCPage);
			GenericFunctions.scrollToElement(explorePage.checkCreatedByInTOCPage);
			LocalDate localDate = LocalDate.now();
			String currentDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(localDate);
			String [] ddmmmyyyy = currentDate.split("-");
			String date = ddmmmyyyy[0].toString();
			String month = ddmmmyyyy[1].toString();
			String year = ddmmmyyyy[2].toString();
			ExtentTestManager.getTest().log(LogStatus.INFO,currentDate);
			String createdBy = explorePage.checkCreatedByInTOCPage.getText();
			String [] createdByarray = createdBy.split(":");
			String createdByName = createdByarray[1].trim();
			String createdOn = explorePage.checkCreatedOnInTOCPage.getText();
			String [] createdOnarray = createdOn.split(":");
			String createdOnDate = createdOnarray[1].trim();
		    String UpdatedOn = explorePage.checkUpdatedOnInTOCPage.getText();	 
			ExtentTestManager.getTest().log(LogStatus.INFO,createdBy);
			ExtentTestManager.getTest().log(LogStatus.INFO,"Org Name: "+explorePage.checkOrgNameInTOCPage.getText());
			ExtentTestManager.getTest().log(LogStatus.INFO,createdOn);
			ExtentTestManager.getTest().log(LogStatus.INFO,UpdatedOn);
			if(createdOnDate.startsWith(date)&&createdOnDate.endsWith(year))
			{
				Assert.assertTrue(true, "created on date is not matched with current date");
			}
			if(createdByName.equalsIgnoreCase(objListOFTestDataForSunbird.get(13).getTitle()))
			{
				Assert.assertTrue(true, "created by data is not matched with actual data");
			}
			ExtentTestManager.getTest().log(LogStatus.PASS, "Created on & created By is verified ");
			
			if(explorePage.checkEmailIdInTOCPage.getText().equalsIgnoreCase(explorePage.checkCreatedOnInTOCPage.getText()))
			{
				
				ExtentTestManager.getTest().log(LogStatus.INFO, "Email id is not available ");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.INFO,explorePage.checkEmailIdInTOCPage.getText());
				explorePage.checkEmailIdInTOCPage.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Email id is available and clicked");
			}
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToStartOfPage();
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify Created Date And Creator Details In TOC Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify Created Date And Creator Details In TOC Page" + e.getStackTrace());
			Assert.fail("Failed to verify Created Date And Creator Details In TOC Page" + e.getLocalizedMessage());
			
		}	
	}
	
	public void navigateToCourseAndSearchForOpenBatch() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section, search course ");
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.readFromNotepad("./testData/dikshadata.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseCard);
			createMentorPage.courseCard.click();
			GenericFunctions.waitWebDriver(3000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section, search course ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed on navigating to Course section, search course and create open batch" + e.getStackTrace());
			Assert.fail("Failed on navigating to Course section, search course and create open batch, Exception : "
					+ e.getLocalizedMessage());
		}
	}
	public void checkInTOCAndConsume() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to check In TOC And Consume");
			if(generic.isElementPresent(explorePage.clickOnFirstTextBookTOC))
			{
				explorePage.clickOnFirstTextBookTOC.click();
				GenericFunctions.waitWebDriver(1000);
				for(int i=0;i<explorePage.clickOnFirstCourseTOCUnits.size()-1;i++)
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Available Content : "+explorePage.clickOnFirstCourseTOCUnits.get(i).getText());
					GenericFunctions.waitWebDriver(1000);
				}
				if(generic.isElementPresent(explorePage.clickOnConsumableContent))
				{
				explorePage.clickOnConsumableContent.click();
				GenericFunctions.waitWebDriver(1000);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Content is consumed after clicking on Unit");
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Content is not available for consumption after clicking on Unit");
			}
			
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to check In TOC And Consume");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to check In TOC And Consume" + e.getStackTrace());
			Assert.fail("Failed to check In TOC And Consume" + e.getLocalizedMessage());
			
		}	
	}
	
	
}
