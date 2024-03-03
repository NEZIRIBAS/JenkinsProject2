package com.Automation.Day15_Feb06_Applying_OOPs_in_Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestBase {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	
	
	
	public TestBase() throws Exception {
		prop = new Properties();
	    ip = new FileInputStream(System.getProperty("user.dir") + "src\\test\\java\\com\\Automation\\Day15_Feb06_Applying_OOPs_in_Automation\\config.properties");
	    prop.load(ip);
	}
	
	public WebDriver initalizeBrowserAndOpenApplication(String browserName) {
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("FireFox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("none of the browser matches");
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
		return driver;
	}
}
