package com.beachbody.automation.stepdefs;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.ConfigFileReader;
import com.beachbody.automation.pages.BYD_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BYDStepDefs {

private World world;
	
	public BYDStepDefs(World world){
		this.world=world;
	}
	
	BYD_Page byd;
			
	@Given("I am on ByDesign Home Page")
	public void i_am_on_ByDesign_Home_Page() {
		//launching BYD in browser
		world.ieDriver.get(ConfigFileReader.getConfigFileReader().getBYDUrl());
		byd=new BYD_Page(this.world);	
	}

	@When("I enter {string} , {string} to login BYDesign")
	public void i_enter_to_login_BYDesign(String userName, String password) {
		//enter credentials to signin
		byd.enterUserName(userName);
		byd.enterPassword(password);
		byd.clickOnSignInButton();
	}

	@When("I click on customers option from search menu")
	public void i_click_on_customers_option_from_search_menu() {
		//navigating to customer search page
		world.ieDriver.get(ConfigFileReader.getConfigFileReader().getBYDSearchUrl());				
	}

	@When("I enter {string} and click on search")
	public void i_enter_and_click_on_search(String email) {
		//entering email and searching
	    byd.enterEmail(email);
	    byd.clickOnSearch();
	    byd.clickOnResultsTab();
	}
	
	@Then("I verify {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string}")
	public void i_verify(String custno, String name, String appdate, String customertype, String status, String rep, String repname, String searchfeild) {
		//Verifying customer details
		 byd.verifyCustomerDetails(custno);
		 byd.verifyCustomerDetails(name);		 
		 byd.verifyCustomerDetails(appdate);
		 byd.verifyCustomerDetails(customertype);
		 byd.verifyCustomerDetails(status);
		 byd.verifyCustomerDetails(rep);
		 byd.verifyCustomerDetails(repname);
		 byd.verifyCustomerDetails(searchfeild);
	}

	@When("I click on customer data")
	public void i_click_on_customer_data() {
		//Clicking on customer data
	    byd.clickOnCustomerData();	    
	}
	
	@Then("I verify {string} , {string} , {string}")
	public void i_verify(String billingadd, String email, String preferredlang) {
		//verifying other details of customer
		byd.verifyOtherCustomerDetails(billingadd);	    
	    byd.verifyOtherCustomerDetails(email);	    
	    byd.verifyOtherCustomerDetails(preferredlang);	 
	}

	@Then("I can see {string} , {string}  , {string} , {string} , {string} , {string} ,  {string} , {string}")
	public void i_can_see(String custno, String name, String appdate, String customertype, String status, String rep, String repname, String searchfield) {
		//Verifying order details
		byd.verifyOrderDetails(custno);
		byd.verifyOrderDetails(name);		
		byd.verifyOrderDetails(appdate);
		byd.verifyOrderDetails(customertype);		
		byd.verifyOrderDetails(status);
		byd.verifyOrderDetails(rep);
		byd.verifyOrderDetails(repname);
		byd.verifyOrderDetails(searchfield);
	}

	@Then("I verify {string}")
	public void i_verify(String billingadd) {
		//verifying billing address
		byd.verifyBillingAddress(billingadd);
	}
	
	@When("I click on order number")
	public void i_click_on_order_number() {
		//clicking on order number
	    byd.clickOnOrderNumber();
	}
	
		
	@Then("I verify order info {string},{string},{string},{string},{string},{string},{string} , {string} , {string}")
	public void i_verify_order_info(String orderShippingadd, String orderdate, String bonusdate, String item, String product, String qty, String zerooutshakeologyitems, String oracleordernum, String ebsordertype) {
		//verifying order information
		byd.verifyShippingOrderInfo(orderShippingadd);
	    byd.verifyOrderInfo(orderdate);
	    byd.verifyOrderInfo(bonusdate);
	    byd.verifyOrderInfo(item);
	    byd.verifyOrderInfo(product);
	    byd.verifyOrderInfo(qty);
	    byd.verifyMiscOrderInfo(zerooutshakeologyitems);
	    byd.verifyMiscOrderInfo(oracleordernum);
	    byd.verifyMiscOrderInfo(ebsordertype);
	}
	
}
