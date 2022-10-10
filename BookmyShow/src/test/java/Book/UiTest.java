package Book;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestBookmyshow.Uipom;
import utils.Utility;

public class UiTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium project\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://in.bookmyshow.com/");
         
        Uipom uipom=new Uipom(driver); 
        uipom.selectLocationPune();
        uipom.searchFeild();
        uipom.enterMovieName(Utility.getTD(0, 1));
        uipom.selectminion();
        
	}

}
