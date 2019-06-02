//WARNING!
//This file was created by Oracle OpenScript.
//Don't change it.

package lib.beachbody.browserlibs;

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
import oracle.oats.scripting.modules.basic.api.internal.FuncLibraryWrapper;
import oracle.oats.scripting.modules.basic.api.exceptions.AbstractScriptException;

public class Browser_Functions extends FuncLibraryWrapper
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
	 * This is the login function for EBS Web UI
	 * @param username  username
	 * @param password  password
	 */
	public void Login(@Arg("username") String username,
			@Arg("password") String password) throws AbstractScriptException {
		checkInit();
		callFunction("Login", username, password);
	}

	/**
	 * Launch the browser and navigate to EBS home page based on the URL
	 * @param URL  URL to navigate to
	 */
	public void Launch(@Arg("URL") String URL) throws AbstractScriptException {
		checkInit();
		callFunction("Launch", URL);
	}

	/**
	 * Select an item for Menu Item
	 * @param Menu  Main Menu in the tree
	 * @param SubMenu  Sub Menu inside the tree
	 */
	public void SelectMenu(@Arg("Menu") String Menu,
			@Arg("SubMenu") String SubMenu) throws AbstractScriptException {
		checkInit();
		callFunction("SelectMenu", Menu, SubMenu);
	}

	public void finish() throws AbstractScriptException {
		checkInit();
		callFunction("finish");
	}
	
}

