package com.beachbody.automation.stepdefs;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

import org.testng.Assert;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.ConfigFileReader;
import com.beachbody.automation.pages.OIM_Page;
import com.beachbody.automation.pages.TBB_HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OIM_StepDefs {
	

	private World world;
	
	public OIM_StepDefs(World world){
		this.world=world;
	}
	
	OIM_Page oim;
	@Given("I am on OIM home page")
	public void i_am_on_OIM_home_page() {		
		//launching OIM on browser
				
	}

	@Given("I am logged in to OIM")
	public void i_am_logged_in_to_OIM() throws MalformedURLException {
		File file = new File("config");
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle configLib=ResourceBundle.getBundle("config",Locale.getDefault(),loader);
		world.driver.get(ConfigFileReader.getConfigFileReader().getOIMUrl());		
		oim=new OIM_Page(this.world);
		oim.login(configLib.getString("OIM_Username"),configLib.getString("OIM_Password"));
	}

	@When("I search for user with email in OIM")
	public void i_search_for_user_with_in_OIM() {
		oim.clickManage();
		oim.clickUsers();
		//selecting 
		oim.selectSearchDropDown("4");
		//entering email
		oim.enterSearchText(world.getCustomerDetails().get("Email"));		
		//clicking on search icon
		oim.clickOnSearchIcon();
		//Click on user link to go to details page
		oim.clickOnUserLogin();
	}

	@Then("I should be able to validate the customer details in OIM")
	public void i_should_be_able_to_validate_the_customer_details_in_OIM() {
	   oim.validateCustomerDetails();
	}
	
	
	@Then("I verify {string} and {string} should be displayed")
	public void i_verify_and_should_be_displayed(String FirstName, String LastName) {
		//validating first name and last name
	   oim.verifyFirstName(FirstName);
	   oim.verifyLastName(LastName);	   
	}

	@When("I click on user login link")
	public void i_click_on_user_login_link() {
		//clicking on user login
	   oim.clickOnUserLogin();
	}

	@Then("I verify {string} should be displayed under contact information")
	public void i_verify_should_be_displayed_under_contact_information(String telephoneNumber) {
		//verifying telephone number
	   oim.verifyTelephoneNumber(telephoneNumber);
	}

	@Then("I verify {string} should be displayed under preferences")
	public void i_verify_should_be_displayed_under_preferences(String locale) {
		//verifying language
	 oim.verifyPreferencesLocale(locale);
	}

	@Then("I verify {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string} should be displayed under other attributes")
	public void i_verify_and_should_be_displayed_under_other_attributes(String Username, String DOB, String Gender, String CustomerType, String GNCCustomerID, String LeadWheelType, String BillingAddress, String ShippingAddress, String IsLiferayProvisioned, String IsEBSProvisioned, String IsBYDESIGNProvisioned) {
		//validating attributes
	   oim.verifyOtherAttributes(Username);
	   oim.verifyOtherAttributes(DOB);
	   oim.verifyOtherAttributes(Gender);
	   oim.verifyOtherAttributes(CustomerType);
	   oim.verifyOtherAttributes(GNCCustomerID);
	   oim.verifyOtherAttributes(LeadWheelType);
	   oim.verifyOtherAttributes(BillingAddress);
	   oim.verifyOtherAttributes(ShippingAddress);
	   oim.verifyOtherAttributes(IsLiferayProvisioned);
	   oim.verifyOtherAttributes(IsEBSProvisioned);
	   oim.verifyOtherAttributes(IsBYDESIGNProvisioned);	   
	     	   
	}

}
