package com.beachbody.automation.drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.beachbody.automation.common.World;

public class WebDriverManager {
	private World world;
	private WebDriver driver;
	
	public WebDriverManager(World world){
		this.world=world;
	}
	
	public WebDriver getIEDriver(){
		io.github.bonigarcia.wdm.WebDriverManager.iedriver().arch32().setup();
		return this.driver=new InternetExplorerDriver();
	}
	
	public WebDriver getDriver() {
		try 
		{
			
			if(world.getBrowser().equalsIgnoreCase("firefox"))
			{
				io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
				this.driver=new FirefoxDriver();		
			}
			else if(world.getBrowser().equalsIgnoreCase("chrome"))
			{
				io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
				this.driver=new ChromeDriver();	
			}
			else if(world.getBrowser().equalsIgnoreCase("safari"))
			{
				
				this.driver=new SafariDriver();	
			}
			else if(world.getBrowser().equalsIgnoreCase("iexplore"))
			{
				io.github.bonigarcia.wdm.WebDriverManager.iedriver().arch32().setup();
				this.driver=new InternetExplorerDriver();
			}
			else if(world.getBrowser().equalsIgnoreCase("edge"))
			{
				io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
				this.driver=new EdgeDriver();
			}
		
		} 
		catch (Exception e) {
			
			
		}	
		return driver;
	}
	

}
