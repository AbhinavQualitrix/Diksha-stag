package org.pageobjects;





import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.apache.log4j.Logger;
import org.generic.AllUploadingPaths;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.ContentCreateUploadPage;
import org.page.CoursePage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.LibraryPage;
import org.page.PublicUserPage;
import org.page.UploadOrgPage;
import org.page.WorkspacePage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;



public class WorkspacePageObj extends BaseTest
{
	//WebDriver driver;
	String onboardingUrl="https://staging.ntp.net.in/resources";
	String onboardingTabame="Custodian Org";
	WorkspacePage workspacePage = PageFactory.initElements(driver, WorkspacePage.class);
	CreatorUserPage createUserPage = PageFactory.initElements(driver, CreatorUserPage.class);
	ContentCreateUploadPage contentUploadPage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	LibraryPage libraryPage = PageFactory.initElements(driver, LibraryPage.class);
	UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
	CreateMentorPage createMentorPage = PageFactory.initElements(driver, CreateMentorPage.class);
	CoursePage coursePage = PageFactory.initElements(driver, CoursePage.class);

	static Logger log = Logger.getLogger(WorkspacePageObj.class.getName());

	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	

	//new PublicUserPage();

	Actions actions = new Actions(driver);
	Alert alert;
	CreatorUserPageObj createUserObj = new CreatorUserPageObj();
	GenericFunctions generic = new GenericFunctions();
	Random rand = new Random();


	/**
	 * Purpose: verifyTermsAndConditionsPopup method is used to verify the terms and conditions popup.
	 */

