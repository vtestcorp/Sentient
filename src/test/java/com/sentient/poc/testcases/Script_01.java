package com.sentient.poc.testcases;

import com.sentient.poc.base.BaseClass;
import com.sentient.poc.pageobjects.Script_01_pageobjects;
import com.sentient.poc.pageobjects.SignIn_Page;
import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Script_01 extends BaseClass {

	SignIn_Page signIn_Page;
	Script_01_pageobjects script_01;


	@Test(enabled = true)
	public void Organisational_Script_01() throws Exception {

		test = extent.createTest("Create User", "User should be created under Organisation");

		signIn_Page = new SignIn_Page(driver, test);
		script_01 = new Script_01_pageobjects(driver, test);

		driver.get(DefineConstants.SENTIENT_URL);
		signIn_Page.click_Organistaion_Tab();
		signIn_Page.enter_Orgnisation(JsonUtils.getData(DefineConstants.Individual_signIn,"Organisation"));
		signIn_Page.enter_UserID(JsonUtils.getData(DefineConstants.Individual_signIn, "Username"));
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.Individual_signIn, "Password"));
		Thread.sleep(3000);
		signIn_Page.click_SignIn_Button();
		Thread.sleep(5000);
		script_01.click_on_account_details();
		Thread.sleep(6000);
		//driver.switchTo().alert().accept();
		String expected=script_01.click_on_manager_user();
		System.out.println(expected);
		Assert.assertEquals("MANAGE USERS",expected);
		Thread.sleep(6000);
		script_01.add_New_User();
		System.out.println("Click");
		Thread.sleep(4000);
		script_01.add_User_details(JsonUtils.getData(DefineConstants.Add_User,"Email"));
		System.out.println("email");
		Thread.sleep(5000);
		script_01.select_group();
		Thread.sleep(6000);
		script_01.select_user();
		Thread.sleep(2000);
		script_01.set_password_option();
		Thread.sleep(6000);
		script_01.new_Password_details(JsonUtils.getData(DefineConstants.Add_User,"Password"));
		Thread.sleep(3000);
		script_01.click_on_create_user();
		Thread.sleep(9000);
		Assert.assertEquals(script_01.verify_expectedUserId(),1);
		
	}
		
}