package com.qa.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crmpro.base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(linkText="Classic CRM")
	WebElement classicCRMLink;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String  validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMLink(){
		return classicCRMLink.isEnabled();
	}
	
	public void login(String user, String pass){
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	
}
	
	
	