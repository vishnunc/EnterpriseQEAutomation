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
import com.beachbody.automation.pages.COO_LoginPage;
import com.beachbody.automation.pages.COO_MyCustomersPage;
import com.beachbody.automation.pages.COO_OrdersPage;
import com.beachbody.automation.pages.OIM_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COO_CustomerAndOrderDetailsDefs {

	private World world;

	public COO_CustomerAndOrderDetailsDefs(World world) {
		this.world = world;
	}

	COO_LoginPage cooLogin;
	COO_MyCustomersPage coomycustomerspage;
	COO_OrdersPage cooorderspage;

	@Given("Launch COO Application")
	public void launch_COO_Application() {
		//launching coo on browser
		world.driver.get(ConfigFileReader.getConfigFileReader().getCOOUrl());		
		world.driver.manage().window().maximize();
		cooLogin = new COO_LoginPage(this.world);
	}

	@When("Enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) {
		// Entering credentials
		cooLogin.enterlogin(username, password);
	}

	@When("Click on Sign In button")
	public void click_on_Sign_In_button() {
		//clicking on sign in button
		cooLogin.clickonSignbutton();
	}

	@When("User Clicks on My Customers under Monitor My Business")
	public void user_Clicks_on_My_Customers_under_Monitor_My_Business() {		
		coomycustomerspage = new COO_MyCustomersPage(world);
		//clicking on my customers button
		coomycustomerspage.clickMyCustomers();
	}

	@Then("Customer Report page should be displayed")
	public void customer_Report_page_should_be_displayed() {
		//veifying customers page
		coomycustomerspage.validateCustomersPage("Customers");
	}

	@When("User Enters Email address {string} and click on search")
	public void user_Enters_Email_address_and_click_on_search(String EmailAddress) {
		//entering email address
		coomycustomerspage.enterEmailAddress(EmailAddress);
		//clicking on search button
		coomycustomerspage.clickSearch();
	}

	@Then("Validate {string}, {string}, {string}, {string}, {string}, {string} , {string}, {string} , {string}")
	public void validate(String JoinDate, String FirstName, String LastName, String CustomerID, String CustomerType,
			String CustomerSource, String PhoneNumber, String LastOrderDate, String Email) {
		
		String date = coomycustomerspage.joinDate();
		//validating join date
		Assert.assertEquals(date, JoinDate, "JoinDate not matched");
		String fname = coomycustomerspage.firstName();
		//validating first name
		Assert.assertEquals(fname,FirstName, "FirstName not matched");
		String lname = coomycustomerspage.lastName();
		//validating last name
		Assert.assertEquals(lname, LastName, "LastName not matched");
		String cusid = coomycustomerspage.customerId();
		//validating customer Id
		Assert.assertEquals(cusid, CustomerID, "CustomerID not matched");
		String custype = coomycustomerspage.customerType();
		//validating customer type
		Assert.assertEquals(custype, CustomerType, "CustomerType not matched");
		String cussource = coomycustomerspage.customerSource();
		//validating customer source
		Assert.assertEquals(cussource, CustomerSource, "CustomerSource not matched");
		String phoneno = coomycustomerspage.phoneNumber();
		//validating phone number
		Assert.assertEquals(phoneno, PhoneNumber, "PhoneNumber not matched");
		String Lastorder = coomycustomerspage.lastOrderDate();
		//validating lastorder
		Assert.assertEquals(Lastorder, LastOrderDate, "LastOrderDate not matched");
		String email = coomycustomerspage.verifyEmail();
		//validating email
		Assert.assertEquals(email, Email, "Email not matched");

	}

	@When("User Clicks on the top arrow near join date field")
	public void user_Clicks_on_the_top_arrow_near_join_date_field() {
		//clicking on top join date
		coomycustomerspage.clickonTopJoindate();
	}

	@Then("Validate {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string}")
	public void validate(String HomeDirect, String LanguagePreference, String Street1, String Street2, String City,
			String State, String PostalCode, String Country) {
		String homedirec = coomycustomerspage.homeDirect();
		//validating home direct
		Assert.assertEquals(homedirec, HomeDirect, "HomeDirect not matched");
		String langpre = coomycustomerspage.langPref();
		//validating Language Preference
		Assert.assertEquals(langpre, LanguagePreference, "LanguagePreference not matched");
		String street1 = coomycustomerspage.street1();
		//validating Street1 address
		Assert.assertEquals(street1, Street1, "Street1 not matched");
		String street2 = coomycustomerspage.street2();
		//validating Street2 address
		Assert.assertEquals(street2, Street2, "Street2 not matched");
		String city = coomycustomerspage.city();
		//validating city
		Assert.assertEquals(city, City, "City not matched");
		String state = coomycustomerspage.state();
		//validating state
		Assert.assertEquals(state, State, "State not matched");
		String pcode = coomycustomerspage.postalCode();
		//validating PostalCode
		Assert.assertEquals(pcode, PostalCode, "PostalCode not matched");
		String country = coomycustomerspage.country();
		//validating Country
		Assert.assertEquals(country, Country, "Country not matched");
	}
	
	@When("User Clicks on My Personal & Customer Orders under Monitor My Business")
	public void user_Clicks_on_My_Personal_Customer_Orders_under_Monitor_My_Business() {
		cooorderspage = new COO_OrdersPage(this.world);
		//clicking on my personal and customers orders button
		cooorderspage.clickMyPersonalAndCustomerOrders();
	}

	@Then("Order Report Page should be displayed")
	public void order_Report_Page_should_be_displayed() {
		//verifying order report page
		cooorderspage.validateReportPage("Orders");
	    
	}

	@When("User Enters orderNo {string} and Clicks on Search")
	public void user_Enters_orderNo_and_Clicks_on_Search(String orderNumber) {
		//entering order number
		cooorderspage.enterOrderNumber(orderNumber);
		//clicking on search button
		cooorderspage.clickSearch();
	}

	@Then("Validate orderDate as {string} customerId as {string} firstName as {string} lastName as {string} orderNumber as {string} homeDirect as {string} emailId as {string} amont as {string} phone as {string} status as {string} volume as {string} trackingNumber as {string}")
	public void validate(String OrderDate, String CustomerID, String FName, String LName, String OrderNo, String HomeDirect, String EmailID, String Amount, String Phone, String Status, String Volume, String TrackingNumber) {
		String date = cooorderspage.Orderdate();
		//validating order date
		Assert.assertEquals(date, OrderDate, "OrderDate not matched");
		String cusId = cooorderspage.CustomerId();
		//validating customer id
		Assert.assertEquals(cusId, CustomerID, "CustomerID not matched");
		String fname = cooorderspage.FirstName();
		//validating first name
		Assert.assertEquals(fname,FName, "FirstName not matched");
		String lname = cooorderspage.lastName();
		//validating last name
		Assert.assertEquals(lname, LName, "LastName not matched");
		String orderno = cooorderspage.ordernumber();
		//validating order no
		Assert.assertEquals(orderno, OrderNo, "OrderNumber not matched");
		String homedirec = cooorderspage.homedirect();
		//validating home direct
		Assert.assertEquals(homedirec, HomeDirect, "HomeDirec not matched");
		String emailid = cooorderspage.verifyEmail();
		//validating email
		Assert.assertEquals(emailid, EmailID, "EmailID not matched");
		String amount = cooorderspage.Amount();
		//validating amount
		Assert.assertEquals(amount, Amount, "Amount not matched");
		String phone = cooorderspage.phonenumber();
		//validating phone number
		Assert.assertEquals(phone, Phone, "Phoneno not matched");
		String staus = cooorderspage.Status();
		//validating status
		Assert.assertEquals(staus, Status, " Status not matched");
		String volume = cooorderspage.volume();
		//validating volume
		Assert.assertEquals(volume, Volume, "Volume not matched");
		String trackingno = cooorderspage.TrackingNumber();
		//validating tracking number
		Assert.assertEquals(trackingno, TrackingNumber, " TrackingNumber not matched");
	}

	@When("User Clicks on the top arrow near order date field")
	public void user_Clicks_on_the_top_arrow_near_order_date_field() {
		//clicking on top order date
		cooorderspage.clickonTopOrderDate();
	}

	@Then("Validate productName as {string} orderType as {string}")
	public void validate_productName_as_orderType_as(String ProductName, String OrderType) {		
		String products = cooorderspage.products();
		//validating product name
		Assert.assertEquals(products, ProductName, "Productname not matched");
		String ordertype = cooorderspage.orderType();
		//validating order type
		Assert.assertEquals(ordertype, OrderType, "OrderType not matched");		
	}
	
	@Given("I am logged in to COO")
	public void i_am_logged_in_to_COO() throws MalformedURLException {
		File file = new File("config");
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle configLib=ResourceBundle.getBundle("config",Locale.getDefault(),loader);
		world.driver.get(configLib.getString("COO_QA3_URL"));		
		cooLogin=new COO_LoginPage(this.world);
		cooLogin.login(configLib.getString("COO_Username"),configLib.getString("COO_Password"));
	}

	@When("I search for the customer with email in COO")
	public void i_search_for_the_customer_with_email_in_COO() {
		coomycustomerspage = new COO_MyCustomersPage(world);
		//clicking on my customers button
		coomycustomerspage.clickMyCustomers();
		//entering email address
		coomycustomerspage.enterEmailAddress(world.getCustomerDetails().get("Email"));
		//clicking on search button
		coomycustomerspage.clickSearch();
	}

	
	@Then("I should be able to validate the customer details in COO")
	public void i_should_be_able_to_validate_the_customer_details_in_COO() {
		coomycustomerspage.validateCustomerDetails();
	}

	@When("I search for the order with order number in COO")
	public void i_search_for_the_order_with_order_number_in_COO() {
		//entering order number
		cooorderspage.enterOrderNumber(world.getCustomerDetails().get("OrderNum"));
		//clicking on search button
		cooorderspage.clickSearch();
	}

	@When("I should be able to validate the order details in COO")
	public void i_should_be_able_to_validate_the_order_details_in_COO() {
		cooorderspage.validateOrderDetails();
	}

}