package org.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspacePage 
{
	//WebDriver driver;

	//Properties properties =new Properties();

	/*
	public WorkspacePage(WebDriver driver){
		this.driver = driver;
	}



	public Properties getNewFeatureObjRepo() throws Exception
	{
		InputStream input= new FileInputStream(new File(System.getProperty("user.dir")+"newFeatureObjRepo.properties"));
		properties.load(input);

		//return properties;


		String prope = properties.getProperty("termsAndConditionsPageLabel");
		@FindBy(xpath="prope")
		public WebElement 
	}

	 */

	@FindBy(xpath="//div/img[contains(@src,'logo.png')]/following::div[contains(.,'Terms and Conditions')]")
	public WebElement termsAndCoditionLabel;


	@FindBy(xpath="//span[contains(.,'I agree to the terms and conditions of use')]")
	public WebElement termsAndConditionsText;

	@FindBy(xpath="//span[contains(.,'I agree to the terms and conditions of use')]/preceding-sibling::input")
	public WebElement termsAndConditionsCheckBox;

	//@FindBy()

	@FindBy(xpath="//button[contains(.,'Continue')]")
	public WebElement continueButton;


	@FindBy(xpath="//label[contains(text(),'OWNER')]/..//div[@class='item active selected']")
	public WebElement selectedCreatedForType;

	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span[contains(.,'ownershipType')]")
	public WebElement ownershipContentInAppUploads;


	@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[contains(@class,'item')][2]")
	public WebElement selectcreatedByType;


	@FindBy(xpath="//label[contains(text(),'OWNER')]/..//div[@class='item active']")
	public WebElement createdByType;

	/*@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[@class='text']")
	public WebElement selectedCreatedForType;*/

	@FindBy(xpath="//label[contains(.,'OWNER')]/..//input")
	public WebElement clikcOwnerTypeToEdit;

	@FindBy(xpath="//a[contains(@class,'black right ribbon')]")
	public List<WebElement> getContentNameFromRS;

	@FindBy(xpath="//a[text()='Next']")
	public WebElement NextButton;

	@FindBy(xpath="//a[text()='10']")
	public WebElement Page10InReviewSubmission;	

	@FindBy(xpath="//div[contains(@class,'content-detail') and contains(text(),'Ownership')]")
	public WebElement verifyOwnershipInContent;

	@FindBy(xpath="//div[@class='ui image']")
	public WebElement contentCardInDraft;

	@FindBy(xpath="//label[.='OWNER']/following::div[@class='text']")
	public WebElement selectedOwnershipTypeValue;

	@FindBy(xpath="//label[contains(.,'OWNER')]/..//input/following::div")
	public WebElement DefaultValueOfOwnershipTypeDdl;

	@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[contains(@class,'item')][1]")
	public WebElement selectcreatedForType;

	@FindBy(xpath="//div[@class='header']//i[@class='close link icon']")
	public WebElement closeIconInEditDetails;

	@FindBy(xpath="//tr/following::h5")
	public WebElement contentInAllMyContent;

	@FindBy(xpath="//div//span[contains(.,'Content Information')]/following::a[contains(.,'View Credits')]")
	public WebElement viewCreditsLink;

	@FindBy(xpath="//div/div[contains(.,'Creators')]/following::div")
	public WebElement creators;

	@FindBy(xpath="//div/div[contains(.,'Contributors')]/following::div")
	public WebElement contributors;

	@FindBy(xpath="//td/b[contains(.,'Owner')]/following::td[2]")
	public WebElement verifyOwnershipValueInCourse;	

	@FindBy(xpath="//span[.='View Details']/following::i[1]")
	public WebElement closeIconViewDetails;

	@FindBy(xpath="//h4[contains(.,'Open for enrollment')]/..//button[contains(.,'View All')]")
	public WebElement openForEnrollmentViewAll;

	@FindBy(xpath="//h4[contains(.,'Textbooks')]/..//button[contains(.,'View All')]")
	public WebElement textbooksViewAll;

	@FindBy(xpath="//div[contains(@class,'sb-card-label')]")
	//@FindBy(xpath="//div[contains(@class,'label tiny right')]")
	public List<WebElement> tinyBookLabel;

	@FindBy(xpath="//i[contains(@class,'remove icon')]")
	public  WebElement clearSearchIcon;

	@FindBy(xpath="//div[@class='UpReviewSubHeader']")
	public List<WebElement> contentTypeAndTimeInAllMyContent;

	@FindBy(xpath="//p[@class='iziToast-message slideIn']")
	public WebElement validationMsgOnInvalidUrl;

	@FindBy(xpath="//h4[contains(.,'My Courses')]/following::app-card//h4")
	public WebElement contentFromMyCourses;

	@FindBy(xpath="//span[contains(.,'TAKE NOTE')]")
	public WebElement takeNote;

	@FindBy(xpath="//input[@placeholder='Title']")
	public WebElement notesTitle;

	@FindBy(xpath="//textarea[@placeholder='Description']")
	public WebElement notesDescription;

	@FindBy(xpath="//button[contains(.,'CLEAR')]")
	public WebElement clearNotes;

	@FindBy(xpath="//span[contains(.,'Auto Content')]/following::i[@class='trash large icon']")
	public WebElement uploadContentDeleteIcon;

	@FindBy(xpath="(//i[@class='trash large icon'])")
	public List<WebElement> deleteIcon;







	@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement clickContentFromBucket;

	@FindBy(xpath="//a[contains(.,'Workspace ')]")
	public WebElement workspace;

	@FindBy(xpath="//a[contains(.,'Course Batches')]")
	public WebElement courseBatches;

	@FindBy(xpath="//a[contains(.,'Created by me')]")
	public WebElement createdByMe;

	@FindBy(xpath="//a[contains(.,'Assigned to me')]")
	public WebElement assignedToMe;

	@FindBy(xpath="(//div[contains(@class,'ui fluid image')])[1]")
	public WebElement ongoingCourse1;

	@FindBy(xpath="(//div[contains(@class,'ui fluid image')])[9]")
	public WebElement upcomingCourse1;	

	@FindBy(xpath="((//div[contains(@class,'ui fluid image')])[16])")
	public WebElement expiredCourse1;	

	@FindBy(xpath="(//button[contains(.,'Update')]")
	public WebElement updateButton;	


	@FindBy(xpath="//h4[contains(.,'Ongoing Courses')]")
	public WebElement ongoingCourse;

	@FindBy(xpath="//h4[contains(.,'Upcoming Courses')]") 
	public WebElement upcomingCourse;


	@FindBy(xpath="//h4[contains(.,'Expired Courses')]")
	public WebElement expiredCourse;


	@FindBy(xpath="//button[contains(.,'View All')]")
	public WebElement viewAll;

	@FindBy(xpath="(//button[contains(.,'View All')])[2]")
	public WebElement viewAllUpcoming;

	@FindBy(xpath="(//button[contains(.,'View All')])[3]")
	public WebElement viewAllExpired;

	@FindBy(xpath="//h5[contains(@class,'ui right floated basic icon circular button')]")
	public WebElement closeIconViewAll;

	@FindBy(xpath="//a[contains(.,'1')]")
	public WebElement pagination1;

	@FindBy(xpath="( //i[contains(@class,'dropdown icon')])[4]")
	public WebElement searchState;


	@FindBy(xpath="//div[contains(text(),'State (Uttar Pradesh)')]")
	public List<WebElement> stateElement;

	@FindBy(xpath="(//span[contains(@class,'ng-scope')])[1]")
	public WebElement editLink;

	@FindBy(xpath="  //button[contains(text(),'Save')]")
	public WebElement saveButton;

	@FindBy(xpath="//i[contains(@class,'close link icon')]")
	public WebElement close;

	@FindBy(xpath="//div[contains(@data-content,'Send for review')]")
	public WebElement shareForReview;


	@FindBy(xpath="//i[contains(@class,'my-icon file text outline icon ')]")
	public WebElement bookCreate;

	@FindBy(xpath="//div[contains(.,' Create Book ')]//input")
	public WebElement bookName;

	@FindBy(xpath="//button[.='Use Editor']")
	public WebElement useEditorBtn;




	@FindBy(xpath="//button[contains(.,' Start creating ')]")
	public WebElement startCreate;


	@FindBy(xpath="(//button[contains(@class,'ui basic button text-transform-none')])[2]")
	public WebElement newChildBtn;

	@FindBy(xpath="(//button[contains(@class,'ui basic button text-transform-none')])[2]")
	public WebElement nameField;

	@FindBy(xpath="//strong[contains(text(),'Find & Select Resources')]")
	public WebElement findSelectActivities;	

	@FindBy(xpath="(//div[@class='facetList ng-scope'][1]//div/div[1])[3]")
	public WebElement selectResource;


	@FindBy(xpath="//i[contains(@class,'long arrow right medium icon right floated blueColor popup-item')]")
	public WebElement previewSymbol;

	@FindBy(xpath="//img[contains(@class,'preview-play-image')]")
	public WebElement playBtn;
	
	@FindBy(xpath="//i[contains(@class,'remove icon custom-cursor')]")
	public WebElement closeBtn;
}
