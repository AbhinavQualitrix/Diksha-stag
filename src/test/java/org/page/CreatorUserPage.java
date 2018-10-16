/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 06/02/2018

* Purpose: All the locators of creator page.
*/
package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class CreatorUserPage {
	WebDriver driver;

	public  CreatorUserPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	@FindBy(id="dropdown-menu-list-header")
	public WebElement dropDown;
	
	@FindBy(xpath="//i[@class='close icon']")
	public WebElement closeIcon;

	//	@FindBy(xpath="//a[.='Profile']")
	//	@FindBy(xpath="//a[@class='item margin-top-10 active']")
	//	@FindBy(xpath="//div[@class='ui secondary pointing menu']/app-menu-item/a]")
	//	public WebElement headerProfile;

	//	@FindBy(xpath="//div//a[5][contains(text(),'Profile')]")
	//	@FindBy(xpath="//a[.='Profile']")
	@FindBy(xpath="//div[@class='ui secondary pointing menu']//a[contains(text(),'Profile')]")
	public WebElement headerProfile;

	//@FindBy(xpath="//a[.='Workspace']")
	//@FindBy(xpath="//a[contains(text(),'Workspace')]")
	//@FindBy(xpath="//div[@class='menu transition hidden']//a[contains(text(),'Workspace')]")
	@FindBy(xpath="//span[.='View your workspace']")
	public WebElement workSpace;

	@FindBy(xpath="//input[@placeholder='Name']")
//	@FindBy(xpath="//div[@class='ui modal ng-scope transition visible active']//input[@placeholder='Name']")
//	@FindBy(xpath="//div[@class='ui modal scroll transition active visible normal']/..//input[@placeholder='Name']")
//	@FindBy(xpath="//label[contains(text(),'Name')]/following-sibling::div/input")
//	@FindBy(xpath="//form[@class='ui form ng-untouched ng-pristine ng-valid']//input")
	public WebElement courseName;

	@FindBy(xpath="//input[@placeholder='Description']")
	public WebElement courseDescription;

	@FindBy(xpath="//button[contains(text(),'START CREATING')]")
	public WebElement startCreating;

	@FindBy(tagName="iframe")
	public WebElement iFrame;

	//@FindBy(xpath="//div[@class='ui two buttons table-of-contents-btn']//button[2]")
	//@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]//a[2]")
	//@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]")
	//@FindBy(xpath="(//button//a//i)[2]")
	@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]//a[2]")
	public WebElement newChild;

	//	@FindBy(xpath="//input[@class='ng-pristine ng-valid-maxlength ng-not-empty ng-valid ng-valid-required ng-touched']")
	//	@FindBy(xpath="//input[@class='ng-valid-maxlength ng-dirty ng-touched ng-not-empty ng-valid ng-valid-required']")
	//	@FindBy(xpath="//form[@name='contentMetaForm']//input[@placeholder='Enter title for Book']")
	@FindBy(xpath="//label[.='Title']/following-sibling::div//following-sibling::input")
	public WebElement titleName;

	@FindBy(xpath="//textarea[@placeholder='Brief description about the course unit']")
	public WebElement titleDescription;

	@FindBy(xpath="//button[.='ADD RESOURCE']")
	public WebElement addResource;

	//@FindBy(xpath="//img[@class='resourceMetaImage ']")
	//	@FindBy(xpath="//div[@class='facetList ng-scope'][1]//div[@id='checkBox_do_212514765720756224117756']")
	@FindBy(xpath="(//div[@class='facetList ng-scope'][1]//div/div[1])[3]")
	public WebElement selectResource;

	@FindBy(xpath="//strong[contains(text(),'Find & Select Activities')]")
	public WebElement findSelectActivities;		

	//@FindBy(xpath="//button[@class='ui right floated primary tiny button btnAttribute']")
	@FindBy(xpath="//button[@ng-click='returnSelectedLessons(mainTemplate, lessonSelection)']")
	//@FindBy(xpath="//button[text()=' PROCEED ']")
	public WebElement proceedButton;

	@FindBy(xpath="//span[.='Save']")
	//@FindBy(xpath="//div[@class='icon-box popup-item label-icon-box']")
	public WebElement saveCourse;

	@FindBy(xpath="//div[@class='ui button text-part popup-item']")
	//@FindBy(xpath="//i[@class='send icon']")
	public WebElement sendForReview;
	
	@FindBy(xpath="//div[@class='five wide column custom-5-wide']/div/div/div/div[5]")
	//@FindBy(xpath="//div[@data-content='Send for review']")
	public WebElement sendForReviewA;

	@FindBy(xpath="//div[@class='ui appIconSelector']")
	public WebElement clickAppIcon;
	
	@FindBy(id="allImagesTab")
	public WebElement allImages;


	//@FindBy(xpath="(//img[@src='https://ekstep-public-qa.s3-ap-south-1.amazonaws.com/content/do_2123816722878955521320/artifact/6008_1489481046_6231_1511434605692.jpg'])[1]")
	//@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_2124646169195151361273']")
	@FindBy(xpath="(//img[@class='asset_thumbnail'])[1]")
	public WebElement checkAppIcon;

	@FindBy(xpath="//button[.='Select']")
	public WebElement selectAppIcon;
	
	@FindBy(xpath="//button[contains(text(),'Select')]")
	public WebElement selectImage;


	@FindBy(xpath="//div[.='CBSE']")
	public WebElement selectCBSE;
	
	@FindBy(xpath="(//div[.='English'])[2]")
	public WebElement selectENGLISH;
	
	@FindBy(xpath="(//div[.='English'])[1]")
	public WebElement selectEnglish;
	
	@FindBy(xpath="//div[.='KG']")
	public WebElement selectKG;
	
	@FindBy(xpath="//div[.='Mathematics']")
	public WebElement selectMATHEMATICS;
	
	
	
	@FindBy(xpath="//button[.='Save']")
	//@FindBy(xpath="//i[@class='icon-save']")
	public WebElement saveButton;	
	
	@FindBy(xpath="//i[@class='icon-save']")
	public WebElement saveIcon;	
	
	

	//	@FindBy(xpath="//div[@class='ui search dropdown placeholder-padding ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required selection active visible']")
	@FindBy(xpath="//div[.='Select Curriculum']")
	public WebElement clickOnSelectCurriculum;

	@FindBy(xpath="//div[@class='item selected']")
	public WebElement selectCurriculum;

	@FindBy(xpath="//div[.='Select Class']")
	public WebElement clickOnSelectClass;

	@FindBy(xpath="//div[@class='menu transition visible']//following-sibling::div")
	public WebElement selectClass;

	@FindBy(xpath="//label[contains(text(),'SUBJECT')]")
	public WebElement clickOnHeaderSubject;

	@FindBy(xpath="//div[.='Select Subject']")
	public WebElement clickOnSelectSubject;

	@FindBy(xpath="//div[@data-value='Mathematics']")
	public WebElement selectSubject;

	@FindBy(xpath="//div[.='Select Medium']")
	public WebElement clickOnSelectMedium;

	@FindBy(xpath="(//div[@data-value='English'])[2]")
	public WebElement selectMedium;

	@FindBy(xpath="//div[@class='text']//span[.='All']")
	public WebElement headerDropdown;

	@FindBy(xpath="//a[contains(text(),'Course')]")
	public WebElement headerCourse;

	@FindBy(xpath="//div[@id='headerSearch']//span[.='Courses']")
	public WebElement headerCourseClick;

	@FindBy(xpath="//input[@id='keyword']")
	public WebElement searchInput;

	@FindBy(xpath="//i[@class='circular search link icon']")
	public WebElement searchIcon;
	
	@FindBy(xpath="(//div[@class='content'])[1]")
	public WebElement searchedContent;

	@FindBy(xpath="//a[contains(text(),'Review Submissions')]")
	public WebElement reviewSubmission;

	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
	public WebElement reviewCourseName;

	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
	public List<WebElement> reviewSubmittedCourse;

	//updated on June 13
	//@FindBy(xpath="(//div[@class='content']/..//span)[2]")
	@FindBy(xpath="//span[.='Course']")
	public WebElement createCourse;

	//@FindBy(xpath="(//div[@class='content']/..//span)[1]")
	//Updated on June 15
	@FindBy(xpath="//div[@class='content']/..//span[.='Book']")
	public WebElement createBook;

	//@FindBy(xpath="(//div[@class='content']/..//span)[3]")
	//Updated on June 15
	@FindBy(xpath="//div[@class='content']/..//span[.='Resource']")
	public WebElement createResource;

	
	//@FindBy(xpath="(//div[@class='content']/..//span)[4]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Collection']")
	public WebElement createCollection;

	
	//@FindBy(xpath="(//div[@class='content']/..//span)[5]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Lesson Plan']")
	public WebElement createLesson;

	//@FindBy(xpath="(//div[@class='content']/..//span)[6]")
	//Updated on 15 June
	@FindBy(xpath="//span[.='Upload Content']")
	//@FindBy(xpath="//div[@class='content']/..//span[.='Upload Content']")
	public WebElement createUploadContent;

	@FindBy(xpath="(//input[@type='text'])[5]")
	public WebElement bookName;

	@FindBy(xpath="//sui-select[@id='board']")
	public WebElement clickBBoard;
	
	@FindBy(xpath="//input[@class='input ng-pristine ng-valid ng-empty ng-touched']")
	public WebElement addKeyword;
	
	@FindBy(xpath="//input[@placeholder='Credit To']")
	public WebElement creditTo;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	//@FindBy(xpath="//div[text()='Select Board']")
	public WebElement clickBoardDropdownIcon;
	
	//@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	@FindBy(xpath="//div[text()='Select Board']")
	public WebElement clickSelectBoard;
	
	@FindBy(xpath="//div[text()='Select Class']")
	public WebElement clickSelectClass;
	
	@FindBy(xpath="//div[@class='ui fluid search dropdown ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required selection multiple']")
	public WebElement clickClassForLessonPlan;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[4]")
	public WebElement clickClass;
	
	@FindBy(xpath="//div[text()='Select Subject']")
	public WebElement clickSelectSubject;
	
	@FindBy(xpath="//div[text()='Select Medium']")
	public WebElement clickSelectMedium;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[4]")
	public WebElement clickClassDropdownIcon;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[5]")
	public WebElement clickSubjectDropdownIcon;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[3]")
	public WebElement clickMediumDropdownIcon;

	//@FindBy(xpath="(//sui-select[@id='board']/..//sui-select-option[@class='item'])[1]")
	@FindBy(xpath="//sui-select-option[@class='item']//span[.='CBSE']")
	public WebElement selectBBoard;

	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']")
	public WebElement clickBGrade;

	//@FindBy(xpath="//sui-select-option[@class='item']//span[.='Class 3']")
	//@FindBy(xpath="//sui-select-option[@class='item selected']//span[.='KG']")

	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']//span[.='KG']")
	public WebElement selectBGrade;

	@FindBy(xpath="//sui-select[@id='subject']")
	public WebElement clickBSubject;

	@FindBy(xpath="//sui-select[@id='subject']//span[.='English']")
	public WebElement selectBSubject;

	@FindBy(xpath="//sui-select[@id='medium']")
	public WebElement clickBMedium;

	@FindBy(xpath="//sui-select[@id='medium']//span[contains(text(),'English')]")
	public WebElement selectBMedium;

	@FindBy(xpath="//sui-select[@id='year']")
	public WebElement clickBYear;

	@FindBy(xpath="//sui-select[@id='year']//span[contains(text(),'2010')]")
	public WebElement selectBYear;

	@FindBy(xpath="//input[@placeholder='Publisher']")
	public WebElement BPublisher;

	@FindBy(xpath="//p[.='TABLE OF CONTENTS']")
	public WebElement tableOfContents;

	//@FindBy(xpath="(//textarea[@placeholder='Brief description about the unit']")
	//@FindBy(xpath="//label[.='Description']/..//div[@class='ui input']//textarea[@placeholder='Brief description about the unit']")
	//@FindBy(xpath="//label[.='Description']/..//div//textarea[@placeholder='Brief description about the unit']")
	//@FindBy(xpath="//label[.='Description']/..//textarea[@ng-model='unit.description']")
	//@FindBy(xpath="//*[@id="contents-data-form"]/div/div/div[2]/div/textarea")
	//label[.='Description']/../div/textarea[@placeholder='Brief description about the unit']
	
	@FindBy(xpath="//label[.='Description']/../div/textarea[@placeholder='Brief description about the unit']")
	public WebElement bookDescription;

	//@FindBy(xpath="(//input[@name='name'])[1]")
	//@FindBy(xpath="(//input[@placeholder='Enter title for Book'])[1]")
	//@FindBy(xpath="(//div[@class='ui input']//input)[1]")


	//@FindBy(xpath="(//form[@id='contents-data-form'])[4]")
	@FindBy(xpath="(//label[.='Name'])[2]")
	public WebElement clickBookForm;

	//@FindBy(xpath="(//input[@placeholder='Enter title for Book'])[3]")
	@FindBy(xpath="//label[.='Name']/../div[@class='ui input']/..//input[@placeholder='Enter title for Book']")
	public WebElement bookTitle;

	//@FindBy(xpath="//div[@class='tags focused']")
	//@FindBy(xpath="(//input[@placeholder='Enter Keywords'])[3]")
	@FindBy(xpath="//label[.='Keywords']/..//div[@class='tags']//input[@placeholder='Enter Keywords']")
