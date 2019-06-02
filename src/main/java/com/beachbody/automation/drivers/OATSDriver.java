package com.beachbody.automation.drivers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.beachbody.automation.common.World;


public class OATSDriver {
	
	private World world;
	public OATSDriver(World world){
		this.world=world;
	}
	
	public boolean runScript(String scriptName,String properties){
		ProcessBuilder oatsProcess = new ProcessBuilder("C:/OracleOATS/openScript/runScript.bat",scriptName);
		oatsProcess.directory(new File("OATS/Scripts"));
		try {
			oatsProcess.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Read the output and error stream here and return accordingly
		return true;
	}

}
