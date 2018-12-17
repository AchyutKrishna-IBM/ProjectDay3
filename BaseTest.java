package com.ibm.test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ibm.initialization.WebDriverLaunch;
import com.ibm.pages.AdminPage;
import com.ibm.pages.Login;


public class BaseTest extends WebDriverLaunch {
	
	    @Test
        public void positiveCredentials() throws FileNotFoundException, IOException
        {
		String url = p.getProperty("url");
		String UserName = p.getProperty("user");
		String Password = p.getProperty("password");
        driver.get(url);
		Login login = new Login(driver,wait);
		login.enterEmailAddress(UserName);
		login.enterPassword(Password);
		login.clickOnLogin();

        }
	   @AfterMethod
	    public void pushNotificationDeletion() throws InterruptedException
	    {
		   
		   String searchEle=p.getProperty("search");
		   String message=p.getProperty("message");
	    	AdminPage adm=new AdminPage(driver,wait);
	    	adm.clickOnMarketing();
	    	Thread.sleep(5000);
	    	adm.clickOnPushNotification();
	    	adm.searchPushNotificationToBeDeleted(searchEle);
	    	adm.clickOnPushNotificationAction();
	    	adm.selectAndDelete();
	    	Thread.sleep(3000);
	 //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='confirm']")));
	    	adm.clickOnconfirmDelEle();
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='search']")));
	    	adm.SearchPushNotificationAfterDeletion(searchEle);
	    	adm.verifyingDeletionOfPushNotification(searchEle,message);
	    	
	    	
	    	
	    }
}
