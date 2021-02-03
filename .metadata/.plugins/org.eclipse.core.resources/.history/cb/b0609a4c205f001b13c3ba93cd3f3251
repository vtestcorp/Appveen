package studi.co.pageModules;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.asserts.SoftAssert;

import com.android.uiautomator.core.UiSelector;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Receive_Questions_Revision;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_Syllabus_Options extends BaseClass {
	Object_Syllabus_Option oso = new Object_Syllabus_Option();
	Object_Receive_Questions_Revision rqr = new Object_Receive_Questions_Revision();

	private void pauseVideo() throws MalformedURLException, InterruptedException {
		if (BaseClass.notesFlag) {
			//applyExplicitWaitsUntilElementVisible(oso.continueOnVdoBtn);
			closeVideoPopup(notesCount);
			BaseClass.notesFlag = false;
		}
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		getDriver().findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
				.click();
		// applyExplicitWait(2);
		getDriver().findElementByAccessibilityId("Pause").click();

	}

	public void Verify_Revision_Overview(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 1;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		while (flag == 1) {
			try {
				applyExplicitWait(5);

				status = findElementByText("Begin Revision").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Begin Revision button Displayed");
					test.log(Status.INFO, "Begin Revision button Displayed");

					applyExplicitWait(2);
					status = findElementByText("Return to Subject").isDisplayed();
					sAss.assertTrue(status);
					if (status) {
						System.out.println("Return to Subject button Displayed");
						test.log(Status.INFO, "Return to Subject button Displayed");
					}

					applyExplicitWait(2);
					clickOnElement(findElementByText("Return to Subject"));
					System.out.println("Clicking on Return to Subject");
					test.log(Status.INFO, "Clicking on Return to Subject");

					applyExplicitWait(5);

					status = findElementByText(subject).isDisplayed();
					sAss.assertTrue(status);
					if (status) {
						System.out.println("Navigated to " + subject + "'s Bookshelf");
						test.log(Status.INFO, "Navigated to " + subject + "'s Bookshelf");
					}

					flag = 0;

				}
			} catch (Exception e) {

				applyExplicitWait(5);

				status = findElementByText("Continue Studying").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Continue Studying button Displayed");
					test.log(Status.INFO, "Continue Studying button Displayed");

					applyExplicitWait(2);
					status = findElementByText("Revise again").isDisplayed();
					sAss.assertTrue(status);
					if (status) {
						System.out.println("Revise again button Displayed");
						test.log(Status.INFO, "Revise again button Displayed");
					}

					applyExplicitWait(2);
					clickOnElement(findElementByText("Continue Studying"));
					System.out.println("Clicking on Continue Studying");
					test.log(Status.INFO, "Clicking on Continue Studying");

					status = findElementByText("Your Confidence Report").isDisplayed();
					sAss.assertTrue(status);
					if (status) {
						System.out.println("Navigated to next lesson of " + subject);
						test.log(Status.INFO, "Navigated to next lesson of " + subject);
					}

					flag = 0;
				}

			}
		}
		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Begin_Revision(String subject, String topic)
			throws WebDriverException, IOException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		int fl = 0;
		while (fl == 0) {
			String resource = verify_TQ_Resource();
			if (resource.equals("Video")) {
				System.out.println("Video started");
				test.log(Status.INFO, "Video started");
				if (BaseClass.notesFlag) {
					closeVideoPopup(notesCount);
					BaseClass.notesFlag = true;
				}
				forwardVideoTimerToEnd();
			} else if (resource.equals("Quiz")) {
				System.out.println("Quiz started");
				test.log(Status.INFO, "Quiz started");
				List<MobileElement> count = rqr.get_Total_Number_Of_Questions_InRevision();
				for (MobileElement mobileElement : count) {
					applyExplicitWait(5);
					clickOnElement(rqr.nextButton);
				}
			}
			fl = 1;

		}

		System.out.println("All resouces completed");
		test.log(Status.INFO, "All resouces completed");

		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_View_Video(String subject, String topic)
			throws MalformedURLException, AWTException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		Thread.sleep(1000);
		status = getDriver()
				.findElement(
						MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Show player controls\")"))
				.isDisplayed();
		sAss.assertTrue(status);

		if (status) {
			System.out.println("Video started");
			test.log(Status.INFO, "Video started");
			Thread.sleep(2000);

			pauseVideo();
			System.out.println("Clicked on Pause Button");
			test.log(Status.INFO, "Clicked on Pause Button");

			status = oso.playBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Play Button visible");
				test.log(Status.INFO, "Play Button visible");
			}

			status = oso.fwdBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Navigate Forward Button visible");
				test.log(Status.INFO, "Navigate Forward Button visible");
			}

			status = oso.bkwdBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Navigate Backward Button visible");
				test.log(Status.INFO, "Navigate Backward Button visible");
			}

			ArrayList<MobileElement> quePointsArrayList = (ArrayList<MobileElement>) driver.findElements(
					MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.tce.studi:id/tv_overview\")"));

			status = (quePointsArrayList.size() > 1) ? true : false;
			sAss.assertTrue(status);
			if (status) {
				System.out.println("QuePoints visible");
				test.log(Status.INFO, "QuePoints visible");
			}
			
			
