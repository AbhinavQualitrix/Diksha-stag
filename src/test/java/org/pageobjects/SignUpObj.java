/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 06/15/2018

* Purpose: All the reusable methods of signup page.
*/
package org.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.page.SignUp;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;


public class SignUpObj extends BaseTest
{ 
	static Logger log = Logger.getLogger(SignUpObj.class.getName());

	public void signUpUser() throws InterruptedException
	{

		List <TestDataForSunbird> objListOFTestDataForSunbird=null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
		int count = objListOFTestDataForSunbird.size();

		for(int i=0; i<count; i++){
			SignUp objSignUp=PageFactory.initElements(driver, SignUp.class);
			objSignUp.Sbtn.click();
			objSignUp.Un.sendKeys(objListOFTestDataForSunbird.get(i).getUsername());
			objSignUp.Pw.sendKeys(objListOFTestDataForSunbird.get(i).getPassword());
			objSignUp.FName.sendKeys(objListOFTestDataForSunbird.get(i).getFirstName());
			objSignUp.LName.sendKeys(objListOFTestDataForSunbird.get(i).getLastName());
			objSignUp.Phone.sendKeys(objListOFTestDataForSunbird.get(i).getPhone());
			objSignUp.Email.sendKeys(objListOFTestDataForSunbird.get(i).getEmail());
			GenericFunctions generic=PageFactory.initElements(driver, GenericFunctions.class);
			String locator = "//i[@class='dropdown icon']";
			driver.findElement(By.xpath(locator)).click();
			String locDrop ="//div[@class='menu transition visible']//div[@class='item']";
			generic.selectValueFromDropdown(driver, locDrop, "Kannada");

		}
	}

	public void userLogin(String userRole) throws InterruptedException
    {
          UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
          List <TestDataForSunbird> objListOFTestDataForSunbird=null;
          objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcredentials");
          try{
                orgUploadPage.Loginbutton.click();
                if(userRole.equalsIgnoreCase("ADMIN")){   
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(5).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(5).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(5).getPassword());
                      log.info("Logged in as"+userRole+"with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(5).getPassword());
                }
                else if(userRole.equalsIgnoreCase("CREATOR")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(0).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(0).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(0).getPassword());
                }
                else if(userRole.equalsIgnoreCase("REVIEWER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(1).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(1).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(1).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(1).getPassword());
                }
          
                else if(userRole.equalsIgnoreCase("REVIEWERD")){
                	orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(24).getUsername());
                	orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(24).getPassword());
                	log.info("UN"+objListOFTestDataForSunbird.get(24).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(24).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTOR")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(2).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(2).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(2).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(2).getPassword());
                }
                else if(userRole.equalsIgnoreCase("FLAGREVIEWER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(4).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(4).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(4).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(4).getPassword());
                }     
                else if(userRole.equalsIgnoreCase("PUBLICUSER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(6).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(6).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(6).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(6).getPassword());
                }
                else if(userRole.equalsIgnoreCase("PUBLICUSER1"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(9).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(9).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(9).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(9).getPassword());
                }
                else if(userRole.equalsIgnoreCase("PUBLICUSERD"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(21).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(21).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(21).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(21).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTORD"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(22).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(22).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(22).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(22).getPassword());
                }
               
                else if(userRole.equalsIgnoreCase("SUBORGMENTOR"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(25).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(25).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(25).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(25).getPassword());
                }
                else if(userRole.equalsIgnoreCase("BOOKREVIEWER"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(10).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(10).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(10).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(10).getPassword());
                }
                
                else if(userRole.equalsIgnoreCase("AUTOCREATOR"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(12).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(12).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(10).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(10).getPassword());
                }
                
                else{
                      log.error("User info not found");
                }
                //orgUploadPage.clickLogin.click();
                orgUploadPage.clickLogin1.click();
          }
          catch(Exception e)
          {
                e.getMessage();
          }
    }
	
	public void userLoginDiksha(String userRole) throws InterruptedException
    {
          UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
          List <TestDataForSunbird> objListOFTestDataForSunbird=null;
          objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcredentials");
          try{
        	    //orgUploadPage.getStarted.click();
        	    //GenericFunctions.waitWebDriver(1000);
                orgUploadPage.Loginbutton.click();
                GenericFunctions.waitWebDriver(1000);
        		//GenericFunctions.switchToNewWindow();
                if(userRole.equalsIgnoreCase("ADMIN")){   
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(5).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(5).getPassword());
                      System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(5).getPassword());
                      log.info("Logged in as"+userRole+"with UN:"+objListOFTestDataForSunbird.get(5).getUsername()+" and PW:"+
                                  objListOFTestDataForSunbird.get(5).getPassword());
                }
                else if(userRole.equalsIgnoreCase("CREATOR")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(0).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(0).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(0).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(0).getPassword());
                }
                else if(userRole.equalsIgnoreCase("REVIEWER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(19).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(19).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(1).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(1).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTOR")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(3).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(3).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(2).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(2).getPassword());
                }
                else if(userRole.equalsIgnoreCase("FLAGREVIEWER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(4).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(4).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(4).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(4).getPassword());
                }     
                else if(userRole.equalsIgnoreCase("PUBLICUSER")){
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(6).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(6).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(6).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(6).getPassword());
                }
                else if(userRole.equalsIgnoreCase("PUBLICUSER1"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(9).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(9).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(9).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(9).getPassword());
                }
                else if(userRole.equalsIgnoreCase("PUBLICUSERD"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(21).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(21).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(21).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(21).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTORD"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(22).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(22).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(22).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(22).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTORD1"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(23).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(23).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(23).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(23).getPassword());
                }
                else if(userRole.equalsIgnoreCase("REVIEWER1"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(24).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(24).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(24).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(24).getPassword());
                }
                else if(userRole.equalsIgnoreCase("SUBORGMENTOR"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(25).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(25).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(25).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(25).getPassword());
                }
                else if(userRole.equalsIgnoreCase("BOOKREVIEWER"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(10).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(10).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(10).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(10).getPassword());
                }
                
