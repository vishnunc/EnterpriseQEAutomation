package com.beachbody.automation.libraries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private Properties orProperties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/config/config.properties";
	private final String objectrepositoryFilePath= System.getProperty("user.dir")+"/configs/objectrepository.properties";
	
	
	//*************************************************
	private static ConfigFileReader configFileReader,objectRepositoryFileReader;
	public static ConfigFileReader getConfigFileReader() {		
		String config = "CONFIG";
		if (configFileReader != null) {
			 return configFileReader; 	
		}else {
			configFileReader = new ConfigFileReader(config);
			return configFileReader;
		}
	        
	}
	
	public static ConfigFileReader getObjectRepositoryFileReader() {		
		String repo = "OR";
		if (objectRepositoryFileReader != null) {
			 return objectRepositoryFileReader; 	
		}else {
			objectRepositoryFileReader = new ConfigFileReader(repo);
			return objectRepositoryFileReader;
		}
	        
	}
	//*************************************************
	
	
	protected ConfigFileReader(String configType){
		System.out.println("Into Config file reader");
		
		BufferedReader reader = null;
		try {
			if(configType.equalsIgnoreCase("CONFIG")) {
				System.out.println("Into Config ");
				properties = new Properties();
				reader = new BufferedReader(new FileReader(propertyFilePath));
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					System.out.println("Here is the exception in config");
					e.printStackTrace();
				}
				
			}
			else if(configType.equalsIgnoreCase("OR")) {
				System.out.println("Into OR Config ");
				orProperties = new Properties();
				reader = new BufferedReader(new FileReader(objectrepositoryFilePath));
				try {
					orProperties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
			//properties = new Properties();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	
	public String getOIMUrl() {
		String url = properties.getProperty("OIM_QA3_URL");
		if(url != null) return url;
		else throw new RuntimeException(url+" url not specified in the Configuration.properties file.");
	}
	
	public String getBYDUrl() {
		String url = properties.getProperty("BYD_QA3_URL");
		if(url != null) return url;
		else throw new RuntimeException(url+" url not specified in the Configuration.properties file.");
	}
	
	public String getCOOUrl() {
		String url = properties.getProperty("COO_QA3_URL");
		if(url != null) return url;
		else throw new RuntimeException(url+" url not specified in the Configuration.properties file.");
	}
	
	public String getTBBUrl() {
		String url = properties.getProperty("TBB_QA3_URL");
		if(url != null) return url;
		else throw new RuntimeException(url+" url not specified in the Configuration.properties file.");
	}
	
	public String getBYDSearchUrl() {
		String url = properties.getProperty("TBB_QA3_URL");
		if(url != null) return url;
		else throw new RuntimeException(url+" url not specified in the Configuration.properties file.");
	}
	
	public String getElement(String elemntName) {
		String tempElement = orProperties.getProperty(elemntName);
		if(tempElement!= null) return tempElement;
		else throw new RuntimeException(tempElement+" not specified in the ObjectRepository.properties file.");	
	}
	
	public String getDriverPath() {
		String driverPath = System.getProperty("user.dir")+properties.getProperty("driverpath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlywait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {

		
		String url=null;
		try {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(System.getenv("APP_URL"));
			url=System.getenv("APP_URL");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			
		}
		catch(Exception e) {
			url = null;
		}
		if(url==null) {
			url = properties.getProperty("url");
		}
		
		

		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getApiGatewayUrl() {
		String url = properties.getProperty("apigateway");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getBeachBodyOIMApplicationUrl() {
		System.out.println("#########################################"+properties.getProperty("OIM_QA3_URL"));
		String url = properties.getProperty("OIM_QA3_URL");
		if(url != null) return url;
		else throw new RuntimeException(url+" url not specified in the Configuration.properties file.");
	}
	
	
	public String getKeyStatus() {
		String url = properties.getProperty("Jsonkeys");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public int getWebDriverWait() {
		String webdriverwait = properties.getProperty("webdriverwait");
		if(webdriverwait != null) return Integer.parseInt(webdriverwait);
		else throw new RuntimeException("webdriverwait not specified in the Configuration.properties file.");
	}
	
	public long getPause() {
		String pause = properties.getProperty("pause");
		if(pause != null) return Long.parseLong(pause);
		else throw new RuntimeException("pause not specified in the Configuration.properties file.");
	}
	
	
	public long getPageLoadPause() {
		String pageloadpause = properties.getProperty("pageloadpause");
		if(pageloadpause != null) return Long.parseLong(pageloadpause);
		else throw new RuntimeException("pageloadpause not specified in the Configuration.properties file.");
	}
	
	public String getTemplatePath(){
        String templatePath = System.getProperty("user.dir")+properties.getProperty("templateloc");
        if(templatePath!= null) return templatePath;
        else throw new RuntimeException("templatePath not specified in the Configuration.properties file.");        
    }
	
	public String getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName != null) return browserName;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	public String getObjectRepoPath(){
		String objectConfigPath = properties.getProperty("ObjectRepoPath");
		if(objectConfigPath!= null) return objectConfigPath;
		else throw new RuntimeException("Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	
	public String getDocumentType(){
		String template = System.getProperty("user.dir")+properties.getProperty("template");
		if(template!= null) return template;
		else throw new RuntimeException("template is not specified in the Configuration.properties file.");		
	}

	public String getOIMUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOIMPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
 
}
