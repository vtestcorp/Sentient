package com.sentient.poc.pageobjects;

import java.io.IOException;
import java.util.List;

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

public class Dashboard_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public Dashboard_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);

	}

	@FindBy(xpath = "//div[@class='user-profile v-list-item v-list-item--link theme--light']")
	public WebElement avtara;

	@FindBy(xpath = "//div[text()='Organisation']")
	public WebElement organisation;

	@FindBy(xpath = "//div[text()=' MANAGE  GROUPS ']")
	public WebElement manageGroup;

	@FindBy(xpath = "(//span[@class='v-btn__content'])[18]")
	public WebElement addGroup;
	
	@FindBy(xpath = "//input[@placeholder='Please enter an unique group name']")
	public WebElement groupName_TextBox;
	
	@FindBy(xpath = "//textarea[@placeholder='Write a sort and clear description of this group']")
	public WebElement description_TextBox;
	
	@FindBy(xpath="//span[text()=' Please Select  Functions To Assign ']")
	public WebElement functions_dropDown;
	
	@FindBy(xpath ="//span[text()='Create']")
	public WebElement createButton ;
	
	@FindBy(xpath = "//span[contains(text(),' Activate Users ')]")
	public  WebElement Checkbox;

	@FindBy(xpath = "//p[text()='Description']")
	public WebElement textDesciption;
	
	@FindBy(xpath = "//td[text()='vTestGroup']")
	public WebElement groupExist;
	
	@FindBy(xpath = "(//button/span[text()=' Cancel '])[2]")
	public WebElement cancel;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table")
	private WebElement productTable;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	
	/**
	 * This method is used to hover mouse on v-avatar to display list item
	 * and perform click operation on Organisation tab
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public void mouseHover_On_Avatara() throws InterruptedException, IOException {
		applyWait.waitforElementToBeDisplayed(avtara, DefineConstants.explicitWait_30);
		avtara.click();
		applyWait.waitforElementToBeDisplayed(organisation, DefineConstants.explicitWait_30);
		organisation.click();
		Screenshots.takeScreenshot(driver, "User clicked organisation_Tab ");
		test.log(Status.INFO, "User clicked organisation_Tab");
		Log.info("User clicked organisation_Tab");	
		Thread.sleep(3000);
	}
	
	public void verifyManage_Group_Visibility() throws IOException {
		applyWait.waitforElementToBeDisplayed(addGroup, DefineConstants.explicitWait_30);
		Assert.assertTrue(manageGroup.isDisplayed());
		Screenshots.takeScreenshot(driver, "Manage Group Button visible to user");
		test.log(Status.INFO, "Manage Group Button visible to user");
		Log.info("Manage Group Button visible to user");

	}
  
	/**
	 * This method perform click operation on Manage Groups tab
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public void click_On_Manage_Groups_tab() throws InterruptedException, IOException {
		applyWait.waitforElementToBeDisplayed(manageGroup, DefineConstants.explicitWait_30);
		manageGroup.click();
		Screenshots.takeScreenshot(driver, "User clicked manageGroups button");
		test.log(Status.INFO, "User clicked manageGroups button");
		Log.info("User clicked manageGroups button");	
		Thread.sleep(3000);

	}
	
	public void verifyAdd_Group_Button_Visibility() throws IOException {
		applyWait.waitforElementToBeDisplayed(addGroup, DefineConstants.explicitWait_30);
		Assert.assertTrue(addGroup.isDisplayed());
		Screenshots.takeScreenshot(driver, "Add Group Button visible to user");
		test.log(Status.INFO, "Add Group Button visible to user");
		Log.info("Add Group Button visible to user");	
	}
	
	/**
	 * This method used to click on Manage Group tab and click on Add Group
	 * And fill group details{@value Group Name,Description,Function}
	 * And click on Create Button
	 * @throws InterruptedException
	 */
	
	public void click_On_ADD_Group_Button(String group_Name) throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(addGroup, DefineConstants.explicitWait_30);
		addGroup.click();
		applyWait.waitForElementToBeClickable(groupName_TextBox, DefineConstants.explicitWait_30);
		groupName_TextBox.sendKeys(group_Name);
		Screenshots.takeScreenshot(driver, "User entered GroupName as "+ group_Name);
		test.log(Status.INFO, "User entered GroupName as "+ group_Name);
		Log.info("User entered GroupName as "+ group_Name);		
   }
	
	public void enter_Dicription(String description) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(description_TextBox, DefineConstants.explicitWait_30);
		description_TextBox.sendKeys(description);
		Screenshots.takeScreenshot(driver, "User entered Discription as ");
		test.log(Status.INFO, "User entered Discription as "+ description);
		Log.info("User entered Discription as "+ description);

    }
	
	public void select_Fuctions_dropDown() throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(functions_dropDown, DefineConstants.explicitWait_30);
		functions_dropDown.click();
		Thread.sleep(3000);
		Checkbox.click();
		Thread.sleep(3000);
		textDesciption.click();
		Screenshots.takeScreenshot(driver, "User clicked functions dropdown");
		test.log(Status.INFO, "User clicked functions dropdown");
		Log.info("User clicked functions dropdown");		
    }

	
	
	public void click_On_Create_button() throws InterruptedException, IOException {
		applyWait.waitforElementToBeDisplayed(createButton, DefineConstants.explicitWait_30);
		createButton.click();
		Screenshots.takeScreenshot(driver, "User clicked create button");
		test.log(Status.INFO, "User clicked create button");
		Log.info("User clicked create button");	
		
		
	}
	
	public void verifyInputValue(String inputGroupName) {
		applyWait.waitForElementToBeClickable(productTable, DefineConstants.explicitWait_60);
		tableRows = productTable.findElements(By.tagName("tr"));

		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				if (cellText.equals(inputGroupName)) {
					System.out.println("value is " + cellText);
					javascriptClick.highLighterMethod(tableColums.get(column));
					Assert.assertTrue(true, inputGroupName + " is verified");
					test.log(Status.INFO, "value is " + cellText);
					Log.info("value is " + cellText);
					try {
						Screenshots.takeScreenshot(driver, inputGroupName + " is verified");
					} catch (IOException e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, inputGroupName + " is verified");
					Log.info(inputGroupName + " is verified");
				}
				else if (cellText.equals("No matching records found")) {
					try {
						javascriptClick.highLighterMethod(tableColums.get(column));
						Screenshots.takeScreenshot(driver, inputGroupName + " is not found");
					} catch (IOException e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, inputGroupName + " is not found");
					Log.info(inputGroupName + " is not found");
					Assert.assertTrue(false, inputGroupName + " is not found");
				}
			}
		}
	}
}
