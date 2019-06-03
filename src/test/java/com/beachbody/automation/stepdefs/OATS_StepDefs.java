package com.beachbody.automation.stepdefs;

import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.ConfigFileReader;
import com.beachbody.automation.pages.TBB_AccountPage;
import com.beachbody.automation.pages.TBB_CheckOutPage;
import com.beachbody.automation.pages.TBB_HomePage;
import com.beachbody.automation.pages.TBB_PaymentPage;
import com.beachbody.automation.pages.TBB_ProductDetailspage;
import com.beachbody.automation.pages.TBB_ShippingPage;
import com.beachbody.automation.pages.TBB_ShoppingCartPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OATS_StepDefs {
	
	private World world;
	
	public OATS_StepDefs(World world){
		this.world=world;
	}
    
	@Then("I should be able to validate customer details in EBS")
	public void i_should_be_able_to_validate_customer_details_in_EBS() {
	    String output = world.getOatsDriver().runScript("EBS_ValidateCustomerDetails", null);
	    world.scenario.write(output);
	}

	@Then("I should be able to validate order details in EBS")
	public void i_should_be_able_to_validate_order_details_in_EBS() {
		String output = world.getOatsDriver().runScript("EBS_ValidateOrderDetails", null);
		world.scenario.write(output);
	}
}
