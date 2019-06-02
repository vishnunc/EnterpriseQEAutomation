package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class TBB_AccountPage {
	private World world;
	public String mail;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB_HomePage");
	
	public TBB_AccountPage(World world)
	{
		this.world=world;
	}
	
	/*
	 * Creating account
	 */
	public void createAccount(String rEmail, String password, String rpassword, String dob, String gender) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_reenterEmail")), 120);
			String email = world.driver.findElement(By.xpath(elementLib.getString("input_AccEmail"))).getAttribute("value");
			WebElement ReEnterMail=world.driver.findElement(By.xpath(elementLib.getString("input_reenterEmail")));
			Assert.assertTrue(ReEnterMail.isEnabled(), "Email reenter filed enabled");
			ReEnterMail.sendKeys(email);					
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_password")), 30);
			WebElement Passwd=world.driver.findElement(By.xpath(elementLib.getString("input_password")));
			Assert.assertTrue(Passwd.isEnabled(), "password filed enabled");
			Passwd.sendKeys(password);		
				
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_reenterpassword")), 30);
			WebElement RPsswd=world.driver.findElement(By.xpath(elementLib.getString("input_reenterpassword")));
			Assert.assertTrue(RPsswd.isEnabled(),"Re enter password field is enabled");
			RPsswd.sendKeys(rpassword);
				
		//For DOB split by - and get all the details		
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_birthMonth")), 30);
			WebElement BirthMonth=world.driver.findElement(By.xpath(elementLib.getString("select_birthMonth")));
			Select month= new Select(BirthMonth);
			month.selectByValue(dob.split("-")[0]);
			
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_birthDay")), 30);
			WebElement BirthDay=world.driver.findElement(By.xpath(elementLib.getString("select_birthDay")));
			Select day= new Select(BirthDay);
			day.selectByValue(dob.split("-")[1]);
				
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_birthYear")), 30);
			WebElement BirthYear=world.driver.findElement(By.xpath(elementLib.getString("select_birthYear")));
			Select year= new Select(BirthYear);
			year.selectByValue(dob.split("-")[2]);
			//Save all the values
			world.setCustomerDetails("Email", email);
			
				
		//Select the appropriate gender				
			if(gender.equalsIgnoreCase("male")){
				world.driver.findElement(By.xpath(elementLib.getString("radio_genderMale"))).click();
			}
			else{
				world.driver.findElement(By.xpath(elementLib.getString("radio_genderFemale"))).click();
			}		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("radio_genderMale")), 30);
			WebElement Gender=world.driver.findElement(By.xpath(elementLib.getString("radio_genderMale")));
			
			//Read all the order details
			world.setOrderDetails("SubTotal", world.driver.findElement(By.xpath(elementLib.getString("text_SubTotal"))).getText().trim());
			world.setOrderDetails("Total", world.driver.findElement(By.xpath(elementLib.getString("text_Total"))).getText().trim());
			world.setOrderDetails("Tax", world.driver.findElement(By.xpath(elementLib.getString("text_Tax"))).getText().trim());
			world.setOrderDetails("SnH", world.driver.findElement(By.xpath(elementLib.getString("text_SnH"))).getText().trim());
		} catch (Exception e1) {
			throw new RuntimeException("Account not created"+e1);
		}
	}
	
	/*
	 *	//Select the coach option 
	 */
	public void selectCoachOption(String option) {

		if(option.equalsIgnoreCase("no")){
			WebElement Coach=world.driver.findElement(By.xpath(elementLib.getString("button_coachNo")));
			Assert.assertTrue(Coach.isEnabled(), "No coach option is enabled" );
			Coach.click();
		}
		else
		{
			WebElement Coach=world.driver.findElement(By.xpath(elementLib.getString("button_coachYes")));
			Assert.assertTrue(Coach.isEnabled(), "No coach option is enabled" );
			Coach.click();
			//Select the type of search for coach to email
			Select coachType = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_coachType"))));
			coachType.selectByValue("email");
			//Enter the coach email id
			world.driver.findElement(By.xpath(elementLib.getString("input_coachSearch"))).sendKeys("wave11uscoach19@yopmail.com");
			//Click on yes again to trigger event
			Coach.click();
		}
	}
	
	/*
	 *	//Select all the checkboxes
	 */
	public void acceptCheckboxes() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("checkbox_ContinuityDisclaimer")), 30);
			WebElement CheckBox=world.driver.findElement(By.xpath(elementLib.getString("checkbox_ContinuityDisclaimer")));
			Assert.assertTrue(CheckBox.isEnabled(), "continuity checkbox is enabled");
			CheckBox.click();
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("checkbox_termsAndConditions")), 30);
			WebElement TermsAndConditions=world.driver.findElement(By.xpath(elementLib.getString("checkbox_termsAndConditions")));
			Assert.assertTrue(TermsAndConditions.isEnabled(), "Terms and Conditions radio button enabled");
			TermsAndConditions.click();
		} catch (Exception e1) {
			throw new RuntimeException("Checkboxes not accepted"+e1);
		}			
	}
	
	//Submit the order and wait for process to finish
	public boolean submitOrder() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_submitOrder")), 30);
			WebElement BtnSubmitOrder=world.driver.findElement(By.xpath(elementLib.getString("button_submitOrder")));
			Assert.assertTrue(BtnSubmitOrder.isEnabled(), "Submit order button enabled");
			BtnSubmitOrder.click();
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_orderNumber")), 120);
		} catch (Exception e1) {
			throw new RuntimeException("submit order not clicked"+e1);
		}		
		return true;
	}
	
	/*
	 * Saving order number
	 */
	public boolean saveOrderNumber() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_orderNumber")), 120);
			//Save the value for other tests to use
			world.setOrderNum(world.driver.findElement(By.xpath(elementLib.getString("text_orderNumber"))).getText());
			WebElement SaveOrder=world.driver.findElement(By.xpath(elementLib.getString("text_orderNumber")));
			Assert.assertTrue(SaveOrder.isDisplayed(), "Order placed successfully");	
		} catch (Exception e1) {			
			throw new RuntimeException("order no not saved"+e1);
		}		
		return true;
	}

}
