package org.pageobjects;


	
import java.awt.Robot;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreateMentorPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUp;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
	

	public class CreateMentorPageObj extends BaseTest{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
		CreatorAnnouncementPage createAnnouncementPage=PageFactory.initElements(driver, CreatorAnnouncementPage.class);
		PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
		SignUp signUpPage=PageFactory.initElements(driver, SignUp.class);
		static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
		CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
		Actions action = new Actions(driver);
		Random rand=new Random();
		//String announcementType="Order";
		List <TestDataForSunbird> objListOfTestDataForSunbird= null;
		String batchStatus="Previous Batches";
		String courseName;
		String startDate;
		String endDate;
		
		public void navigateToMyActivityInDropDownMenu() throws InterruptedException
		{
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to My Activity in drop down menu");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.dropDown.click();
				GenericFunctions.waitWebDriver(1000);
				createAnnouncementPage.myActivityInDropdown.click();	
				GenericFunctions.waitWebDriver(1500);
				createMentorPage.SearchCourseDropdown.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.firstCourseDropdownitem.click();
				createMentorPage.rightArrowIcon.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.leftArrowIcon.click();
					
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to My activity");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToMyActivityInDropDownMenu"+e.getLocalizedMessage());
				Assert.fail("Failed on navigating to My activity, Exception : "+e.getLocalizedMessage());
			}
		}
		public void navigateToCourseAndSearch() throws InterruptedException
		{
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section and search course");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toUpperCase());
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section and search course");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToCourseAndSearch"+e.getLocalizedMessage());
				Assert.fail("Failed on navigating to Course section and search course, Exception : "+e.getLocalizedMessage());
			}
		}
		public void navigateToCourseAndSearchForOpenBatch() throws InterruptedException
		{
			
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section, search course and create open batch");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toUpperCase());
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section, search course and create batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToCourseAndSearchForOpenBatch"+e.getLocalizedMessage());
				Assert.fail("Failed on navigating to Course section, search course and create open batch, Exception : "+e.getLocalizedMessage());
			}
		}
		public void navigateToCourseSearchAndUpdate() throws InterruptedException
		{
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section, search course and update the course");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/batchNumbers.txt").toUpperCase());
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
				createMentorPage.editBatch.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.nameOfBatch.clear();
				createMentorPage.nameOfBatch.sendKeys(objListOfTestDataForSunbird.get(1).getCourseName()+ GenericFunctions.testDataIncrementer("./TestData/batchName.txt"));
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.updateBatch.click();
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section, search course and update the course");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToCourseSearchAndUpdate"+e.getMessage());
				Assert.fail("Failed on navigating to Course section, search course and update the course, Exception : "+e.getLocalizedMessage());
			}
		}
		public void navigateToWorkspaceAndSelectBatches(String batchType) throws InterruptedException
		{
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Worskpace and select batch "+batchType);
				GenericFunctions.waitWebDriver(1500);
				createUserPage.dropDown.click();
				GenericFunctions.waitWebDriver(1000);
				createAnnouncementPage.workspaceInDropDown.click();	
				GenericFunctions.waitWebDriver(1500);
				createMentorPage.courseBatches.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.batchesDropDown.click();
				if(batchStatus.equalsIgnoreCase("Ongoing Batches")) {
					GenericFunctions.waitWebDriver(1000);
					createMentorPage.ongoingBatches.click();
					System.out.println("Ongoing batches");
				}else if(batchStatus.equalsIgnoreCase("Upcoming Batches"))
				{
					GenericFunctions.waitWebDriver(1000);
					createMentorPage.upcomingBatches.click();
					System.out.println("upcoming batches");
				}else if(batchStatus.equalsIgnoreCase("Previous Batches"))
				{
					GenericFunctions.waitWebDriver(1000);
					createMentorPage.previousBatches.click();
					System.out.println("Previous batches");
				}					
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and select batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToWorkspaceInDropDownMenu"+e.getMessage());
				Assert.fail("Failed on navigating to Workspace and selecting batch, Exception : "+e.getLocalizedMessage());
			}
		}
		
		public void checkForAuthenticUserAndEdit() throws InterruptedException
		{
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search authentic user and edit");
				GenericFunctions generic = new GenericFunctions();
				CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
				String personName = createMentorPage.profileNameInUserSearch.getText();
				System.out.println(personName);
				boolean elementStatus = generic.isElementPresent(createMentorPage.editIconInUserProfileSearch);	
				if(elementStatus == true)
				{
					
					System.out.println("authenticPerson");
					createMentorPage.editIconInUserProfileSearch.click();
					GenericFunctions.waitWebDriver(1000);
					for(int k=0;k<createMentorPage.selectRoleCheckboxL.size();k++) {
						if(createMentorPage.selectRoleCheckboxL.get(k).isEnabled()) {
							createMentorPage.selectRoleCheckboxL.get(k).click();
							break;
						}else {
							k++;
						}
							
					}
					createMentorPage.updateButtonInUserProfile.click();
					String msg = createMentorPage.successfulMessage.getText();
					System.out.println(msg);
				}	
				
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching authentic user and edit");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method checkForAuthenticUserAndEdit"+e.getMessage());
				Assert.fail("Failed on searching authentic user and edit"+e.getLocalizedMessage());
			}
		}
		
		public void checkForUnauthenticUserAndEdit() throws InterruptedException
		{
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search Unauthentic user and edit");
				GenericFunctions generic = new GenericFunctions();
				CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
				String personName = createMentorPage.profileNameInUserSearch.getText();
				System.out.println(personName);
				boolean elementStatus = generic.isElementPresent(createMentorPage.editIconInUserProfileSearch);	
				if(elementStatus == true)
				{
					System.out.println("UnauthenticPerson" +"edit button is unavailable");

				}	
				
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching authentic user and edit");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method checkForUnauthenticUserAndEdit"+e.getMessage());
				Assert.fail("Failed on searching unauthentic user and edit"+e.getLocalizedMessage());
			}
		}
		
		public void enrollForOpenBatch() throws InterruptedException
		{
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to enroll for an open batch");
				GenericFunctions.waitWebDriver(3000);
				createMentorPage.enrollForOpenBatch.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.enrollForCourse.click();
				
				
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to enroll for an open batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method enrollForOpenBatch"+e.getMessage());
				Assert.fail("Failed to enroll for an open batch, Exception"+e.getLocalizedMessage());
			}
		}
		/*public void navigateToElement( )throws InterruptedException
		{
			
		
			try {
				
				
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to element");
				for (WebElement ele : createMentorPage.courseImg)
				{
					GenericFunctions.waitWebDriver(1000);
					//courseName = ele.getText();
					ele.click();
					//System.out.println(courseName);
					GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
					GenericFunctions.waitWebDriver(1000);
					createMentorPage.calendarStartDate.click();
					startDate = createMentorPage.calendarStartDate.getText();
					System.out.println(startDate);
					createMentorPage.calendarEndDate.click();
					endDate = createMentorPage.calendarEndDate.getText();
					System.out.println(endDate);
					System.out.println("bingo");
					createMentorPage.closeButton.click();	
					//CreateMentorPageObj createMentorPageObj =new CreateMentorPageObj();
					GenericFunctions.waitWebDriver(1000);
//					createMentorPage.batchesDropDown.click();
//					GenericFunctions.waitWebDriver(1000);
//					createMentorPage.previousBatches.click();
				}
			
				
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to element");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToElement"+e.getMessage());
				Assert.fail("Failed to navigate to element, Exception"+e.getLocalizedMessage());
				
			}
		}*/
		
		public void createInviteOnlyBatch() throws InterruptedException, Exception
		{
			//Robot robot = new Robot();
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toUpperCase());
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
				createMentorPage.addIcon.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.nameOfBatch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+ GenericFunctions.testDataIncrementer("./TestData/batchName.txt"));
				createMentorPage.aboutBatch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName());
				createMentorPage.startDate.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.startDateCalendar.click();
				GenericFunctions.waitWebDriver(1000);
				
				//createMentorPage.startDate.sendKeys(objListOfTestDataForSunbird.get(8).getTitle());
				createMentorPage.endDate.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.endDateCalendar.click();
				//createMentorPage.endDate.sendKeys(objListOfTestDataForSunbird.get(8).getTitleDescription());
				createMentorPage.mentorsInBatch.click();
				GenericFunctions.waitWebDriver(2000);
				//createMentorPage.mentorsInBatch.sendKeys(objListOfTestDataForSunbird.get(9).getCourseName());
				createMentorPage.mentor_mentor.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.mentorDropdown.click();
				GenericFunctions.waitWebDriver(1000);
				//GenericFunctions.scrollToElement(createMentorPage.membersInBatch);
				createMentorPage.membersInBatch.click();
				GenericFunctions.waitWebDriver(1000);
				//createMentorPage.membersInBatch.sendKeys("test batch person");
				//GenericFunctions.scrollToElement(createMentorPage.selectMemberInBatch);
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.content_reviewer.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.memberDropdown.click();
				GenericFunctions.waitWebDriver(2000);
				//createMentorPage.aboutBatch.click();
				GenericFunctions.waitWebDriver(3000);
				//GenericFunctions.waitWebDriver(1000);
