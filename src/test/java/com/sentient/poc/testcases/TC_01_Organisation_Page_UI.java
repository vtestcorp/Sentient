package com.sentient.poc.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sentient.poc.base.baseClass;
import com.sentient.poc.config.defineConstants;
import com.sentient.poc.helper.jsonUtils;
import com.sentient.poc.pageobjects.Dashboard_Page;

import com.sentient.poc.pageobjects.Organisation_Page;
import com.sentient.poc.pageobjects.SignIn_Page;

public class TC_01_Organisation_Page_UI extends baseClass {

	Dashboard_Page dashboard_Page;
	SignIn_Page signIn_Page;
	Organisation_Page organisation_Page;

	@Test
	public void verify_OrganisationPage_UI() throws Exception {

		test = extent.createTest("Organisation_Details_Title", "User should be able to verify Organisation Details Title");

		dashboard_Page = new Dashboard_Page(driver, test);
		signIn_Page = new SignIn_Page(driver, test);
		organisation_Page = new Organisation_Page(driver, test);
		
		driver.get(defineConstants.SENTIENT_URL);

		signIn_Page.click_Organistaion_Tab();
		signIn_Page.enter_Orgnisation(jsonUtils.getData(defineConstants.Organisation_SignIn, "Organisation"));
		signIn_Page.enter_UserID(jsonUtils.getData(defineConstants.Organisation_SignIn, "Username"));
		signIn_Page.enter_Password(jsonUtils.getData(defineConstants.Organisation_SignIn, "Password"));

		signIn_Page.click_SignIn_Button();
		dashboard_Page.mouseHover_On_Profile();
		dashboard_Page.click_On_Organisation_Tab();
	
		Assert.assertEquals(organisation_Page.verify_Logo_Of_OrganisationPage(), true);
		Assert.assertEquals(defineConstants.ORGANISATION_URL, organisation_Page.getCurrentPageUrl());
    	Assert.assertEquals(defineConstants.ORGANISATION_TITLE, organisation_Page.getOrganisationTitle());
		
		
		
		

	}
}
