package com.sentient.poc.testcases;

import com.sentient.poc.base.baseClass;
import com.sentient.poc.pageobjects.Organisation_Manage_Users_Page;
import com.sentient.poc.pageobjects.SignIn_Page;
import com.sentient.poc.config.defineConstants;
import com.sentient.poc.helper.jsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_Verify_Add_User_Under_Manage_Users_Tab extends baseClass {

    SignIn_Page signIn_Page;
    Organisation_Manage_Users_Page script_01;


    @Test(enabled = true)
    public void verify_add_user_under_manage_users() throws Exception {

        test = extent.createTest("Verify Add User Under Manage Users Tab", "User should be created under Organisation");

        signIn_Page = new SignIn_Page(driver, test);
        script_01 = new Organisation_Manage_Users_Page(driver, test);

        driver.get(defineConstants.SENTIENT_URL);
        signIn_Page.click_Organistaion_Tab();
        //Login with valid username and Password
        signIn_Page.enter_Orgnisation(jsonUtils.getData(defineConstants.Organisation_SignIn, "Organisation"));
        signIn_Page.enter_UserID(jsonUtils.getData(defineConstants.Organisation_SignIn, "Username"));
        signIn_Page.enter_Password(jsonUtils.getData(defineConstants.Organisation_SignIn, "Password"));
        signIn_Page.click_SignIn_Button();
        script_01.click_on_account_details();
        String expected = script_01.click_on_manager_user();
        //Verify the Manage Users tab name
        Assert.assertEquals("MANAGE USERS", expected);
        script_01.wait_for_element(6000);
        script_01.add_New_User();
        script_01.add_User_details(jsonUtils.getData(defineConstants.Add_User, "Email"));
        script_01.select_group();
        script_01.wait_for_element(5000);
        script_01.select_user();
        script_01.wait_for_element(3000);
        script_01.set_password_option();
        script_01.wait_for_element(5000);
        script_01.new_Password_details(jsonUtils.getData(defineConstants.Add_User, "Password"));
        script_01.wait_for_element(5000);
        script_01.click_on_create_user();
        script_01.wait_for_element(8000);
        //Verify User added successfully
       // Assert.assertEquals(script_01.verify_expectedUserId(), 1);
        Assert.assertEquals(1, 0);

    }

}