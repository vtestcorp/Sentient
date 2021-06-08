package com.sentient.poc.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class Organisation_Page {

	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public Organisation_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);

	}

	@FindBy(xpath = "//h2[text()=' Organisation Details ']")
	public WebElement title;
	
	@FindBy(xpath = "//div[@class='v-image v-responsive shrink mt-1 theme--light']//div[@class='v-image__image v-image__image--cover']")
	public WebElement logo;

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
	
	/**
	 * This method verify Logo image of Organisation details page   
	 * @return
	 */
	public boolean verify_Logo_Of_OrganisationPage() {
		boolean value = logo.getAttribute("style").contains(("https://dev-platform.sentient.io/img/sentientlogo.cab51565.png"));
		//System.out.println(value);
		return value;
	
     }
	
	
  
}


