import java.io.FileInputStream;
import java.nio.file.Paths;
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
		System.out.println(System.getProperty("user.dir"));
		System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
		browser_Functions.Launch("https://ebsqa.beachbody.local:4463/");
		browser_Functions.Login("VNALLANI", deobfuscate("gHrGh5c1JDUlwIb0PAucrA=="));
		browser_Functions.SelectMenu("US CS ADMIN", "CSP");
		Properties customerDetails = new Properties();
		customerDetails.load(new FileInputStream("../DataBank/customerdetails.properties"));
		
		Map<String,String> CustomerDetails = new HashMap<String,String>();
		CustomerDetails.put("Email", customerDetails.getProperty("Email"));
		CustomerDetails.put("FirstName", customerDetails.getProperty("FirstName"));
		CustomerDetails.put("LastName", customerDetails.getProperty("LastName"));
		CustomerDetails.put("Phone", customerDetails.getProperty("Phone"));
		CustomerDetails.put("Entitlement", "");
		CustomerDetails.put("Network", "CLUB");
		CustomerDetails.put("Address1", customerDetails.getProperty("Address"));
		CustomerDetails.put("Country", customerDetails.getProperty("Country"));
		CustomerDetails.put("City", customerDetails.getProperty("City"));
		CustomerDetails.put("State", customerDetails.getProperty("State"));
		CustomerDetails.put("Zip", customerDetails.getProperty("Zip"));
		forms_Functions.CustomerSearch(customerDetails.getProperty("Email"));
		forms_Functions.ValidateCustomerDetails(CustomerDetails);
	}

	public void finish() throws Exception {
		browser.closeAllBrowsers();
	}
}
