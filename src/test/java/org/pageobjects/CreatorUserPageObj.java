/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 06/20/2018

* Purpose: All the reusable methods of creator page.
*/
package org.pageobjects;

import java.awt.Robot;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUp;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CreatorUserPageObj extends BaseTest{

	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	SignUp signUpPage=PageFactory.initElements(driver, SignUp.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	String lessonNumber;

	public void navigateToWorkspace(String createVariable)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is navigating to the Workspace to create "+createVariable);
			GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1500);
			if(createVariable.equalsIgnoreCase(createUserPage.createCourse.getText()))
			{
				createUserPage.createCourse.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createBook.getText()))
			{
				createUserPage.createBook.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createResource.getText()))
			{
				createUserPage.createResource.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createCollection.getText()))
			{
				createUserPage.createCollection.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createLesson.getText()))
			{
				createUserPage.createLesson.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.createUploadContent.getText()))
			{
				createUserPage.createUploadContent.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.published.getText()))
			{
				createUserPage.published.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.drafts.getText()))
			{
				createUserPage.drafts.click();
				GenericFunctions.waitWebDriver(1500);
			}
			else if(createVariable.equalsIgnoreCase(createUserPage.allMyContent.getText()))
			{
				createUserPage.allMyContent.click();
				GenericFunctions.waitWebDriver(1500);
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on navigating to Workspace");
			Assert.fail("Failed on navigating to Workspace and create "+createVariable);
		}

	}

	public void createCourse(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./TestData/courseNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.titleName.click();
			createUserPage.titleName.clear();
			createUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createCourse"+e.getMessage());
			System.out.println("Exception In the method createCourse, failed to create corse");
			Assert.fail("Failed on creating course");
		}
	}
	public void createCourseForOpenBatch(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./TestData/dikshadata.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.titleName.click();
			createUserPage.titleName.clear();
			createUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			//GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.selectResourceN.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			log.error("Exception In the method createCourse"+e.getMessage());
		}
	}

	public void saveAndSendCourseForReview(List <TestDataForSunbird> objListOFTestDataForSunbird)throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.sendForReview.click();
			createUserPage.clickAppIcon.click();	
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review");

		}

	}
