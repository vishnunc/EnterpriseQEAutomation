package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TBB_ProductDetailspage {
	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB_HomePage");
	
	public TBB_ProductDetailspage(World world)
	{
		this.world=world;
	}
	
	/*
	 * Verifying PDP page
	 */
	public boolean verifyPDPPage()
	{
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("title_PDP")), 10);
			WebElement a=world.driver.findElement(By.xpath(elementLib.getString("title_PDP")));
			Assert.assertTrue(a.isDisplayed(), "PDP page displayed succesffully");			
		} catch (Exception e1) {
			throw new RuntimeException("PDP page not loaded"+e1);
		}
		return true;
	}
	
	/*
	 * Selecting flavor
	 */
     public boolean selectFlavor(String flavor){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Flavor")), 15);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("select_Flavor")));
			e.click();
			Select selectFlav = new Select(e);
			selectFlav.selectByValue(flavor);
		} catch (Exception e1) {
			throw new RuntimeException("flavor not selected"+e1);
		}
		return true;
	}
     
     /*
      * Selecting recover packaging
      */
     public boolean RecoverPackaging(String RPacking){
         try {
             driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_RecoverPackage")), 15);         
	         WebElement e=world.driver.findElement(By.xpath(elementLib.getString("select_RecoverPackage")));
	         Select selectRecover = new Select(e);
	         selectRecover.selectByValue(RPacking);
	         Assert.assertTrue(e.isEnabled(), "recover packing option is selected");
         } catch (Exception e1) {
        	 throw new RuntimeException("recover packaging not selected"+e1);
         }
         return true;
     }
     
     /*
      * Selecting packaging
      */
	public boolean selectPackaging(String packaging){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Packaging")), 15);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("select_Packaging")));
			e.click();
			Select selectPack = new Select(e);
			selectPack.selectByValue(packaging);
		} catch (Exception e1) {
			throw new RuntimeException("packaging not selected"+e1);
		}
		return true;
	}
	
	/*
	 * Selecting recover
	 */
	public boolean selectRecover(String recover){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Recover")), 15);
		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("select_Recover")));
			e.click();
			Select selectRecover = new Select(e);
			selectRecover.selectByValue(recover);
			} catch (Exception e1) {
				throw new RuntimeException("recover not selected"+e1);
			}
		return true;
	}
	
	/*
	 * Selecting quantity
	 */
	public boolean selectQuantity(String qty){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Quantity")), 15);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("select_Quantity")));
			e.click();
			Select selectQty = new Select(e);
			selectQty.selectByValue(qty);
			} catch (Exception e1) {
				throw new RuntimeException("Quantity not selected"+e1);
			}
		return true;
	}
	
	/*
	 * clicking on add to cart button
	 */
	public boolean clickAddToCart(){
		try {
			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_AddToCart")), 30);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("button_AddToCart")));
			e.click();
		} catch (Exception e1) {
			throw new RuntimeException("Add to cart not clicked"+e1);
			}
		return true;
	}
	
	/*
	 * Clicking on view cart button
	 */
	public boolean clickViewCart(){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_ViewCart")), 20);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("link_ViewCart")));
			Assert.assertTrue(e.isEnabled(), "view cart enabled to click");
			e.click();
		} catch (Exception e1) {
			throw new RuntimeException("viewcart not clicked"+e1);
			}
		return true;
	}
	
	/*
	 * Verifying popup with pack
	 */
	public boolean ValidatePopUpWithPack(){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_ProductTitle")), 20);		
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("text_ProductTitle")));
			Assert.assertTrue(e.isDisplayed(), "popUp with powerpack is displayed");
		} catch (Exception e1) {
			throw new RuntimeException("popup is not displayed"+e1);
			}
		return true;	
	}

}
