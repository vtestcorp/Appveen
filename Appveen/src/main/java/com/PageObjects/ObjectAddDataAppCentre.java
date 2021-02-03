package com.PageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ObjectAddDataAppCentre extends ObjectLoginAppCentre {

	public ObjectAddDataAppCentre() {
		super();
	}

	//// fields added in author for DS visible here in App Centre///////////
	public By addDataButton = By.xpath("//span[normalize-space()='Add Data']");
	public By nameTextBox = By.xpath("//input[@id='name']");
	public By idTextBox = By.xpath("//input[@id='_id']");

	////// Dynamic Locator for Adding Attribute in App Centre after clicking Add
	////// Data //////////
	public By allinputTextBoxes = By.xpath("//input");

	///////// buttons for adding data/////////
	public By cancelButton = By.xpath("//span[normalize-space()='Cancel']");
	public By saveNCreateanotherButton = By.xpath("//span[normalize-space()='Save & create another']");
	public By saveButton = By.xpath("//span[normalize-space()='Save']");

	///// checkbox for editing /////////////
	public By allcheckBoxes = By.xpath("//div[@col-id='_checkbox']");
	public By selectcheckBoxForAll = By.xpath("//strong[text()='Select all ']");
	public By editButton = By.xpath("//span[contains(text(),'Edit')]");
	public By saveChangesButton = By.xpath("//span[text()='Edit']");
	public By deleteButton = By.xpath("//span[contains(text(),'Delete')]");

	/// all Elements id ////////////
	public By allIds = By.xpath("//div[@col-id='_id']");

	////// Pop-up Yes No //////////////
	public By yesPopup = By.xpath("//button[text()='No']");
	public By noPopup = By.xpath("//button[text()='Yes']");

}
