package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class DisplayLatestCourse extends BaseTest

{
	//MT done
	@Test(groups= {"publicuser","sanity1","regression2"})
	public void searchCourse() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();

		//Step 1 : Login into Application as Public user	
		userLogin.userLogin(PUBLICUSER1);

		//Step 2 and 3 : Click on courses
		//Search for course
		publicUser.verifyListOfCourse();
	}
}