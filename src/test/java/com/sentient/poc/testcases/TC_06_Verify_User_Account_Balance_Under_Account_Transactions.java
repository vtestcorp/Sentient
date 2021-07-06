package com.sentient.poc.testcases;

import com.sentient.poc.base.baseClass;
import com.sentient.poc.config.*;
import com.sentient.poc.helper.jsonUtils;
import com.sentient.poc.pageobjects.Organisation_Manage_Users_Page;
import com.sentient.poc.pageobjects.Account_Transactions_Page;
import com.sentient.poc.pageobjects.SignIn_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06_Verify_User_Account_Balance_Under_Account_Transactions extends baseClass {
    SignIn_Page signIn_Page;
    Organisation_Manage_Users_Page script_01;
    Account_Transactions_Page script_03;

    @Test(enabled = true)
    public void verify_user_account_balance_under_account_transactions() throws Exception {

        test = extent.createTest("Verify User Account Balance Under Account Transactions", "Verify User Account Balance");
        signIn_Page = new SignIn_Page(driver, test);
        script_01 = new Organisation_Manage_Users_Page(driver, test);
        script_03 = new Account_Transactions_Page(driver, test);
        driver.get(defineConstants.SENTIENT_URL);
        //Login with valid username and Password
        signIn_Page.click_Organistaion_Tab();
        signIn_Page.enter_Orgnisation(jsonUtils.getData(defineConstants.Organisation_SignIn, "Organisation"));
        signIn_Page.enter_UserID(jsonUtils.getData(defineConstants.Organisation_SignIn, "Username"));
        signIn_Page.enter_Password(jsonUtils.getData(defineConstants.Organisation_SignIn, "Password"));
        script_01.wait_for_element(6000);
        signIn_Page.click_SignIn_Button();
        script_01.wait_for_element(7000);
        script_03.click_on_account_details();
        script_01.wait_for_element(6000);
        //Verify User account balance wth Account Transaction
        Assert.assertEquals(script_03.verify_amount_balance(), 1);

    }
}
