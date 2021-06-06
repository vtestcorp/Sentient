package com.sentient.poc.pageobjects;

import com.aventstack.extentreports.ExtentTest;
import com.sentient.poc.helper.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Iterator;

public class Script_03_pageobjects {
    private WebDriver driver;
    private WaitTypes applyWait;
    private ExtentTest test;
    private SwitchWindow switchToWindow;
    private Keyboard keyboard;
    private DropDown dropDown;
    public Actions actions;
    public String expectedResult;
    public Iterator it;
    int flag = 0;
    String expected, actual;


    public Script_03_pageobjects(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.applyWait = new WaitTypes(driver);
        this.test = test;
        new JavascriptClick(driver);
        switchToWindow = new SwitchWindow(driver);
        keyboard = new Keyboard();
    }

    @FindBy(css = ".user-profile.v-list-item.v-list-item--link.theme--light")
    private WebElement account_details;

    @FindBy(xpath = "//div[contains(text(),'Account Transactions')]")
    private WebElement account_transaction;

    @FindBy(css = ".px-2")
    private WebElement amount_balance;

    @FindBy(xpath = "//p")
    private WebElement account_transcation_balance;

    public void click_on_account_details() throws IOException, InterruptedException {

        Thread.sleep(2000);
        //account_details.get(0).click();
        actions = new Actions(driver);
        actions.moveToElement(account_details).build().perform();
        account_transaction.click();
        //dropDown.moveToElement(driver,account_details);

        //manage_user.click();

    }

    public int verify_amount_balance() throws InterruptedException {
        expected = amount_balance.getText();
        System.out.println(expected);
        Thread.sleep(4000);
        actual = account_transcation_balance.getText();
        System.out.println(actual);
        if (actual.contains(expected)) {
            flag = 1;
        }
        return flag;
    }
}
