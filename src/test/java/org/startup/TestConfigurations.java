/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 06/10/2018

* Purpose: All the locators of login page.
*/
package org.startup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;


public class TestConfigurations 
{
	public static Properties APPCONFIG=null;
	public static Properties COLUMNHEADERSPROP=null;
	public static Properties OTHERCONFIGPROP=null;
	public static boolean isTestConfigInitialized = false;

	static Logger log = Logger.getLogger(TestConfigurations.class.getName());

	@BeforeClass
	public static void initTestConfiguration() throws IOException {

		if(!isTestConfigInitialized) {

			APPCONFIG = new Properties();
			COLUMNHEADERSPROP = new Properties();
			OTHERCONFIGPROP = new Properties();


			try  {
				APPCONFIG.load(new FileInputStream(".\\Application.config"));
			}  catch (FileNotFoundException e) {
				log.error("Method: initTestConfiguration ::" + "file not found exception occured = " + e
						+ " Line Number = " +  Thread.currentThread().getStackTrace()[3].getLineNumber());
			}  catch (IOException e) {
				log.error("Method: initTestConfiguration ::" + "IO exception occured = " + e
						+ " Line Number = " +  Thread.currentThread().getStackTrace()[3].getLineNumber());
			}

			try {
				if (APPCONFIG.size() > 0) {

					FileInputStream ColumnHeaderFile = new FileInputStream(APPCONFIG.getProperty("ExcelColumnHeadersFilePath"));
					COLUMNHEADERSPROP.load(ColumnHeaderFile);
					FileInputStream OtherConfigFile = new FileInputStream(APPCONFIG.getProperty("OtherConfigurationsPath"));
					OTHERCONFIGPROP.load(OtherConfigFile);

				}
			} catch (Exception e) {
				log.error("Method: initTestConfiguration ::" + "Exception occured = " + e
						+ " Line Number = " +  Thread.currentThread().getStackTrace()[3].getLineNumber());
				e.printStackTrace();
			}
			isTestConfigInitialized = true;
		}
	}
}
