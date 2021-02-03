package com.PageModules;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.WebElement;

import com.PageObjects.ObjectAddAttribute;

public class AddAttribute extends ObjectAddAttribute {

	public static String dropdownMainoption = null;
	public static String dropdownSuboption = null;

	public AddAttribute() {
		super();
	}

	public int numberOfCurrentDataService() {
		List<WebElement> elements = getWebElements(editButton);
		int numberOfDataService = elements.size();
		System.out.println("Number of Data Service Currently avaialble is :" + numberOfDataService);
		return numberOfDataService;
	}

	public int numberOfPreviousAttributes() {
		List<WebElement> elements = getWebElements(allPreviousAttributes);
		int numberOfPreviouAttributes = elements.size();
		System.out.println("Number of previous Attributes are : " + numberOfPreviouAttributes);
		return numberOfPreviouAttributes;
	}

	public void namesOfPreviousAttributes() {
		List<WebElement> elements = getWebElements(allPreviousAttributes);
		int numberOfPreviouAttributes = elements.size();
		for (int i = 0; i < numberOfPreviouAttributes; i++) {
			String name = elements.get(i).getText();
			System.out.println(name);
		}
	}

	public void nameRecentlyAddedAttribute(String nameOfAttribute) {
		int currentNumberOfAttributes = numberOfPreviousAttributes();
		System.out.println(currentNumberOfAttributes);
		List<WebElement> elements = getWebElements(allPreviousAttributes);
		int size = elements.size();
		clickElementJS(elements.get(size - 1));
		elements.get(size - 1).sendKeys("nameOfAttribute");
	}

	public void editExistingAttribute() {

	}

	public JSONObject getNewAttributeData() {
		JSONObject object = new JSONObject();
		object.put("Attribute Name", "Employee Number");
		object.put("Custom Label", "Employee Number");
		object.put("Error Message", "Should be a number");
		object.put("Default Value", "1");
		object.put("Minimum Value", "1");
		object.put("Maximum Value", "1000");
		object.put("Description Text", "Describes Employee Number");
		return object;
	}

	/*
	 * Step 0: Login Step 1: Click on Edit Step 2: Click on editDraft Step 3: Click
	 * on New Attribute Step 4: Click on Attribute Name Field Step 5: Send Text and
	 * Name the Attribute Step 6: Select the options Create, Required and Unique
	 * Step 7: Select dropdown for type (11 options) Step 8: After Selecting
	 * dropdown arrow select text type and then again select text by usign mouse
	 * hover Based on the options in 7 the next values will be there for number
	 * option in step 7 we will continue the flow Send Text in Customer label Send
	 * TExt in Custom Error Send Text in Defaut Value Let the Drag and drop be
	 * default value Send TExt in Min and Max value Send Text in Description
	 * Save/Deploy
	 */
	public void addNewAttribute() {
		JSONObject object = getNewAttributeData();
		System.out.println("The values to be entered are as follow : " + object.toString());
		clickElement(editButton);
		clickElement(editDraft);
		int numberofPreviousAttributes = numberOfPreviousAttributes();
		clickElement(newAttribute);
		int numberOfCurrentAttributes = numberOfPreviousAttributes();
		applyWait(3000);
		if (numberofPreviousAttributes < numberOfCurrentAttributes) {
			nameRecentlyAddedAttribute(object.getString("Attribute Name"));
		}
		if (!isElementSelected(requiredOnlyRadioButton)) {
			clickElementJS(requiredOnlyRadioButton);
		}
		clickElement(dropdownArrow);
		clickElement(dropdownTypeNumber);
		mouseHover(selectDropdownNumberNumber);
		clickElementJS(selectDropdownNumberNumber);

		scrollToElement(customLableTextBox);
		enterText(customLableTextBox, object.getString("Custom Label"));
		scrollToElement(errorMessageTextbox);
		enterText(errorMessageTextbox, object.getString("Error Message"));
		scrollToElement(deafultValueTextbox);
		enterText(deafultValueTextbox, object.getString("Default Value"));
		scrollToElement(minNumberTextbox);
		enterText(minNumberTextbox, object.getString("Minimum Value"));
		scrollToElement(maxNumberTextbox);
		enterText(maxNumberTextbox, object.getString("Maximum Value"));
		scrollToElement(descriptionTextbox);
		enterText(descriptionTextbox, object.getString("Description Text"));
		scrollToElement(saveButtonAttribute);
		clickElement(saveButtonAttribute);
	}

