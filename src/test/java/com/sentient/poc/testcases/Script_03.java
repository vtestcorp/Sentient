package com.sentient.poc.testcases;

import com.sentient.poc.base.BaseClass;
import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JsonUtils;
import com.sentient.poc.pageobjects.Script_01_pageobjects;
import com.sentient.poc.pageobjects.Script_03_pageobjects;
import com.sentient.poc.pageobjects.SignIn_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Script_03 extends BaseClass {
    SignIn_Page signIn_Page;
    Script_01_pageobjects script_01;
    Script_03_pageobjects script_03;

    @Test(enabled = true)
    public void verify_Account_Balance() throws Exception {

        test = extent.createTest("Verify User Account Balance", "Verify User Account Balance");
        signIn_Page = new SignIn_Page(driver, test);
        script_01 = new Script_01_pageobjects(driver, test);
        script_03 = new Script_03_pageobjects(driver, test);
        driver.get(DefineConstants.SENTIENT_URL);
        signIn_Page.click_Organistaion_Tab();
        signIn_Page.enter_Orgnisation(JsonUtils.getData(DefineConstants.Individual_signIn, "Organisation"));
        signIn_Page.enter_UserID(JsonUtils.getData(DefineConstants.Individual_signIn, "Username"));
        signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.Individual_signIn, "Password"));
        Thread.sleep(6000);
        signIn_Page.click_SignIn_Button();
        Thread.sleep(7000);
        script_03.click_on_account_details();
        Thread.sleep(6000);
        Assert.assertEquals(script_03.verify_amount_balance(),1);

    }
}