//need to be verified
	public void saveAndSendBookForReview(List <TestDataForSunbird> objListOFTestDataForSunbird)throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send book for for review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.sendForReview.click();
			createUserPage.clickAppIcon.click();	
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickOnSelectCurriculum.click();
			createUserPage.selectCurriculum.click();
			GenericFunctions.selectValueFromDropdown(driver,createUserPage.selectCurriculum.toString(),"NCERT");
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectClass.click();
			GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
			//createUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			createUserPage.selectSubject.click();
			createUserPage.clickOnSelectMedium.click();
			createUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending the book for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and send book for review"+e.getLocalizedMessage());
			Assert.fail("Failed to save and send the book for review");

		}

	}

	public void searchInUpForReview(String source,List <TestDataForSunbird> objListOFTestDataForSunbird) throws Exception{
		try{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search in Up For Review bucket for "+source);
			String courseNumber = "",searchCourseName="";
			GenericFunctions.waitWebDriver(3000);
			publicUserPage.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			if(source.equalsIgnoreCase(COURSE)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/courseNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(BOOK)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(RESOURCE)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(COLLECTION)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/collectionNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(LESSONPLAN)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/lessonPlan.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			assertFoundInUpForReview(searchCourseName);
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}

	}
	public void searchInUpForReviewForOpenbatch(String source,List <TestDataForSunbird> objListOFTestDataForSunbird) throws Exception{
		try{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search in Up For Review bucket for "+source);
			String courseNumber = "",searchCourseName="";
			GenericFunctions.waitWebDriver(3000);
			publicUserPage.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			if(source.equalsIgnoreCase(COURSE)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(BOOK)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(RESOURCE)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(COLLECTION)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(LESSONPLAN)){
				courseNumber = GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			assertFoundInUpForReview(searchCourseName);
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}

	}



	public void reviewInSubmissions(String source, List <TestDataForSunbird> objListOFTestDataForSunbird){

		try{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify "+source+" is found in review submission");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.reviewSubmission);
			createUserPage.reviewSubmission.click();
			//assertFoundInReviewSubmission(source,objListOFTestDataForSunbird);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to find in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Failed to find in review submission bucket"+e.getLocalizedMessage());
		}

	}

	public static void assertFoundInReviewSubmission(String source,List <TestDataForSunbird> objListOFTestDataForSunbird){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To assert that "+source+" is found in review submission");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			if(source.equalsIgnoreCase(COURSE)){
				String courseNumber = GenericFunctions.readFromNotepad("./TestData/courseNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Found: Submitted for Review");
						System.out.println(courseName+"Course Found: Course Submitted for Review");
						log.info(courseName+"Course Found: Course Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding course in review submission");
					}
				}
			}
			else if(source.equalsIgnoreCase(BOOK)){

				String courseNumber = GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Book: Submitted for Review");
						System.out.println(courseName+"Book Found: Course Submitted for Review");
						log.info(courseName+"Book Found: Course Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding book in review submission");
					}
				}
			}
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to assert in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			Assert.fail("Failed on asserting in review submission bucket");

		}
	}

	public static void assertCourseFoundInSearch(String searchCourseName){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that course is found in search");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			//String courseNumber = GenericFunctions.readFromNotepad(".//TestData/courseNumbers.txt").toString();
			for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
				String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Course Found in Search");
					System.out.println(courseName+"Course Found in Search");
					log.info(courseName+" Course Found in Search");
					break;
				}
				else
				{				
					log.info("Still finding course in review submission");
				}
			}
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching for course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on searching the course");
		}
	}

	public static void assertFoundInUpForReview(String searchCourseName){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To assert that course is found in Up for review");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			//String courseNumber = GenericFunctions.readFromNotepad(".//TestData/courseNumbers.txt").toString();
			GenericFunctions.waitForElementToAppear(createUserPage1.searchCoursesUpForReviewE);
			for(int i=0;i<createUserPage1.searchCoursesUpForReview.size();i++){
				String courseName = createUserPage1.searchCoursesUpForReview.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Found in up for review");
					createUserPage1.searchCoursesUpForReview.get(i).click();
					System.out.println(courseName+"Found and Clicked in up for review");
					log.info(courseName+"Found and Clicked in up for review");
					break;
				}
				else
				{				
					log.info("Still finding in up for review");
				}
			}
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying the asserrtion in Up for review bucket ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on asserting the course in Up for review bucket");
		}
	}

	public static void assertOnSearchAfterPublish(String searchCourseName){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that "+searchCourseName+" is found on searching after publishing");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			//String courseNumber = GenericFunctions.readFromNotepad(".//TestData/courseNumbers.txt").toString();
			for(int i=0;i<createUserPage1.searchPublishedCourses.size();i++){
				String courseName = createUserPage1.searchPublishedCourses.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Found in Search");
					System.out.println(courseName+"Found in Search");
					log.info(courseName+" Found in Search");
					break;
				}
				else
				{				
					log.info("Still finding course in review submission");
				}
			}
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching the course after publishing it");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on asserting the course after publishing");
		}
	}

	public void createBook(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try {
		
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a book");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String bookNumber = GenericFunctions.testDataIncrementer("./TestData/bookNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+bookNumber);
			createUserPage.clickBBoard.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBBoard);
			createUserPage.selectBBoard.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBGrade.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBGrade);
			createUserPage.selectBGrade.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBSubject);
			createUserPage.selectBSubject.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBMedium.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBMedium);
			createUserPage.selectBMedium.click();
			createUserPage.BPublisher.sendKeys(PUBLISHER);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickBYear.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBYear);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectBYear.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.bookTitle.click();
			createUserPage.bookTitle.clear();
			createUserPage.bookTitle.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+bookNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.selectResource.click();
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(1500);
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating a book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create a book");
			Assert.fail("Failed on creating a book");
			
		}
	}
	public String getBookName()
	{
		//GenericFunctions.testDataIncrementer();
		String course = GenericFunctions.randomCourseName();
		String generatedName=GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt");
		System.out.println(generatedName+course);
		return generatedName+course;
	}

	public void createLessonPlan()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a lesson plan");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(LESSONPLAN);
			//GenericFunctions.waitWebDriver(2000);
			String myWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(myWindowHandle);
			lessonNumber = GenericFunctions.testDataIncrementer("./TestData/lessonPlan.txt")+getBookName();
			//createUserPage.clickOnPopup.click();

			createUserPage.bookName.sendKeys(lessonNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBBoard.click();
			createUserPage.selectBBoard.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBGrade.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectBGrade.click();
			//createUserPage.clickOnPopup.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBSubject.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectBSubject.click();
			createUserPage.clickBMedium.click();
			//createUserPage.clickOnPopup.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectBMedium.click();
			GenericFunctions.waitWebDriver(2000);

			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
			System.out.println(createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(2500);
			//createUserPage.newChild.click();	
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(5000);

			createUserPage.lessonTitle.clear();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(3).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.lessonResource.click();
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickAppIcon.click();
			createUserPage.selectLessonIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(5000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating the lesson plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create the new lesson plan");
			Assert.fail("Failed on creating the lesson plan");
		}
	}

	public void goToWorkspaceAndPublish(String inputToSearch)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go To Workspace And Publish");
		
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt"));
			GenericFunctions.waitWebDriver(3000);
			//	String compare=createUserPage.searchedContentForPublish.getText();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(7000);			
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.scrollToElement(createUserPage.publishButton);
			GenericFunctions.waitWebDriver(4500);
			createUserPage.publishButton.click();
			GenericFunctions.waitWebDriver(1000);
			for(int i=0;i<createUserPage.checkbox.size();i++)
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	 
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			System.out.println("Content Published");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on going To Workspace And Publish");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to go To Workspace And Publish");
			Assert.fail("Failed on going To Workspace And Publish");
		}	
	}
	
	public void publishAndSearch(String source,List <TestDataForSunbird> objListOFTestDataForSunbird){
		try{
			String courseNumber="",searchCourseName="";
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search "+source);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.publishCourseButton);
			createUserPage.publishCourseButton.click();
			for(int i=0;i<createUserPage.checkbox.size();i++){
				createUserPage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(1500);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			driver.switchTo().defaultContent();
			if(source.equalsIgnoreCase(COURSE))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				courseNumber = GenericFunctions.readFromNotepad("./TestData/courseNumbers.txt").toString();
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
			}
			else if(source.equalsIgnoreCase(BOOK))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
				createUserPage.headerLibrary.click();
				courseNumber = GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt").toString();
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
			}
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search "+source);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed to publish and search");
		}

	}
	public void publishAndSearchForOpenBatch(String source,List <TestDataForSunbird> objListOFTestDataForSunbird){
		try{
			String courseNumber="",searchCourseName="";
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search "+source);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.publishCourseButton);
			createUserPage.publishCourseButton.click();
			for(int i=0;i<createUserPage.checkbox.size();i++){
				createUserPage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(1500);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			driver.switchTo().defaultContent();
			if(source.equalsIgnoreCase(COURSE))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				courseNumber = GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toString();
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
			}
			else if(source.equalsIgnoreCase(BOOK))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
				createUserPage.headerLibrary.click();
				courseNumber = GenericFunctions.readFromNotepad("./TestData/dikshadata.txt").toString();
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
			}
			//assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search "+source);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed to publish and search");
		}

	}

	public String uploadContent(String uploadType) throws Exception
	{
		String title="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Content");
			
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			Robot robot = new Robot();
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(UPLOADCONTENT);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(2000);
			WebElement browse=createUserPage.browseButton;

			if(uploadType.equalsIgnoreCase("mp4"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Uploading videos\\"+UPLOAD_MP4;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Uploading videos\\"+UPLOAD_WEBM;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("webm content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(2000);
				createUserPage.UploadButton.click();
				System.out.println("YOUTUBE content uploaded sucessfully");

			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_EPUB;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("epub content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_H5P;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("h5p content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_HTML;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("html content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("pdf"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_PDF;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("pdf content uploaded sucessfully");
			}
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.contentMp4Title);
			title=(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.testDataIncrementer("./TestData/contentNumbers.txt")).toString();
			System.out.println(title);
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			if(uploadType.contains(MP4))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+MP4);
			}
			else if(uploadType.contains(WEBM))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+WEBM);
			}
			else if(uploadType.contains(YOUTUBE))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+YOUTUBE);
			}
			else if(uploadType.contains(EPUB))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+EPUB);
			}
			else if(uploadType.contains(HTML))
			{	
				createUserPage.contentMp4Title.sendKeys(title+"_"+HTML);
			}
			else if(uploadType.contains(H5P))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+H5P);
			}
			else if(uploadType.contains(PDF))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+PDF);
			}
			
			GenericFunctions.waitWebDriver(1000);
			createUserPage.contentMp4Desc.click();
			createUserPage.contentMp4Desc.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.checkAppIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoardDropdownIcon);
			createUserPage.clickBoardDropdownIcon.click();
			createUserPage.selectCBSE.click();
			createUserPage.clickMediumDropdownIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassDropdownIcon);
			createUserPage.clickClassDropdownIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			createUserPage.clickClassDropdownIcon.click();
			GenericFunctions.scrollToElement(createUserPage.clickSubjectDropdownIcon);
			createUserPage.clickSubjectDropdownIcon.click();
			createUserPage.selectUrdu2.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1000);
		}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload "+uploadType+" content and send for review ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				System.out.println("Failed to upload content");
				Assert.fail("Failed to upload any content and send for review ");
			}
		return title;
	}
	public void navigateToProfileAndSearch(String userData)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Profile And Search");
			//List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			//objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			createUserPage.headerProfile.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(userData);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Profile And Search ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate To Profile And Search");
			Assert.fail("Failed to navigate To Profile And Search ");
		}
		
	}
	public void navigateToLibraryAndSearchContent(String userData)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search Content");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchedContent.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search Content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate To Library And Search Content");
			Assert.fail("Failed to navigate To Library And Search Content ");
		}
		
		
	}
	public void navigateToProfileAndSearchOrg()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Profile And Search Org");
			//createUserPage.dropDown.click();
			createUserPage.headerProfile.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.searchDropDown.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.SearchDropDownOrg.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.downloadButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Profile And Search Org");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate To Profile And Search Org");
			Assert.fail("Failed to navigate To Profile And Search Org ");
		}
		
		
	}
	
	public void navigateToCourseSearchAndCreateBatch()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Course Search And Create Batch");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			createUserPage.headerProfile.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.searchDropDown.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.SearchDropDownCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(8).getCourseDescription());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.createBatch.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Course Search And Create Batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate To Course Search And Create Batch");
			Assert.fail("Failed to navigate To Course Search And Create Batch ");
		}
		
		
	}
	public void createResource(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.click();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addShape.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addTriangle.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addImage.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.img1.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectImage.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);

