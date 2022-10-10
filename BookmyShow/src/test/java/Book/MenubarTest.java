package Book;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestBookmyshow.MenubarPom;
import TestBookmyshow.Uipom;

public class MenubarTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium project\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://in.bookmyshow.com/");
        
        Uipom uipom=new Uipom(driver); 
        uipom.selectLocationPune();
        
        MenubarPom menubarPom=new MenubarPom(driver);    
        menubarPom.clickOnMenuButton();
        menubarPom.clickhelp();
        System.out.println(driver.getCurrentUrl());
        menubarPom.enterKeys();
        System.out.println(driver.getCurrentUrl());
       
        System.out.println(driver.getCurrentUrl());
}
}