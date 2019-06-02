package com.beachbody.automation.common;

import com.beachbody.automation.drivers.OATSDriver;
import com.beachbody.automation.drivers.RESTDriver;
import com.beachbody.automation.drivers.SOAPDriver;
import com.beachbody.automation.drivers.SauceLabsDriver;
import com.beachbody.automation.drivers.SeleniumGridDriver;
import com.beachbody.automation.drivers.WebDriverManager;

import org.openqa.selenium.WebDriver;


public class World {
	private String browser;
	private String locale;
	private String driverType;
	private String orderNum;
	WebDriverManager webDriver=new WebDriverManager(this);
	SauceLabsDriver sauceDriver = new SauceLabsDriver(this);
	SeleniumGridDriver gridDriver = new SeleniumGridDriver(this);
	RESTDriver restDriver = new RESTDriver(this);
	SOAPDriver soapDriver = new SOAPDriver(this);
	OATSDriver oatsDriver = new OATSDriver(this);
	public WebDriver driver;
	public WebDriver ieDriver;
	

	public WebDriver getDriver(){
		switch(this.driverType){
		case "sauce": this.driver= sauceDriver.getDriver();
		case "grid": this.driver= gridDriver.getDriver();
		default: this.driver= webDriver.getDriver();
		}
		return this.driver;
	}
	
	public WebDriver getIEDriver(){
		return this.ieDriver=webDriver.getIEDriver();
	}
	
	public String getLocale() {
		return locale;
	}
	
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public String getBrowser(){
		return browser;
	}
	
	public void setBrowser(String browser){
		this.browser=browser;
	}
	
	public String getDriverType() {
		return driverType;
	}
	
	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}
	
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
}
