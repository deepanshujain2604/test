package com.CRM.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.CRM.BaseClass.BaseClass;
import com.CRM.Pages.ContactPage;
import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;

public class HomePageTest extends BaseClass
{
LoginPage loginpage;
HomePage homepage;
ContactPage contactpage;

@BeforeMethod
public void initialisation()
{
	launch_Browser();
	loginpage=new LoginPage();
	homepage=loginpage.login(UN, PWD);
}

@Test(priority=1)
public void verifyUserNameTest()
{
	String UserName =homepage.validateHomepage();
	Assert.assertEquals(UserName, "Deepanshu Jain");
	System.out.println("Username is "+UserName);
}

@Test(priority=2) 
public void navigateToContactPage() throws Throwable
{
	Thread.sleep(2000);
	contactpage=homepage.navigateToContacts();
	Thread.sleep(2000);
}

@Test(priority=3)
public void verfifyHomePageTest()
{
 String HomePagetitle=homepage.getTitle();
 Assert.assertEquals(HomePagetitle, "Cogmento CRM" ,"Title is not matched");
}

@AfterMethod
public void terminate()
{
 driver.close();	
}
}
