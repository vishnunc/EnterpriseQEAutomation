package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class TBB_PaymentPage {
	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB_HomePage");
	
	WebDriver driver;
	
	public TBB_PaymentPage(World world)
	{	
		this.world=world;	
	}
	
	/*
	 * Entering Credit card details
	 */
	public boolean enterCCDetails() {		
		System.out.println("enter CCDetails");
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_ccfName")), 120);
			WebElement CCFname=world.driver.findElement(By.xpath(elementLib.getString("input_ccfName")));
			Assert.assertTrue(CCFname.isEnabled(), "CCFname field is enabled");
			CCFname.sendKeys("testing");
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_cclName")), 30);
			WebElement CCLname=world.driver.findElement(By.xpath(elementLib.getString("input_cclName")));
			Assert.assertTrue(CCLname.isEnabled(), "CCLname field is enabled");
			CCLname.sendKeys("vv");
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_ccNum")), 30);
		
			WebElement CCnum=world.driver.findElement(By.xpath(elementLib.getString("input_ccNum")));
			Assert.assertTrue(CCnum.isEnabled(), "CCNum filed is enabled");
			CCnum.sendKeys("4111111111111111");		
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_ccMonth")), 30);
		
			WebElement CCMonth=world.driver.findElement(By.xpath(elementLib.getString("select_ccMonth")));
			Select ccMonth = new Select(CCMonth);
			ccMonth.selectByValue("08");
				
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_ccYear")), 30);
		
			WebElement CCYear=world.driver.findElement(By.xpath(elementLib.getString("select_ccYear")));
			Select ccYear = new Select(CCYear);
			ccYear.selectByValue("2024");
			
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_ccCVV")), 30);
		
			WebElement CVV=world.driver.findElement(By.xpath(elementLib.getString("input_ccCVV")));
			Assert.assertTrue(CVV.isEnabled(), "CVV field is enabled");
			CVV.sendKeys("123");
		} catch (Exception e1) {
			throw new RuntimeException("Credit card details not entered"+e1);
		}
		return true;
	}
	
	/*
	 * clicking on continue button
	 */
	public boolean clickccContinue() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_ccContinue")), 10);
		
			WebElement CCContinue=world.driver.findElement(By.xpath(elementLib.getString("button_ccContinue")));
			Assert.assertTrue(CCContinue.isEnabled(), "CC continue button enabled");
			CCContinue.click();
		} catch (Exception e1) {
			throw new RuntimeException("continue button not clicked"+e1);
		}
		return true;
		
	}
	
	
}
