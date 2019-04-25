package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.startup.BaseTest;

/**
 * Created by Qualitrix Technologies Pvt Ltd. Purpose: To capture and maintain
 * all webelements related to SignUpPage
 */
public class LibraryPage {
	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Library')]")
	public WebElement clickLibray;

	@FindBy(xpath = "//*[contains(text(),' Teaching Material')]/following::div[contains(@class,' ellipsis')]")
	//@FindBy(xpath = "//*[contains(text(),' Teaching Material')]/following::div[contains(@class,' ellipsis')]")
	public WebElement latestResourceListInTeachingMaterial;

	@FindBy(xpath = "//*[@class='sb-card-title']")
	public WebElement validateResource;

	@FindBy(xpath = "(//h4[contains(@class,'pageSection-heading')]/..//button[contains(.,'View All')])")
	public List<WebElement> viewAllButtonsInPage;

	@FindBy(xpath = "//*[contains(text(),'Featured Content')]/following::span[1]")
	public WebElement featuredContentCount;

	@FindBy(xpath = "//*[contains(text(),'Textbooks')]/following::span[1]")
	public WebElement textBookContentCount;

	@FindBy(xpath = "//*[contains(text(),'Teaching Material')]/following::span[1]")
	public WebElement teachingMaterialtCount;

	@FindBy(xpath = "//*[contains(text(),'Learning Material')]/following::span[1]")
	public WebElement learningMaterialCount;

	@FindBy(xpath = "//*[contains(text(),'Practice and Test Material')]/following::span[1]")
	public WebElement practiceandTestMaterial;

	// div[contains(@class,'field')]/child::label
	@FindBy(xpath = "//label/following::input/preceding::div[contains(@class,'field')]/child::label")
	// @FindBy(xpath="//label[contains(.,'Explore content
	// from')]/following::label/..//i[contains(@class,'dropdown icon')]")
	public List<WebElement> filterLabelsInPage;

	@FindBy(xpath = "//label/following::input")
	// @FindBy(xpath="//label[contains(.,'Explore content from')]/following::label")
	public List<WebElement> filterCountInPage;

	@FindBy(xpath = "//i[contains(@class,'icon filter')]/following::input")
	public List<WebElement> filtersOnViewAllClick;

	@FindBy(xpath = "//span[contains(@class,'cursor-pointer')]")
	public WebElement filterIconInPage;

	@FindBy(xpath = "//div//p")
	public WebElement getSectionTextOnViewAll;

	// div[@class='expanded']//div[contains(@class,'text')]
	@FindBy(xpath = "//span[contains(@class,'cursor-pointer')]/following::div[@class='text']")
	public List<WebElement> textOfFiltersOnViewAllClick;

	@FindBy(xpath = "//input[@id='treePicker']")
	public WebElement topicFilterOnViewAll;

	// Mar 12
	@FindBy(xpath = "//div[contains(text(),'No results found')]")
	public WebElement validateResult;

	@FindBy(xpath = "//input[@title='Search']")
	public WebElement searchInputfield;


	// March 13

	@FindBy(xpath = "//h4[contains(text(),'CourseOpenBatch50')]")
	public WebElement clickCourseSearchedResult;

	@FindBy(xpath = "//button[contains(text(),'Enroll')]")
	public WebElement enrollButton;

	@FindBy(xpath = "//div[contains(text(),'Sign in to enroll in this course')]")
	public WebElement assertSignInPopup;

	@FindBy(xpath = "//i[@class='close icon']/following::a[6]")
	public WebElement clickSignIn;

	@FindBy(xpath = "//span[contains(text(),'CourseOpenBatch50')]")
	public WebElement validateTOCForOpenBatchCourse;

	//@FindBy(xpath = "//a[contains(.,'Sign In')]")
	@FindBy(xpath = "//a[contains(.,'Sign in')]")
	public WebElement exploreSignInLink;

