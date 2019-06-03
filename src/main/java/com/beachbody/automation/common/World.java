package com.beachbody.automation.common;

import com.beachbody.automation.drivers.OATSDriver;
import com.beachbody.automation.drivers.RESTDriver;
import com.beachbody.automation.drivers.SOAPDriver;
import com.beachbody.automation.drivers.SauceLabsDriver;
import com.beachbody.automation.drivers.SeleniumGridDriver;
import com.beachbody.automation.drivers.WebDriverManager;

import cucumber.api.Scenario;

import java.util.HashMap;
import java.util.Map;

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
	Map<String,String> customerDetails=new HashMap<String,String>();
	Map<String,String> orderDetails=new HashMap<String,String>();
	public Scenario scenario;

	public Map<String, String> getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(String key,String value) {
		
		this.customerDetails.put(key, value);
	}

	public Map<String, String> getOrderDetails() {
		return orderDetails;
	}

	public OATSDriver getOatsDriver() {
		return oatsDriver;
	}

	public void setOatsDriver(OATSDriver oatsDriver) {
		this.oatsDriver = oatsDriver;
	}

	public void setOrderDetails(String key,String value) {
		
		this.orderDetails.put(key, value);
	}

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
