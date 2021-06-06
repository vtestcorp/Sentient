package com.sentient.poc.testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sentient.poc.base.BaseClass;
import com.sentient.poc.config.DefineConstants;
import com.sentient.poc.helper.JsonUtils;
import com.sentient.poc.pageobjects.Dashboard_Page;
import com.sentient.poc.pageobjects.SignIn_Page;

public class Script_02 extends BaseClass {

	Dashboard_Page dashboard_Page;
	SignIn_Page signIn_Page;

	@Test
	public void Manage_Groups_Script_02() throws Exception {

		test = extent.createTest("Create Groups", "Create Groups under Organisation");

		dashboard_Page = new Dashboard_Page(driver, test);
		signIn_Page = new SignIn_Page(driver, test);

		driver.get(DefineConstants.SENTIENT_URL);
		
		signIn_Page.click_Organistaion_Tab();
		signIn_Page.enter_Orgnisation(JsonUtils.getData(DefineConstants.Individual_signIn, "Organisation"));
		signIn_Page.enter_UserID(JsonUtils.getData(DefineConstants.Individual_signIn, "Username"));
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.Individual_signIn, "Password"));
		
		signIn_Page.click_SignIn_Button();
		dashboard_Page.mouseHover_On_Avatara();
		
		dashboard_Page.click_On_Manage_Groups_tab();
		
		dashboard_Page.verifyAdd_Group_Button_Visibility();
		dashboard_Page.click_On_ADD_Group_Button(JsonUtils.getData(DefineConstants.Manage_Groups, "GroupName"));
		dashboard_Page.enter_Dicription(JsonUtils.getData(DefineConstants.Manage_Groups, "Description"));
		Thread.sleep(5000);
		dashboard_Page.select_Fuctions_dropDown();
		dashboard_Page.click_On_Create_button();
		dashboard_Page.verifyInputValue(JsonUtils.getData(DefineConstants.Manage_Groups, "GroupName"));
		

	}

}
