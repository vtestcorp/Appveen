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

	public void selectDropdownSuboption(String selectDropdownSuboption) {
		if (dropdownMainoption.contains("Text")) {
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
		} else if (dropdownMainoption.contains("Number")) {
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
		} else if (dropdownMainoption.contains("Date")) {
			switch (selectDropdownSuboption) {
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
		} else {
			System.out.println("There is no suboption to choose under the selected main dropdown option");
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

	public void enterTextInTextboxes() {
		/////////// Main Dropdown is Text /////////
		if (dropdownMainoption.contains("Text") & dropdownSuboption.contains("Text")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(deafultValueTextbox);
			enterText(deafultValueTextbox, "");
			scrollToElement(patternTextbox);
			enterText(patternTextbox, "");
			scrollToElement(minLengthTextbox);
			enterText(minLengthTextbox, "");
			scrollToElement(maxLengthTextbox);
			enterText(maxLengthTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");

		} else if (dropdownMainoption.contains("Text") & dropdownSuboption.contains("LongText")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(customLableTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(tokenTextbox);
			enterText(tokenTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Text") & dropdownSuboption.contains("RichText")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(tokenTextbox);
			enterText(tokenTextbox, "");
			clickElement(plusButton);
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Text") & dropdownSuboption.contains("Email")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(defaultValueTextbox);
			enterText(defaultValueTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Text") & dropdownSuboption.contains("SecureText")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(patternTextbox);
			enterText(patternTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Text") & dropdownSuboption.contains("ListOfValues")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(valuesTextbox);
			enterText(valuesTextbox, "");
			clickElement(plusButton);
			selectFromDropdownByText(defaultValueDropdown, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		//// main dropdown number/////
		else if (dropdownMainoption.contains("Number") & dropdownSuboption.contains("Number")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(valuesTextbox);
			enterText(valuesTextbox, "");
			// precision slider (1 to 5)
			scrollToElement(minNumberTextbox);
			enterText(minNumberTextbox, "");
			scrollToElement(maxNumberTextbox);
			enterText(maxNumberTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Number") & dropdownSuboption.contains("ListOfValue")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(valuesTextbox);
			enterText(valuesTextbox, "");
			clickElement(plusButton);
			selectFromDropdownByText(defaultValueDropdown, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Number") & dropdownSuboption.contains("Currency")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(valuesTextbox);
			enterText(valuesTextbox, "");
			selectFromDropdownByText(currencyDropdown, "");
			// precision slider
			scrollToElement(minNumberTextbox);
			enterText(minNumberTextbox, "");
			scrollToElement(maxNumberTextbox);
			enterText(maxNumberTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		///////// Main Dropdown Boolean //////
		if (dropdownMainoption.contains("Boolean")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			if (getText(togglePosition).equalsIgnoreCase("yes")) {
				clickElement(toggleYesNo);
			} else if (getText(togglePosition).equalsIgnoreCase("no")) {
				clickElement(toggleYesNo);
			}
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		///// Main Dropdown is Date ///////
		if (dropdownMainoption.contains("Date")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			selectExactDate();
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Time&Date")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			selectExactDate();
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		///// Main Dropdown is Group //////
		else if (dropdownMainoption.contains("Group")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		//////// Main Dropdown is Collection /////
		if (dropdownMainoption.contains("Collection")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			clickElementJS(collectionOfDropdown);
			selectMainDropdownOption("Text");
			selectDropdownSuboption("Text");
			scrollToElement(defaultValueTextbox);
			enterText(defaultValueTextbox, "");
			scrollToElement(patternTextbox);
			enterText(patternTextbox, "");
			scrollToElement(minLengthTextbox);
			enterText(minLengthTextbox, "");
			scrollToElement(maximumLengthTextbox);
			enterText(maximumLengthTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		////// Main Dropdown is Location ///////////
		else if (dropdownMainoption.contains("Location")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		///// Main Dropdown is File ///////////
		else if (dropdownMainoption.contains("File")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		////// Main Dropdown option is Relation////
		else if (dropdownMainoption.contains("Relation")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			selectFromDropdownByText(relatedToDropdown, "");
			// relates to (dropdown : value aviailable is data service names )

			selectFromDropdownByText(searchOnFieldDropdown, "");
			selectFromDropdownByText(viewFieldsDropdown, "");
			// search on fields (dropdown: value available is the attributes under data
			// service chosen)
			// selectFromDropdownByText(, "");
			// view fields (dropdown: value available is the attributes under data service
			// chosen)
			scrollToElement(defaultValueTextbox);
			enterText(defaultValueTextbox, "");
			clickElement(deletionOfRecordsSlider);
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		////////// Main Dropdown Schema ///////
		else if (dropdownMainoption.contains("Schema")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(linkedLibraryTextbox);
			enterText(linkedLibraryTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
		///// Main Dropdown User /////////
		else if (dropdownMainoption.contains("User")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			selectFromDropdownByText(searchOnFieldDropdown, "");
			selectFromDropdownByText(viewFieldsDropdown, "");
			selectFromDropdownByText(defaultValueDropdown, "");
			enterText(descriptionTextbox, "");
		} else if (dropdownMainoption.contains("Schema")) {
			scrollToElement(customLableTextbox);
			enterText(customLableTextbox, "");
			scrollToElement(errorMessageTextbox);
			enterText(errorMessageTextbox, "");
			scrollToElement(linkedLibraryTextbox);
			enterText(linkedLibraryTextbox, "");
			scrollToElement(descriptionTextbox);
			enterText(descriptionTextbox, "");
		}
	}

	// public void enterTextUnderMainDropdownNumber() {
	// if (dropdownMainoption.contains("Number") &
	// dropdownSuboption.contains("Number")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// enterText(valuesTextbox, "");
	// // precision slider (1 to 5)
	// enterText(minNumberTextbox, "");
	// enterText(maxNumberTextbox, "");
	// enterText(descriptionTextbox, "");
	// } else if (dropdownMainoption.contains("Number") &
	// dropdownSuboption.contains("ListOfValue")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// enterText(valuesTextbox, "");
	// clickElement(plusButton);
	// selectFromDropdownByText(defaultValueDropdown, "");
	// enterText(descriptionTextbox, "");
	// } else if (dropdownMainoption.contains("Number") &
	// dropdownSuboption.contains("Currency")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// enterText(valuesTextbox, "");
	// selectFromDropdownByText(currencyDropdown, "");
	// // precision slider
	// enterText(minNumberTextbox, "");
	// enterText(maxNumberTextbox, "");
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderBoolean() {
	// if (dropdownMainoption.contains("Boolean")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// if (getText(togglePosition).equalsIgnoreCase("yes")) {
	// clickElement(toggleYesNo);
	// } else if (getText(togglePosition).equalsIgnoreCase("no")) {
	// clickElement(toggleYesNo);
	// }
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderDate() {
	// if (dropdownMainoption.contains("Date")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// selectExactDate();
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderGroup() {
	// if (dropdownMainoption.contains("Group")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderCollection() {
	// if (dropdownMainoption.contains("Collection")) {
	// // all 11 mainoption and under it all suboptions are available
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// clickElementJS(collectionOfDropdown);
	// // selectMainDropdownOption(mainDropdownOption);
	//
	// // collection of dropdown (again all 11 dropdown value available under which
	// all
	// // suboption)
	// }
	// }
	//
	// public void enterTextUnderLocation() {
	// if (dropdownMainoption.contains("Location")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderFile() {
	// if (dropdownMainoption.contains("File")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderRelation() {
	// if (dropdownMainoption.contains("Relation")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// selectFromDropdownByText(relatedToDropdown, "");
	// // relates to (dropdown : value aviailable is data service names )
	//
	// selectFromDropdownByText(searchOnFieldDropdown, "");
	// selectFromDropdownByText(viewFieldsDropdown, "");
	// // search on fields (dropdown: value available is the attributes under data
	// // service chosen)
	// // selectFromDropdownByText(, "");
	// // view fields (dropdown: value available is the attributes under data
	// service
	// // chosen)
	// enterText(defaultValueTextbox, "");
	// clickElement(deletionOfRecordsSlider);
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderSchema() {
	// if (dropdownMainoption.contains("Schema")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// enterText(linkedLibraryTextbox, "");
	// enterText(descriptionTextbox, "");
	// }
	// }
	//
	// public void enterTextUnderUser() {
	// if (dropdownMainoption.contains("User")) {
	// enterText(customLableTextbox, "");
	// enterText(errorMessageTextbox, "");
	// selectFromDropdownByText(searchOnFieldDropdown, "");
	// selectFromDropdownByText(viewFieldsDropdown, "");
	// selectFromDropdownByText(defaultValueDropdown, "");
	// enterText(descriptionTextbox, "");
	// }
	// }

	public void selectExactDate() {
		JSONObject dateobject = getDateJSON();
		clickElement(selectDate);
		selectFromDropdownByText(month, dateobject.getString("Month"));
		selectFromDropdownByText(year, dateobject.getString("Year"));
		selectFromDropdownByText(hour, dateobject.getString("Hour"));
		selectFromDropdownByText(minute, dateobject.getString("Minute"));
		selectFromDropdownByText(second, dateobject.getString("Second"));
		clickElement(doneButton);
	}

	public JSONObject getDateJSON() {
		JSONObject object = new JSONObject();
		object.put("Month", "January");
		object.putOnce("Year", "2021");
		object.put("Hour", "12");
		object.put("Minute", "12");
		object.put("Seconds", "12");
		return object;

	}

	public void addNEWAttribute() {
		JSONObject object=new JSONObject();
		clickElement(editButton);
		clickElement(editDraft);
		int numberofPreviousAttributes = numberOfPreviousAttributes();
		clickElement(newAttribute);
		int numberOfCurrentAttributes = numberOfPreviousAttributes();
		applyWait(3000);
		if (numberofPreviousAttributes < numberOfCurrentAttributes) {
			nameRecentlyAddedAttribute(object.getString("Attribute Name"));
		}
		selectMainDropdownOption("");
		selectRadioButtonOptions("");
		selectDropdownSuboption("");
		enterTextInTextboxes();
		scrollToElement(saveButtonAttribute);
		clickElement(saveButtonAttribute);
		
	}
}