//for uploading audio
			/*createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addAudio.click();
			createUserPage.uploadAndUseButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.yesRadioButton.click();
			createUserPage.uploadAudioIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.chooseFileButton.click();
			GenericFunctions.waitWebDriver(1500);
			String path1 = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+ AUDIO;
			System.out.println("Uploaded image : "+path1);
			//log.info("Uploaded file name: "+path);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.uploadFile(path1);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.uploadAndUseButtonRight.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);*/


			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addHotspot.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addScribblepad.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addActivity.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.searchActivity);
			createUserPage.searchActivity.sendKeys("Math");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.mathText);
			createUserPage.mathText.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addButtonInActivity.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addVideo.click();
			createUserPage.pasteVideoUrl.sendKeys(UPLOAD_MP4_URL);
			createUserPage.goButton.click();
			GenericFunctions.waitWebDriver(4000);
			createUserPage.addToLesson.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closePage);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Resource ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Resource");
			Assert.fail("Failed to create Resource ");
		}
	}
	public void saveAndSendResouceForReview(){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send Resouce For Review ");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickSelectBoard);
			createUserPage.clickSelectBoard.click();
			createUserPage.selectCBSE.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickSelectMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectClass);
			createUserPage.clickSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			GenericFunctions.waitWebDriver(1000);
			//createUserPage.creditTo.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectSubject);
			createUserPage.clickSelectSubject.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectUrdu2.click();;
				
			
			GenericFunctions.waitWebDriver(3500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(3500);
			//createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send Resouce For Review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send Resouce For Review ");
			Assert.fail("Failed to save And Send Resouce For Review  ");

		}


	}
	public void resourcePublishAndSearch(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to resource Publish And Search ");
			String courseNumber="",searchCourseName="";
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.publishResource);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.publishResource);
			createUserPage.publishResource.click();
			//driver.switchTo().defaultContent();
			
			//Select all check boxes to publish
			//Updated on 10 july 2018
			
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
			
			createUserPage.headerLibrary.click();
			courseNumber = GenericFunctions.readFromNotepad("./resourceNumbers.txt").toString();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
			createUserPage.searchIcon.click();
			searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;	*/
			
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to resource Publish And Search ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to resource Publish And Search ");
			Assert.fail("Failed to resource Publish And Search  ");
		}
	}
	public void rejectTheResource()
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to reject The Resource ");
			List <TestDataForSunbird> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

			GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();

			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName());//+GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString());
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			//GenericFunctions.waitWebDriver(4000);
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7000);
			GenericFunctions.scrollToElement(createUserPage.clickRequestChanges);
			createUserPage.clickRequestChanges.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.rejectReason1.click();
			createUserPage.rejectReason2.click();
			createUserPage.rejectReason3.click();
			String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
			System.out.println(rejectReason);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.reviewComments.click();
			createUserPage.reviewComments.sendKeys(rejectReason);
			createUserPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to reject The Resource ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to reject The Resource ");
			Assert.fail("Failed to reject The Resource  ");
		}
		
	}
	public void saveAndSendCourseForReviewAfterEdit(List <TestDataForSunbird> objListOFTestDataForSunbird)throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send Course For Review After Edit ");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editdetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickAppIcon.click();	
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			//createUserPage.clickOnSelectCurriculum.click();
			//createUserPage.selectCurriculum.click();
			//GenericFunctions.selectValueFromDropdown(driver,createUserPage.selectCurriculum.toString(),"MSCERT");

