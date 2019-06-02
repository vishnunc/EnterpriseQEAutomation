//WARNING!
//This file was created by Oracle OpenScript.
//Don't change it.

package lib.beachbody.formslibs;

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
import oracle.oats.scripting.modules.basic.api.internal.FuncLibraryWrapper;

public class Forms_Functions extends FuncLibraryWrapper
{

	public void initialize() throws AbstractScriptException {
		checkInit();
		callFunction("initialize");
	}

	/**
	 * Add code to be executed each iteration for this virtual user.
	 */
	public void run() throws AbstractScriptException {
		checkInit();
		callFunction("run");
	}

	/**
	 * Search for a customer
	 * @param Email  
	 */
	public void CustomerSearch(@Arg("Email") String Email)
			throws AbstractScriptException {
		checkInit();
		callFunction("CustomerSearch", Email);
	}

	/**
	 * Validate the Customer Detail Values
	 * @param CustomerDetails  Customer Details Map for validation
	 */
	public void ValidateCustomerDetails(
			@Arg("CustomerDetails") java.util.Map<String, String> CustomerDetails)
			throws AbstractScriptException {
		checkInit();
		callFunction("ValidateCustomerDetails", CustomerDetails);
	}

	/**
	 * Search for an Order
	 * @param OrderNum  
	 */
	public void OrderSearch(@Arg("OrderNum") String OrderNum)
			throws AbstractScriptException {
		checkInit();
		callFunction("OrderSearch", OrderNum);
	}

	/**
	 * @param OrderDetails  A map containing Order details
	 */
	public void ValidateOrderDetails(
			@Arg("OrderDetails") java.util.Map<String, String> OrderDetails)
			throws AbstractScriptException {
		checkInit();
		callFunction("ValidateOrderDetails", OrderDetails);
	}

	public void validateTransactionHistory(
			java.util.Map<String, String> OrderDetails)
			throws AbstractScriptException {
		checkInit();
		callFunction("validateTransactionHistory", OrderDetails);
	}

	public void validateOrderTab(java.util.Map<String, String> OrderDetails)
			throws AbstractScriptException {
		checkInit();
		callFunction("validateOrderTab", OrderDetails);
	}

	public void finish() throws AbstractScriptException {
		checkInit();
		callFunction("finish");
	}

}

