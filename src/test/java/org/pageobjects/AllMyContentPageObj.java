package org.pageobjects;


import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.AllMyContentPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.WorkspacePage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AllMyContentPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	AllMyContentPage allMyContentPage=PageFactory.initElements(driver, AllMyContentPage.class);
	CreatorUserPage createUserPage= PageFactory.initElements(driver, CreatorUserPage.class);
	WorkspacePage workspacePage = PageFactory.initElements(driver, WorkspacePage.class);

	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	GenericFunctions genericFunction = new GenericFunctions();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	Random rand=new Random();
	String a="Browse";
	String title="";
	String deletedContent;

	/**
	 * Purpose: allMyContentSortByDropdown method is used to check data is getting available in all my content based on selected sort by option .
	 */
	public void allMyContentSortByDropdown()throws Exception
	{
		String contentBeforeSorting=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to  select modified on and created on option in the dropdown");			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(allMyContentPage.sortByDropdown);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReview.get(0));
			contentBeforeSorting=createUserPage.searchCoursesUpForReview.get(0).getText().trim();
			System.out.println("contentBeforeModifiedSorting-"+contentBeforeSorting);
			allMyContentPage.sortByDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			allMyContentPage.modifiedOnDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			try
			{
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReview.get(0));
				if(createUserPage.searchCoursesUpForReview.get(0).isDisplayed())
				{
					
					String contentAfterSortingModifiedOn= createUserPage.searchCoursesUpForReview.get(0).getText().trim();
					System.out.println("content after Modified sorting -"+contentAfterSortingModifiedOn);
					if(contentBeforeSorting!=contentAfterSortingModifiedOn)
					{

						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Recently modified contents are listed at the top, Type-"
								+workspacePage.contentTypeAndTimeInAllMyContent.get(0).getText().trim()+
								" and Time-"+workspacePage.contentTypeAndTimeInAllMyContent.get(1).getText().trim());
					}
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not get the contents after applying Modified-On Sorting , "+e.getLocalizedMessage());
				log.info("Could not get the contents after applying Modified-On Sorting, Exception "+e.getStackTrace());
				Assert.fail("Could not get the contents after applying Modified-On Sorting");
			}

			GenericFunctions.waitWebDriver(2000);
			allMyContentPage.allMyContent.click();
			GenericFunctions.waitForElementToAppear(allMyContentPage.sortByDropdown);
			allMyContentPage.sortByDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			allMyContentPage.createdOnDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			
			try
			{
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReview.get(0));
				String contentAfterSortingCreatedOn= createUserPage.searchCoursesUpForReview.get(0).getText().trim();
				System.out.println("contentAfterSortingCreatedOn-"+contentAfterSortingCreatedOn);
				if(contentBeforeSorting!=contentAfterSortingCreatedOn)
				{
					Assert.assertTrue(true);	
					ExtentTestManager.getTest().log(LogStatus.PASS, "Recently Created contents are listed at the top, Type-"
							+workspacePage.contentTypeAndTimeInAllMyContent.get(0).getText().trim()+
							" and Time-"+workspacePage.contentTypeAndTimeInAllMyContent.get(1).getText().trim());
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not get the contents after applying Created-On Sorting, "+e.getLocalizedMessage());
				log.info("Could not get the contents after applying Created-On Sorting, Exception "+e.getStackTrace());
				Assert.fail("Could not get the contents after applying Created-On Sorting, Exception "+e.getLocalizedMessage());
			}
			
			GenericFunctions.waitWebDriver(2000);
		}
		catch (Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on selecting options from dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method allMyContentSortByDropdown" + e.getLocalizedMessage());
			Assert.fail("Failed on selecting options from dropdown" + e.getLocalizedMessage());
		}
	}

	/**
	 * Purpose: clickAllMyContent method is used to navigate to all my content & select filter  .
	 */
	public void clickAllMyContent()throws Exception
	{
		try{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content and then filter icon");
			GenericFunctions.waitForElementToAppear(allMyContentPage.allMyContent);
			allMyContentPage.allMyContent.click();
			GenericFunctions.waitWebDriver(2000);		
			allMyContentPage.filterIcon.click();				
			GenericFunctions.waitWebDriver(2000);				
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("failed to click filter icon");
		}
	}	
	/**
	 * Purpose: deleteByStatus method is used to delete the content by using status filter  .
	 */
	public void deleteByStatus(String statusContent)throws Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
			GenericFunctions.waitForElementToAppear(allMyContentPage.selectStatus);
			allMyContentPage.selectStatus.click();
			if(statusContent.equalsIgnoreCase("DRAFT")){
				allMyContentPage.draftSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("FLAGDRAFT")){
				allMyContentPage.flagDraftSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("REVIEW")){
				allMyContentPage.reviewSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("PROCESSING")){
				allMyContentPage.processingSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("LIVE")){
				allMyContentPage.liveSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("UNLISTED")){
				allMyContentPage.unlistedSelect.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(statusContent.equalsIgnoreCase("FLAGREVIEW")){
				allMyContentPage.flagReviewSelect.click();
				GenericFunctions.waitWebDriver(2000);
			} 
			allMyContentPage.applyButton.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPage.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);
			try{
				if(driver.findElement(By.xpath("(//div[contains(@class,'UpReviewHeader')])[1]")).isDisplayed() ){
					String contentType = allMyContentPage.firstDraft.getText();
					allMyContentPage.deleteButton.click();					
					GenericFunctions.waitWebDriver(2000);		
					allMyContentPage.confirmYesToPopup.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true,"Content got deleted successfully");
					System.out.println("Content got deleted successfully");
					log.info("Content got deleted successfully");

					allMyContentPage.searchContent.click();
					allMyContentPage.searchContent.sendKeys(contentType);
					Assert.assertTrue(true,"Deleted content is not available in search result");
					System.out.println("Deleted content is not available in search result");
					log.info("Deleted content is not available in search result");
					GenericFunctions.waitWebDriver(4000);

					allMyContentPage.filterIcon.click();
					GenericFunctions.waitWebDriver(2000);

					allMyContentPage.resetFilter.click();

				}
			}

			catch(Exception e){

				allMyContentPage.filterIcon.click();
				GenericFunctions.waitWebDriver(2000);

				allMyContentPage.resetFilter.click();
				GenericFunctions.waitWebDriver(2000);			
			}	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on deleting content by status");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method deleteByStatus" + e.getLocalizedMessage());
			Assert.fail("Failed on deleting content by status" + e.getLocalizedMessage()); 			 
		}
	}


	/**
	 * Purpose: allMyContent method is used to navigate to all my content  .
	 */

	public void allMyContent()throws Exception
	{
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content");
			allMyContentPage.allMyContent.click();
			GenericFunctions.waitWebDriver(2000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("failed on clicking all my content");
		}

	}


	/**
	 * 
	 * deleteContent method is used to delete the content in all my content using search bar and filters.
	 * @param PublishedContent 
	 * @return deletedContent
	 * @throws Exception
	 */
	public String deleteContent(String PublishedContent)throws Exception
	{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
			GenericFunctions.waitForElementToAppear(allMyContentPage.searchContent);				
			if(PublishedContent.equalsIgnoreCase("COURSE")){
				allMyContentPage.searchContent.sendKeys("COURSE");
				allMyContentPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(4000);
			}
			else if(PublishedContent.equalsIgnoreCase("COLLECTION")){
				allMyContentPage.searchContent.sendKeys("COLLECTION");
				allMyContentPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("LESSON PLAN")){
				allMyContentPage.searchContent.sendKeys("LESSON PLAN");
				allMyContentPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("RESOURCES")){
				allMyContentPage.searchContent.sendKeys("RESOURCES");
				allMyContentPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("BOOK")){
				allMyContentPage.searchContent.sendKeys("BOOK");
				allMyContentPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(PublishedContent.equalsIgnoreCase("CONTENT")){
				allMyContentPage.searchContent.sendKeys("CONTENT");
				allMyContentPage.searchIconUpForReview.click();
				GenericFunctions.waitWebDriver(2000);
			} 

			allMyContentPage.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPage.selectStatus.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPage.liveSelect.click();
			GenericFunctions.waitWebDriver(2000);

			allMyContentPage.applyButton.click();
			GenericFunctions.waitWebDriver(2000);	

			allMyContentPage.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);

			try{
				if(allMyContentPage.firstDraft.isDisplayed())
				{
					deletedContent = allMyContentPage.firstDraft.getText();
					allMyContentPage.deleteButton.click();
					GenericFunctions.waitWebDriver(2000);
					allMyContentPage.yesButtonPopup.click();
					Assert.assertTrue(true, "User is  able to delete the content successfully");
					ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to delete the content successfully");
					System.out.println("User is able to delete the content successfully");
					GenericFunctions.waitWebDriver(2000);
					allMyContentPage.searchContent.clear();
					allMyContentPage.searchContent.sendKeys(deletedContent);
					String availableContent = allMyContentPage.firstDraft.getText();
					GenericFunctions.waitWebDriver(1000);
					Assert.assertNotEquals(deletedContent, availableContent, "Deleted content is available in search result");
					ExtentTestManager.getTest().log(LogStatus.PASS, "Deleted content not available in search result");
					GenericFunctions.waitWebDriver(4000);
				}
			}
			catch(Exception e)
			{
				System.out.println("There is no content");
			}
		}
		catch(Exception e)
		{				
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is unable delete content by status");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User is unable delete content by status");
		}
		return deletedContent;
	}	

	/**
	 * Purpose: clickWorkspace method is used to navigate to workspace.
	 */
	public void clickWorkspace()throws Exception
	{
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all workspace");	
			GenericFunctions.waitForElementToAppear(allMyContentPage.workSpace);
			allMyContentPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);				
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to click on all workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User is trying to click on all workspace");
		}
	}

	/**
	 * Purpose: allMyContent method is used to navigate to all my content  .
	 */

	public void publishedSection()throws Exception
	{
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on published section");
			allMyContentPage.published.click();
			GenericFunctions.waitWebDriver(2000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking published section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("failed on clicking published section");
		}

	}
	/**
	 * Purpose: searchInLibrary method is used to search a content in library
	 *   .
	 */
	public void searchInLibrary(String contentDeleted) throws Exception
	{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the library search");
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchInput.clear();
			createUserPage.searchInput.sendKeys(contentDeleted);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			boolean status = genericFunction.isElementPresent(publicUserPage.showResults);
			Assert.assertEquals(status,false, "Element is present on page");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in library and getting the results");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Could not search and get the results in the library");
			Assert.fail("Failed on searching in the library");
		}

	}

}



