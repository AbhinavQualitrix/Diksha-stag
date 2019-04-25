package org.apiPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.generic.GenericFunctions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.startup.BaseTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiHashMap extends BaseTest {

	String TopicSelectorImg = "//a[@class='tree item active']//following::input[1]//following::a[1]//preceding::i[3]";
	String TopicSelectorContent = "//a[@class='tree item active']//following::input[1]//following::a[1]//following::a[1]";
	String TopicSelectorDone = "(//a[.='Done'])[2]";

	ArrayList<String> xPath = new ArrayList<String>();
	ArrayList<String> allXPath = new ArrayList<String>();

	ArrayList<String> inputType = new ArrayList<String>();
	ArrayList<String> allInputType = new ArrayList<String>();

	ArrayList<String> dropdownValueXPath = new ArrayList<String>();
	ArrayList<String> allDropdownValueXPath = new ArrayList<String>();

	/**
	 * @param api_key
	 * @param rootorg_id
	 * @param framework_name
	 * @param action
	 * @param subtype
	 */
	public void dynamicFormHandling(String api_key, String rootorg_id, String framework_name, String action,
			String subtype) {
		{
			// Passing required credentials to fetch the API response
			try {

				String apikey = api_key;
				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json").header("Authorization", "Bearer " + apikey);

				JSONObject json = new JSONObject();

				json.put("type", "content");
				json.put("framework", framework_name);
				json.put("action", action);
				json.put("subType", subtype);
				json.put("rootOrgId", rootorg_id);

				JSONObject json2 = new JSONObject();
				json2.put("request", json);
				request.body(json2.toJSONString());

				Response resp = request.post(APP_URL + "/api/data/v1/form/read");

				// Converting JSON object response to String
				String fileAsString = resp.body().toString();
				Object value = resp.getBody().asString();
				JSONParser parser = new JSONParser();
				fileAsString = value.toString();

				org.json.JSONObject jsonResult = new org.json.JSONObject(fileAsString);
				Object result = jsonResult.get("result");

				org.json.JSONObject jsonForm = new org.json.JSONObject(result.toString());
				Object resultForm = jsonForm.get("form");

				org.json.JSONObject jsonData = new org.json.JSONObject(resultForm.toString());
				Object formData = jsonData.get("data");

				org.json.JSONObject jsonFields = new org.json.JSONObject(formData.toString());
				org.json.JSONArray dataFields = jsonFields.getJSONArray("fields");

				List<JsonAttributes> fieldValues = new ArrayList<>();

				// To Read all the JSON key-value data
				for (int i = 0; i < dataFields.length(); i++) {
					try {
						org.json.JSONObject jsonvalue = dataFields.getJSONObject(i);

						JsonAttributes pojoObj = new JsonAttributes();

						try {

							String lableValue = jsonvalue.getString("label");
							String newLabelValue = lableValue.toUpperCase();

							pojoObj.setlable(newLabelValue);

						} catch (Exception ee) {

							System.out.println("Exception found while reading label" + ee.getLocalizedMessage());
							/*
							 * String lableValue = jsonvalue.getString("lable"); String newLabelValue =
							 * lableValue.toUpperCase();
							 * 
							 * pojoObj.setlable(newLabelValue);
							 */

						}

						pojoObj.setVisible(jsonvalue.getBoolean("visible"));
						pojoObj.setInputType(jsonvalue.getString("inputType"));
						pojoObj.setRequired(jsonvalue.getBoolean("required"));

						fieldValues.add(pojoObj);
					} catch (Exception e) {
						System.out.println("Exception found while reading fieldvalues" + e.getLocalizedMessage());
					}
				}

				// Filter JSON Response based on Visibility & Required fields condition
				List<JsonAttributes> requiredDataFields = new ArrayList<>();

				for (JsonAttributes jsonAttributes : fieldValues)

				{

					// if (jsonAttributes.getVisible())

					if (jsonAttributes.getRequired())

					{
						requiredDataFields.add(jsonAttributes);

						inputType.add(jsonAttributes.getInputType());

						// For Generating Dynamic Xpaths
						String prefiXPath = "//label[contains(text(),'";
						String suffiXPath = "')]/..//input";
						String fetchLabel = jsonAttributes.getlable();
						String multiSelectClick = "')]";
						String suffiXPathDropdown = "')]/following-sibling::*";
						String suffiXpathSibling = "')]/following-sibling::*/..//*[contains(@class,'item')][2]";
						String xPathForDropDownValue = prefiXPath + fetchLabel + suffiXpathSibling;
						String suffixMultiSelectXpath = "')]/following::i[1]";

						String prefixTopicSelect = "//label[contains(.,'";
						String suffixTopicSelect = "Topics')]/..//topic-selector/..//input";
						String topicSltDoneButton = "//a[.='Done']";

						// To Generate the Xpath for all the Web Elements based on the input type of the
						// element

						if (jsonAttributes.getInputType().equalsIgnoreCase("text")) {
							String finalXPath = prefiXPath + fetchLabel + suffiXPath;

							xPath.add(finalXPath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}
						if (jsonAttributes.getInputType().equalsIgnoreCase("select")) {
							String Finalxpath = prefiXPath + fetchLabel + suffiXPathDropdown;

							xPath.add(Finalxpath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}

						if (jsonAttributes.getInputType().equalsIgnoreCase("multiSelect")) {
							String Finalxpath = prefiXPath + fetchLabel + suffiXPathDropdown;

							xPath.add(Finalxpath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}

						if (jsonAttributes.getInputType().equalsIgnoreCase("file")) {
							String Finalxpath = prefiXPath + fetchLabel;

							xPath.add(Finalxpath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}
						if (jsonAttributes.getInputType().equalsIgnoreCase("textarea")) {
							String Finalxpath = prefiXPath + fetchLabel + suffiXPathDropdown;

							xPath.add(Finalxpath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}

						if (jsonAttributes.getInputType().equalsIgnoreCase("keywordsuggestion")) {
							String Finalxpath = prefiXPath + fetchLabel + suffiXPath;

							xPath.add(Finalxpath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}
						if (jsonAttributes.getInputType().equalsIgnoreCase("dialcode")) {
							String Finalxpath = prefiXPath + fetchLabel + suffiXPath;

							xPath.add(Finalxpath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}

						if (jsonAttributes.getInputType().equalsIgnoreCase("topicselector")) {
							String Finalxpath = prefixTopicSelect + suffixTopicSelect;

							xPath.add(Finalxpath);
							dropdownValueXPath.add(xPathForDropDownValue);

						}

						// NEED TO ADD THE CONDITION FOR DIAL CODE FIELD AND ANY OTHER INPUT TYPES
					}
				}

				// Add all input type to Array List "allInputType"
				addInputTypeInToArrayList();

				// Add All generated XPaths to "allXPath"
				addXPathIntoArraylist();

				// Add all generated dropdown value xpaths to "allDropdownValueXPath"
				addDropdownValueXPathIntoArraylist();
			}

			catch (Exception e) {
				System.out.println(
						"Exception found while generating xpaths based on input type" + e.getLocalizedMessage());
			}

			// converting array list of "input type" to array
			listAllArrayList();

			// converting array list of "xpath" to array
			listXpathAllArrayList();

			// converting array list of "dropdown value xpath" to array
			listDropDownInArrayList();

			// To perform operation on UI
			feedDataToUI();
		}
	}

	/**
	 * Purpose: addInputTypeInToArrayList method is used to add all the input types
	 * of the elements in the arraylist .
	 */
	public ArrayList<String> addInputTypeInToArrayList() {
		allInputType.addAll(inputType);

		return allInputType;
	}

	/**
	 * Purpose: addDropdownValueXPathIntoArraylist method is used to add all the
	 * dropdown values xpaths of the elements in the arraylist .
	 */
	public ArrayList<String> addDropdownValueXPathIntoArraylist() {
		allDropdownValueXPath.addAll(dropdownValueXPath);

		return allDropdownValueXPath;
	}

	/**
	 * Purpose: addXPathIntoArraylist method is used to add all the xpaths of the
	 * elements in the arraylist .
	 */
	public ArrayList<String> addXPathIntoArraylist() {
		allXPath.addAll(xPath);

		return allXPath;
	}

	/**
	 * Purpose: listAllArrayList method is used to fetch the inputType of the
	 * elements in the UI. .
	 */
	public void listAllArrayList() {

		String[] inputTypeArray = new String[allInputType.size()];
		inputTypeArray = allInputType.toArray(inputTypeArray);

		for (int i = 0; i < allInputType.size(); i++) {
			// System.out.println("DataType " +stockArr[i]);
			// if(jsonAttributes.getInputType().equalsIgnoreCase("select"))

		}
	}

	/**
	 * Purpose: listXpathAllArrayList method is used to fetch the xpaths of the
	 * elements in the UI. .
	 */
	public void listXpathAllArrayList() {

		String[] allXpathArray = new String[allXPath.size()];
		allXpathArray = allXPath.toArray(allXpathArray);

		for (int i = 0; i < allXPath.size(); i++) {
			System.out.println("Xpath" + allXpathArray[i]);
			// if(jsonAttributes.getInputType().equalsIgnoreCase("select"))

		}
	}

	/**
	 * Purpose: listDropDownInrrayList method is used to fetch the dropdown values
	 * of the elements in the UI. .
	 */
	public void listDropDownInArrayList() {

		String[] allDropdownValueArray = new String[allDropdownValueXPath.size()];
		allDropdownValueArray = allDropdownValueXPath.toArray(allDropdownValueArray);

		for (int i = 0; i < allDropdownValueXPath.size(); i++) {
			System.out.println("Dropdown Xpath" + allDropdownValueArray[i]);
			// if(jsonAttributes.getInputType().equalsIgnoreCase("select"))

		}
	}

	/**
	 * Purpose: feedDataToUI method is used to perform the needed operations in the
	 * elements in the UI.
	 */
	public void feedDataToUI() {

		try {
			System.out.println("=======================================");
			String[] xPathArray = new String[allXPath.size()];
			xPathArray = allXPath.toArray(xPathArray);

			String[] dropdownXPathArray = new String[allDropdownValueXPath.size()];
			dropdownXPathArray = allDropdownValueXPath.toArray(dropdownXPathArray);

			String[] inputTypeXPathArray = new String[allInputType.size()];
			inputTypeXPathArray = allInputType.toArray(inputTypeXPathArray);

			for (int i = 0; i < xPathArray.length; i++) {
				String PathValue = xPathArray[i];
				String inpuTypeValue = inputTypeXPathArray[i];

				String str = inpuTypeValue;
				switch (str) {

				case "text":

					String PathValue2 = xPathArray[i];
					System.out.println("Xpath Value=== " + inpuTypeValue + PathValue2);

					break;

				case "textarea":
					String pathValueForTextArea = xPathArray[i];
					System.out.println("Xpath Value=== " + inpuTypeValue + pathValueForTextArea);

					break;

				case "select":

					String pathValueForSelectType = xPathArray[i];
					String DropDownValue = dropdownXPathArray[i];
					System.out.println("Xpath Value=== " + DropDownValue);
					GenericFunctions.scrollToElement(driver.findElement(By.xpath(pathValueForSelectType)));
					Thread.sleep(2000);
					driver.findElement(By.xpath(pathValueForSelectType)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(DropDownValue)).click();

					break;

				case "multiselect":

					String pathValueForMultiSelectType = xPathArray[i];
					String dropDownValueForMultiSltDropdown = dropdownXPathArray[i];
					System.out.println("Xpath Value=== " + dropDownValueForMultiSltDropdown);
					Thread.sleep(1000);
					GenericFunctions.scrollToElement(driver.findElement(By.xpath(pathValueForMultiSelectType)));
					driver.findElement(By.xpath(pathValueForMultiSelectType)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(dropDownValueForMultiSltDropdown)).click();
					Thread.sleep(1000);

					break;

				case "file":

					// System.out.println("Xpath Value=== " + DataTypeValue + PathValue);
					// driver.findElement(By.xpath(PathValue)).sendKeys("TestingDesc");
					break;

				case "keywordsuggestion":
					String pathValueForkeywordSuggestionType = xPathArray[i];
					Thread.sleep(1000);
					driver.findElement(By.xpath(pathValueForkeywordSuggestionType)).sendKeys("TestingDesc");
					break;
				case "dialcode":
					String pathValueFordialcodeType = xPathArray[i];
					Thread.sleep(1000);
					driver.findElement(By.xpath(pathValueFordialcodeType)).sendKeys("654321");
					break;

				case "topicselector":
					String pathValueForTopicSelectortType = xPathArray[i];
					Thread.sleep(1000);
					driver.findElement(By.xpath(pathValueForTopicSelectortType)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(TopicSelectorImg)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(TopicSelectorContent)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(TopicSelectorDone)).click();

					break;
				}
			}
		}

		catch (Exception e) {
			System.out.println("Exception found on feeding data to UI" + e.getLocalizedMessage());

		}
	}
}
