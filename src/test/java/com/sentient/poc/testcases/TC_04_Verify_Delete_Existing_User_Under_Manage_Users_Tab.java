package com.sentient.poc.testcases;

import com.sentient.poc.base.BaseClass;
import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JsonUtils;
import com.sentient.poc.pageobjects.Organisation_Manage_Users_Page;
import com.sentient.poc.pageobjects.SignIn_Page;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_04_Verify_Delete_Existing_User_Under_Manage_Users_Tab extends BaseClass {
    SignIn_Page signIn_Page;
    Organisation_Manage_Users_Page script_01;

    @Test(enabled = true)
    public void verify_delete_existing_user_under_manage_users() throws Exception {

        test = extent.createTest("Verify Delete Existing User Under Manage Users Tab", "Delete the existing User in Organisation");

        signIn_Page = new SignIn_Page(driver, test);
        script_01 = new Organisation_Manage_Users_Page(driver, test);

        driver.get(DefineConstants.SENTIENT_URL);
        signIn_Page.click_Organistaion_Tab();
        //Login with valid username and Password
        signIn_Page.enter_Orgnisation(JsonUtils.getData(DefineConstants.Organisation_SignIn, "Organisation"));
        signIn_Page.enter_UserID(JsonUtils.getData(DefineConstants.Organisation_SignIn, "Username"));
        signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.Organisation_SignIn, "Password"));
        script_01.wait_for_element(3000);
        signIn_Page.click_SignIn_Button();
        script_01.wait_for_element(5000);
        script_01.click_on_account_details();
        script_01.wait_for_element(6000);
        String expected = script_01.click_on_manager_user();
        script_01.wait_for_element(5000);
        script_01.select_existing_user_in_list();
        script_01.wait_for_element(8000);
        script_01.click_on_delete_selected_user();
        List<WebElement> after = script_01.getUserEmailList();

        String email = JsonUtils.getData(DefineConstants.Add_User, "Email");
        boolean containsEmail = false;

        for (WebElement webElement : after) {
            if (webElement.getText().equals(email)) {
                containsEmail = true;
            }
        }
        //Verify Existing User deleted
        Assert.assertFalse(containsEmail);
    }
}