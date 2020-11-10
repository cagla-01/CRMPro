package com.qa.crmpro.tests;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.constants.Constants;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.utulities.TestUtility;

public class LoginPageTest extends BasePage {
	
	LoginPage loginPage;
	
	
	public LoginPageTest(){
		super();
		}
	
	@BeforeTest
	public void setUp(){
		initDriver();
		loginPage=new LoginPage();
		log.info("Application launched!");
	}
	@Test(priority=1, enabled=true)
	public void verifyTitle(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		TestUtility.takeScreenshotAtEndOfTest();
		log.info("Login page title verified");

	}
	
	@Test(priority=2, enabled=true)
	public void crmLinkTest(){
		boolean status=loginPage.validateCRMLink();
		Assert.assertTrue(status);
		TestUtility.takeScreenshotAtEndOfTest();
		log.info("CRM Link is verified");
	}
	
	
@Test(priority=3)
	public void loginTest(){
	loginPage.login(property.getProperty("username"), property.getProperty("password"));
	TestUtility.takeScreenshotAtEndOfTest();
	log.info("Succesfully logged into CRM");
	
}
@AfterTest
public void tearDown(){
	driver.quit();
}
	

}
