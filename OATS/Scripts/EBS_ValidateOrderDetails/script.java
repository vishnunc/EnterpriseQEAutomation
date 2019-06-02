import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import oracle.oats.scripting.modules.basic.api.*;
import oracle.oats.scripting.modules.browser.api.*;
import oracle.oats.scripting.modules.functionalTest.api.*;
import oracle.oats.scripting.modules.utilities.api.*;
import oracle.oats.scripting.modules.utilities.api.sql.*;
import oracle.oats.scripting.modules.utilities.api.xml.*;
import oracle.oats.scripting.modules.utilities.api.file.*;
import oracle.oats.scripting.modules.webdom.api.*;
import oracle.oats.scripting.modules.formsFT.api.*;
import oracle.oats.scripting.modules.applet.api.*;
import lib.*;

public class script extends IteratingVUserScript {
	@ScriptService oracle.oats.scripting.modules.utilities.api.UtilitiesService utilities;
	@ScriptService oracle.oats.scripting.modules.browser.api.BrowserService browser;
	@ScriptService oracle.oats.scripting.modules.functionalTest.api.FunctionalTestService ft;
	@ScriptService oracle.oats.scripting.modules.webdom.api.WebDomService web;
	@ScriptService oracle.oats.scripting.modules.applet.api.AppletService applet;
	@ScriptService oracle.oats.scripting.modules.formsFT.api.FormsService forms;
	@FunctionLibrary("Browser_Functions") lib.beachbody.browserlibs.Browser_Functions browser_Functions;
	@FunctionLibrary("Forms_Functions") lib.beachbody.formslibs.Forms_Functions forms_Functions;

	public void initialize() throws Exception {
	}

	/**
	 * Add code to be executed each iteration for this virtual user.
	 */
	public void run() throws Exception {
		
		browser_Functions.Launch("https://ebsqa.beachbody.local:4463/");
		browser_Functions.Login("VNALLANI", deobfuscate("gHrGh5c1JDUlwIb0PAucrA=="));
		browser_Functions.SelectMenu("US CS ADMIN", "CSP");
		Properties orderDetails = new Properties();
		orderDetails.load(new FileInputStream("../DataBank/orderdetails.properties"));
		
		Map<String,String> OrderDetails = new HashMap<String,String>();
		OrderDetails.put("BusinessUnit", "NETWORK");
		OrderDetails.put("OrderNum", orderDetails.getProperty("OrderNum"));
		OrderDetails.put("OrderType", "WEB ORDER_NT");
		OrderDetails.put("OrderDate", orderDetails.getProperty("OrderDate"));
		OrderDetails.put("Source", "TBB WEB");
		OrderDetails.put("SubTotal", orderDetails.getProperty("SubTotal"));
		OrderDetails.put("SnH", orderDetails.getProperty("SnH"));
		OrderDetails.put("Tax", orderDetails.getProperty("Tax"));
		OrderDetails.put("Total", orderDetails.getProperty("Total"));
		OrderDetails.put("CustomerRole", "CLUB");
		OrderDetails.put("FirstName", orderDetails.getProperty("FirstName"));
		OrderDetails.put("LastName", orderDetails.getProperty("LastName"));
		OrderDetails.put("ItemSKU", "MBDPP21E");
		OrderDetails.put("ItemDesc", "21 Day Fix Extreme Performance Pack");
		
		forms_Functions.ValidateOrderDetails(OrderDetails);
	}

	public void finish() throws Exception {
		browser.closeAllBrowsers();
	}
}
