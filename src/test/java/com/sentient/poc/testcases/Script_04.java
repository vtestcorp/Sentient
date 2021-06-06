package com.sentient.poc.testcases;

import com.sentient.poc.base.BaseClass;
import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JsonUtils;
import com.sentient.poc.pageobjects.Script_01_pageobjects;
import com.sentient.poc.pageobjects.SignIn_Page;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Script_04 extends BaseClass {
    SignIn_Page signIn_Page;
    Script_01_pageobjects script_01;

    @Test(enabled = true)
    public void Organisational_Script_04() throws Exception {

        test = extent.createTest("Delete Existing User", "Delete the existing User in Organisation");

        signIn_Page = new SignIn_Page(driver, test);
        script_01 = new Script_01_pageobjects(driver, test);

        driver.get(DefineConstants.SENTIENT_URL);
        signIn_Page.click_Organistaion_Tab();
        signIn_Page.enter_Orgnisation(JsonUtils.getData(DefineConstants.Individual_signIn, "Organisation"));
        signIn_Page.enter_UserID(JsonUtils.getData(DefineConstants.Individual_signIn, "Username"));
        signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.Individual_signIn, "Password"));
        Thread.sleep(3000);
        signIn_Page.click_SignIn_Button();
        Thread.sleep(5000);
        //driver.switchTo().alert().accept();
        Thread.sleep(3000);
        //driver.switchTo().alert().accept();
        Thread.sleep(3000);
        script_01.click_on_account_details();
        Thread.sleep(6000);
        //driver.switchTo().alert().accept();
        String expected = script_01.click_on_manager_user();
        Thread.sleep(5000);
        script_01.select_existing_user_in_list();
        Thread.sleep(8000);
        script_01.click_on_delete_selected_user();
        List<WebElement> after = script_01.getUserEmailList();

        String email = JsonUtils.getData(DefineConstants.Add_User, "Email");
        boolean containsEmail = false;

        for(WebElement webElement : after){
            if(webElement.getText().equals(email)){
                containsEmail = true;
            }
        }

        Assert.assertFalse(containsEmail);
    }
}