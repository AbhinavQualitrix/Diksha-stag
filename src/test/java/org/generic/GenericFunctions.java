/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 05/20/2018

* Purpose: Contains all the reusable generic methods. 
*/


package org.generic;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobjects.CreatorUserPageObj;
import org.startup.BaseTest;
import org.testng.Assert;
import java.io.IOException;
import java.io.UncheckedIOException;

import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.text.ParseException;
import org.apache.commons.io.FileUtils;


public class GenericFunctions extends BaseTest{
	
	public Select select;
	public Action action;

	static Logger log = Logger.getLogger(GenericFunctions.class.getName());
	
	public static void selectValueFromDropdown(WebDriver driver,String locator, String text)
	{	
	
		WebElement lang = driver.findElement(By.xpath(locator));
		List<WebElement> list = lang.findElements(By.xpath(locator));
		for (WebElement opt : list)
		{
			String value = opt.getText();
			if(value.equalsIgnoreCase(text)){
				System.out.println("Value clicked ="+value);
				opt.click();
			}
		}		
	}

	public static void setClipboardData(String string) 
	{
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) 
	{
		try {
			//Setting clipboard with file location
			setClipboardData(fileLocation);
			//native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			System.out.println("Failed uploading document");
			exp.printStackTrace();
		}
	}