//			createUserPage.clickOnSelectClass.click();
//			GenericFunctions.waitWebDriver(2000);
//			createUserPage.selectClass.click();
//			GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
//
//			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
//			//createUserPage.clickOnHeaderSubject.click();
//			GenericFunctions.waitWebDriver(2000);
//			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
//			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
//			createUserPage.clickOnSelectSubject.click();
//			createUserPage.selectSubject.click();
//			createUserPage.clickOnSelectMedium.click();
//			createUserPage.selectMedium.click();
			//GenericFunctions.waitWebDriver(3500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send Course For Review After Edit  ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send Course For Review After Edit ");
			Assert.fail("Failed to save And Send Course For Review After Edit  ");

		}

	}

	public void CoursePublishAndSearch(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Course Publish And Search  ");
			String courseNumber="",searchCourseName="";
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.publishCourse);
			GenericFunctions.scrollToElement(createUserPage.publishCourse);
			createUserPage.publishCourse.click();
			//driver.switchTo().defaultContent();
			
			//Select all check boxes to publish
			//Updated on 10 july 2018
			
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
			
			createUserPage.headerLibrary.click();
			courseNumber = GenericFunctions.readFromNotepad("./resourceNumbers.txt").toString();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
			createUserPage.searchIcon.click();
			searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;	*/
			
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Course Publish And Search ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Course Publish And Search ");
			Assert.fail("Failed to Course Publish And Search ");
		}
	}
	public void BookPublishAndSearch(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		String courseNumber="",searchCourseName="";
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Book Publish And Search ");
			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.publishCourse);
			GenericFunctions.scrollToElement(createUserPage.publishCourse);
			createUserPage.publishCourse.click();
			//driver.switchTo().defaultContent();
			
			//Select all check boxes to publish
			//Updated on 10 july 2018
			
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
			
			createUserPage.headerLibrary.click();
			courseNumber = GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
			createUserPage.searchIcon.click();
			searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;	*/
			
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Book Publish And Search ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Book Publish And Search ");
			Assert.fail("Failed to Book Publish And Search ");
		}
	}
	public void LessonPlanPublishAndSearch(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		String courseNumber="",searchCourseName="";
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Lesson Plan Publish And Search ");
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.publishCourse);
			GenericFunctions.scrollToElement(createUserPage.publishCourse);
			createUserPage.publishCourse.click();
			//driver.switchTo().defaultContent();
			
			//Select all check boxes to publish
			//Updated on 10 july 2018
			
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.headerLibrary);
			
			createUserPage.headerLibrary.click();
			courseNumber = GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
			createUserPage.searchIcon.click();
			searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;	*/
			
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Lesson Plan Publish And Search  ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Lesson Plan Publish And Search ");
			Assert.fail("Failed to Lesson Plan Publish And Search ");
		}
	}
	public void goToWorkspaceAndReview(String inputToSearch)
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go To Workspace And Review ");
			GenericFunctions.refreshWebPage();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			if(inputToSearch.equalsIgnoreCase(MP4))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("contentNumbers.txt")+"_"+MP4);
			}

			else if(inputToSearch.equalsIgnoreCase(WEBM))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("contentNumbers.txt")+"_"+WEBM);
			}
			else if(inputToSearch.equalsIgnoreCase(YOUTUBE))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("contentNumbers.txt")+"_"+YOUTUBE);
			}
			else if(inputToSearch.equalsIgnoreCase(EPUB))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("contentNumbers.txt")+"_"+EPUB);
			}
			else if(inputToSearch.equalsIgnoreCase(HTML))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("contentNumbers.txt")+"_"+HTML);
			}
			else if(inputToSearch.equalsIgnoreCase(H5P))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("contentNumbers.txt")+"_"+H5P);
			}

			else if(inputToSearch.equalsIgnoreCase(COLLECTION))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName());
				//+"_"+GenericFunctions.readFromNotepad("collectionNumbers.txt")
			}
			else if(inputToSearch.equalsIgnoreCase(LESSONPLAN))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName());
			}
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			/*GenericFunctions.waitWebDriver(4000);
		GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
		GenericFunctions.waitWebDriver(7000);*/
			if(inputToSearch.contains("collection"))
			{
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(7000);
				GenericFunctions.waitWebDriver(4500);
				createUserPage.clickPublishIcon.click();
			}
			else if(inputToSearch.contains("lessonplan"))
			{
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(7000);
				GenericFunctions.waitWebDriver(4500);
				createUserPage.clickPublishIcon.click();
			}
			else if(inputToSearch.contains("epub")||inputToSearch.contains("webm"))
			{
				//GenericFunctions.waitForElementToAppear(createUserPage.publishButton);
				//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.scrollToElement(createUserPage.publishButton);
				GenericFunctions.waitWebDriver(2500);
				System.out.println(createUserPage.publishButton.getText());
				createUserPage.publishButton.click();
			}
			//	String compare=createUserPage.searchedContentForPublish.getText();	
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			System.out.println("Test case completed");
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to go To Workspace And Review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to go To Workspace And Review ");
			Assert.fail("Failed to go To Workspace And Review ");
		}
	}
	public void createCollection(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Collection");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./TestData/collectionNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(5000);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(3500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3500);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.untitledNameC.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.untitledNameC.clear();
			createUserPage.untitledNameC.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			createUserPage.proceedButton.click();
			System.out.println("Creating - "+objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./TestData/collectionNumbers.txt"));

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Collection ");
			Assert.fail("Failed to create Collection ");
		}
	}
	public void createNewBook(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create New Book");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./TestData/bookNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(3500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.untitledName.click();
			createUserPage.untitledName.clear();
			createUserPage.untitledName.sendKeys(objListOFTestDataForSunbird.get(2).getTitle()+courseNumber);
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create New Book");
			Assert.fail("Failed to create New Book ");
		}
	}
	public void createNewLessonPlan(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create New Lesson Plan");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./TestData/lessonPlan.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.untitledUnitName.click();
			createUserPage.untitledUnitName.clear();
			createUserPage.untitledUnitName.sendKeys(objListOFTestDataForSunbird.get(3).getTitle()+courseNumber);
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Lesson Plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create New Lesson Plan");
			Assert.fail("Failed to create New Lesson Plan");
		}
	}
	public void saveAndSendNewBookForReview(){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send NewBook For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editdetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickSelectBoard);
			createUserPage.clickSelectBoard.click();
			createUserPage.selectCBSE.click();
			//GenericFunctions.waitWebDriver(1000);
			createUserPage.clickSelectMedium.click();
			//GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickClass);
			createUserPage.clickClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectSubject);
			createUserPage.clickSelectSubject.click();
			createUserPage.selectMATHEMATICS.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.selectYear);
			createUserPage.selectYear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			//createUserPage.closePage.click();
			//GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send NewBook For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send NewBook For Review ");
			Assert.fail("Failed to save And Send NewBook For Review ");

		}


	}
	public void saveAndSendNewLessonPlanForReview(){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send New Lesson Plan For Review");
			
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.editdetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			
			//System.out.println("done");
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReview);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(2000);
			
		
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickSelectBoard);
			createUserPage.clickSelectBoard.click();
			createUserPage.selectCBSE.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickSelectMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			//createUserPage.clickOnSelectCurriculum.click();
			//createUserPage.selectCBSE.click();
			//GenericFunctions.selectValueFromDropdown(driver,createUserPage.selectCurriculum.toString(),"NCERT");
			createUserPage.clickClassForLessonPlan.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.untitledDescription.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectSubject);
			createUserPage.clickSelectSubject.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMATHEMATICS.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectYear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();
			GenericFunctions.waitWebDriver(3500);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			//GenericFunctions.waitWebDriver(1500);
			//createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send New Lesson Plan For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send New Lesson Plan For Review ");
			Assert.fail("Failed to save And Send New Lesson Plan For Review");

		}


	}

	public void createQuestionMCQ(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create QuestionMCQ");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectMCQTemplate);
			createUserPage.selectMCQTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			String question = GenericFunctions.readFromNotepad("./TestData/questions.txt").toString();
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys(question);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.inputAnswer1);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.inputAnswer1.click();
			createUserPage.inputAnswer1.sendKeys("240,200,160");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.markAsRightAnswer);
			createUserPage.markAsRightAnswer.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.inputAnswer2);
			createUserPage.inputAnswer2.click();
			createUserPage.inputAnswer2.sendKeys("200,160,240");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.previewFrame);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img1.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MCQ is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.downButtonPreview.click();
			GenericFunctions.waitWebDriver(1000);
			/*Screenshot myScreenshot1 = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot1.getImage(), "PNG", new File("./ScreenShot/ + img2.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Second Image comparison in MCQ is passed");
			//GenericFunctions.takeScreenshotOnValidation("img");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.previewContainer.click();
			GenericFunctions.scrollTillEndOfPage();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Third Image comparison in MCQ is passed");
			/*Screenshot myScreenshot2 = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot2.getImage(), "PNG", new File("./ScreenShot/ + img3.png"));*/
			//GenericFunctions.captureScreenshotOnValidation();
			GenericFunctions.waitWebDriver(1000);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQueNext);
			//createUserPage.selectLayout.click();
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishQues.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectUrdu4.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.clear();
			createUserPage.maxScore.sendKeys("10");
			GenericFunctions.waitWebDriver(3000);
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(3000);*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.submitButtonInQuestion);
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.nextButton);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.nextButton);
			createUserPage.nextButton.click();*/
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(5000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create MCQQuestion ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create MCQQuestion");
			Assert.fail("Failed to create MCQQuestion ");
		}
	}
	public void createQuestionMTF(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create QuestionMTF type");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMTFTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.enterAnswer1);
			createUserPage.enterAnswer1.sendKeys("animal");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer2.sendKeys("dog");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer3.sendKeys("bird");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer4.sendKeys("peacock");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer5.sendKeys("mammal");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer6.sendKeys("human");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.previewRefreshIcon);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img4.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MTF is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishQues.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectUrdu4.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.clear();
			createUserPage.maxScore.sendKeys("10");
			GenericFunctions.waitWebDriver(3000);
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(3000);*/
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(4000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create QuestionMTF ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create QuestionMTF");
			Assert.fail("Failed to create QuestionMTF ");
		}
	}
	public void createQuestionFITB(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectFITBTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys("2+7=[[9]]");
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img5.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MCQ is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishFITB.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMathematics.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.sendKeys("10");
			GenericFunctions.waitWebDriver(3000);
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(3000);*/
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create QuestionFITB ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create QuestionFITB");
			Assert.fail("Failed to create QuestionFITB ");
		}
	}
	public void createQuestion(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(4000);
			//GenericFunctions.waitForElementToAppear(createUserPage.questionCheckbox);
			//GenericFunctions.waitWebDriver(1000);
			createUserPage.questionCheckbox.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(createUserPage.nextButton);
			createUserPage.nextButton.click();
			createUserPage.questionSetTitle.sendKeys("Math test");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Question ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Question");
			Assert.fail("Failed to create Question ");
		}
	}
	
	public void deleteItems()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete Items ");
			List<WebElement>lists = createUserPage.deleteButtonAll;
			
			//createUserPage.deleteButtonAll.stream().forEach(elem -> elem.click());
			for(WebElement ls : lists)
			{
				GenericFunctions.waitForElementToAppear(createUserPage.deleteButton);
				ls.click();
				createUserPage.yesButtonPopup.click();
				GenericFunctions.waitWebDriver(6000);
				
			}
			
			/*List<WebElement>list = createUserPage.deleteButtonAll;
			Iterator<WebElement> iter = list.iterator();

			while(iter.hasNext()) {
			    WebElement ls = iter.next();
			    if (ls.isDisplayed()) {
			    	ls.click();
					createUserPage.yesButtonPopup.click();
					GenericFunctions.waitWebDriver(6000);
			    }
			}*/
		}
	catch(Exception e)
	 {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to delete Items ");
		ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
		System.out.println("Failed to delete Items");
		Assert.fail("Failed to delete Items ");
	 }
	}
	public void deleteCreatedItems()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete Items ");
			createUserPage.deleteButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.yesButtonPopup.click();
			GenericFunctions.waitWebDriver(6000);
			
			
			/*List<WebElement>lists = createUserPage.deleteButtonAll;
			
			//createUserPage.deleteButtonAll.stream().forEach(elem -> elem.click());
			for(WebElement ls : lists)
			{
				GenericFunctions.waitForElementToAppear(createUserPage.deleteButton);
				ls.click();
				createUserPage.yesButtonPopup.click();
				GenericFunctions.waitWebDriver(6000);
				
			}*/
			
			/*List<WebElement>list = createUserPage.deleteButtonAll;
			Iterator<WebElement> iter = list.iterator();

			while(iter.hasNext()) {
			    WebElement ls = iter.next();
			    if (ls.isDisplayed()) {
			    	ls.click();
					createUserPage.yesButtonPopup.click();
					GenericFunctions.waitWebDriver(6000);
			    }
			}*/
		}
	catch(Exception e)
	 {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to delete Items ");
		ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
		System.out.println("Failed to delete Items");
		Assert.fail("Failed to delete Items ");
	 }
	}
	public void createResourceWithoutSave(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			GenericFunctions.waitWebDriver(1500);
			/*GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.click();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);*/
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addShape.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addTriangle.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addImage.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.img1.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectImage.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);

