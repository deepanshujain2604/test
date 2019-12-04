package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.BaseClass.BaseClass;

public class HomePage extends BaseClass
{
	// All the web elements present on the Login Page

	
  @FindBy(xpath="//span[text()='Calendar']")
  WebElement Calender;
  
  @FindBy(xpath="//span[text()='Contacts']")
  WebElement Contacts;
  
  @FindBy(xpath="//span[text()='Deals']")
  WebElement Deals;
  
  @FindBy(xpath="//span[text()='Tasks']")
  WebElement Tasks;
  
  @FindBy(xpath="//span[text()='Deepanshu  Jain']")
  WebElement user;
  
  
  public HomePage()
  {
	  PageFactory.initElements(driver, this);
	  
  }
  // ALL the actions on HOMEPAGE
  public CalenderPage navigateToCalender()
  {
	  Calender.click();
	  return new CalenderPage();
  }
  
  public ContactPage navigateToContacts()
  {
	Contacts.click();
	return new ContactPage();
  }
  
  public DealsPage navigateToDeals()
  {
	  Deals.click();
	  return new DealsPage();
  }
  
  public TaskPage navigateToTask()
  {
	  Tasks.click();
	  return new TaskPage();
  }
  
  public String validateHomepage()
  {
	  return user.getText();
  }
  
  public String getTitle()
  {
    return driver.getTitle();
  }
  
}