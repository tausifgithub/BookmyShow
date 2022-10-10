package Book;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Setup.Base;
import TestBookmyshow.MenubarPom;
import TestBookmyshow.Uipom;
import utils.Utility;


public class TestngBookmyshow1 extends Base{
	private WebDriver driver;
	private MenubarPom menubarPom;
	private Uipom uipom;
	private SoftAssert soft;
	 
	  int testcaseID;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver=openFirefoxBrowser();	
		}
		if(browserName.equals("Opera"))
		 {
			 driver=openOperaBrowser();
		 }
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	 
	
	@BeforeClass
	public void createPOMObjects()
	{
		menubarPom=new MenubarPom(driver);
		uipom=new Uipom(driver);
		soft=new SoftAssert();
		
	}
	
	 @BeforeMethod
	 public void homePage()
	 {
		driver.get("https://in.bookmyshow.com/");
		String url=driver.getCurrentUrl();
		System.out.println(url);
		soft.assertEquals(url,"https://in.bookmyshow.com/");
		soft.assertAll();
		uipom.selectLocationPune();
	
	 }
	
	
	@Test
	public void searchMovie() throws EncryptedDocumentException, IOException
	{
	 testcaseID=100;
	 uipom.searchFeild();
	 uipom.enterMovieName(Utility.getTD(0, 1));
	 uipom.selectminion();
	String url= driver.getCurrentUrl();
	Assert.assertEquals(url, "https://in.bookmyshow.com/pune/movies/minions-the-rise-of-gru/ET00122133");
	 Assert.fail();
	}
	
	@AfterMethod
	public void logout(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("status failed ");
			Utility.captureScreenShot(driver, testcaseID );
		}
		System.out.println("after method");
	}
	
	@AfterClass
	public void cleanPOMobjects()
	{
		menubarPom=null;
		uipom=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{  
		driver.close();
		driver=null;
		System.gc();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
