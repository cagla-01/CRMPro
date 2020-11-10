package com.qa.crmpro.utulities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.crmpro.base.BasePage;

public class TestUtility extends BasePage {
	// Set Date for my Log4j
		public static void setDateForLog4j() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			System.setProperty("currentDate", dateFormat.format(new Date()));
			PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		}
		// To take a screenshot at the end of each test
		public static void takeScreenshotAtEndOfTest() {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currDir = System.getProperty("user.dir");
			try {
				FileUtils.copyFile(source, new File(currDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

}