//	@FindBy(xpath="//div[@class='sixteen wide column metacontent-holder metadata-form-container ng-scope']//tags-input[@placeholder='Enter Keywords']")
	public WebElement bookKeywords;

	@FindBy(xpath="//input[@placeholder='Enter code here']")
	public WebElement bookDialcode;

	@FindBy(xpath="(//div[@class='ui image']//img[@data_id='do_2124646169195151361273'])[1]")
	public WebElement clickBookIcon;

	@FindBy(xpath="(//div[@class='ui image']//img[@data_id='do_212450905413713920137'])[1]")
	public WebElement selectBookIcon;

	@FindBy(xpath="(//img[@class='resourceMetaImage '])[2]")
	public WebElement selectBookResource;

	@FindBy(xpath="//i[@class='large blue check circle icon']")
	public WebElement acceptDialcode;

	@FindBy(xpath="//a[contains(text(),'Up For Review')]")
	public WebElement upForReview;
	
	//--------------------------------------------------------------
	//Elements for Create A Lesson plan
	
	@FindBy(xpath="//input[@placeholder='Enter title for unit']")
	public WebElement lessonTitle;
	
	@FindBy(xpath="//label[.='Description']/..//textarea[@placeholder='Brief description about the unit']")
	public WebElement lessonDescription;
	
	@FindBy(xpath="//input[@placeholder='Add Notes']")
	public WebElement lessonNotes;
	
	@FindBy(xpath="(//img[@class='resourceMetaImage '])[3]")
	public WebElement lessonResource;
	
	@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_2124646193555292161285']")
	public WebElement selectLessonIcon;
	