//				for(int i=1;i<=7;i++)
//				{
//					robot.keyPress(KeyEvent.VK_TAB);
//					robot.keyRelease(KeyEvent.VK_TAB);
//				}
//				GenericFunctions.waitWebDriver(1000);
//
//				robot.keyPress(KeyEvent.VK_ENTER);
//				GenericFunctions.waitWebDriver(1000);
//				robot.keyRelease(KeyEvent.VK_ENTER);
//				GenericFunctions.waitWebDriver(3000);
				
				createMentorPage.buttonCreate.click();
				//createMentorPage.successfulMessage.click();
				System.out.println("Batch Created");
					
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method createInviteOnlyBatch"+e.getMessage());
				Assert.fail("Failed to create invite only batch, Exception"+e.getLocalizedMessage());
			}
		}
		public void createOpenBatch() throws InterruptedException, Exception
		{
			Robot robot = new Robot();
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create open batch for a course");
//				GenericFunctions.waitWebDriver(1500);
//				createUserPage.headerCourse.click();
//				GenericFunctions.waitWebDriver(1000);
//				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./batchNumbers.txt").toUpperCase());
//				createUserPage.searchIcon.click();
//				GenericFunctions.waitWebDriver(2000);
//				createMentorPage.courseImg1.click();
				//GenericFunctions.waitWebDriver(3000);
				createMentorPage.addIcon.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.nameOfBatch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+ GenericFunctions.testDataIncrementer("./TestData/batchName.txt"));
				createMentorPage.aboutBatch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName());
				createMentorPage.openBatch.click();
				createMentorPage.startDate.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.startDateCalendar.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.endDate.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.endDateCalendar.click();
				//createMentorPage.endDate.sendKeys(objListOfTestDataForSunbird.get(8).getTitleDescription());
				GenericFunctions.waitWebDriver(3000);
				createMentorPage.buttonCreate.click();
				//createMentorPage.successfulMessage.click();
				System.out.println("Batch Created");
					
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create open batch");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method createOpenBatch"+e.getMessage());
				Assert.fail("Failed to create open batch, Exception"+e.getLocalizedMessage());
			}
		}
		public void createInviteOnlyBatchForSuborg() throws InterruptedException, Exception
		{
			
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for Sub Organization");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/batchNumbers.txt").toUpperCase());
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
				createMentorPage.addIcon.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.nameOfBatch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+ GenericFunctions.testDataIncrementer("./TestData/batchName.txt"));
				createMentorPage.aboutBatch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName());
				createMentorPage.startDate.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.startDateCalendar.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.endDate.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.endDateCalendar.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPage.mentorsInBatch.click();
				GenericFunctions.waitWebDriver(1000);
				//createMentorPage.mentorsInBatch.sendKeys(objListOfTestDataForSunbird.get(9).getCourseName());
				createMentorPage.mentor_mentor .click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.mentorDropdown.click();
				createMentorPage.membersInBatch.click();
				GenericFunctions.waitWebDriver(1000);
				//createMentorPage.membersInBatch.sendKeys("test batch person");
				//GenericFunctions.scrollToElement(createMentorPage.selectMemberInBatch);
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions generic = new GenericFunctions();
				generic.isElementPresent(createMentorPage.orgAdminInBatch);
				System.out.println("Batch not Created");
					
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch for Sub Organization");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method createInviteOnlyBatchForSuborg"+e.getMessage());
				Assert.fail("Failed to create invite only batch for Sub Organization, Exception"+e.getLocalizedMessage());
			}
		}
		public void navigateToCourseAndSearchForCourse() throws InterruptedException
		{
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Course And Search For Course");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/courseNumbers.txt"));
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Course And Search For Course");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToCourseAndSearchForCourse"+e.getMessage());
				Assert.fail("Failed to navigate To Course And Search For Course, Exception"+e.getLocalizedMessage());
			}
		}
		public void navigateToLibraryAndSearchForCollection() throws InterruptedException
		{
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Collection");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerLibrary.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/collectionNumbers.txt"));
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Collection");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToLibraryAndSearchForCollection"+e.getMessage());
				Assert.fail("Failed to navigate To Library And Search For Collection, Exception"+e.getLocalizedMessage());
			}
		}
		
		public void navigateToLibraryAndSearchForBook() throws InterruptedException
		{
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Book");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerLibrary.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(2).getCourseName()+GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt"));
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Book");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToLibraryAndSearchForBook"+e.getMessage());
				Assert.fail("Failed to navigate To Library And Search For Book, Exception"+e.getLocalizedMessage());
			}
		}
		public void navigateToLibraryAndSearchForLessonPlan() throws InterruptedException
		{
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For LessonPlan");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerLibrary.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(3).getCourseName()+GenericFunctions.readFromNotepad("./TestData/lessonPlan.txt"));
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For LessonPlan");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToLibraryAndSearchForLessonPlan"+e.getMessage());
				Assert.fail("Failed to navigate To Library And Search For LessonPlan, Exception"+e.getLocalizedMessage());
			}
		}
		
		public void viewCourseStats()
		{
			try
			{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to view the course stats");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.viewCourseStat.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.fromBeginning.click();
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to view the course stats");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method viewCourseStats"+e.getMessage());
				Assert.fail("Failed to view the course stat, Exception"+e.getLocalizedMessage());

			}
		}
		public void navigateToLibraryAndSearchForEdittedBook() throws InterruptedException
		{
			objListOfTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			try{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Book");
				GenericFunctions.waitWebDriver(1500);
				createUserPage.headerLibrary.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.filterSearch.sendKeys(objListOfTestDataForSunbird.get(2).getCourseName());//+GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt"));
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
				createMentorPage.courseImg1.click();
				GenericFunctions.waitWebDriver(3000);
			}
			catch(Exception e){
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Book");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				log.error("Exception In the method navigateToLibraryAndSearchForBook"+e.getMessage());
				Assert.fail("Failed to navigate To Library And Search For Book, Exception"+e.getLocalizedMessage());
			}
		}

	}
	
	

