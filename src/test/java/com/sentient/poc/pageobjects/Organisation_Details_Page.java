package com.sentient.poc.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class Organisation_Details_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public Organisation_Details_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);

	}

	@FindBy(xpath = "//span[text()=' User Edit ']")
	public WebElement editUser;
	
	@FindBy(xpath = "//div[@class='v-text-field__slot']/child::input[@id='input-136']")
	public WebElement email;
	
	@FindBy(xpath = "//div[@class='row mt-0 mt-md-4']//textarea")
	public WebElement description;
	
	@FindBy(xpath ="(//div[@class='v-input__control']//textarea)[2]")
	public WebElement publicKey;
	
	@FindBy(xpath = "//span[text()=' Confirm Changes ']")
	public WebElement confirm_Changes_Button;
	
	/**
	 * This method perform click operation on User Edit Button.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void click_On_EditUser_Button() throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(editUser, DefineConstants.explicitWait_30);
		editUser.click();
		Screenshots.takeScreenshot(driver, "User clicked on Edit User");
		test.log(Status.INFO, "User clicked on Edit User");
		Log.info("User clicked on Edit User");	
        Thread.sleep(5000);
	}
	
	/**
	 * This method used to Enter text in Description text box.	
	 * @param textToEnter
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enterText_In_Description_textBox(String textToEnter) throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(description, DefineConstants.explicitWait_30);
		WebElement toClear = driver.findElement(By.xpath("//div[@class='row mt-0 mt-md-4']//textarea"));
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		description.sendKeys(textToEnter);;
		Screenshots.takeScreenshot(driver, "User enterd text in Description TextBox as "+ textToEnter);
		test.log(Status.INFO, "User enterd text in Description TextBox as "+ textToEnter);
		Log.info("User enterd text in Description TextBox as "+ textToEnter);		
        Thread.sleep(3000);


	}
	
	/**
	 * This method  id used to enter public key.
	 * @param keyToEnter
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	public void enterKey_On_Public_Key_textBox(String keyToEnter) throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(publicKey, DefineConstants.explicitWait_30);
		WebElement toClear = driver.findElement(By.xpath("(//div[@class='v-input__control']//textarea)[2]"));
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		publicKey.sendKeys(keyToEnter);
		Screenshots.takeScreenshot(driver, "User enterd Public Key as "+ keyToEnter);
		test.log(Status.INFO, "User enterd Public Key as "+ keyToEnter);
		Log.info("User enterd Public Key as "+ keyToEnter);		
        Thread.sleep(3000);
	}
	
	
	/**
	 * This method is used to click on Confirm Changes Button
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void click_On_Confirm_Changes() throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(publicKey, DefineConstants.explicitWait_30);
		confirm_Changes_Button.click();
		Screenshots.takeScreenshot(driver, "User clicked on Confirm Changes Button ");
		test.log(Status.INFO, "User clicked on Confirm Changes Button ");
		Log.info("User clicked on Confirm Changes Button ");		
        Thread.sleep(3000);

	}
	
}
