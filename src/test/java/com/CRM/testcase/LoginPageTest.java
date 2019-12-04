package com.CRM.testcase;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;
import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;


public class LoginPageTest extends BaseClass
{


LoginPage loginpage ;
HomePage homepage;

@BeforeMethod
public void initialize()
{
  launch_Browser();
  loginpage=new LoginPage();
 
}

@Test(priority=1)
public void loginPage_titleTest()
{
 String title =loginpage.verify_loginPage_title();
 Assert.assertEquals(title, "Cogmento CRM");
}


@Test(priority=2)
public void logintest()
{
	homepage=loginpage.login(UN, PWD);
	Assert.assertEquals(driver.getTitle(),"Cogmento CRM");
	
}



@AfterMethod
public void terminate()
{
	driver.close();
}
}