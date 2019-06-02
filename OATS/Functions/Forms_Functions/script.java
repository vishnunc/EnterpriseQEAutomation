import java.util.Map;
import java.util.concurrent.TimeUnit;

import oracle.oats.scripting.modules.basic.api.*;
import oracle.oats.scripting.modules.basic.api.exceptions.AbstractScriptException;
import oracle.oats.scripting.modules.browser.api.*;
import oracle.oats.scripting.modules.functionalTest.api.*;
import oracle.oats.scripting.modules.utilities.api.*;
import oracle.oats.scripting.modules.utilities.api.sql.*;
import oracle.oats.scripting.modules.utilities.api.xml.*;
import oracle.oats.scripting.modules.utilities.api.file.*;
import oracle.oats.scripting.modules.webdom.api.*;
import oracle.oats.scripting.modules.formsFT.api.*;
import oracle.oats.scripting.modules.applet.api.*;

public class script extends IteratingVUserScript {
	@ScriptService oracle.oats.scripting.modules.utilities.api.UtilitiesService utilities;
	@ScriptService oracle.oats.scripting.modules.browser.api.BrowserService browser;
	@ScriptService oracle.oats.scripting.modules.functionalTest.api.FunctionalTestService ft;
	@ScriptService oracle.oats.scripting.modules.webdom.api.WebDomService web;
	@ScriptService oracle.oats.scripting.modules.applet.api.AppletService applet;
	@ScriptService oracle.oats.scripting.modules.formsFT.api.FormsService forms;

	public void initialize() throws Exception {
	}

	/**
	 * Add code to be executed each iteration for this virtual user.
	 */
	public void run() throws Exception {

	}

	/**
	 * Search for a customer
	 * @param Email 
	 */
	public void CustomerSearch(@Arg("Email") String Email) throws Exception {
		//Click on the Customer tab
		forms.tab("//forms:tab[(@name='FIND_TAB_CANVAS')]").select("Customer");
		//Enter the Email and search
		forms.textField("{{obj.FindCustomerPage.Email}}").exists(15, TimeUnit.SECONDS);
		forms.textField(45,
		"{{obj.FindCustomerPage.Email}}").setText(Email);
		forms.button("{{obj.FindCustomerPage.Search}}").click();
		{
			think(3.0);
		}
		//Ensure the data is returned
		if(forms.choiceBox("//forms:choiceBox").exists(10, TimeUnit.MILLISECONDS)){
			forms.choiceBox("//forms:choiceBox").clickButton("No");
		}
		
		//Click on Open to open Customer detail page
		forms.button("{{obj.FindCustomerPage.Open}}").click();
		{
			think(3.0);
		}
		
	}

