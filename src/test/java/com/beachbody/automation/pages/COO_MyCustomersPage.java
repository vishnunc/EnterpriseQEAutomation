package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class COO_MyCustomersPage {
	private World world;
	String joinDateDescrp, firstNameDescrp, lastNameDescrp, customerIdDescrp, customerTypeDescrp, customerSourceDescrp,
			lastOrderDateDescrp, phoneNumberDescrp, emailDescrp, homeDirectDescrp, langPrefDescrp, street1Descrp,
			street2Descrp, cityDescrp, stateDescrp, postalcodeDescrp, countryDescrp;
	Boolean result;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib = ResourceBundle.getBundle("com.beachbody.automation.elementlib.COO_MyCustomersPage");

	public COO_MyCustomersPage(World world) {
		this.world = world;
	}

	/*
	 *clicking customers button
	 */
	public boolean clickMyCustomers() {
		try {
			System.out.println("The retrieved element is :" + elementLib.getString("link_MonitorMyBusiness"));
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_MonitorMyBusiness")),
					40);
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_MyCustomers")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("link_MonitorMyBusiness"))).click();
			world.driver.findElement(By.xpath(elementLib.getString("link_MyCustomers"))).click();
		} catch (Exception e1) {
			throw new RuntimeException("Customers button not clicked"+e1);
		}		
		return true;
	}
	
	/*
	 * validating customers page
	 */
	public boolean validateCustomersPage(String text) {
		boolean result = false;
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_Customer")), 5);
			if (world.driver.findElement(By.xpath(elementLib.getString("textdata_Customer"))).getText()
					.equalsIgnoreCase(text)) {
				return result;
			}
		} catch (Exception e1) {
			throw new RuntimeException("Customers paeg not opened"+e1);
		}		
		return result;
	}

	/*
	 * entering email address
	 */
	public boolean enterEmailAddress(String email) {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("input_Email") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("input_Email"))).sendKeys(email);
		}catch (Exception e1) {			
			throw new RuntimeException("email not entered"+e1);
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
	 * verifying join date
	 */
	public String joinDate() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("input_Email") , 20);
			joinDateDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_JoinDate"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("joindate not matched"+e1);
		}		
		return joinDateDescrp;
	}
	

	/*
	 * verifying first name
	 */
	public String firstName() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_FirstName") , 20);
			firstNameDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_FirstName"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("firstname not matched"+e1);
		}				
		return firstNameDescrp;
	}

	/*
	 * verifying last name
	 */
	public String lastName() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_LastName") , 20);
			lastNameDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_LastName"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("lastname not entered"+e1);
		}						
		return lastNameDescrp;
	}

	/*
	 * verifying customer Id
	 */
	public String customerId() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_CustomerID") , 20);
			customerIdDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerID"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("CustomerID not matched"+e1);
		}								
		return customerIdDescrp;
	}

	/*
	 * verifying customer type
	 */
	public String customerType() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_CustomerType") , 20);
			customerTypeDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerType")))
					.getText();
		}catch (Exception e1) {			
			throw new RuntimeException("customertype not matched"+e1);
		}							
		return customerTypeDescrp;
	}
	

	/*
	 * verifying customerSource
	 */
	public String customerSource() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_CustomerSource") , 20);
			customerSourceDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerSource")))
					.getText();
		}catch (Exception e1) {			
			throw new RuntimeException("customerSource not matched"+e1);
		}				
		return customerSourceDescrp;
	}


	/*
	 * verifying lastOrderDate 
	 */
	public String lastOrderDate() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_LastOrderDate") , 20);
			lastOrderDateDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_LastOrderDate")))
					.getText();
		}catch (Exception e1) {			
			throw new RuntimeException("lastOrderDate not matched"+e1);
		}				
		return lastOrderDateDescrp;
	}

	/*
	 * verifying email 
	 */
	public String verifyEmail() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_Email") , 20);
			emailDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Email"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("email not matched"+e1);
		}						
		return emailDescrp;
	}

	/*
	 * verifying phoneNumber 
	 */
	public String phoneNumber() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_Phone") , 20);
			phoneNumberDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Phone"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("phoneNumber not matched"+e1);
		}						
		return phoneNumberDescrp;
	}

	/*
	 * clicking join date button 
	 */
	public boolean clickonTopJoindate() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textdata_JoinDate")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("textdata_JoinDate"))).click();
		} catch (Exception e1) {
			throw new RuntimeException("join date not clicked"+e1);
		}		
		return true;
	}

	/*
	 * verifying homeDirect
	 */
	public String homeDirect() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_HomeDirect") , 20);
			homeDirectDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_HomeDirect"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("homeDirect not matched"+e1);
		}						
		return homeDirectDescrp;
	}

	/*
	 * verifying langPref
	 */
	public String langPref() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_LanguagePreference") , 20);
			langPrefDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_LanguagePreference")))
					.getText();
		}catch (Exception e1) {			
			throw new RuntimeException("language not matched"+e1);
		}						
		return langPrefDescrp;
	}

	/*
	 * verifying street1 address
	 */
	public String street1() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_Street1") , 20);
			street1Descrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Street1"))).getText();
		}catch (Exception e1) {			
			e1.printStackTrace();
			throw new RuntimeException("Street1 Address not matched"+e1);
		}
		return street1Descrp;					
		
	}

	/*
	 * verifying street2 address
	 */
	public String street2() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_Street2") , 20);
			street2Descrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Street2"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("Street2 Address not matched"+e1);
		}					
		return street2Descrp;
	}

	/*
	 * verifying city address
	 */
	public String city() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_City") , 20);
			cityDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_City"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("City Address not matched"+e1);
		}							
		return cityDescrp;
	}

	/*
	 * verifying state address
	 */
	public String state() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_State") , 20);
			stateDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_State"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("state Address not matched"+e1);
		}							
		return stateDescrp;
	}

	/*
	 * verifying postalCode address
	 */
	public String postalCode() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_PostalCode") , 20);
			postalcodeDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_PostalCode"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("postalCode not matched"+e1);
		}						
		return postalcodeDescrp;
	}

	/*
	 * verifying country address
	 */
	public String country() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textdata_Country") , 20);
			countryDescrp = world.driver.findElement(By.xpath(elementLib.getString("textdata_Country"))).getText();
		}catch (Exception e1) {			
			throw new RuntimeException("country not matched"+e1);
		}								
		return countryDescrp;
	}


	/*
	 * verifying customer details
	 */
	public boolean verifyCustomerDetails(String txt) {
		boolean ele = false;
		try {
			ele = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText()
					.contains(txt);
		} catch (Exception e1) {
			throw new RuntimeException("CustomerDetails not matched"+e1);
		}
		return ele;
	}
	

	public void validateCustomerDetails() {
		//Validate JoinDate name
		String JoinDate = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("JoinDate").equalsIgnoreCase(JoinDate)){
			throw new RuntimeException("JoinDate did not match");
		}
		//validate first name
		String fname = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("FirstName").equalsIgnoreCase(fname)){
			throw new RuntimeException("first name did not match");
		}
		//validate last name
		String lname = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("LastName").equalsIgnoreCase(lname)){
			throw new RuntimeException("Last name did not match");
		}
		//validate CustomerID
		String CustomerID = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("CustomerID").equalsIgnoreCase(CustomerID)){
			throw new RuntimeException("CustomerID did not match");
		}
		//validate CustomerType
		String CustomerType = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("CustomerType").equalsIgnoreCase(CustomerType)){
			throw new RuntimeException("CustomerType did not match");
		}			
		//validate CustomerSource
		String CustomerSource = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("CustomerSource").equalsIgnoreCase(CustomerSource)){
			throw new RuntimeException("CustomerSource name did not match");
		}
		//validate PhoneNumber name
		String PhoneNumber = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("PhoneNumber").equalsIgnoreCase(PhoneNumber)){
			throw new RuntimeException("PhoneNumber did not match");
		}
		//validate LastOrderDate
		String LastOrderDate = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("LastOrderDate").equalsIgnoreCase(LastOrderDate)){
			throw new RuntimeException("LastOrderDate did not match");
		}
		//validate Email
		String Email = world.driver.findElement(By.xpath(elementLib.getString("textdata_CustomerDetails"))).getText();
		if(!world.getCustomerDetails().get("Email").equalsIgnoreCase(Email)){
			throw new RuntimeException("Email did not match");
		}
	}

}