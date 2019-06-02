package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class TBB_ShoppingCartPage {

	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB_HomePage");
	
	public TBB_ShoppingCartPage(World world)
	{
		this.world=world;
	}
	
	/*
	 * validating title
	 */
	public boolean validateTitle() throws Exception {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("Validate_CartTitle")), 20);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("Validate_CartTitle")));
			Assert.assertTrue(e.isDisplayed(), "title displayed with selected package");
		} catch (Exception e) {
			throw new Exception("TBB title not displaying"+e);
		}
		return true;
	}

	/*
	 * validating quantity
	 */
	public void validateQuantity() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("Validate_CartQuantity")), 20);		
			String attrib=world.driver.findElement(By.xpath(elementLib.getString("Validate_CartQuantity"))).getAttribute("data-option-qty");
			Assert.assertEquals(attrib, "1", "product quantity is 1");			
		}catch (Exception e1) {		
			throw new RuntimeException("product Quantity is not matched"+e1);
		}
	}
	
	/*
	 * validating price
	 */
	public boolean validatePrice() {
		// TODO Auto-generated method stub
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("Validate_CartPrice")), 20);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("Validate_CartPrice")));
			Assert.assertTrue(e.isDisplayed(), "product price displayed");
		} catch (Exception e1) {
			throw new RuntimeException("price not matched"+e1);
		}
		return true;
	}
	
	/*
	 * Validating order cart summary
	 */
	public boolean validateSummary() {
		// TODO Auto-generated method stub
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("Validate_CartOrderSummary")), 20);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("Validate_CartOrderSummary")));
			Assert.assertTrue(e.isDisplayed(), "product summary displayed");
		} catch (Exception e1) {
			throw new RuntimeException("summary button not matched"+e1);
		}
		return true;
	}
		
	/*
	 * Validating subtotal and estimated total
	 */
    public boolean validateSubTotal_EstimatedTotal(String subtotal,String estimatedtotal){
    	try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("Validate_CartSubTotal")), 20);		
	    	WebElement e=world.driver.findElement(By.xpath(elementLib.getString("Validate_CartSubTotal")));
	    	Assert.assertTrue(e.isDisplayed(), "product cart subtotal displayed");
    	
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("Validate_CartEstimatedTotal")), 20);		
	    	WebElement a=world.driver.findElement(By.xpath(elementLib.getString("Validate_CartEstimatedTotal")));
	    	Assert.assertTrue(a.isDisplayed(), "product cart Estimatedtotal displayed");
    	} catch (Exception e1) {
    		throw new RuntimeException("subtotal and estimated total not matched"+e1);
		}
		return true;
    }
    
    /*
     * Clicking on checkout button
     */
    public boolean clickCheckout(){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Checkout")), 20);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("button_Checkout")));
			Assert.assertTrue(e.isEnabled(), "checkout button enabled to click");
			e.click();
		} catch (Exception e1) {
			throw new RuntimeException("checkout button not clicked"+e1);
		}
		return true;
	}
	
}
