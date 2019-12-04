package com.CRM.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;
import com.CRM.Pages.ContactPage;
import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.Utils.TestDataExcel;

public class ContactPageTest extends BaseClass
{
LoginPage loginpage;
HomePage homepage;
ContactPage contactpage;
@BeforeMethod
public void initialize() throws Throwable
{

	launch_Browser();
	loginpage=new LoginPage();
	homepage=loginpage.login(UN, PWD);
	homepage = new HomePage();
	contactpage=homepage.navigateToContacts();
	Thread.sleep(2000);
	
}

@Test(priority=1,enabled=true)
public void verfiyTitle() throws Throwable
{
  
  String actual=contactpage.fetchtitle();
  String expected ="Cogmento CRM";
  Assert.assertEquals(actual, expected,"Contact Page title is not matching");

 
}
@DataProvider
@Test
public Object[][] getCRMtestdata()
{
	
	Object data[][]=TestDataExcel.getExceldata("contact");
     return data;
}



@Test(priority=2,dataProvider="getCRMtestdata",enabled=true)
public void addContactTest(String FirstName, String LastName , String Email, String city) throws Throwable
{
 contactpage.addContact(FirstName, LastName,Email,city);
 Thread.sleep(3000);
 boolean result=contactpage.serchContact(FirstName);
 Assert.assertTrue(result,"Contact is not saved"); 
}



@Test(priority=3,enabled=true,dataProvider="getCRMtestdata")
public void deleteContactTest(String FirstName, String LastName , String Email, String city) throws Throwable
{
	contactpage.deleteContact(FirstName,LastName);
	Thread.sleep(2000);
	boolean contactDeleted =contactpage.serchContact(FirstName);
	Assert.assertFalse(contactDeleted, "Contact is not deleted");
}


@AfterMethod
public void terminate()
{
	driver.close();
}
}
