package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Keyword;

public class ObjectLoginAppCentre extends Keyword {
	
	public ObjectLoginAppCentre() {
		super();
	}
	
	public By username=By.xpath("//input[@id='username']");
	public By nextButton=By.xpath("//span[text()='Next']");
	public By password=By.xpath("//input[@id='password']");
	public By loginButton=By.xpath("//span[text()='Login']");
	
	
}
