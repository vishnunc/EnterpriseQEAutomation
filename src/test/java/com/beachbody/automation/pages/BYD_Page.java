package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.CommonUtilities;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class BYD_Page {

	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	public CommonUtilities commonUtilities = new CommonUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.BYDPages");
	public BYD_Page(World world){
		this.world=world;
	}
			
	//Entering username
	public boolean enterUserName(String userName) {	
		try {
		driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("textbox_Username"), 10);
			world.driver.findElement(By.xpath(elementLib.getString("textbox_Username"))).sendKeys(userName);	
		} catch (Exception e1) {
			throw new RuntimeException("username not entered"+e1);
		}
		return true;
	}
 
	//Entering Password
	public boolean enterPassword(String password) {	
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("textbox_Password"), 10);
			world.driver.findElement(By.xpath(elementLib.getString("textbox_Password"))).sendKeys(password);	
		}catch (Exception e1) {
			 throw new RuntimeException("password not entered"+e1);
		}		
			return true;
	
	}
	
	//Clicking on signin button
	public boolean clickOnSignInButton() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("button_SignIn"), 10);
			world.driver.findElement(By.xpath(elementLib.getString("button_SignIn"))).click();
		}catch (Exception e1) {
			throw new RuntimeException("signin button not clicked"+e1);
		}
			return true;		
	}
	
	//Entering email
	public boolean enterEmail(String email) {
	   try{
		   driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("textbox_CustomerEmail"), 20);
		   world.driver.findElement(By.xpath(elementLib.getString("textbox_CustomerEmail"))).sendKeys(email);
	   }catch(Exception e1) {
			   throw new RuntimeException("email not entered"+e1);
       }   
   	   return true;
	}
	
	//Clicking on search button
	public boolean clickOnSearch() {	   
  	    boolean result = false;  		
		try{
		   driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Search")), 20);  
		   result = true;	       	   
		   world.driver.findElement(By.xpath(elementLib.getString("button_Search"))).click();
	       Assert.assertTrue(result,"Unable to find element button_Search in Bydesign Page");
		}catch(Exception e1) {
			throw new RuntimeException("search button not clicked"+e1);
	       }
       return result;
	}
	
	//Clicking on results tab
	public boolean clickOnResultsTab() {	   
	      try{
		   driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_ResultsTab")), 20);  
   		   world.driver.findElement(By.xpath(elementLib.getString("link_ResultsTab"))).click();
	      }catch(Exception e1) {
	    	  throw new RuntimeException("results tab not clicked"+e1);
	       }
       return true;
}

	//Verifying customer details
	public boolean verifyCustomerDetails(String txt) {
	boolean ele=false;
	try {
		driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("table_ResultsRow"), 20);
		String temp = world.driver.findElement(By.xpath(elementLib.getString("table_ResultsRow"))).getText();
		ele = temp.trim().contains(txt.trim());  
		Assert.assertTrue(ele,txt+" Desent exist");    
		}catch(Exception e1) {
			throw new RuntimeException("Customer details not mached"+e1);
		}	
		return ele;
	}
	
	//Click on customer data
	public boolean clickOnCustomerData() {
	     try{
	    	 driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("table_ResultsRow"), 20);  
	    	 world.driver.findElement(By.xpath(elementLib.getString("table_ResultsRow"))).click();
	       }catch(Exception e1) {
	    	   throw new RuntimeException("customer data not clicked"+e1);
	       }
	         return true;
	}
	
	//Verifying customer details
	public boolean verifyOtherCustomerDetails(String txt) {
		boolean ele=false;
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("text_Customer_Info"), 20);
			ele = world.driver.findElement(By.xpath(elementLib.getString("text_Customer_Info"))).getText().trim().contains(txt.trim()); 
		
			Assert.assertTrue(ele,txt+" Desent exist");
			}catch(Exception e1) {
				throw new RuntimeException("Customer details are not mached"+e1);
			}
			return ele;
		}
	
	//Verifying order details
	public boolean verifyOrderDetails(String txt) {	   
         boolean ele=false;
	     	try {
	     		driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("text_Customer_Info"), 20);
	     		ele = world.driver.findElement(By.xpath(elementLib.getString("text_Customer_Info"))).getText().trim().contains(txt.trim());  
	     	     	
	     	Assert.assertTrue(ele,txt+" Desent exist");
	     	}catch(Exception e1) {
	     		throw new RuntimeException("order details not mached"+e1);
	     	}
	     	return ele;
	}
	
	//Click on order number
	public boolean clickOnOrderNumber() {	      
		try{
			driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("text_Order_Row"), 30);
           world.driver.findElement(By.xpath(elementLib.getString("text_Order_Row"))).click();
	       }catch(Exception e1) {
	    	   throw new RuntimeException("order number not clicked"+e1);
	       }
	         return true;
	}
	
	//Verifying billing address
	public boolean verifyBillingAddress(String txt) {	     	         
         boolean ele=false;
	     	try {
	     		driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("text_Complete_Shipping_and_Billing_Address"), 20); 
	     		String tmp = world.driver.findElement(By.xpath(elementLib.getString("text_Complete_Shipping_and_Billing_Address"))).getText().trim();
	     		
	     		ele = tmp.contains(txt.trim()) || txt.contains(tmp.trim());  
	     		Assert.assertTrue(ele,txt+" Desent exist");
	     	}catch(Exception e1) {
	     		throw new RuntimeException("Billing address not mached"+e1);
	     	}	     	
	     	return ele;
	}
	
	//Verifying order details
	public boolean verifyOrderInfo(String txt) {
		boolean ele=false;
	      try{
	    	  driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("text_OrderInfo"), 20);
	    	  String abc = world.driver.findElement(By.xpath(elementLib.getString("text_OrderInfo"))).getText().trim();
	    	  ele= abc.contains(txt.trim());
	    	  Assert.assertTrue(ele,txt+" Desent exist");
	       }catch(Exception e1) {
	    	   throw new RuntimeException("Order details not mached"+e1);
	       }	      
	     	return ele;
	}
	
	//verifying miscoder details
	public boolean verifyMiscOrderInfo(String txt) {
		boolean ele=false;
	      try{
	    	  driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("text_Order_misc"), 20);
	    	  String abc = world.driver.findElement(By.xpath(elementLib.getString("text_Order_misc"))).getText().trim();
	    	  ele= abc.contains(txt.trim());
	    	  Assert.assertTrue(ele,txt+" Desent exist");
	       }catch(Exception e1) {
	    	   throw new RuntimeException("MIscOrder details not mached"+e1);
	       }	      
	     	return ele;
	}
	
	//Clicking on logout button
	public boolean clickOnLogOut() {
	       try{
	    	   driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("link_logout"), 20);
	    	   world.driver.findElement(By.xpath(elementLib.getString("link_logout"))).click();
	       }catch(Exception e1) {
	    	   throw new RuntimeException("Logout button not clicked"+e1);
	       }
	         return true;
	}

	//Verifying shiping order info
	public boolean verifyShippingOrderInfo(String txt) {
		boolean ele=false;
	      try{
	    	  driverUtils.verifyElementPresence(driverUtils, world.driver, elementLib.getString("text_Order_shipping"), 20);
	    	  String abc = world.driver.findElement(By.xpath(elementLib.getString("text_Order_shipping"))).getText().trim();
	    	  ele= abc.contains(txt.trim());
	    	  Assert.assertTrue(ele,txt+" Desent exist");
	       }catch(Exception e1) {
	    	   throw new RuntimeException("Shipping order details not mached"+e1);
	       }	      
	      return ele;		
	}
}
