package com.CRM.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.CRM.BaseClass.BaseClass;

public class SelectDropdown extends BaseClass
{
 
  public static void selectDropdownText(String Value)
  {
	  Select sel = new Select(driver.findElement(By.xpath("//button//i[@class='trash icon']")));
	 
	  sel.selectByVisibleText(Value);
  }

}
	


