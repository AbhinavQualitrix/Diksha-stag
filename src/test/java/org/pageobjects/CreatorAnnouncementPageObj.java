package org.pageobjects;


import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.AllUploadingPaths;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.relevantcodes.extentreports.LogStatus;


public class CreatorAnnouncementPageObj extends BaseTest{

	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	CreatorAnnouncementPage createAnnouncementPage=PageFactory.initElements(driver, CreatorAnnouncementPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	Actions action = new Actions(driver);
	Random rand=new Random();
	List <TestDataForDiksha> objListOFTestDataForDiksha= null;


	public void navigateToAnnouncementInDropDownMenu() throws InterruptedException
	{
		try{
			//String expectedDashboardUrl="https://staging.open-sunbird.org/announcement/outbox/1";
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to announcement dashboard in drop down menu");
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.announcement_Dashboard.click();	
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.create_Announcement);
			if(createAnnouncementPage.create_Announcement.isDisplayed())
			{
				GenericFunctions.waitWebDriver(2000);
				//Assert.assertEquals(driver.getCurrentUrl(), expectedDashboardUrl);
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Announcement dashboard is sucessfully visible to user");
				GenericFunctions.waitWebDriver(2000);
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating announcement in drop down menu");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToAnnouncementInDropDownMenu"+e.getMessage());
			Assert.fail("Failed on navigating to announcement dashboard in drop down menu, Exception : "+e.getLocalizedMessage());

		}
	}

