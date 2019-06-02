package com.beachbody.automation.stepdefs;

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
		world.driver.get(ConfigFileReader.getConfigFileReader().getOIMUrl());		
		oim=new OIM_Page(this.world);		
	}

	
	@When("I login with userName {string} and password {string}")
	public void i_login_with_userName_and_password(String userName, String password) {	
	   //entering username
	   oim.enterUserName(userName);
	   //entering password
	   oim.enterPassword(password);
	   //clicking on sign in button
	   oim.clickOnSignInButton();
	}


	@When("I click on manage")
	public void i_click_on_manage() {
		//clicking on manage button
		oim.clickManage();	   
	}

	@When("I click on users under administration")
	public void i_click_on_users_under_administration() {
		//clicking on users
		oim.clickUsers();	   
	}
			
	@When("I enter email {string} and click on search")
	public void i_enter_email_and_click_on_search(String email) {	
		//selecting 
		oim.selectSearchDropDown("4");
		//entering email
		oim.enterSearchText(email);		
		//clicking on search icon
		oim.clickOnSearchIcon();
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
