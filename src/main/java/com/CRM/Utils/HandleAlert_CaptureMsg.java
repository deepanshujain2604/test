package com.CRM.Utils;

import com.CRM.BaseClass.BaseClass;

public class HandleAlert_CaptureMsg extends BaseClass 
{
	public static void handleAlert(String alert) 
	{
      if(alert=="ok")
		driver.switchTo().alert().accept();
      else 
        driver.switchTo().alert().dismiss();
	}
}
