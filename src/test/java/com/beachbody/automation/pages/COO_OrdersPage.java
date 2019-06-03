package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.ConfigFileReader;
import com.beachbody.automation.libraries.WebDriverUtilities;



public class COO_OrdersPage  {
    private World world;
    String orderDateDescrp,customerIdDescrp,firstNameDescrp,lastNameDescrp,orderDescrp,homeDirectDescrp,emailDescrp,amountDescrp,phoneDescrp,statusDescrp,voulumeDescrp,trackingDescrp,ordersReportPage,productsNameDescrp,orderTypeDescrp,customerTypeDescrp, customerSourceDescrp,
	lastOrderDateDescrp, phoneNumberDescrp, langPrefDescrp, street1Descrp,joinDateDescrp,product,orderType,trackingNumberDescrp,volumedescrp,statusdescrp,ordernoDescrp,homedirectDescrp;
	
    Boolean result;
    
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.COO_MyOrdersPage");
	public void COO_MyPersonalandCustomerOrders(World world){
		this.world=world;
        }

	public COO_OrdersPage(World world) {
		this.world = world;
	}

	/*
	 * clicking on my personal and customers orders link
	 */
   public boolean clickMyPersonalAndCustomerOrders(){				
		try {
			System.out.println("The retrieved element is :" + elementLib.getString("link_MyPersonalandCustomerOrders"));
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_MonitorMyBusiness")),
					40);
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_MyPersonalandCustomerOrders")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("link_MonitorMyBusiness"))).click();
			world.driver.findElement(By.xpath(elementLib.getString("link_MyPersonalandCustomerOrders"))).click();
		} catch (Exception e1) {
			throw new RuntimeException("MyPersonalAndCustomerOrders not clicked"+e1);
		}		
		return true;		
    }

   /*
	 * verifying report page
	 */
    public boolean validateReportPage(String text) {
    	boolean result = false;
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Order")), 5);
			if (world.driver.findElement(By.xpath(elementLib.getString("textdata_Order"))).getText()
					.equalsIgnoreCase(text)) {
				return result;
			}
		} catch (Exception e1) {
			throw new RuntimeException("report page not matched"+e1);
		}		
		return result;
	}
    
    /*
	 * entering order number
	 */ 
   public boolean enterOrderNumber(String orderNumber) {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("input_OrderNumber") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("input_OrderNumber"))).sendKeys(orderNumber);
		}catch (Exception e1) {			
			throw new RuntimeException("order number not entered"+e1);
		}
		return true;
	}

   /*
	 * clicking on search button
	 */
   public boolean clickSearch() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Search")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("button_Search"))).click();
		} catch (Exception e1) {
			throw new RuntimeException("search button not clicked"+e1);
		}		
		return true;
	}

   /*
	 * verifying order date
	 */
	public String Orderdate() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_OrderDate")), 5);
			orderDateDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_OrderDate"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("order date not matched"+e1);
		}				
		return orderDateDescrp;
	}
	
	/*
	 * verifying customer Id
	 */
	public String CustomerId() {		
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_CustomerID")), 5);
			customerIdDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerID"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("CustomerId not matched"+e1);
		}				
		return customerIdDescrp;
	}

	/*
	 * verifying first name
	 */
	public String FirstName() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("c")), 5);
			firstNameDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_FirstName"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("FirstName not matched"+e1);
		}						
		return firstNameDescrp;
	}

	/*
	 * verifying last name
	 */
	public String lastName() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_LastName")), 5);
			lastNameDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_LastName"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("lastName not matched"+e1);
		}		
		return lastNameDescrp;
	}

	/*
	 * verifying order number 
	 */
	public String ordernumber() {		
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Order")), 5);
			ordernoDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Order"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("ordernumber not matched"+e1);
		}		
		return ordernoDescrp;
	}

	/*
	 * verifying homedirect
	 */
	public String homedirect() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_HomeDirect")), 5);
			homedirectDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_HomeDirect"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("homedirect not matched"+e1);
		}				
		return homedirectDescrp;
	}
	

	/*
	 * verifying email
	 */
	public String verifyEmail() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Email")), 5);
			emailDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Email"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("email not matched"+e1);
		}						
		return emailDescrp;
	}
	

	/*
	 * verifying amount
	 */
	public String Amount() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Amount")), 5);
			amountDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Amount"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("Amount not matched"+e1);
		}								
		return amountDescrp;
	}
	

	/*
	 * verifying phonenumber
	 */
	public String phonenumber() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Phone")), 5);
			phoneDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Phone"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("phonenumber not matched"+e1);
		}								
		return phoneDescrp;
	}
	
	/*
	 * verifying Status
	 */
	public String Status() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Status")), 5);
			statusdescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Status"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("Status not matched"+e1);
		}				
		return statusdescrp;
	}
	
	/*
	 * verifying volume
	 */
	public String volume() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Volume")), 5);
			volumedescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Volume"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("volume not matched"+e1);
		}				
		return volumedescrp;
	}
	
	/*
	 * verifying TrackingNumber
	 */
	public String TrackingNumber() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Tracking")), 5);
			trackingNumberDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Tracking"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("TrackingNumber not matched"+e1);
		}						
		return trackingNumberDescrp;
	}

	/*
	 * clicking on order date
	 */
	public boolean clickonTopOrderDate() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_OrderDate")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("textdata_OrderDate"))).click();
		} catch (Exception e1) {
			throw new RuntimeException("Order date not clicked"+e1);
		}		
		return true;
	}
	
	/*
	 * verifying products
	 */
	public String products() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Products")), 5);
			product = world.driver.findElement(By.xpath(elementLib.getString("textdata_Products"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("products not matched"+e1);
		}		
		return product;
	}

	/*
	 * verifying order type
	 */
	public String orderType() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_OrderType")), 5);
			orderType = world.driver.findElement(By.xpath(elementLib.getString("textdata_OrderType"))).getText();
		} catch (Exception e1) {
			throw new RuntimeException("orderType not matched"+e1);
		}		
		return orderType;
	}
    
	
	public void validateOrderDetails() {
		
		//validate first name
		String FName = world.driver.findElement(By.xpath(elementLib.getString("textdata_FirstName"))).getText();
		if(!world.getCustomerDetails().get("FirstName").equalsIgnoreCase(FName)){
			throw new RuntimeException("FirstName name did not match");
		}
		//validate LastName
		String LName = world.driver.findElement(By.xpath(elementLib.getString("textdata_LastName"))).getText();
		if(!world.getCustomerDetails().get("LastName").equalsIgnoreCase(LName)){
			throw new RuntimeException("LastName did not match");
		}
		//validate orderNumber
		String orderNumber = world.driver.findElement(By.xpath(elementLib.getString("textdata_Order"))).getText();
		if(!world.getCustomerDetails().get("OrderNum").equalsIgnoreCase(orderNumber)){
			throw new RuntimeException("orderNumber did not match");
		}			
		
		//validate EmailID
		String EmailID = world.driver.findElement(By.xpath(elementLib.getString("textdata_Email"))).getText();
		if(!world.getCustomerDetails().get("Email").equalsIgnoreCase(EmailID)){
			throw new RuntimeException("EmailID did not match");
		}
		
		//validate Phone
		String Phone = world.driver.findElement(By.xpath(elementLib.getString("textdata_Phone"))).getText();
		if(!world.getCustomerDetails().get("Phone").equalsIgnoreCase(Phone)){
			throw new RuntimeException("Phone did not match");
		}
		
		String Amount = world.driver.findElement(By.xpath(elementLib.getString("textdata_Amount"))).getText();
		if(!world.getCustomerDetails().get("Total").equalsIgnoreCase(Amount)){
			throw new RuntimeException("Total amount did not match");
		}
		
	}
}




