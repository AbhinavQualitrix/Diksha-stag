package org.pageobjects;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
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
public class SignUpPageObj extends BaseTest {
	static Logger log = Logger.getLogger(SignUpPageObj.class.getName());
	SignUpPage objSignUp = PageFactory.initElements(driver, SignUpPage.class);
	UploadOrgPage orgUploadPage = PageFactory.initElements(driver, UploadOrgPage.class);
	CreatorUserPage createUserPage = PageFactory.initElements(driver, CreatorUserPage.class);
	Actions action = new Actions(driver);
	CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	GenericFunctions genericFunctions = new GenericFunctions();

	/**
	 * Purpose: userLogin() method is used for user logging
	 */

	public void userLogin(String userRole) throws InterruptedException, Exception {
		try {

			String[] Creden = FetchUserCredentials(userRole);
			/*
			 * GenericFunctions.waitForElementToAppear(orgUploadPage.loginButton);
			 * orgUploadPage.loginButton.click();
			 */
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL + "/home");
			// driver.get("https://preprod.ntp.net.in/home");
			GenericFunctions.waitForElementToAppear(orgUploadPage.username);
			orgUploadPage.username.sendKeys(Creden[0]);
			orgUploadPage.password.sendKeys(Creden[1]);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.clickLogin1);
			orgUploadPage.clickLogin1.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is logged in as "+userRole);
			if(userRole.equalsIgnoreCase(PUBLICUSER1)||userRole.equalsIgnoreCase(PUBLICUSER2)||userRole.equalsIgnoreCase(ADMIN)

					||userRole.equalsIgnoreCase(TC_TESTUSER) ||userRole.equalsIgnoreCase(FRAMEWORK_TESTUSER)||userRole.equalsIgnoreCase(UNAUTHENTIC_USER)||userRole.equalsIgnoreCase(CUSTODIANUSER))

			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "No workspace is available for "+userRole);
				
			}
			else
			{
				
				createUserPageObj.tryForWorkSpace();
			}
		} catch (Exception e) {
			
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to login to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to login to the application" + e.getStackTrace());
			Assert.fail("Failed to login to the application ," + e.getLocalizedMessage());

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

	/**
	 * Purpose: userLogout() method is used for user logout
	 */

	// Nov 28
	public void userLogout() throws Exception {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Log out");

			UploadOrgPage orgUploadPage = PageFactory.initElements(driver, UploadOrgPage.class);

			driver.switchTo().defaultContent();
			GenericFunctions.refreshWebPage();

			GenericFunctions.waitWebDriver(3000);
			Boolean dropDown = genericFunctions.isElementPresent(orgUploadPage.dropdown);
			if (dropDown == true) {
				System.out.println(" header dropDown is present");
			} else {
				driver.get(APP_URL + "/workspace");
			}

			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
			GenericFunctions.waitWebDriver(1000);
			action.moveToElement(orgUploadPage.logout).build().perform();
			action.click(orgUploadPage.logout).build().perform();
			GenericFunctions.waitWebDriver(3500);
			
		}
		catch(Exception e)
		{

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on logging out");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method userLogout" + e.getLocalizedMessage());
			Assert.fail("Failed on logging out, Exception : " + e.getLocalizedMessage());
		}

	}


	public String singleSignUpUser() throws InterruptedException {
		String alerttext = "";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Single User is trying to Sign up to the application");
			List<TestDataForDiksha> objListOFTestDataForSunbird = null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetuserinfo");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL + "/home");
			GenericFunctions.waitWebDriver(2000);
			objSignUp.signUpLink.click();
			GenericFunctions.waitForElementToAppear(objSignUp.username);
			objSignUp.username.sendKeys(objListOFTestDataForSunbird.get(0).getUsername());
			GenericFunctions.waitWebDriver(2000);
			objSignUp.phone.sendKeys(objListOFTestDataForSunbird.get(0).getPhone());
			objSignUp.password.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());
			objSignUp.confirmPassword.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());

			GenericFunctions.waitWebDriver(2000);

			try {

				/*
				 * GenericFunctions.waitTillTheElementIsVisibleAndClickable(objSignUp.
				 * signUpButton); GenericFunctions.waitWebDriver(1000);
				 * action.moveToElement(objSignUp.signUpButton); objSignUp.signUpButton.click();
				 */
				GenericFunctions.waitWebDriver(500);
				GenericFunctions.captureScreenshotOnValidation();
				action.moveToElement(objSignUp.alertLabel.get(0)).build().perform();
				alerttext = objSignUp.alertLabel.get(0).getText();
				ExtentTestManager.getTest().log(LogStatus.PASS, alerttext);
				System.out.println(alerttext);
				Assert.assertEquals("Mobile Number is already registered", alerttext);
				/*
				 * if(objSignUp.alertLabel.size()!=0) { int noOfAlertLabel =
				 * objSignUp.alertLabel.size(); for(int i=0 ; i<=noOfAlertLabel;i++) { String
				 * alertText = objSignUp.alertLabel.get(noOfAlertLabel).getText();
				 * System.out.println(alertText);
				 * ExtentTestManager.getTest().log(LogStatus.INFO,"Alert text -"+alertText); } }
				 * else { Assert.assertTrue(true);
				 * System.out.println("No error on filling the fields on SignUp");
				 * ExtentTestManager.getTest().log(LogStatus.
				 * INFO,"No error on filling the fields on SignUp"); }
				 */
			}
			catch (Exception e)
			{
				System.out.println("Exception Message" + e.getLocalizedMessage());
				ExtentTestManager.getTest().log(LogStatus.INFO, "User credentials is already used for SignUp");
				Assert.fail("User credentials is already used for SignUp" + e.getLocalizedMessage());
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Single Sign up to the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on sign up to the application" + e.getLocalizedMessage());
		}

		return alerttext;
	}
	public void checkUserDataExists() throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Verifying whether the currently creating data has existed or not");
			try {
				/*GenericFunctions.waitForElements(objSignUp.alertMessage);
				if (objSignUp.alertMessage.size() != 0) {
					action.moveToElement((WebElement) objSignUp.alertMessage).build().perform();
					objSignUp.alertMessage.get(0).click();
					String alertMessage = objSignUp.alertMessage.get(0).getText();
					ExtentTestManager.getTest().log(LogStatus.INFO, "Alert Message: " + alertMessage);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Checked for the alert message, and verified same user cannot signup again");
					System.out.println(objSignUp.alertMessage.get(0).getText());*/
				GenericFunctions.waitWebDriver(1000);
				if(objSignUp.signUpBtn.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,"Single User sign up is verified");
				}
			} catch (Exception e) {
				System.out.println(
						"Could not check for the Alert message On Same Data Sign-Up" + e.getLocalizedMessage());
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Could not check for the alert message, and verified same user cannot signup again");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not check");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on sign up to the application" + e.getLocalizedMessage());
		}

	}


}
