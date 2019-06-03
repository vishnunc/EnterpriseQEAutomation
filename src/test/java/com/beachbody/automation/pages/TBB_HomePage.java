package com.beachbody.automation.pages;

import java.util.ResourceBundle;

import javax.validation.constraints.AssertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.CommonUtilities;
import com.beachbody.automation.libraries.WebDriverUtilities;

public class TBB_HomePage {
	private World world;
	public WebDriverUtilities driverUtils = new WebDriverUtilities();
	public CommonUtilities Reusable = new CommonUtilities();
	ResourceBundle elementLib=ResourceBundle.getBundle("com.beachbody.automation.elementlib.TBB_HomePage");
	public TBB_HomePage(World world){
		this.world=world;
	}
	
	/*
	 * clicking on menu
	 */
	public boolean navigateToMenu(String menu){
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_"+menu)), 10);
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("link_"+menu)));
			Assert.assertTrue(e.isEnabled(), "navigate to menu button enabled to click");
			e.click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return true;
	}
	
	/*
	 * clicking on submenu
	 */
	public boolean navigateToSubMenu(String subMenu)
		{
		try{
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_"+subMenu)), 10);
			WebElement e=world.driver.findElement(By.xpath(elementLib.getString("link_"+subMenu)));
			Assert.assertTrue(e.isEnabled(), "navigate to submenu button enabled to click");
			e.click();
		}  catch(Exception el) {
			el.printStackTrace();
		}			
			return true;
	}
	
	/*
	 * closing the popup
	 */
	public boolean ClosingHomePagePopUp() throws RuntimeException {            
        try{
        	boolean popupExists = driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("popup_HomePage")), 30);
        	
            if(popupExists)
            {
            	WebElement popup=world.driver.findElement(By.xpath(elementLib.getString("popup_HomePage")));
            	popup.click();
            }
		}  catch(Exception el) {
    			throw new RuntimeException("The pop up is not clickable");
		}			            
        return true;
    }
	

	/*
	 * verifying home page
	 */
	public boolean VerifyHomePage()
	{
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_HomePageTitle")), 10);
			WebElement a=world.driver.findElement(By.xpath(elementLib.getString("text_HomePageTitle")));
			Assert.assertTrue(a.isDisplayed(), "Home page displayed succesffully");			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return true;
	}
	

	/*
	 * Selecting challenge pack
	 */
	public boolean selectChallengePack(String packName){
		String pack = elementLib.getString("placeholder_button_Pack").replaceAll("PLACEHOLDER", packName);
		try {	
			Thread.sleep(5000);
			driverUtils.waitforElementPresent(world.driver, By.xpath(pack), 120);
			WebElement e=world.driver.findElement(By.xpath(pack));
			e.click();
			Thread.sleep(5000);
		} catch (Exception e1) {
			throw new RuntimeException("Issue selecting challenge pack");
		}				
		return true;
	}
	
	/*
	 * Selecting challenge pack type
	 */
	public boolean selectChallengePackType(String packType) {
		String pack = elementLib.getString("placeholder_button_PackType").replaceAll("PLACEHOLDER", packType);
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(pack), 40);			
			WebElement e=world.driver.findElement(By.xpath(pack));
			Assert.assertTrue(e.isEnabled(), "challenge packType button Enabled");
			e.click();
		} catch (Exception e1) {
			throw new RuntimeException("Issue selecting challenge pack type");
		}		
		return true;
	}
	
	/*
	 * Selecting challenge pack
	 */
	public boolean selectFlavor(String flavor) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Flavor")), 5);
			Select selectFlav = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_Flavor"))));
			selectFlav.selectByValue(flavor);
		} catch (Exception e1) {
			throw new RuntimeException("Issue selecting flavor");
		}		
		return true;
	}

	/*
	 * Selecting packaging
	 */
	public boolean selectPackaging(String packaging) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Packaging")), 5);
			Select selectPack = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_Packaging"))));
			selectPack.selectByValue(packaging);
		} catch (Exception e1) {
			throw new RuntimeException("Issue selecting packaging");
		}		
		return true;
	}

	/*
	 * Selecting Recover
	 */
	public boolean selectRecover(String recover) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Recover")), 5);
			Select selectRecover = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_Recover"))));
			selectRecover.selectByValue(recover);
		} catch (Exception e1) {
			throw new RuntimeException("Issue selecting recover");
		}		
		return true;
	}

	
	/*
	 * Selecting RecoverPackaging
	 */
	public boolean selectRecoverPackaging(String recoverpackaging) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_RecoverPackaging")),
					5);
			Select selectPack = new Select(
					world.driver.findElement(By.xpath(elementLib.getString("select_RecoverPackaging"))));
			selectPack.selectByValue(recoverpackaging);
		} catch (Exception e1) {
			throw new RuntimeException("Issue selecting recover packaging");
		}		
		return true;
	}
	
	/*
	 * Selecting quantity
	 */	
	public boolean selectQuantity(String qty) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_Quantity")), 5);
			Select selectQty = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_Quantity"))));
			selectQty.selectByValue(qty);
		} catch (Exception e1) {
			throw new RuntimeException("Issue selecting quantity");
		}		
		return true;
	}

	/*
	 * clicking on add to cart button
	 */
	public boolean clickAddToCart() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_AddToCart")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("button_AddToCart"))).click();
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_AddToCart")), 5);
		} catch (Exception e1) {
			throw new RuntimeException("Issue clicking on add to cart");
		}		
		return true;
	}
	
	/*
	 * Clicking on continue shipping button
	 */
	public boolean continueToShipping() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("link_continueToShipping")),
					15);
			world.driver.findElement(By.xpath(elementLib.getString("link_continueToShipping"))).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return true;
	}
	
	/*
	 * Entering shipping address
	 */
	public boolean enterShippingAddress(String address, String city, String state,	String zip) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_address1")), 10);
			world.driver.findElement(By.xpath(elementLib.getString("input_address1"))).sendKeys(address);
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_city")), 10);			
			world.driver.findElement(By.xpath(elementLib.getString("input_city"))).sendKeys(city);
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_state")), 10);			
			Select selState = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_state"))));
			selState.selectByValue(state);
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_zip")), 10);			
			world.driver.findElement(By.xpath(elementLib.getString("input_zip"))).sendKeys(zip);
