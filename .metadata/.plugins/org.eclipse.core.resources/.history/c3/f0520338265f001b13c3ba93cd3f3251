package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.android.uiautomator.core.UiSelector;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import studi.co.Base.BaseClass;

public class Object_Create_Study_Plan extends BaseClass{
	public Object_Create_Study_Plan() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	@AndroidFindBy(id = "com.tce.studi:id/profilePic")
	public WebElement profilePic;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Test Unit\")")
	public WebElement testUnitBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.tce.studi:id/tvHeading\").textContains(\"Create Study Plan\\r\\n\")")
	public WebElement createStudyPlanTab;
	
	@AndroidFindBy(id = "com.tce.studi:id/study_layout")
	public WebElement studyLayout;
	
	


}
