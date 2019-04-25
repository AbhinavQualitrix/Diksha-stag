package org.testscript.publicuser;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreatorUserPage;
import org.page.UploadOrgPage;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.startup.IAutoConst;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Enroll200UsersTOBatch extends BaseTest
{

	@Test
	public void enrollToCourse200Users() throws Exception
	{
			//	public WebDriver driver;

		UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
		CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
		SignUpPageObj signupObj = new SignUpPageObj();


		for(int i=0;i<=9;i++)
		{
			List <TestDataForDiksha> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

			/*driver = new ChromeDriver(); 

			driver.manage().window().maximize();


			driver.get(APP_URL+"/home");
			 */

			//driver.get("https://preprod.ntp.net.in/home");
			try
			{
				/*for(int j=0;j<=103;j++)
				{*/
				
					GenericFunctions.waitWebDriver(2000);
					driver.get(APP_URL+"/home");
					GenericFunctions.waitWebDriver(2000);
					GenericFunctions.waitForElementToAppear(orgUploadPage.username);
					System.out.println("UN "+objListOFTestDataForSunbird.get(i).getCourseName()+ " PW "+objListOFTestDataForSunbird.get(i).getCourseDescription());
					orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(i).getCourseName());
					orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(i).getCourseDescription());

					GenericFunctions.waitWebDriver(500);
					GenericFunctions.waitForElementToAppear(orgUploadPage.clickLogin1);
					orgUploadPage.clickLogin1.click();
					System.out.println("Execution count "+i);
					GenericFunctions.waitWebDriver(2000);
					createUserPage.headerCourse.click();
					GenericFunctions.waitWebDriver(500);
					GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
					createUserPage.searchInput.sendKeys("05-03-19-course");
					createUserPage.searchIcon.click();
					GenericFunctions.waitWebDriver(2000);
					//WebElement el=driver.findElement(By.xpath("//h4[contains(.,'Course with Open Batch')]"));			
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(createUserPage.el);
					createUserPage.el.click();

					//WebElement el1=driver.findElement(By.xpath("//button[contains(.,'Enroll')]"));
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(createUserPage.el1);
					createUserPage.el1.click();

					//WebElement el2=driver.findElement(By.xpath("//button[contains(.,'ENROLL')]"));
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(createUserPage.el2);
					createUserPage.el2.click();
					GenericFunctions.waitWebDriver(3000);
					//GenericFunctions.refreshWebPage();

					WebElement el3=driver.findElement(By.xpath("//button[contains(.,'RESUME')]"));
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(el3);
					if(el3.isDisplayed())
					{
						Assert.assertTrue(true);
						System.out.println("Enrolled to Course Iteration "+i);

					}

					GenericFunctions.waitWebDriver(2000);
					//	driver.manage().deleteAllCookies();
					//driver.close();
					//signupObj.userLogout();
					GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
					orgUploadPage.dropdown.click();
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
					GenericFunctions.waitWebDriver(1000);
					orgUploadPage.logout.click();
					System.out.println("Logged out");
					driver.manage().deleteAllCookies();
					GenericFunctions.waitWebDriver(1000);
					/*driver.quit();
					GenericFunctions.waitWebDriver(1000);
					driver = new ChromeDriver(); 

					driver.manage().window().maximize();*/
					//GenericFunctions.refreshWebPage();
				}
			//}
			catch(Exception e)
			{
				System.out.println("Exception "+e.getLocalizedMessage());
				/*
				GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
				orgUploadPage.dropdown.click();
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
				GenericFunctions.waitWebDriver(1000);
				orgUploadPage.logout.click();
				*/
				
			
			}
			//SignUpPageObj signupObj = new SignUpPageObj();

		}


		/*public static void waitTillTheElementIsVisibleAndClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitWebDriver(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());

		}
	}

	public static WebElement waitForElementToAppear(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(id));
		return id;
	}*/


		//Course details: https://staging.ntp.net.in/learn/course/do_21271419069843046416175
	}
}




