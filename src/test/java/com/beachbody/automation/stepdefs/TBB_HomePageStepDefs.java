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

public class TBB_HomePageStepDefs {
	
	private World world;
	
	public TBB_HomePageStepDefs(World world){
		this.world=world;
	}
    TBB_HomePage tbbHome;
    TBB_ProductDetailspage tbbproductDetailsPage;
    TBB_ShoppingCartPage tbbShoppingCartPage;
    TBB_CheckOutPage tbbCheckoutPage;
    TBB_ShippingPage tbbShippingPage;
    TBB_PaymentPage tbbPaymentPage;
    TBB_AccountPage tbbAccountPage;
    
    @Given("I am on TBB home page")
    public void i_am_on_TBB_home_page() {       
    	//launching tbb on browser
        world.driver.get(ConfigFileReader.getConfigFileReader().getTBBUrl());
        //maximizing the browser
        world.driver.manage().window().maximize();
        tbbHome=new TBB_HomePage(this.world);
        //closing the popup on home page
        tbbHome.ClosingHomePagePopUp();
        //veifying home page
        tbbHome.VerifyHomePage();
    }

	@When("I select Challenge pack {string}")
	public void i_select_Challenge_pack(String pack) {
		//navigating to menu
		tbbHome.navigateToMenu("Shop");
		//navigating to sub menu
	    tbbHome.navigateToSubMenu("ChallengePacks");
	    //selecting a pack
	    tbbHome.selectChallengePack(pack);
	    
	}

	@When("I select {string} for buying")
	public void i_select_for_buying(String packType)     {
		//selecting pack type 
		tbbHome.selectChallengePackType(packType);
	}

	@When("I add to cart with {string},{string},{string},{string} and {string} options")
	   public void i_add_to_cart_with_and_options(String flavor, String packaging, String recover,String RPacking, String qty)     {
	       tbbproductDetailsPage=new TBB_ProductDetailspage(this.world);
	       //validating PDP Page on product details page
	       tbbproductDetailsPage.verifyPDPPage();
	       //Selecting flavour on product details page
	       tbbproductDetailsPage.selectFlavor(flavor);
	       //Selecting Packaging on product details page
	       tbbproductDetailsPage.selectPackaging(packaging);
	       //selecting recover on product details page
	       tbbproductDetailsPage.selectRecover(recover);
	       //selecting recovering packaging
	       //tbbproductDetailsPage.RecoverPackaging(RPacking);
	       //selecting quantity on product details page
	       tbbproductDetailsPage.selectQuantity(qty);
	       //Clicking Add to cart button
	       tbbproductDetailsPage.clickAddToCart();
	   }

	@When("I view my cart")
	public void i_view_my_cart() {
		//clicking view cart button
		tbbproductDetailsPage.clickViewCart();
	}
	@Then("I should be able to validate Title, Qty, Price and Order summary")
	public void i_should_be_able_to_validate_Title_Qty_Price_and_Order_summary() throws Exception {			
		    tbbShoppingCartPage=new TBB_ShoppingCartPage(this.world);
		    //validating title on shopping cart page
		    tbbShoppingCartPage.validateTitle();
		    //validating Quantity on shopping cart page
		    tbbShoppingCartPage.validateQuantity();
		    //validating Price on shopping cart page
		    tbbShoppingCartPage.validatePrice();
		    //validating Summary on shopping cart page
		    tbbShoppingCartPage.validateSummary();
	}

	@Then("I should be able to validate {string} and {string}")
	public void i_should_be_able_to_validate_and(String subtotal, String estimatedtotal) {
	    //validating subtotal and estimated total
	    tbbShoppingCartPage.validateSubTotal_EstimatedTotal(subtotal,estimatedtotal);
		
	}

	@When("I checkout")
	public void i_checkout() {
		//clicking on checkout button
	    tbbShoppingCartPage.clickCheckout();
	}

	@Then("I should be able to provide email to begin checkout")
	public void i_should_be_able_to_provide_to_begin_checkout() {
		tbbCheckoutPage=new TBB_CheckOutPage(this.world);
		//providing random email and clicking on begin checkout button
	    tbbCheckoutPage.beginCheckout();
	}

	@When("I skip offers to continue shopping")
	public void i_skip_offers_to_continue_shopping() {
		tbbShippingPage=new TBB_ShippingPage(this.world);
		//clicking on continue shipping
	    tbbShippingPage.continueToShipping();
	}

	@When("I enter my shipping information {string},{string},{string},{string},{string},{string},{string}")
	public void i_enter_my_shipping_information(String fname, String lname, String phone, String address, String city, String state, String zip) {
	    //entering shipping details
		tbbShippingPage.enterShippingInfo(fname,lname,phone,address,city,state,zip);
	}

	@When("validate the QAS address")
	public void validate_the_QAS_address() {
		//validating Address
	    tbbShippingPage.validateQASAddress();
	}

	@When("I select shipping option as {string} to continue")
	public void i_select_shipping_option_as_to_continue(String ship) {
	    //Selecting shipping
		tbbShippingPage.selectShipping(ship);
	    //clicking on continue button
		tbbShippingPage.clickContinue();
	}

	@Then("shipping & handling and taxes should be updated")
	public void shipping_handling_and_taxes_should_be_updated() {
	    //Validating shipping handling taxes
		tbbShippingPage.ValidateShippingHandlingTaxes();
	}

	@Then("when I enter payment details to continue")
	public void when_I_enter_payment_details_to_continue() {
		tbbPaymentPage = new TBB_PaymentPage(this.world);
	    //entering CC details	    
		tbbPaymentPage.enterCCDetails();
		//clicking on continue button
		tbbPaymentPage.clickccContinue();
	}

	@Then("I create an account with {string},{string},{string},{string}")
	public void i_create_an_account_with(String rEmail, String password, String dob,String gender) {
		tbbAccountPage=new TBB_AccountPage(this.world);
		//creating account
	    tbbAccountPage.createAccount(rEmail,password,password,dob,gender);	    
	}

	@Then("I select {string} as option for coach")
	public void i_select_as_option_for_coach(String option) {
	    tbbAccountPage.selectCoachOption(option);
	    //selecting check box
	    tbbAccountPage.acceptCheckboxes();
	}

	@Then("I submit order")
	public void i_submit_order() {
	    //clicking on submit button
		tbbAccountPage.submitOrder();
	}

	@Then("I should be able to see a successful order placement with an Order ID")
	public void i_should_be_able_to_see_a_successful_order_placement_with_an_Order_ID() {
		//Saving order number
		tbbAccountPage.saveOrderNumber();
	}

}
