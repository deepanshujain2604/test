package com.CRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.CRM.BaseClass.BaseClass;
import com.CRM.Utils.HandleAlert_CaptureMsg;

public class ContactPage extends BaseClass
{
   // All the Web Element Present on the contact page 
 @FindBy(xpath="//i[@aria-hidden='true' and @class='download icon']") 
 WebElement Export;
 
 @FindBy(xpath="//button[text()='Show Filters']")
 WebElement ShowFilters;
 
 @FindBy(xpath="//button[text()='Show Filters']/parent::div//a")
 WebElement AddContactButton;
 
 @FindBy(xpath="//input[@type='text']")
 WebElement searchContact;
 
 @FindBy(name="first_name")
 WebElement firstnameBtn;
 
 @FindBy(name="last_name")
 WebElement lastnameBtn;
 
 @FindBy(xpath="//input[@name='value' and @type='text' and @autocomplete='new-password']")
 WebElement email;

 @FindBy(name="city")
 WebElement cityName;
 
 
 @FindBy(xpath="//button//i[@aria-hidden='true' and @class='save icon']")
 WebElement saveBtn;
 
 
 
public ContactPage()
{
  PageFactory.initElements(driver, this);	
}


// ALL actions present on the contact page 



//public String ExportAlertMessage()
//{
//Export.click();
//String AlertMsg= HandleAlert_CaptureMsg.handleAlert("ok");
//System.out.println("ALERT MSG IS : "+AlertMsg);
//return AlertMsg;
//}

public void addContact(String FN,String LN,String Email ,String city) throws Throwable
{
AddContactButton.click();
firstnameBtn.sendKeys(FN);
Thread.sleep(2000);
lastnameBtn.sendKeys(LN);
Thread.sleep(2000);
email.sendKeys(Email);
Thread.sleep(2000);
cityName.sendKeys(city);
Thread.sleep(2000);
saveBtn.click();
Thread.sleep(2000);

}


public void deleteContact(String deleteFName,String deleteLName) throws Throwable
{
	searchContact.sendKeys(deleteFName,Keys.ENTER);
	Thread.sleep(2000);
try {
		
		driver.findElement(By.xpath("//th[text()='Name']/parent::tr"
				+ "/parent::thead//following-sibling::tbody//tr//td//a[text()='"+deleteFName+" "+deleteLName+"']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button//following-sibling::button//i[@aria-hidden='true' and @class='trash icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ui red button']")).click();
	} catch (Exception e) 
	 {
		
		//return false;
	 }
//	driver.findElement(By.xpath("//td[text()='"+deleteFName+" "+deleteLName+"']")).click();
//	Thread.sleep(2000);
//    driver.findElement(By.xpath("//a/following-sibling::button/following-sibling::div[@class='contents']//button[@class]//i[@class='trash icon']")).click();
//    Thread.sleep(2000);
//    driver.findElement(By.xpath("//button[@class='ui button']//i[@class='checkmark icon']")).click();
//    Thread.sleep(3000);
}

public boolean serchContact(String Fname) throws Throwable
{
	searchContact.clear();
	searchContact.sendKeys(Fname,Keys.ENTER);
	Thread.sleep(5000);
	try {
		
		return driver.findElement(By.xpath("//th[text()='Name']/parent::tr"
				+ "/parent::thead//following-sibling::tbody//tr//td//a")).getText().startsWith(Fname);
	} catch (Exception e) 
	 {
		return false;
	 }
    
	    
	
	 
}

public String fetchtitle()
{
 String title=driver.getTitle();
 return title;
}
}