//			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_city")), 10);			
//			world.driver.findElement(By.xpath(elementLib.getString("input_city"))).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return true;
	}
	
	/*
	 * Verifying address
	 */
	public boolean validateQASAddress() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_qasNo")), 10);
			world.driver.findElement(By.xpath(elementLib.getString("button_qasNo"))).click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;				
	}

	/*
	 * Selecting shipping
	 */
	public boolean selectShipping(String ship) {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_shippingMethod")), 10);
			Select selShip = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_shippingMethod"))));
			selShip.selectByValue(ship);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;		
	}

	/*
	 * Clicking on continue button
	 */
	public boolean clickContinue() {
		try {
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Continue")), 15);
			world.driver.findElement(By.xpath(elementLib.getString("button_Continue"))).click();
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_Continue")), 15);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return true;		
	}  
	
		/*
		 * Entering CC details
		 */
		
		public boolean enterCCDetails(String ccfname, String cclname, String cardno, String ccmonth, String ccyear, String cvv) {
			
			String randomString = new CommonUtilities().generateRandomString();
			try {
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_ccfName")), 30);
				world.driver.findElement(By.xpath(elementLib.getString("input_ccfName"))).sendKeys(ccfname+randomString);
			
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_cclName")), 30);
				world.driver.findElement(By.xpath(elementLib.getString("input_cclName"))).sendKeys(cclname+randomString);			
			
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_ccNum")), 30);			
				world.driver.findElement(By.xpath(elementLib.getString("input_ccNum"))).sendKeys(cardno);
			
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_ccMonth")), 30);
						
				Select ccMonth = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_ccMonth"))));
				ccMonth.selectByValue(ccmonth);

				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_ccYear")), 30);			
			
				Select ccYear = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_ccYear"))));
				ccYear.selectByValue(ccyear);

				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_ccCVV")), 30);	
				world.driver.findElement(By.xpath(elementLib.getString("input_ccCVV"))).sendKeys(cvv);
				
			}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return true;
		}
		
		/*
		 * creating account
		 */

		public void createAccount(String rEmail, String password, String rpassword, String dob, String gender) {
			try {
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_reenterEmail")), 30);
				world.driver.findElement(By.xpath(elementLib.getString("input_reenterEmail"))).sendKeys(rEmail);
			
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_password")), 30);
				world.driver.findElement(By.xpath(elementLib.getString("input_password"))).sendKeys(password);
			
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("input_reenterpassword")), 30);
				world.driver.findElement(By.xpath(elementLib.getString("input_reenterpassword"))).sendKeys(rpassword);
		
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_birthMonth")), 30);
				// For DOB split by - and get all the details
				Select month = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_birthMonth"))));
				month.selectByValue(dob.split("-")[0]);
			
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_birthDay")), 30);
				Select day = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_birthDay"))));
				day.selectByValue(dob.split("-")[1]);
			
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("select_birthYear")), 30);
				Select year = new Select(world.driver.findElement(By.xpath(elementLib.getString("select_birthYear"))));
				year.selectByValue(dob.split("-")[2]);
						
			// Select the appropriate gender
			if (gender.equalsIgnoreCase("male")) {				
					driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("radio_genderMale")), 30);
					world.driver.findElement(By.xpath(elementLib.getString("radio_genderMale"))).click();						
			} else {				
					driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("radio_genderFemale")), 30);
					world.driver.findElement(By.xpath(elementLib.getString("radio_genderFemale"))).click();
				} 		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
			
		}

		// Selecting the coach option
		public boolean selectCoachOption(String option) {
			try {
			if (option.equalsIgnoreCase("no")) {				
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_coachNo")), 5);
				world.driver.findElement(By.xpath(elementLib.getString("button_coachNo"))).click();
			}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			return true;
		}

		// Select all the checkboxes
		public boolean acceptCheckboxes() {
			try {			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("checkbox_ContinuityDisclaimer")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("checkbox_ContinuityDisclaimer"))).click();			
			driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("checkbox_termsAndConditions")), 5);
			world.driver.findElement(By.xpath(elementLib.getString("checkbox_termsAndConditions"))).click();			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			return true;
		}
		
		/*
		 * clicking on no thanks button
		 */
		public boolean clickNoThanksButton() {
			try {
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_nothanks")), 5);
				world.driver.findElement(By.xpath(elementLib.getString("button_nothanks"))).click();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			return true;
		}
		
		// Submit the order and wait for process to finish
		public boolean submitOrder() {
			try {
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("button_submitOrder")), 30);
				world.driver.findElement(By.xpath(elementLib.getString("button_submitOrder"))).click();
				driverUtils.waitforElementPresent(world.driver, By.xpath(elementLib.getString("text_orderNumber")), 120);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			return true;
		}
			
			/*
			 * verifying element presence
			 */
		public boolean verifyElementPresence(String strXpath,int seconds) {
			try {
				driverUtils.waitforElementPresent(world.driver, By.xpath(strXpath), seconds);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return true;
		}
	}


