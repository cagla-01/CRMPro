package com.qa.crmpro.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.qa.crmpro.utulities.TestUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties property;
	public static Logger log;
	
	//constructor
	public BasePage(){
		log=Logger.getLogger(this.getClass());
		
		try{
		property=new Properties();
		
		FileInputStream ip=new FileInputStream("./src/main/java/com/qa/crmpro/configuration/config.properties");
		property.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	@BeforeTest
	public void setLog4j(){
		TestUtility.setDateForLog4j();
	}
	
	
	public static void initDriver(){
		String browser = property.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equals("IE")) {
			WebDriverManager.getInstance(InternetExplorerDriver.class);
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("Driver is not found");
		}
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));	
	}

}
