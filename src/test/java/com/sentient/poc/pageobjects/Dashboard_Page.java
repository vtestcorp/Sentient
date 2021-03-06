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
import com.sentient.poc.config.defineConstants;
import com.sentient.poc.helper.waitTypes;
import com.sentient.poc.helper.javascriptClick;
import com.sentient.poc.helper.log;

public class Dashboard_Page {
	private WebDriver driver;
	private waitTypes applyWait;
	private ExtentTest test;
	private com.sentient.poc.helper.javascriptClick javascriptClick;

	public Dashboard_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new waitTypes(driver);
		this.test = test;
		javascriptClick = new javascriptClick(driver);

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
	
	@FindBy(xpath = "//div[@class='v-window-item v-window-item--active']//div//div[@class='container']")
	private WebElement productTable;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	
	/**
	 * This method is used to hover mouse on Profile to display list item.
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public void mouseHover_On_Profile() throws InterruptedException, IOException {
		applyWait.waitforElementToBeDisplayed(avtara, defineConstants.explicitWait_30);
		avtara.click();
		//Screenshots.takeScreenshot(driver, "User should  hover Mouse on Profile");
		test.log(Status.INFO, "User should  hover Mouse on Profile");
		log.info("User should  hover Mouse on Profile");
		Thread.sleep(3000);
	}
	
	/**
	 * This method is used to Perform clicked operation on Organisation tab.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void click_On_Organisation_Tab() throws InterruptedException, IOException{
		applyWait.waitforElementToBeDisplayed(organisation, defineConstants.explicitWait_30);
		organisation.click();
		//Screenshots.takeScreenshot(driver, "User clicked organisation_Tab ");
		test.log(Status.INFO, "User clicked organisation_Tab");
		log.info("User clicked organisation_Tab");
		Thread.sleep(5000);
	}
	
	public void verifyManage_Group_Visibility() throws IOException {
		applyWait.waitforElementToBeDisplayed(addGroup, defineConstants.explicitWait_30);
		Assert.assertTrue(manageGroup.isDisplayed());
		//Screenshots.takeScreenshot(driver, "Manage Group Button visible to user");
		test.log(Status.INFO, "Manage Group Button visible to user");
		log.info("Manage Group Button visible to user");

	}
  
	/**
	 * This method perform click operation on Manage Groups tab
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public void click_On_Manage_Groups_tab() throws InterruptedException, IOException {
		applyWait.waitforElementToBeDisplayed(manageGroup, defineConstants.explicitWait_30);
		manageGroup.click();
		//Screenshots.takeScreenshot(driver, "User clicked manageGroups button");
		test.log(Status.INFO, "User clicked manageGroups button");
		log.info("User clicked manageGroups button");
		Thread.sleep(3000);

	}
	
	/**
	 * This method used to verify visibility of Add Group Button.
	 * @throws InterruptedException
	 */	
	public void verifyAdd_Group_Button_Visibility() throws IOException {
		applyWait.waitforElementToBeDisplayed(addGroup, defineConstants.explicitWait_30);
		Assert.assertTrue(addGroup.isDisplayed());
		//Screenshots.takeScreenshot(driver, "Add Group Button visible to user");
		test.log(Status.INFO, "Add Group Button visible to user");
		log.info("Add Group Button visible to user");
	}
	
	/**
	 * This method used to click on Add Group Button.
	 * @throws InterruptedException
	 */
	
	public void click_On_ADD_Group_Button(String group_Name) throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(addGroup, defineConstants.explicitWait_30);
		addGroup.click();
		applyWait.waitForElementToBeClickable(groupName_TextBox, defineConstants.explicitWait_30);
		groupName_TextBox.sendKeys(group_Name);
		//Screenshots.takeScreenshot(driver, "User entered GroupName as "+ group_Name);
		test.log(Status.INFO, "User entered GroupName as "+ group_Name);
		log.info("User entered GroupName as "+ group_Name);
   }
	
	/**
	 * This method is used to enter description in Description text box
	 * @param description
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void enter_Discription(String description) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(description_TextBox, defineConstants.explicitWait_30);
		description_TextBox.sendKeys(description);
		//Screenshots.takeScreenshot(driver, "User entered Discription as ");
		test.log(Status.INFO, "User entered Discription as "+ description);
		log.info("User entered Discription as "+ description);

    }
	
	/**
	 * This method is used to select the function from drop down.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void select_Fuctions_dropDown() throws IOException, InterruptedException {
		applyWait.waitforElementToBeDisplayed(functions_dropDown, defineConstants.explicitWait_30);
		functions_dropDown.click();
		Thread.sleep(5000);
		Checkbox.click();
		Thread.sleep(3000);
		textDesciption.click();
		//Screenshots.takeScreenshot(driver, "User clicked functions dropdown");
		test.log(Status.INFO, "User clicked functions dropdown");
		log.info("User clicked functions dropdown");
    }

	
	/**
	 * This method is used to click on create button of create new group.
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void click_On_Create_button() throws InterruptedException, IOException {
		applyWait.waitforElementToBeDisplayed(createButton, defineConstants.explicitWait_30);
		createButton.click();
		//Screenshots.takeScreenshot(driver, "User clicked create button");
		test.log(Status.INFO, "User clicked create button");
		log.info("User clicked create button");
	}
	
	
	/**
	 * This method is used to verify input value from table.
	 * @param inputGroupName
	 */
	public void verifyInputValue(String inputGroupName) {
		applyWait.waitForElementToBeClickable(productTable, defineConstants.explicitWait_60);
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
					log.info("value is " + cellText);
					try {
						//Screenshots.takeScreenshot(driver, inputGroupName + " is verified");
					} catch (Exception e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, inputGroupName + " is verified");
					log.info(inputGroupName + " is verified");
				}
				else if (cellText.equals("No matching records found")) {
					try {
						javascriptClick.highLighterMethod(tableColums.get(column));
						//Screenshots.takeScreenshot(driver, inputGroupName + " is not found");
					} catch (Exception e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, inputGroupName + " is not found");
					log.info(inputGroupName + " is not found");
					Assert.assertTrue(false, inputGroupName + " is not found");
				}
			}
		}
	}
}
