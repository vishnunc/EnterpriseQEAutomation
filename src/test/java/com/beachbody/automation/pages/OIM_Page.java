
package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.CommonUtilities;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class OIM_Page {

	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.OIMPages");
	CommonUtilities reusableMethods = new CommonUtilities();
	public OIM_Page(World world){
		this.world=world;
	}
	
	//LoginPage		
	/*
	 * entering username
	 */
	public boolean enterUserName(String userName) {	
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textbox_username") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("textbox_username"))).sendKeys(userName);	
		}catch (Exception e1) {			
			throw new RuntimeException("username not entered"+e1);
		}
		return true;
	}
	
	/*
	 * entering password
	 */
	public boolean enterPassword(String password) {	
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textbox_password") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("textbox_password"))).sendKeys(password);	
		}catch (Exception e1) {
			throw new RuntimeException("password not entered"+e1);
		}		
			return true;	
	}
	
	/*
	 * clicking on signIn button
	 */
	public boolean clickOnSignInButton() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("button_signin") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("button_signin"))).click();
		}catch (Exception e1) {
			throw new RuntimeException("signin button not clicked"+e1);
		}
			return true;				
	}
	
	/*
	 * validating IdentifyServiceConsole
	 */	
	public boolean verifyIdentifyServiceConsole(String txt) {
		boolean result = false;		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("text_identityselfservice") , 20);		
		if(txt.equalsIgnoreCase(world.driver.findElement(By.xpath(elementLib.getString("text_identityselfservice"))).getText())) {
			result = true;		
		}
			Assert.assertTrue(result,txt+" dosent match");
		}catch (Exception e1) {
			throw new RuntimeException("IdentifyServiceConsole details not mached"+e1);
		}				
		return result;	
	}

	
	//HomePage		
	/*
	 * clicking on manage button 
	 */	
	public boolean clickManage() {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("button_manage") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("button_manage"))).click();
		}catch (Exception e1) {
			throw new RuntimeException("Manage button not clicked"+e1);
		}		
		return true;
	}
 
	/*
	 * clicking on users
	 */	
	public boolean clickUsers() {
		try {			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_users")), 20);
			world.driver.findElement(By.xpath(elementLib.getString("link_users"))).click();
		} catch (Exception e1) {
			throw new RuntimeException("Users button not clicked"+e1);
		}		
		return true;	
	}	
		
	/*
	 * verifying User Information
	 */	
	public boolean verifyMyInformation(String txt) {		
		boolean result = false;
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("text_myinformation") , 20);
			if(txt.equalsIgnoreCase(world.driver.findElement(By.xpath(elementLib.getString("text_myinformation"))).getText())) { 
			System.out.println("Verifying My Information is displayed in the Home Page"); 
			Assert.assertTrue(result,txt + " dosent match");
			result = true;
			}
		}catch (Exception e1) {
			throw new RuntimeException("My Information details not mached"+e1);
		}		
		return true;
	}
	
	//OIMUSersPage	
	/*
	 * entering email
	 */	
	public void enterSearchText(String searchTxt) {        
        try {
        	driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textbox_search") , 20);
            driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("textbox_search")), 20);
            Thread.sleep(20000);            
        	//driverUtils.waitForPresenceOfElement(world.driver, By.xpath(elementLib.getString("textbox_search")), 20000);        	
            world.driver.findElement(By.xpath(elementLib.getString("textbox_search"))).clear();            
            Thread.sleep(2000);
            //driverUtils.waitForPresenceOfElement(world.driver, By.xpath(elementLib.getString("textbox_search")), 20000);            
            world.driver.findElement(By.xpath(elementLib.getString("textbox_search"))).sendKeys(searchTxt);
        } catch (Exception e1) {
        	throw new RuntimeException("Text not entered"+e1);            
        }            
    }
 
	/*
	 * clicking on search Icon
	 */	
	public boolean clickOnSearchIcon() {
		try {			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("image_search")), 10);
			world.driver.findElement(By.xpath(elementLib.getString("image_search"))).click();	
		} catch (Exception e1) {
			throw new RuntimeException("Search button not clicked"+e1);
		}						
		return true;	
	}
	
	/*
	 * clicking on user login button
	 */	
	public boolean clickOnUserLogin() {
		try {			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_userLogin")), 10);
			world.driver.findElement(By.xpath(elementLib.getString("text_userLogin"))).click();	
		} catch (Exception e1) {
			throw new RuntimeException("login not clicked"+e1);
		}				
		return true;
	}
	
	/*
	 * selecting a value from dropdown
	 */	
	public boolean selectSearchDropDown(String text) {
		try {			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("dropdown_search")), 10);
			Select selSearch = new Select(world.driver.findElement(By.xpath(elementLib.getString("dropdown_search"))));
			selSearch.selectByValue(text);
		} catch (Exception e1) {
			throw new RuntimeException("Dropdown not selected"+e1);
		}			
		return true;
	}
	
	/*
	 * verifying first name
	 */	
	public boolean verifyFirstName(String fname) {					
		boolean result = false;
		try {			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_firstName")), 20);
			result= world.driver.findElement(By.xpath(elementLib.getString("text_firstName"))).getText().contains(fname);
			Assert.assertTrue(result, fname + " doesent match");
		}		
		catch(Exception e1) {
			throw new RuntimeException("first name not matched"+e1);
		}			
		return result;
	}
	
	/*
	 * verifying last name
	 */	
	
	public boolean verifyLastName(String lname) {				
		boolean result = false;
		try {			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_lastName")), 10);
			result= world.driver.findElement(By.xpath(elementLib.getString("text_lastName"))).getText().contains(lname);
			Assert.assertTrue(result, lname + " doesent match");
		}		
		catch(Exception e1) {
			throw new RuntimeException("lastname details not mached"+e1);
		}			
		return true;		
	}
	
	/*
	 * clicking on user login button
	 */	
	public void clickUserLogin() {		
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("text_userLogin") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("text_userLogin"))).click();		
		}catch(Exception e1) {
			throw new RuntimeException("login not clicked"+e1);
		}			
	}	
		
	/*
	 * verifying users page
	 */	
	public boolean verifyUsersPage(String txt) {	
		boolean result = false; 
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("text_userRow") , 20);
			if(txt.equalsIgnoreCase(world.driver.findElement(By.xpath(elementLib.getString("text_userRow"))).getText())) { 
				result = true;
			System.out.println("Verifying My Information is displayed in the Home Page");
			Assert.assertTrue(result,txt + "dosent exist");		}
		}catch(Exception e1) {
			throw new RuntimeException("Users page not displayed"+e1);
		}					
		return true;
	}

	
	//UserDetailsPage	
	/*
	 * verifying telephone number
	 */	
	public boolean verifyTelephoneNumber(String number) {		
		boolean result = false;
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("text_contactInformationTelephone") , 20);
			String tel = world.driver.findElement(By.xpath(elementLib.getString("text_contactInformationTelephone"))).getText();
			if(tel.trim().contains(number.trim())) { 
			System.out.println("Verifying My Information is displayed in the Home Page");
			Assert.assertTrue(result,number + "dosent exist");
			result = true;
			}
		}catch(Exception e1) {
			throw new RuntimeException("telephone no details not mached"+e1);
		}					
		return result;
	}
			
	/*
	 * verify preference language
	 */	
	public boolean verifyPreferencesLocale(String txt) {   		
        boolean result = false;
        try {
        	driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("text_preferencesLocale") , 20);
        	String locale = world.driver.findElement(By.xpath(elementLib.getString("text_preferencesLocale"))).getText();
        if((locale).trim().contains(txt.trim())) {
            System.out.println("Verifying My Information is displayed in the Home Page");  
            Assert.assertTrue(result,txt + "dosent exist");
            result = true;    
        }
        }catch(Exception e1) {
        	throw new RuntimeException("language details not mached"+e1);         
        }        	
        return result;        
    }
	
	/*
	 * verifying other attributes
	 */	
	public boolean verifyOtherAttributes(String txt) {           
		boolean ele=false;
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("text_otherAttributes") , 20);
			String temp = world.driver.findElement(By.xpath(elementLib.getString("text_otherAttributes"))).getText();			
			ele = temp.trim().contains(txt.trim());  
			Assert.assertTrue(ele,txt + " dosent match");
		}catch(Exception e1) {
			throw new RuntimeException("attributes not mached"+e1);
		}        	
		return ele;
    }

	public boolean login(String username, String password) {
		try {
			driverUtils.verifyElementPresence(driverUtils, world.driver,elementLib.getString("textbox_username") , 20);
			world.driver.findElement(By.xpath(elementLib.getString("textbox_username"))).sendKeys(username);	
			world.driver.findElement(By.xpath(elementLib.getString("textbox_password"))).sendKeys(password);
			world.driver.findElement(By.xpath(elementLib.getString("button_signin"))).click();
		}catch (Exception e1) {
			throw new RuntimeException("Login not successful "+e1);
		}
			return true;				
		
	}


}