	// Mar 14
	@FindBy(xpath = "//input[@id='treePicker']")
	public WebElement clickTopticDropdown;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]/following::i[contains(@class,'add icon')]")
	//@FindBy(xpath = "//input[@placeholder='  Search']/following::a[1]")
	public WebElement selectFirstContent;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]/following::span[contains(@class,'name')][2]")
	//@FindBy(xpath = "//input[@placeholder='  Search']/following::a[2]")
	public WebElement selectFirstSubject;

	@FindBy(xpath = "//button[contains(text(),'Done')]")
	public WebElement clickDonebutton;

	@FindBy(xpath = "//label[contains(text(),'Purpose')]/following::div[1]")
	public WebElement clickPurposeDropDown;

	@FindBy(xpath = "//label[contains(text(),'Purpose')]/following::div[@class='p-5 option-text'][1]")
	public WebElement selectPurposeDropdown;

	@FindBy(xpath = "//label[contains(text(),'Medium')]/following::div[1]")
	public WebElement clickMediumDropDown;

	@FindBy(xpath = "//label[contains(text(),'Medium')]/following::div[@class='p-5 option-text'][1]")
	public WebElement selectMediumDropDown;

	@FindBy(xpath = "//label[contains(text(),'Class')]/following::div[1]")
	public WebElement clickClassDropDown;

	@FindBy(xpath = "//label[contains(text(),'Class')]/following::div[@class='p-5 option-text'][1]")
	public WebElement selectClassDropDown;

	@FindBy(xpath = "//label[contains(text(),'Subject')]/following::div[1]")
	public WebElement clickSubjectDropDown;

	@FindBy(xpath = "//label[contains(text(),'Subject')]/following::div[@class='p-5 option-text'][1]")
	public WebElement selectSubjectDropDown;

	@FindBy(xpath = "//label[contains(text(),'Organization')]/following::div[1]")
	public WebElement clickOrganizationDropDown;

	@FindBy(xpath = "//label[contains(text(),'Organization')]/following::div[@class='p-5 option-text'][1]")
	public WebElement selectOrganizationDropDown;


	@FindBy(xpath = "//h4[contains(@class,'title')][1]")
	public WebElement validateCourseResult;


	@FindBy(xpath = "//div[contains(text(),'No results found')]")
	public WebElement validateNoResultFound;

	@FindBy(xpath = "//*[contains(text(),'Latest Courses')]/following::button[1]")
	public WebElement clickLatestCourseViewAllLink;

	@FindBy(xpath = "//*[contains(text(),'Filters')]")
	public WebElement clickFilters;

	@FindBy(xpath = "//i[@class='delete icon']")
	public WebElement checkAppliedFilters;

	@FindBy(xpath = "//a[contains(.,'Last')]")
	public WebElement lastPageLink;

	@FindBy(xpath = "//input[@id='searchText']")
	public WebElement searchTextInQuestion;

	@FindBy(xpath = "//i[@id='qb-search-button']")
	public WebElement searchIconInQuestion;

	@FindBy(xpath = "//div[@data-tooltip='select question']//input[@type='checkbox']")
	public List<WebElement> checkBoxInSelectQuestion;

	@FindBy(xpath = "//input[@name='filter_search']")
	public WebElement searchInLibrary;

	@FindBy(xpath = "//*[contains(text(),'Search')]")
	public WebElement clickSearch;


	@FindBy(xpath = "//div[contains(text(),' Medium : English ')]")
	public WebElement validateFilteredContent;

	@FindBy(xpath = "//*[contains(text(),'Teaching Material')]/following::button[1]")
	public WebElement teachingMaterialViewAllSection;

	@FindBy(xpath = "//*[contains(text(),'Textbooks')]/following::button[1]")
	public WebElement textbooksViewAllSection;

	@FindBy(xpath = "//*[contains(text(),'Practice and Test Material')]/following::button[1]")
	public WebElement practiceAndTestMaterialViewAllSection;

	@FindBy(xpath = "//*[contains(text(),'Featured Content')]/following::button[1]")
	public WebElement featuredContentViewAllButton;

	@FindBy(xpath = "//*[contains(text(),'Learning Material')]/following::button[1]")
	public WebElement learningMaterialViewAllButton;

	@FindBy(xpath = "//*[@class='sb-card-title']")
	public WebElement validateFilterResult;

	@FindBy(xpath = "//*[contains(text(),'Select Medium')]")
	public WebElement clickDropdownMedium;
	@FindBy(xpath = "//*[contains(text(),'Select Medium')]//following::span[contains(text(),'English')]")
	public WebElement sltMediumDropdown;

	@FindBy(xpath = "//*[contains(text(),' Select Class')]")
	public WebElement clickDropdownClass;
	@FindBy(xpath = "//*[contains(text(),' Select Class')]//following::span[2]")
	public WebElement sltClassDropdown;
	@FindBy(xpath = "//*[contains(text(),' 1 Class')]//following::span[4]")
	public WebElement sltClassDropdown2;

	@FindBy(xpath = "//*[contains(text(),' Select Subject')]")
	public WebElement clickDropdownsubject;
	
	@FindBy(xpath = "//*[contains(text(),' Select Subject')]//following::span[2]")
	public WebElement sltSubjectDropdown;
	
	@FindBy(xpath = "//*[contains(text(),' 1 Subject')]//following::span[4]")
	public WebElement sltsubjectDropdown2;

	@FindBy(xpath = "//th[contains(.,'Trainings attended')]")
	public WebElement trainingsAttendedSection;

	@FindBy(xpath = "//ul//li//span[1]")
	public WebElement completedCourseBatches;

	@FindBy(xpath="//i[@class='delete icon']")
	public WebElement AppliedFilters;
	
	@FindBy(xpath = "//i[contains(@class,'ui large blue clone')]")
	public WebElement copyContentLink;

	//@FindBy(xpath = "//button[contains(text(),' SUBMIT ')]")
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement clickSubmitButton;

	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	//@FindBy(xpath = "//button[contains(text(),'RESET')]")
	public WebElement clikResettButton;
	
	
	
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	//@FindBy(xpath = "//button[contains(text(),'APPLY')]")
	public WebElement clickApply;
	
	@FindBy(xpath = "//button[@title='Search']")
	//@FindBy(xpath = "//i[@class='search blue icon br-0']")
	public WebElement clickSearchBlueicon;

	@FindBy(xpath = "//*[contains(text(),' Practice and Test Material')]/following::div[contains(@class,'ellipsis')]")
	//@FindBy(xpath = "//*[contains(text(),' Practice and Test Material')]/following::div[@class='creator ellipsis']")
	public WebElement latestCourseListInPacticeAndTestMaterial;
}
