package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class COO_LoginPage {

	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib = ResourceBundle.getBundle("com.beachbody.automation.elementlib.COO_LoginPage");

	public COO_LoginPage(World world) {
		this.world = world;
	}
	
	/*
	 * Entering credentials
	 */
	public boolean enterlogin(String user, String pswd) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_Email")), 10);
			world.driver.findElement(By.xpath(elementLib.getString("input_Email"))).sendKeys(user);
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_Password")), 10);
			world.driver.findElement(By.xpath(elementLib.getString("input_Password"))).sendKeys(pswd);
		} catch (Exception e1) {
			throw new RuntimeException("COO credentials are not entered"+e1);
		}
		return true;
	}
	
	public boolean login(String username, String password) {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("input_Email") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("input_Email"))).sendKeys(username);	
			world.driver.findElement(By.xpath(elementLib.getString("input_Password"))).sendKeys(password);
			world.driver.findElement(By.xpath(elementLib.getString("button_Sign"))).click();
		}catch (Exception e1) {
			throw new RuntimeException("Login not successful "+e1);
		}
			return true;					
	}

	/*
	 * Clicking on signin button
	 */
	public boolean clickonSignbutton() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Sign")), 10);
			world.driver.findElement(By.xpath(elementLib.getString("button_Sign"))).click();
		} catch (Exception e1) {
			throw new RuntimeException("Sign in button not clicked"+e1);
		}
		return true;
	}
}
