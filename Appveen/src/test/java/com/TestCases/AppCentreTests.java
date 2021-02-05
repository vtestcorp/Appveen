package com.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageModules.AddDataAppCentre;
import com.PageModules.LaunchAppCentre;
import com.PageModules.LaunchAuthor;
import com.PageObjects.ObjectAddDataAppCentre;
import com.Utility.BaseClass;
import com.Utility.Config;

public class AppCentreTests extends BaseClass {

	public AppCentreTests() {
		super();
	}
	

	@Test
	public void TC01() {
		LaunchAppCentre centre = new LaunchAppCentre();
		AddDataAppCentre centred=new AddDataAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		centred.IsAddDataButtonDisplayed();
		int number=centred.getCheckboxesNumber();
		System.out.println("Number of entries are : "+number);
		centred.isSelectAllCheckBoxSelected();
		centred.isDeleteIconDisplayed();
		centred.isEditIconDisplayed();
		
	}

	@Test(enabled = false)
	public void TC02() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		AddDataAppCentre adddataappcentre = new AddDataAppCentre();
		adddataappcentre.addData();
	}

	@Test(enabled = true)
	public void TC03() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		AddDataAppCentre centred = new AddDataAppCentre();
		centred.deleteEntry("123");
	}

	@Test(enabled = true)
	public void TC04() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		AddDataAppCentre centred = new AddDataAppCentre();
		centred.editEntryById("123", "_id", "1234567");
	}

	@Test(enabled=true)
	public void UI01() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		centre.applyWait(5000);
		AddDataAppCentre adddataappcentre = new AddDataAppCentre();
		adddataappcentre.isSelectAllCheckBoxSelected();
	}

	@Test (enabled =true)
	public void UI02() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		AddDataAppCentre adddataappcentre = new AddDataAppCentre();
		adddataappcentre.applyWait(5000);
		adddataappcentre.individualCheckBoxSelectable();
	}

	@Test(enabled=true)
	public void UI03() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		AddDataAppCentre adddataappcentre = new AddDataAppCentre();
		adddataappcentre.applyWait(5000);
		boolean result = adddataappcentre.isDeleteIconDisplayed();
		if (result) {
			System.out.println("the element is displayed");
		}
	}

	@Test(enabled=true)
	public void UI04() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		centre.applyWait(5000);
		AddDataAppCentre adddataappcentre = new AddDataAppCentre();
		adddataappcentre.applyWait(5000);
		boolean result = adddataappcentre.isEditIconDisplayed();
		if (result) {
			System.out.println("the element is displayed");
		}
	}

	@Test (enabled =true)
	public void UI05() {
		LaunchAppCentre centre = new LaunchAppCentre();
		centre.launchAppCentre();
		centre.loginAppCentre();
		AddDataAppCentre adddataappcentre = new AddDataAppCentre();
		adddataappcentre.applyWait(5000);
		boolean result = adddataappcentre.isAddDateButtonClickable();
		if (result) {
			System.out.println("AddData Button clickable");
		}
	}

}
