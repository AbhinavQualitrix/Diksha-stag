package org.pageobjects;

import java.awt.Robot;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CoursePage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.LibraryPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by Qualitrix Technologies Pvt Ltd. Purpose: Class file to segregate
 * complete functional methods related to user sign up and its feature
 */
public class LibraryPageObj extends BaseTest {

	static Logger log = Logger.getLogger(LibraryPageObj.class.getName());
	LibraryPage objLibraryPage = PageFactory.initElements(driver, LibraryPage.class);
	CoursePage coursePage = PageFactory.initElements(driver, CoursePage.class);
	SignUpPage objSignUp = PageFactory.initElements(driver, SignUpPage.class);
	UploadOrgPage orgUploadPage = PageFactory.initElements(driver, UploadOrgPage.class);
	CreatorUserPage createUserPage = PageFactory.initElements(driver, CreatorUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	Actions action = new Actions(driver);
	CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	GenericFunctions genericFunctions = new GenericFunctions();
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	String	searchedContentName;
	String searchedLastContentName;
	String searchedFirstContentName;
	List<String> firstAndLastContent = new ArrayList<String>();
	List <TestDataForDiksha> objListOFTestDataForSunbird= null;

	WebDriverWait wait = new WebDriverWait(driver, 20);


	/**
	 * Purpose: userLogin() method is used for user logging
	 */

	public void verifyViewAllSectionBasedOnContentCount() {

		try {
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickLibray);
			objLibraryPage.clickLibray.click();
			GenericFunctions.waitWebDriver(7000);

			String featuredContentCount = objLibraryPage.featuredContentCount.getText();
			int featuredContentCountValue = Integer.parseInt(featuredContentCount);
			if (featuredContentCountValue < 10) {
				boolean result = objLibraryPage.featuredContentViewAllButton.isDisplayed();
				if (result == false) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is Not displayed featuredContentSection");
				}

			} else {
				if (objLibraryPage.featuredContentViewAllButton.isDisplayed()) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is displayed in featuredContentSection");
				}
			}

			GenericFunctions.waitWebDriver(3000);

