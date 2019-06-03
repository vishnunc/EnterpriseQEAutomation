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
		   driverUtils.verifyElementPresence(driverUtils, world.ieDriver, elementLib.getString("textbox_CustomerEmail"), 20);
		   world.ieDriver.findElement(By.xpath(elementLib.getString("textbox_CustomerEmail"))).sendKeys(email);
	   }catch(Exception e1) {
			   throw new RuntimeException("email not entered"+e1);
       }   
   	   return true;
	}
	
	//Clicking on search button
	public boolean clickOnSearch() {	   
  	    boolean result = false;  		
		try{
		   driverUtils.waitforElementPresent(world.ieDriver, By.xpath(elementLib.getString("button_Search")), 40);  
		   result = true;	       	   
		   world.ieDriver.findElement(By.xpath(elementLib.getString("button_Search"))).click();
	       Assert.assertTrue(result,"Unable to find element button_Search in Bydesign Page");
		}catch(Exception e1) {
			throw new RuntimeException("search button not clicked"+e1);
	       }
       return result;
	}
	
	//Clicking on results tab
	public boolean clickOnResultsTab() {	   
	      try{
		   driverUtils.waitforElementPresent(world.ieDriver, By.xpath(elementLib.getString("link_ResultsTab")), 20);  
   		   world.ieDriver.findElement(By.xpath(elementLib.getString("link_ResultsTab"))).click();
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

	public boolean login(String username,String password) {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.ieDriver, elementLib.getString("textbox_Username"), 120);
			world.ieDriver.findElement(By.xpath(elementLib.getString("textbox_Username"))).sendKeys(username);	
			world.ieDriver.findElement(By.xpath(elementLib.getString("textbox_Password"))).sendKeys(password);	
			world.ieDriver.findElement(By.xpath(elementLib.getString("button_SignIn"))).click();
		}catch (Exception e1) {
				throw new RuntimeException("signin button not clicked"+e1);
		}
				return true;
	}
	
	
	public void validateCustomerDetails() {
		//Validate Email
		String Email = world.driver.findElement(By.xpath(elementLib.getString("text_Email"))).getText();
		if(!world.getCustomerDetails().get("Email").equalsIgnoreCase(Email)){
			throw new RuntimeException("Email did not match");
		}
		//validate FirstName
		String FirstName = world.driver.findElement(By.xpath(elementLib.getString("text_Name"))).getText();
		String[] fname=FirstName.split("");
		if(!world.getCustomerDetails().get("FirstName").equalsIgnoreCase(fname[0])){
			throw new RuntimeException("FirstName did not match");
		}
		//validate LastName
		String LastName = world.driver.findElement(By.xpath(elementLib.getString("text_Name"))).getText();
		String[] lname=LastName.split("");
		if(!world.getCustomerDetails().get("LastName").equalsIgnoreCase(lname[1])){
			throw new RuntimeException("LastName did not match");
		}
		//validate Phone
		String Phone = world.driver.findElement(By.xpath(elementLib.getString("text_Phone"))).getText();
		if(!world.getCustomerDetails().get("Phone").equalsIgnoreCase(Phone)){
			throw new RuntimeException("Phone did not match");
		}
		 //validate Network
		String Network = world.driver.findElement(By.xpath(elementLib.getString("text_Network"))).getText();
		if(!world.getCustomerDetails().get("Network").equalsIgnoreCase(Network)){
			throw new RuntimeException("Network did not match");
		}
		
	}		
		
	public void verifyOrderDetails() {
		//Validate OrderNum
		String OrderNum = world.driver.findElement(By.xpath(elementLib.getString("text_OrderNumber"))).getText();
		if(!world.getCustomerDetails().get("OrderNum").equalsIgnoreCase(OrderNum)){
			throw new RuntimeException("OrderNumber did not match");
		}
		//validate OrderDate
		String OrderDate = world.driver.findElement(By.xpath(elementLib.getString("text_OrderDate"))).getText();
		if(!world.getCustomerDetails().get("OrderDate").equalsIgnoreCase(OrderDate)){
			throw new RuntimeException("OrderDate did not match");
		}
		//validate CustomerRole
		String CustomerRole = world.driver.findElement(By.xpath(elementLib.getString("text_Network"))).getText();
		if(!world.getCustomerDetails().get("CustomerRole").equalsIgnoreCase(CustomerRole)){
			throw new RuntimeException("CustomerRole did not match");
		}
		//validate FirstName
		String FirstName = world.driver.findElement(By.xpath(elementLib.getString("text_Name"))).getText();
		String[] fname=FirstName.split("");
		if(!world.getCustomerDetails().get("FirstName").equalsIgnoreCase(fname[0])){
			throw new RuntimeException("FirstName did not match");
		}
		 //validate LastName
		String LastName = world.driver.findElement(By.xpath(elementLib.getString("text_Name"))).getText();
		String[] lname=LastName.split("");
		if(!world.getCustomerDetails().get("LastName").equalsIgnoreCase(lname[1])){
			throw new RuntimeException("LastName did not match");
		}
									
	}

	
}
