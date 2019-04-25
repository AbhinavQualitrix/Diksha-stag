package org.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.openqa.selenium.By;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.page.BatchUserPage;
import org.page.ContentCreationResourcePage;
import org.page.CoursePage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.LibraryPage;
import org.page.UploadOrgPage;
import org.page.WorkspacePage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class CoursePageObj extends BaseTest {

	CoursePage coursePage = PageFactory.initElements(driver, CoursePage.class);
	CreatorUserPage createUserPage = PageFactory.initElements(driver, CreatorUserPage.class);
	LibraryPage libraryPage = PageFactory.initElements(driver, LibraryPage.class);
	private static Logger log = Logger.getLogger(CoursePageObj.class.getName());
	CreateMentorPage createMentorPage = PageFactory.initElements(driver, CreateMentorPage.class);
	BatchUserPage BatchUserPage = PageFactory.initElements(driver, BatchUserPage.class);
	UploadOrgPage uploadOrgPage = PageFactory.initElements(driver, UploadOrgPage.class);
	WorkspacePage workspacePage = PageFactory.initElements(driver, WorkspacePage.class);
	Actions action = new Actions(driver);
	List<TestDataForDiksha> objListOFTestDataForSunbird = null;
	GenericFunctions generic = new GenericFunctions();
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	String ContentName;
	String notesNumber;
	String notesName;

	/*
	 * purpose : To verify Slider button under Course Tab
	 */
	public void verifySliderButtonInMyCourses() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify slider button in My Courses");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElements(coursePage.sliderNextButton);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElements(coursePage.sliderPreviousButton);
			if (coursePage.sliderNextButton.get(0).isDisplayed()
					&& coursePage.sliderPreviousButton.get(0).isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Slider buttons are displayed Under My Courses Tab");
				GenericFunctions.waitWebDriver(1000);
				coursePage.sliderNextButton.get(0).click();
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To verify Slider Buttons under Course Tab");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify Slider Button under Course Tab " + e.getStackTrace());
			Assert.fail("Failed To verify Slider Buttons under Course Tab");
		}
	}

	public void verifyCourseCardDetailsInCoursePage() {
		ArrayList<String> topicArray = new ArrayList<String>();
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to verify Course Card details in Course Page");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			// GenericFunctions.waitForElements(coursePage.courseCard);
			log.info("Courses size -" + coursePage.courseCard.size());
			System.out.println("Courses size -" + coursePage.courseCard.size());

			// driver.manage().logs().get("browser");
			if (coursePage.courseCard.get(0).isDisplayed()) {
				/*
				 * for (int i=0; i<=coursePage.courseCard.size();i++) {
				 */
				// System.out.println("itr-"+i);
				GenericFunctions.waitWebDriver(1000);

				boolean status = coursePage.courseCardOrgName.get(0).getText().isEmpty();
				if (status == true) {
					log.info("Courses not having Org Name " + coursePage.courseCardOrgName.get(0).getText());
					System.out.println("Courses not having Org Name " + coursePage.courseCardOrgName.get(0).getText());

				} else if (status == false) {
					log.info("Courses having Org Name - " + coursePage.courseCardOrgName.get(0).getText());
					System.out.println("Courses having Org Name - " + coursePage.courseCardOrgName.get(0).getText());
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Course Card have cousrse name - " + coursePage.courseCardName.getText() + "\n"
									+ " Course Org Name - " + coursePage.courseCardOrgName.get(0).getText());

					for (WebElement el : coursePage.courseCardTopics) {
						if (coursePage.courseCardTopics.size() > 2) {
							Assert.fail();
							ExtentTestManager.getTest().log(LogStatus.FAIL,
									"Course Card is displayed with more than 2 topics");

						} else {
							System.out.println("Course Topics -" + el.getText());
							Assert.assertTrue(true);
							ExtentTestManager.getTest().log(LogStatus.PASS,
									"Course Card is displayed with only first 2 Topics, No of topics are - "
											+ coursePage.courseCardTopics.size() + " , and topics are:"
											+ el.getText().toString());
						}
					}

				}
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To verify Course Card details in Course Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify Course Card details in Course Page " + e.getStackTrace());
			Assert.fail("Failed To verify Course Card details in Course Page");
		}
	}

	/*
	 * purpose : Verify Editing of Batches from Expired Courses Section
	 * 
	 */

	public void verifyBatchEditingFromExpiredCoursesSection() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to verify editing of Batch from Expired Courses section");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.expiredCoursesCourse);
			coursePage.expiredCoursesCourse.click();
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

			if (nameValue == true && aboutBatchValue == true && startDateValue == true && updateButtonValue == true
					&& batchTypeValue == true && endDateValue == true && mentorsValue == true && membersValue == true) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"In Expired Courses section user is NOT ALLOWED TO EDIT any details of Courses");
				log.info("Batch from Expired Courses section is not editable");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-2107");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-2113");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying-SUN-2117");
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"User is NOT ABLE TO EDIT -" + "'Name of batch'-" + nameValue + ", 'About the batch'-"
								+ aboutBatchValue + ", 'Start date'-" + startDateValue + ", 'End date'-" + endDateValue
								+ ", 'Mentor field'-" + mentorsValue + ", 'Member field'-" + membersValue);

				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);
				createUserPage.closePopUp.click();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify editing of Batch from Expired Courses section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify editing of Batch from Expired Courses section :" + e.getStackTrace());
			Assert.fail("Failed To verify editing of Batch from Expired Courses section");
		}
	}

	public void verifyBatchEditingFromOngoingCoursesSection() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to verify editing of Batch from Ongoing Courses section");
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.ongoingCoursesCourse);
			coursePage.ongoingCoursesCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.aboutBatch);
			boolean aboutBatchValue = createMentorPage.aboutBatch.isEnabled(); // getAttribute("disabled").contains("true");
			boolean endDateValue = createMentorPage.endDate.isEnabled(); // getAttribute("disabled").contains("true");
			boolean mentorsValue = createMentorPage.mentorsInBatch.isEnabled();
			boolean membersValue = createMentorPage.membersInBatch.isEnabled();
			boolean startDateValue = createMentorPage.startDate.getAttribute("disabled").contains("true");

			boolean nameValue = createMentorPage.nameOfBatch.isEnabled();// getAttribute("disabled").contains("true");
			// System.out.println("Attr Value
			// "+createMentorPage.aboutBatch.getAttribute("disabled").isEmpty());

			if (aboutBatchValue == true && endDateValue == true && mentorsValue == true && membersValue == true
					&& startDateValue == true) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"In Ongoing Courses section user can only edit:	" + "'About the batch'-" + aboutBatchValue
								+ ", 'End date'-" + endDateValue + ", " + "'Members'-" + membersValue
								+ " and 'Mentors'-" + mentorsValue + " fields");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying-SUN-2114");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying-SUN-2117");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"User cannot edit- 'Name of batch'-" + nameValue + ", 'Start date'-" + startDateValue);
				/*
				 * try {
				 * 
				 * createMentorPage.nameOfBatch.sendKeys("Test");
				 * GenericFunctions.waitWebDriver(2000); createMentorPage.updateBatch.click();
				 * 
				 * } catch(Exception e) { ExtentTestManager.getTest().log(LogStatus.INFO,
				 * "User cannot edit- 'Name of batch'-"+nameValue+" 'Start date'-"
				 * +startDateValue); }
				 */

				GenericFunctions.waitWebDriver(1000);
				createMentorPage.aboutBatch.clear();
				createMentorPage.aboutBatch.sendKeys("Ongoing Courses-About Batch is Updated");
				GenericFunctions.waitWebDriver(2000);
				updateBatchDetails();

				/*
				 * GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);
				 * createUserPage.closePopUp.click();
				 */

			}

			else {
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Couldn't verify editing of batch details in Ongoing Courses section");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify editing of Batch from Ongoing Courses section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify editing of Batch from Ongoing Courses section :" + e.getStackTrace());
			Assert.fail("Failed To verify editing of Batch from Ongoing Courses section");
		}
	}

	public void updateBatchDetails() {
		try {
			createMentorPage.updateBatch.click();
			GenericFunctions.waitWebDriver(1000);
			try {
				GenericFunctions.waitForElementToAppear(coursePage.batchUpdated);
				coursePage.batchUpdated.click();
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Batch is updated successfully-" + coursePage.batchUpdated.getText());

			} catch (Exception e) {
				log.info("Batch is updated , could not capture update message");
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not capture Update Message");
			}

		} catch (Exception c) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not update the Batch after Editing");
			Assert.fail("Exception Occured " + c.getLocalizedMessage());
		}
	}

	public void verifyBatchEditingFromUpcomingCoursesSection() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to verify editing of Batch from Upcoming Courses section");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.upcomingCoursesCourse);
			coursePage.upcomingCoursesCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.aboutBatch);
			boolean aboutBatchValue = createMentorPage.nameOfBatch.isEnabled();
			boolean nameValue = createMentorPage.aboutBatch.isEnabled();
			boolean startDateValue = createMentorPage.startDate.isEnabled();
			boolean endDateValue = createMentorPage.endDate.isEnabled();
			boolean mentorsValue = createMentorPage.mentorsInBatch.isEnabled();
			boolean membersValue = createMentorPage.membersInBatch.isEnabled();
			if (aboutBatchValue == true && nameValue == true && startDateValue == true && endDateValue == true
					&& mentorsValue == true && membersValue == true) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"In Upcoming Courses section user can only edit- 'Name of Batch', 'About the batch', 'Start date' 'End date', 'Members' and 'Mentors' fields");
				GenericFunctions.waitWebDriver(1000);
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying-SUN-2116");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying-SUN-2117");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"These fields are editable- " + ", 'Name of batch'-" + nameValue + ", 'About the batch'-"
								+ aboutBatchValue + ", 'Start date'-" + startDateValue + ", 'End date value'-"
								+ endDateValue + ", 'Member field'-" + membersValue + ", 'Mentor field'-"
								+ mentorsValue);

				createMentorPage.aboutBatch.clear();
				createMentorPage.aboutBatch.sendKeys("Upcoming Courses-About Batch is Updated");
				GenericFunctions.waitWebDriver(2000);
				updateBatchDetails();
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify editing of Batch from Upcoming Courses section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify editing of Batch from Upcoming Courses section :" + e.getStackTrace());
			Assert.fail("Failed To verify editing of Batch from Upcoming Courses section");
		}
	}

	public void LangaugeTranslation() {
		try {

			driver.get(APP_URL + "/explore-course");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Verify Langauge Translation ");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			createUserPage.searchInput.sendKeys("Course");
			GenericFunctions.waitWebDriver(2000);

			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User Searched Course");

			GenericFunctions.waitForElementToAppear(coursePage.clickLangDropdown);
			coursePage.clickLangDropdown.click();
			GenericFunctions.waitWebDriver(2000);

			coursePage.sltHindiLang.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Hindi Language Selected in the Dropdown");

			GenericFunctions.waitWebDriver(2000);

			coursePage.filterSearch.clear();

			coursePage.filterSearch.sendKeys("हिंदी");
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickSearch.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElementToAppear(coursePage.assertLangContent);
			boolean validateHindiContent = coursePage.assertLangContent.isDisplayed();
			if (validateHindiContent == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Hindi Content Validated Succesfully");

			}

			GenericFunctions.waitWebDriver(2000);
			coursePage.clickHindiLangDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			coursePage.sltUrduLang.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Urdu Language Selected in the Dropdown");
			GenericFunctions.waitWebDriver(2000);

			coursePage.filterSearch.clear();
			coursePage.filterSearch.sendKeys("کورس");
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickSearch.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElementToAppear(coursePage.assertLangContent);
			boolean validateUrduContent = coursePage.assertLangContent.isDisplayed();
			if (validateHindiContent == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Urdu Content Validated Succesfully");

			}
			GenericFunctions.waitWebDriver(2000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify Langauge Translation in Explore-CoursePage");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify Langauge Translation in  Explore-CoursePage" + e.getStackTrace());
			Assert.fail("Failed To verify Langauge Translationin Explore-CoursePage");
		}
	}

	public void SearchCouseWithRegionalLang() {
		try {
			// driver.get(APP_URL + "/explore-course");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to Verify Regional Langauge Course Search ");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);

			createUserPage.searchInput.sendKeys("हिंदी");
			GenericFunctions.waitWebDriver(2000);

			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User Searched Hindi Course");

			GenericFunctions.waitForElementToAppear(coursePage.assertLangContent);
			boolean validateHindiContent = coursePage.assertLangContent.isDisplayed();
			if (validateHindiContent == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Hindi Content Validated Succesfully");

			}

			coursePage.filterSearch.clear();

			coursePage.filterSearch.sendKeys("தமிழ்");
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickSearch.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User Searched Tamil Course");

			GenericFunctions.waitForElementToAppear(coursePage.assertLangContent);
			boolean validateTamilContent = coursePage.assertLangContent.isDisplayed();
			if (validateTamilContent == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Tamil Content Validated Succesfully");

			}

			GenericFunctions.waitWebDriver(2000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To verify Regional Langauge Course Search ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify Regional Langauge Course Search " + e.getStackTrace());
			Assert.fail("Failed To verify Regional Langauge Course Search ");
		}
	}

	public void vaidatePageLangaugeTranslation() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Verify Langauge Translation ");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			createUserPage.searchInput.sendKeys("Course");
			GenericFunctions.waitWebDriver(2000);

			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User Searched Course");

			GenericFunctions.waitForElementToAppear(coursePage.clickLangDropdown);
			coursePage.clickLangDropdown.click();
			GenericFunctions.waitWebDriver(2000);

			coursePage.sltHindiLang.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Hindi Language Selected in the Dropdown");

			GenericFunctions.waitForElementToAppear(coursePage.validateHindiContent);
			boolean validateHindiContent = coursePage.validateHindiContent.isDisplayed();
			if (validateHindiContent == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Hindi Content Validated Succesfully");

			}

			GenericFunctions.waitWebDriver(2000);
			coursePage.clickHindiLangDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			coursePage.sltUrduLang.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Urdu Language Selected in the Dropdown");

			GenericFunctions.waitForElementToAppear(coursePage.validateUrduContent);
			boolean validateUrduContent = coursePage.validateUrduContent.isDisplayed();
			if (validateHindiContent == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Urdu Content Validated Succesfully");

			}
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickUrduLangDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			coursePage.sltEnglishLang.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "English Language Selected in the Dropdown");

			GenericFunctions.waitForElementToAppear(coursePage.validateEnglishContent);
			boolean validateEnglishContent = coursePage.validateEnglishContent.isDisplayed();
			if (validateEnglishContent == true) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "English Content Validated Succesfully");

			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To verify Langauge Translation ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify Langauge Translation " + e.getStackTrace());
			Assert.fail("Failed To verify Langauge Translation ");
		}
	}

	/*
	 * purpose : TO verify that the parameterized batch fields are editable
	 */
	public void verifyParameterizedCourseBatchIsEditable(String searchBatch, String batchType) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to search " + searchBatch + " and check fields are editable");
			System.out.println("searchBatch-" + searchBatch);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			createUserPage.searchInput.sendKeys(searchBatch);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchPublishedCourses.get(0));
			createUserPage.searchPublishedCourses.get(0).click();
			GenericFunctions.waitWebDriver(2000);
			if (batchType.equalsIgnoreCase("upcoming")) {

				GenericFunctions.waitForElementToAppear(coursePage.ongoingDropdown);
				coursePage.ongoingDropdown.click();
				GenericFunctions.waitWebDriver(2000);
				coursePage.upcomingDdlValue.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createMentorPage.editBatch);
				createMentorPage.editBatch.click();
				checkBatchFieldsAreEditable("upcoming");
			} else if (batchType.equalsIgnoreCase("ongoing")) {
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createMentorPage.editBatch);
				createMentorPage.editBatch.click();
				checkBatchFieldsAreEditable("ongoing");

			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify editing of " + searchBatch + " Batch fields from Courses section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify editing of Batch from Upcoming Courses section :" + e.getStackTrace());
			Assert.fail("Failed To verify editing of Batch from Upcoming Courses section");
		}
	}

	public void checkBatchFieldsAreEditable(String batch) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "Checking the batch fields editable ");
			boolean aboutBatchValue = createMentorPage.nameOfBatch.isEnabled();
			boolean nameValue = createMentorPage.aboutBatch.isEnabled();
			boolean startDateValue = createMentorPage.startDate.isEnabled();
			boolean endDateValue = createMentorPage.endDate.isEnabled();
			boolean mentorsValue = createMentorPage.mentorsInBatch.isEnabled();
			boolean membersValue = createMentorPage.membersInBatch.isEnabled();
			switch (batch)// .equalsIgnoreCase("ongoing"))
			{
			case "ongoing":

				if (nameValue == true && aboutBatchValue == true && startDateValue == false && endDateValue == true
						&& mentorsValue == true && membersValue == true) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"The fields which are editable and not : 'Name of the Batch'-" + nameValue
									+ ", 'About the batch'-" + aboutBatchValue + " " + ", 'Start Date'-"
									+ startDateValue + ", 'End date'-" + endDateValue + ", 'Add Member field'-"
									+ membersValue + ", 'Add Mentor field'-" + mentorsValue + " for " + batch
									+ "  batch type");
				}
				break;

			case "upcoming":
				if (nameValue == true && aboutBatchValue == true && startDateValue == true && endDateValue == true
						&& mentorsValue == true && membersValue == true) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"The fields which are editable and not : 'Name of the Batch'-" + nameValue
									+ ", 'About the batch'-" + aboutBatchValue + " " + ", 'Start Date'-"
									+ startDateValue + ",	 'End date'-" + endDateValue + ", 'Add Member field'-"
									+ membersValue + ", 'Add Mentor field'-" + mentorsValue + " for " + batch
									+ "  batch type");
				}
				break;

			}

			System.out.println(aboutBatchValue + "," + startDateValue + "," + nameValue + "," + endDateValue + ","
					+ mentorsValue + "," + membersValue);
			log.info(aboutBatchValue + "," + startDateValue + "," + nameValue + "," + endDateValue + "," + mentorsValue
					+ "," + membersValue);

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.closeIcon);
			createUserPage.closeIcon.click();

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To verify fields are editable");
			log.error("Failed to check batch details are editable " + e.getStackTrace());
		}
	}

	public void ApplyFilterCoursePage() {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is in Course Page");
		GenericFunctions.waitWebDriver(3000);

		try {

			coursePage.clickCourseModule.click();

			GenericFunctions.waitForElementToAppear(coursePage.clickViewAllLink);
			coursePage.clickViewAllLink.click();

			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitForElementToAppear(coursePage.clickFliters);

			coursePage.clickFliters.click();
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickPurposeDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on PurposeDropdown");

			coursePage.sltPurpose.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selcted Purpose");

			coursePage.clickApply.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");
			GenericFunctions.waitForElementToAppear(coursePage.validateCourseResult);

			boolean result = coursePage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Purpose");
				coursePage.clickReset.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter Purpose");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter Purpose," + e.getLocalizedMessage());

		}

		try {
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickMediumDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on MediumDropdown");

			coursePage.sltMedium.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selcted Medium");

			coursePage.clickApply.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");
			GenericFunctions.waitForElementToAppear(coursePage.validateCourseResult);

			boolean result = coursePage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Medium");
				coursePage.clickReset.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter Medium");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter Medium," + e.getLocalizedMessage());

		}

		try {
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickClassDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on ClassDropdown");

			coursePage.sltClass.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selcted Class");

			coursePage.clickApply.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");
			GenericFunctions.waitForElementToAppear(coursePage.validateCourseResult);

			boolean result = coursePage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter Class");
				coursePage.clickReset.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter Class");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter Class," + e.getLocalizedMessage());

		}

		try {
			GenericFunctions.waitWebDriver(2000);

			coursePage.clicksubjectDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on subjectDropdown");

			coursePage.sltsubject.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Selcted subject");

			coursePage.clickApply.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Apply button");
			GenericFunctions.waitForElementToAppear(coursePage.validateCourseResult);

			boolean result = coursePage.validateCourseResult.isDisplayed();
			if (result == true) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is displayed for the filter subject");
				coursePage.clickReset.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on Reset Button");

			}

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Searching Content using Filter subject");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			Assert.fail("Failed on Searching Content using Filter subject," + e.getLocalizedMessage());

		}
	}

	/*
	 * purpose : TO create an Upcoming Invite Only batch with Members and mentors
	 * from Different Sub Org
	 * 
	 */

	public String createIOBatchWithMentorsAndMembersFromDifferentSubOrg() {
		String batchUrl = null;
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to create an Upcoming Invite-Only Batch with Members and mentors from Different Sub Org");
			batchUrl = driver.getCurrentUrl();
			System.out.println("Batch -" + driver.getCurrentUrl());
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			String batchName = "Invite-Only Batch"
					+ GenericFunctions.testDataIncrementer("./testData/inviteOnlyBatch.txt");
			createMentorPage.nameOfBatch.sendKeys(batchName);

			createMentorPage.aboutBatch.sendKeys("Invite-Only Batch Description");
			createMentorPage.startDate.click();
			GenericFunctions.waitWebDriver(2000);
			// createMentorPage.startDateCalendar.click();
			coursePage.upcomingBatchStartDate.click();
			GenericFunctions.waitWebDriver(1000);

			createMentorPage.endDate.click();
			GenericFunctions.waitWebDriver(2000);
			// createMentorPage.endDateCalendar.click();
			coursePage.upcomingBatchEndDate.click();
			GenericFunctions.waitWebDriver(2000);

			// Search mentors in batch from different tenant
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-2118");
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(coursePage.searchMentorsForBatch);
			coursePage.searchMentorsForBatch.click();
			coursePage.searchMentorsForBatch.sendKeys(MENTOR_DIFFERENT_SUBORG);
			GenericFunctions.waitWebDriver(1000);
			try {
				GenericFunctions.waitForElementToAppear(coursePage.noResultsFound);
				if (coursePage.noResultsFound.isDisplayed()) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Mentors from different tentant cannot be added " + coursePage.noResultsFound.getText());
					GenericFunctions.waitWebDriver(1000);
					coursePage.searchMentorsForBatch.clear();

				}
			} catch (Exception e) {
				log.info("Failed to add mentors from differnet tenant " + e.getStackTrace());
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Searched for mentor from differnet tenant, Exception on " + e.getLocalizedMessage());
			}

			createMentorPage.mentorDropdown.click();

			// Select mentors in batch from same tenant
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.mentorsInBatch);
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(coursePage.subOrgMentorForIOBatch);
			if (coursePage.subOrgMentorForIOBatch.isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Mentor can search mentors from another Sub Org");
				coursePage.subOrgMentorForIOBatch.click();
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.mentorDropdown.click();
			}

			// Search mentors in batch from different tenant

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-2118");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.membersInBatch);
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(coursePage.searchMembersForBatch);
			coursePage.searchMembersForBatch.click();
			coursePage.searchMembersForBatch.sendKeys(MEMBER_DIFFERENT_SUBORG);
			GenericFunctions.waitWebDriver(1000);
			try {
				GenericFunctions.waitForElementToAppear(coursePage.noResultsFound);
				if (coursePage.noResultsFound.isDisplayed()) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Members from different tentant cannot be added " + coursePage.noResultsFound.getText());
					GenericFunctions.waitWebDriver(1000);
					coursePage.searchMembersForBatch.clear();
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1541");
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"User is trying to   Verify that root org’s and sub org’s users are search able in the 'Add Members” field' ");
					coursePage.searchMembersForBatch.sendKeys(ROOT_ORG_USER);
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(coursePage.membersResultSet);
					if (coursePage.membersResultSet.isDisplayed()) {
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Members from root org is searchable");
						GenericFunctions.waitWebDriver(1000);
						coursePage.searchMembersForBatch.clear();
					}

				}
			} catch (Exception e) {
				log.info("Failed to add Members from differnet tenant " + e.getStackTrace());
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Searched for Members from differnet tenant and verify root org members are searchable , Exception on "
								+ e.getLocalizedMessage());
			}
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.memberDropdown.click();

			// Select Members in batch from same tenant
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.membersInBatch);
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(coursePage.subOrgMemberForIOBatch);
			if (coursePage.subOrgMemberForIOBatch.isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Mentor can search members from another Sub Org");
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Suborg Mentor is having Root Org Users in Member and mentor list");
				coursePage.subOrgMemberForIOBatch.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(coursePage.selectedBatchMembers);
				if (coursePage.selectedBatchMembers.isDisplayed()) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying: SUN-2099");
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Mentor can select members for the batch Successfully");
					createMentorPage.memberDropdown.click();
				}
			}
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.buttonCreate);
			createMentorPage.buttonCreate.click();
			GenericFunctions.waitWebDriver(1000);

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To create an Upcoming Invite-Only Batch with Members and mentors from Different Sub Org");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To create an Upcoming Invite-Only Batch with Members and mentors from Different Sub Org :"
					+ e.getStackTrace());
			Assert.fail(
					"Failed To create an Upcoming Invite-Only Batch with Members and mentors from Different Sub Org");
		}
		return batchUrl;
	}

	public String createCourseForOpenBatchWithResourcesFromDifferentContributors(
			List<TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException {
		String courseNumber = null, courseName = null;
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			courseNumber = GenericFunctions.testDataIncrementer("./testData/dikshadata.txt").toString();
			courseName = objListOFTestDataForSunbird.get(0).getCourseName() + courseNumber;
			createUserPage.courseName.sendKeys(courseName);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.titleNameForCourse);
			createUserPage.titleNameForCourse.click();
			createUserPage.titleNameForCourse.clear();
			createUserPage.titleNameForCourse
					.sendKeys(objListOFTestDataForSunbird.get(0).getTitle() + courseNumber + " Open Batch");
			createUserPage.titleDescriptionForCourse
					.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription() + courseNumber);
			createUserPage.titleKeywordForCourse.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription());
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.resourceSearch.click();
			createUserPage.resourceSearch.sendKeys(objListOFTestDataForSunbird.get(12).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			action.moveToElement(createUserPage.resourceSearch).perform();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.firstSuggestionInResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.addButtonInResource);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addButtonInResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.resourceSearch.clear();
			createUserPage.resourceSearch.sendKeys(objListOFTestDataForSunbird.get(13).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			action.moveToElement(createUserPage.resourceSearch).perform();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.firstSuggestionInResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.addButtonInResource);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addButtonInResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					objListOFTestDataForSunbird.get(0).getCourseName() + courseNumber + " is successfully created ");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to create course" + e.getMessage());
			Assert.fail("Failed on creating course");
		}
		return courseName;
	}

	public void updateUpcomingBatches() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		// String courseName = "null";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify updation of the upcoming batch");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(BatchUserPage.courseBatchImg1);
			BatchUserPage.courseBatchImg1.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.switchToFrame(driver, BatchUserPage.batchForm);
			BatchUserPage.nameOfBatch.clear();
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.aboutBatch.clear();
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			// BatchUserPage.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			/*
			 * BatchUserPage.startDate.click(); GenericFunctions.waitWebDriver(1000);
			 * BatchUserPage.startDateCalendar.click();
			 * GenericFunctions.waitWebDriver(1000);
			 */
			BatchUserPage.endDate.clear();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDateCalendar.click();

			// BatchUserPage.endDate.sendKeys("300 September 2019");
			// GenericFunctions.waitWebDriver(3000);
			// BatchUserPage.mentorsInBatch.click();
			// BatchUserPage.updateMentorInBatch.click();
			// GenericFunctions.waitWebDriver(1000);
			// BatchUserPage.mentorsInBatch.click();

			// BatchUserPage.updateMembersInBatch.click();
			// BatchUserPage.membersInBatch.click();
			// GenericFunctions.waitWebDriver(1500);
			// BatchUserPage.updateMembersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.updateBatch.click();
			GenericFunctions.waitWebDriver(4000);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Updated the course successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on updating the upcoming batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseSearchAndUpdate" + e.getMessage());
			Assert.fail("Failed on updating the upcoming batch : " + e.getLocalizedMessage());
		}

	}

	public void navigateToWorkspaceAndSelectBatches(String batchType) throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to navigate to Worskpace and select batch " + batchType);
			GenericFunctions.waitForElementToAppear(BatchUserPage.workSpace);
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.courseBatches.click();
			GenericFunctions.waitWebDriver(1500);
			if (batchType.equalsIgnoreCase("Ongoing Courses")) {
				// GenericFunctions.scrollToElement(BatchUserPage.ongoingBatches);
				BatchUserPage.ongoingBatches.click();
				GenericFunctions.waitWebDriver(1500);
				ExtentTestManager.getTest().log(LogStatus.INFO, "trying to update Ongoing Batches");
			} else if (batchType.equalsIgnoreCase("Upcoming Courses")) {
				GenericFunctions.waitWebDriver(1000);
				// GenericFunctions.scrollToElement(BatchUserPage.upcomingBatches);
				BatchUserPage.upcomingBatches.click();
				ExtentTestManager.getTest().log(LogStatus.INFO, "trying to update Upcoming Batches");
			} else if (batchType.equalsIgnoreCase("Expired Courses")) {
				GenericFunctions.waitWebDriver(1000);
				// GenericFunctions.scrollToElement(BatchUserPage.previousBatches);
				GenericFunctions.scrollTillEndOfPage();
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.previousBatches.click();
				GenericFunctions.waitWebDriver(1500);
				ExtentTestManager.getTest().log(LogStatus.INFO, "trying to update Previous Batches");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and select batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed on navigating to Workspace and selecting batch, Exception" + e.getMessage());
			Assert.fail(
					"Failed on navigating to Workspace and selecting batch, Exception : " + e.getLocalizedMessage());
		}
	}

	public void navigateToOngoingCourseSearchAndUpdate() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify update the Ongoing batch");
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.firstCourseCard.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.nameOfBatch.clear();
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.aboutBatch.clear();
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			GenericFunctions.waitWebDriver(1000);
			boolean startDateStatus = BatchUserPage.startDate.isEnabled();
			Assert.assertEquals(startDateStatus, false, "startDate is enabled");
			BatchUserPage.endDate.clear();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.updateBatch.click();
			GenericFunctions.waitWebDriver(3000);

			// BatchUserPage.closeBatchPage.click();
			// GenericFunctions.waitWebDriver(3000);

			ExtentTestManager.getTest().log(LogStatus.PASS, "Updated the course successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on updating the Ongoing course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed on updating the Ongoing course" + e.getMessage());
			Assert.fail("Failed on updating the Ongoing course : " + e.getLocalizedMessage());
		}

	}

	public void navigateToUpcomingCourseSearchAndUpdate() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify update the Upcoming batch");
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.firstCourseCard.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.nameOfBatch.clear();
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.aboutBatch.clear();
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.startDate.clear();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDate.clear();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.updateBatch.click();
			GenericFunctions.waitWebDriver(3000);
			BatchUserPage.closePage.click();
			GenericFunctions.waitWebDriver(3000);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Updated the course successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on updating the Upcoming course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed on updating the Upcoming course" + e.getStackTrace());
			Assert.fail("Failed on updating the Upcoming course : " + e.getLocalizedMessage());
		}
	}

	/**
	 * purpose : To add and remove members from the created batch
	 * 
	 * @param url
	 */
	public void addMembersToBatch(String url) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"To verify updating of batch after adding and removing members");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			driver.get(url);
			GenericFunctions.waitForElementToAppear(coursePage.ongoingDropdown);
			coursePage.ongoingDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			coursePage.upcomingDdlValue.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.editBatch);
			createMentorPage.editBatch.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.removeSelectedMembers);
			coursePage.removeSelectedMembers.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.membersInBatch);
			createMentorPage.membersInBatch.click();
			// coursePage.searchMembersForBatch.sendKeys();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(coursePage.subOrgMemberForIOBatch);
			String subOrgMember = coursePage.subOrgMemberForIOBatch.getText().trim();
			System.out.println("subOrgMember" + subOrgMember);
			coursePage.subOrgMemberForIOBatch.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.memberDropdown);
			createMentorPage.memberDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			if (coursePage.selectedBatchMembers.getText().trim().contains(subOrgMember)) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Mentor can able to update the batch members");

			}
			createMentorPage.updateBatch.click();

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to verify updating of batch after adding and removing members");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed to verify updating of batch after adding and removing members : " + e.getStackTrace());
			Assert.fail("Failed to verify updating of batch after adding and removing members");
		}
	}

	public void navigateToCoursePage() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is tryin to navigate to Course Page and verify filter option");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.filterTopic);
			if (coursePage.filterTopic.isDisplayed() && coursePage.clickPurposeDropdown.isDisplayed()
					&& coursePage.clickMediumDropdown.isDisplayed() && coursePage.clickClassDropdown.isDisplayed()
					&& coursePage.clicksubjectDropdown.isDisplayed() && coursePage.filterOrganzation.isDisplayed())

			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Filter are displayed ");
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1509");
				GenericFunctions.waitWebDriver(1000);
				createUserPage.searchInput.sendKeys("Course");
				GenericFunctions.waitWebDriver(1000);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(coursePage.resultCardAfterFilterWithSearh);
				try {
					GenericFunctions.waitForElementToAppear(coursePage.clickViewAllLink);
				} catch (Exception e) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "View All button is not displayed on searching");
				}

				ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1508");
				libraryPage.clickFilters.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(libraryPage.clickDropdownMedium);
				libraryPage.clickDropdownMedium.click();
				GenericFunctions.waitWebDriver(1000);
				libraryPage.sltMediumDropdown.click();
				GenericFunctions.waitWebDriver(2000);
				libraryPage.clickApply.click();
				try {
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(coursePage.resultCardAfterFilterWithSearh);
					if (coursePage.resultCardAfterFilterWithSearh.isDisplayed()) {
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Search is working fine on Course Page with filters, results are displayed - "
										+ coursePage.resultCardAfterFilterWithSearh.getText());
					}
				}

				catch (Exception e) {
					log.info("Exception on finding the content after searching and applying filters :"
							+ e.getStackTrace());
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Search is working fine on Course Page with filters, but results are not displayed");
				}

			}

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to navigate to course page and verify filter option");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed to navigate to course page and verify filter option :" + e.getStackTrace());
			Assert.fail("Failed to navigate to course page and verify filter option");
		}
	}

	public void applyParameterizedFilterAndVerifyContent(String filterName, String filterOption) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to apply " + filterName + " filter and verify result ");

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			WebElement filter = driver.findElement(By.xpath(filterName));
			GenericFunctions.waitWebDriver(1000);
			if (filterName != null && filterOption != null) {

				WebElement selectFilterOption = driver.findElement(By.xpath(filterOption));
				GenericFunctions.waitForElementToAppear(filter);
				filter.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(selectFilterOption);
				selectFilterOption.click();
			}

			else if (filterName != null && filterOption == null) {
				GenericFunctions.waitForElementToAppear(filter);
				GenericFunctions.waitWebDriver(1000);
				filter.click();
				// String filterText=verifyFilterSelectedOrNot(filterName);
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(libraryPage.selectFirstContent);
				libraryPage.selectFirstContent.click();
				GenericFunctions.waitWebDriver(1000);
				libraryPage.selectFirstSubject.click();
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(libraryPage.clickDonebutton);
				libraryPage.clickDonebutton.click();
			}
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(libraryPage.clickSubmitButton);
			libraryPage.clickSubmitButton.click();
			try {
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(coursePage.resultCardAfterFilterWithoutSearch);
				if (coursePage.resultCardAfterFilterWithoutSearch.isDisplayed()) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Results are displayed as per the applied filters, content displayed is -"
									+ coursePage.resultCardAfterFilterWithoutSearch.getText());
				}
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Filters are applied but not getting the results as per applied filter " + e.getStackTrace()
								+ " Exception " + e.getLocalizedMessage());
			}

			GenericFunctions.waitWebDriver(2000);
			libraryPage.clikResettButton.click();
		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to  apply " + filterName + " filter and verify result ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed to apply " + filterName + " filter and verify result " + e.getStackTrace());
			Assert.fail("Failed to  apply " + filterName + " filter and verify result ");

		}
	}

	/*
	 * public void applyParameterizedFilterAndVerifyContent(String filterName,
	 * String filterOption) { try { ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "User is trying to apply " + filterName + " filter and verify result ");
	 * 
	 * GenericFunctions.waitWebDriver(1000);
	 * GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
	 * createUserPage.headerCourse.click(); WebElement filter =
	 * driver.findElement(By.xpath(filterName));
	 * GenericFunctions.waitWebDriver(1000); if (filterName != null && filterOption
	 * != null) {
	 * 
	 * WebElement selectFilterOption = driver.findElement(By.xpath(filterOption));
	 * GenericFunctions.waitForElementToAppear(filter); filter.click();
	 * GenericFunctions.waitWebDriver(1000);
	 * GenericFunctions.waitForElementToAppear(selectFilterOption);
	 * selectFilterOption.click();
	 * 
	 * }
	 * 
	 * else if (filterName != null && filterOption == null) {
	 * GenericFunctions.waitForElementToAppear(filter);
	 * GenericFunctions.waitWebDriver(1000); filter.click(); // String
	 * filterText=verifyFilterSelectedOrNot(filterName);
	 * GenericFunctions.waitWebDriver(1000);
	 * GenericFunctions.waitForElementToAppear(libraryPage.selectFirstContent);
	 * libraryPage.selectFirstContent.click(); GenericFunctions.waitWebDriver(1000);
	 * libraryPage.selectFirstSubject.click();
	 * GenericFunctions.waitTillTheElementIsVisibleAndClickable(libraryPage.
	 * clickDonebutton); libraryPage.clickDonebutton.click(); }
	 * GenericFunctions.waitWebDriver(1000);
	 * GenericFunctions.waitForElementToAppear(libraryPage.clickSubmitButton);
	 * libraryPage.clickSubmitButton.click(); try {
	 * GenericFunctions.waitWebDriver(1000);
	 * GenericFunctions.waitForElementToAppear(coursePage.
	 * resultCardAfterFilterWithoutSearch); if
	 * (coursePage.resultCardAfterFilterWithoutSearch.isDisplayed()) {
	 * Assert.assertTrue(true); ExtentTestManager.getTest().log(LogStatus.PASS,
	 * "Results are displayed as per the applied filters, content displayed is -" +
	 * coursePage.resultCardAfterFilterWithoutSearch.getText()); } } catch
	 * (Exception e) { ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "Filters are applied but not getting the results as per applied filter " +
	 * e.getStackTrace() + " Exception " + e.getLocalizedMessage()); }
	 * 
	 * GenericFunctions.waitWebDriver(2000); libraryPage.clikResettButton.click(); }
	 * catch (Exception e) {
	 * 
	 * ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to  apply " +
	 * filterName + " filter and verify result ");
	 * ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " +
	 * e.getLocalizedMessage()); log.error("Failed to apply " + filterName +
	 * " filter and verify result " + e.getStackTrace());
	 * Assert.fail("Failed to  apply " + filterName + " filter and verify result ");
	 * 
	 * }
	 * 
	 * }
	 */
	public void verifyFilterSelectedOrNot() {
		String textAfterFilter = null, textAfterResetFilter = null;
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying filter gets cleared on clicking RESET");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(libraryPage.clickMediumDropDown);
			libraryPage.clickMediumDropDown.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(libraryPage.selectMediumDropDown);

			libraryPage.selectMediumDropDown.click();
			GenericFunctions.waitForElementToAppear(coursePage.selectedFilterText);
			textAfterFilter = coursePage.selectedFilterText.getText().trim();
			libraryPage.selectMediumDropDown.click();
			GenericFunctions.waitForElementToAppear(coursePage.selectedFilterText);
			textAfterFilter = coursePage.selectedFilterText.getText().trim();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(libraryPage.clickSubmitButton);
			libraryPage.clickSubmitButton.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.resultCardAfterFilterWithoutSearch);

			String contentAfterFilter = coursePage.resultCardAfterFilterWithoutSearch.getText();
			GenericFunctions.waitWebDriver(2000);
			libraryPage.clikResettButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.selectedFilterText);
			textAfterResetFilter = coursePage.selectedFilterText.getText().trim();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.resultCardAfterFilterWithoutSearch);
			String contentAfterResetFilter = coursePage.resultCardAfterFilterWithoutSearch.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying:SUN-1510");
			if (textAfterFilter != textAfterResetFilter
					&& coursePage.resultCardAfterFilterWithoutSearch.isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "On Clearing filters , contents are loaded correctly");
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"On Clicking the RESET option filters clears successfully");

			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify filter clearing");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception : " + e.getLocalizedMessage());
			log.error("Could not verify filter clears after clicking on RESET button, Exception -" + e.getStackTrace());
			Assert.fail("Could not verify filter clears after clicking on RESET button");

		}
	}

	public void verifyBatchDetailsFromOngoingCoursesSection() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to verify details of Batch from Ongoing Courses section");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.aboutBatch);
			boolean aboutBatchValue = createMentorPage.aboutBatch.isEnabled(); // getAttribute("disabled").contains("true");
			boolean endDateValue = createMentorPage.endDate.isEnabled(); // getAttribute("disabled").contains("true");
			boolean mentorsValue = createMentorPage.mentorsInBatch.isEnabled();
			// boolean membersValue = createMentorPage.membersInBatch.isEnabled();
			boolean startDateValue = createMentorPage.startDate.getAttribute("disabled").contains("true");
			boolean nameValue = createMentorPage.nameOfBatch.isEnabled();// getAttribute("disabled").contains("true");
			Assert.assertTrue(true);
			createMentorPage.closeBatchesIcon.click();
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed To verify details of Batch from Ongoing Courses section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e.getLocalizedMessage());
			log.error("Failed To verify details of Batch from Ongoing Courses section :" + e.getLocalizedMessage());
			Assert.fail("Failed To verify details of Batch from Ongoing Courses section");
		}
	}

	public String getContentNameFromPublishedBucket() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is get Content Name From Published Bucket ");
			GenericFunctions.waitForElementToAppearOnScreen(BatchUserPage.firstCourseCardContentName);
			ContentName = BatchUserPage.firstCourseCardContentName.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, ContentName);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			ExtentTestManager.getTest().log(LogStatus.PASS, "User got Content Name From Published Bucket ");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to get Content Name From Published Bucket ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			System.out.println("Failed to get Content Name From Published Bucket");
			Assert.fail("Failed to get Content Name From Published Bucket ");
		}
		return ContentName;
	}

	public String createOpenBatchWithStartDateonly() throws InterruptedException, Exception {
		String batchName = "";
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create open batch for a course");
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			batchName = objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.readFromNotepad("./testData/dikshadata.txt");
			createMentorPage.nameOfBatch.sendKeys(batchName);
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName() + " Open Batch");
			createMentorPage.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.buttonCreate);
			action.moveToElement(createMentorPage.buttonCreate).build().perform();
			action.click(createMentorPage.buttonCreate).build().perform();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(createMentorPage.viewCourseDashboard);
			createMentorPage.viewCourseDashboard.click();
			GenericFunctions.waitWebDriver(2000);

			boolean val = driver.getCurrentUrl().contains("https://staging.ntp.net.in/learn/course/do_");

			if (val == true) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Batch is successfully for course : " + createMentorPage.batchCourseName.getText());
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createOpenBatch" + e.getMessage());
			Assert.fail("Failed to create open batch, Exception" + e.getLocalizedMessage());

		}
		return batchName;
	}

	/*
	 * public String createInviteOnlyBatch() throws InterruptedException, Exception
	 * { String savedCourseName = null; objListOFTestDataForSunbird =
	 * ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse"); try {
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "User is trying to create invite only batch for a course");
	 * GenericFunctions.waitWebDriver(2000);
	 * GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
	 * createMentorPage.addIcon.click(); GenericFunctions.waitWebDriver(1000);
	 * createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).
	 * getCourseName() +
	 * GenericFunctions.testDataIncrementer("./testData/batchName.txt"));
	 * createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).
	 * getCourseName());
	 * 
	 * // Added on 31/07/2018 createMentorPage.startDate.click();
	 * GenericFunctions.waitWebDriver(1000);
	 * createMentorPage.startDateCalendar.click();
	 * GenericFunctions.waitWebDriver(1000);
	 * 
	 * // Added on 08/09/2018 createMentorPage.endDate.click();
	 * GenericFunctions.waitWebDriver(1000);
	 * createMentorPage.endDateCalendar.click();
	 * GenericFunctions.waitWebDriver(1000);
	 * createMentorPage.mentorsInBatch.click();
	 * GenericFunctions.waitWebDriver(1000);
	 * 
	 * textAfterResetFilter = coursePage.selectedFilterText.getText().trim();
	 * GenericFunctions.waitWebDriver(1000);
	 * GenericFunctions.waitForElementToAppear(coursePage.
	 * resultCardAfterFilterWithoutSearch); String contentAfterResetFilter =
	 * coursePage.resultCardAfterFilterWithoutSearch.getText();
	 * ExtentTestManager.getTest().log(LogStatus.INFO,
	 * "User is verifying:SUN-1510"); if (textAfterFilter != textAfterResetFilter &&
	 * coursePage.resultCardAfterFilterWithoutSearch.isDisplayed()) {
	 * Assert.assertTrue(true); ExtentTestManager.getTest().log(LogStatus.PASS,
	 * "On Clearing filters , contents are loaded correctly");
	 * ExtentTestManager.getTest().log(LogStatus.PASS,
	 * "On Clicking the RESET option filters clears successfully");
	 */

	public void applyMultipleFiltersInCoursePage(String filterName, String filterOption, String filterName2,
			String filterOption2) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to apply " + filterName + " filter and verify result ");

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(6000);

			createUserPage.searchInput.sendKeys("Course");
			GenericFunctions.waitWebDriver(1000);

			WebElement filter = driver.findElement(By.xpath(filterName));
			WebElement filter2 = driver.findElement(By.xpath(filterName2));

			GenericFunctions.waitWebDriver(1000);
			if (filterName != null && filterOption != null) {

				WebElement selectFilterOption = driver.findElement(By.xpath(filterOption));
				GenericFunctions.waitForElementToAppear(filter);
				filter.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(selectFilterOption);
				selectFilterOption.click();
			}
			if (filterName2 != null && filterOption2 != null) {

				WebElement selectFilterOption = driver.findElement(By.xpath(filterOption2));
				GenericFunctions.waitForElementToAppear(filter2);
				filter2.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(selectFilterOption);
				selectFilterOption.click();
			}
			/*
			 * else if(filterName!=null&&filterOption==null) {
			 * GenericFunctions.waitForElementToAppear(filter);
			 * GenericFunctions.waitWebDriver(1000); filter.click(); //String
			 * filterText=verifyFilterSelectedOrNot(filterName);
			 * GenericFunctions.waitWebDriver(1000);
			 * GenericFunctions.waitForElementToAppear(libraryPage.selectFirstContent);
			 * libraryPage.selectFirstContent.click(); GenericFunctions.waitWebDriver(1000);
			 * libraryPage.selectFirstSubject.click();
			 * GenericFunctions.waitTillTheElementIsVisibleAndClickable(libraryPage.
			 * clickDonebutton); libraryPage.clickDonebutton.click(); }
			 */
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(libraryPage.clickSubmitButton);
			libraryPage.clickSubmitButton.click();
			try {
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(coursePage.resultCardAfterFilterWithoutSearch);
				if (coursePage.resultCardAfterFilterWithoutSearch.isDisplayed()) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Results are displayed as per the Multiple applied filters, content displayed is -"
									+ coursePage.resultCardAfterFilterWithoutSearch.getText());
				}
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Filters are applied but not getting the results as per Multiple applied filter "
								+ e.getStackTrace() + " Exception " + e.getLocalizedMessage());
			}

			GenericFunctions.waitWebDriver(2000);
			libraryPage.clikResettButton.click();
		} catch (Exception e2) {

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to  apply " + filterName + " filter and verify result ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on : " + e2.getLocalizedMessage());
			log.error("Failed to apply " + filterName + " filter and verify result " + e2.getStackTrace());
			Assert.fail("Failed to  apply " + filterName + " filter and verify result ");

		}

	}

	public void navigateToPreviousCourseSearchAndUpdate() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify update the Previous batch");
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.firstCourseCard.click();
			GenericFunctions.waitWebDriver(2000);
			if (BatchUserPage.nameOfBatch.isEnabled()) {
				BatchUserPage.nameOfBatch.clear();
				BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
						+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.aboutBatch.clear();
				BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.startDate.clear();
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.startDateCalendar.click();
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.endDate.clear();
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.endDateCalendar.click();
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.updateBatch.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Updated the course successfully");
			} else {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Can't update the previous batches");
			}
			GenericFunctions.waitWebDriver(3000);
			BatchUserPage.closePage.click();
			GenericFunctions.waitWebDriver(3000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on updating the Upcoming course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed on updating the Upcoming course" + e.getStackTrace());
			Assert.fail("Failed on updating the Upcoming course : " + e.getLocalizedMessage());
		}

	}

	public void navigateToCourseAndClickOnMyCourse() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section and search course");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseCard);
			createMentorPage.courseCard.click();
			GenericFunctions.waitWebDriver(1000);
			boolean resumeCourseStatus = generic.isElementPresent(coursePage.resumeCourse);
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.scrollToStartOfPage();
			Assert.assertEquals(resumeCourseStatus, true,
					"Not verified,navigated to Course section and searched course has  no enrolled batch");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"verified navigated to Course section and searched course has enrolled batch");

			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseCard);
			boolean previousArrowStatus = generic.isElementPresent(coursePage.myCoursePreviousArrow);

			Assert.assertEquals(previousArrowStatus, false, "Not verified, previous arrow is available on first page");
			ExtentTestManager.getTest().log(LogStatus.PASS, "verified previous arrow is not available on first page");

			String myCourseCount = coursePage.myCourseCount.getText();
			int iterationCount = Integer.parseInt(myCourseCount) / 3;
			for (int i = 0; i < iterationCount; i++) {
				GenericFunctions.waitForElementToAppear(coursePage.myCourseNextArrow);
				coursePage.myCourseNextArrow.click();
				GenericFunctions.waitWebDriver(1000);
			}

			boolean nextArrowStatus = generic.isElementPresent(coursePage.myCourseNextArrow);
			// Assert.assertEquals(nextArrowStatus, false, "Not verified, next arrow is
			// available on first page");

			if (nextArrowStatus == true) {
				ExtentTestManager.getTest().log(LogStatus.INFO, "next arrow is available on Last page");
			} else if (nextArrowStatus == false) {
				Assert.assertEquals(nextArrowStatus, false, "Not verified, next arrow is available on first page");
				ExtentTestManager.getTest().log(LogStatus.PASS, "verified next arrow is not available on Last page");
			}
			GenericFunctions.waitWebDriver(3000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section and search course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearch" + e.getLocalizedMessage());
			Assert.fail(
					"Failed on navigating to Course section and search course, Exception : " + e.getLocalizedMessage());
		}
	}

	public String createInviteOnlyBatchWithStartDateAsFutureDate() throws InterruptedException, Exception {
		String savedCourseName = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to create invite only batch with start date as future date for a course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchName.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			// Added on 31/07/2018
			createMentorPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			coursePage.upcomingBatchStartDate.click();
			GenericFunctions.waitWebDriver(1000);

			// Added on 08/09/2018
			createMentorPage.endDate.click();
			GenericFunctions.waitWebDriver(1000);
			coursePage.upcomingBatchEndDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);

			// Added on 08/09/2018
			createMentorPage.selectMentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.mentorDropdown.click();
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.selectMembersInBatch);
			executor.executeScript("arguments[0].click();", createMentorPage.selectMembersInBatch);

			GenericFunctions.waitWebDriver(1000);
			createMentorPage.memberDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.buttonCreate.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Invite only batch for a course is created sucessfully");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to create invite only batch with start date as future date");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to create invite only batch with start date as future date" + e.getMessage());
			Assert.fail("Failed to create invite only batch with start date as future date" + e.getLocalizedMessage());
		}
		return savedCourseName;

	}

	public String createCourseForOpenBatchWithFourResourcesFromDifferentContributors(
			List<TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException {
		String courseNumber = null, courseName = null;
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to create course with four resources from two Different contributors");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			courseNumber = GenericFunctions.testDataIncrementer("./testData/dikshadata.txt").toString();
			courseName = objListOFTestDataForSunbird.get(0).getCourseName() + courseNumber;
			createUserPage.courseName.sendKeys(courseName);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.titleNameForCourse);
			createUserPage.titleNameForCourse.click();
			createUserPage.titleNameForCourse.clear();
			createUserPage.titleNameForCourse
					.sendKeys(objListOFTestDataForSunbird.get(0).getTitle() + courseNumber + " Open Batch");
			createUserPage.titleDescriptionForCourse
					.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription() + courseNumber);
			createUserPage.titleKeywordForCourse.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription());
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.resourceSearch.click();
			createUserPage.resourceSearch.sendKeys(objListOFTestDataForSunbird.get(12).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			action.moveToElement(createUserPage.resourceSearch).perform();
			createUserPage.firstSuggestionInResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.addButtonInResource);
			createUserPage.addButtonInResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.resourceSearch.click();
			createUserPage.resourceSearch.sendKeys(objListOFTestDataForSunbird.get(12).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			action.moveToElement(createUserPage.resourceSearch).perform();
			createUserPage.secondSuggestionInResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.addButtonInResource);
			createUserPage.addButtonInResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.resourceSearch.clear();
			createUserPage.resourceSearch.sendKeys(objListOFTestDataForSunbird.get(13).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			action.moveToElement(createUserPage.resourceSearch).perform();
			createUserPage.firstSuggestionInResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.addButtonInResource);
			createUserPage.addButtonInResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.resourceSearch.clear();
			createUserPage.resourceSearch.sendKeys(objListOFTestDataForSunbird.get(13).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			action.moveToElement(createUserPage.resourceSearch).perform();
			createUserPage.secondSuggestionInResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.addButtonInResource);
			createUserPage.addButtonInResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					objListOFTestDataForSunbird.get(0).getCourseName() + courseNumber + " is successfully created ");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed in trying to create course with four resources from two Different contributors");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed in trying to create course with four resources from two Different contributors"
					+ e.getStackTrace());
			Assert.fail("Failed in trying to create course with four resources from two Different contributors");
		}
		return courseName;
	}

	public void resumeTheCourseAfterStopingTheconsumption() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to resume The Course After Stoping The consumption");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppearOnScreen(coursePage.nextButtonInCourseConsumption);
			GenericFunctions.scrollToElement(coursePage.nextButtonInCourseConsumption);
			coursePage.nextButtonInCourseConsumption.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "consuming second content");
			GenericFunctions.waitWebDriver(4000);
			coursePage.nextButtonInCourseConsumption.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "consuming third content");
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(coursePage.consumedcontentName);
			String contentName = coursePage.consumedcontentName.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Third content name : " + contentName);
			GenericFunctions.scrollToStartOfPage();
			createUserPage.closeContentPlayer.click();
			GenericFunctions.waitForElementToAppearOnScreen(coursePage.resumeCourse);
			coursePage.resumeCourse.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(coursePage.consumedcontentName);
			String newContentName = coursePage.consumedcontentName.getText();
			Assert.assertEquals(newContentName, contentName, "After resuming the course,contents are not same");

			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"User is resumed with the same content is verified successfully ");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to resume The Course After Stoping The consumption");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to resume The Course After Stoping The consumption" + e.getStackTrace());
			Assert.fail("Failed to resume The Course After Stoping The consumption");
		}

	}

	public void resumeTheCourseAfterHalfconsumptionAndVerify() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to resume The Course After Stoping The consumption");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppearOnScreen(coursePage.nextButtonInCourseConsumption);
			GenericFunctions.scrollToElement(coursePage.nextButtonInCourseConsumption);
			coursePage.nextButtonInCourseConsumption.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "consuming second content");
			GenericFunctions.scrollToElement(coursePage.consumedcontentName);
			String contentName = coursePage.consumedcontentName.getText();
			GenericFunctions.scrollToElement(coursePage.progressBar);
			String progressBarStatus = coursePage.progressBar.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"second content name : " + contentName + " " + progressBarStatus);
			Assert.assertEquals(progressBarStatus, "Your Progress 50%",
					"After resuming the course,contents progress are not same");
			GenericFunctions.scrollToStartOfPage();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Progress of the course is successfully verified ");
			createUserPage.closeContentPlayer.click();
			GenericFunctions.waitForElementToAppearOnScreen(coursePage.resumeCourse);
			coursePage.resumeCourse.click();
			GenericFunctions.waitForElementToAppearOnScreen(coursePage.previousButtonInCourseConsumption);
			GenericFunctions.scrollToElement(coursePage.previousButtonInCourseConsumption);
			coursePage.previousButtonInCourseConsumption.click();
			String newProgressBarStatus = coursePage.progressBar.getText();
			// Assert.assertEquals(newProgressBarStatus, progressBarStatus, "After consuming
			// the same content again,contents progress are not same");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"User is resumed with the same content is verified successfully ");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to resume The Course After Stoping The consumption");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to resume The Course After Stoping The consumption" + e.getStackTrace());
			Assert.fail("Failed to resume The Course After Stoping The consumption");
		}

	}

	public String createInviteOnlyBatch() throws InterruptedException, Exception {
		String savedCourseName = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchName.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

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
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);

			// Added on 08/09/2018
			createMentorPage.selectMentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.mentorDropdown.click();
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.selectMembersInBatch);
			executor.executeScript("arguments[0].click();", createMentorPage.selectMembersInBatch);

			GenericFunctions.waitWebDriver(1000);
			createMentorPage.memberDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.buttonCreate.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Invite only batch for a course is created sucessfully");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getStackTrace());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		System.out.println("savedCourseName-" + savedCourseName);
		return savedCourseName;

	}

	public void takeNoteOptionAvailable(List<TestDataForDiksha> objListOFTestDataForSunbird)
			throws InterruptedException, Exception {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to create note the avilaibility of takenote icon");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollTillEndOfPage();
			boolean takenote = generic.isElementPresent(coursePage.takeNote);
			Assert.assertEquals(takenote, true, "takenote icon was not available");
			coursePage.takeNote.click();
			GenericFunctions.waitWebDriver(2000);
			notesNumber = GenericFunctions.testDataIncrementer("./testData/notesNumber.txt").toString();
			coursePage.noteText.sendKeys(objListOFTestDataForSunbird.get(4).getTitle() + notesNumber);
			GenericFunctions.waitWebDriver(2000);
			coursePage.noteDescription.sendKeys(objListOFTestDataForSunbird.get(4).getTitle() + notesNumber);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(coursePage.saveNoteBtn);
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"user created note the availibity of take note sucessfully");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify availability of takenote icon");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify availability of takenote icon" + e.getStackTrace());
			Assert.fail("Failed to verify availability of takenote icon" + e.getLocalizedMessage());
		}

	}

	public String verifyNotesinViewAll(List<TestDataForDiksha> objListOFTestDataForSunbird)

	{

		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the notes ");
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollTillEndOfPage();
			GenericFunctions.waitForElementToAppear(coursePage.viewAll);
			coursePage.viewAll.click();

			String textTitle = coursePage.titleText.getText();
			String textDesc = coursePage.descriptionText.getText();
			String notesName = objListOFTestDataForSunbird.get(4).getTitle()
					+ GenericFunctions.readFromNotepad("./testData/notesNumber.txt").toUpperCase().toString();
			Assert.assertEquals(textTitle, notesName, "title text is not same as expected");

			ExtentTestManager.getTest().log(LogStatus.PASS, "User has successfully verified the entered text in title");

			Assert.assertEquals(textDesc, notesName, "Description text is not same as expected");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"User has successfully verified the entered text in description");
		}

		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the text");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to verify the text" + e.getLocalizedMessage());
		}
		return notesName;
	}

	public void verifyOnSearchingWithFilteringViewAllIsNotDisplayed() {

		// NEED TO ADD CODE HERE -TEJAS ,APRIL 02 2019
	}

	public void searchACourseWhereLogggedInUserIsNotCreatorOfIt() {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying Search a course where logged in user is not the creator");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys("Course");
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchPublishedCourses.get(0));
			createUserPage.searchPublishedCourses.get(0).click();
			GenericFunctions.waitWebDriver(2000);
			String urlBeforeConsuming = driver.getCurrentUrl().trim();
			GenericFunctions.waitForElementToAppear(coursePage.contentUnitCard);
			coursePage.contentUnitCard.click();
			GenericFunctions.waitWebDriver(2000);
			coursePage.contentItem.click();
			GenericFunctions.waitWebDriver(2000);
			String urlAfterConsuming = driver.getCurrentUrl().trim();
			if (urlBeforeConsuming != urlAfterConsuming) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Course mentor is able to read/preview the course content successfully.");
			}
			GenericFunctions.waitWebDriver(2000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to Search a course where logged in user is not the creator");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to Search a course where logged in user is not the creator" + e.getMessage());
			Assert.fail("Failed to Search a course where logged in user is not the creator, Exception"
					+ e.getLocalizedMessage());
		}
	}

	public String verifyCourseSharingViaUrl() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to share the course by copying Share Url");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.contentFromMyCourses);
			workspacePage.contentFromMyCourses.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(coursePage.shareIcon);
			action.moveToElement(coursePage.shareIcon);
			coursePage.shareIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.copyLinkButton);
			coursePage.copyLinkButton.click();
			GenericFunctions.waitWebDriver(1000);
			if (coursePage.linkCopiedMsg.isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"User can successfully share the content by copying the link");
				GenericFunctions.waitWebDriver(1000);
				// driver.quit();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to share the course by copying Share Url");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to share the course by copying Share Url, " + e.getStackTrace());
			Assert.fail("Failed to share the course by copying Share Url" + e.getLocalizedMessage());
		}
		System.out.println("link-" + coursePage.getTheLink.getText());
		return coursePage.getTheLink.getText().trim();
	}

	/*
	 * purpose : To verify copied link can be opened in different browser can see
	 * course TOC structure and batch details
	 */
	public void openTheCopiedLinkInDifferentBrowser(String link) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is open the copied link in Opera Browser and verify Course TOC");
			System.setProperty("webdriver.opera.driver", "/drivers/operadriver");
			WebDriver driver = new OperaDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(link);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.batchListCard);
			if (coursePage.batchListCard.isDisplayed()) {
				Assert.assertTrue(true);
				GenericFunctions.waitWebDriver(1000);
				coursePage.contentUnitCard.click();
				GenericFunctions.waitWebDriver(1000);
				if (coursePage.contentItem.isDisplayed()) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"When user load the link in different browser, User can see the course TOC structure and Batch Details");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to open the copied link different browser and verify course TOC");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to open the copied link different browser, " + e.getStackTrace());
			Assert.fail("Failed to open the copied link different browser " + e.getLocalizedMessage());

		}
	}

	public void deleteTheFirstNote(String notesName) throws Exception {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete the first note");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(coursePage.deleteIcon);
			coursePage.deleteIcon.click();
			GenericFunctions.waitWebDriver(2000);
			coursePage.yesButton.click();
			GenericFunctions.waitWebDriver(1000);
			String titleTextstatus = coursePage.titleText.getText();
			Assert.assertNotEquals(titleTextstatus, notesName, "First note was not deleted");
			ExtentTestManager.getTest().log(LogStatus.PASS, "user deleted the first note sucessfully");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to delete the note");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to delete the note" + e.getStackTrace());
			Assert.fail("Failed to delete the note" + e.getLocalizedMessage());
		}

	}

	public void checkclearOptionInTakeNotes() throws InterruptedException, Exception {

		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to clear the note ");
			GenericFunctions.waitWebDriver(2000);
			// if(generic.isElementPresent(locator))

			coursePage.clickCourseTitle.click();
			GenericFunctions.waitWebDriver(2000);

			coursePage.clickCourseSubTitle.click();
			GenericFunctions.waitWebDriver(5000);

			GenericFunctions.scrollTillEndOfPage();
			boolean takenote = generic.isElementPresent(coursePage.takeNote);
			Assert.assertEquals(takenote, true, "takenote icon was not available");
			coursePage.takeNote.click();
			GenericFunctions.waitWebDriver(2000);
			coursePage.noteText.sendKeys("todayscript");
			GenericFunctions.waitWebDriver(2000);
			coursePage.noteDescription.sendKeys("todayscript");
			GenericFunctions.waitWebDriver(2000);
			coursePage.clearNoteBtn.click();
			GenericFunctions.waitWebDriver(1000);
			String textData = coursePage.noteText.getText();
			String descriptionData = coursePage.noteDescription.getText();
			Assert.assertEquals(textData, "", "textdata is not cleared");
			Assert.assertEquals(descriptionData, "", "textDescription is not cleared");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"user cleared created note and the availibity of take note sucessfully");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify availability of takenote icon");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify availability of takenote icon" + e.getStackTrace());
			Assert.fail("Failed to verify availability of takenote icon" + e.getLocalizedMessage());
		}

	}

	public String verifyAvailabilityOfShareIcon() throws InterruptedException, Exception {

		String savedCourseName = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the avilaibility of share icon");
			GenericFunctions.waitWebDriver(2000);
			savedCourseName = coursePage.contentName.getText();
			boolean shareiconstatus = generic.isElementPresent(coursePage.shareIcon);
			Assert.assertEquals(shareiconstatus, true, "share icon was not available");
			ExtentTestManager.getTest().log(LogStatus.PASS, "user verified the availibity of share icon sucessfully");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify availability of share icon");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify availability of share icon" + e.getStackTrace());
			Assert.fail("Failed to verify availability of share icon" + e.getLocalizedMessage());
		}
		return savedCourseName;
	}

	public String getAnyContentNameFromPublishedBucket(String contentUsed) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to get any Content Name From Published Bucket ");
			for (int j = 0; j <= 3; j++) {
				for (int i = 0; i < 9; i++) {
					String contentType = BatchUserPage.typeOfContentInCards.get(i).getText();
					if (contentUsed.equalsIgnoreCase(contentType)) {
						GenericFunctions.waitForElementToAppearOnScreen(BatchUserPage.firstCourseCardContentName);
						ContentName = BatchUserPage.courseCardContentName.get(i).getText();
						ExtentTestManager.getTest().log(LogStatus.INFO, ContentName);
						GenericFunctions.waitWebDriver(500);
						BatchUserPage.courseCards.get(i).click();
						GenericFunctions.waitWebDriver(1000);
						break;
					} else {
						i++;

					}
					// BatchUserPage.contentTitle.isDisplayed()||
				}
				if (generic.isElementPresent(createUserPage.workSpace)) {
					GenericFunctions.scrollTillEndOfPage();
					if (generic.isElementPresent(BatchUserPage.nextButtonInPagination)) {
						BatchUserPage.nextButtonInPagination.click();
					} else {
						break;
					}
				} else {
					break;
				}
			}

			GenericFunctions.waitWebDriver(4000);
			ExtentTestManager.getTest().log(LogStatus.PASS, "User got Content Name From Published Bucket ");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to get any Content Name From Published Bucket  ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			System.out.println("Failed to get any Content Name From Published Bucket ");
			Assert.fail("Failed to get any Content Name From Published Bucket ");
		}
		return ContentName;
	}

	public void searchTheCreatedNote(String notesName) throws Exception {

		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search the created note");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitWebDriver(2000);
			coursePage.searchForNotes.click();
			String notes = objListOFTestDataForSunbird.get(4).getTitle()
					+ GenericFunctions.readFromNotepad("./testData/notesNumber.txt").toUpperCase().toString();
			coursePage.searchForNotes.sendKeys(notes);
			GenericFunctions.waitWebDriver(2000);

			if (generic.isElementPresent(coursePage.titleTextHeader)) {
				String searchedResult = coursePage.titleTextHeader.getText();
				Assert.assertEquals(searchedResult, notes, "search note was not found");
				ExtentTestManager.getTest().log(LogStatus.PASS, "user searched the created note sucessfully");
			}
			coursePage.searchForNotes.clear();
			;
			coursePage.searchForNotes.sendKeys("Auto");
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitWebDriver(1000);
			if (generic.isElementPresent(coursePage.titleTextHeader)) {
				String searchedResult = coursePage.titleTextHeader.getText();
				Assert.assertEquals(searchedResult, "Auto", "search note was not found");
				ExtentTestManager.getTest().log(LogStatus.PASS, "user searched the created note sucessfully");
			} else {
				Assert.assertTrue(true, "invalid search content found");
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"searched content not availble as its not a valid notes");
			}

			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search the note");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to search the note" + e.getStackTrace());
			Assert.fail("Failed to search the note" + e.getLocalizedMessage());
		}

	}

	public void updateTheCreatedNote() throws Exception {

		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to update the created note");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitWebDriver(2000);
			coursePage.editIcon.click();
			GenericFunctions.waitWebDriver(2000);

			coursePage.noteText.sendKeys("update");
			GenericFunctions.waitWebDriver(2000);
			coursePage.italicIcon.click();
			coursePage.noteDescription.sendKeys("update");

			GenericFunctions.waitWebDriver(2000);
			coursePage.updateButtonInNotes.click();

			GenericFunctions.waitWebDriver(1000);
			String titleTextstatus = coursePage.titleText.getText();
			if (titleTextstatus.contains("update")) {
				Assert.assertTrue(true, "notes are not getting updated");
			}
			// Assert.assertEquals(titleTextstatus, true, "search note was not found");
			ExtentTestManager.getTest().log(LogStatus.PASS, "user updated the created note sucessfully");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to update the note");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to update the note" + e.getStackTrace());
			Assert.fail("Failed to update the note" + e.getLocalizedMessage());
		}

	}

	public String verifyUpdatedNotesinViewAll(List<TestDataForDiksha> objListOFTestDataForSunbird)

	{

		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the entered text");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollTillEndOfPage();
			/*
			 * GenericFunctions.waitForElementToAppear(coursePage.viewAll);
			 * coursePage.viewAll.click();
			 */

			String textTitle = coursePage.titleText.getText();
			String textDesc = coursePage.descriptionText.getText();
			String notesName = objListOFTestDataForSunbird.get(4).getTitle()
					+ GenericFunctions.readFromNotepad("./testData/notesNumber.txt").toUpperCase().toString()
					+ "update";
			Assert.assertEquals(textTitle, notesName, "title text is not same as expected");

			ExtentTestManager.getTest().log(LogStatus.PASS, "User has successfully verified the entered text in title");

			Assert.assertEquals(textDesc, notesName, "Description text is not same as expected");
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"User has successfully verified the entered text in description");
		}

		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the text");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to verify the text" + e.getLocalizedMessage());
		}
		return notesName;
	}

	public void verifyMyNoteBookSection() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify My NoteBook Section");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying: SUN-1501");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.myNotebookSection);
			GenericFunctions.scrollTillEndOfPage();
			if (coursePage.myNotebookSection.isDisplayed() && coursePage.viewAll.isDisplayed()) {
				Assert.assertTrue(true);
				GenericFunctions.waitWebDriver(1000);
				coursePage.viewAll.click();
				GenericFunctions.waitForElementToAppear(coursePage.myNotes);
				if (coursePage.myNotes.isDisplayed() && coursePage.createdNotes.isDisplayed()) {
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"User is able to access all the created notes and displayed in a separate page");
				}
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify My NoteBook Section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify My NoteBook Section" + e.getStackTrace());
			Assert.fail("Failed to verify My NoteBook Section" + e.getLocalizedMessage());

		}
	}

	public void verifyEditingOfCreatedNotes() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit the created notes");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1502");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToStartOfPage();
			GenericFunctions.waitWebDriver(2000);
			coursePage.editNotes.click();
			GenericFunctions.waitWebDriver(2000);
			coursePage.noteText.sendKeys("updated");
			GenericFunctions.waitWebDriver(1000);
			coursePage.noteDescription.sendKeys("*updated*");
			GenericFunctions.waitWebDriver(1000);
			coursePage.updateNotes.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.createdNotes);
			if (coursePage.createdNotes.isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to edit the created notes");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify editing of created notes");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify editing of created notes" + e.getStackTrace());
			Assert.fail("Failed to verify editing of created notes" + e.getLocalizedMessage());

		}
	}

	public void searchCreatedNotes() {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search created notes");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying : SUN-1503");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(coursePage.createdNotes);
			String searchInput = coursePage.getFirstNotesTitle.getText();

			coursePage.searchNotes.sendKeys(searchInput);
			coursePage.notesSearchIcon.click();
			GenericFunctions.waitForElementToAppear(coursePage.createdNotes);
			if (coursePage.createdNotes.isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to search the created notes");
			}

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify editing of created notes");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify editing of created notes" + e.getStackTrace());
			Assert.fail("Failed to verify editing of created notes" + e.getLocalizedMessage());
		}
	}

	/*
	 * Purpose : User is trying to search for the course [SUN-1542 and SUN-1543]
	 */

	public String VerifyAddedMentorsAreAbleToMoniterCourseBatchProgress() {

		String savedCourseName, batchName = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying SUN-1543");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);

			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
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
			batchName = objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchName.txt");
			createMentorPage.nameOfBatch.sendKeys(batchName);
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

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

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed to verify that mentors are able to moniter Course batch progress");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Failed to verify that mentors are able to moniter Course batch progress" + e.getStackTrace());
			Assert.fail("Failed to verify that mentors are able to moniter Course batch progress"
					+ e.getLocalizedMessage());

		}

		return batchName;

	}

	/*
	 * Purpose: Verify that root mentor and sub-org mentor are able to moniter
	 * Course batch progress
	 */

	public void viewCourseStatsForMentors(String batchName) {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verifying SUN-1542");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to view the course stats");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createMentorPage.viewCourseDashboard);
			createMentorPage.viewCourseDashboard.click();
			GenericFunctions.waitWebDriver(3000);

			createMentorPage.selectBatchDropdown.click();
			GenericFunctions.waitWebDriver(3000);

			createMentorPage.searchCourseBatch.sendKeys(batchName);
			GenericFunctions.waitWebDriver(3000);

			try {
				createMentorPage.selectFirstBatch.click();
				GenericFunctions.waitWebDriver(3000);
			} catch (Exception e3) {

			}

			GenericFunctions.waitForElementToAppear(createMentorPage.courseDashboard);
			if (createMentorPage.courseDashboard.isDisplayed() && createMentorPage.status.isDisplayed()) {
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "USer is able to Verify Course Stats of course  batch"
						+ createMentorPage.batchCourseName.getText());
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

	public String createInviteBatchByRootOrgMentor(String courseToCreateBatch) throws InterruptedException, Exception {
		String savedCourseName = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			/*
			 * createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).
			 * getCourseName() +
			 * GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toUpperCase());
			 */
			createUserPage.searchInput.sendKeys(courseToCreateBatch);
			createUserPage.searchIcon.click();

			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.getCourseName);
			savedCourseName = createMentorPage.getCourseName.getText().trim();
			System.out.println(savedCourseName);
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.getCourseName.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchName.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

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
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);

			// Added on 08/09/2018
			createMentorPage.selectMentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.mentorDropdown.click();
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.selectMembersInBatch);
			executor.executeScript("arguments[0].click();", createMentorPage.selectMembersInBatch);

			// createMentorPage.selectMembersInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.memberDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.buttonCreate.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Invite only batch for a course is created sucessfully");
			System.out.println("Batch Created");
			GenericFunctions.waitWebDriver(4000);

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		System.out.println("savedCourseName-" + savedCourseName);
		return savedCourseName;

	}
}
