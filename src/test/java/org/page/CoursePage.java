package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage {
	WebDriver driver;

	public CoursePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//button[contains(.,'Next')]")
	public List<WebElement> sliderNextButton;

	@FindBy(xpath = "//button[contains(.,'Previous')]")
	public List<WebElement> sliderPreviousButton;

	@FindBy(xpath = "//div[@class='sb-card']")
	//@FindBy(xpath = "//div[contains(@class,'sb-card')]")
	public List<WebElement> courseCard;

	@FindBy(xpath = "//div[@class='sb-card']/..//div[@class='sb-card-org ellipsis']")
	//@FindBy(xpath = "//div[contains(@class,'sb-card')]/..//div[contains(@class,'creator')]")
	public List<WebElement> courseCardOrgName;

	@FindBy(xpath = "//div[contains(@class,'sb-card')]/..//h4[contains(@class,'title')]")
	public WebElement courseCardName;

	@FindBy(xpath = "(//div[contains(@class,'sb-card')])[1]/..//div[contains(@class,'topic')]")
	public List<WebElement> courseCardTopics;

	@FindBy(xpath = "//a[@href='/workspace/content/batches/created']")
	public WebElement courseBatches;

	// March 20-T
	@FindBy(xpath = "//h4[contains(.,'Expired Courses')]/following::div[contains(@class,'ui link cards')]//div[@class='image']")
	public WebElement expiredCoursesCourse;

	@FindBy(xpath = "//h4[contains(.,'Ongoing Courses')]/following::div[contains(@class,'ui link cards')]//div[@class='image']")
	public WebElement ongoingCoursesCourse;

	@FindBy(xpath = "//h4[contains(.,'Upcoming Courses')]/following::div[contains(@class,'ui link cards')]//div[@class='image']")
	public WebElement upcomingCoursesCourse;

	@FindBy(xpath = "//strong[contains(.,'Batch updated successfully...')]")
	public WebElement batchUpdated;

	// mar 20
	@FindBy(xpath = "//*[contains(text(),'Select language')]/following::sui-select")
	public WebElement clickLangDropdown;

	@FindBy(xpath = "//span[contains(text(),'हिंदी')]")
	public WebElement sltHindiLang;

	@FindBy(xpath = "//*[contains(text(),'भाषा चुनिये ')]")
	public WebElement validateHindiContent;

	@FindBy(xpath = "//*[contains(text(),'भाषा चुनिये')]/following::sui-select")
	public WebElement clickHindiLangDropdown;

	@FindBy(xpath = "//span[contains(text(),'اردو')]")
	public WebElement sltUrduLang;

	@FindBy(xpath = "//*[contains(text(),'زبان منتخب کریں')]")
	public WebElement validateUrduContent;

	@FindBy(xpath = "//*[contains(text(),'زبان منتخب کریں')]/following::sui-select")
	public WebElement clickUrduLangDropdown;

	@FindBy(xpath = "//span[contains(text(),'English')]")
	public WebElement sltEnglishLang;

	@FindBy(xpath = "//span[contains(text(),' Filters ')]")
	public WebElement validateEnglishContent;

	// March 21-T
	@FindBy(xpath = "//span[contains(text(),'Ongoing')]")
	public WebElement ongoingDropdown;

	@FindBy(xpath = "//sui-select-option//span[contains(text(),'Upcoming')]")
	public WebElement upcomingDdlValue;

	// Mar 22
	@FindBy(xpath = "//sui-multi-select[@id='purpose']")
	public WebElement clickPurposeDropdown;

	@FindBy(xpath = "//sui-multi-select[@id='purpose']//following::span[2]")
	public WebElement sltPurpose;

	@FindBy(xpath = "//sui-multi-select[@id='medium']")
	public WebElement clickMediumDropdown;

	@FindBy(xpath = "//sui-multi-select[@id='medium']//following::span[2]")
	public WebElement sltMedium;

	@FindBy(xpath = "//sui-multi-select[@id='gradeLevel']")
	public WebElement clickClassDropdown;

	@FindBy(xpath = "//sui-multi-select[@id='gradeLevel']//following::span[2]")
	public WebElement sltClass;

	@FindBy(xpath = "//sui-multi-select[@id='subject']")
	public WebElement clicksubjectDropdown;

	@FindBy(xpath = "//sui-multi-select[@id='subject']//following::span[2]")
	public WebElement sltsubject;

	@FindBy(xpath = "//div[@class='sb-card-body']")
	public WebElement validateCourseResult;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	public WebElement clickApply;

	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	public WebElement clickReset;

	@FindBy(xpath = "//*[contains(text(),' Open for enrollment')]//following::button[1]")
	public WebElement clickViewAllLink;

	@FindBy(xpath = "//*[contains(text(),' Filters ')]")
	public WebElement clickFliters;

	@FindBy(xpath = "//a[contains(text(),'Courses')]")
	public WebElement clickCourseModule;

	@FindBy(xpath = "//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link'][2]")
	public WebElement upcomingBatchStartDate;

	@FindBy(xpath = "//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link'][3]")
	public WebElement upcomingBatchEndDate;

	@FindBy(xpath = "(//input[@id='mentorSelList']/following::div/div[contains(.,'Suborg 2 Course Mentor')])")
	public WebElement subOrgMentorForIOBatch;

	@FindBy(xpath = "(//input[@id='userSelList']/following::div/div[contains(.,'Suborg 2 Content Reviewer')])")
	public WebElement subOrgMemberForIOBatch;

	@FindBy(xpath = "//input[@id='mentorSelList']/..//input[@class='search']")
	public WebElement searchMentorsForBatch;

	@FindBy(xpath = "//input[@id='userSelList']/..//input[@class='search']")
	public WebElement searchMembersForBatch;

	@FindBy(xpath = "//input[@id='userSelList']/..//input[@class='search']/following::i")
	public WebElement removeSelectedMembers;

	// div[@id[contains(.,'participant')]]/following::a
	@FindBy(xpath = "//input[@id='userSelList']/following::a")
	public WebElement selectedBatchMembers;

	@FindBy(xpath = "//input[@id='treePicker']")
	public WebElement filterTopic;

	@FindBy(xpath = "//sui-multi-select[@id='channel']")
	public WebElement filterOrganzation;

	// strong[contains(.,'Batch created successfully')]

	@FindBy(xpath = "//span[contains(@class,'count')]")
	public WebElement myCourseCount;

	@FindBy(xpath = "//h4[contains(.,'My Courses')]/..//following-sibling::div/ngx-slick/button[@class='slick-prev slick-arrow']")
	public WebElement myCoursePreviousArrow;

	@FindBy(xpath = "//h4[contains(.,'My Courses')]/..//following-sibling::div/ngx-slick/button[@class='slick-next slick-arrow']")
	public WebElement myCourseNextArrow;

	@FindBy(xpath = "//button[contains(.,'Resume course')]")
	//@FindBy(xpath = "//button[contains(.,'RESUME COURSE')]")
	public WebElement resumeCourse;

	@FindBy(xpath = "//span[contains(.,'Next')]")
	public WebElement nextButtonInCourseConsumption;

	@FindBy(xpath = "//p[contains(@class,'text-align-center m-responsive-cp-header')]")
	public WebElement progressBar;

	@FindBy(xpath = "//span[contains(@class,'left floated header')]")
	public WebElement consumedcontentName;

	@FindBy(xpath = "//span[contains(.,'PREVIOUS')]")
	public WebElement previousButtonInCourseConsumption;

	@FindBy(xpath = "//div[contains(@class,'pageSection')]/following::h4[contains(@class,'title')]")
	public WebElement resultCardAfterFilterWithoutSearch;

	@FindBy(xpath = "//sui-multi-select[@id='medium']/..//div[@class='text']")
	public WebElement selectedFilterText;

	@FindBy(xpath = "//div[contains(@class,'sb-card')]/following::h4[contains(@class,'title')]")
	public WebElement resultCardAfterFilterWithSearh;

	@FindBy(xpath = "//div[@class='message']")
	public WebElement noResultsFound;

	@FindBy(xpath = "//div[contains(@class,'transition visible')]")
	public WebElement membersResultSet;

	@FindBy(xpath = "//div[@class='title']")
	public WebElement contentUnitCard;

	@FindBy(xpath = "//li[@role='treeitem']")
	public WebElement contentItem;

	@FindBy(xpath = "//div[contains(.,'Link copied to clipboard')]")
	public WebElement linkCopiedMsg;

	@FindBy(id = "copyLinkData")
	public WebElement getTheLink;

	@FindBy(xpath = "//div[@class='content batchcardListContent']")
	public WebElement batchListCard;

	@FindBy(xpath = "//input[@id='copyLinkData']/following::button")
	public WebElement copyLinkButton;

	@FindBy(xpath = "//a[contains(text(),'View All')]")
	public WebElement viewAll;

	@FindBy(xpath = "//span[contains(@class,'ui small header notedecheader mouse-pointer')]")
	public WebElement titleText;

	@FindBy(xpath = "//span[contains(@class,'notedecheader mouse-pointer')]")
	public WebElement descriptionText;

	@FindBy(xpath = "//i[@title='Delete']")
	public WebElement deleteIcon;

	@FindBy(xpath = "//button[contains(.,'Yes')]")
	public WebElement yesButton;

	@FindBy(xpath = "//a[.=' Courses '][1]")
	public WebElement courselink;

	@FindBy(xpath = "//div[contains(@class,'meta course')]")
	public WebElement firstContent;

	@FindBy(xpath = "//img[contains(@src,'assets/images/takenote.png')]")
	public WebElement takeNote;

	@FindBy(xpath = "//div[@class='toc-title']")
	public WebElement clickCourseTitle;
	
	@FindBy(xpath = "//span[@class='fancytree-title']")
	public WebElement clickCourseSubTitle;
	
	
	
	
	@FindBy(xpath = "//input[contains(@placeholder,'Title')]")
	public WebElement noteText;

	@FindBy(xpath = "//textarea[contains(@placeholder,'Description')]")
	public WebElement noteDescription;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement saveNoteBtn;

	@FindBy(xpath = "//button[contains(text(),'Clear')]")
	public WebElement clearNoteBtn;

	@FindBy(xpath = "//div[contains(@class,'pageSection')]/following::h4[contains(@class,'title')]")
	public WebElement resultCardAfterFilter;

	@FindBy(xpath = "//i[contains(@class,'blue share')]")
	public WebElement shareIcon;
	
    @FindBy(xpath="//div[contains(@class,'ui fluid icon input')]")
    public WebElement searchContentQR;

    @FindBy(xpath="//input[@name='search']")
    public WebElement searchContentQRClear;
    
	@FindBy(xpath = "//i[contains(@class,'blue clone')]")
	public WebElement cloneIcon;

	
	@FindBy(xpath = "//button[contains(.,'Copy link')]")
	public WebElement copyLink;
	
	@FindBy(xpath = "//div[contains(.,'Link copied to clipboard')]")
	public WebElement linkCopiedToClipBoard;
	
	
	@FindBy(xpath = "//*[contains(@class,'ui header small')]")
	//@FindBy(xpath = "//*[contains(@class,'left floated')]")
	public WebElement contentName;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search for notes ')]")
	public WebElement searchForNotes;
	
	@FindBy(xpath = "//i[contains(@title,'Edit')]")
	public WebElement editIcon;
	
	@FindBy(xpath = "//a[contains(@class,'header')]")
	public WebElement titleTextHeader;
	
	@FindBy(xpath = "//*[contains(@class,'description')]")
	public WebElement descriptionTextHeader;
	
	@FindBy(xpath = "//button[.='Update']")
	public WebElement updateButtonInNotes;
	
	@FindBy(id="wmd-italic-button")
	public WebElement italicIcon;


	@FindBy(xpath="//i[contains(@class,'search icon dialcode')]")
	public WebElement searchIcon;
	
    @FindBy(xpath="//div[contains(@class,'card-body')]")
	public WebElement linkedContentCard;
    
	@FindBy(xpath="//div[contains(@class,'ui tiny header pt-30 font-weight-bold')]")
	public WebElement linkedContent;
	
	@FindBy(xpath="//span[contains(.,'My Notebook')]")
	public WebElement myNotebookSection;
	
	
	@FindBy(xpath="//*[@name='filter_search']")
	public WebElement filterSearch;
	
	@FindBy(xpath="//*[contains(text(),'Search')]")
	public WebElement clickSearch;
	
	
	@FindBy(xpath="//*[@class='sb-card-title']")
	public WebElement assertLangContent;

	
	@FindBy(xpath="//span[contains(.,'My Notes')]")
	public WebElement myNotes;
	
	@FindBy(xpath="//div[contains(@class,'contentnotelist notelistborder')]")
	public WebElement createdNotes;
	
	@FindBy(xpath="//i[@title='Edit']")
	public WebElement editNotes;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement updateNotes;
	
	@FindBy(xpath="//input[@title='Search']")
	public WebElement searchNotes;
	
	@FindBy(xpath="//a[@class='header']")
	public WebElement getFirstNotesTitle;
	
	@FindBy(xpath="//input[@title='Search']/following::i")
	public WebElement notesSearchIcon;

	
	@FindBy(xpath="//a[contains(.,'Assigned to me')]")
	public WebElement assignedToMe;
	
	/*@FindBy(xpath="//a[contains(.,'Assigned to me')]")
	public WebElement resumeButton;*/
}
