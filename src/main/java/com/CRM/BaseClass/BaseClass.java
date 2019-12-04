package com.CRM.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.CRM.Utils.WebEventListener;
import com.CRM.configuration.configReader;

public class BaseClass 

{
 public static WebDriver driver;
 public static configReader confi = new configReader(); 
 public static String link = confi.getURL();
 public static String UN = confi.getUN();
 public static String PWD = confi.getPWD();
 public static String Browser = confi.getBrowserName();
 public static EventFiringWebDriver e_driver;
 public static WebEventListener event_listener;
 
 
 public void launch_Browser()
{
	 if(Browser.equals("chrome"))
	 {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\win 10\\eclipse-workspace\\Free_CRM_Automation\\resources\\chromedriver.exe");
	 driver = new ChromeDriver();
	 } else if (Browser.equals("firefox"))
	  {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\win 10\\eclipse-workspace\\Free_CRM_Automation\\resources\\geckodriver.exe"); 
       driver = new FirefoxDriver();	  
	  }
	 else 
	  {System.out.println("browser not found");}
	 
	 e_driver= new EventFiringWebDriver(driver);
	 event_listener = new WebEventListener();
	 e_driver.register(event_listener);
	 driver = e_driver;

	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	 driver.get(link);
}
 
 
 
 
  public void getScreenShot() throws Throwable
  {
	   File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File dfile = new File("C:\\Users\\win 10\\eclipse-workspace\\Free_CRM_Automation\\Screenshot\\ "+System.currentTimeMillis()+ ".png");
	   FileUtils.copyFile(file, dfile);
	}
  }
  
  
