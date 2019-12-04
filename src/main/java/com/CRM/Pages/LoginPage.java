package com.CRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.BaseClass.BaseClass;

public class LoginPage extends BaseClass

{
	// All the web elements present on the Login Page
@FindBy(name="email")
 WebElement username;
 
 @FindBy(name="password")
 WebElement password;
 
 @FindBy(xpath="//div[text()='Login']")
 WebElement loginButton;
 
 @FindBy(linkText="Forgot your password?")
 WebElement forgot_pass;
 
 
 
 public LoginPage()
 {
	 PageFactory.initElements(driver, this);	
 } 
 
   //ALL THE ACTIONS
 
 
 public String verify_loginPage_title()
 {
	 
	 return driver.getTitle();
 }
 
 
 public  HomePage login(String un,String pwd)
 {
	 
	 username.sendKeys(un);
	 password.sendKeys(pwd);
	 loginButton.click();
	 
	 return new HomePage();
 }
}