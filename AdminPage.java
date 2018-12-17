package com.ibm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminPage{
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//*[@id='side-menu']/li[5]/a")
	WebElement marketingEle;
	@FindBy(xpath="//*[@id='side-menu']/li[5]/ul/li[3]/a")
	WebElement pushNotEle;
	@FindBy(xpath="//input[@type='search']")
	WebElement searchEle;
	@FindBy(xpath="//button[@class='btn dropdown-toggle btn-primary']")
	WebElement actionEle;
	@FindBy(xpath="//*[@id='dataTableExample2']/tbody/tr/td[6]/div/ul/li[2]/a")
	WebElement delePushNotEle;
	@FindBy(xpath="//button[@class='confirm']")
	WebElement delePushNotConfEle;
	@FindBy(xpath="//*[@id='dataTableExample2']/tbody/tr[3]/td[2]")
	WebElement NotNameEle;
	@FindBy(xpath="//*[@id='dataTableExample2']/tbody/tr[3]/td[3]")
	WebElement messageEle;
	
	
	public AdminPage(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}
	public void clickOnMarketing()
	{
		marketingEle.click();
	}
	public void clickOnPushNotification()
	{
		pushNotEle.click();
	}
	public void searchPushNotificationToBeDeleted(String searchedEle)
	{
		searchEle.sendKeys(searchedEle);
	}
	public void clickOnPushNotificationAction()
	{
		actionEle.click();
	}
	public void selectAndDelete()
	{
		delePushNotEle.click();
	}
	public void clickOnconfirmDelEle()
	{
		delePushNotConfEle.click();
	}
	public void SearchPushNotificationAfterDeletion(String searchDeletedPushNot)
	{
		searchEle.sendKeys(searchDeletedPushNot);	
	}
	public void verifyingDeletionOfPushNotification(String notificationName,String messageName)
	{
		Assert.assertFalse(driver.getPageSource().contains(notificationName));
		Assert.assertFalse(driver.getPageSource().contains(messageName));
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