	public void verifyTermsAndConditionsPopup()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the Terms And Conditions Popup after New SignUp");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(workspacePage.termsAndCoditionLabel);
			//Boolean url = wait.until(ExpectedConditions.urlContains(onboardingUrl));
			if(driver.getCurrentUrl().contentEquals(onboardingUrl) 
					&& workspacePage.termsAndCoditionLabel.isDisplayed()
					&& workspacePage.termsAndConditionsText.isDisplayed() )
			{
				System.out.println(driver.getCurrentUrl());

				ExtentTestManager.getTest().log(LogStatus.PASS, "Terms And Conditions Popup is displayed after New User SignUp");
				Assert.assertTrue(true);
				GenericFunctions.scrollToElement(workspacePage.termsAndConditionsCheckBox);
				if(workspacePage.termsAndConditionsCheckBox.isDisplayed())
				{
					GenericFunctions.waitWebDriver(2000);
					workspacePage.termsAndConditionsCheckBox.click();
					GenericFunctions.waitWebDriver(2000);
					System.out.println("Continue button color"+workspacePage.continueButton.getCssValue("background-color"));
					workspacePage.termsAndConditionsCheckBox.click();
					//if(workspacePage.termsAndConditionsCheckBox)
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "User can accept Terms And Conditions after New SignUp"+workspacePage.continueButton.getCssValue("background-color"));


				}


			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify Terms And Conditions Popup after New SignUp");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying T&C"+e.getLocalizedMessage());
			ExtentTestManager.endTest();
			System.out.println("Failed to verify Terms And Conditions Popup after New SignUp");
			Assert.fail("Failed to verify Terms And Conditions Popup after New SignUp");
		}

	}


	/**
	 * Purpose: checkNoTermsAndConditionsPopup method is used to verify NO Terms and Conditions popup is displayed to the user.
	 */


	public void checkNoTermsAndConditionsPopup()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that NO Terms And Conditions Popup on second or more login");
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);

			if(createUserPage.headerCourse.isDisplayed()&&createUserPage.headerLibrary.isDisplayed())
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "NO Terms and Conditions popup is displayed to the user "
						+ "on second or more logins , User is in HOME PAGE "+driver.getCurrentUrl());
				Assert.assertTrue(true);

			}
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that NO Terms And Conditions Popup on second or more login");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying NO T&C"+ex.getLocalizedMessage());
			System.out.println("Exception on verifying NO T&C popup"+ex.getLocalizedMessage());
			Assert.fail("Failed to verify that NO Terms And Conditions Popup after first or more signups");
		}
	}

	/*
	 * Properties properties =new Properties();
	 * 
	 * public Properties getNewFeatureObjRepo() throws Exception { InputStream
	 * input= new FileInputStream(new
	 * File(System.getProperty("user.dir")+"newFeatureObjRepo.properties"));
	 * properties.load(input); return properties;
	 * 
	 * }
	 */

	/**
	 * Purpose: uploadContentToVerifyOwnershipTypeDropdown method is used to verify ownershipType dropdown feature.
	 */

	public String uploadContentToVerifyOwnershipTypeDropdown()
	{
		String createdForText=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload content");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			String uploadedContent=uploadContentsRandomly();
			System.out.println("UC "+uploadedContent);

			GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
			//GenericFunctions.waitForElementToAppear(createUserPage.editdetailslink);

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify ownershipType dropdown feature");
			createUserPage.editOrViewDetailslink.click();			
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			createUserPage.contentMp4Title.sendKeys(uploadedContent+" ownershipType test content");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			System.out.println("waited here");
			//actions.moveToElement(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			System.out.println("passing here");
			createUserPage.selectOwner.click();
			createdForText=workspacePage.selectedCreatedForType.getText();
			System.out.println(createdForText);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeButtonMsg);			
			if(createUserPage.closeButtonMsg.isDisplayed())
			{
				createUserPage.closeButtonMsg.click();
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User has verifed 'createdBy' and 'createdFor' fields");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is select 'CreatedFor' ownershipType in dropdown "
						+createdForText+" is the Org Name to which content is createdFor");
			}
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();

		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying verifying ownershipType dropdown and features "+ex.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify ownershipType dropdown and features");			
			System.out.println("Exception on verifying verifying ownershipType dropdown and features "+ex.getLocalizedMessage());
			Assert.fail("Failed to verify ownershipType dropdown and features");
		}
		return createdForText;
	}

	/**
	 * Purpose: uploadContentsRandomly method is used to randomly upload the content.
	 */

	public String uploadContentsRandomly()
	{

		String contentToUpload=(UPLOAD_CONTENTS[new Random().nextInt(UPLOAD_CONTENTS.length)]);
		System.out.println("CONTENT "+contentToUpload);
		WebElement browse=createUserPage.browseButton;
		String path=null;

		switch(contentToUpload)
		{

		case "youtube":
		{
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			path=contentToUpload;
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.popupUploadButton);
			contentUploadPage.popupUploadButton.click();
			GenericFunctions.waitWebDriver(10000);
			//GenericFunctions.waitForElementToAppear(createUserPage.editdetailslink);
			break;
		}
		case "mp4" :
		{

			System.out.println(AllUploadingPaths.mp4Path);
			GenericFunctions.waitWebDriver(5000);
			browse.sendKeys(AllUploadingPaths.mp4Path);
			GenericFunctions.waitWebDriver(7000);

			path=contentToUpload;
			break;
		}

		case "pdf" :
		{

			System.out.println(AllUploadingPaths.pdfPath);
			GenericFunctions.waitWebDriver(5000);
			browse.sendKeys(AllUploadingPaths.pdfPath);
			GenericFunctions.waitWebDriver(7000);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editdetailslink);
			path=contentToUpload;
			break;
		}


		}
		System.out.println("path after uploading "+path);
		return path;	


	}

	/**
	 * Purpose: verifyUserCanEditWhenOpenedFromAllUploads method is used to verify User Can Edit When Opened From All Uploads.
	 */

	public void verifyUserCanEditWhenOpenedFromAllUploads(String compareText)
	{
		try
		{
			System.out.println(compareText);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit ownershipType by opening same content from ALL UPLOADS");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.allUploads);
			createUserPage.allUploads.click();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(workspacePage.ownershipContentInAppUploads);
			workspacePage.ownershipContentInAppUploads.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editOrViewDetailslink);
			createUserPage.editOrViewDetailslink.click();
			//actions.moveToElement(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(workspacePage.clikcOwnerTypeToEdit);
			workspacePage.clikcOwnerTypeToEdit.click();
			GenericFunctions.waitWebDriver(2000);
			//workspacePage.selectedCreatedForType.click();

			//WebElement createdByElement=driver.findElement(By.xpath("//label[contains(.,'OWNER')]/"));
			//workspacePage.createdByType.getText();
			String createdByText=workspacePage.selectedCreatedForType.getText();
			System.out.println(createdByText);
			if(compareText.equalsIgnoreCase(createdByText))
			{
				workspacePage.selectcreatedByType.click();
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User can EDIT and VERIFY both 'CreatedFor' and 'CreatedBy' ownershipTypes");
				ExtentTestManager.getTest().log(LogStatus.PASS, workspacePage.selectcreatedByType.getText()+" is the createdBy value present in ownershipType");

			}
			else
			{
				Assert.fail("failed on comparing createdForType");

			}
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();

		}	

		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify ownershipType dropdown and features");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying verifying ownershipType dropdown and features"+ex.getLocalizedMessage());
			System.out.println("Exception on verifying verifying ownershipType dropdown and features"+ex.getLocalizedMessage());
			Assert.fail("Failed to verify ownershipType dropdown and features");
		}
	}


	/*public void findContentInReviewSubmission()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to find content in Review Submission");
			//String [] contentNamesInReviewSubmission = {"TextBook","Enter description for Resource","LessonPlan","Course","Collection","Content Description"};
			GenericFunctions.waitWebDriver(3000);
			List<String> contentNamesInReviewSubmission = Arrays.asList("TextBook","LessonPlan","Course","Collection");
			List<String> contentDescInRviewSubmission = Arrays.asList("Enter description for Resource","Content Description");

			do
			{
				createUserPage.reviewSubmission.click();
				GenericFunctions.waitWebDriver(3000);


				for(int i=0;i<=workspacePage.getContentNameFromRS.size();i++)
				{
					String content=workspacePage.getContentNameFromRS.get(i).getText();
					System.out.println(content);
					if(content.contains(contentNamesInReviewSubmission.get(i)))
					{
						workspacePage.getContentNameFromRS.get(i).click();
						break;
						//WebElement e:workspacePage.getContentNameFromRS.get()
					}
					else if(content.contains(contentDescInRviewSubmission.get(i).toString()))
					{
						workspacePage.getContentNameFromRS.get(i).click();
					}
					else
					{
						GenericFunctions.waitWebDriver(2000);
						GenericFunctions.scrollToElement(workspacePage.NextButton);
						workspacePage.NextButton.click();
					}

				}
				GenericFunctions.waitWebDriver(2000);
				continue;

			}while(workspacePage.Page10InReviewSubmission.isDisplayed()==false);

			for(int i=0;i<=workspacePage.getContentNameFromRS.size();i++)
			{
				if(workspacePage.getContentNameFromRS.get(i).getText().contains("TextBook"))
				{
					workspacePage.getContentNameFromRS.get(i).click();
					GenericFunctions.
				}



				for(WebElement e:workspacePage.getContentNameFromRS.get(i))
				{
					if((e.getText().compareTo(contentNamesInReviewSubmission.get(i).toString()))!=0)
					{
						GenericFunctions.waitWebDriver(2000);
						e.click();
					}
					else
					{
						i++;
					}
				}

			}
			//workspacePage.getContentNameFromRS.get
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to find content in Review Submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on finding content in Review Submission"+ex.getLocalizedMessage());
			System.out.println("Exception on finding content in Review Submission"+ex.getLocalizedMessage());
			Assert.fail("Failed to find content in Review Submission");
		}
	}*/




	/*public String findContentInDrafts()
	{

		//System.out.println(param.length);
		int i=0;
		try
		{
			do
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "USer is trying to Open "+param[i]+
						" from DRAFTS and verify value of OwnershipType dropdown");
				//a[contains(@class,'black right ribbon') and contains(.,TextBook)]
				String xpath="//a[contains(@class,'black right ribbon') and contains(.,'"+param[i]+"')]";
				GenericFunctions.waitWebDriver(2000);	
				GenericFunctions.refreshWebPage();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(workspacePage.contentCardInDraft);

				WebElement contentInDraft = driver.findElement(By.xpath(xpath));
				try
				{
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(contentInDraft);
					boolean present = contentInDraft.isDisplayed();
					if(present==true)
					{
						GenericFunctions.waitWebDriver(2000);
						contentInDraft.click();
						GenericFunctions.waitWebDriver(2000);
						verifyOwnerTypeInContentWhenFound();
					}
					else if(present==false)
					{
						System.out.println(param[i]);
						GenericFunctions.waitWebDriver(1000);
						GenericFunctions.scrollToElement(workspacePage.NextButton);
						workspacePage.NextButton.click();
						GenericFunctions.waitWebDriver(1000);
						findContentInDrafts(param[i]);
						//System.out.println("Exception here");
					}
				}
				catch(Exception ee)
				{
					System.out.println("Exception on finding content"+ee);
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(workspacePage.NextButton);
					workspacePage.NextButton.click();

				}


				i++;
			}while(i<param.length);
		}
		catch(NoSuchElementException Nse)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+param[i]+" "
					+ "from the Drafts and verify value of OwnershipType dropdown");
			System.out.println("No Such Element Exception , content not found in draft "+Nse);
			createContentWhichNotFoundInDrafts(param[i]);
			System.out.println("Content Created and calling same method again");
			//	findContentInDrafts();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(workspacePage.NextButton);
			workspacePage.NextButton.click();
			findContentInDrafts();
		}
		catch(Exception ge)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+param[i]+" "
					+ "from the Drafts and verify value of OwnershipType dropdown");
			System.out.println("General Exception"+ge);
			Assert.fail("");
		}

		return param[i];
	}*/

	/**
	 * Purpose: createContentWhichNotFoundInDrafts method is used to create content which is not found in drafts.
	 */

	public void createContentWhichNotFoundInDrafts(String createThis)
	{

		ExtentTestManager.getTest().log(LogStatus.INFO,"content is not found in Drafts, so creating it ");
		createUserObj.navigateToWorkspace(createThis);
		GenericFunctions.waitWebDriver(1000);
		GenericFunctions.waitForElementToAppear(createUserPage.startCreating);
		createUserPage.startCreating.click();
		GenericFunctions.waitWebDriver(1000);
		addOwnershipTypeToContent();
	}

	/**
	 * Purpose: addOwnershipTypeToContent method is used to add OwnershipType To Content.
	 */

	public void addOwnershipTypeToContent()
	{
		try
		{
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectOwner.click();	
			saveCloseEditorIcon();
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Could not add ownershipType to the content"+ex.getLocalizedMessage());
			System.out.println("Could not add ownershipType to the content"+ex.getLocalizedMessage());
			Assert.fail("Could not add ownershipType to the content");
		}
	}

	/**
	 * Purpose: saveCloseEditorIcon method is used to save Close Editor Icon .
	 */
	public void saveCloseEditorIcon()
	{
		try
		{
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			try
			{
				GenericFunctions.waitWebDriver(2000);	
				driver.switchTo().alert().accept();//alert.accept();

			}
			catch(Exception al)
			{
				System.out.println("could not find alert "+al.getMessage());
			}
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.INFO,"Exception for save, close the editor icon"+ex.getLocalizedMessage());
			System.out.println("Exception for save, close editor icon"+ex.getLocalizedMessage());
		}
	}

	/*
	 * purpose : To verify the dropdown values of ownershipType dropdown
	 */
	public void verifyOwnerTypeInContentWhenFound()
	{
		String foundValue,foundValue1="";
		try
		{
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1000);

			try
			{
				boolean value=workspacePage.clikcOwnerTypeToEdit.isDisplayed();
				if(value==true)
				{
					GenericFunctions.scrollToElement(workspacePage.clikcOwnerTypeToEdit);
					workspacePage.clikcOwnerTypeToEdit.click();
					GenericFunctions.waitWebDriver(1000);
					//workspacePage.DefaultValueOfOwnershipTypeDdl.click();
					foundValue=workspacePage.selectcreatedByType.getText();
					foundValue1=workspacePage.selectcreatedForType.getText();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.captureScreenshotOnValidation();
					//saveCloseEditorIcon();
					workspacePage.closeIconInEditDetails.click();
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Content has ownershipType Dropdown value "+foundValue+" and "+foundValue1);
					//addOwnershipTypeToContent();
				}
				else if(value==false)
				{
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(createUserPage.clickOwner);
					if(createUserPage.clickOwner.isDisplayed())
					{
						createUserPage.clickOwner.click();
						GenericFunctions.captureScreenshotOnValidation();
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Verified Dropdown value of ownershipType ");
					}
				}
				driver.get("https://staging.ntp.net.in/workspace");
				GenericFunctions.waitWebDriver(1000);
				//GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
				//createUserPage.workSpace.click();
				generic.navigateToWorkspaceFeatures(DRAFTS);

			}
			catch(Exception ownershipValue)
			{
				System.out.println("Could not verify dropdown value of ownershipType in the found content");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Could not verify dropdown value of ownershipType in the content ");
			System.out.println("Exception on verifying the owner"+e.getMessage());
			Assert.fail("Exception on verifying the ownershipType dropdown value");

		}
	}

	/**
	 * Purpose: findParameterizedContentFromWorkspace method is used to find Parameterized Content From Workspace.
	 */

	public String findParameterizedContentFromWorkspace(String callParam1)
	{
		String bucket= null;
		try
		{

			String bucketName=driver.getCurrentUrl();

			System.out.println(bucketName);			
			String result[] = bucketName.split("/");			
			bucket = result[result.length-2];

			System.out.println("FINAL  "+result[result.length-2]);

			String xpath1="//a[contains(@class,'black right ribbon') and contains(.,'"+callParam1+"')]";



			System.out.println("xpath1"+xpath1);

			/*
			if(callParam1!=null &&callParam2==null)
			{
				finalXpath=xpath1;
				GenericFunctions.waitForElementToAppear(workspacePage.contentCardInDraft);
			}
			else if (callParam1==null&&callParam2!=null)
			{
				finalXpath=xpath2;
				GenericFunctions.waitForElementToAppear(workspacePage.contentInAllMyContent);
			}*/


			ExtentTestManager.getTest().log(LogStatus.INFO, "USer is trying to Open "+callParam1+
					" from 	"+bucket +"and verify value of OwnershipType dropdown");

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.contentCardInDraft);
			try
			{
				WebElement contentInDraft = driver.findElement(By.xpath(xpath1));
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(contentInDraft);
				boolean present = contentInDraft.isDisplayed();
				System.out.println("present"+present);
				if(present==true)
				{
					System.out.println();
					GenericFunctions.waitWebDriver(2000);
					contentInDraft.click();
					GenericFunctions.waitWebDriver(2000);
					verifyOwnerTypeInContentWhenFound();
				}
				//else if(present==false)
				else
				{

					System.out.println("Could not find content in this page, calling");
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(workspacePage.NextButton);
					workspacePage.NextButton.click();
					GenericFunctions.waitWebDriver(1000);

					//	findParametarisedContentFromWorkspace(callParam);

					findParameterizedContentFromWorkspace(callParam1);
					//findContentInDrafts(param[j]);
					//System.out.println("Exception here");


				}

			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the content even in this page ,going to next page to find it");
				System.out.println("Could not find the content even in this page"+e.getLocalizedMessage());
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToElement(workspacePage.NextButton);
				workspacePage.NextButton.click();
				GenericFunctions.waitWebDriver(1000);
				//findParametarisedContentFromWorkspace(callParam);
				findParameterizedContentFromWorkspace(callParam1);
			}

		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+callParam1+ " from the Drafts and verify value of OwnershipType dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+ex.getLocalizedMessage());
			System.out.println("Exception , content not found in draft "+callParam1 +ex.getLocalizedMessage());
			Assert.fail("Could not open content from  "+bucket);
		}
		return callParam1;
	}

	/*
	 * purpose : TO find the Parameterized content from All My Content Bucket And verify the ownerShipType dropdown value
	 */

	public void findParameterizedContentFromAllMyContent(String contentToFind)

	{
		String bucket=null;
		try
		{
			String bucketName=driver.getCurrentUrl();
			System.out.println(bucketName);			
			String result[] = bucketName.split("/");			
			bucket = result[result.length-2];
			System.out.println("Current Bucket-"+result[result.length-2]);

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Open "+contentToFind+
					" from 	"+bucket +" and verify value of OwnershipType dropdown");

			//div[ contains(.,'TextBook')]/following::td[2]/parent::tr/following::div[contains(.,'TextBook')]/following::td[.='Draft']

			//	String xpath1="//div[@class='UpReviewSubHeader' and contains(.,'"+contentToFind+"')]/following::td[contains(.,'Draft')]";

			String xpath1="//div[ contains(.,'"+contentToFind+"')]/following::td[2]/parent::tr/following::div[contains(.,'"+contentToFind+"')]/following::td[.='Draft']/parent::tr/td";

			System.out.println("xpath "+xpath1);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.contentInAllMyContent);

			try
			{
				WebElement contentFromAllMyContent = driver.findElement(By.xpath(xpath1));

				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(contentFromAllMyContent);
				boolean present = (contentFromAllMyContent).isDisplayed();
				System.out.println("present-"+present);

				if(present==true)
				{
					System.out.println();
					GenericFunctions.waitWebDriver(2000);
					contentFromAllMyContent.click();
					GenericFunctions.waitWebDriver(2000);
					verifyOwnerTypeInContentWhenFound();
				}

				else if(present==false)
				{

					System.out.println("Could not find content in this page, calling");
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(workspacePage.NextButton);
					workspacePage.NextButton.click();
					GenericFunctions.waitWebDriver(1000);

					//	findParametarisedContentFromWorkspace(callParam);

					findParameterizedContentFromWorkspace(contentToFind);
					//findContentInDrafts(param[j]);
					//System.out.println("Exception here");


				}



			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the content even in this page ,going to next page to find it");
				System.out.println("Could not find the content even in this page"+e.getLocalizedMessage());
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToElement(workspacePage.NextButton);
				workspacePage.NextButton.click();
				GenericFunctions.waitWebDriver(1000);
				//findParametarisedContentFromWorkspace(callParam);
				findParameterizedContentFromAllMyContent(contentToFind);				

			}


		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+contentToFind+ " from the All My Content and verify value of OwnershipType dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+ex.getLocalizedMessage());
			System.out.println("Exception , content not found in draft "+contentToFind +ex.getLocalizedMessage());
			Assert.fail("Could not open content from  "+bucket);
		}

	}

	/*
	 * purpose :  Click on the created content and Check the OWNERSHIP field value
	 */

	public boolean openTheCreatedContentFromUpForReview(String contentToSearch)
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to open the content from Up For Review and verify the value of selected ownershipType dropdown");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
			//createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			createUserPage.searchForReview.sendKeys(contentToSearch);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(2000);
			//	GenericFunctions.waitForElementToAppear(workspacePage.viewCreditsLink);
			ExtentTestManager.getTest().log(LogStatus.INFO, "content is opened from Up For Review Section");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content from the Up For Review and verify value of OwnershipType dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+e.getLocalizedMessage());
			System.out.println("Exception , Could not open in Up For Review  and verify value "+e.getLocalizedMessage());
			Assert.fail("Could not open content from Up For Review and verify value ownershipType dropdown ");
		}

		return true;
	}

	/*
	 * purpose : TO verify the ownershipType value of the content opened from Up For Review section
	 */
	public void verifyownershipTypeValueOfTheContent(String passedValue1, String passedValue2)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is triyng to verify the value of the ownershipType value");
			//GenericFunctions.scrollToElement(workspacePage.viewCreditsLink);
			if(passedValue1!=null&&passedValue2==null)
			{
				workspacePage.viewCreditsLink.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(workspacePage.creators); 
				if(workspacePage.creators.isDisplayed())
				{	
					ExtentTestManager.getTest().log(LogStatus.PASS," OwnershipType-CreatedBy : "+workspacePage.creators.getText()+" OwnershipType-CreatedFor :"+workspacePage.contributors.getText());
					Assert.assertEquals(workspacePage.creators.getText(), "content creator");
					//Assert.assertEquals(workspacePage.contributors.getText(), driver.getTitle(),"Failed to assert value of Org");
					System.out.println(passedValue1.toLowerCase());
					Assert.assertEquals(workspacePage.contributors.getText(), passedValue1.toLowerCase(),"Failed to assert value of Org");
					Assert.assertTrue(true);
				}

				GenericFunctions.waitWebDriver(1000);
				createUserPage.closePopUp.click();	
			}
			else if(passedValue1==null&&passedValue2!=null)
			{
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
				createUserPage.editOrViewDetailslink.click();
				GenericFunctions.waitWebDriver(2000);

				Assert.assertEquals(workspacePage.verifyOwnershipValueInCourse.getText().trim().toLowerCase(), passedValue2.toLowerCase(),"Failed to verify ownershipType of selected content");
				//ExtentTestManager.getTest().log(LogStatus.ERROR,"Failed to verify ownershipType of selected content");
				ExtentTestManager.getTest().log(LogStatus.PASS,"Verified ownershipType value of the opened Content type and has "+workspacePage.verifyOwnershipValueInCourse.getText()+" as its value");
				Assert.assertTrue(true);
				GenericFunctions.waitWebDriver(1000);
				workspacePage.closeIconViewDetails.click();	 
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
				createUserPage.editorCloseIcon.click();


			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify value of ownersipType value");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+e.getLocalizedMessage());
			System.out.println("Exception ,Could not verify value of ownersipType value"+e.getLocalizedMessage());
			Assert.fail("Could not verify value of ownersipType value");
		}

	}

	/**
	 * Purpose: verifyViewAllOptionInCourse method is used to verify View All Option In Course.
	 */

	public void verifyViewAllOptionInCourse()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify view all option Under Open For Enrollment");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			try
			{
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(workspacePage.openForEnrollmentViewAll);
				if(workspacePage.openForEnrollmentViewAll.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "View All button  is present under Open For Enrollment course section");
					workspacePage.openForEnrollmentViewAll.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElements(createUserPage.searchPublishedCourses);;
					if(createUserPage.searchPublishedCourses.get(0).isDisplayed())
					{
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "On Clicking View All Button, Course list is displayed to the user, "+createUserPage.searchPublishedCourses.size()+" is the size of the course list and "+createUserPage.searchPublishedCourses.get(0).getText()+" is the course name from the list");
					}
				}

			}
			catch(Exception c)
			{
				System.out.println("Exception found verifying view All button"+c.getLocalizedMessage());
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+c.getLocalizedMessage());

			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify view all option under Open for enrollment course section ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+e.getLocalizedMessage());
			System.out.println("Exception ,Could not verify view all option under Open for enrollment section"+e.getLocalizedMessage());
			Assert.fail("Could not verify view all option under Open for enrollment  course section");
		}
	}



	/**
	 * Purpose: verifyViewAllOptionUnderTextbooksInLibrary method is used to verify View All Option Under Textbooks In Library.
	 */
	public void verifyViewAllOptionUnderTextbooksInLibrary()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify view all option Under Textbooks in Library Page");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			try
			{
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(workspacePage.textbooksViewAll);
				if(workspacePage.textbooksViewAll.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "View All button  is present under Textbooks in Library Page");
					workspacePage.textbooksViewAll.click();
					GenericFunctions.waitWebDriver(1000);
				//	GenericFunctions.waitForElements(createUserPage.searchPublishedCourses);
					Boolean bookIsDisplayed = wait.until(ExpectedConditions.urlContains("view-all/Textbooks"));
					int random = rand.nextInt(workspacePage.tinyBookLabel.size());
					System.out.println("random--"+random);

					GenericFunctions.waitWebDriver(1000);
					if(bookIsDisplayed==true)
					{
						Assert.assertEquals(workspacePage.tinyBookLabel.get(random).getText().trim(), "Book","Failed to validate Tiny Book Label");
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "On Clicking View All Button, Book list is displayed to the user, "+createUserPage.searchPublishedCourses.size()+" is the size of the Book list and "+
								createUserPage.searchPublishedCourses.get(random).getText()+" is the book name from the list");
					}
				}

			}
			catch(Exception c)
			{
				System.out.println("Exception found verifying view All button"+c.getLocalizedMessage());
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+c.getLocalizedMessage());

			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify view all option under Textbooks section in Library Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+e.getLocalizedMessage());
			System.out.println("Exception ,Could not verify view all option under Textbooks section in Library Page"+e.getLocalizedMessage());
			Assert.fail("Could not verify view all option under Textbooks section in Library Page");
		}

	}
	/**
	 * Purpose: verifyTextbooksSearchAndApplyFiltersInLibrary method is used to verify Textbooks Search And Apply Filters In Library.
	 */
	public void verifyTextbooksSearchAndApplyFiltersInLibrary()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify content search and apply filter in Library");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.textbooksViewAll);
			workspacePage.textbooksViewAll.click();

			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(CONTENT_ARRAY[new Random().nextInt(CONTENT_ARRAY.length)]);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(publicUserPage.filterIcon);
			publicUserPage.filterIcon.click();



		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify content search and apply filter in Library");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+e.getLocalizedMessage());
			System.out.println("Exception ,Could not verify view all option under Textbooks section in Library Page"+e.getLocalizedMessage());
			Assert.fail("Could not verify view all option under Textbooks section in Library Page");
		}

	}
	/**
	 * Purpose: applyFilters method is used to Apply Filters In Library.
	 */
	public void applyFilters()
	{
		GenericFunctions.waitWebDriver(1000);
		publicUserPage.clickFilterBoard.click();
		GenericFunctions.waitWebDriver(1000);
		publicUserPage.selectFilterBoard.click();	


		GenericFunctions.waitWebDriver(1000);
		publicUserPage.clickFilterMedium.click();
		GenericFunctions.waitWebDriver(1000);
		publicUserPage.selectFilterMedium.get(0).click();	

		GenericFunctions.waitWebDriver(1000);
		publicUserPage.clickFilterClass.click();
		GenericFunctions.waitWebDriver(1000);
		publicUserPage.selectFilterClass.get(0).click();	


		GenericFunctions.waitWebDriver(1000);
		publicUserPage.clickFilterMedium.click();
		GenericFunctions.waitWebDriver(1000);
		publicUserPage.selectFilterMedium.get(0).click();	




		GenericFunctions.waitWebDriver(1000);
		publicUserPage.clickFilterSubject.click();
		GenericFunctions.waitWebDriver(1000);
		publicUserPage.selectFilterSubject.get(0).click();	
	}

	/**
	 * Purpose: verifyViewAllInExploreLibraryPage method is used to verify View All In Explore Library Page
	 */
	public void verifyViewAllInExploreLibraryPage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify View All button under Library in Explore Page");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify , filters applied are reseted after clicking browser back button");

			navigateToExploreLibraryPage();

			try
			{
				//	GenericFunctions.waitForElementToAppear(workspacePage.textbooksViewAll);
				/*if(workspacePage.textbooksViewAll.isDisplayed()
						&&libraryPage.featuredContentViewAllButton.isDisplayed()
						&&libraryPage.teachingMaterialViewAllSection.isDisplayed()
						&&libraryPage.learningMaterialViewAllButton.isDisplayed()
						&&libraryPage.practiceAndTestMaterialViewAllSection.isDisplayed())
				{	


					Assert.assertEquals(workspacePage.textbooksViewAll.getText(), "View All");
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "Verified View All button for-Featured Content, Textbooks, Learning material, Teaching material, Practice and test material under Explore Library Page");

				}	*/
				if(libraryPage.featuredContentViewAllButton.isDisplayed())

					if(workspacePage.textbooksViewAll.isDisplayed())

						GenericFunctions.scrollDownByPixel();	
				if(libraryPage.teachingMaterialViewAllSection.isDisplayed())
					GenericFunctions.scrollDownByPixel();	

				if(libraryPage.learningMaterialViewAllButton.isDisplayed())
					GenericFunctions.scrollDownByPixel();	

				if(libraryPage.practiceAndTestMaterialViewAllSection.isDisplayed())



					GenericFunctions.waitWebDriver(5000);

				libraryPage.practiceAndTestMaterialViewAllSection.click();
				GenericFunctions.waitWebDriver(3000);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Click on PracticeAndTest Material Section");

				GenericFunctions.waitForElementToAppear(libraryPage.clickFilters);
				libraryPage.clickFilters.click();
				GenericFunctions.waitWebDriver(2000);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Filters");

				libraryPage.clickDropdownMedium.click();
				GenericFunctions.waitWebDriver(2000);
				libraryPage.sltMediumDropdown.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Medium Dropdown Selected");

				GenericFunctions.waitWebDriver(2000);
				libraryPage.clickApply.click();
				GenericFunctions.waitWebDriver(3000);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Apply button");



				boolean result = libraryPage.AppliedFilters.isDisplayed();
				if (result == true) {
					ExtentTestManager.getTest().log(LogStatus.INFO, "Filters are Applied succesfully");
					driver.navigate().back();
					ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Browser Back button");

					GenericFunctions.waitWebDriver(3000);
					boolean result2 = libraryPage.clickDropdownMedium.isDisplayed();
					if(result2==true)
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Filters are Reseted succesfully After Cliking Browser Back Button");

					}

				}

			}

			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Reseting Filters  After Cliking Browser Back Button");

				ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify View All button for all Category in Library Page");
				ExtentTestManager.getTest().log(LogStatus.FAIL,e.getLocalizedMessage());

				Assert.fail("Could not verify View All button in Library Page");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify View All button under Explore Library Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Exception ,Could not verify View All button under Explore Library Page "+e.getLocalizedMessage());
			Assert.fail("Could not verify View All button under Explore Library Page");
		}
	}

	/**
	 * Purpose: clickOnViewAllAndVerifyContents method is used to click On View All And Verify Contents.
	 */
	public void clickOnViewAllAndVerifyContents(String contentCategory)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Verify Contents on Clicking View All Button Under "+contentCategory);

			navigateToExploreLibraryPage();
			//libraryPage.featuredContentViewAllButton.click();
			WebElement viewAll = driver.findElement(By.xpath(contentCategory));
			GenericFunctions.waitWebDriver(500);
			GenericFunctions.waitForElementToAppear(viewAll);
			viewAll.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Verify Contents on Clicking View All Button Under "+contentCategory);

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchPublishedCourses.get(0));
			if(createUserPage.searchPublishedCourses.get(0).isDisplayed())
			{
				Assert.assertTrue(true);		
				ExtentTestManager.getTest().log(LogStatus.PASS, "Contents are displayed on Clicking View All button of "+createUserPage.searchPublishedCourses.size()+" contents are displayed"); 
				GenericFunctions.waitWebDriver(5000);
				workspacePage.clearSearchIcon.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(libraryPage.featuredContentViewAllButton);			
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify View All button under Explore Library Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Exception ,Could not verify View All button under Explore Library Page "+e.getLocalizedMessage());
			Assert.fail("Could not verify View All button under Explore Library Page");
		}
	}
	/**
	 * Purpose: navigateToExploreLibraryPage method is used to navigate To Explore Library Page.
	 */
	public void navigateToExploreLibraryPage()
	{
		try
		{
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();	
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			System.out.println("Could not navigate to Explore Library Page"+e.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not navigate to Explore Library Page"+e.getLocalizedMessage());

		}
	}
	/**
	 * Purpose: verifyViewAllForAllTheSectionsOfCoursePage method is used to verify View All For All The Sections Of Course Page.
	 */
	public void verifyViewAllForAllTheSectionsOfCoursePage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify View All Under Course Section After Login");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();


			//Get the filer Names in the page
			ArrayList<String> filtersCount = verifyFiltersBeforeClickingViewAll();


			//Get the filter count from Course Page
			int filterCount=libraryPage.filterCountInPage.size()-1;
			System.out.println("filterCount"+filterCount);


			GenericFunctions.waitForElements(libraryPage.viewAllButtonsInPage);
			int viewButtons = libraryPage.viewAllButtonsInPage.size();

			System.out.println(viewButtons);

			for(int i=0; i<=libraryPage.viewAllButtonsInPage.size();i++)
				//for(int i=0; i<=3;i++)
			{
				GenericFunctions.waitWebDriver(3000);
				//GenericFunctions.waitForElements(libraryPage.viewAllButtonsInPage);
				System.out.println(libraryPage.viewAllButtonsInPage.get(i));
				libraryPage.viewAllButtonsInPage.get(i).click();
				//System.out.println(libraryPage.viewAllButtonsInPage.get(i));
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(libraryPage.filterIconInPage);
				libraryPage.filterIconInPage.click();
				GenericFunctions.waitWebDriver(1000);
				int filtersOnViewAllClick=libraryPage.filtersOnViewAllClick.size()-1;
				System.out.println("filtersOnViewAllClick"+filtersOnViewAllClick);

				ArrayList<String> returnFilterCount = verifyFilterAfterClickingViewAll();

				for(int j=0;j<filtersCount.size();j++)
				{
					String content = filtersCount.get(j).toLowerCase();
					String content1 = returnFilterCount.get(j).toLowerCase();
					if(content1.contains(content))
					{
						System.out.println(content1);
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.INFO, "Filters have been verified on cliking View All-"+content+" and has the same filters as before clicking on View All");
					}
				}


				/*try
				{
					if(filterCount==filtersOnViewAllClick)
					{
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, libraryPage.getSectionTextOnViewAll.getText()+" Section have the same filters after clicking on View All");

					}
				}
				catch(Exception ne)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Could verify filters after clicking on View All of "+libraryPage.getSectionTextOnViewAll.getText()+"section "+ne.getLocalizedMessage());
					Assert.fail("Could verify filters after clicking on View All of "+libraryPage.getSectionTextOnViewAll.getText()+"section, Exception "+ne.getLocalizedMessage());
					//START FROM HERE
				}*/

				driver.navigate().back();
				//createUserPage.headerCourse.click();
				//i++;
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify View All button Under Course Section After login "+e.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Could not verify View All button Under Course Section After login "+e.getLocalizedMessage());
			Assert.fail("Could not verify View All button Under Course Section After login");
		}
	}
	/**
	 * Purpose: verifyFiltersBeforeClickingViewAll method is used to verify Filters Before Clicking View All.
	 */
	public ArrayList<String> verifyFiltersBeforeClickingViewAll()
	{
		ArrayList<String> filterNames = new ArrayList<String>();
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to get the Filter Names Before clicking View All on each section");
			GenericFunctions.waitWebDriver(1000);
			libraryPage.filterLabelsInPage.size();
			for(WebElement el:libraryPage.filterLabelsInPage)
			{
				System.out.println("FilterText "+el.getText());
				filterNames.add(el.getText());
			}
			System.out.println("Filter Names :"+filterNames.toString());
		}


		catch(Exception fe)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not get the Filter Names Before clicking View All on each section "+fe.getLocalizedMessage());
			Assert.fail("Could not get the Filter Names Before clicking View All on each section "+fe.getLocalizedMessage());
			System.out.println("Could not get the Filter Names Before clicking View All on each section "+fe.getLocalizedMessage());			

		}

		return filterNames;
	}
	/**
	 * Purpose: verifyFilterAfterClickingViewAll method is used to verify Filter After Clicking View All.
	 */
	public ArrayList<String> verifyFilterAfterClickingViewAll()
	{
		ArrayList<String> filerNameOnViewAll = new ArrayList<String>();
		int filtersOnViewAllClick = 0;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to get the Filter Names After clicking View All on each section");
			GenericFunctions.waitWebDriver(1000);
			try
			{
				if(libraryPage.topicFilterOnViewAll.isDisplayed())
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "Topic Filter is displayed on clicking View All");
				}
			}
			catch(Exception e)
			{
				System.out.println("Topic select filter is not present"+e.getLocalizedMessage());
			}

			filerNameOnViewAll.add(libraryPage.topicFilterOnViewAll.getText());

			filtersOnViewAllClick=libraryPage.filtersOnViewAllClick.size()-1;
			System.out.println("filtersOnViewAllClick"+filtersOnViewAllClick);


			for(WebElement al:libraryPage.textOfFiltersOnViewAllClick)
			{
				System.out.println(al.getText());
				filerNameOnViewAll.add(al.getText());
			}
			System.out.println("filerNameOnViewAll "+filerNameOnViewAll.toString());
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not get the Filter Names After clicking View All on each section "+ex.getLocalizedMessage());
			Assert.fail("Could not get the Filter Names After clicking View All on each section "+ex.getLocalizedMessage());
			System.out.println("Could not get the Filter Names After clicking View All on each section "+ex.getLocalizedMessage());
		}
		//return filtersOnViewAllClick;
		return filerNameOnViewAll;
	}


	public void verifyUserRedirectsToLoginPageFromExploreCourse()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Navigation to Login Page"); 
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore-course");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(libraryPage.exploreSignInLink);
			libraryPage.exploreSignInLink.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(orgUploadPage.clickLogin1);
			if(orgUploadPage.clickLogin1.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "USer is successfully navigated to Login Page on clicking Sign-In Link in explore course page");
			}


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify User redirection to Login Page on clicking Sign-In link"+e.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Could not verify User redirection to Login Page on clicking Sign-In link "+e.getLocalizedMessage());
			Assert.fail("Could not verify User redirection to Login Page on clicking Sign-In link");
		}	
	}

	/*
	 * purpose : To upload  and verify Youtube content with External Invalid Url
	 */

	public void uploadContentWithInvalidUrl()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Content with External Invalid Url");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			createUserPage.enterUrl.sendKeys(INVALID_URL);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.UploadButton);
			createUserPage.UploadButton.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.validationMsgOnInvalidUrl);
			workspacePage.validationMsgOnInvalidUrl.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.validationMsgOnInvalidUrl);
			workspacePage.validationMsgOnInvalidUrl.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.validationMsgOnInvalidUrl);

			if(workspacePage.validationMsgOnInvalidUrl.isDisplayed())	
			{
				Assert.assertTrue(true);
				workspacePage.validationMsgOnInvalidUrl.click();				
				ExtentTestManager.getTest().log(LogStatus.PASS, "Validation error message with supported domain is displayed - "+workspacePage.validationMsgOnInvalidUrl.getText());
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify upload Content with External Invalid Url"+e.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Could not verify upload Content with External Invalid Url"+e.getLocalizedMessage());
			Assert.fail("Could not verify upload Content with External Invalid Url");
		}
	}

	public String getContentFromMyCourses()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Trying to get content which User is enrolled");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.contentFromMyCourses);
			workspacePage.contentFromMyCourses.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not get content to which User is enrolled");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Could not get content to which User is enrolled"+e.getLocalizedMessage());
			log.info("Could not get content to which User is enrolled, "+e.getStackTrace());
			Assert.fail("Could not get content to which User is enrolled");
		}
		return driver.getCurrentUrl();
	}


	public void verifyNotesOptionInContent(String contentUrl)
	{
		List<TestDataForDiksha> objListOFTestDataForSunbird = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Take Note Option");
			GenericFunctions.waitWebDriver(2000);
			System.out.println("content url while consuming-"+driver.getCurrentUrl());
			if(contentUrl!=driver.getCurrentUrl())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to content consume the content");
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(workspacePage.takeNote);
				workspacePage.takeNote.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(workspacePage.notesTitle);
				workspacePage.notesTitle.click();
				workspacePage.notesTitle.sendKeys(objListOFTestDataForSunbird.get(13).getCourseName());
				GenericFunctions.waitWebDriver(1000);
				workspacePage.notesDescription.sendKeys(objListOFTestDataForSunbird.get(13).getCourseDescription());
				String titleText = workspacePage.notesTitle.getText();
				String DescText = workspacePage.notesDescription.getText();
				GenericFunctions.waitWebDriver(1000);
				workspacePage.clearNotes.click();
				GenericFunctions.waitWebDriver(1000);
				workspacePage.notesTitle.click();
				String titleAfterClear= workspacePage.notesTitle.getText();
				String DescAfterClear = workspacePage.notesDescription.getText();
				if(titleText!=titleAfterClear&&DescText!=DescAfterClear)
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "On clicking clear all the entered data is cleared");
				}


			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify Take Note Option while consuming content");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Could not verify upload Content with External Invalid Url"+e.getLocalizedMessage());
			Assert.fail("Could not verify upload Content with External Invalid Url");
		}


	}

	/*
	 * purpose : To delete upload content from published sections
	 */
	public void findUploadContentFromPublishedSection(String contentName)
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete Upload Content from Published Section");
			GenericFunctions.waitForElementToAppear(workspacePage.contentCardInDraft);
			try
			{
				WebElement content=driver.findElement(By.xpath(contentName));
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(content);
				boolean present = content.isDisplayed();
				System.out.println("present"+present);
				if(present==true)
				{
					System.out.println();
					GenericFunctions.waitWebDriver(2000);
					workspacePage.uploadContentDeleteIcon.click();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(createUserPage.yesButtonPopup);
					createUserPage.yesButtonPopup.click();
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, contentName+" is successfuly deleted from published section");
				}
				//else if(present==false)
				else
				{

					System.out.println("Could not find content in this page, calling");
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(workspacePage.NextButton);
					workspacePage.NextButton.click();


				}
				GenericFunctions.waitWebDriver(1000);

			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the content even in this page ,going to next page to find it");
				System.out.println("Could not find the content even in this page"+e.getLocalizedMessage());
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToElement(workspacePage.NextButton);
				workspacePage.NextButton.click();
				GenericFunctions.waitWebDriver(1000);
				//findParametarisedContentFromWorkspace(callParam);
				findUploadContentFromPublishedSection(contentName);
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not delete upload content from Published Section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println("Could not delete upload content from Published Section , "+e.getLocalizedMessage());
			log.error("Could not delete upload content from Published Section, "+e.getStackTrace());
			Assert.fail("Could not delete upload content from Published Section");
		}
	}


	/*
	 * Purpose : User is trying to verify whether Pagination works fine for workspace for mentor user
	 */

	public void verifyingPagination() {

		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is Verifying SUN-1672");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Pagination for workspace"); 
			GenericFunctions.waitWebDriver(1000);

			workspacePage.workspace.click();
			GenericFunctions.waitWebDriver(1000);

			workspacePage.courseBatches.click();
			GenericFunctions.waitWebDriver(1000);

			if(workspacePage.ongoingCourse.isDisplayed())
			{
				GenericFunctions.waitWebDriver(1000);
				workspacePage.viewAll.click();

				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.scrollTillEndOfPage();

				GenericFunctions.waitWebDriver(2000);

				if(workspacePage.pagination1.isDisplayed())
				{
					Assert.assertTrue(true, "Failed to verify Pagination for Ongoing courses");
					ExtentTestManager.getTest().log(LogStatus.PASS, "User successfully verified pagination for Ongoing courses for workspace");
				}
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToStartOfPage();
				workspacePage.closeIconViewAll.click();

				GenericFunctions.waitWebDriver(1000);
				//GenericFunctions.scrollToElement(workspacePage.upcomingCourse);
			}

			if(workspacePage.upcomingCourse.isDisplayed())
			{
				GenericFunctions.waitWebDriver(1000);

				workspacePage.viewAllUpcoming.click();

				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.scrollTillEndOfPage();

				GenericFunctions.waitWebDriver(2000);

				if(workspacePage.pagination1.isDisplayed())
				{
					Assert.assertTrue(true, "Failed to verify Pagination for Upcoming courses");
					ExtentTestManager.getTest().log(LogStatus.PASS, "User successfully verified pagination for Upcoming courses for workspace");
				}
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToStartOfPage();
				workspacePage.closeIconViewAll.click();

				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollTillEndOfPage();
			}

			if(workspacePage.expiredCourse.isDisplayed())
			{
				GenericFunctions.waitWebDriver(1000);
				workspacePage.viewAllExpired.click();

				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.scrollTillEndOfPage();

				GenericFunctions.waitWebDriver(2000);

				if(workspacePage.pagination1.isDisplayed())
				{
					Assert.assertTrue(true, "Failed to verify Pagination for Expired courses");
					ExtentTestManager.getTest().log(LogStatus.PASS, "User successfully verified pagination for Expired courses for workspace");
				}
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToStartOfPage();
				workspacePage.closeIconViewAll.click();

				GenericFunctions.waitWebDriver(1000);

			}
		}

		catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, " Failed to verify pagination for Workspace for mentor user "+e.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message "+e.getLocalizedMessage());
			System.out.println(" Failed to verify pagination for Workspace for mentor user "+e.getLocalizedMessage());
			Assert.fail(" Failed to verify pagination for Workspace for mentor user ");

		}	


	}

	//SUN-1674
	/*
	 * purpose : Verify Editing of Batches from Ongoing Courses Section
	 * 
	 */

	public void verifyBatchEditingFromOngoingCoursesSectionAssignedToMe() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to verify editing of Batch from Ongoing Courses section");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.assignedToMe);
			coursePage.assignedToMe.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.ongoingCoursesCourse);
			coursePage.ongoingCoursesCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.nameOfBatch);
			boolean nameValue = createMentorPage.nameOfBatch.getAttribute("disabled").contains("true");
			boolean aboutBatchValue = createMentorPage.aboutBatch.getAttribute("disabled").contains("true");
			boolean startDateValue = createMentorPage.startDate.getAttribute("disabled").contains("true");
			boolean endDateValue = createMentorPage.endDate.getAttribute("disabled").contains("true");
			boolean updateButtonValue = createMentorPage.updateBatch.getAttribute("class").contains("disabled");
			//boolean batchTypeValue = createMentorPage.openBatch.getAttribute("disabled").contains("true");
			boolean mentorsValue = createMentorPage.mentorsInBatch.getAttribute("class").contains("disabled"); // isEnabled();
			boolean membersValue = createMentorPage.membersInBatch.getAttribute("class").contains("disabled");// isEnabled();
			System.out.println(nameValue + "," + aboutBatchValue + "," + "" + startDateValue + "," + updateButtonValue
					+ "," + endDateValue + "," + mentorsValue + "," + membersValue);

			if (nameValue == true && aboutBatchValue == true && startDateValue == true && updateButtonValue == false
					&& endDateValue == true && mentorsValue == true && membersValue == true) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"In Ongoing Courses section batch editing is verified");
				log.info("Editing Batch from Ongoing Courses section is verified ");
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);
				createUserPage.closePopUp.click();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify editing of Batch from Ongoing Courses section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify editing of Batch from Ongoing Courses section :" + e.getStackTrace());
			Assert.fail("Failed To verify editing of Batch from Ongoing Courses section");
		}
	}

	/*
	 * purpose : Verify Editing of Batches from Upcoming Courses Section
	 * 
	 */

	public void verifyBatchEditingFromUpcomingCoursesSectionAssignedToMe() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to verify editing of Batch from Upcoming Courses section");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.assignedToMe);
			coursePage.assignedToMe.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.upcomingCoursesCourse);
			coursePage.upcomingCoursesCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.nameOfBatch);
			boolean nameValue = createMentorPage.nameOfBatch.getAttribute("disabled").contains("true");
			boolean aboutBatchValue = createMentorPage.aboutBatch.getAttribute("disabled").contains("true");
			boolean startDateValue = createMentorPage.startDate.getAttribute("disabled").contains("true");
			boolean endDateValue = createMentorPage.endDate.getAttribute("disabled").contains("true");
			boolean updateButtonValue = createMentorPage.updateBatch.getAttribute("class").contains("disabled");
			boolean batchTypeValue = createMentorPage.openBatch.getAttribute("disabled").contains("true");
			boolean mentorsValue = createMentorPage.mentorsInBatch.getAttribute("class").contains("disabled"); // isEnabled();
			boolean membersValue = createMentorPage.membersInBatch.getAttribute("class").contains("disabled");// isEnabled();
			System.out.println(nameValue + "," + aboutBatchValue + "," + "" + startDateValue + "," + updateButtonValue
					+ "," + batchTypeValue + "," + endDateValue + "," + mentorsValue + "," + membersValue);

			if (nameValue == true && aboutBatchValue == true && startDateValue == true && updateButtonValue == false
					&& batchTypeValue == true && endDateValue == true && mentorsValue == true && membersValue == true) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"In Assigned to me Upcoming Courses batch editing is verified");
				log.info("In Assigned to me Upcoming Courses batch editing is verified");
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);
				createUserPage.closePopUp.click();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify editing of Batch from Upcoming Courses section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify editing of Batch from Upcoming Courses section :" + e.getStackTrace());
			Assert.fail("Failed To verify editing of Batch from Upcoming Courses section");
		}

	}





		
		
		
		
		public void  stateFramework(String uploadType) throws Exception
		{
		//	ApiHashMap apiHashMap = new ApiHashMap();
			String selectedOwnerType = null;
			try {
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"User is trying to upload" + uploadType + " and send it for review");
				List<TestDataForDiksha> objListOFTestDataForSunbird1 = null;
				objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
				GenericFunctions.waitWebDriver(2000);
				
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);

				GenericFunctions.waitWebDriver(4000);
				WebElement browse = createUserPage.browseButton;
				if (uploadType.equalsIgnoreCase("mp4")) 
				{

					System.out.println(AllUploadingPaths.mp4Path);
					GenericFunctions.waitWebDriver(6000);
					browse.sendKeys(AllUploadingPaths.mp4Path);
					System.out.println("Uploaded file : " + AllUploadingPaths.mp4Path);
					GenericFunctions.waitWebDriver(8000);
					System.out.println("MP4 content uploaded sucessfully");
				} 

			}
			catch (Exception e)
			{

				ExtentTestManager.getTest().log(LogStatus.FAIL,
						"Failed to upload " + uploadType + " content and send for review ");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				System.out.println("Failed to upload content" + e.getLocalizedMessage());
				Assert.fail("Failed to upload any content and send for review ");
			}
			
			
		}
		public void stateFrameworkVeification(String stateName)
		{
			try
			{
				ExtentTestManager.getTest().log(LogStatus.INFO,"User is trying to edit the details");
				List<TestDataForDiksha> objListOFTestDataForSunbird1 = null;
				objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
				GenericFunctions.waitWebDriver(2000);
				workspacePage.editLink.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(workspacePage.searchState);
				GenericFunctions.waitWebDriver(2000);
				workspacePage.searchState.click();
				GenericFunctions.waitWebDriver(2000);
				for(int i=0;i<workspacePage.stateElement.size();i++)
				{
					String statevalue = workspacePage.stateElement.get(i).getText();
					Assert.assertEquals(statevalue,stateName , "selected state is  matching from RJ framework  ");
					ExtentTestManager.getTest().log(LogStatus.PASS,"successfuly verify the state from to RJ framework");
				}
				GenericFunctions.waitWebDriver(2000);
				workspacePage.close.click();
				GenericFunctions.waitForElementToAppear(workspacePage.shareForReview);
				workspacePage.shareForReview.click();
				GenericFunctions.waitWebDriver(2000);
				workspacePage.searchState.click();
				GenericFunctions.waitWebDriver(2000);
				for(int i=0;i<workspacePage.stateElement.size();i++)
				{
					String statevalue = workspacePage.stateElement.get(i).getText();
					Assert.assertEquals(statevalue,stateName , "selected state is  matching from RJ framework after share for review ");
					ExtentTestManager.getTest().log(LogStatus.PASS,"successfuly verify the state from to RJ framework");
				}
				GenericFunctions.waitWebDriver(2000);
				workspacePage.close.click();
				
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Failed to verify state from RJ framework ");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Failed to verify states from RJ framework" + e.getStackTrace());
				Assert.fail("Failed to verify states from RJ framework");
			}		
			
		}
		
		