			String textBookContentCount = objLibraryPage.textBookContentCount.getText();
			int textBookContentCountValue = Integer.parseInt(textBookContentCount);
			if (textBookContentCountValue < 10) {
				boolean result = objLibraryPage.textBookContentCount.isDisplayed();
				if (result == false) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is Not displayed textBookContentSection");
				}

			} else {
				if (objLibraryPage.textBookContentCount.isDisplayed()) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is displayed in textBookContentSection");
				}
			}

			String teachingMaterialtCount = objLibraryPage.teachingMaterialtCount.getText();
			int teachingMaterialtCountValue = Integer.parseInt(teachingMaterialtCount);
			if (teachingMaterialtCountValue < 10) {
				boolean result = objLibraryPage.teachingMaterialtCount.isDisplayed();
				if (result == false) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is Not displayed teachingMaterialtSection");
				}

			} else {
				if (objLibraryPage.teachingMaterialtCount.isDisplayed()) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is displayed in teachingMaterialtSection");
				}
			}

			String learningMaterialCount = objLibraryPage.learningMaterialCount.getText();
			int learningMaterialCountValue = Integer.parseInt(learningMaterialCount);
			if (learningMaterialCountValue < 10) {
				boolean result = objLibraryPage.learningMaterialCount.isDisplayed();
				if (result == false) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is Not displayed learningMaterialSection");
				}

			} else {
				if (objLibraryPage.learningMaterialCount.isDisplayed()) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is displayed in learningMaterialSection");
				}
			}

			String practiceandTestMaterial = objLibraryPage.practiceandTestMaterial.getText();
			int practiceandTestMaterialValue = Integer.parseInt(practiceandTestMaterial);
			if (practiceandTestMaterialValue < 10) {
				boolean result = objLibraryPage.practiceandTestMaterial.isDisplayed();
				if (result == false) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is Not displayed practiceandTestMaterialSection");
				}

			} else {
				if (objLibraryPage.practiceandTestMaterial.isDisplayed()) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"ViewAll button is displayed in practiceandTestMaterialSection");
				}
			}

		} catch (Exception e3) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e3.getLocalizedMessage());
			Assert.fail("Failed on Verifying ViewAll Section in LibraryPage");

		}
	}

	public void verifyListResultInViewAllSection(String sectionName) {

		try {
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickLibray);
			objLibraryPage.clickLibray.click();
			GenericFunctions.waitWebDriver(7000);

			if (sectionName.equalsIgnoreCase("TeacherMaterial")) {
				ExtentTestManager.getTest().log(LogStatus.INFO, "Verify the List of the result in " + sectionName);
				GenericFunctions.scrollDownByPixel();
				if (objLibraryPage.teachingMaterialViewAllSection.isDisplayed()) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "View All Section  is verified in" + sectionName);

					objLibraryPage.teachingMaterialViewAllSection.click();
					GenericFunctions.waitWebDriver(6000);
					objLibraryPage.latestResourceListInTeachingMaterial.isDisplayed();

					ExtentTestManager.getTest().log(LogStatus.PASS, "Result is verified in " + sectionName);

				}
			}

			else if (sectionName.equalsIgnoreCase("practiceAndTestMaterial")) {
				GenericFunctions.scrollBy850pixel();
				GenericFunctions.scrollToElement(objLibraryPage.practiceAndTestMaterialViewAllSection);
				if (objLibraryPage.practiceAndTestMaterialViewAllSection.isDisplayed())
					
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "View All Section  is verified in" + sectionName);

					objLibraryPage.practiceAndTestMaterialViewAllSection.click();

					GenericFunctions.waitWebDriver(6000);

					objLibraryPage.latestCourseListInPacticeAndTestMaterial.isDisplayed();

					ExtentTestManager.getTest().log(LogStatus.PASS, "Result is verified in " + sectionName);

				}
			}
		} catch (Exception e) {
			System.out.println("Failed on Verifying list of the " + sectionName);

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Verifying list of the " + sectionName);

		}
	}

	public void validateResult() {

		try {
			driver.get(APP_URL + "/explore-course");

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is in Explore-Course Page");
			GenericFunctions.waitWebDriver(3000);

			objLibraryPage.searchInputfield.click();
			GenericFunctions.waitWebDriver(1000);

			objLibraryPage.searchInputfield.sendKeys("Automation Content");
			GenericFunctions.waitWebDriver(1000);
			objLibraryPage.clickSearchBlueicon.click();
			GenericFunctions.waitWebDriver(5000);

			boolean result = objLibraryPage.validateResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"LibraryContent is not displayed in Explore-Course Page");

			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Validating LibraryContent in Explore-Course Page");
		}
	}

	public void validateSignInPopupOnClickOnEnroll() {

		try {

			driver.get(APP_URL + "/explore-course");

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is in Explore-Course Page");
			GenericFunctions.waitWebDriver(3000);

			objLibraryPage.searchInputfield.click();
			GenericFunctions.waitWebDriver(1000);

			objLibraryPage.searchInputfield.sendKeys("CourseOpenBatch50");
			GenericFunctions.waitWebDriver(1000);
			objLibraryPage.clickSearchBlueicon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickCourseSearchedResult);

			objLibraryPage.clickCourseSearchedResult.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Searched Course");

			GenericFunctions.waitForElementToAppear(objLibraryPage.enrollButton);
			objLibraryPage.enrollButton.click();
			GenericFunctions.waitWebDriver(2000);

			boolean result = objLibraryPage.assertSignInPopup.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"SignInPopUp has appeared on Click on Enroll button in Explore Course Page");

			}
			// objLibraryPage.assertSignInPopup.click();
			objLibraryPage.clickSignIn.click();
			GenericFunctions.waitWebDriver(5000);

			String title = driver.getTitle();
			Assert.assertEquals(title, "Log in to DIKSHA");
			ExtentTestManager.getTest().log(LogStatus.PASS, "User has re-directed to Login Screen");

			userLogin(PUBLICUSER1);
			boolean openBatchCourse = objLibraryPage.validateTOCForOpenBatchCourse.isDisplayed();
			if (openBatchCourse == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "TOC Page Displayed Succesfully for OpenBatch Course");

			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Validating SignInPopup on click on Enroll button in Explore-Course Page");
		}
	}

	public String[] FetchUserCredentials(String UserRole) throws Exception

	{

		List<TestDataForDiksha> objListOFTestDataForDiksha = null;
		objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcredentials");

		String propertyFile = "./properties/otherConfigurations.properties";

		InputStream fis = new FileInputStream(propertyFile);
		Properties property = new Properties();
		property.load(fis);
		String testDataProperty = property.getProperty("testExcelDataPath");
		FileInputStream fis1 = new FileInputStream(testDataProperty);

		// File src = new File(propertyFile);
		// load file
		// Load workbook

		HSSFWorkbook wb = new HSSFWorkbook(fis1);
		// Load sheet- Here we are loading first sheetonly
		HSSFSheet sh1 = wb.getSheet("Credentials");
		HSSFRow row = sh1.getRow(0);
		int colNum = row.getLastCellNum();
		System.out.println("Total Number of Columns in the excel is : " + colNum);
		int rowNum = sh1.getLastRowNum() + 1;
		System.out.println("Total Number of Rows in the excel is : " + rowNum);

		String[] CredentialsValue = null;
		for (int i = 1; i < rowNum; i++) {

			String RoleName = sh1.getRow(i).getCell(0).getStringCellValue();
			System.out.println(RoleName);

			String ExcelRoleName = RoleName.replaceAll("\\s", "");
			System.out.println(ExcelRoleName);

			if (ExcelRoleName.equalsIgnoreCase(UserRole)) {
				System.out.println("ExcelRoleName" + ExcelRoleName);

				String userName = sh1.getRow(i).getCell(1).getStringCellValue();
				System.out.println("userName " + userName);

				String passWord = sh1.getRow(i).getCell(2).getStringCellValue();
				System.out.println("passWord " + passWord);

				String[] Credentials = new String[2];
				Credentials[0] = userName;
				Credentials[1] = passWord;

				CredentialsValue = Credentials;
				break;
			}
		}

		return CredentialsValue;
	}

	public void userLogin(String userRole) throws InterruptedException, Exception {
		try {

			String[] Creden = FetchUserCredentials(userRole);
			/*
			 * GenericFunctions.waitForElementToAppear(orgUploadPage.loginButton);
			 * orgUploadPage.loginButton.click();
			 */
			GenericFunctions.waitWebDriver(2000);
			// driver.get(APP_URL+"/home");
			// driver.get("https://preprod.ntp.net.in/home");
			GenericFunctions.waitWebDriver(2000);
			orgUploadPage.username.sendKeys(Creden[0]);
			orgUploadPage.password.sendKeys(Creden[1]);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.clickLogin1);
			orgUploadPage.clickLogin1.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is logged in as " + userRole);
			if (userRole.equalsIgnoreCase(PUBLICUSER1) || userRole.equalsIgnoreCase(PUBLICUSER2)
					|| userRole.equalsIgnoreCase(ADMIN) || userRole.equalsIgnoreCase(TC_TESTUSER)
					|| userRole.equalsIgnoreCase(FRAMEWORK_TESTUSER)) {
				System.out.println(userRole + " user login");
				// createUserPageObj.handlePopupOnLogin();
			} else {
				createUserPageObj.tryForWorkSpace();
			}
		} catch (Exception e) {
			System.out.println("Failed to login to the application ," + e.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to login to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed to login to the application ," + e.getLocalizedMessage());

		}

	}

	public void searchContentWithFilter() {
		/*
		 * try {
		 */

		driver.get(APP_URL + "/explore-course");

		ExtentTestManager.getTest().log(LogStatus.INFO, "User is in Explore-Course Page");
		GenericFunctions.waitWebDriver(3000);

		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Topic Dropdown");

			objLibraryPage.clickTopticDropdown.click();
			GenericFunctions.waitWebDriver(2000);

			objLibraryPage.selectFirstContent.click();
			GenericFunctions.waitWebDriver(2000);

			objLibraryPage.selectFirstSubject.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected First Topics");

			objLibraryPage.clickDonebutton.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Done Button");

			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickSubmitButton);
			objLibraryPage.clickSubmitButton.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Submit Button");
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.validateCourseResult);
			boolean result = objLibraryPage.validateCourseResult.isDisplayed();
			if (result == true)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter TOPIC");
				objLibraryPage.clikResettButton.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter Topics");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter," + e.getLocalizedMessage());

		}

		// For Purpose
		try {

			objLibraryPage.clickPurposeDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Purpose Dropdown");

			objLibraryPage.selectPurposeDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Purpose dropdown");

			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickSubmitButton.click();

			boolean result = objLibraryPage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Purpose");
				objLibraryPage.clikResettButton.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {
			System.out.println(e);
			objLibraryPage.clikResettButton.click();

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter PurPose");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter," + e.getLocalizedMessage());

		}

		// For Medium
		try {

			objLibraryPage.clickMediumDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Medium Dropdown");

			objLibraryPage.selectMediumDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Medium dropdown");

			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickSubmitButton.click();

			boolean result = objLibraryPage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Medium");
				objLibraryPage.clikResettButton.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {
			System.out.println(e);
			objLibraryPage.clikResettButton.click();

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter Medium");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter," + e.getLocalizedMessage());

		}

		// For Class
		try {

			objLibraryPage.clickClassDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Class Dropdown");

			objLibraryPage.selectClassDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Class dropdown");

			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickSubmitButton.click();

			boolean result = objLibraryPage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Class");
				objLibraryPage.clikResettButton.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {
			System.out.println(e);
			objLibraryPage.clikResettButton.click();

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter Class");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter," + e.getLocalizedMessage());

		}

		// For Subject
		try {

			objLibraryPage.clickSubjectDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Subject Dropdown");

			objLibraryPage.selectSubjectDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Subject dropdown");

			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickSubmitButton.click();

			boolean result = objLibraryPage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Subject");
				objLibraryPage.clikResettButton.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {
			System.out.println(e);
			objLibraryPage.clikResettButton.click();

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter Subject");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter," + e.getLocalizedMessage());

		}

		// Organizatoin
		try {

			objLibraryPage.clickOrganizationDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Organization Dropdown");

			objLibraryPage.selectOrganizationDropDown.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Organization dropdown");

			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickSubmitButton.click();

			boolean result = objLibraryPage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Organization");
				objLibraryPage.clikResettButton.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {
			System.out.println(e);
			objLibraryPage.clikResettButton.click();

			/*
			 * ExtentTestManager.getTest().log(LogStatus.FAIL,
			 * "Failed on Searching Content using Filter Organization");
			 * ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.
			 * getLocalizedMessage());
			 * Assert.fail("Failed on Searching Content using Filter,"+e.getLocalizedMessage
			 * ());
			 */

		}

	}

	public void carryForwardSearchFilter() {
		/*
		 * try {
		 */

		driver.get(APP_URL + "/explore-course");

		ExtentTestManager.getTest().log(LogStatus.INFO, "User is in Explore-Course Page");
		GenericFunctions.waitWebDriver(3000);

		try {

			objLibraryPage.clickPurposeDropDown.click();
			GenericFunctions.waitWebDriver(2000);

			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on PurposeDropdown");

			objLibraryPage.selectPurposeDropdown.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Filters in PurposeDropdown");

			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickSubmitButton.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Submit Button");
			
			
			GenericFunctions.waitWebDriver(1000);
			//GenericFunctions.scrollDownByPixel();
			
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickLatestCourseViewAllLink);
			objLibraryPage.clickLatestCourseViewAllLink.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on ViewAll Link");

			GenericFunctions.waitWebDriver(2000);
			
			wait.until(ExpectedConditions.urlContains("explore-course/view-all/Latest-Courses"));
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickFilters);
			objLibraryPage.clickFilters.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Filters");

			GenericFunctions.waitWebDriver(2000);

			boolean result = objLibraryPage.checkAppliedFilters.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Filters are carry forwarded succesfully");

			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Carry Forwarding Filters");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Carry Forwarding Filters" + e.getLocalizedMessage());

		}

	}	public void librarySearchForNewContents(List <TestDataForDiksha> objListOFTestDataForSunbird) throws Exception
	{
		Robot robot = new Robot();
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the library search");
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			//creatorUserPageObj.goToProfilePage();

			for(int i=0;i<searchInput.length;i++)
			{	
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				GenericFunctions.waitWebDriver(2000);
				if(searchInput[i].equalsIgnoreCase("BookA"))
				{
					String bookNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
					searchedContentName=objListOFTestDataForSunbird.get(2).getCourseName()+bookNumber;
				}
				else if(searchInput[i].equalsIgnoreCase("Automation content")) 
				{
					searchedContentName = (objListOFTestDataForSunbird.get(4).getCourseName() + "_"
							+ GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")).toString();
				}
				else if(searchInput[i].equalsIgnoreCase("Automation Collection"))
				{
					searchedContentName = objListOFTestDataForSunbird.get(5).getCourseName() + "_"
							+ GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt");
				}
				else if(searchInput[i].equalsIgnoreCase("lesson plan"))
				{
					String lessonNumber = GenericFunctions.readFromNotepad("./testData/lessonPlan.txt").toString();
					searchedContentName = objListOFTestDataForSunbird.get(3).getCourseName() + lessonNumber;
				}
				else if (searchInput[i].equalsIgnoreCase("Automation Resource"))
				{
					String resourceNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
					searchedContentName = objListOFTestDataForSunbird.get(6).getCourseName() + resourceNumber;
				}
				createUserPage.searchInput.clear();
				createUserPage.searchInput.sendKeys(searchedContentName);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(publicUserPage.showResults);
				if(publicUserPage.showResults.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.INFO, "Searched result :"+publicUserPage.searchedCourses1.getText());
					System.out.println("Searched result :"+publicUserPage.searchedCourses1.getText());
					System.out.println(publicUserPage.showResults.getText());
					/*js.executeScript("scroll(0, -250);");
					GenericFunctions.waitWebDriver(2000);
					publicUserPage.lastPageLink.click();*/
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.scrollToElement(publicUserPage.resultCourseCard);
					publicUserPage.resultCourseCard.click();
					GenericFunctions.waitForElementToAppear(createUserPage.plusIcon);
					createUserPage.plusIcon.click();
					GenericFunctions.waitWebDriver(1000);
					createUserPage.actualResourceName.get(0).click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(createUserPage.uiRemoveIcon);
					createUserPage.uiRemoveIcon.click();
					/*GenericFunctions.waitWebDriver(2000);
					js.executeScript("scroll(0, 250);");
					GenericFunctions.waitWebDriver(2000);
					js.executeScript("scroll(0, -250);");*/
					GenericFunctions.waitWebDriver(2000);
					ExtentTestManager.getTest().log(LogStatus.PASS, publicUserPage.showResults.getText()+" for input "+searchInput[i]+'\n'+", Searched result is:"+publicUserPage.searchedCourses1.getText());	
					Assert.assertTrue(true);

				}
				else
				{
					System.out.println("Results are not displayed for the inputs");
				}
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in library and getting the results");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on searching in library and getting the results");
			Assert.fail("Failed on searching in library and getting the results");
		}

	}
	public void librarySearchForOldContents(List <TestDataForDiksha> objListOFTestDataForSunbird) throws Exception
	{
		Robot robot = new Robot();
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the library search");
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			//creatorUserPageObj.goToProfilePage();

			for(int i=0;i<searchInput.length;i++)
			{	
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				GenericFunctions.waitWebDriver(2000);
				if(searchInput[i].equalsIgnoreCase("BookA"))
				{
					String bookNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
					searchedContentName=objListOFTestDataForSunbird.get(2).getCourseName()+bookNumber;
				}
				else if(searchInput[i].equalsIgnoreCase("Automation content")) 
				{
					searchedContentName = (objListOFTestDataForSunbird.get(4).getCourseName() + "_"
							+ GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")).toString();
				}
				else if(searchInput[i].equalsIgnoreCase("Automation Collection"))
				{
					searchedContentName = objListOFTestDataForSunbird.get(5).getCourseName() + "_"
							+ GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt");
				}
				else if(searchInput[i].equalsIgnoreCase("lesson plan"))
				{
					String lessonNumber = GenericFunctions.readFromNotepad("./testData/lessonPlan.txt").toString();
					searchedContentName = objListOFTestDataForSunbird.get(3).getCourseName() + lessonNumber;
				}
				else if (searchInput[i].equalsIgnoreCase("Automation Resource"))
				{
					String resourceNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
					searchedContentName = objListOFTestDataForSunbird.get(6).getCourseName() + resourceNumber;
				}
				createUserPage.searchInput.clear();
				createUserPage.searchInput.sendKeys(searchedContentName);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(publicUserPage.showResults);
				if(publicUserPage.showResults.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.INFO, "Searched result :"+publicUserPage.searchedCourses1.getText());
					System.out.println("Searched result :"+publicUserPage.searchedCourses1.getText());
					System.out.println(publicUserPage.showResults.getText());
					/*js.executeScript("scroll(0, -250);");
					GenericFunctions.waitWebDriver(2000);
					publicUserPage.lastPageLink.click();*/
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.scrollToElement(publicUserPage.resultCourseCard);
					publicUserPage.resultCourseCard.click();
					GenericFunctions.waitForElementToAppear(createUserPage.plusIcon);
					createUserPage.plusIcon.click();
					GenericFunctions.waitWebDriver(1000);
					createUserPage.actualResourceName.get(0).click();
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(createUserPage.uiRemoveIcon);
					createUserPage.uiRemoveIcon.click();
					/*GenericFunctions.waitWebDriver(2000);
					js.executeScript("scroll(0, 250);");
					GenericFunctions.waitWebDriver(2000);
					js.executeScript("scroll(0, -250);");*/
					GenericFunctions.waitWebDriver(2000);
					ExtentTestManager.getTest().log(LogStatus.PASS, publicUserPage.showResults.getText()+" for input "+searchInput[i]+'\n'+", Searched result is:"+publicUserPage.searchedCourses1.getText());	
					Assert.assertTrue(true);

				}
				else
				{
					System.out.println("Results are not displayed for the inputs");
				}
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in library and getting the results");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on searching in library and getting the results");
			Assert.fail("Failed on searching in library and getting the results");
		}

	}
	public List<String> getFirstAndLastPublishedContent() throws Exception
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to get First And Last Published Content");
			for(int i=0;i<=publicUserPage.searchedContentTypes.size();i++)
			{
				if(publicUserPage.searchedContentTypes.get(i).getText().equalsIgnoreCase("Course")) 
				{
					i++;
				}
				else
				{
					searchedFirstContentName = publicUserPage.searchedContents.get(i).getText();
					break;
				}

			}


			firstAndLastContent.add(searchedFirstContentName);
			GenericFunctions.scrollTillEndOfPage();
			objLibraryPage.lastPageLink.click();
			GenericFunctions.waitForElementToAppear(publicUserPage.searchedCourses1);
			searchedLastContentName = publicUserPage.searchedCourses1.getText();
			firstAndLastContent.add(searchedLastContentName);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to get First And Last Published Content");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to get First And Last Published Content" + e.getStackTrace());
			Assert.fail("Failed to get First And Last Published Content");
		}
		return firstAndLastContent;


	}
	public void librarySearchforOldAndNewContents(List<String> searchedData) throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "verifying the library search");
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();

			for(int i=0;i<searchedData.size();i++)
			{	
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				GenericFunctions.waitWebDriver(2000);
				createUserPage.searchInput.clear();
				createUserPage.searchInput.sendKeys(searchedData.get(i));
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(publicUserPage.showResults);
				if(publicUserPage.showResults.isDisplayed())
				{
					publicUserPage.resultCourseCard.click();
					GenericFunctions.waitWebDriver(3000);
					/*Assert.assertTrue(true);
					System.out.println("Searched result :"+publicUserPage.searchedCourses1.getText());
					System.out.println(publicUserPage.showResults.getText()+" for "+searchInput[i]);
					js.executeScript("scroll(0, 250);");
					GenericFunctions.waitWebDriver(2000);
					js.executeScript("scroll(0, -250);");
					GenericFunctions.waitWebDriver(5000);
					ExtentTestManager.getTest().log(LogStatus.PASS, publicUserPage.showResults.getText()+" for input "+searchInput[i]+'\n'+", Searched result is:"+publicUserPage.searchedCourses1.getText());	
					Assert.assertTrue(true);*/

				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Results are not displayed for the inputs");
				}
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in library and getting the results");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Failed on searching in the library" + e.getStackTrace());
			Assert.fail("Failed on searching in the library");
		}

	}
	public String createQuestionsWith10MCQ10FTB10MTF(List<TestDataForDiksha> objListOFTestDataForSunbird) {
		String resourceName = null;
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to a create Resource and Create Question");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName() + resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);
			System.out.println("Adding Resource: " + createUserPage.untitledCollection.getText());
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.addQuestionSet);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(4000);
			//GenericFunctions.waitForElementToAppear(createUserPage.questionCheckbox);
			// GenericFunctions.waitWebDriver(1000);
			// GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.questionCheckbox);
			for(int j=0;j<SEARCH_QUESTIONTYPE.length;j++)
			{
				objLibraryPage.searchTextInQuestion.click();
				objLibraryPage.searchTextInQuestion.sendKeys(SEARCH_QUESTIONTYPE[j]);
				objLibraryPage.searchIconInQuestion.click();
				GenericFunctions.waitWebDriver(3000);

				for(int i=0;i<10;i++)
				{
					objLibraryPage.checkBoxInSelectQuestion.get(i).click();
					GenericFunctions.waitWebDriver(2000);
				}
				objLibraryPage.searchTextInQuestion.clear();
			}


			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(createUserPage.nextButton);
			createUserPage.nextButton.click();
			createUserPage.questionSetTitle.sendKeys("Math test");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(50000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Question ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			System.out.println("Failed to create Question");
			Assert.fail("Failed to create Question ");
		}
		System.out.println("ResourceName -" + resourceName);
		return resourceName;
	}
	public void navigateToLibraryAndSearchForResource() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Book");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseCard);
			createMentorPage.courseCard.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForBook"+e.getMessage());
			Assert.fail("Failed to navigate To Library And Search For Book, Exception"+e.getLocalizedMessage());
		}
	}


	public void filterInTeachingMaterialSection(String sectionName) {

		try {
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickLibray);
			objLibraryPage.clickLibray.click();
			GenericFunctions.waitWebDriver(5000);


			genericFunctions.scrollDownByPixel();
			GenericFunctions.waitWebDriver(2000);

			if (sectionName.equalsIgnoreCase("TeacherMaterial")) {
				ExtentTestManager.getTest().log(LogStatus.INFO, "Verify the List of the result in " + sectionName);
				if (objLibraryPage.teachingMaterialViewAllSection.isDisplayed()) {
					ExtentTestManager.getTest().log(LogStatus.PASS, "View All Section  is verified in" + sectionName);

					GenericFunctions.waitWebDriver(2000);


					objLibraryPage.teachingMaterialViewAllSection.click();
					GenericFunctions.waitWebDriver(6000);
					objLibraryPage.validateResource.isDisplayed();

					ExtentTestManager.getTest().log(LogStatus.PASS, "Result is verified in " + sectionName);

				}
			}
			GenericFunctions.waitWebDriver(2000);

			objLibraryPage.searchInLibrary.sendKeys("Auto Content");
			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickSearch.click();
			GenericFunctions.waitWebDriver(6000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User Entered Content in Search box");

			GenericFunctions.scrollToStartOfPage();
			objLibraryPage.clickFilters.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Filters");
	
			
			GenericFunctions.waitWebDriver(3000);

			objLibraryPage.clickDropdownMedium.click();
			GenericFunctions.waitWebDriver(1000);

			objLibraryPage.sltMediumDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Medium Dropdown");


			objLibraryPage.clickApply.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");

			GenericFunctions.waitForElementToAppear(objLibraryPage.validateFilteredContent);

			if (objLibraryPage.validateFilteredContent.isDisplayed()) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is Verified after Filter in Teaching Material Section");
			}


		} catch (Exception e) {
			

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Verifying Content after applying filter in " + sectionName);

		}
	}








	public void filterForLibraryPageSections(String sectionName) {

		try {
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.clickLibray);
			objLibraryPage.clickLibray.click();
			GenericFunctions.waitWebDriver(10000);
			if(sectionName.contains("Practice"))
			{
				GenericFunctions.scrollDownByPixel();
				GenericFunctions.scrollDownByPixel();
			}
			if(sectionName.contains("Teaching Material"))
			{
				GenericFunctions.scrollDownByPixel();
				GenericFunctions.scrollDownByPixel();

			}
			if(sectionName.contains("Learning Material"))
			{
				GenericFunctions.scrollDownByPixel();
				GenericFunctions.scrollDownByPixel();
			}
			if(sectionName.contains("Practice"))
			{
				GenericFunctions.scrollDownByPixel();
				GenericFunctions.scrollDownByPixel();
				//GenericFunctions.scrollDownByPixel();
				//GenericFunctions.scrollDownByPixel();
				GenericFunctions.scrollTillEndOfPage();
			}
			GenericFunctions.waitWebDriver(2000);
			driver.findElement(By.xpath(sectionName)).click();
			GenericFunctions.waitWebDriver(5000);
	
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitWebDriver(2000);
			objLibraryPage.clickFilters.click();
			GenericFunctions.waitWebDriver(2000);

			objLibraryPage.clickDropdownMedium.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on Medium Dropdown");

			objLibraryPage.sltMediumDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Medium Dropdown");

			objLibraryPage.clickApply.click();
			GenericFunctions.waitWebDriver(3000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");

			GenericFunctions.waitForElementToAppear(objLibraryPage.validateFilterResult);

			if (objLibraryPage.validateFilterResult.isDisplayed()) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is Verified after Applying Filter in Medium ");
			}


		} catch (Exception e) {
			System.out.println("Failed on Verifying Content after applying filter Medium ");

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Verifying Content after applying filter in Medium");

		}




		try {

			objLibraryPage.clikResettButton.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on Reset Button");

			objLibraryPage.clickDropdownClass.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on Class Dropdown");
			objLibraryPage.sltClassDropdown.click();
			GenericFunctions.waitWebDriver(1000);



			objLibraryPage.sltClassDropdown2.click();
			GenericFunctions.waitWebDriver(1000);

			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Class Dropdown");

			objLibraryPage.clickApply.click();
			GenericFunctions.waitWebDriver(3000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");

			GenericFunctions.waitForElementToAppear(objLibraryPage.validateFilterResult);

			if (objLibraryPage.validateFilterResult.isDisplayed()) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is Verified after Applying Filter in Class ");
			}


		} catch (Exception e) {
			System.out.println("Failed on Verifying Content after applying filter Class ");

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Verifying Content after applying filter in Class");

		}



		try {

			objLibraryPage.clikResettButton.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on Reset Button");

			objLibraryPage.clickDropdownsubject.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on Subject Dropdown");

			objLibraryPage.sltSubjectDropdown.click();
			GenericFunctions.waitWebDriver(1000);

			objLibraryPage.sltsubjectDropdown2.click();
			GenericFunctions.waitWebDriver(1000);

			ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Subject Dropdown");

			objLibraryPage.clickApply.click();
			GenericFunctions.waitWebDriver(3000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");

			GenericFunctions.waitForElementToAppear(objLibraryPage.validateFilterResult);

			if (objLibraryPage.validateFilterResult.isDisplayed()) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is Verified after Applying Filter in Subject ");
			}


		} catch (Exception e) {
			

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Verifying Content after applying filter in Subject");

		}



	}	
	
	/*
	 * purpose : To Check the Training Attended Section and verify all completed course batches are available in the list
	 */
	
	
	public void verifyTrainingsAttendedSection()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify Training Attended section is displayed with completed course batches in profile page");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(objLibraryPage.trainingsAttendedSection);			
			if(objLibraryPage.trainingsAttendedSection.isDisplayed()&&objLibraryPage.completedCourseBatches.isDisplayed())
			{
				GenericFunctions.waitWebDriver(1000);
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO, "User has Training attended section in profile page, All the completed courses batches are displayed "+objLibraryPage.completedCourseBatches.getText());
						
			}
			
			
		}
		catch(Exception e )
		{
			
		}
	}

	public void copyContentAndVerify(String ResourceName) throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Book");
			GenericFunctions.waitWebDriver(3500);
			objLibraryPage.copyContentLink.click();
			//Assert.assertEquals(actual, ResourceName,"updated but not published changes are available");
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForBook"+e.getMessage());
			Assert.fail("Failed to navigate To Library And Search For Book, Exception"+e.getLocalizedMessage());
		}
	}

	public void shareContentAndConsumeInDifferentBrowser(String contentUsed) throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Book");
			GenericFunctions.waitWebDriver(3500);
			String contentName = coursePage.contentName.getText();
			coursePage.shareIcon.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertEquals(coursePage.copyLink.isDisplayed(), true,"copy link is not available");
			Assert.assertEquals(coursePage.linkCopiedToClipBoard.isDisplayed(), true,"copy link is not available");
			String newURL = coursePage.getTheLink.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, newURL);
			/*WebDriver driver = new OperaDriver();
			driver.get(newURL);
			GenericFunctions.waitWebDriver(3500);
			Assert.assertEquals(contentName, contentUsed,"content is not same in two browsers");
			GenericFunctions.waitWebDriver(2000);
			driver.quit();*/
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForBook"+e.getMessage());
			Assert.fail("Failed to navigate To Library And Search For Book, Exception"+e.getLocalizedMessage());
		}
	}





}