	/**
	 * Validate the Customer Detail Values
	 * @param CustomerDetails Customer Details Map for validation
	 */
	public void ValidateCustomerDetails(
			@Arg("CustomerDetails") java.util.Map<String, String> CustomerDetails)
			throws Exception {
		
		//Verify that the Customer Details window is open
		forms.textField("{{obj.CustomerDetails.Email}}").exists(5,TimeUnit.SECONDS);
		//Validate the Customer FName and LName and Email
		if(CustomerDetails.containsKey("FirstName")){
			if(forms.textField("{{obj.CustomerDetails.FirstName}}").getText().equals(CustomerDetails.get("FirstName"))){
				reportPassed("First Name "+CustomerDetails.get("FirstName")+ " validated");
			}
			else{
				assert(false);
			}
		}
		if(CustomerDetails.containsKey("LastName")){
			if(forms.textField("{{obj.CustomerDetails.LastName}}").getText().equals(CustomerDetails.get("LastName"))){
				reportPassed("Last Name "+CustomerDetails.get("LastName")+ " validated");
			}
			else{
				assert(false);
			}
		}
		if(CustomerDetails.containsKey("Email")){
			if(forms.textField("{{obj.CustomerDetails.Email}}").getText().equals(CustomerDetails.containsKey("Email"))){
				reportPassed("Email "+CustomerDetails.get("Email")+ " validated");
			}
			else{
				assert(false);
			}
		}
		//Validate that CLUB Network user is displayed
		if(CustomerDetails.containsKey("Network")){
			if(forms.textField("{{obj.CustomerDetails.Network_0}}").getText().equals(CustomerDetails.get("Network"))){
				reportPassed("Network "+CustomerDetails.get("Network")+ " validated");
			}
			else{
				assert(false);
			}
		}
		//Validate Entitlements if provided
		forms.tab("{{obj.CustomerDetails.Tabs}}").select("Entitlements");
		if(CustomerDetails.containsKey("Entitlement")){
			if(forms.textField("{{obj.CustomerDetails.EntitlementName_0}}").getText().equals(CustomerDetails.get("Entitlement"))){
				reportPassed("First Name "+CustomerDetails.get("FirstName")+ " validated");
			}
			else{
				assert(false);
			}
			if(forms.checkBox("{{obj.CustomerDetails.Entitlement_Active_0}}").isSelected()){
				reportPassed("Entitlement "+CustomerDetails.get("Entitlement")+ " is active");
			}
			else{
				assert(false);
			}
		}
		//Validate Shipping and Billing address
		if(CustomerDetails.containsKey("Address1")){
			if(forms.textField("{{obj.CustomerDetails.Address1}}").getText().equals(CustomerDetails.get("Address1"))){
				reportPassed("Address1 "+CustomerDetails.get("Address1")+ " validated");
			}
			else{
				assert(false);
			}
		}
		if(CustomerDetails.containsKey("City")){
			if(forms.textField("{{obj.CustomerDetails.City}}").getText().equals(CustomerDetails.get("City"))){
				reportPassed("City "+CustomerDetails.get("City")+ " validated");
			}
			else{
				assert(false);
			}
		}
		if(CustomerDetails.containsKey("Zip")){
			if(forms.textField("{{obj.CustomerDetails.Zip}}").getText().equals(CustomerDetails.get("Zip"))){
				reportPassed("Zip "+CustomerDetails.get("Zip")+ " validated");
			}
			else{
				assert(false);
			}
		}
		if(CustomerDetails.containsKey("State")){
			if(forms.textField("{{obj.CustomerDetails.State}}").getText().equals(CustomerDetails.get("State"))){
				reportPassed("State "+CustomerDetails.get("State")+ " validated");
			}
			else{
				assert(false);
			}
		}
		if(CustomerDetails.containsKey("Country")){
			if(forms.textField("{{obj.CustomerDetails.Country}}").getText().equals(CustomerDetails.get("Country"))){
				reportPassed("Country "+CustomerDetails.get("Country")+ " validated");
			}
			else{
				assert(false);
			}
		}
		//Validate Phone number
		if(CustomerDetails.containsKey("Phone")){
			String Phone = "+"+forms.textField("{{obj.CustomerDetails.CountryCode}}").getText()+forms.textField("{{obj.CustomerDetails.AreaCode}}").getText()+forms.textField("{{obj.CustomerDetails.PhoneNum}}").getText();
			if(Phone.equals(CustomerDetails.get("Phone"))){
				reportPassed("Phone "+CustomerDetails.get("Phone")+ " validated");
			}
			else{
				assert(false);
			}
		}
		
	}

	/**
	 * Search for an Order
	 * @param OrderNum 
	 */
	public void OrderSearch(@Arg("OrderNum") String OrderNum) throws Exception {
		//Click on the Customer tab
		forms.tab("//forms:tab[(@name='FIND_TAB_CANVAS')]").select("Order");
		//Enter the Email and search
		forms.textField("{{obj.FindCustomerPage.OrderNum}}").exists(15, TimeUnit.SECONDS);
		forms.textField("{{obj.FindCustomerPage.OrderNum}}").setText(OrderNum);
		forms.button("{{obj.FindCustomerPage.Search}}").click();
		{
			think(3.0);
		}
		//Ensure the data is returned
		if(forms.choiceBox("//forms:choiceBox").exists(10, TimeUnit.MILLISECONDS)){
			forms.choiceBox("//forms:choiceBox").clickButton("No");
		}
		//Click on Open to open Customer detail page
		forms.button("{{obj.FindCustomerPage.Open}}").click();
		{
			think(3.0);
		}
		
	}

	/**
	 * 
	 * @param OrderDetails A map containing Order details
	 */
	public void ValidateOrderDetails(
			@Arg("OrderDetails") java.util.Map<String, String> OrderDetails)
			throws Exception {
		//Verify that the Customer Details window is open
		forms.textField("{{obj.CustomerDetails.Email}}").exists(5,TimeUnit.SECONDS);
		//Click on Transaction History tab
		forms.tab("{{obj.CustomerDetails.Tabs}}").select("Transaction History");
		//Validate values in transaction tab
		validateTransactionHistory(OrderDetails);
		//Click on Orders Tab
		forms.textField("{{obj.TransactionHistory.LegacyNum}}").doubleClick();
		//forms.tab("{{obj.CustomerDetails.Tabs}}").select("Order");
		forms.button("{{obj.OrderDetailsPage.VolumeDetails}}").exists(120, TimeUnit.SECONDS);
		validateOrderTab(OrderDetails);
		validateItemDetails(OrderDetails);
		validateCCDetails(OrderDetails);
		//Click on Volume details
		forms.button("{{obj.OrderDetailsPage.VolumeDetails}}").click();
		forms.textField("{{obj.OrderDetailsPage.BP}}").exists(120, TimeUnit.SECONDS);
		validateVolumeDetails(OrderDetails);
	}
	