                else if(userRole.equalsIgnoreCase("AUTOCREATOR"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(12).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(12).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(10).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(10).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTOR_S"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(24).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(24).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(24).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(24).getPassword());
                }
                else if(userRole.equalsIgnoreCase("REVIEWER_S"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(25).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(25).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(25).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(25).getPassword());
                }
                else if(userRole.equalsIgnoreCase("PUBLICUSER_S"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(23).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(23).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(23).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(23).getPassword());
                }
                else if(userRole.equalsIgnoreCase("MENTORS_S"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(26).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(26).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(26).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(26).getPassword());
                }
                else if(userRole.equalsIgnoreCase("PUBLICUSERS_S"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(27).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(27).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(27).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(27).getPassword());
                }
                else if(userRole.equalsIgnoreCase("CREATOR_S"))
                {
                      orgUploadPage.username.sendKeys(objListOFTestDataForSunbird.get(28).getUsername());
                      orgUploadPage.password.sendKeys(objListOFTestDataForSunbird.get(28).getPassword());
                log.info("UN"+objListOFTestDataForSunbird.get(28).getUsername()+"/nPW"+objListOFTestDataForSunbird.get(28).getPassword());
                }
                else{
                      log.error("User info not found");
                }
                //orgUploadPage.clickLogin.click();
                GenericFunctions.waitWebDriver(1000);
                orgUploadPage.clickLogin1.click();
                System.out.println("User Logged in");
          }
          catch(Exception e)
          {
                e.getMessage();
          }
    }
	
	
	
	


	public void userLogout()throws Exception{
		try{
			GenericFunctions.waitWebDriver(3500);
			UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
			orgUploadPage.logout.click();
			GenericFunctions.waitWebDriver(1500);
			System.out.println("User Logout");
			
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			log.error("User could not be logged out");
		}

	}
}


