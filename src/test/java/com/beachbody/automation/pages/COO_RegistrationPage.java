package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.CommonUtilities;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class COO_RegistrationPage {
	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib = ResourceBundle.getBundle("com\\beachbody\\automation\\elementlib\\COO_RegistationPage");
	CommonUtilities re = new CommonUtilities();

	public COO_RegistrationPage(World world) {
		this.world = world;
	}

	public boolean clickSignUpLink() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_signup")), 5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		world.driver.findElement(By.xpath(elementLib.getString("link_signup"))).click();
		return true;
	}

	public boolean verifySignUpStatus(String status) {
		String signup = elementLib.getString("placeholder_button_signup").replaceAll("PLACEHOLDER", status);
		if (world.driver.findElement(By.xpath(signup)).isDisplayed() == true) {
			return true;
		} else {
			return false;
		}
	}

	public void fillInfo(String country, String language, String pswd,
		String phone, String month, String date, String year, String govtid, String sign) {

		verifyElementPresence(elementLib.getString("select_country"),10);
		Select selCountry = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_country"))));
		selCountry.selectByValue(country);

		verifyElementPresence(elementLib.getString("select_language"),10);
		Select selLanguage = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_language"))));
		selLanguage.selectByValue(language);
		
		String fname = re.generateRandomString();
		String lname = re.generateRandomString();
		String email = fname+"@yopemail.com";
		
		verifyElementPresence(elementLib.getString("input_firstname"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_firstname"))).sendKeys(fname);

		verifyElementPresence(elementLib.getString("input_lastname"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_lastname"))).sendKeys(lname);

		verifyElementPresence(elementLib.getString("input_email"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_email"))).sendKeys(email);

		verifyElementPresence(elementLib.getString("input_confirmemail"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_confirmemail"))).sendKeys(email);

		verifyElementPresence(elementLib.getString("input_password"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_password"))).sendKeys(pswd);

		verifyElementPresence(elementLib.getString("input_confirmpassword"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_confirmpassword"))).sendKeys(pswd);

		verifyElementPresence(elementLib.getString("input_phone"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_phone"))).sendKeys(phone);

		verifyElementPresence(elementLib.getString("select_month"),10);
		Select selMonth = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_month"))));
		selMonth.selectByValue(month);

		verifyElementPresence(elementLib.getString("select_day"),10);
		Select selDay = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_day"))));
		selDay.selectByValue(date);

		verifyElementPresence(elementLib.getString("select_year"),10);
		Select selYear = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_year"))));
		selYear.selectByValue(year);
		
		/*
		 * WebElement govt_id =
		 * world.driver.findElement(By.xpath(elementLib.getString("input_govtid")));
		 * govt_id.sendKeys(govtid);
		 */
		
		

		verifyElementPresence(elementLib.getString("radio_genderMale"),10);
		world.driver.findElement(By.xpath(elementLib.getString("radio_genderMale"))).click();
		
		
		verifyElementPresence(elementLib.getString("input_govtid"),10);
		WebElement govt_id = world.driver.findElement(By.xpath(elementLib.getString("input_govtid")));
		
		govt_id.clear();
		govt_id.sendKeys(govtid);
		
				
		verifyElementPresence(elementLib.getString("input_sign"),10);
		world.driver.findElement(By.xpath(elementLib.getString("input_sign"))).sendKeys(sign);

		
	}

	public boolean clickNoCoachButton() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_coachNo")), 10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		world.driver.findElement(By.xpath(elementLib.getString("button_coachNo"))).click();
		return true;
	}

	public boolean clickDisclaimerCheckBox() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("checkbox_disclaimer")), 5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		world.driver.findElement(By.xpath(elementLib.getString("checkbox_disclaimer"))).click();
		return true;
	}

	public boolean clickTermsCheckBox() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("checkbox_terms")), 5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		world.driver.findElement(By.xpath(elementLib.getString("checkbox_terms"))).click();
		return true;
	}

	public boolean clickContinueButton() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_continue")), 5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		world.driver.findElement(By.xpath(elementLib.getString("button_continue"))).click();
		return true;
	}
	
	public boolean verifyChallengePackStatus(String status) {
		String challengePack = elementLib.getString("placeholder_button_challengepack").replaceAll("PLACEHOLDER", status);
		if (world.driver.findElement(By.xpath(challengePack)).isDisplayed() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyTopSellersStatus(String status) {
		String topSeller = elementLib.getString("placeholder_button_topsellers").replaceAll("PLACEHOLDER", status);
		if (world.driver.findElement(By.xpath(topSeller)).isDisplayed() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void verifyElementPresence(String strXpath,int seconds) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(strXpath), seconds);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
