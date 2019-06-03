package com.beachbody.automation.drivers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
		ProcessBuilder oatsProcess = new ProcessBuilder("C:/OracleATS/openScript/runScript.bat",scriptName+"/"+scriptName+".jwg");
		oatsProcess.directory(new File("OATS/Scripts"));
		try {
			oatsProcess.redirectErrorStream(true);
			Process p = oatsProcess.start();
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
			    System.out.println(line);
			}
			
			p.waitFor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Read the output and error stream here and return accordingly
		return true;
	}

}
