package org.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {

	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "(//a[contains(.,'Profile')])[2]")
	public WebElement qBookCreator;

	@FindBy(xpath = "(//a[contains(.,'Profile')])[3]")
	public WebElement profile;

	@FindBy(xpath = "//div[contains(@class,'profile-label-container')]")
	public WebElement profileContainer;

	@FindBy(xpath = "//div[@class='avatar-content']")
	public WebElement profileIcon;

	@FindBy(xpath = "(//div[contains(@class,' mb-15 text-ac')])")
	public WebElement profileUserName;

	@FindBy(xpath = "(//div[contains(@class,' mb-15 text-ac')])/following::div[contains(.,'User ID :')]")
	public WebElement profileUserId;

	@FindBy(xpath = "//span[contains(@class,'dodger-blue basic')]")
	public WebElement assignedUserRole;

	@FindBy(xpath = "(//div[contains(.,'SunbirdQA 1')])[3]")
	public WebElement orgnization;

	@FindBy(xpath = "//a[contains(@routerlink,'dashBoard/organization')]")
	public WebElement dashBoard;

	@FindBy(xpath = "(//a[contains(@class,'item active')])[1]")
	public WebElement firstLink;

	@FindBy(xpath = "//a[contains(@class,'item')]/following::a[contains(.,' QR Code Exception: Summary')]")
	public WebElement secondLink;

	@FindBy(xpath = "//a[@class='item']/following::a[contains(.,' QR Code Exception: Details')]")
	public WebElement thirdLink;

	@FindBy(xpath = "//a[@class='item']/following::a[contains(.,' ETB Creation Status: Summary')]")
	public WebElement fourthLink;

	@FindBy(xpath = "//a[@class='item']/following::a[contains(.,' ETB Creation Status: Details')]")
	public WebElement fifthLink;

	@FindBy(xpath = "//h2[@class='ui small header']")
	public WebElement dikshaReportHeader;

	@FindBy(xpath = "//h2[@class='ui small header']")
	public WebElement qrSummaryHeader;

	@FindBy(xpath = "//h2[@class='ui small header']")
	public WebElement qrDetailsHeader;

	@FindBy(xpath = "//h2[@class='ui small header']")
	public WebElement etbSummaryHeader;

	@FindBy(xpath = "//h2[@class='ui small header']")
	public WebElement etbDetailsHeader;

	@FindBy(xpath = "(//a[contains(.,'Profile')])[2]")
	public WebElement profileName;

	@FindBy(xpath = "(//span[contains(@class,'edit-user-icon')])[1]")
	public WebElement editUserDetails;

	@FindBy(xpath = "(//i[contains(@class,'dropdown icon')])[12]")
	public WebElement dropDown;

	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closeEditIcon;

	@FindBy(xpath = "(//label[contains(.,'Role')])[2]/following::sui-select-option")
	public WebElement courseMentorDropdown;

	@FindBy(xpath = "//button[contains(@class,'sb-btn-primary')]")
	public WebElement saveButton;

	@FindBy(xpath = "//span[contains(.,'Course Mentor')]")
	public WebElement courseMentorOption;

	@FindBy(xpath = "(//i[contains(@class,'delete icon')])[2]")
	public WebElement deleteIcon;

	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closeIcon;

		
		
		@FindBy(xpath="//*[contains(text(),'Select language')]/following::sui-select")
		public WebElement selectlanguage;
		
		@FindBy(xpath="( //sui-select[contains(@valuefield,'value')])[1]")
		public WebElement clickOnLanguageDropdwon;;
		
		@FindBy(xpath="(//sui-select[contains(@valuefield,'value')])[1]")
		public WebElement clickagainEnglish;
		
		@FindBy(xpath="//span[contains(text(),'हिंदी')]")
		public WebElement hindiLanguage;
		
		@FindBy(xpath="(//sui-select-option[contains(.,'اردو')])[1]")
		public WebElement urduLanguage;
		
		@FindBy(xpath="(//sui-select-option[contains(@class,'item')])[1]")
		public WebElement englishLanguage;
		
		@FindBy(xpath="(//div[contains(@class,'sb-card-body')])[2]")
		public WebElement englishContent;
		
		
		
		
		@FindBy(xpath="(//sui-select[contains(@tabindex,'0')])[1]")
		public WebElement selectLanguageInUrdu;
		
		
		//@FindBy(xpath="(//a[contains(text(),' Profile ')])[2]")
		//public WebElement profileLanguage;
		
		
		@FindBy(xpath="//input[contains(@id,'keyword')]")
		public WebElement searchTextBox;
		
		@FindBy(xpath="//div[contains(@class,'sb-card-body')]")
		public WebElement hindiContent;
		
		
		
		
		@FindBy(xpath="//input[contains(@title,'اندر تلاش کریں सभी')]")
		public WebElement searchForUrdu;
		
		@FindBy(xpath="//button[contains(.,'Search')]")
		public WebElement searchButton;
		
		@FindBy(xpath="//button[contains(@title,'اندر تلاش کریں सभी')]")
		public WebElement urduSearchButton;
		
		@FindBy(xpath="(//div[contains(@class,'sb-card-body')])[2]")
		public WebElement urduContent;
		
		
	


	@FindBy(xpath = "//sui-select-option[contains(@class,'item selected')]")
	public WebElement districtName;

	@FindBy(xpath = "(//div[contains(.,'S')])[9]")
	public WebElement sProfileIcon;

	@FindBy(xpath = "//div[contains(@class,'font-w-bold text-ac')]")
	public WebElement selectedDistrict;

	@FindBy(xpath = "(//div[contains(@class,' font-w-bold text-ac')])[2]")
	public WebElement selectedState;

	@FindBy(xpath = "(//i[contains(@class,'dropdown icon')])[4]")
	public WebElement stateDropdown;

	@FindBy(xpath = "(//i[contains(@class,'dropdown icon')])[5]")
	public WebElement districtDropdown;

	@FindBy(xpath = "//sui-select-option[contains(@class,'item selected')]")
	public WebElement stateName;

	@FindBy(xpath = "(//div[contains(.,'District :')])[4]")
	public WebElement district;

	@FindBy(xpath = "(//div[contains(.,'State :')])[4]")
	public WebElement state;

	@FindBy(xpath = "//button[contains(.,'Edit')]")
	public WebElement editButton;
	
	
	@FindBy(xpath="//input[contains(@id,'keyword')]")
	public WebElement searchInUser;
	

	@FindBy(xpath="//div[contains(@style,'text-align')]")
	public WebElement bookCreator;

	

	@FindBy(xpath="//h4[contains(@class,'sb-card-title')]")
	public WebElement textBook;
     
	
	
	@FindBy(xpath="//input[contains(@id,'keyword')]")
	public WebElement searchInAll;
	
	
	
	@FindBy(xpath="//div[contains(@class,'header mb-5')]")
	public WebElement creatorContent;
	
	
	@FindBy(xpath="//h4[contains(@class,'sb-card-title')]")
	public WebElement bookContent;
	
}
