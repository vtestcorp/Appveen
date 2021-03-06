package com.PageModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.PageObjects.ObjectLoginAppCentre;
import com.Utility.BaseClass;
import com.Utility.Config;
import com.Utility.Keyword;

public class LaunchAppCentre extends ObjectLoginAppCentre {
	public LaunchAppCentre() {
		super();
		PageFactory.initElements(getDriver(), this);
	}

	public void launchAppCentre() {
		
		getDriver().get(Config.appcentreUrl);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void loginAppCentre() {
		
		LaunchAppCentre centre=new LaunchAppCentre();
		centre.isAlertPresent();
		enterText(centre.username, Config.username);
		clickElement(centre.nextButton);
		enterText(centre.password, Config.password);
		clickElement(centre.loginButton);
		System.out.println("Logged in successfully in AppCentre");
	}
}
