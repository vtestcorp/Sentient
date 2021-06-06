package com.sentient.poc.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JavascriptClick;
import com.sentient.poc.helper.Log;
import com.sentient.poc.helper.Screenshots;
import com.sentient.poc.helper.WaitTypes;

public class SignIn_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public SignIn_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
	}

	@FindBy(css = "#input-36")
	private WebElement userID_TextBox;

	@FindBy(css = "#input-39")
	private WebElement password_TextBox;

	@FindBy(css = "#input-33")
	private WebElement orgnisation_TextBox;


	@FindBy(xpath = "//button[@type='button']/span")
	private List<WebElement> SignIn_Button;

	@FindBy(xpath = "//div[contains(text(),'Organisation')]")
	private WebElement organisation_Tab;

//	@FindBy(xpath = "//a[@id='groupNode_sales']")
//	private WebElement Sales_Tab;





	public void enter_UserID(String input_userID) throws IOException, InterruptedException {

		applyWait.waitForElementToBeClickable(userID_TextBox, DefineConstants.explicitWait_30);
		//javascriptClick.highLighterMethod(userID_TextBox);
		userID_TextBox.sendKeys(input_userID);
		Screenshots.takeScreenshot(driver, "User entered userID as "+ input_userID);
		test.log(Status.INFO, "User entered userID as "+ input_userID);
		Log.info("User entered email address as "+ input_userID);		
   }
	
	public void enter_Password(String input_Password) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(password_TextBox, DefineConstants.explicitWait_30);
		password_TextBox.sendKeys(input_Password);
		Screenshots.takeScreenshot(driver, "User entered password as ");
		test.log(Status.INFO, "User entered password as "+ input_Password);
		Log.info("User entered password as "+ input_Password);

    }
	
	public void click_SignIn_Button() throws IOException, InterruptedException {
		SignIn_Button.get(1).click();
		Screenshots.takeScreenshot(driver, "User clicked login button");
		test.log(Status.INFO, "User clicked login button");
		Log.info("User clicked login button");		
    }

    public void click_Organistaion_Tab()throws IOException, InterruptedException
	{
		applyWait.waitforElementToBeDisplayed(organisation_Tab, DefineConstants.explicitWait_30);
		organisation_Tab.click();
		Screenshots.takeScreenshot(driver, "User clicked Organisation Tab");
		test.log(Status.INFO, "User clicked login button");
		Log.info("User clicked login button");
	}

    public void enter_Orgnisation(String input_Organisation) throws IOException, InterruptedException
	{
		applyWait.waitForElementToBeClickable(orgnisation_TextBox, DefineConstants.explicitWait_30);
		orgnisation_TextBox.sendKeys(input_Organisation);
		Screenshots.takeScreenshot(driver, "User entered Organisation ID ");
		test.log(Status.INFO, "User entered password as "+ input_Organisation);
		Log.info("User entered password as "+ input_Organisation);
	}
	

}
