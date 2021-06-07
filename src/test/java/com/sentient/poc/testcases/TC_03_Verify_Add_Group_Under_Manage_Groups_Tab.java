package com.sentient.poc.testcases;

import java.util.Random;

import com.sentient.poc.pageobjects.Organisation_Manage_Users_Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sentient.poc.base.BaseClass;
import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JsonUtils;
import com.sentient.poc.pageobjects.Dashboard_Page;
import com.sentient.poc.pageobjects.SignIn_Page;

public class TC_03_Verify_Add_Group_Under_Manage_Groups_Tab extends BaseClass {

	Dashboard_Page dashboard_Page;
	SignIn_Page signIn_Page;
	Organisation_Manage_Users_Page script_01;
	
	@Test
	public void verify_add_group_under_manage_groups() throws Exception {

		test = extent.createTest("Verify Add Group Under Manage Groups Tab", "User should be able visible Manage group tab");

		dashboard_Page = new Dashboard_Page(driver, test);
		signIn_Page = new SignIn_Page(driver, test);

		driver.get(DefineConstants.SENTIENT_URL);

		signIn_Page.click_Organistaion_Tab();
		signIn_Page.enter_Orgnisation(JsonUtils.getData(DefineConstants.Organisation_SignIn, "Organisation"));
		signIn_Page.enter_UserID(JsonUtils.getData(DefineConstants.Organisation_SignIn, "Username"));
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.Organisation_SignIn, "Password"));

		signIn_Page.click_SignIn_Button();
		dashboard_Page.mouseHover_On_Profile();
		dashboard_Page.click_On_Organisation_Tab();

		dashboard_Page.click_On_Manage_Groups_tab();

		dashboard_Page.verifyAdd_Group_Button_Visibility();
		dashboard_Page.click_On_ADD_Group_Button(JsonUtils.getData(DefineConstants.Manage_Groups, "Group Name"));

		dashboard_Page.enter_Discription(JsonUtils.getData(DefineConstants.Manage_Groups, "Description"));
		dashboard_Page.select_Fuctions_dropDown();
		dashboard_Page.click_On_Create_button();
		dashboard_Page.verifyInputValue(JsonUtils.getData(DefineConstants.Manage_Groups, "Group Name"));


	}

}
