package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	  public static String getTD(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
  	{
  		FileInputStream file = new FileInputStream("src\\test\\resources\\Testdata\\bookmyhsow.xlsx");
  		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
  	    Cell cell=sh.getRow(rowIndex).getCell(cellIndex);
  	 	
  	    try {
  	 		String value=cell.getStringCellValue();
  	 		return value;
  	 	}
  	 	catch(IllegalStateException e)
  	 	{
  	 		double value_1=cell.getNumericCellValue();
  	 		String str=String.valueOf(value_1);
  	 		return str;
  	   }
  	}

	
	public static void captureScreenShot(WebDriver driver, int testcaseID) {
			Date date=new Date();
			String currenttime =date.toString().replace(":", " ").replace(" ", "-");
			
			TakesScreenshot ss=(TakesScreenshot) driver;
			File src=ss.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\selenium project\\failTestcases\\bookmyshow\\Test-"+testcaseID+"-"+currenttime+".jpeg");
	        try
	        {
	        	FileHandler.copy(src, dest);
	        }
	        catch(Exception e)
	        {
	        	e.getMessage();
	        }


	      //  test-output\Failed testcase screenshot
	      
}
}