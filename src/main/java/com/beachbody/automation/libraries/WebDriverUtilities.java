package com.beachbody.automation.libraries;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

import com.beachbody.automation.common.World;

public class WebDriverUtilities {
	
	
	public boolean click(WebDriver driver,By ele)
	{
		try
		{
			findElement(driver,ele).click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean enter_text(WebDriver driver,By ele,String val)
	{
		try
		{
			
			findElement(driver,ele).clear();
			findElement(driver,ele).sendKeys(val);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean mouseOver(WebDriver driver,By ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(findElement(driver,ele));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public WebElement findElement(WebDriver driver,By ele)
	{
		try
		{
			WebElement web = driver.findElement(ele);
			return web;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public boolean waitforElementPresent(WebDriver driver,By ele,int secs) throws InterruptedException
	{
		int timecount=0;
		while(timecount<secs)
		{
			if(findElement(driver,ele)!=null)
			{
				return true;
			}
			Thread.sleep(1000);
			timecount=timecount+1;
		}
		return false;
	}
	
	public String getElementText(WebDriver driver,By ele)
	{
		if(findElement(driver,ele)!=null)
		{
			return findElement(driver,ele).getText();
		}
		else
		{
			return null;
		}
	}
	
	public byte[] captureScreenshot(WebDriver driver)
	{
		try {  
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);  
            return screenshot;
        } catch (WebDriverException wde) {  
            System.err.println(wde.getMessage()); 
            return null;
        } catch (ClassCastException cce) {  
            cce.printStackTrace(); 
            return null;
        } 
	}
	public String randomEmail() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		return "username"+ randomInt +"@yopmail.com"; 
	}
	
	public void verifyElementPresence(WebDriverUtilities util,WebDriver driver,String strXpath,int seconds) {
		
    	boolean result = false;
    	try {
    		result = util.waitforElementPresent(driver, By.xpath(strXpath), seconds);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block			
			e1.printStackTrace();
		}
		Assert.assertTrue(result,"Unable to find element using :"+strXpath);
	}
}