	public void selectRadioButtonOptions(String optionsForRadioButton) {
		switch (optionsForRadioButton) {
		case "Select Required Only":
			if (isElementDisplayed(requiredOnlyRadioButton)) {
				clickElement(requiredOnlyRadioButton);
			} else {
				System.out.println("The radio button is not displayed");
			}
			break;
		case "Select Create Only":
			if (isElementDisplayed(createRadioButton)) {
				clickElement(createRadioButton);
			} else {
				System.out.println("The radio button is not displayed ");
			}
			break;
		case "Select Unique":
			if (isElementDisplayed(uniqueRadioButton)) {
				clickElement(uniqueRadioButton);
			} else {
				System.out.println("The radio button is not displayed");
			}
			break;
		case "Select Required Only and Create Only":
			if (isElementDisplayed(requiredOnlyRadioButton) && isElementDisplayed(createRadioButton)) {
				clickElement(requiredOnlyRadioButton);
				clickElement(createRadioButton);
			} else {
				System.out.println("either or both radio buttons are not displayed");
			}
			break;
		case "Select Required Only and Unique":
			if (isElementDisplayed(requiredOnlyRadioButton) && isElementDisplayed(uniqueRadioButton)) {
				clickElement(requiredOnlyRadioButton);
				clickElement(uniqueRadioButton);
			} else {
				System.out.println("Either or both radio button not displayed");
			}
			break;
		case "Select Unique and Create Only":
			if (isElementDisplayed(uniqueRadioButton) && isElementDisplayed(createRadioButton)) {
				clickElement(uniqueRadioButton);
				clickElement(createRadioButton);
			} else {
				System.out.println("Either or both radio buttons not displayed");
			}
			break;
		case "Select All Radio Buttons":
			if (isElementDisplayed(requiredOnlyRadioButton) && isElementDisplayed(uniqueRadioButton)
					&& isElementDisplayed(createRadioButton)) {
				clickElement(requiredOnlyRadioButton);
				clickElement(uniqueRadioButton);
				clickElement(createRadioButton);
			} else {
				System.out.println("Either one or two or all of the radio buttons are not displayed");
			}
			break;
		default:
			if (isElementDisplayed(createRadioButton)) {
				clickElement(createRadioButton);
			} else if (isElementDisplayed(requiredOnlyRadioButton)) {
				clickElement(requiredOnlyRadioButton);
			} else if (isElementDisplayed(uniqueRadioButton)) {
				clickElement(uniqueRadioButton);
			} else {
				System.out.println("None of the radio buttons are displayed nor selected");
			}
		}
	}

	public void selectMainDropdownOption(String selectDropdownOption) {
		clickElement(dropdownArrow);
		switch (selectDropdownOption) {
		case "Select Text":
			clickElement(dropdownTypeText);
			dropdownMainoption = "Main Dropdown: Text";
			break;
		case "Select Number":
			clickElement(dropdownTypeNumber);
			dropdownMainoption = "Main Dropdown: Number";
			break;
		case "Select Boolean":
			clickElement(dropdownTypeBoolean);
			dropdownMainoption = "Main Dropdown: Boolean";
			break;
		case "Select Date":
			clickElement(dropdownTypeDate);
			dropdownMainoption = "Main Dropdown: Date";
			break;
		case "Select Group":
			clickElement(dropdownTypeGroup);
			dropdownMainoption = "Main Dropdown: Group";
			break;
		case "Select User":
			clickElement(dropdownTypeUser);
			dropdownMainoption = "Main Dropdown: User";
			break;
		case "Select Collection":
			clickElement(dropdownTypeCollection);
			dropdownMainoption = "Main Dropdown: Collection";
			break;
		case "Select Location":
			clickElement(dropdownTypeLocation);
			dropdownMainoption = "Main Dropdown: Location";
			break;
		case "Select File":
			clickElement(dropdownTypeFile);
			dropdownMainoption = "Main Dropdown: File";
			break;
		case "Select Schema":
			clickElement(dropdownTypeSchema);
			dropdownMainoption = "Main Dropdown: Schema";
			break;
		case "Select Relation":
			clickElement(dropdownTypeRelation);
			dropdownMainoption = "Main Dropdown: Relation";
			break;
		default:
			clickElement(dropdownTypeText);
			System.out.println("Default Text Option is Selected");
			dropdownMainoption = "Main Dropdown: Text";
		}
	}