	private void validateVolumeDetails(Map<String, String> orderDetails) {
		// TODO Auto-generated method stub
		
	}

	private void validateCCDetails(Map<String, String> orderDetails) {
		// TODO Auto-generated method stub
		
	}

	private void validateItemDetails(Map<String, String> orderDetails) {
		// TODO Auto-generated method stub
		
	}

	public void validateTransactionHistory(java.util.Map<String,String> OrderDetails) throws AbstractScriptException{
		if(OrderDetails.containsKey("BusinessUnit")){
			if(forms.textField("{{obj.TransactionHistory.BusinessUnit}}").getText().equals(OrderDetails.get("BusinessUnit"))){
				reportPassed("Business Unit validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("OrderNum")){
			if(forms.textField("{{obj.TransactionHistory.LegacyNum}}").getText().equals(OrderDetails.get("OrderNum"))){
				reportPassed("Order Num validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("OrderDate")){
			if(forms.textField("{{obj.TransactionHistory.OrderDate}}").getText().equals(OrderDetails.get("OrderDate"))){
				reportPassed("Order Date validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("OrderType")){
			if(forms.textField("{{obj.TransactionHistory.OrderType}}").getText().equals(OrderDetails.get("OrderType"))){
				reportPassed("Order Type validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("Source")){
			if(forms.textField("{{obj.TransactionHistory.Source}}").getText().equals(OrderDetails.get("Source"))){
				reportPassed("Source validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("SubTotal")){
			if(forms.textField("{{obj.TransactionHistory.SubTotal}}").getText().equals(OrderDetails.get("SubTotal"))){
				reportPassed("Sub Total validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("SnH")){
			if(forms.textField("{{obj.TransactionHistory.SnH}}").getText().equals(OrderDetails.get("SnH"))){
				reportPassed("Shipping and Handling validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("Tax")){
			if(forms.textField("{{obj.TransactionHistory.Tax}}").getText().equals(OrderDetails.get("Tax"))){
				reportPassed("Tax validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("Total")){
			if(forms.textField("{{obj.TransactionHistory.Total}}").getText().equals(OrderDetails.get("Total"))){
				reportPassed("Total validated");
			}
			else
			{
				
			}
		}
	}
	
	public void validateOrderTab(java.util.Map<String,String> OrderDetails) throws AbstractScriptException{
		if(OrderDetails.containsKey("BusinessUnit")){
			if(forms.textField("{{obj.OrderDetailsPage.BusinessUnit}}").getText().equals(OrderDetails.get("BusinessUnit"))){
				reportPassed("Business Unit validated");
			}
			else
			{
				
			}
		}
		
		if(OrderDetails.containsKey("OrderType")){
			if(forms.textField("{{obj.OrderDetailsPage.OrderType}}").getText().equals(OrderDetails.get("OrderType"))){
				reportPassed("Order Type validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("OrderDate")){
			if(forms.textField("{{obj.OrderDetailsPage.RequestDate}}").getText().equals(OrderDetails.get("OrderDate"))){
				reportPassed("Source validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("FirstName")){
			if(forms.textField("{{obj.OrderDetailsPage.FirstName}}").getText().equals(OrderDetails.get("FirstName"))){
				reportPassed("First Name validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("LastName")){
			if(forms.textField("{{obj.OrderDetailsPage.LastName}}").getText().equals(OrderDetails.get("LastName"))){
				reportPassed("Last Name validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("CustomerRole")){
			if(forms.textField("{{obj.OrderDetailsPage.CustomerRole}}").getText().equals(OrderDetails.get("CustomerRole"))){
				reportPassed("Customer Role validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("Address1")){
			if(forms.textField("{{obj.OrderDetailsPage.Bill_Addr1}}").getText().equals(OrderDetails.get("Address1"))){
				reportPassed("Address validated");
			}
			else
			{
				
			}
		}
		if(OrderDetails.containsKey("Address1")){
			if(forms.textField("{{obj.OrderDetailsPage.Ship_Addr1}}").getText().equals(OrderDetails.get("Address1"))){
				reportPassed("Address validated");
			}
			else
			{
				
			}
		}
	}

	public void finish() throws Exception {
	}
}