	public String createAnnouncement() throws InterruptedException, Exception
	{
		String announcementName =null;

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create an announcement");
			objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.create_Announcement);
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.enterTitle);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForDiksha.get(7).getCourseName()+announcementNumber;
			System.out.println(announcementName);
			createAnnouncementPage.enterTitle.sendKeys(announcementName);
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForDiksha.get(7).getCourseDescription());
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForDiksha.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys("https://www.google.com/");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.selectRecipient);
			/*action.moveToElement(createAnnouncementPage.selectRecipient).build().perform();
			action.click().build().perform();*/
			
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			GenericFunctions.waitWebDriver(2000);
			for(WebElement el:createAnnouncementPage.checkLocation)
			{	
				el.click();
				
			}
			//action.moveToElement(createAnnouncementPage.checkLocation).click().build().perform();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.confirmRecipients);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.confirmRecipients);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.previewAnnouncement);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.previewAnnouncement);
			//createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.sendAnnouncement);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.sendAnnouncement);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementSent);
			if(createAnnouncementPage.announcementSent.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Annoucement Has been successfully Created and sent to the Recipients ");
				createAnnouncementPage.gotIt.click();
			}
			
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed to create an announcement, Exception : "+e.getLocalizedMessage());
		}
		
		return announcementName;
	}

	public void CreateAnnouncementUsingAttachment() throws InterruptedException, Exception
	{
		String announcementName =null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create an announcement using an attachment");
			objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.create_Announcement);		
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.enterTitle);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForDiksha.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForDiksha.get(7).getCourseDescription());
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForDiksha.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			/*createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys("https://www.google.com/");*/
			GenericFunctions.waitWebDriver(4000);
			action.moveToElement(createAnnouncementPage.uploadDocument).click().build().perform();
		
			//action.click().build().perform();
			GenericFunctions.waitWebDriver(3000);
			//String path = System.getProperty("user.dir")+"\\uploadingDocuments\\upload Document Contents\\"+IMAGE;
			GenericFunctions.waitWebDriver(3000);
			//String path = System.getProperty("user.dir")+"/UploadingDocuments/Upload Document Contents/"+IMAGE;
			GenericFunctions.uploadFile(AllUploadingPaths.attachmentImagePath);
			GenericFunctions.waitWebDriver(5000);
			
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.selectRecipient);
			/*action.moveToElement(createAnnouncementPage.selectRecipient).build().perform();
			action.click().build().perform();*/
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			GenericFunctions.waitWebDriver(3000);
			createAnnouncementPage.checkLocation.get(0).click();
			createAnnouncementPage.checkLocation.get(1).click();
			createAnnouncementPage.checkLocation.get(2).click();
			//action.moveToElement(createAnnouncementPage.checkLocation).click().build().perform();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.confirmRecipients);
			//createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.previewAnnouncement);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.previewAnnouncement);
			//createAnnouncementPage.previewAnnouncement.click();
			//GenericFunctions.waitForElementToAppear(createAnnouncementPage.sendAnnouncement);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.sendAnnouncement);
			//createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(3000);
			//GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementcreatedConfirmation);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.announcementcreatedConfirmation);
			//createAnnouncementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.PASS, "An Announcement along with the attachment is created sucessfully");
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement using an attachment");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed on creating an announcement using an attachment, Exception : "+e.getLocalizedMessage());
		}

	}
	
	public void checkForAnnouncement(String announcementName)
	{
		String announcementnameReview;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Check for the created announcement in the Home Page");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForPageToLoad(createAnnouncementPage.seeAllAnnouncement);
			createAnnouncementPage.seeAllAnnouncement.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.reviewAnnouncementN);
			announcementnameReview = createAnnouncementPage.reviewAnnouncementN.getText().trim();

			Assert.assertEquals(announcementnameReview, announcementName,"failed on asserting announcement names");
			createAnnouncementPage.reviewAnnouncementN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.popupCloseIcon);
			createAnnouncementPage.popupCloseIcon.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Announcement has successfully received by the recipients "+announcementName);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to find the announcement in the Home Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method checkForAnnouncement "+e.getMessage());
			Assert.fail("User failed to find the announcement in the Home Page "+e.getLocalizedMessage());
		}
	}
	public void deleteAnnouncement()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify deleting of an Announcement from the list");
			
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElements(createAnnouncementPage.deleteAnnouncementButton);
			
			try
			{
				createAnnouncementPage.deleteAnnouncementButton.get(0).click();
				
			}
			catch(Exception de)
			{
				System.out.println("Could not find 'Delete' in this page "+de.getLocalizedMessage());
				GenericFunctions.waitWebDriver(1000);
				action.moveToElement(createAnnouncementPage.viewNextPage);
				createAnnouncementPage.viewNextPage.click();
				deleteAnnouncement();
			}
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.yesButtonPopup);
			if(createUserPage.yesButtonPopup.isDisplayed())
			{
				Assert.assertTrue(true);
				createUserPage.yesButtonPopup.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementCancelledMessage);
				createAnnouncementPage.announcementCancelledMessage.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Deleted Successfully "+createAnnouncementPage.announcementCancelledMessage.getText());
			}
			
	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to delete the announcement in the Home Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method deleteAnnouncement "+e.getMessage());
			Assert.fail("User failed to delete the announcement in the Home Page "+e.getLocalizedMessage());
		}
	}
	public void checkDeletedAnnouncement(String announcement)
	{
	
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the deleted Announcement from All Announcements");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.seeAllAnnouncement);
			createAnnouncementPage.seeAllAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.refreshWebPage();
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElements(createAnnouncementPage.reviewAnnouncement);
			createAnnouncementPage.reviewAnnouncement.get(0).getText();
			boolean announcementValue = announcement.equalsIgnoreCase(createAnnouncementPage.reviewAnnouncement.get(0).getText());
			
			
			if(announcementValue==false)
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Deleted Announcement is not available to the receiver");
			}
				
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to delete the announcement in the Home Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method deleteAnnouncement "+e.getMessage());
			Assert.fail("User failed to delete the announcement in the Home Page "+e.getLocalizedMessage());
		}
	}
	public void checkForAnnouncementWithAttachment(String announcementName2)
	{
		String announcementnameReview;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Check for the created announcement with attachement in the Home Page");
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.seeAllAnnouncement.click();
			GenericFunctions.waitWebDriver(1500);
			announcementnameReview = createAnnouncementPage.reviewAnnouncementN.getText();
			Assert.assertEquals(announcementName2, announcementnameReview);
			createAnnouncementPage.reviewAnnouncementN.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to find the announcement with attachment in the Home Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method checkForAnnouncementWithAttachment "+e.getMessage());
			Assert.fail("User failed to find the announcement with attachment in the Home Page "+e.getLocalizedMessage());
		}
	}
	public void openAnnouncement()
	{
		String announcementName =null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to open announcement in the Home Page");
			GenericFunctions.waitWebDriver(1000);
			CreatorAnnouncementPage createAnnouncementPage = PageFactory.initElements(driver,CreatorAnnouncementPage.class);
			announcementName = createAnnouncementPage.announcementTableNameContent.getText();
			createAnnouncementPage.announcementTableNameContent.click();
			System.out.println(announcementName);
			GenericFunctions.waitWebDriver(1000);
			String verifyannouncementName = createAnnouncementPage.announcementReview.getText();
			AssertJUnit.assertEquals(announcementName, verifyannouncementName);
			System.out.println("Announcement is verified");
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.CloseAnnouncementPopup.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to open announcement in the Home Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method open announcement in the Home Page "+e.getMessage());
			Assert.fail("User failed to open announcement in the Home Page "+e.getLocalizedMessage());
		}
	}
	public String verifyResendingOfAnnouncement()
	{
		String editTitle=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to resend an Announcement from the existing list");
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElements(createAnnouncementPage.resendAnnouncementButton);
			System.out.println("No of Resend announcements -"+createAnnouncementPage.resendAnnouncementButton.size());
			
			try
			{
				createAnnouncementPage.resendAnnouncementButton.get(1).click();
				
			}
			catch(Exception re)
			{
				System.out.println("Could not find Resend in this page "+re.getLocalizedMessage());
				GenericFunctions.waitWebDriver(1000);
				action.moveToElement(createAnnouncementPage.viewNextPage);
				createAnnouncementPage.viewNextPage.click();
				verifyResendingOfAnnouncement();
			}
				
			GenericFunctions.waitWebDriver(2000);
			objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.enterTitle);
			createAnnouncementPage.enterTitle.click();
			createAnnouncementPage.enterTitle.clear();
			String announcementNumber = GenericFunctions.readFromNotepad("./testData/announcementNumbers.txt").toString().toUpperCase();
			editTitle = "Re-Announcement "+announcementNumber;
			createAnnouncementPage.enterTitle.sendKeys(editTitle);
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.selectRecipient);
			action.moveToElement(createAnnouncementPage.selectRecipient).build().perform();
			action.click().build().perform();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			createAnnouncementPage.checkLocation.get(0).click();
			createAnnouncementPage.checkLocation.get(1).click();
			//action.moveToElement(createAnnouncementPage.checkLocation).click().build().perform();
			GenericFunctions.waitWebDriver(2000);
			*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createAnnouncementPage.editRecipients);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.editRecipients);
			//createAnnouncementPage.editRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.searchForLocation);
			//createAnnouncementPage.searchForLocation.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.confirmRecipients);
			//createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			//GenericFunctions.waitForElementToAppear(createAnnouncementPage.previewAnnouncement);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.previewAnnouncement);
			//createAnnouncementPage.previewAnnouncement.click();
			//GenericFunctions.waitForElementToAppear(createAnnouncementPage.sendAnnouncement);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.sendAnnouncement);
			//createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(3000);
			//GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementcreatedConfirmation);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.announcementcreatedConfirmation);
			//createAnnouncementPage.announcementcreatedConfirmation.click();
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementSent);
			if(createAnnouncementPage.announcementSent.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Annoucement Has been successfully Resent to the Recipients "+editTitle);
				createAnnouncementPage.gotIt.click();
			}
			
			
			/*
			String edittedTitle = createAnnouncementPage.resendAnnouncementName.getText();
			System.out.println(edittedTitle);
			Assert.assertEquals(announcementName, edittedTitle);
			System.out.println("updated info verified");*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to resend announcement in the Home Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method resend announcement in the Home Page "+e.getMessage());
			Assert.fail("User failed to resend announcement in the Home Page "+e.getLocalizedMessage());
		}
		
		return editTitle;
	}
	
	/*
	 * purpose : TO verify that received the Resent Announcement 
	 */
	
	public void verifyReceivedResentAnnouncement(String announcementName)
	{
		String announcementnameReview=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that received the resent announcement");			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.seeAllAnnouncement);
			createAnnouncementPage.seeAllAnnouncement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.reviewAnnouncementN);
			announcementnameReview = createAnnouncementPage.reviewAnnouncementN.getText().trim();
			System.out.println("announcementnameReview "+announcementnameReview);
			Assert.assertEquals(announcementnameReview,announcementName);
			createAnnouncementPage.reviewAnnouncementN.click();	
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.popupCloseIcon);
			createAnnouncementPage.popupCloseIcon.click();
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Resent Announcement is available to the user "+announcementName);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that received resent the Announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Failed to verify that received resent the Announcement"+e.getMessage());
			Assert.fail("Failed to verify that received resent the Announcement"+e.getLocalizedMessage());
			
		}
	}
}
