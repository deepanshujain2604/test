package com.CRM.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataExcel 
{
 static Workbook wb; 
 static Sheet sh;
 public static Object[][] getExceldata (String sheetName) 
 {
	File file = new File("C:\\Users\\win 10\\eclipse-workspace\\Free_CRM_Automation\\src\\main\\java\\com\\CRM\\TestData\\CRMTestdata.xlsx");

		
		try {
			FileInputStream fis = new FileInputStream(file);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    sh=wb.getSheet(sheetName);
	    Row row=sh.getRow(0);
	    Cell col=row.getCell(0);
	    int totalRow=sh.getLastRowNum();
	    int totalCol =row.getLastCellNum();
	    
	    Object [][] data = new Object[totalRow][totalCol];
	    
	    for (int i=0;i<totalRow;i++)
	    	{
	    	for(int j=0;j<totalCol;j++)
		    	{
		    		data[i][j] = sh.getRow(i+1).getCell(j).toString();   		
		    	    //System.out.println(data[i][j]);
		    	}
	    	 }
	    	return data;
	    }       
	    
 
}