	public void selectDropdownSuboptionForText(String selectDropdownSuboption) {
		switch (selectDropdownSuboption) {
		case "Select Text":
			mouseHover(selectDropdownTextSuboptionText);
			clickElement(selectDropdownTextSuboptionText);
			dropdownSuboption = "Suboption Dropdown: Text";
			break;
		case "Select SecureText":
			mouseHover(selectDropdownTextSuboptionSecureText);
			clickElement(selectDropdownTextSuboptionSecureText);
			dropdownSuboption = "Suboption Dropdown: SecureText";
			break;
		case "Select RichText":
			mouseHover(selectDropdownTextSuboptionRichText);
			clickElement(selectDropdownTextSuboptionRichText);
			dropdownSuboption = "Suboption Dropdown: RichText";
			break;
		case "Select LongText":
			mouseHover(selectDropdownTextSuboptionLongText);
			clickElement(selectDropdownTextSuboptionLongText);
			dropdownSuboption = "Suboption Dropdown: LongText";
			break;
		case "Select ListOfValue":
			mouseHover(selectDropdownTextSuboptionListOfValue);
			clickElement(selectDropdownTextSuboptionListOfValue);
			dropdownSuboption = "Suboption Dropdown: ListOfValue";
			break;
		case "Select Email":
			mouseHover(selectDropdownTextSuboptiontEmail);
			clickElement(selectDropdownTextSuboptiontEmail);
			dropdownSuboption = "Suboption Dropdown: Email";
			break;
		default:
			mouseHover(selectDropdownTextSuboptionText);
			clickElement(selectDropdownTextSuboptionText);
			dropdownSuboption = "Suboption Dropdown: Text";
			System.out.println("Selected Default Suboption text which is under main option Text");
			break;
		}
	}

	public void selectDropdownSuboptionForNumber(String selectDropdownSuboption) {
		switch (selectDropdownSuboption) {
		case "selectDropdownNumberNumber":
			mouseHover(selectDropdownNumberNumber);
			clickElement(selectDropdownNumberNumber);
			dropdownSuboption = "Suboption Dropdown: Number";
			break;
		case "selectDropdownNumberListOfValue":
			mouseHover(selectDropdownTextSuboptionListOfValue);
			clickElement(selectDropdownTextSuboptionListOfValue);
			dropdownSuboption = "Suboption Dropdown: ListOFValue";
			break;
		case "selectDropdownNumber":
			mouseHover(selectDropdownNumberCurrency);
			clickElement(selectDropdownNumberCurrency);
			dropdownSuboption = "Suboption Dropdown: Currency";
			break;
		default:
			System.err.print("The Dropdown Suboption under main dropdown Number is not selected ");
		}
	}

	public void selectDropdownSubptionForDate(String selectDropdownSubption) {
		switch (selectDropdownSubption) {
		case "selectDropdownDateDate":
			mouseHover(selectDropdownDateDate);
			clickElement(selectDropdownDateDate);
			dropdownSuboption = "Suboption Dropdown: Date";
			break;
		case "selectDropdownDateDateAndTime":
			mouseHover(selectDropdownDateDateAndTime);
			clickElement(selectDropdownDateDateAndTime);
			dropdownSuboption = "Suboption Dropdown: DateAndTime";
			break;
		}
	}

