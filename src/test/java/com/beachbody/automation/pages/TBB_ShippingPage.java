package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class TBB_ShippingPage {
	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB_HomePage");
	
	public TBB_ShippingPage(World world)
	{
		this.world=world;
	}
	
	/*
	 * clicking on continue shopping button
	 */
	public boolean continueToShipping(){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_continueToShipping")), 15);
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("link_continueToShipping")));
			Assert.assertTrue(e.isEnabled(), "continue shipping nutton enabled");
			e.click();
		} catch (Exception e1) {
			throw new RuntimeException("continue to shipping button not clicked"+e1);
		}		
		return true;
	}
	
	/*
	 * Entering shipping address
	 */
	
	public void enterShippingInfo(String fname, String lname, String phone, String address, String city, String state,
			String zip) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_firstName")), 15);		
			WebElement FirstName=world.driver.findElement(By.xpath(elementLib.getString("input_firstName")));
			Assert.assertTrue(FirstName.isEnabled(), "firstname field is enabled");
			FirstName.clear();
			FirstName.sendKeys(fname);
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_lastName")), 15);		
			WebElement LastName=world.driver.findElement(By.xpath(elementLib.getString("input_lastName")));
			Assert.assertTrue(FirstName.isEnabled(), "Lastname field is enabled");
			LastName.clear();
			LastName.sendKeys(lname);		
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_phoneNumber")), 15);		
			WebElement PhoneNumber=world.driver.findElement(By.xpath(elementLib.getString("input_phoneNumber")));
			Assert.assertTrue(PhoneNumber.isEnabled(), "phone number field is enabled");
			PhoneNumber.clear();
			PhoneNumber.sendKeys(phone);		
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_address1")), 15);		
			WebElement Addrs1=world.driver.findElement(By.xpath(elementLib.getString("input_address1")));
			Assert.assertTrue(Addrs1.isEnabled(), "Address1 field enabled");
			Addrs1.clear();
			Addrs1.sendKeys(address);		
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_state")), 15);		
			WebElement State=world.driver.findElement(By.xpath(elementLib.getString("select_state")));
			Select selState = new Select(State);
			selState.selectByValue(state);
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_zip")), 15);		
			WebElement ZipCode=world.driver.findElement(By.xpath(elementLib.getString("input_zip")));
			Assert.assertTrue(ZipCode.isEnabled(), "zip code filed enabled");
			ZipCode.clear();
			ZipCode.sendKeys(zip);		
		
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_city")), 15);	
			WebElement City=world.driver.findElement(By.xpath(elementLib.getString("input_city")));
			Assert.assertTrue(City.isEnabled(), "city filed enabled");
			City.clear();
			City.sendKeys(city);
			
			//Click to show the QAS pop up
			ZipCode.click();
			
			world.setCustomerDetails("FirstName", fname);
			world.setCustomerDetails("LastName", lname);
			world.setCustomerDetails("Phone", phone);
			world.setCustomerDetails("Address1", address);
			world.setCustomerDetails("City", city);
			world.setCustomerDetails("State", state);
			world.setCustomerDetails("Zip", zip);
		} catch (Exception e1) {
			throw new RuntimeException("shipping address notmatched"+e1);
		}
	}
	
	/*
	 * Validating Address
	 */
	public void validateQASAddress() {
		try {
			if(!driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_qasNo")), 60)){
				validateQASAddress();
			}
			WebElement QASNoButton=world.driver.findElement(By.xpath(elementLib.getString("button_qasNo")));
			QASNoButton.click();
		} catch (Exception e1) {
			throw new RuntimeException("QAS address not matched"+e1);
		}
	}
	
	/*
	 * Selecting shipping
	 */
	public void selectShipping(String ship) {
		try {
			Thread.sleep(2000);
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Continue")), 10);		
			WebElement ContinueButton=world.driver.findElement(By.xpath(elementLib.getString("select_shippingMethod")));
			Select selShip = new Select(ContinueButton);
			selShip.selectByValue(ship);
			//Assert.assertTrue(ContinueButton.isSelected(), "shipping method selected");
		} catch (Exception e1) {
			throw new RuntimeException("shipping not selected"+e1);
		}
	}

	/*
	 * Clicking on continue button
	 */
	public void clickContinue() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Continue")), 10);
			WebElement ContinueBtn=world.driver.findElement(By.xpath(elementLib.getString("button_Continue")));
			Assert.assertTrue(ContinueBtn.isEnabled(), "continue button is enabled");
			ContinueBtn.click();		  
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Continue")), 10);
		} catch (Exception e1) {
			throw new RuntimeException("continue button not clicked"+e1);
		}
	}
	/*
	 * Validating shipping taxes
	 */
	public void ValidateShippingHandlingTaxes()
	{
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("Validate_ShippingTaxes")), 10);		
			WebElement Taxes=world.driver.findElement(By.xpath(elementLib.getString("Validate_ShippingTaxes")));
			Assert.assertTrue(Taxes.isDisplayed(), "taxes updated");
			
			
		} catch (Exception e1) {
			throw new RuntimeException("Shipping taxes not matched"+e1);
		}
	}
}