//for uploading audio
			/*createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addAudio.click();
			createUserPage.uploadAndUseButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.yesRadioButton.click();
			createUserPage.uploadAudioIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.chooseFileButton.click();
			GenericFunctions.waitWebDriver(1500);
			String path1 = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+ AUDIO;
			System.out.println("Uploaded image : "+path1);
			//log.info("Uploaded file name: "+path);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.uploadFile(path1);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.uploadAndUseButtonRight.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);*/


			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addHotspot.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addScribblepad.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addActivity.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.searchActivity);
			createUserPage.searchActivity.sendKeys("Math");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.mathText);
			createUserPage.mathText.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addButtonInActivity.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addVideo.click();
			createUserPage.pasteVideoUrl.sendKeys(UPLOAD_MP4_URL);
			createUserPage.goButton.click();
			GenericFunctions.waitWebDriver(4000);
			createUserPage.addToLesson.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closePage);
			createUserPage.closePage.click();*/
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			/*GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Resource ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Resource");
			Assert.fail("Failed to create Resource ");
		}
	}
	public void createQuestionMCQWithoutSave(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create QuestionMCQ");
			GenericFunctions.waitWebDriver(1500);
			/*GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());*/
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectMCQTemplate);
			createUserPage.selectMCQTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			String question = GenericFunctions.readFromNotepad("./TestData/questions.txt").toString();
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys(question);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.inputAnswer1);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.inputAnswer1.click();
			createUserPage.inputAnswer1.sendKeys("240,200,160");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.markAsRightAnswer);
			createUserPage.markAsRightAnswer.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.inputAnswer2);
			createUserPage.inputAnswer2.click();
			createUserPage.inputAnswer2.sendKeys("200,160,240");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.previewFrame);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img1.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MCQ is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.downButtonPreview.click();
			GenericFunctions.waitWebDriver(1000);
			/*Screenshot myScreenshot1 = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot1.getImage(), "PNG", new File("./ScreenShot/ + img2.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Second Image comparison in MCQ is passed");
			//GenericFunctions.takeScreenshotOnValidation("img");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.previewContainer.click();
			GenericFunctions.scrollTillEndOfPage();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Third Image comparison in MCQ is passed");
			/*Screenshot myScreenshot2 = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot2.getImage(), "PNG", new File("./ScreenShot/ + img3.png"));*/
			//GenericFunctions.captureScreenshotOnValidation();
			GenericFunctions.waitWebDriver(1000);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQueNext);
			//createUserPage.selectLayout.click();
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishQues.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectUrdu4.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.clear();
			createUserPage.maxScore.sendKeys("10");
			GenericFunctions.waitWebDriver(3000);
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(3000);*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.submitButtonInQuestion);
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.nextButton);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.nextButton);
			createUserPage.nextButton.click();*/
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addAnotherQuestion.click();
			/*createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();*/
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(5000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create MCQQuestion ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create MCQQuestion");
			Assert.fail("Failed to create MCQQuestion ");
		}
	}
	public void createQuestionMTFWithoutSave(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create QuestionMTF type");
			GenericFunctions.waitWebDriver(1500);
			//GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			/*String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());*/
			/*GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();*/
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMTFTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.enterAnswer1);
			createUserPage.enterAnswer1.sendKeys("animal");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer2.sendKeys("dog");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer3.sendKeys("bird");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer4.sendKeys("peacock");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer5.sendKeys("mammal");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer6.sendKeys("human");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.previewRefreshIcon);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img4.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MTF is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishQues.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectUrdu4.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.clear();
			createUserPage.maxScore.sendKeys("10");
			GenericFunctions.waitWebDriver(3000);
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(3000);*/
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(4000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create QuestionMTF ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create QuestionMTF");
			Assert.fail("Failed to create QuestionMTF ");
		}
	}
	public void createQuestionFITBWithoutSave(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			GenericFunctions.waitWebDriver(1500);
			/*GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());*/
			/*GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();*/
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectFITBTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys("2+7=[[9]]");
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img5.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MCQ is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt"));
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishFITB.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMathematics.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.sendKeys("10");
			GenericFunctions.waitWebDriver(3000);
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(3000);*/
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addAnotherQuestion.click();
			/*createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();*/
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create QuestionFITB ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create QuestionFITB");
			Assert.fail("Failed to create QuestionFITB ");
		}
	}
	public void createQuestionAndSave(List <TestDataForSunbird> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Question from existing ones");
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.addSlide);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			/*GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./TestData/questionNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.addQuestionSet);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(4000);
			//GenericFunctions.waitForElementToAppear(createUserPage.questionCheckbox);
			//GenericFunctions.waitWebDriver(1000);
			createUserPage.questionCheckbox.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(createUserPage.nextButton);
			createUserPage.nextButton.click();
			createUserPage.questionSetTitle.sendKeys("Math test");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(4000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Question ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Question");
			Assert.fail("Failed to create Question ");
		}
	}
	public void editBook(List <TestDataForSunbird> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit a Book");
			GenericFunctions.waitWebDriver(1500);
			//action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.untitledName.click();
			createUserPage.untitledName.clear();
			createUserPage.untitledName.sendKeys(objListOFTestDataForSunbird.get(2).getTitle());
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.deleteResource);
			createUserPage.deleteResource.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.yesDeleteResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create New Book");
			Assert.fail("Failed to create New Book ");
		}
	}
	public void saveAndSendEdittedBookForReview(){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send NewBook For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editdetailslink.click();
			/*GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickSelectBoard);
			createUserPage.clickSelectBoard.click();
			createUserPage.selectCBSE.click();
			//GenericFunctions.waitWebDriver(1000);
			createUserPage.clickSelectMedium.click();
			//GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickClass);
			createUserPage.clickClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectSubject);
			createUserPage.clickSelectSubject.click();
			createUserPage.selectMATHEMATICS.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.selectYear);
			createUserPage.selectYear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();*/
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			/*GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();*/
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			//createUserPage.closePage.click();
			//GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send NewBook For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send NewBook For Review ");
			Assert.fail("Failed to save And Send NewBook For Review ");

		}
	}
	public String uploadNewContent(String uploadType) throws Exception
	{
		String title="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload new Content");
			GenericFunctions.waitWebDriver(1500);
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			createUserPage.uploadNewfile.click();
			GenericFunctions.waitWebDriver(3000);
			/*Robot robot = new Robot();
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(UPLOADCONTENT);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);*/
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(2000);
			WebElement browse=createUserPage.browseButton;

			if(uploadType.equalsIgnoreCase("mp4"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Uploading videos\\"+UPLOAD_MP4;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Uploading videos\\"+UPLOAD_WEBM;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("webm content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(2000);
				createUserPage.UploadButton.click();
				System.out.println("YOUTUBE content uploaded sucessfully");

			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_EPUB;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("epub content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_H5P;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("h5p content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_HTML;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("html content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("pdf"))
			{
				String path = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\"+UPLOAD_PDF;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("pdf content uploaded sucessfully");
			}
			
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.contentMp4Title);
			
			title=(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt")).toString();
			System.out.println(title);
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			if(uploadType.contains(MP4))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+MP4);
			}
			else if(uploadType.contains(WEBM))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+WEBM);
			}
			else if(uploadType.contains(YOUTUBE))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+YOUTUBE);
			}
			else if(uploadType.contains(EPUB))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+EPUB);
			}
			else if(uploadType.contains(HTML))
			{	
				createUserPage.contentMp4Title.sendKeys(title+"_"+HTML);
			}
			else if(uploadType.contains(H5P))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+H5P);
			}
			else if(uploadType.contains(PDF))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+PDF);
			}
			
			GenericFunctions.waitWebDriver(1000);
			/*createUserPage.contentMp4Desc.click();
			createUserPage.contentMp4Desc.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.checkAppIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoardDropdownIcon);
			
			createUserPage.clickBoardDropdownIcon.click();
			createUserPage.selectCBSE.click();
			createUserPage.clickMediumDropdownIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassDropdownIcon);
			createUserPage.clickClassDropdownIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			createUserPage.clickClassDropdownIcon.click();
			GenericFunctions.scrollToElement(createUserPage.clickSubjectDropdownIcon);
			createUserPage.clickSubjectDropdownIcon.click();
			createUserPage.selectUrdu2.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitWebDriver(3000);*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1000);
		}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload "+uploadType+" content and send for review ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				System.out.println("Failed to upload content");
				Assert.fail("Failed to upload any content and send for review ");
			}
		return title;
	}
	public void navigateToAllMyContentAndSearch(List <TestDataForSunbird> objListOFTestDataForSunbird,String createVariable)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is navigating to the All my content and search "+createVariable);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.allMyContent.click();
			GenericFunctions.waitWebDriver(500);
			if(createVariable.equalsIgnoreCase(BOOK))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());//+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(5000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(5000);
			}
			else if(createVariable.equalsIgnoreCase(UPLOADCONTENT))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_");//+courseNumber+"_"+ PDF);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(5000);
			}
			else if(createVariable.equalsIgnoreCase(RESOURCE))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName());// +courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(5000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(5000);
			}
			else if(createVariable.equalsIgnoreCase(COLLECTION))
			{
				String courseNumber = GenericFunctions.readFromNotepad("./TestData/collectionNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(5000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(5000);
			}
			else if(createVariable.equalsIgnoreCase(LESSONPLAN))
			{
				String courseNumber = GenericFunctions.readFromNotepad("./TestData/lessonPlan.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(5000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(5000);
			}
			else if(createVariable.equalsIgnoreCase(COURSE))
			{
				String courseNumber = GenericFunctions.readFromNotepad("./TestData/courseNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(5000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(5000);
			}
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to All my content and search");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on navigating to Workspace");
			Assert.fail("Failed on navigating to Workspace and create "+createVariable);
		}

	}
	public void deleteTheSlide() 
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete the slide");
			GenericFunctions.waitWebDriver(2000);
			/*List<WebElement>list = createUserPage.existingSlide;
			for(WebElement del : list) {
				if(del.isDisplayed()) {
					del.click();
					GenericFunctions.waitWebDriver(1000);
					createUserPage.deleteSlide.click();
					GenericFunctions.waitWebDriver(500);
					createUserPage.deleteConfirmationPopup.click();
					GenericFunctions.waitWebDriver(500);
				}
	
				
			}*/
			for(int i=0;i<=createUserPage.existingSlide.size()+4;i++) {
				//if(createUserPage.existingSlide.get(i).isDisplayed()) {
					createUserPage.existingSlide.get(0).click();
					GenericFunctions.waitWebDriver(500);
					createUserPage.deleteSlide.click();
					GenericFunctions.waitWebDriver(500);
					createUserPage.deleteConfirmationPopup.click();
					GenericFunctions.waitWebDriver(1000);
				/*}else {
					i++;
					
				}*/
			}
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on deleting the slide");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on deleting the slide");
			Assert.fail("Failed on deleting the slide ");
		}
	}
	public void saveAndSendEdittedResouceForReview(){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send editted Resource For Review ");
		/*	GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickSelectBoard);
			createUserPage.clickSelectBoard.click();
			createUserPage.selectCBSE.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickSelectMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectClass);
			createUserPage.clickSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			GenericFunctions.waitWebDriver(1000);
			//createUserPage.creditTo.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectSubject);
			createUserPage.clickSelectSubject.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectUrdu2.click();;*/
			
			GenericFunctions.waitWebDriver(3500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(3500);
			//createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send editted Resouce For Review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send editted Resouce For Review ");
			Assert.fail("Failed to save And Send editted Resouce For Review  ");

		}


	}
	public void searchInUpForReviewForEdittedContents(String source,List <TestDataForSunbird> objListOFTestDataForSunbird) throws Exception{
		try{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search in Up For Review bucket for "+source);
			String courseNumber = "",searchCourseName="";
			GenericFunctions.waitWebDriver(3000);
			publicUserPage.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			if(source.equalsIgnoreCase(COURSE)){
				//courseNumber = GenericFunctions.readFromNotepad("./TestData/courseNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());//+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(BOOK)){
				//courseNumber = GenericFunctions.readFromNotepad("./TestData/bookNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());//+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(RESOURCE)){
				//courseNumber = GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName());//+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(COLLECTION)){
				//courseNumber = GenericFunctions.readFromNotepad("./TestData/collectionNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());//+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(LESSONPLAN)){
				//courseNumber = GenericFunctions.readFromNotepad("./TestData/lessonPlan.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName());//+courseNumber);
				createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(3).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			assertFoundInUpForReview(searchCourseName);
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}

	}
	public void goToWorkspaceAndPublishEdittedContent(String inputToSearch)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go To Workspace And Publish");
		
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_");//+GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt"));
			GenericFunctions.waitWebDriver(3000);
			//	String compare=createUserPage.searchedContentForPublish.getText();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(7000);			
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.scrollToElement(createUserPage.publishButton);
			GenericFunctions.waitWebDriver(4500);
			createUserPage.publishButton.click();
			GenericFunctions.waitWebDriver(1000);
			for(int i=0;i<createUserPage.checkbox.size();i++)
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	 
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			System.out.println("Content Published");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on going To Workspace And Publish");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to go To Workspace And Publish");
			Assert.fail("Failed on going To Workspace And Publish");
		}	
	}
	public void navigateToLibraryAndSearchEdittedContent(String userData)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search Content");
			List <TestDataForSunbird> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_");//+GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_");//+GenericFunctions.readFromNotepad("./TestData/contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchedContent.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search Content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate To Library And Search Content");
			Assert.fail("Failed to navigate To Library And Search Content ");
		}
		
		
	}

}
