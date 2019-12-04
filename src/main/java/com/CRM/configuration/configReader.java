package com.CRM.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader
{
Properties prop;
FileInputStream fi;
public configReader()
{
	try 
	{
		fi = new FileInputStream("C:\\Users\\win 10\\eclipse-workspace\\Free_CRM_Automation\\src\\main\\java\\com\\CRM\\configuration\\Free_Crm.properties");
		prop = new Properties();
		prop.load(fi);
	} catch (Exception e) {
	
	}
	
       
}
public String getURL()
{
return prop.getProperty("url");
}

public String getUN()
{
return(prop.getProperty("username"));	
}

public  String getPWD()
{
return(prop.getProperty("password"));	
}

public  String getBrowserName()
{
return(prop.getProperty("browser"));	
}
}