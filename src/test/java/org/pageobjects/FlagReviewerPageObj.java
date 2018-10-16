/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 06/18/2018

* Purpose: All the reuasble methods of flag reviewer page.
*/
package org.pageobjects;


import java.util.Random;

import org.generic.GenericFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.page.FlagReviewerPage;
import org.page.PublicUserPage;
import org.startup.BaseTest;

public class FlagReviewerPageObj extends BaseTest
{
	FlagReviewerPage flagReviewerpage = PageFactory.initElements(driver, FlagReviewerPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreatorUserPage creatorPage = PageFactory.initElements(driver, CreatorUserPage.class);
	Random rand = new Random();
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public void flaggedUpForReview()
	{	

		//Click a random course from My courses section
		publicUserPage.headerProfile.click();

		/*int randomCourse=rand.nextInt(flagReviewerpage.courseMyCourses1.size());
		System.out.println("clicking on Course no: "+randomCourse+", and size is :"+flagReviewerpage.courseMyCourses1.size());
		//GenericFunctions.waitTillTheElementIsVisibleAndClickable(flagReviewerpage.courseMyCourses1.get(randomCourse));
		String clickCourse=flagReviewerpage.courseMyCourses1.get(randomCourse).getText();
		System.out.println("Course  :"+clickCourse); 	
		flagReviewerpage.courseMyCourses1.get(randomCourse).click();
		GenericFunctions.waitWebDriver(4000);*/

		publicUserPage.searchBar.sendKeys(SEARCH_COURSES);
		publicUserPage.clickSearch.click();
		GenericFunctions.waitWebDriver(3000);
		int randomCourse=rand.nextInt(flagReviewerpage.coursesSearched.size());
		flagReviewerpage.coursesSearched.get(randomCourse).click();
		String getCourseName=flagReviewerpage.clikedCourseContentName.getText();
		GenericFunctions.waitWebDriver(3000);


		//GenericFunctions.waitForElementToAppear(flagReviewerpage.flagIcon);
		flagReviewerpage.flagIcon.click();
		GenericFunctions.waitWebDriver(2000);
		randomReasonForFlag();
		GenericFunctions.waitWebDriver(3000);
		//Search and click on a random Content from Popular Books section
		publicUserPage.headerLibrary.click();
		publicUserPage.searchBar.sendKeys(SEARCH_LIBRARIES);
		GenericFunctions.waitForElementToAppear(flagReviewerpage.popularBooksHeader);
		int randomContent=rand.nextInt(flagReviewerpage.contentsSearched.size());
		flagReviewerpage.contentsSearched.get(randomContent).click();
		String getContentName=flagReviewerpage.clikedCourseContentName.getText();
		GenericFunctions.waitForElementToAppear(flagReviewerpage.flagIcon);
		flagReviewerpage.flagIcon.click();
		GenericFunctions.waitWebDriver(2000);
		randomReasonForFlag();

	}
	public void randomReasonForFlag()
	{
		//Select a random reject reason for a flag
		int randomreason=rand.nextInt(flagReviewerpage.flagReason.size());
		flagReviewerpage.flagReason.get(randomreason).click();
		//Give a random comment for the comment box
		String randcourse = (flagReviewerpage.randomComments[rand.nextInt(flagReviewerpage.randomComments.length)]);
		flagReviewerpage.addComment.sendKeys(randcourse);
		GenericFunctions.waitWebDriver(2000);
		flagReviewerpage.submitButton.click();
	}

	public void flagged_UpforReview()
	{
		publicUserPage.headerProfile.click();
		GenericFunctions.waitForElementToAppear(creatorPage.workSpace);
		creatorPage.workSpace.click();
		GenericFunctions.waitWebDriver(2000);
		flagReviewerpage.flaggedContent.click();	
		System.out.println(driver.getCurrentUrl()+"Reviwer has FLAGGED bucket access");
		GenericFunctions.waitWebDriver(1000);
		flagReviewerpage.upForReview.click();
		GenericFunctions.waitWebDriver(2000);
		System.out.println(driver.getCurrentUrl()+"Reviewer has UP FOR REVIEW bucket access");
	}

	public void genericCourseSearch()
	{
		GenericFunctions.waitForElementToAppear(publicUserPage.headerCourses);
		publicUserPage.headerCourses.click();
		GenericFunctions.waitForElementToAppear(flagReviewerpage.latestCourses);
		int courseSize = flagReviewerpage.courseMy.size();
		int i=0;
		String elementArray[]=new String[courseSize];
		for(WebElement ele:flagReviewerpage.courseMy)
		{
			GenericFunctions.waitWebDriver(2000);
			if(ele.isDisplayed())
			{
				String eleText=ele.getText();
				System.out.println(eleText);
				elementArray[i]=eleText;
				i++;
				GenericFunctions.waitWebDriver(2000);
			}
			else
			{
				flagReviewerpage.myCourseNextuBtton.click();
				GenericFunctions.waitWebDriver(2000);
				elementArray[i]=flagReviewerpage.courseMyFifth.getText();
			}
		}
		
		
		//Adding all the values from the araay to ArrayList except NULL
	//	List<String> values = new ArrayList<String>();
		/*for(String data:elementArray)
		{
			if(data!=null){
				values.add(data);
			}
		}
		
		//Trimming all the null values and adding only Non null values to String array
		String [] trimmedArray= values.toArray(new String[values.size()]);
		for(String data:trimmedArray)
		{
			System.out.println(data+" ");
		}*/
		
		for(String data:elementArray)
		{
			System.out.println(data+" ");
		}
		
		String randomCourseSearch = (elementArray[new Random().nextInt(elementArray.length)]);
		System.out.println(randomCourseSearch);

		//To click on a any random course from the cours
		
		for(int c=0;c<=elementArray.length;c++)
		{
			
			
			
			
		}
		
		try
		{
			publicUserPage.searchBar.clear();
			publicUserPage.searchBar.sendKeys(randomCourseSearch);
			publicUserPage.clickSearch.click();
			GenericFunctions.waitWebDriver(3000);
			if(randomCourseSearch.equalsIgnoreCase(publicUserPage.courseToBeClicked.getText()))
			{
				publicUserPage.courseToBeClicked.click();
				GenericFunctions.waitWebDriver(2000);
				if(flagReviewerpage.flagIcon.isDisplayed())
				{
					GenericFunctions.waitWebDriver(2000);
					flagReviewerpage.flagIcon.click();
					randomReasonForFlag();
					System.out.println("Flagged the Course");
				}
				else
				{
					driver.navigate().back();
					publicUserPage.searchBar.clear();
					
					
				}
			}
			
			/*int randomValue = rand.nextInt(flagReviewerpage.courseList.size()); //Getting a random value that is between 0 and (list's size)-1
			// flagReviewerpage.courseList.get(randomValue).click(); 
			GenericFunctions.waitWebDriver(2000);
			int width = flagReviewerpage.courseList.get(randomValue).getSize().getWidth();
			action.moveToElement(flagReviewerpage.courseList.get(randomValue)).moveByOffset((width/2)-2, 0).click().perform();
*/

		}
		catch(Exception e)
		{
			System.out.println( "exception occured" + e);
		}
		
		
		
		
		/*	Random rand = new Random();
		   string locator = string.Format("//div/div[2]/div[{0}]/input", rand.Next(5)); 
		   // Where 5 is the number of the elements in the list
		   driver.FindElement(By.Xpath(locator)).Click();*/

	}	
	
	
	public void clickCourses()
	{
		GenericFunctions.waitForElementToAppear(publicUserPage.headerCourses);
		publicUserPage.headerCourses.click();
		GenericFunctions.waitForElementToAppear(flagReviewerpage.latestCourses);
		//int c=0;
		
		GenericFunctions.waitForElementToAppear(flagReviewerpage.latestCourses);
		int courseSize = flagReviewerpage.courseMy.size();
		int i=0;
		String elementArray[]=new String[courseSize];
		for(WebElement ele:flagReviewerpage.courseMy)
		{
			
		
		}
		
	}


}
