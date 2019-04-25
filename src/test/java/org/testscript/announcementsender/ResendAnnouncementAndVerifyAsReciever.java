/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/26/2018

* Purpose: Resend and edit the Announcement and verify announcement sender receives it.

*/
package org.testscript.announcementsender;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResendAnnouncementAndVerifyAsReciever extends BaseTest
{
		
	@Test( groups={"sanity2", "regression1","announcementsender"})
	public void resendAnnouncementAndVerifyAsReciever() throws InterruptedException, Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
	
		
		//Step1.Login as creator.
		userLogin.userLogin(CREATOR);
		
		//Step2.Click on Announcement Dashboard.
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		
		//Step3.Click on resend.
		String resentAnnouncement=creatorAnnouncementPageObj.verifyResendingOfAnnouncement();
		
		//Step4. Logout as Creator
		userLogin.userLogout();
				
		//Step5: Login as Reviewer
		userLogin.userLogin(REVIEWER);
		
		creatorAnnouncementPageObj.verifyReceivedResentAnnouncement(resentAnnouncement);
		
		//Step11. Logout as Creator
		userLogin.userLogout();
	}

}
