package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class TBB_CheckOutPage {
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB_HomePage");
	private World world;
	WebDriver driver;
	
	public TBB_CheckOutPage(World world)
	{
		this.world=world;
	}
	
	/*
	 * entering the email and clicking on begin checkout
	 */
	public boolean beginCheckout(String email){
		System.out.println("begin checkout");		
		try{		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_Email")), 20);
			WebElement eleme=world.driver.findElement(By.xpath(elementLib.getString("input_Email")));
			Assert.assertTrue(eleme.isEnabled(), "Email filed enabled");
			driverUtils.randomEmail(driver, eleme);			
				
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_BeginCheckout")), 20);
			WebElement BeGinCheckOut=world.driver.findElement(By.xpath(elementLib.getString("button_BeginCheckout")));
			Assert.assertTrue(BeGinCheckOut.isEnabled(), "BeginCheckout button enabled");
			BeGinCheckOut.click();
		} catch (Exception e1) {
			throw new RuntimeException("email not entered or begin checkout not clicked"+e1);
		}				
		return true;
	}
	
	
	
}
