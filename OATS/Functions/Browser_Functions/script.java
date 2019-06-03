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
	 * This is the login function for EBS Web UI
	 * @param username username
	 * @param password password
	 */
	public void Login(@Arg("username")
			String username, @Arg("password")
			String password) throws Exception {
		
		//Wait for login page to appear
		//think(10.43);
		/*web.window("/web:window[@index='0' or @title='Login']")
		.waitForPage(null);*/
		//Enter username and password
		web.textBox("{{obj.LoginPage.Username}}")
			.click();
		web.textBox("{{obj.LoginPage.Username}}")
		.setText(username);
		web.textBox("{{obj.LoginPage.Username}}")
			.pressTab();
		web.textBox("{{obj.LoginPage.Password}}")
		.setPassword(password);
		//Click on login and wait for home page to appear
		web.button("{{obj.LoginPage.Login}}")
			.click();
		
		web.window("/web:window[@index='0' or @title='Home']")
		.waitForPage(null);
		
		
		
	}

	/**
	 * Launch the browser and navigate to EBS home page based on the URL
	 * @param URL URL to navigate to
	 */
	public void Launch(@Arg("URL") String URL) throws Exception {
		//Close all browsers
		browser.closeAllBrowsers();
		//Launch new browser
		browser.launch();
		//Navigate to the URL
		web.window(23, "/web:window[@index='0' or @title='about:blank']")
		.navigate(URL);
		//Wait for login page to appear
		web.window(24, "/web:window[@index='0' or @title='Login']")
				.waitForPage(null);
	}

	/**
	 * Select an item for Menu Item
	 * @param Menu Main Menu in the tree
	 * @param SubMenu Sub Menu inside the tree
	 */
	public void SelectMenu(@Arg("Menu") String Menu,
			@Arg("SubMenu") String SubMenu) throws Exception {
		//Ensure that you are on Home Page
		
		//web.window("/web:window[@index='0' or @title='Home']").waitForPage(null);
		web.link("{{obj.LoginPage."+Menu+"}}")
		.click();
		{
		think(5);
		}
		web.link("{{obj.LoginPage."+SubMenu+"}}")
			.click();
		web.window("/web:window[@index='1' or @title='Oracle E-Business Suite R12']")
		.waitForPage(null);
		{
		think(10.43);
		}
	}

	public void finish() throws Exception {
	}
}