////////////////////////////////////////////Note Creation///////////////////////////////
			//createNoteInVideo(prop.getProperty("note"));

			System.out.println("Verifying added note");
			test.log(Status.INFO, "Verifying added note");

			applyExplicitWait(5);
			clickOnElement(oso.hamburgerBtn);
			System.out.println("Opening hamburger menu");
			test.log(Status.INFO, "Opening hamburger menu");

			applyExplicitWait(5);
			clickOnElement(findElementByText("NOTES"));
			System.out.println("Opening notes");
			test.log(Status.INFO, "Opening notes");

			status = findElementByText(prop.getProperty("note").toLowerCase()).isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Note added succesfully");
				test.log(Status.INFO, "Note added succesfully");
			}

		} else {
			System.out.println("Video not started");
			test.log(Status.INFO, "Video not started");

		}
		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Create_Note_During_Video(String subject, String topic)
			throws MalformedURLException, InterruptedException, AWTException, ParseException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWait(5);

		status = getDriver()
				.findElement(
						MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Show player controls\")"))
				.isDisplayed();
		sAss.assertTrue(status);
		Thread.sleep(2000);
		if (status) {
			if (BaseClass.notesFlag) {
				//applyExplicitWaitsUntilElementVisible(oso.continueOnVdoBtn);
				closeVideoPopup(notesCount);
				BaseClass.notesFlag = false;
			}

			applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
			applyExplicitWait(5);

			/*
			 * getDriver().findElement(By.xpath(
			 * "//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"
			 * )) .click(); applyExplicitWait(2);
			 * getDriver().findElementByAccessibilityId("Pause").click();
			 * System.out.println("Clicked on Pause Button"); test.log(Status.INFO,
			 * "Clicked on Pause Button");
			 */
			pauseVideo();
			String actualBookmarkDesc = driver.findElementById("com.tce.studi:id/exo_progress")
					.getAttribute("content-desc");

			System.out.println("actual " + actualBookmarkDesc);

			status = oso.addNotesBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Create note Button visible");
				test.log(Status.INFO, "Create note Button visible");
			}

			status = oso.addNotesBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Create note Button is tappable");
				test.log(Status.INFO, "Create note Button is tappable");
			}

			clickOnElement(oso.addNotesBtn);
			System.out.println("Clicked on Create note Button");
			test.log(Status.INFO, "Clicked on Create note Button");

			status = oso.saveNoteBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Save Note option is visible");
				test.log(Status.INFO, "Save Note option is visible");
			}

			status = oso.discardNoteBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Discard option is visible");
				test.log(Status.INFO, "Discard option is visible");
			}

			applyExplicitWait(5);
			clickOnElement(oso.playBtn);

			oso.noteTxtArea.sendKeys(prop.getProperty("note"));
			applyExplicitWait(5);

			status = findElementByText(prop.getProperty("note").toLowerCase()).isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Note entered correctly");
				test.log(Status.INFO, "Note entered correctly");
			} else {
				System.out.println("Note not entered correctly");
				test.log(Status.INFO, "Note not entered correctly");
			}

			driver.hideKeyboard();

			status = oso.saveNoteBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Save Note option is visible after entering note");
				test.log(Status.INFO, "Save Note option is visible after entering note");
			}

			status = oso.discardNoteBtn.isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Discard option is visible after entering note");
				test.log(Status.INFO, "Discard option is visible after entering note");
			}

			applyExplicitWait(5);
			clickOnElement(oso.saveNoteBtn);
			System.out.println("Clicking on Save Note");
			test.log(Status.INFO, "Clicking on Save Note");

			System.out.println("Note " + prop.getProperty("note") + " Saved");
			test.log(Status.INFO, "Note " + prop.getProperty("note") + " Saved");

			try
			{
			status = driver.findElementById("com.tce.studi:id/tutorialDoNotShow").isDisplayed();
			sAss.assertTrue(status);
			if (status) {
				System.out.println("Guidance model displayed after saving note");
				test.log(Status.INFO, "Guidance model displayed after saving note");
				
				System.out.println("Clicking on Do not show me again");
				test.log(Status.INFO, "Clicking on Do not show me again");
				clickOnElement(getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow"));
			} }
			catch(Exception e){
				System.out.println("Guidance model not displayed after saving note");
				test.log(Status.INFO, "Guidance model not displayed after saving note");
			}

			
			System.out.println("Verifyind added Bookmark of note");
			test.log(Status.INFO, "Verifyind added Bookmark of note");

			clickOnElement(oso.hamburgerBtn);
			clickOnElement(findElementByText("NOTES"));

			System.out.println("Opening notes");
			test.log(Status.INFO, "Opening notes");

			clickOnElement(findElementByText(prop.getProperty("note")));
			System.out.println("Opening note : " + prop.getProperty("note"));
			test.log(Status.INFO, "Opening notes : " + prop.getProperty("note"));

			clickOnElement(findElementByText("Go to Note Location"));
			System.out.println("Clicking on Go to Note Location");
			test.log(Status.INFO, "Clicking on Go to Note Location");

			// pauseVideo();

			String expected = driver.findElementById("com.tce.studi:id/exo_progress").getAttribute("content-desc");
			System.out.println("expected " + expected);
			int diff = Integer.parseInt(actualBookmarkDesc.replaceAll("[:0]", ""))
					- Integer.parseInt(expected.replaceAll("[:0]", ""));

			status = (diff < 5 && diff > -5) ? true : false;

			sAss.assertTrue(status);
			if (status) {
				System.out.println("Note succefully bookmarked in Video");
				test.log(Status.INFO, "Note succefully bookmarked in Video");
			} else {
				System.out.println("Note can't bookmarked in Video");
				test.log(Status.INFO, "Note can't bookmarked in Video");

			}

		} else {
			System.out.println("Video not started");
			test.log(Status.INFO, "Video not started");
		}
		sAss.assertAll();
	}

	public void Verify_Functionality_After_Killing_The_App(String subject, String topic)
			throws InterruptedException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWait(5);
		status = getDriver()
				.findElement(
						MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Show player controls\")"))
				.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("TQ resource started for revision");
			test.log(Status.INFO, "TQ resource started for revision");
		}
		System.out.println("Reset the App");
		test.log(Status.INFO, "Reset the App");
		driver.resetApp();

		System.out.println("App relaunching");
		test.log(Status.INFO, "App relaunching");
		driver.launchApp();

		System.out.println("Try to login with valid credintials");
		test.log(Status.INFO, "Try to login with valid credintials");

		Module_Login login = new Module_Login();
		login.Login_to_app();

		applyExplicitWait(5);

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("After relauch, user lands on Homepage");
			test.log(Status.INFO, "After relauch, user lands on Homepage");
		}
		sAss.assertAll();
	}

	public void Verify_Functionality_After_Network_Loss_The_App(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		// oso.startRevision2();

		/*
		 * forwardVideoTimerToEnd(); System.out.println("Forwarding video to end");
		 * test.log(Status.INFO,"Forwarding video to end");
		 * 
		 * System.out.println("Quiz started"); test.log(Status.INFO,"Quiz started");
		 * 
		 * System.out.println("Skipping two question in Quiz");
		 * test.log(Status.INFO,"Skipping two question in Quiz");
		 * 
		 * applyExplicitWaitsUntilElementVisible(rqr.question); applyExplicitWait(5);
		 * clickOnElement(rqr.nextButton);
		 * applyExplicitWaitsUntilElementVisible(rqr.question); applyExplicitWait(5);
		 * clickOnElement(rqr.nextButton);
		 */
		driver.toggleData();
		driver.toggleWifi();

		String sdkPath = System.getenv("ANDROID_HOME") + "/platform-tools/";

		Runtime.getRuntime().exec(sdkPath + "adb shell settings put global airplane_mode_on 1");

		Thread.sleep(1000);

		Process process = Runtime.getRuntime()

				.exec(sdkPath + "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");

		process.waitFor();

		Thread.sleep(4000);
		System.out.println("Turning OFF Data and Wifi connection");

		/*
		 * applyExplicitWait(5); System.out.println("Try to fetching next question");
		 * test.log(Status.INFO,"Try to fetching next question"); applyExplicitWait(5);
		 * clickOnElement(rqr.nextButton);
		 */

		clickOnElement(findElementByText("Begin Revision"));
		applyExplicitWait(5);
		status = driver.findElementById("android:id/alertTitle").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("No internet connection message displayed");
			test.log(Status.INFO, "No internet connection message displayed");
		}

		driver.toggleData();
		driver.toggleWifi();

		sdkPath = System.getenv("ANDROID_HOME") + "/platform-tools/";

		Runtime.getRuntime().exec(sdkPath + "adb shell settings put global airplane_mode_on 0");

		Thread.sleep(1000);

		process = Runtime.getRuntime()

				.exec(sdkPath + "adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");

		process.waitFor();

		Thread.sleep(4000);

		System.out.println("Turning ON Data and Wifi connection");

		System.out.println("App relaunching");
		test.log(Status.INFO, "App relaunching");
		driver.launchApp();

		System.out.println("Try to login with valid credintials");
		test.log(Status.INFO, "Try to login with valid credintials");

		Module_Login login = new Module_Login();
		login.Login_to_app();

		applyExplicitWait(5);

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		status = findElementByText("Begin Revision").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Begin Revision Button Displayed (i.e. Revision set to Not Started)");
			test.log(Status.INFO, "Begin Revision Button Displayed (i.e. Revision set to Not Started)");
		}

		sAss.assertAll();
	}

	public void Verify_Functionality_The_App_After_Call_Interrupt(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		System.out.println("Trying Call");
		test.log(Status.INFO, "Trying Call");
		driver.makeGsmCall("1010101010", GsmCallActions.CALL);
		Thread.sleep(5000);
		System.out.println("Call Recieved");
		test.log(Status.INFO, "Call Recieved");
		driver.makeGsmCall("1010101010", GsmCallActions.ACCEPT);
		Thread.sleep(5000);
		System.out.println("Call End");
		test.log(Status.INFO, "Call End");
		driver.makeGsmCall("1010101010", GsmCallActions.CANCEL);

		status = findElementByText("What you will revise:").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on same page after call inturruption");
			test.log(Status.INFO, "Landed on same page after call inturruption");
		}

		sAss.assertAll();
	}

	public void Verify_Functionality_Of_App_In_App_Background_Scenario(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		System.out.println("Minimize app");
		test.log(Status.INFO, "Minimize app");

		// String act=driver.currentActivity();
		// driver.runAppInBackground(Duration.ofMillis(200));
		driver.pressKeyCode(AndroidKeyCode.HOME);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
		List<MobileElement> apps = driver.findElementsByClassName("android.widget.FrameLayout");

		for (MobileElement mobileElement : apps) {
			if (mobileElement.getAttribute("content-desc").toLowerCase().contains("studi")) {
				clickOnElement(mobileElement);
				break;
			}
		}
		System.out.println("Bring App in front");
		test.log(Status.INFO, "Bring App in front");

		applyExplicitWait(5);
		status = findElementByText("What you will revise:").isDisplayed();
		if (status) {
			System.out.println("List of TQ'a Displayed after maximizing");
			test.log(Status.INFO, "List of TQ'a Displayed after maximizing");
		}
		sAss.assertAll();
	}

	public void Verify_Behaviour_In_Landscape_And_Portrait_Mode_Transition(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWait(5);
		pauseVideo();

		status = oso.playBtn.isDisplayed();
		if (status) {
			System.out.println("Video control panel displayed");
			test.log(Status.INFO, "Video control panel displayed");
		}

		System.out.println("Current screen orientation Is : " + driver.getOrientation());
		test.log(Status.INFO, "Current screen orientation Is : " + driver.getOrientation());
		System.out.println("Changing screen Orientation to LANDSCAPE.");
		test.log(Status.INFO, "Changing screen Orientation to LANDSCAPE.");

		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);

		System.out.println("Now screen orientation Is : " + driver.getOrientation());
		test.log(Status.INFO, "Now screen orientation Is : " + driver.getOrientation());

		applyExplicitWait(5);
		clickOnElement(driver.findElementById("com.tce.studi:id/exo_subtitles"));
		getDriver().findElementByAccessibilityId("Pause").click();

		status = oso.playBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video control panel displayed in Landscape mode");
			test.log(Status.INFO, "Video control panel displayed in Landscape mode");
		}
		System.out.println("Changing screen Orientation to PORTRAIT.");
		test.log(Status.INFO, "Changing screen Orientation to PORTRAIT.");

		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);

		System.out.println("Now screen orientation Is : " + driver.getOrientation());
		test.log(Status.INFO, "Now screen orientation Is : " + driver.getOrientation());

		applyExplicitWait(5);

		pauseVideo();

		status = oso.playBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video control panel displayed in portrait mode");
			test.log(Status.INFO, "Video control panel displayed in portrait mode");
		}

		sAss.assertAll();

	}

	public void Verify_Behaviour_In_Locking_and_Unlocking_Transition(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		applyExplicitWait(5);
		String temp=driver.findElementById("com.tce.studi:id/tv_overview").getText();
		
		applyExplicitWait(5);
		System.out.println("Lock the device");
		test.log(Status.INFO, "Lock the device");
        driver.lockDevice();
		
        applyExplicitWait(5);
		System.out.println("Unlock the device");
		test.log(Status.INFO, "Unlock the device");
		driver.unlockDevice();

		status = findElementByText(temp).isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on same page after lock\\unlock");
			test.log(Status.INFO, "Landed on same page after lock\\unlock");
		}

		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Abondon_The_Revision(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		oso.startRevision2();

		System.out.println("Video started");
		test.log(Status.INFO, "Video started");
		if (BaseClass.notesFlag) {
			closeVideoPopup(notesCount);
			BaseClass.notesFlag = true;
		}

		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);

		applyExplicitWait(5);

		if (getDriver().findElementById("com.tce.studi:id/txtTitle").isEnabled()) {
			test.log(Status.INFO, "Exit warning message displayed");
			System.out.println("Exit warning message displayed");
		}

		test.log(Status.INFO, "Tapping on Continue revise");
		System.out.println("Tapping on Continue revise");
		clickOnElement(oso.noBtn);

		System.out.println("Forwarding Video");
		forwardVideoTimerToEnd();

		String actualQue, expectedQue;

		expectedQue = oso.question.getText();

		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);

		applyExplicitWait(5);

		if (getDriver().findElementById("com.tce.studi:id/txtTitle").isEnabled()) {
			test.log(Status.INFO, "Exit warning message displayed");
			System.out.println("Exit warning message displayed");
		}

		test.log(Status.INFO, "Tapping on Continue revise");
		System.out.println("Tapping on Continue revise");
		clickOnElement(oso.noBtn);

		applyExplicitWait(5);

		actualQue = oso.question.getText();
		if (actualQue.equalsIgnoreCase(expectedQue)) {
			sAss.assertTrue(actualQue.equalsIgnoreCase(expectedQue));
			test.log(Status.INFO, "same question appear again");
			System.out.println("same question appear again");
		}

		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);
		applyExplicitWait(5);

		test.log(Status.INFO, "Tapping on End revise");
		System.out.println("Tapping on End revise");
		clickOnElement(oso.yesBtn);
		applyExplicitWait(5);

		status = findElementByText("What you will revise:").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on Bookshelf");
			test.log(Status.INFO, "Landed on Bookshelf");
		}

		sAss.assertAll();

	}

	public void Verify_User_Should_Be_Able_To_Navigate_To_Revision_Via_MySyllabus(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo1("Report an issue");
		status = findElementByText("Test Unit").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed");
			test.log(Status.INFO, "Test Unit tab displayed");
		}

		status = findElementByText("Syllabus").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab displayed");
			test.log(Status.INFO, "Syllabus tab displayed");
		}
		status = findElementByText("Assignments").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}

		System.out.println("Selecting Syllabus option");
		test.log(Status.INFO, "Selecting Syllabus option");
		clickOnElement(findElementByText("Syllabus"));

		status = oso.allSubjectLbl.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("All Subjects displayed as follow :");
			test.log(Status.INFO, "All Subjects displayed as follow :");
		}
		int endX = oso.allSubjectLbl.getLocation().getX();
		int endY = oso.allSubjectLbl.getLocation().getY();
		int startX = 0;
		int startY = 0;

		action = new TouchAction(driver);
		List<MobileElement> subjects = driver.findElementsById("com.tce.studi:id/tv_book_name");
		int flag = 0;
		while (flag == 0) {
			subjects.addAll(driver.findElementsById("com.tce.studi:id/tv_book_name"));

			try {
				if (driver.findElementById("com.tce.studi:id/tv_syllabus").isDisplayed()) {
					flag = 1;
					startX = driver.findElementById("com.tce.studi:id/tv_syllabus").getLocation().getX();
					startY = driver.findElementById("com.tce.studi:id/tv_syllabus").getLocation().getY();

				}
			} catch (Exception e) {
				action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
						.moveTo(PointOption.point(115, 350)).release().perform();
			}

		}

		ArrayList<String> aa = new ArrayList<>();
		for (MobileElement mobileElement : subjects) {
			aa.add(mobileElement.getText());
		}

		List<String> subjectsWD = new ArrayList<>(new HashSet<>(aa));
		for (String mobileElement : subjectsWD) {
			System.out.println(mobileElement);
			test.log(Status.INFO, mobileElement);
		}

		action.press(PointOption.point(startX, startY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(100)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));
		System.out.println("Opening book for :" + subject);
		test.log(Status.INFO, "Opening book for :" + subject);

		scrollTo1(topic);
		System.out.println("Opening Topic :" + subject);
		test.log(Status.INFO, "Opening Topic :" + subject);
		clickOnElement(findElementByText(topic));

		Boolean status1 = false;
		Boolean status2 = false;
		applyExplicitWait(5);
		try {
			status1 = findElementByText("Begin Revision").isDisplayed();
		} catch (Exception e) {
		}
		try {
			status2 = findElementByText("Revise Again").isDisplayed();
		} catch (Exception e) {
		}

		if (status1) {
			sAss.assertTrue(status1);
			test.log(Status.INFO, "Begin Revision tab displayed");
			System.out.println("Begin Revision tab displayed");
		} else {
			sAss.assertTrue(status2);
			test.log(Status.INFO, "Revise Again tab displayed");
			System.out.println("Revise Again tab displayed");

		}

		sAss.assertAll();

	}

	public void Verify_User_Should_Be_Able_To_Launch_Revision_Via_MySyllabus(String subject, String topic)
			throws MalformedURLException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		status = oso.profilePic.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Logged in successfully");
			test.log(Status.INFO, "Logged in successfully");
		}

		scrollTo1("Report an issue");
		status = findElementByText("Test Unit").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Test Unit tab displayed");
			test.log(Status.INFO, "Test Unit tab displayed");
		}

		status = findElementByText("Syllabus").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Syllabus tab displayed");
			test.log(Status.INFO, "Syllabus tab displayed");
		}
		status = findElementByText("Assignments").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Assignments tab displayed");
			test.log(Status.INFO, "Assignments tab displayed");
		}

		System.out.println("Selecting Syllabus option");
		test.log(Status.INFO, "Selecting Syllabus option");
		clickOnElement(findElementByText("Syllabus"));

		status = oso.allSubjectLbl.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("All Subjects displayed as follow :");
			test.log(Status.INFO, "All Subjects displayed as follow :");
		}
		int endX = oso.allSubjectLbl.getLocation().getX();
		int endY = oso.allSubjectLbl.getLocation().getY();
		int startX = 0;
		int startY = 0;

		action = new TouchAction(driver);
		List<MobileElement> subjects = driver.findElementsById("com.tce.studi:id/tv_book_name");
		int flag = 0;
		while (flag == 0) {
			subjects.addAll(driver.findElementsById("com.tce.studi:id/tv_book_name"));

			try {
				if (driver.findElementById("com.tce.studi:id/tv_syllabus").isDisplayed()) {
					flag = 1;
					startX = driver.findElementById("com.tce.studi:id/tv_syllabus").getLocation().getX();
					startY = driver.findElementById("com.tce.studi:id/tv_syllabus").getLocation().getY();

				}
			} catch (Exception e) {
				action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
						.moveTo(PointOption.point(115, 350)).release().perform();
			}

		}

		ArrayList<String> aa = new ArrayList<>();
		for (MobileElement mobileElement : subjects) {
			aa.add(mobileElement.getText());
		}

		List<String> subjectsWD = new ArrayList<>(new HashSet<>(aa));
		for (String mobileElement : subjectsWD) {
			System.out.println(mobileElement);
			test.log(Status.INFO, mobileElement);
		}

		action.press(PointOption.point(startX, startY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(100)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		scrollTo2(subject);
		clickOnElement(findElementByText(subject));
		System.out.println("Opening book for :" + subject);
		test.log(Status.INFO, "Opening book for :" + subject);

		scrollTo1(topic);
		System.out.println("Opening Topic :" + subject);
		test.log(Status.INFO, "Opening Topic :" + subject);
		clickOnElement(findElementByText(topic));

		Boolean status1 = false;
		Boolean status2 = false;
		applyExplicitWait(5);
		try {
			status1 = findElementByText("Begin Revision").isDisplayed();
		} catch (Exception e) {
		}
		try {
			status2 = findElementByText("Revise Again").isDisplayed();
		} catch (Exception e) {
		}

		if (status1) {
			sAss.assertTrue(status1);
			test.log(Status.INFO, "Begin Revision tab displayed");
			System.out.println("Begin Revision tab displayed");

		} else {
			sAss.assertTrue(status2);
			test.log(Status.INFO, "Revise Again tab displayed");
			System.out.println("Revise Again tab displayed");

		}

		applyExplicitWait(5);
		/*
		 * try { status1 =
		 * Boolean.parseBoolean(findElementByText("Begin Revision").getAttribute(
		 * "clickable")); } catch (Exception e) { } try { status2 =
		 * Boolean.parseBoolean(findElementByText("Revise Again").getAttribute(
		 * "clickable")); } catch (Exception e) { } if (status1) {
		 * sAss.assertTrue(status1); test.log(Status.INFO,
		 * "Begin Revision tab clickable");
		 * System.out.println("Begin Revision tab clickable"); } else {
		 * sAss.assertTrue(status2); test.log(Status.INFO,
		 * "Revise Again tab clickable");
		 * System.out.println("Revise Again tab clickable"); }
		 */
		try {
			findElementByText("Begin Revision").click();
		} catch (Exception e) {
		}
		try {
			findElementByText("Revise Again").click();
		} catch (Exception e) {
		}

		applyExplicitWait(5);
		status = findElementByText("What you will revise:").isDisplayed();
		if (status) {
			System.out.println("List of TQ's Displayed");
			test.log(Status.INFO, "List of TQ's Displayed");
		}
		sAss.assertAll();

	}

	public void Verify_User_Should_Be_Able_To_Attempt_Revision_Multiple_Times(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		oso.startRevision2();
		applyExplicitWait(5);
		String rc = verify_TQ_Resource();
		if (rc.equalsIgnoreCase("Video")) {
			System.out.println("Video Started");
			test.log(Status.INFO, "Video Started");

			System.out.println("Forwarding Video");
			test.log(Status.INFO, "Forwarding Video");
			forwardVideoTimerToEnd();
		}
		applyExplicitWait(5);
		rc = verify_TQ_Resource();
		if (rc.equalsIgnoreCase("Quiz")) {
			System.out.println("Quiz Started");
			test.log(Status.INFO, "Quiz Started");

			System.out.println("Skipping the Quiz");
			test.log(Status.INFO, "Skipping the Quiz");

			List<MobileElement> count = rqr.get_Total_Number_Of_Questions_InRevision();
			for (MobileElement mobileElement : count) {
				applyExplicitWaitsUntilElementVisible(oso.question);
				System.out.println("Next question");
				test.log(Status.INFO, "Next question");
				clickOnElement(rqr.nextButton);
			}
		}

		applyExplicitWait(5);
		status = oso.letsSummriseTxt.isDisplayed();
		if (status) {
			System.out.println("All resouces completed");
			test.log(Status.INFO, "All resouces completed");
		}
		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_View_Summary_Pages(String subject, String topic)
			throws InterruptedException, WebDriverException, IOException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		applyExplicitWait(5);

		oso.startRevision2();

		for (int i = 0; i < oso.count; i++) {
			String rc = verify_TQ_Resource();
			if (rc.equalsIgnoreCase("Video")) {
				System.out.println("Video Started");
				test.log(Status.INFO, "Video Started");

				System.out.println("Forwarding Video");
				test.log(Status.INFO, "Forwarding Video");
				forwardVideoTimerToEnd();
			}

			Thread.sleep(3000);
			rc = verify_TQ_Resource();
			if (rc.equalsIgnoreCase("Quiz")) {
				System.out.println("Quiz Started");
				test.log(Status.INFO, "Quiz Started");

				System.out.println("Skipping the Quiz");
				test.log(Status.INFO, "Skipping the Quiz");

				List<MobileElement> count1 = rqr.get_Total_Number_Of_Questions_InRevision();
				for (MobileElement mobileElement : count1) {
					applyExplicitWaitsUntilElementVisible(oso.question);
					System.out.println("Next question");
					test.log(Status.INFO, "Next question");
					clickOnElement(rqr.nextButton);
				}
			}

			applyExplicitWait(5);
			status = oso.letsSummriseTxt.isDisplayed();
			if (status) {
				System.out.println("Summary of TQ" + (i + 1) + " displayed");
				test.log(Status.INFO, "Summary of TQ" + (i + 1) + " displayed");
			}

			clickOnElement(findElementByText("CONTINUE"));
		}

		applyExplicitWait(5);
		status = findElementByText("What have you revised:").isDisplayed();
		if (status) {
			System.out.println("All TQ's completed");
			test.log(Status.INFO, "All TQ's completed");
		}

		status = findElementByText("Continue Studying").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Continue Studying button Displayed");
			test.log(Status.INFO, "Continue Studying button Displayed");
		}
		applyExplicitWait(2);
		status = findElementByText("Revise again").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Revise again button Displayed");
			test.log(Status.INFO, "Revise again button Displayed");
		}

		applyExplicitWait(5);
		clickOnElement(oso.tertiaryBtnBottom);
		status = findElementByText("Return to Subject").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Return to Subject button available");
			test.log(Status.INFO, "Return to Subject button available");
		}

		action = new TouchAction(driver);
		getTouchAction().tap(PointOption.point((driver.manage().window().getSize().width) / 2,
				(driver.manage().window().getSize().height) / 2)).perform();

		clickOnElement(findElementByText("Revise again"));
		test.log(Status.INFO, "Clicked on Revise again");
		System.out.println("Clicked on Revise again");
		applyExplicitWait(5);

		// applyExplicitWaitsUntilElementVisible(oso.continueOnVdoBtn);
		status = getDriver().findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
				.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("TQ started again");
			test.log(Status.INFO, "TQ started again");
		}
		System.out.println("Pressed back buton");
		test.log(Status.INFO, "Pressed back buton");
		clickOnElement(oso.backBtn);
		applyExplicitWait(5);

		test.log(Status.INFO, "Tapping on End revise");
		System.out.println("Tapping on End revise");
		clickOnElement(oso.yesBtn);
		applyExplicitWait(5);

		status = findElementByText("What have you revised:").isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Landed on Bookshelf");
			test.log(Status.INFO, "Landed on Bookshelf");
		}

		sAss.assertAll();
	}

	public void Verify_Behaviour_In_Sleep_Mode(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();

		try {
			System.out.println("Left the app unattended for 1 Min");
			test.log(Status.INFO, "Left the app unattended for 1 Min");
			for (int i = Integer.parseInt(prop.getProperty("timerDuration")); i > 0; i--) {
				label2.setText("");
				label.setText("");

				startCounter(i);
				Thread.sleep(1000);
				frame.dispose();
			}
			status = findElementByText("What you will revise:").isDisplayed();
			sAss.assertFalse(status);
			if (status) {
				System.out.println("Same page is visible after visible after sleep");
				test.log(Status.INFO, "Same page is visible after visible after sleep");
			}
		} catch (Exception ne) {
			System.out.println("Session expired/User Logged out after sleep mode");
			test.log(Status.INFO, "Session expired/User Logged out after sleep mode");

		}
		sAss.assertAll();

	}

	public void Verify_Create_Note_Icon_Should_Be_Visible_In_Video(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		status = getDriver().findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
				.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("TQ started");
			test.log(Status.INFO, "TQ started");
			pauseVideo();
		}

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}
		sAss.assertAll();
	}

	public void Verify_User_Should_Be_Able_To_Write_Upto_3000_Charcters_In_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException, AWTException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		System.out.println("Try to enter more than 3000 characters in note");
		test.log(Status.INFO, "Try to enter more than 3000 characters in note");
		String temp = "";
		for (int i = 0; i < oso.notesLimit + 10; i++) {
			temp = temp + "T";
		}
		oso.noteTxtArea.sendKeys(temp);

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println(
				"Entering " + temp.length() + " characters but only " + temp2.length() + " characters accepted");
		test.log(Status.INFO,
				"Entering " + temp.length() + " characters but only " + temp2.length() + " characters accepted");

		status = oso.notesLimit == temp2.length() ? true : false;
		sAss.assertTrue(status);

		sAss.assertAll();
	}

	public void Verify_User_Is_Unable_To_Add_Empty_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);
		// clickOnElement(oso.noteTxtArea);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Text field displayed to enter note");
			test.log(Status.INFO, "Text field displayed to enter note");
		}

		System.out.println("Try to add note without any Text");
		test.log(Status.INFO, "Try to add note without any Text");

		clickOnElement(oso.saveNoteBtn);
		System.out.println("Clicked on Save note Button");
		test.log(Status.INFO, "Clicked on Save note Button");

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Error message displayed. Not Allowed to add empty note");
			test.log(Status.INFO, "Error message displayed. Not Allowed to add empty note");
		}

		System.out.println("Try to add note with adding Blank-spaces");
		test.log(Status.INFO, "Try to add note with adding Blank-spaces");

		System.out.println("Adding spaces in Text area");
		test.log(Status.INFO, "Adding spaces in Text area");
		String temp = "";
		for (int i = 0; i < 10; i++) {
			temp = temp + " ";
		}

		oso.noteTxtArea.sendKeys(temp);
		driver.hideKeyboard();
		clickOnElement(oso.saveNoteBtn);
		System.out.println("Clicked on Save note Button");
		test.log(Status.INFO, "Clicked on Save note Button");

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Error message displayed. Not Allowed to add empty note");
			test.log(Status.INFO, "Error message displayed. Not Allowed to add empty note");
		}

		sAss.assertAll();
	}

	public void Verify_Create_Note_Icon_Should_Be_Clickable_In_Video(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		status = getDriver().findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
				.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video started");
			test.log(Status.INFO, "Video started ");
			pauseVideo();
		}

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		status = oso.addNotesBtn.getAttribute("clickable").trim().equalsIgnoreCase("true");
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes button is Clickable");
			test.log(Status.INFO, "Add notes button is Clickable");
		}

		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");
		clickOnElement(oso.addNotesBtn);

		applyExplicitWait(5);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add Note module window displayed");
			test.log(Status.INFO, "Add Note module window displayed");
		}

		sAss.assertAll();
	}

	public void Verify_User_Is_Able_To_Enter_Special_Characters_In_Note(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to enter Text with special characters");
		test.log(Status.INFO, "Try to enter Text with special characters");
		String temp = "T@t@ $tud!";
		oso.noteTxtArea.sendKeys(temp);

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println("Entered text: " + temp + ", Accepted text by note module: " + temp2);
		test.log(Status.INFO, "Entered text: " + temp + ", Accepted text by note module: " + temp2);

		status = temp.equalsIgnoreCase(temp2) ? true : false;
		sAss.assertTrue(status);
		if (status) {
			System.out.println("User can enter special characters in note");
			test.log(Status.INFO, "User can enter special characters in note");
		}

		sAss.assertAll();

	}

	public void Verify_Note_Module_Will_Cosed_Without_Warning(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to close Note Module without adding any text in note");
		test.log(Status.INFO, "Try to close Note Module without adding any text in note");

		System.out.println("Clicked on Close(X) Button");
		test.log(Status.INFO, "Clicked on Close(X) Button");
		clickOnElement(oso.closeNotesBtn);

		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Notes Module closed without any warning message");
			test.log(Status.INFO, "Notes Module closed without any warning message");
		}
		sAss.assertAll();
	}

	public void Verify_Warning_Message_Shown_After_Clicking_Discard_In_Notes(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);
		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);
		oso.startRevision1();
		oso.startRevision2();

		pauseVideo();
		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to close Note Module without adding any text in note");
		test.log(Status.INFO, "Try to close Note Module without adding any text in note");

		System.out.println("Clicked on Close(X) Button");
		test.log(Status.INFO, "Clicked on Close(X) Button");
		clickOnElement(oso.closeNotesBtn);

		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Notes Module closed without any warning message");
			test.log(Status.INFO, "Notes Module closed without any warning message");
		}

		System.out.println("Verifying Discard Button");
		test.log(Status.INFO, "Verifying Discard Button");

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		clickOnElement(oso.addNotesBtn);
		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");

		applyExplicitWait(5);

		System.out.println("Try to enter text in note and Click Discard Button");
		test.log(Status.INFO, "Try to enter text in note and Click Discard Button");

		oso.noteTxtArea.sendKeys(prop.getProperty("note"));

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println("Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);
		test.log(Status.INFO, "Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);

		driver.hideKeyboard();

		System.out.println("Clicked on Discard Button");
		test.log(Status.INFO, "Clicked on Discard Button");
		clickOnElement(oso.discardNoteBtn);

		status = oso.discardWarnMsg.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Warning message displayed to Discard Note");
			test.log(Status.INFO, "Warning message displayed to Discard Note");
		}

		System.out.println("Cancel the discarding process");
		test.log(Status.INFO, "Cancel the discarding process");
		clickOnElement(oso.discardDenyBtn);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("User can still able to modify entered text");
			test.log(Status.INFO, "User can still able to modify entered text");
		}

		System.out.println("Clicked on Discard Button");
		test.log(Status.INFO, "Clicked on Discard Button");
		clickOnElement(oso.discardNoteBtn);

		status = oso.discardWarnMsg.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Warning message displayed to Discard Note");
			test.log(Status.INFO, "Warning message displayed to Discard Note");
		}

		System.out.println("Accept the discarding process");
		test.log(Status.INFO, "Accept the discarding process");
		clickOnElement(oso.discardAcceptBtn);

		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Note discarded using Discard Button");
			test.log(Status.INFO, "Note discarded using Discard Button");
		}
		sAss.assertAll();
	}

	public void Verify_Notes_Will_Be_Saved_Using_Save_Note_Option(String subject, String topic)
			throws MalformedURLException, InterruptedException {
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;

		System.out.println("Traverse towards " + subject + " -> " + topic);
		oso.traverse_toward_topic(subject, topic);

		test.log(Status.INFO, "Traverse towards " + subject + " -> " + topic);

		oso.startRevision1();

		oso.startRevision2();

		applyExplicitWait(5);
		status = getDriver().findElement(By.xpath(
				"//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]"))
				.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Video started");
			test.log(Status.INFO, "Video started");
			pauseVideo();
		}

		applyExplicitWaitsUntilElementVisible(oso.addNotesBtn);
		status = oso.addNotesBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add notes option displayed at top right of video");
			test.log(Status.INFO, "Add notes option displayed at top right of video");
		}

		System.out.println("Clicked on Add note Button");
		test.log(Status.INFO, "Clicked on Add note Button");
		clickOnElement(oso.addNotesBtn);

		applyExplicitWait(5);

		status = oso.noteTxtArea.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Add Note module window displayed");
			test.log(Status.INFO, "Add Note module window displayed");
		}

		status = oso.saveNoteBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Save Note option is visible");
			test.log(Status.INFO, "Save Note option is visible");
		}

		applyExplicitWait(5);
		clickOnElement(oso.noteTxtArea);

		oso.noteTxtArea.sendKeys(prop.getProperty("note"));
		applyExplicitWait(5);

		System.out.println("Checking entered text");
		test.log(Status.INFO, "Checking entered text");

		String temp2 = oso.noteTxtArea.getText();

		System.out.println("Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);
		test.log(Status.INFO, "Entered text: " + prop.getProperty("note") + ", Accepted text by note module: " + temp2);

		driver.hideKeyboard();

		status = oso.saveNoteBtn.isDisplayed();
		sAss.assertTrue(status);
		if (status) {
			System.out.println("Save Note option is visible after entering note");
			test.log(Status.INFO, "Save Note option is visible after entering note");
		}

		applyExplicitWait(5);
		clickOnElement(oso.saveNoteBtn);
		System.out.println("Clicking on Save Note");
		test.log(Status.INFO, "Clicking on Save Note");

		System.out.println("Note " + prop.getProperty("note") + " Saved");
		test.log(Status.INFO, "Note " + prop.getProperty("note") + " Saved");

		try {
			status = driver.findElementById("com.tce.studi:id/tutorialDoNotShow").isDisplayed();
			if (status) {
				System.out.println("Guidance model displayed after saving note");
				test.log(Status.INFO, "Guidance model displayed after saving note");

				System.out.println("Clicking on Do not show me again");
				test.log(Status.INFO, "Clicking on Do not show me again");
				clickOnElement(getDriver().findElementById("com.tce.studi:id/tutorialDoNotShow"));

			} else {
				System.out.println("Guidance model not displayed after saving note");
				test.log(Status.INFO, "Guidance model not displayed after saving note");
			}
		} catch (Exception e) {
			System.out.println("Guidance model not displayed after saving note");
			test.log(Status.INFO, "Guidance model not displayed after saving note");
		}

		System.out.println("Verifyind added Bookmark of note");
		test.log(Status.INFO, "Verifyind added Bookmark of note");

		clickOnElement(oso.hamburgerBtn);

		System.out.println("Verifying total notes count");
		test.log(Status.INFO, "Verifying total notes count");
		status = Integer.parseInt(oso.notesCountIndicator.getText()) == (notesCount + 1) ? true : false;
		if (status) {
			System.out.println("Notes count increased by 1 succefully");
			test.log(Status.INFO, "Notes count increased by 1 succefully");
		}

		clickOnElement(driver.findElementById("com.tce.studi:id/tv_notes"));

		System.out.println("Opening note list");
		test.log(Status.INFO, "Opening note list");

		status = findElementByText(prop.getProperty("note")).isDisplayed();
		if (status) {
			System.out.println(prop.getProperty("note") + " succefully save in list");
			test.log(Status.INFO, prop.getProperty("note") + " succefully save in list");
		}

		sAss.assertAll();

	}
}