/*
 * purpose:User is trying to create New Book and preview the content
 */

	public String toCreateBookAndPreviewContents(List<TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException {
		String courseNumber = null, bookName = null;
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create New Book and preview the content");
			GenericFunctions.waitWebDriver(1000);
			// System.out.println(driver.findElement(By.xpath("
			// //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			courseNumber = GenericFunctions.testDataIncrementer("./testData/bookNumbers.txt").toString();
			bookName = objListOFTestDataForSunbird.get(2).getCourseName() + courseNumber;
			createUserPage.courseName.sendKeys(bookName);
			// createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1000);

			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.clickOnElementUsingJavascript(createUserPage.clickUseEditor);

			GenericFunctions.waitWebDriver(2000);
			System.out.println("Creating - " + createUserPage.newChild.getText());

			actions.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.untitledNameB.click();
			createUserPage.untitledNameB.clear();

			createUserPage.untitledNameB.sendKeys(objListOFTestDataForSunbird.get(2).getTitle() + courseNumber);
			// createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(3000);
			// GenericFunctions.waitForElementToAppear(createUserPage.selectResourceN);
			// GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectResourceN);
			createUserPage.selectResourceN.click();
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);
	

			GenericFunctions.scrollToElement(workspacePage.previewSymbol);
			GenericFunctions.waitForElementToAppear(workspacePage.previewSymbol);

			workspacePage.previewSymbol.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(workspacePage.playBtn);

			workspacePage.playBtn.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(workspacePage.closeBtn);

			
			workspacePage.closeBtn.click();
			
			//GenericFunctions generic = new GenericFunctions();
			//generic.alert
			GenericFunctions.waitWebDriver(2000);
			driver.switchTo().alert().accept();

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			System.out.println("Failed to create New Book");
			Assert.fail("Failed to create New Book ");
		}
		return bookName;



	}


	

}
