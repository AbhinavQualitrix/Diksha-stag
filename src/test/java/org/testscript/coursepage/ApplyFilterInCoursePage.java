package org.testscript.coursepage;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CoursePageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.startup.IAutoConst;
import org.testng.annotations.Test;

public class ApplyFilterInCoursePage extends BaseTest
{
	//Sun-2065
	@Test(groups= {"regression1"})
	public void applyFilterInCoursePage() throws Exception
	{
		
		
		
		CoursePageObj courseobj=new CoursePageObj();
		SignUpPageObj signupObj = new SignUpPageObj();
		
		
		signupObj.userLogin(CREATOR);
		courseobj.ApplyFilterCoursePage();
		
	}
	

}
