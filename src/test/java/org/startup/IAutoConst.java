package org.startup;

public interface IAutoConst {

	//User Roles
	String PUBLICUSER="PUBLICUSER";
	String ADMIN="ADMIN";
	String CREATOR="CREATOR";
	String REVIEWER="REVIEWER";
	String FLAGREVIEWER="FLAGREVIEWER";
	String MENTOR="MENTOR";
	String XPATH="XPATH";
	String PUBLICUSER1="PUBLICUSER1";
	String BOOKREVIEWER="BOOKREVIEWER";
	String AUTOCREATOR="AUTOCREATOR";
	String ORGADMIND="ORGADMIND";
	String PUBLICUSERD="PUBLICUSERD";
	String MENTORD="MENTORD";
	String MENTORD1="MENTORD1";
	String REVIEWER1="REVIEWER1";
	String SUBORGMENTOR="SUBORGMENTOR";
	String MENTOR_S="MENTOR_S";
	String REVIEWER_S="REVIEWER_S";
	String PUBLICUSER_S="PUBLICUSER_S";
	String MENTORS_S="MENTORS_S";
	String PUBLICUSERS_S="PUBLICUSERS_S";
	String CREATOR_S="CREATOR_S";

	//Driver values
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VAL="./Drivers/chromedriver";
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VAL="./Drivers/geckodriver.exe";
	String APP_URL="https://staging.ntp.net.in";
	String AUTO_APP_URL="http://qatestautomation.centralus.cloudapp.azure.com";

	
	//Upload documents name
	String IMAGE="images1.jpg";
	String UPLOAD_ROOT_ORG="Test_Data_Sample_Organizations-1.csv";
	String UPLOAD_USERS_ROOT_ORG="Sample_Users (44).csv";
	String UPLOAD_SUB_ORG="Test_Data_Sample_Sub_Organizations-1.csv";
	String UPLOAD_USERS_SUB_ORG="Sample_Users (45).csv";
	String FILTER_CREATION="Creation";
	String FILTER_CONSUMPTION="Consumption";
	String A_HOME_URL="https://staging.ntp.net.in/home";
	String SEARCH_COURSE="Course";
	String SEARCH_LIBRARY="Library";
	String SEARCH_COURSES="Courses";
	String SEARCH_LIBRARIES="content";	
	String[] searchInput = new String[]{"Book","Story","Upload content","Collections","lesson plan"};
	String UPLOAD_PROFILE_PIC="C:\\Users\\TEJAS46\\Pictures\\motogp.png";
	String[] SEARCH_USERS=new String[]{"mentor","admin","public","creator"};
	String[] SEARCH_ORG=new String[]{"Org","Root Org"};
	String SUMMARY_EDIT ="Profile Summary is edited";
	String EXP_OCCUPATION="Test Occupation";
	String EXP_DESIGNATION="Test Designation";
	String EXP_ORG="Test Organization";
	String AUDIO="SampleAudio_0.4mb.mp3";
	
	String[] ADDRESS=new String[]{"Test #15","Test Vasanthnagar","Test Bangalore","Test Karnataka","Test India","Test 560035"};
	String ENDORSE_USER="TestFlagReviewer  N";
	String BOOK="book";
	String COURSE="Course";
	String RESOURCE="resource";
	String COLLECTION="collection";
	String LESSONPLAN="lesson plan";
	String UPLOADCONTENT="upload content";
	String PUBLISHER="Test Automation Publisher";
	String[] DIAL_CODE={"UH8FPE","XGDMVD","4EP38B","7DUAEA","ACZHK9","DC5PR8","GBAWX7","JAG546","M9LCA5","Q8RJG4"};
	String LESSON_NAME="Automation Lesson Plan";	
	//Added for content upload
	String MP4_CONTENT_NAME="Automation Content Mp4";
	String SEARCH_CONTENT_IMAGE="content image1";
	String SEARCH_RESOURCE_IMAGE="content image";
	String SEARCH_COURSE_IMAGE="course image";
	String MP4="MP4";
	String UPLOAD_MP4="Upload content-mp4.mp4";
	String WEBM="WEBM";
	String UPLOAD_WEBM="Upload content-webm.webm";
	String YOUTUBE="YOUTUBE";
	String UPLOAD_YOUTUBE="https://www.youtube.com/watch?v=qCs0pm_D_hM";
	String EPUB="EPUB";
	String UPLOAD_EPUB="faulkner-sound-and-the-fury.epub";
	String HTML="HTML";
	String UPLOAD_HTML="HTMLContent_test.zip";
	String H5P="H5P";
	String UPLOAD_H5P="fill-in-the-blanks-837.h5p";
	String PDF="PDF";
	String UPLOAD_PDF="samplepdf.pdf";
	//added for announcement page
	
	String UPLOAD_MP4_URL="https://drive.google.com/file/d/16O6wbBoAum6NXdqTSXVZxh1SUAQNV1ok/view?usp=sharing";
	
	//Added for Test case 13
	String [] REVIEW_COMMENTS={"Inappropriate course","Empty Course","Duplicate Course","Not Suitable for Children"};
	
	//Added for announcement
	
	String DESCRIPTION="DESCRIPTION";
	String ENTERURL="ENTERURL";
	String UPLOADDOCUMENT="UPLOADDOCUMENT";

	//Adding for FlagReviewer
	String ACCEPT="accept";
	String DISCARD="discard";
	String PUBLISH="publish";
	String REQUESTCHANGES="request changes";

	//Adding for Public user 
	String TEST_MAIL_ID="testmemeight@gmail.com";
	String [] CONTENT_TYPE={"//sui-select-option/..//span[.='TextBook']","//sui-select-option/..//span[.='Collection']","//sui-select-option/..//span[.='LessonPlan']","//sui-select-option/..//span[.='Resource']"};
	
	//added on 18 Sep 2018 for deletion.
	String DRAFTS="drafts";
	String PUBLISHED="published";
	String ALLMYCONTENT="allMyContent";
}