	public static void writeNotepad(String processID,String fileName)
	{
		try 
		{
			BufferedWriter bWriter=new BufferedWriter(new FileWriter(fileName));
			bWriter.write(processID);
			System.out.println("Write ID: "+processID);
			bWriter.newLine();
			bWriter.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	@SuppressWarnings("resource")
    public static String readFromNotepad(String fileName){
        String path = "";
        try {
            BufferedReader bReader=new BufferedReader(new FileReader(fileName));
            while((path=bReader.readLine())!=null){
                System.out.println("Read ID: "+path);
                String str = bReader.readLine();
               // System.out.println(str);
                return path;
            }
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
		return path;
    }
	
	public static void waitTillTheElementIsVisibleAndClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOf(element));

        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	

    public static void waitTillTheElementInVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public static void waitForElementState(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(id));

        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public static void waitForPageToLoad(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public static void waitForElementToDisAppear(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfAllElements(id));
    }

    public static void waitForElementToDisAppear(List<WebElement> id, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfAllElements(id));
    }

    public static WebElement waitForElementToAppear(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForElementToAppear(WebElement id, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public static void WaitForFrameAndSwitchToIt(WebElement frame){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public static void WaitForFrameAndSwitchToIt(int id){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForElements(List<WebElement> arg) {
        waitForPageToLoad(arg);
    }

    public static WebElement waitForElementToAppearOnScreen(WebElement arg) {
        waitForElementToAppear(arg);
        WebElement el = arg;
        return el;
    }

    public static void clickUntilElementExists(WebElement clickLocator, By by) {
        boolean elementOnScreen;
        int i = 0;
        do {
            if (i == 25) {
                break;
            }
            try {
                driver.findElement(by);
                break;
            } catch (NoSuchElementException e) {
                clickLocator.click();
                elementOnScreen = false;
                System.out.println(i);
            }
            i++;
        } while (!elementOnScreen);
    }

    public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
     }

    public String withBoldHTML(String string) {
        if (!string.trim().isEmpty()) {
            return "<b>" + string + "</b>";
        } else {
            return "";
        }
    }


    public boolean isElementPresent(WebElement locator) {
        try {
            if (locator.isDisplayed())
                System.out.println("Element presend on screen ***********" + locator);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not present on screen **************" + locator);
            return false;
        }
    }

    public String getCurrentMonth(int month) {
        int i = Calendar.getInstance().get(Calendar.MONTH);
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month + i];
    }

    public static void refreshWebPage() {
        driver.navigate().refresh();
        GenericFunctions.waitWebDriver(1500);
    }

    //Method to wait for time
    public static void waitWebDriver(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());

        }
    }

    public static void switchToNewWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
    
    public static String genrateRandomInputs(String getRandomIp)
	{
	char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	StringBuilder sb = new StringBuilder(20);
	Random random = new Random();
	for (int i = 0; i < 10; i++) {
	    char c = chars[random.nextInt(chars.length)];
	    sb.append(c);
	}
	String output = sb.toString();
	System.out.println(output);
	return output;
	}
	
  //Method to switchToFrame
  	public static void switchToFrame(WebDriver mDriver,WebElement frame){
  		try 
  		{
  			mDriver.switchTo().frame(frame);
  		} catch (Exception e) {
  			log.error("Method: switchToFrame :: Exception is = " + e.getMessage() );
  		}
  	}
  	
  //Method Tab Operation
  	public static void keyTab(WebDriver mDriver,String locator)	{
  		
  		try	{
  			log.info("MethodName: keyTab :: element found = " + locator);
  			
  			mDriver.findElement(By.cssSelector(locator)).sendKeys(Keys.TAB);
  		} catch(Exception e) {
  			log.error("MethodName: TabKeys :: Exception occured for locator = " + locator + "exception = "+ e.getMessage());
  		}
  	}
  	
 // Method to get value of element
 	public static String getValue(WebDriver mDriver, String identifyBy, String locator) {
 		boolean assertElementExists = false;
 		String value = "";

 		try	{
 			assertElementExists = assertIfElementExists(mDriver, identifyBy, locator);
 			log.info("Method: getValue :: assertElementExists = " + assertElementExists + " for xpath = " + locator);
 			if (assertElementExists==true) {	
 				if (identifyBy.equalsIgnoreCase("xpath")) 
 					value = mDriver.findElement(By.xpath(locator)).getText();
 				else if (identifyBy.equalsIgnoreCase("id")) 
 					value = mDriver.findElement(By.id(locator)).getText();
 				else if (identifyBy.equalsIgnoreCase("name")) 
 					value = mDriver.findElement(By.name(locator)).getText();
 				else if (identifyBy.equalsIgnoreCase("css")) 
 					value = mDriver.findElement(By.cssSelector(locator)).getText();
 			}
 		} catch(Exception e) {
 			log.error("Method: getValue :: Exception occured for locator = " + locator + "exception = "+ e.getMessage());
 			// e.printStackTrace();
 		}
 		log.info("Method: getValue :: value of element = " + value);
 		//System.out.println("Method: getValue :: value of element = " + value); 
 		return value.trim();
 	}
 	

	// Method to check if element exists on page
	public static boolean assertIfElementExists(WebDriver mDriver, String identifyBy, String locator) throws Exception {
		boolean bElementFound = false;
		try	{		
			if (identifyBy.equalsIgnoreCase("xpath")){ 
				bElementFound = mDriver.findElement(By.xpath(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("id")){ 
				bElementFound = mDriver.findElement(By.id(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("name")){ 
				bElementFound = mDriver.findElement(By.name(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("css")){ 
				bElementFound = mDriver.findElement(By.cssSelector(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("linktext")){ 
				bElementFound = mDriver.findElement(By.linkText(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("partialtext")){ 
				bElementFound = mDriver.findElement(By.partialLinkText(locator)).isDisplayed();
			}else {
				log.info("None of the Element Selected Please check the Element Once: ");
			}
		} catch(Exception e){
			log.error("Method: assertIfElementExists :: Exception occured for locator = " + locator + " exception is = "+ e.getMessage());
			Assert.assertTrue(false,"***Method: assertIfElementExists: Exception occured for locator= " + e.getMessage());
		}
		log.info("Method: assertIfElementExists for locator = " + locator  + " status = " + bElementFound);	
		return bElementFound;
	}

  	public static boolean assertElementValue(WebDriver mDriver, String identifyBy, String locator, String expectedValue) {
		String actualElementValue = "";
		actualElementValue =  getValue(mDriver, identifyBy, locator);
		expectedValue = expectedValue.trim();

		log.info("Method: assertElementValue :: actualElementValue = " + actualElementValue 
				+ " expectedValue = " + expectedValue);

		if (expectedValue.equals(actualElementValue) == true)
			return true;
		else
			return false;
	}
  	

	public static String currentDateAndTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHHmmss");
		// String newDate = dtf.toString().toCharArray().toString();
		//	System.out.println(now.format(dtf).toCharArray());
		String date = now.format(dtf);
		return date;
	}
	public static String currentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
	    Date date = new Date();  
	    //System.out.println(formatter.format(date));  
		String current_date = formatter.format(date);
		return current_date;
	}
	

	public static String autoIncrementer()
	{
		String get = GenericFunctions.readFromNotepad(".\\courseNumbers.txt");
		int var=Integer.parseInt(get);
		System.out.println("Reading "+var);
		var=++var;
		String var1 = Integer.toString(var);
		GenericFunctions.writeNotepad(var1,".\\courseNumbers.txt");
		String set=GenericFunctions.readFromNotepad(".\\courseNumbers.txt");
		System.out.println("writing "+set);
		return set;
	}
	
	public static String randomCourseName()
	{

		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	public static String testDataIncrementer(String filePath) {

		   String courseNum = GenericFunctions.readFromNotepad(filePath);
		      Pattern compile = Pattern.compile("^(.*?)([9Z]*)$");
		      Matcher matcher = compile.matcher(courseNum);
		      String left="";
		      String right="";
		      if(matcher.matches()){
		           left = matcher.group(1);
		           right = matcher.group(2);
		      }
		      courseNum = !left.isEmpty() ? Long.toString(Long.parseLong(left, 36) + 1,36):"";
		      courseNum += right.replace("Z", "A").replace("9", "0");
		      GenericFunctions.writeNotepad(courseNum,filePath);
		      return courseNum.toUpperCase();
		  }
	public static void getStatusOfMonthsBetweenDates(String startDate, String endDate) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date date1 = sdf.parse(startDate);
        Date date2 = sdf.parse(endDate);

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.compareTo(date2) > 0) {
            System.out.println("startDate is after endDate");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("startDate is before endDate");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("startDate is equal to endDate");
        } else {
            System.out.println("How to get here?");
        }

    }
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	public static void handleAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
	
	public static void captureScreenshotOnValidation(){
		  try
		  {
		   GenericFunctions.waitWebDriver(1500);
		   String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		   ExtentTestManager.getTest().log(LogStatus.INFO,"CONTENT VALIDATED",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		  }
		  catch(Exception e)
		  {
		   System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		  }
		 }
	 public static void scrollTillEndOfPage(){
	     
	    	  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight )");  
	      
		 
	    }
	public static void takeScreenshotOnValidation(String screenShotvariable){
		  try
		  {
		   GenericFunctions.waitWebDriver(1500);
		   /*EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		   File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		   String screenShotName = screenShotvariable + GenericFunctions.testDataIncrementer("./TestData/screenShot.txt").toString();
		   File dstFile = new File("./Screenshot/" + screenShotName + ".jpg");
		   FileUtils.copyFile(srcFile,dstFile);*/
		   
		   
		  }
		  catch(Exception e)
		  {
		   System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		  }
		 }
	public static void compareTwoImages(){
		  try
		  {
		   GenericFunctions.waitWebDriver(1500);
		   BufferedImage expectedImage=ImageIO.read(new File("./ScreenShot/ + img1.png"));
		   Screenshot myScreenshot = new AShot().takeScreenshot(driver);	   
		   BufferedImage actualImage=myScreenshot.getImage();
		   ImageDiffer imgDiff = new ImageDiffer();
		   ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		   //int status = diff.hashCode();
		   //System.out.println(status);
		   
		   Assert.assertTrue(diff.hasDiff());
		   //BufferedImage DiffImage = diff.getDiffImage();
		   
		   //String base64Screenshot = imgToBase64String(DiffImage,"png");//"data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		   //ExtentTestManager.getTest().log(LogStatus.INFO,"CONTENT VALIDATED",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		  
		   
		   System.out.println("Images are Same");
		    
		  }
		  catch(Exception e)
		  {
		   System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		  }
	
		 }
	public static void compareImages(String img2,String screenShotvariable) {
		{ 
	        BufferedImage imgA = null; 
	        BufferedImage imgB = null; 
	  
	        try
	        { 
	        	String screenShotName = screenShotvariable + GenericFunctions.readFromNotepad("./TestData/screenShot.txt").toString();
	        	System.out.println(screenShotName);
	            File fileA = new File("./Screenshot/" + img2 + ".jpg"); 
	            File fileB = new File("./Screenshot/" + screenShotName + ".jpg"); 
	  
	            imgA = ImageIO.read(fileA); 
	            imgB = ImageIO.read(fileB); 
	        } 
	        catch (IOException e) 
	        { 
	            System.out.println(e); 
	        } 
	        int width1 = imgA.getWidth(); 
	        int width2 = imgB.getWidth(); 
	        int height1 = imgA.getHeight(); 
	        int height2 = imgB.getHeight(); 
	  
	        if ((width1 != width2) || (height1 != height2)) 
	            System.out.println("Error: Images dimensions"+ 
	                                             " mismatch"); 
	        else
	        { 
	            long difference = 0; 
	            for (int y = 0; y < height1; y++) 
	            { 
	                for (int x = 0; x < width1; x++) 
	                { 
	                    int rgbA = imgA.getRGB(x, y); 
	                    int rgbB = imgB.getRGB(x, y); 
	                    int redA = (rgbA >> 16) & 0xff; 
	                    int greenA = (rgbA >> 8) & 0xff; 
	                    int blueA = (rgbA) & 0xff; 
	                    int redB = (rgbB >> 16) & 0xff; 
	                    int greenB = (rgbB >> 8) & 0xff; 
	                    int blueB = (rgbB) & 0xff; 
	                    difference += Math.abs(redA - redB); 
	                    difference += Math.abs(greenA - greenB); 
	                    difference += Math.abs(blueA - blueB); 
	                } 
	            } 
	  
	            // Total number of red pixels = width * height 
	            // Total number of blue pixels = width * height 
	            // Total number of green pixels = width * height 
	            // So total number of pixels = width * height * 3 
	            double total_pixels = width1 * height1 * 3; 
	  
	            // Normalizing the value of different pixels 
	            // for accuracy(average pixels per color 
	            // component) 
	            double avg_different_pixels = difference / 
	                                          total_pixels; 
	  
	            // There are 255 values of pixels in total 
	            double percentage = (avg_different_pixels / 
	                                            255) * 100; 
	  
	            System.out.println("Difference Percentage-->" + 
	                                                percentage); 
	        } 
	    } 
	 

	}
	
	public static String imgToBase64String(final RenderedImage img, final String formatName)
	{
	  final ByteArrayOutputStream os = new ByteArrayOutputStream();

	  try
	  {
	    ImageIO.write(img, formatName, os);
	    return Base64.getEncoder().encodeToString(os.toByteArray());
	  }
	  catch (final IOException ioe)
	  {
	    throw new UncheckedIOException(ioe);
	  }
	}
//	public void SelectDateFromDatePicker(String year, String month, String date)
//    {
//
//        while (year != lblYear.Text)
//        {
//            if (int.Parse(year) < int.Parse(lblYear.Text))
//            {
//                btnPrevious.Clicks();
//            }
//            else
//            {
//                btnNext.Clicks();
//            }
//        }
//
//        while (lblMonth.Text != "January")
//        {
//            btnPrevious.Clicks();
//        }
//
//        while (month != lblMonth.Text)
//        {
//               btnNext.Clicks();
//        }
//
//        WebElement dateField = PropertiesCollection.driver.FindElement(By.XPath("//a[text()=\""+ date+"\"]"));
//        dateField.clicks();
//    }
	
}
