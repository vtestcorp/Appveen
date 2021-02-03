package studi.co.pageObjects;

import android.*;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.aventstack.extentreports.Status;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import studi.co.Base.BaseClass;

public class Object_Syllabus_Option extends BaseClass {

	public Object_Syllabus_Option() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	public int count = 0;
	@AndroidFindBy(id = "com.tce.studi:id/tv_lets_summarise")
	public WebElement letsSummriseTxt;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	public WebElement allSubjectLbl;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Begin Revision\")")
	public WebElement beginRbtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_play\").className(\"android.widget.ImageButton\")")
	public WebElement playBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_pause\").className(\"android.widget.ImageButton\")")
	public WebElement pauseBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_ffwd\").className(\"android.widget.ImageButton\")")
	public WebElement fwdBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/exo_rew\").className(\"android.widget.ImageButton\")")
	public WebElement bkwdBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/ib_create_note\")")
	public WebElement addNotesBtn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]")
	public WebElement hamburgerBtn;

	@AndroidFindBy(id = "com.tce.studi:id/tv_disruptive_continue")
	public WebElement continueOnVdoBtn;

	@AndroidFindBy(id = "com.tce.studi:id/profilePic")
	public WebElement profilePic;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View")
	public WebElement question;

	@AndroidFindBy(id = "com.tce.studi:id/iv_left_icon")
	public WebElement backBtn;

	@AndroidFindBy(id = "com.tce.studi:id/txtPositiveBtn")
	public WebElement yesBtn;

	@AndroidFindBy(id = "com.tce.studi:id/txtNegativeBtn")
	public WebElement noBtn;

	@AndroidFindBy(id = "com.tce.studi:id/iv_tertiary_action")
	public WebElement tertiaryBtnBottom;

	
	public int notesLimit = 3000;

	@AndroidFindBy(id = "com.tce.studi:id/et_notes")
	public WebElement noteTxtArea;

	@AndroidFindBy(id = "com.tce.studi:id/tv_save_note")
	public WebElement saveNoteBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/tv_discard")
	public WebElement discardNoteBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/ivCross")
	public WebElement closeNotesBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/tv_discard_confirmation")
	public WebElement discardWarnMsg;
	
	@AndroidFindBy(id = "com.tce.studi:id/ib_discard_accept")
	public WebElement discardAcceptBtn;
	
	@AndroidFindBy(id = "com.tce.studi:id/ib_discard_deny")
	public WebElement discardDenyBtn;

	@AndroidFindBy(id = "com.tce.studi:id/tv_notes_indicator")
	public WebElement notesCountIndicator;
	
	public void traverse_toward_syllabus() throws MalformedURLException {
		applyExplicitWait(5);
		scrollTo1("Syllabus");
		applyExplicitWait(5);
		clickOnElement(findElementByText("Syllabus"));
		applyExplicitWait(5);

	}

	public void traverse_toward_subject(String subject) throws MalformedURLException {
		applyExplicitWait(5);
		scrollTo1("Syllabus");
		applyExplicitWait(5);
		clickOnElement(findElementByText("Syllabus"));
		applyExplicitWait(5);

		scrollTo1(subject);
		applyExplicitWait(2);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(5);

	}

	public void traverse_toward_topic(String subject, String topic) throws MalformedURLException, InterruptedException {
		
		applyExplicitWait(5);
		scrollTo1("Syllabus");
		applyExplicitWait(5);
		clickOnElement(findElementByText("Syllabus"));
		applyExplicitWait(5);

		scrollTo1(subject);
		applyExplicitWait(2);
		clickOnElement(findElementByText(subject));
		applyExplicitWait(5);

		scrollTo1(topic);
		applyExplicitWait(2);
		clickOnElement(findElementByText(topic));
		applyExplicitWait(5);

		Thread.sleep(500);

		try {
			if (findElementByText("Notes").isDisplayed()) {
				notesFlag = true;
				System.out.println("Notes available");
				action=new TouchAction(driver);
				action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
				.moveTo(PointOption.point(115, 550)).release().perform();
				notesCount = getNotesCount();
				System.err.println("returned notes :" + notesCount);

			} else {
				notesFlag = false;
				System.out.println("Notes not available");
			}
		} catch (Exception e) {
			System.out.println("Notes not created previously");
		}
	}

	public void startRevision1() throws MalformedURLException {
		int temp = 0;
		Boolean status;
		while (temp == 0) {
			try {
				findElementByText("Begin Revision");
				scrollTo1("Begin Revision");
				clickOnElement(findElementByText("Begin Revision"));
				test.log(Status.INFO, "Clicked on Begin Revision");
				System.out.println("Clicked on Begin Revision");
				applyExplicitWait(5);
				temp = 1;

				status = findElementByText("What you will revise:").isDisplayed();
				if (status) {
					count = driver.findElementsById("com.tce.studi:id/iv_overview").size();
					System.out.println("List of TQ'a Displayed");
					test.log(Status.INFO, "List of TQ'a Displayed");
				}

			} catch (Exception e) {
				test.log(Status.INFO, "Revision already attempted previously");
				System.out.println("Revision already attempted previously");

				scrollTo1("Revise Again");
				clickOnElement(findElementByText("Revise Again"));
				test.log(Status.INFO, "Clicked on Revise Again");
				System.out.println("Clicked on Revise Again");
				applyExplicitWait(5);
				temp = 1;

				status = findElementByText("What have you revised:").isDisplayed();
				if (status) {
					count = driver.findElementsById("com.tce.studi:id/iv_overview").size();
					System.out.println("List of TQ'a Displayed");
					test.log(Status.INFO, "List of TQ'a Displayed");
				}

			}
		}

	}

	public void startRevision2() throws MalformedURLException, InterruptedException {

		Thread.sleep(2000);
		SoftAssert sAss = new SoftAssert();
		int flag = 0;
		Boolean status;
		while (flag == 0) {
			try {
				applyExplicitWait(5);
				status = findElementByText("Begin Revision").isDisplayed();
				sAss.assertTrue(status);
				if (status) {
					System.out.println("Begin Revision button Displayed");
					test.log(Status.INFO, "Begin Revision button Displayed");
					clickOnElement(beginRbtn);
					flag = 1;
				}
			} catch (Exception e) {

				applyExplicitWait(5);
				status = findElementByText("Revise again").isDisplayed();
				sAss.assertTrue(status);
				if (status) {

					System.out.println("Revise again button Displayed");
					test.log(Status.INFO, "Revise again button Displayed");

					clickOnElement(findElementByText("Revise again"));
					System.out.println("Clicking on Revise again");
					test.log(Status.INFO, "Clicking on Revise again");

					flag = 1;
				}

			}

		}
	}

}
