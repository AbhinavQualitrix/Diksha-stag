package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExplorePage  {
	
	WebDriver driver;
	
	public ExplorePage(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(xpath="(//app-card[@class='pr-20 d-block'])[11]")
	public WebElement clickOnFirstTextBook;
	
	@FindBy(xpath="//i[contains(@class,'plus')]")
	public WebElement clickOnFirstTextBookTOC;
	
	@FindBy(xpath="//span[contains(@class,'fancytree-title')]")
	public WebElement clickOnFirstTextBookTOCUnits;
	
	@FindBy(xpath="//*[contains(text(),'Latest Courses')]/following::div[contains(@class,'ellipsis')][1]")
	public WebElement clickOnFirstLatestCourse;
	
	//Mar 21
	@FindBy(xpath="//*[contains(text(),'Latest')]")
	public WebElement latestCourseViewAllSection;

	@FindBy(xpath="//*[contains(text(),'Latest Courses')]/following::div[contains(@class,'ellipsis')][1]")
	public WebElement validateLatestCourse;
	
	@FindBy(xpath="//span[contains(@class,'fancytree-title')]")
	public List<WebElement> clickOnFirstCourseTOCUnits;
	
	@FindBy(xpath="//app-curriculum-card/following-sibling::div/p")
	public WebElement checkCreatedByInTOCPage;
	
	@FindBy(xpath="//app-curriculum-card/following-sibling::div/p[2]")
	public WebElement checkOrgNameInTOCPage;
	
	@FindBy(xpath="//app-curriculum-card/following-sibling::div/p[3]")
	public WebElement checkEmailIdInTOCPage;
	
	@FindBy(xpath="//app-curriculum-card/following-sibling::div/div/following::p")
	public WebElement checkCreatedOnInTOCPage;
	
	@FindBy(xpath="//app-curriculum-card/following-sibling::div/div/following::p[2]")
	public WebElement checkUpdatedOnInTOCPage;
	
	//Mar 21
	@FindBy(xpath="//*[contains(text(),'content')]/following::button[4]")
	public WebElement submitButtonInCoursePage;
	
	@FindBy(xpath="//*[contains(@class,'fancy-tree-black')]")
	public WebElement clickOnConsumableContent;
}