//	@FindBy(xpath="//input[@class='upForReviewSearchBox ng-pristine ng-valid ng-touched']")
//	@FindBy(xpath="//div[@class='workspacesegment eight wide column']//input[@class='upForReviewSearchBox ng-pristine ng-valid ng-touched']")
	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchForReview;
	
	@FindBy(xpath="//img[@class='ui tiny image UpReviewTinyImage']/..//div[@class='UpReviewHeader']")
	public WebElement searchedContentForPublish;
	
	@FindBy(xpath="//span[.='Publish']")
	public WebElement clickPublishIcon;
	
	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> selectAllCB; 
	
	//@FindBy(xpath="//button[@class='ui blue button ng-binding']")
	@FindBy(xpath="(//button[@class='ui right floated primary button mouse-pointer'])[1]")
	public WebElement publishButton;
	
	@FindBy(xpath="(//div[@class='UpReviewHeader'])[1]")
	public WebElement contentForReject;
	
	@FindBy(xpath="//button[contains(text(),'REQUEST CHANGES')]")
	public WebElement clickRequestChanges;
	
	@FindBy(xpath="//h5[.='Appropriateness']/..//input[@class='listItem']")
	public WebElement rejectReason1;
	
	@FindBy(xpath="//h5[.='Content details']/..//input[@class='listItem']")
	public WebElement rejectReason2;
	
	@FindBy(xpath="//h5[.='Usability']/..//input[@class='listItem']")
	public WebElement rejectReason3;
	
	//Added locator for fetching list of courses up for review
	@FindBy(xpath="//div[@class='UpReviewHeader']")
	public List<WebElement> searchCoursesUpForReview;
	
	@FindBy(xpath="//div[@class='UpReviewHeader']")
	public WebElement searchCoursesUpForReviewE;
	
	@FindBy(xpath="//span[contains(text(),'Publish')]")
	public WebElement publishCourseButton;
	
	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> checkbox;
	
	@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public List<WebElement> searchPublishedCourses;
	
	@FindBy(xpath="//a[contains(text(),'Library')]")
	public WebElement headerLibrary;
	
	//Elements for upload documents -
	
		@FindBy(xpath="//input[@type='file']")
		public WebElement browseButton;
		
		@FindBy(xpath="//div[@class='qq-uploader-selector qq-uploader custom-qq-uploader']")
		public WebElement clickUploadSection;
		
		@FindBy(xpath="//label[.='URL']/following-sibling::div//following-sibling::input")
		public WebElement enterUrl;
		
		@FindBy(xpath="//button[.='Upload']")
		public WebElement UploadButton;

		@FindBy(xpath="//input[@id='name']")
		public WebElement contentMp4Title;
		
		@FindBy(xpath="//textarea[@id='description']")
		public WebElement contentMp4Desc;

		@FindBy(xpath="//input[@placeholder='Add a tag']")
		public WebElement contentKeywords;
		
		@FindBy(xpath="//input[@id='searchMyImageAssets']")
		public WebElement searchUploadImage;
		
		@FindBy(xpath="//input[@id='searchMyImageAssets']/..//i[@class='circular search link icon inverted']")
		public WebElement clickImageSearch;
		
		@FindBy(xpath="(//div[@class='ui image']//img[@data_id='do_21252875847904460811925'])[1]")
		public WebElement checkContentIcon;
		
		@FindBy(xpath="//input[@name='concepts']")
		public WebElement clickConcepts;
		
		@FindBy(xpath="//a[.='Artificial_Intelligence']")
		public WebElement selectConcept1;
		
		@FindBy(xpath="//a[.='Deep_Learning']")
		public WebElement selectConcept2;
		
		@FindBy(xpath="//a[.='Perceptron']")
		public WebElement selectSubConcept1;
		
		@FindBy(xpath="//a[.='RELU']")
		public WebElement selectSubConcept2;
		
		@FindBy(xpath="//a[.='Softmax']")
		public WebElement selectSubConcept3;
		
		@FindBy(xpath="(//a[.='Done'])[2]")
		public WebElement doneButton;
		
		@FindBy(xpath="//div[.='no-results']")
		public WebElement noResults;
		
		@FindBy(xpath="//button[contains(text(),'Publish')]")
		public WebElement popupPublishButton;
		
		@FindBy(xpath="//input[@id='treePicker']")
		public WebElement selectConcept;
		
		@FindBy(xpath="//div[@id='conceptSelector_treePicker']//input[@placeholder='Search']")
		public WebElement searchConcept;
		
		@FindBy(xpath="//a[contains(text(),'Choose All')]")
		public WebElement conceptChooseAll;
		
		@FindBy(xpath="//a[contains(text(),'Done')]")
		public WebElement conceptDoneButton;
		
		@FindBy(xpath="//sui-select[@id='resourceType']")
		public WebElement clickResourceType;
		
		@FindBy(xpath="//sui-select-option[@class='item']//span[.='Study material']")
		public WebElement selectResouceType;
		
		@FindBy(xpath="//div[@class='content-title-container row custom-row-1']/label")
		public WebElement untitledCollection;
		
		@FindBy(xpath="//i[@class='fa fa-picture-o custom-menu-icon']")
		public WebElement addImageIcon;
		
		@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_21252947427956326412231']")
		public WebElement contentResourceIcon;
		
		@FindBy(xpath="//button[contains(text(),'Close')]")
		public WebElement closeButton;
		
		//@FindBy(xpath="//button[contains(text(),'PUBLISH')]")
		@FindBy(xpath="//span[contains(text(),'Publish')]")
		public WebElement publishCourse;
		
		@FindBy(xpath="//button[contains(text(),'PUBLISH')]")
		//@FindBy(xpath="//span[contains(text(),'Publish')]")
		public WebElement publishResource;
		
		//@FindBy(xpath="//textarea[@id='review-comments']")
		@FindBy(xpath="//h5[.='Comments']/..//textarea")
		public WebElement reviewComments;
		
		//@FindBy(xpath="//div[@class='actions footer']/..//button[.='Request changes']")
		//@FindBy(xpath="(//div[@id='review-footer']/..//button[.='Request changes'])[2]")
		@FindBy(xpath="//div[@class='actions footer']/..//button[.='Request changes']")
		public WebElement requestChangesButton;
		
		@FindBy(xpath="//i[@id='stage']")
		public WebElement addSlide ;
		
		@FindBy(xpath="//i[@id='shape']")
		public WebElement addShape  ;
		
		@FindBy(xpath="//div[@class='menu transition visible']/a[1]")
		public WebElement addTriangle  ;
		
		@FindBy(xpath="//i[@id='image']")
		public WebElement addImage  ;
		
		@FindBy(xpath="//i[@id='audio']")
		public WebElement addAudio  ;
		
		@FindBy(xpath="//a[@data-content='Add Hotspot']")
		public WebElement addHotspot  ;
		
		@FindBy(xpath="//i[@id='scribblepad']")
		public WebElement addScribblepad  ;
		
		@FindBy(xpath="//i[@id='activitybrowser']")
		public WebElement addActivity  ;
		
		@FindBy(xpath="//input[@placeholder='Search activity']")
		public WebElement searchActivity  ;
		
		@FindBy(xpath="(//i[@class='dropdown icon'])[6]")
		public WebElement categoryType  ;
		
		@FindBy(xpath="//div[text()='core']")
		public WebElement typeCore  ;
		
		@FindBy(xpath="//div[contains(text(),'Triangles- Introduction')]")
		public WebElement triangleIntroduction  ;
		
		@FindBy(xpath="//div[contains(text(),'Math')]")
		public WebElement mathText  ;
		
		@FindBy(xpath="(//button[text()='Add'])[2]")
		public WebElement addButtonInActivity   ;
		
		@FindBy(xpath="//i[@id='videoPlugin']")
		public WebElement addVideo  ;
		
		@FindBy(xpath="//input[@placeholder='Paste video url here...']")
		public WebElement pasteVideoUrl  ;
		
		@FindBy(xpath="//div[text()='Go']")
		public WebElement goButton  ;
		
		@FindBy(xpath="//button[text()='Add To Lesson']")
		public WebElement addToLesson  ;
		
		@FindBy(xpath="//i[@id='question-set']")
		public WebElement addQuestionSet  ;
		
		@FindBy(xpath="(//input[@type='checkbox'])[6]")
		public WebElement questionCheckbox  ;
		
		@FindBy(xpath="//button[contains(text(),'Next')]")
		public WebElement nextButton  ;
		
		@FindBy(xpath="//input[@placeholder='Question Set Title']")
		public WebElement questionSetTitle  ;
		
		@FindBy(xpath="(//button[contains(text(),'Add')])[3]")
		public WebElement addbutton  ;
		
		@FindBy(xpath="//button[contains(text(),'Close')]")
		public WebElement closeButtonMsg ;
		
		@FindBy(xpath="//button[@class='ui blue button ng-binding']")
		public WebElement uploadAndUseButton ;
		
		@FindBy(xpath="//label[@for='ccByContribution1']")
		public WebElement yesRadioButton ;
		
		@FindBy(xpath="//input[@id='assetfile']")
		public WebElement chooseFileButton ;
		
		@FindBy(xpath="//button[@class='ui blue button submit button']")
		public WebElement uploadAndUseButtonRight ;
		
		@FindBy(xpath="//i[@class='huge upload icon']")
		public WebElement uploadAudioIcon ;
		
		//@FindBy(xpath="//i[@class='remove icon custom-cursor']")
		@FindBy(xpath="//i[@class='remove icon custom-cursor']")
		public WebElement closePage  ;
		
		@FindBy(xpath="(//span[@class='sliderCardHeading text-cencapitalize'])[1]")
		public WebElement createdResorce  ;
		
		@FindBy(xpath="(//div[@class='ui image'])[2]")
		public WebElement img2;
		
		@FindBy(xpath="//div[@class='ui image']")
		public WebElement img1;
		
		@FindBy(xpath="//span[@class='ng-scope']")
		public WebElement editdetailslink;
		
		@FindBy(xpath="//input[@placeholder='Enter title for Book']")
		public WebElement untitledName;
		
		@FindBy(xpath="//textarea[@id='description']")
		public WebElement untitledDescription;
		
		@FindBy(xpath="//input[@placeholder='Enter title for unit']")
		public WebElement untitledUnitName;
		
		@FindBy(xpath="(//input[@class='checkBox'])[1]")
		public WebElement selectResourceN;
		
		@FindBy(xpath="//div[.='Class 3']")
		public WebElement selectClass3;
		
		@FindBy(xpath="//div[.=' Limited sharing']")
		public WebElement limitedsharing;
		
		@FindBy(xpath="//div[@class='ui pointing dropdown icon button']")
		public WebElement dropdownlimitedsharing;
		
		@FindBy(xpath="//a[.=' Limited Publishing ']")
		public WebElement limitedPublish;
		
		@FindBy(xpath="//a[@class='ui black right ribbon label']")
		public WebElement limitedPublishedContent;
		
		@FindBy(id="_selectyear")
		public WebElement selectYear;
		
		@FindBy(xpath="//option[@data-value='2018']")
		public WebElement select2018;
		
		@FindBy(xpath="(//input[@placeholder='Enter title for Book'])[2]")
		public WebElement untitledNameC;
		
		//for uploading audio updated on 14 Sep	
		@FindBy(xpath="(//div[@class='audioitem infopopover'])[1]")
		public WebElement audio1;

		//added on 16 Sep
		@FindBy(xpath="//button[contains(text(),'Create question')]")
		public WebElement createQuestion;
		
		@FindBy(xpath="//a[.='Multiple Choice Question']/../../div[3]/div")
		//@FindBy(xpath="(//div[@class='ui small primary button'])[2]")
		public WebElement selectMCQTemplate;
		
		@FindBy(xpath="//a[.='Match The Following']/../../div[3]/div")
		//@FindBy(xpath="(//div[@class='ui small primary button'])[3]")
		public WebElement selectMTFTemplate;
		
		@FindBy(xpath="//a[.='Fill in the Blanks']/../../div[3]/div")
		//@FindBy(xpath="(//div[@class='ui small primary button'])[1]")
		public WebElement selectFITBTemplate;

		@FindBy(xpath="//iframe[@frameborder='0']")
		public WebElement writeQuestion ;

		//@FindBy(xpath="(//input[@placeholder='Enter answer'])[1]")
		@FindBy(xpath="//div[@id='mcqoptions_0']")
		public WebElement inputAnswer1 ;

		@FindBy(xpath="//div[@id='mcqoptions_1']")
		public WebElement inputAnswer2 ;

		@FindBy(xpath="//button[.='Add answer']")
		public WebElement addAnswer ;

		//@FindBy(xpath="(//label[contains(text(),'Mark as right answer')])[1]")
		@FindBy(xpath="//input[@id='0']")
		public WebElement markAsRightAnswer ;

		@FindBy(xpath="//i[@class='icon undo ui right-floated replayIcon']")
		public WebElement previewRefreshIcon ;

		@FindBy(xpath="//div[@class='ps-body']")
		public WebElement nextArrowPreview  ;

		@FindBy(xpath="(//img[@class='ui centered tiny image select-template'])[1]")
		public WebElement selectLayout   ;

		@FindBy(xpath="(//div[.='Select Medium'])[2]")
		public WebElement mediumInQuestion ;



		@FindBy(xpath="(//div[.='Select Level'])[2]")
		public WebElement levelInQuestion ;

		@FindBy(xpath="(//div[.='EASY'])[2]")
		public WebElement selectEasy ;

		@FindBy(xpath="//div[.='Select Grade']")
		public WebElement gradeLevelInQuestion ;

		@FindBy(xpath="(//div[.='Class 4'])[3]")
		public WebElement selectClass4 ;

		@FindBy(xpath="(//div[.='Select Subject'])[2]")
		public WebElement subjectInQuestion ;

		@FindBy(xpath="(//div[.='Mathematics'])[2]")
		public WebElement selectMathematics ;
		
		

		@FindBy(xpath="(//div[.='Select Board'])[2]")
		public WebElement boardInQuestion ;



		@FindBy(xpath="//input[@placeholder='Enter the Max Score']")
		public WebElement maxScore  ;

		@FindBy(xpath="//input[@id='questionMetaDataTemplate-concept']")
		public WebElement Concepts ;

		@FindBy(xpath="(//button[@id='save-question-button'])[2]")
		public WebElement submitButtonInQuestion  ;

		@FindBy(xpath="//button[@id='add-more-ques-button']")
		public WebElement addMoreQuestion   ;

		@FindBy(xpath="(//input[@id='mtf-optionLHS'])[1]")
		public WebElement enterAnswer1 ;

		@FindBy(xpath="(//input[@id='mtf-optionRHS-input'])[1]")
		public WebElement enterAnswer2 ;

		@FindBy(xpath="(//input[@id='mtf-optionLHS'])[2]")
		public WebElement enterAnswer3 ;

		@FindBy(xpath="(//input[@id='mtf-optionRHS-input'])[2]")
		public WebElement enterAnswer4 ;

		@FindBy(xpath="(//input[@id='mtf-optionLHS'])[3]")
		public WebElement enterAnswer5 ;

		@FindBy(xpath="(//input[@id='mtf-optionRHS-input'])[3]")
		public WebElement enterAnswer6 ;

		@FindBy(xpath="//input[@id='ans-field1']")
		public WebElement answerFITB ;

		@FindBy(xpath="//li[@class='ps-action-list__item']")
		public WebElement nextInPreview ;

		@FindBy(xpath="(//div[@class='option-text-container '])[1]")
		public WebElement answerMCQ  ;

		@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
		//@FindBy(xpath="//div[@class='form-group segment textBoxDiv questionTextBox']//textarea")
		public WebElement enterTheQuestion;

		@FindBy(xpath="//button[@id='next-button']")
		public WebElement createQueNext;

		@FindBy(xpath="(//div[.='English'])[3]")
		public WebElement selectEnglishQues;

		@FindBy(xpath="(//div[.='CBSE'])[2]")
		public WebElement selectCBSEQue;

		@FindBy(xpath="//input[@placeholder='Enter the Title']")
		public WebElement enterTheTitleQues;
		
		@FindBy(xpath="//a[.=' Published ']")
		public WebElement published ;
		
		@FindBy(xpath="//a[.=' Drafts ']")
		public WebElement drafts ;
		
		@FindBy(xpath="//i[@class='trash large icon']")
		public List<WebElement> deleteButtonAll ;
		
		@FindBy(xpath="//button[.='Yes']")
		public WebElement yesButtonPopup ;
		
		@FindBy(xpath="(//i[@class='trash large icon'])[1]")
		public WebElement deleteButton ;
		
		@FindBy(xpath="(//i[@class='dropdown icon'])[3]")
		 public WebElement showFilter;
		 
		 @FindBy(xpath="//a[.='APPLY']")
		 public WebElement applyFilter;
		 
		 //@FindBy(xpath="//a[.=' All My Content ']")
		 @FindBy(xpath="//a[@href='/workspace/content/allcontent/1']")
		 public WebElement allMyContent;
		
		 @FindBy(xpath="(//div[.='English'])[4]")
		 public WebElement selectEnglishFITB;
		 
		 @FindBy(xpath="(//button[contains(text(),'Add')])[2]")
		 public WebElement addAnotherQuestion  ;
		 
		 @FindBy(xpath="//iframe[@id='iframeArea']")
		 public WebElement previewFrame ;
		 
		 @FindBy(xpath="//img[@id='org-ekstep-contentrenderer-questionunit-questionComponent-downArwImg']")
		 public WebElement downButtonPreview ;
		 
		 @FindBy(xpath="//div[@class='expand-container ']//p[contains(text(),'days?')]")
		 public WebElement previewContainer;
		 
		 @FindBy(xpath="(//input[@name='filter_search'])[3]")
		 public WebElement searchInActivity;
		 
		 @FindBy(xpath="//i[@data-content='Delete']")
		 public WebElement deleteResource;
		 
		 @FindBy(xpath="//button[.='YES, DELETE']")
		 public WebElement yesDeleteResource;
		 
		 @FindBy(xpath="//i[@class='upload icon custom-icon']")
		 public WebElement uploadNewfile;
		 
		 @FindBy(xpath="//i[@ng-click='fireEvent(stage.ondelete)']")
		 public WebElement deleteSlide;
		 
		 @FindBy(xpath="//button[.='Delete']")
		 public WebElement deleteConfirmationPopup;
		 
		 @FindBy(xpath="//img[@ng-click='fireEvent(stage.getOnClick())']")
		 public List<WebElement> existingSlide;
		 
		 @FindBy(xpath="(//div[.='Urdu'])[4]")
		 public WebElement selectUrdu4 ;

		 @FindBy(xpath="(//div[.='Urdu'])[2]")
		 public WebElement selectUrdu2 ;
}


