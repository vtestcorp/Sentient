package com.sentient.poc.pageobjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;



import com.sentient.poc.helper.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sentient.poc.config.*;

public class Organisation_Manage_Users_Page {
    private WebDriver driver;
    private waitTypes applyWait;
    private ExtentTest test;
    private switchWindow switchToWindow;
    private com.sentient.poc.helper.keyboard keyboard;
    private com.sentient.poc.helper.dropDown dropDown;
    public Actions actions;
    public String expectedResult;
    public Iterator it;
    int flag = 0;


    public String selectText1 = "Organisation";

    public Organisation_Manage_Users_Page(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new waitTypes(driver);
        this.test = test;
        new javascriptClick(driver);
        switchToWindow = new switchWindow(driver);
        keyboard = new keyboard();
    }


    @FindBy(css = ".user-profile.v-list-item.v-list-item--link.theme--light")
    private WebElement account_details;

    @FindBy(xpath = "//div[contains(text(),'Organisation')]")
    private WebElement organisation;

    @FindBy(xpath = "//div[contains(text(),'MANAGE USERS')]")
    private WebElement manage_user;

    @FindBy(css = ".nocap.v-btn.v-btn--flat.v-btn--text.theme--light.elevation-0.v-size--default")
    private List<WebElement> add_User;
    private WebElement add_user1;

    @FindBy(xpath = "//input[@placeholder='example@email.com']")
    private WebElement add_user_emailId;

    @FindBy(css = ".v-input--selection-controls__ripple")
    private List<WebElement> let_user_set_password;

    @FindBy(xpath = "//span[@class='black--text']")
    private List<WebElement> user;

    @FindBy(css = ".v-btn__content")
    private List<WebElement> groups;

    @FindBy(xpath = "//p[contains(text(),'Set password')]")
    private WebElement set_password;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement new_Password;

    @FindBy(xpath = "//p[contains(text(),'Groups')]")
    private WebElement group_Name;

    @FindBy(css = ".mx-4")
    private List<WebElement> create_user;

    @FindBy(xpath = "//td[2]")
    private List<WebElement> expetedUser;

//    @FindBy(xpath = "//td[contains(text(),'test11@gmail.com')]/parent::tr/td[@class='text-start']/div[@class='v-simple-checkbox']")
//    private WebElement select_existing_user;

    @FindBy(xpath = "//span[contains(text(),'Delete Selected User')]")
    private WebElement delete_button_selected_user;

    @FindBy(css=".confirm-btn")
    private WebElement click_on_delete;

    public void select_existing_user_in_list() {
        String email= jsonUtils.getData(defineConstants.Add_User, "Email");
        WebElement select_existing_user=driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]/parent::tr/td[@class='text-start']/div[@class='v-simple-checkbox']"));
        select_existing_user.click();
    }

    public void click_on_delete_selected_user() throws InterruptedException {
        delete_button_selected_user.click();
        Thread.sleep(3000);
        click_on_delete.click();
        Thread.sleep(8000);
    }

    //    public int verify_expectedUserId() {
//        for (WebElement a : expetedUser) {
//            if (a.getText().equals(JsonUtils.getData(DefineConstants.Add_User, "Email"))) {
//                System.out.println("Expected Result");
//                flag = 1;
//            }
//        }
//        return flag;
//    }

    public int verify_user_deleted()
    {
        String email= jsonUtils.getData(defineConstants.Add_User, "Email");
        WebElement expected = driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]"));
        expetedUser.size();
        if (expected.getText().equals(jsonUtils.getData(defineConstants.Add_User, "Email"))) {
            System.out.println("Expected Result");
            flag = 0;
//            }
        }
        else
            flag=1;
        return flag;
    }


    public int verify_expectedUserId() {
        String email= jsonUtils.getData(defineConstants.Add_User, "Email");
        WebElement expected = driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]"));
        System.out.println(expected.getText());
        if (expected.getText().equals(jsonUtils.getData(defineConstants.Add_User, "Email"))) {
            System.out.println("Expected Result");
            flag = 1;
//            }
        }
        return flag;
    }



    public void click_on_create_user() {
        create_user.get(1).click();
    }

    public void set_password_option() {
        set_password.click();
    }

    public void add_User_details(String input_userID) throws IOException, InterruptedException {

        applyWait.waitForElementToBeClickable(add_user_emailId, defineConstants.explicitWait_30);
        add_user_emailId.sendKeys(input_userID);
        //Screenshots.takeScreenshot(driver, "User entered userID as " + input_userID);
        test.log(Status.INFO, "User entered userID as " + input_userID);
        log.info("User entered email address as " + input_userID);
    }

    public void new_Password_details(String input_userID) throws IOException, InterruptedException {

        applyWait.waitForElementToBeClickable(new_Password, defineConstants.explicitWait_30);
        new_Password.sendKeys(input_userID);
        //Screenshots.takeScreenshot(driver, "User entered userID as " + input_userID);
        test.log(Status.INFO, "User entered userID as " + input_userID);
        log.info("User entered email address as " + input_userID);
    }

    public void select_group() throws InterruptedException {
        Thread.sleep(5000);
        for (WebElement a : groups) {
            if (a.getText().equals("Select Predefined Groups")) {
                a.click();
                break;
            }

        }



        //user.isSelected();
    }

    public void wait_for_element(int t1) throws InterruptedException {
        Thread.sleep(t1);
    }

    public void select_user() {
        user.get(1).click();
        group_Name.click();
    }

    public void click_on_account_details() throws IOException, InterruptedException {

        Thread.sleep(2000);
        //account_details.get(0).click();
        actions = new Actions(driver);
        actions.moveToElement(account_details).build().perform();
        //dropDown.moveToElement(driver,account_details);
        organisation.click();
        //manage_user.click();
        Thread.sleep(5000);

    }

    public String click_on_manager_user() throws InterruptedException {
        Thread.sleep(5000);
        manage_user.click();
        expectedResult = manage_user.getText();
        return expectedResult;

    }

    public void add_New_User() throws InterruptedException {
        for (WebElement a : add_User) {
            if (a.getText().equals("Add User")) {
                a.click();
                Thread.sleep(5000);
                break;
            }
        }
    }


    public List<WebElement> getUserEmailList() {
       return driver.findElements(By.xpath("//td[2]"));
    }
}