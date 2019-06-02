package com.beachbody.automation.stepdefs;

import org.testng.Assert;
import com.beachbody.automation.common.World;
import com.beachbody.automation.libraries.ConfigFileReader;
import com.beachbody.automation.pages.COO_RegistrationPage;
import com.beachbody.automation.pages.TBB_HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COO_CoachRegistrationStepDefs {

	private World world;

	public COO_CoachRegistrationStepDefs(World world) {
		this.world = world;
	}

	COO_RegistrationPage cooRegistration;
	TBB_HomePage tbbHome;

	@Given("I am on COO home page")
	public void i_am_on_COO_home_page() {		
		world.driver.get(ConfigFileReader.getConfigFileReader().getCOOUrl());
		world.driver.manage().window().maximize();
		cooRegistration = new COO_RegistrationPage(this.world);
		tbbHome = new TBB_HomePage(this.world);
	}

	@When("I click on Become Coach Link")
	public void i_click_on_Become_Coach_Link() {
		// clicking on signup link
		cooRegistration.clickSignUpLink();
	}

	@Then("signup page should be displayed")
	public void signup_page_should_be_displayed() {
		Assert.assertTrue(cooRegistration.verifySignUpStatus("in-progress"));
	}
	
	@Then("I enter my information {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void i_enter_my_information(String country, String language,
			String pswd, String phone, String month, String day, String year, String govtid, String sign) {
		cooRegistration.fillInfo(country, language,pswd, phone, month, day, year, govtid, sign);
		cooRegistration.clickNoCoachButton();
		cooRegistration.clickDisclaimerCheckBox();
		cooRegistration.clickTermsCheckBox();
	}

	@When("I click on Continue")
	public void i_click_on_Continue() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		cooRegistration.clickContinueButton();
	}

	@Then("Coach registered sucessfully and navigated to challenge pack step")
	public void coach_registered_sucessfully_and_navigated_to_challenge_pack_step() {
		Assert.assertTrue(cooRegistration.verifySignUpStatus("finished"));
		Assert.assertTrue(cooRegistration.verifyChallengePackStatus("in-progress"));
	}

	@When("I selects challenge pack {string}")
	public void i_selects_challenge_pack(String pack) {
		tbbHome.selectChallengePack(pack);
	}

	@When("I selects {string} for buying")
	public void i_selects_for_buying(String packType) throws InterruptedException {
		//
		tbbHome.selectChallengePackType(packType);
	}

	@When("I fill product details with {string},{string},{string} , {string} and {string} options")
	public void i_fill_product_details_with_and_options(String flavor, String packaging, String recover,
			String recovpackaging, String qty) {
		tbbHome.selectFlavor(flavor);
		tbbHome.selectPackaging(packaging);
		tbbHome.selectRecover(recover);
		tbbHome.selectRecoverPackaging(recovpackaging);
		tbbHome.selectQuantity(qty);
	}

	@When("I click on select and continue to cart")
	public void i_click_on_select_and_continue_to_cart() {
		// Write code here that turns the phrase above into concrete actions
		tbbHome.clickAddToCart();

	}

	@Then("Navigated to topsellers step")
	public void navigated_to_topsellers_step() {
		Assert.assertTrue(cooRegistration.verifyChallengePackStatus("finished"));
		Assert.assertTrue(cooRegistration.verifyTopSellersStatus("in-progress"));
	}

	@When("I click on no thanks complete my enrollment button")
	public void i_click_on_no_thanks_complete_my_enrollment_button() {
		tbbHome.clickNoThanksButton();
	}
	
	@When("I click on continue to shopping")
	public void i_click_on_continue_to_shopping() {
	    tbbHome.continueToShipping();
	}


	@Then("I enter my shipping information {string},{string},{string},{string}")
	public void i_enter_my_shipping_information(String address, String city, String state, String zip) {
		tbbHome.enterShippingAddress(address, city, state, zip);
	}
	
	@Then("I validates the QAS address")
	public void i_validates_the_QAS_address() {
		tbbHome.validateQASAddress();
	}

	@Then("I select shipping option {string} and click on continue")
	public void i_select_shipping_option_and_click_on_continue(String shipping) {
		tbbHome.selectShipping(shipping);
		tbbHome.clickContinue();
	}
	
	@Then("I enter payment information {string} , {string} , {string} , {string} , {string} , {string}")
	public void i_enter_payment_information(String ccfname, String cclname, String cardno, String ccmonth, String ccyear, String cvv) {
	   tbbHome.enterCCDetails(ccfname, cclname, cardno, ccmonth, ccyear, cvv);
	}

	@Then("I click on submit")
	public void i_click_on_submit() {
		tbbHome.submitOrder();
	   
	}


}
