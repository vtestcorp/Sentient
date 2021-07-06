package com.sentient.poc.testcases;

import com.sentient.poc.pageobjects.Organisation_Manage_Users_Page;
import org.testng.annotations.Test;

import com.sentient.poc.base.baseClass;
import com.sentient.poc.config.defineConstants;
import com.sentient.poc.helper.jsonUtils;
import com.sentient.poc.pageobjects.Dashboard_Page;
import com.sentient.poc.pageobjects.SignIn_Page;

public class TC_03_Verify_Add_Group_Under_Manage_Groups_Tab extends baseClass {

	Dashboard_Page dashboard_Page;
	SignIn_Page signIn_Page;
	Organisation_Manage_Users_Page script_01;
	
	@Test
	public void verify_add_group_under_manage_groups() throws Exception {

		test = extent.createTest("Verify Add Group Under Manage Groups Tab", "User should be able visible Manage group tab");

		dashboard_Page = new Dashboard_Page(driver, test);
		signIn_Page = new SignIn_Page(driver, test);

		driver.get(defineConstants.SENTIENT_URL);

		signIn_Page.click_Organistaion_Tab();
		signIn_Page.enter_Orgnisation(jsonUtils.getData(defineConstants.Organisation_SignIn, "Organisation"));
		signIn_Page.enter_UserID(jsonUtils.getData(defineConstants.Organisation_SignIn, "Username"));
		signIn_Page.enter_Password(jsonUtils.getData(defineConstants.Organisation_SignIn, "Password"));

		signIn_Page.click_SignIn_Button();
		dashboard_Page.mouseHover_On_Profile();
		dashboard_Page.click_On_Organisation_Tab();

		dashboard_Page.click_On_Manage_Groups_tab();

		dashboard_Page.verifyAdd_Group_Button_Visibility();
		dashboard_Page.click_On_ADD_Group_Button(jsonUtils.getData(defineConstants.Manage_Groups, "Group Name"));

		dashboard_Page.enter_Discription(jsonUtils.getData(defineConstants.Manage_Groups, "Description"));
		dashboard_Page.select_Fuctions_dropDown();
		dashboard_Page.click_On_Create_button();
		dashboard_Page.verifyInputValue(jsonUtils.getData(defineConstants.Manage_Groups, "Group Name"));


	}

}
