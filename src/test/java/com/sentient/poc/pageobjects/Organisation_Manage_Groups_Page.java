package com.sentient.poc.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JavascriptClick;
import com.sentient.poc.helper.Log;
import com.sentient.poc.helper.Screenshots;
import com.sentient.poc.helper.WaitTypes;

public class Organisation_Manage_Groups_Page {

	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public Organisation_Manage_Groups_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);

	}

	@FindBy(xpath = "//h2[text()=' Organisation Details ']")
	public WebElement title;
	

	/**
	 * This method is used to get Current Page Url
	 * 
	 * @return{@author SuchitaDorage}
	 */
	public String getCurrentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	

	/**
	 * This method returns Organisation Dtails Page Title.
	 * 
	 * @return{@author SuchitaDorage}
	 */

	public String getOrganisationTitle() {
		String actual_Title = title.getText();
		return actual_Title;

	}
}
