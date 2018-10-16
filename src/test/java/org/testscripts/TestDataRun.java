package org.testscripts;

import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.testdata.TestDataForSunbird;

public class TestDataRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
		
		System.out.println(objListOFTestDataForSunbird.get(0).getCourseName());
		System.out.println(objListOFTestDataForSunbird.get(0).getCourseDescription());
		
		String path1 = System.getProperty("user.dir")+"\\UploadingDocuments\\Upload Document Contents\\";
		System.out.println("Uploaded image : "+path1);
		
		
	}

}
