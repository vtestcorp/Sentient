package com.sentient.poc.testcases;

import org.testng.annotations.Test;

import com.sentient.poc.base.baseClass;
import com.sentient.poc.config.defineConstants;
import com.sentient.poc.helper.jsonUtils;
import com.sentient.poc.pageobjects.Dashboard_Page;
import com.sentient.poc.pageobjects.Organisation_Details_Page;
import com.sentient.poc.pageobjects.SignIn_Page;

public class TC_05_Verify_Edit_User_Under_Organisation_Details extends baseClass {
	
	Dashboard_Page dashboard_Page;
	SignIn_Page signIn_Page;
	Organisation_Details_Page editUser_Page;
	
	@Test
	public void verify_edit_user_under_organisation_details() throws Exception {
		
		test = extent.createTest("Verify Edit User Under Organisation Details", "User should be able to Edit all User details");
		
		dashboard_Page = new Dashboard_Page(driver, test);
		signIn_Page = new SignIn_Page(driver, test);
		editUser_Page = new Organisation_Details_Page(driver, test);
		
		driver.get(defineConstants.SENTIENT_URL);
		
		signIn_Page.click_Organistaion_Tab();
		signIn_Page.enter_Orgnisation(jsonUtils.getData(defineConstants.Organisation_SignIn, "Organisation"));
		signIn_Page.enter_UserID(jsonUtils.getData(defineConstants.Organisation_SignIn, "Username"));
		signIn_Page.enter_Password(jsonUtils.getData(defineConstants.Organisation_SignIn, "Password"));
		
		 signIn_Page.click_SignIn_Button();
		 dashboard_Page.mouseHover_On_Profile();
		 dashboard_Page.click_On_Organisation_Tab();
		
	     editUser_Page.click_On_EditUser_Button();
		
    	 editUser_Page.enterText_In_Description_textBox(jsonUtils.getData(defineConstants.Edit_User, "Description"));
		 editUser_Page.enterKey_On_Public_Key_textBox(jsonUtils.getData(defineConstants.Edit_User, "Public Key"));
    	 editUser_Page.click_On_Confirm_Changes();
		 
}
}