	public void enterTextUnderMainDropdownText() {
		if (dropdownSuboption.contains("Text")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(deafultValueTextbox, "");
			enterText(patternTextbox, "");
			enterText(minLengthTextbox, "");
			enterText(maxLengthTextbox, "");
			enterText(descriptionTextbox, "");

		} else if (dropdownSuboption.contains("LongText")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(tokenTextbox, "");
			clickElement(plusButton);
			enterText(descriptionTextbox, "");
		} else if (dropdownSuboption.contains("RichText")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(tokenTextbox, "");
			clickElement(plusButton);
			enterText(descriptionTextbox, "");
		} else if (dropdownSuboption.contains("Email")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(defaultValueTextbox, "");
			enterText(descriptionTextbox, "");
		} else if (dropdownSuboption.contains("SecureText")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(patternTextbox, "");
			enterText(descriptionTextbox, "");
		} else if (dropdownSuboption.contains("ListOfValues")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(valuesTextbox, "");
			clickElement(plusButton);
			selectFromDropdownByText(defaultValueDropdown, "");
			enterText(descriptionTextbox, "");
		}
	}

	public void enterTextUnderMainDropdownNumber() {
		if (dropdownSuboption.contains("Number")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(valuesTextbox, "");
			// precision slider (1 to 5)
			enterText(minNumberTextbox, "");
			enterText(maxNumberTextbox, "");
			enterText(descriptionTextbox, "");
		} else if (dropdownSuboption.contains("ListOfValue")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(valuesTextbox, "");
			clickElement(plusButton);
			selectFromDropdownByText(defaultValueDropdown, "");
			enterText(descriptionTextbox, "");
		} else if (dropdownSuboption.contains("Currency")) {
			enterText(customLableTextbox, "");
			enterText(errorMessageTextbox, "");
			enterText(valuesTextbox, "");
			selectFromDropdownByText(currencyDropdown, "");
			// precision slider
			enterText(minNumberTextbox, "");
			enterText(maxNumberTextbox, "");
			enterText(descriptionTextbox, "");
		}
	}

	public void enterTextUnderBoolean() {
		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		if (getText(togglePosition).equalsIgnoreCase("yes")) {
			clickElement(toggleYesNo);
		} else if (getText(togglePosition).equalsIgnoreCase("no")) {
			clickElement(toggleYesNo);
		}
		enterText(descriptionTextbox, "");
	}

	public void enterTextUnderDate(JSONObject object) {
		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		selectExactDate(object);
		enterText(descriptionTextbox, "");
	}

	public void enterTextUnderGroup() {
		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		enterText(descriptionTextbox, "");

	}

	public void enterTextUnderCollection() {
		// all 11 mainoption and under it all suboptions are avaialable
		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		// collection of dropdown (again all 11 dropdown value available under which all
		// suboption)

	}

	public void enterTextUnderLocation() {
		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		enterText(descriptionTextbox, "");
	}

	public void enterTextUnderFile() {
		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		enterText(descriptionTextbox, "");
	}

	public void enterTextUnderRelation() {
		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		selectFromDropdownByText(relatedToDropdown, "");
		// relates to (dropdown : value aviailable is data service names )

		selectFromDropdownByText(searchOnFieldDropdown, "");
		// search on fields (dropdown: value available is the attributes under data
		// service chosen)
		// selectFromDropdownByText(, "");
		// view fields (dropdown: value available is the attributes under data service
		// chosen)
		enterText(defaultValueTextbox, "");
		// allow deletion of records toggle bar
		enterText(descriptionTextbox, "");
	}

	public void enterTextUnderSchema() {

		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		enterText(linkedLibraryTextbox, "");
		enterText(descriptionTextbox, "");

	}

	public void enterTextUnderUser() {
		// select[@formcontrolname='_listInput']
		// select[@id='relatedTo']

		enterText(customLableTextbox, "");
		enterText(errorMessageTextbox, "");
		selectFromDropdownByText(searchOnFieldDropdown, "");

		// selectFromDropdownByText(addNewDataService, "");
		// viewfields dropdown and then select from dropdown
		selectFromDropdownByText(defaultValueDropdown, "");
		enterText(descriptionTextbox, "");
	}

	public void selectExactDate(JSONObject object) {
		JSONObject dateobject = object;
		clickElement(selectDate);
		selectFromDropdownByText(month, dateobject.getString("Month"));
		selectFromDropdownByText(year, dateobject.getString("Year"));
		selectFromDropdownByText(hour, dateobject.getString("Hour"));
		selectFromDropdownByText(minute, dateobject.getString("Minute"));
		selectFromDropdownByText(second, dateobject.getString("Second"));
		clickElement(doneButton);
	}

}
