package studi.co.pageModules;

import org.testng.asserts.SoftAssert;

import com.android.uiautomator.core.UiSelector;
import com.aventstack.extentreports.Status;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Create_Study_Plan;

public class Module_Create_Study_Plan extends BaseClass{
	Object_Create_Study_Plan oso=new Object_Create_Study_Plan();
	
	public void Verify_Existing_User_Should_Be_Able_To_Navigate_Create_Study_Plan(String property, String property2) {
		SoftAssert sAss = new SoftAssert();
		Boolean status;
		
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo1("Report an issue");
		status = oso.testUnitBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}	
		sAss.assertAll();
	}

	public void Verify_New_User_Should_Be_Able_To_Navigate_To_Study_Plan(String property, String property2) {
		SoftAssert sAss = new SoftAssert();
		Boolean status;
		
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}
		
		status = oso.createStudyPlanTab.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Create Study Plan option shown on landing page");
			test.log(Status.INFO, "Create Study Plan option shown on landing page");
		}		
		sAss.assertAll();
	}

	public void Verify_Existing_User_With_Active_Study_Plan_Able_To_Navigate_Create_Plan(String property,
			String property2) {
		SoftAssert sAss = new SoftAssert();
		Boolean status;
		
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo1("Report an issue");
		status = oso.testUnitBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}	
		
		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitBtn);
		
		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}	
		
		sAss.assertAll();		
	}

	public void Verify_Existing_User_With_Paused_Study_Plan_Able_To_Navigate_To_Test_Plan(String property,
			String property2) {
		SoftAssert sAss = new SoftAssert();
		Boolean status;
		
		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo1("Report an issue");
		status = oso.testUnitBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed on landing page");
			test.log(Status.INFO, "Test Unit tab displayed on landing page");
		}	
		
		System.out.println("Opening Test Unit Tab");
		test.log(Status.INFO, "Opening Test Unit Tab");
		clickOnElement(oso.testUnitBtn);
		
		status = oso.studyLayout.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Active plan of Test Unit displayed");
			test.log(Status.INFO, "Active plan of Test Unit displayed");
		}	
		
		sAss.assertAll();		

		
	}


	

}
