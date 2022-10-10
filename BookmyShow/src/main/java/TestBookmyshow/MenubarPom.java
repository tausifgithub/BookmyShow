package TestBookmyshow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenubarPom {
	
	@FindBy (xpath="//div[@class='sc-chbbiW fcsTnZ']")
	private WebElement menuButton;
	
	@FindBy (xpath="(//div[@class='sc-bZQynM sc-jrIrqw HDQsy'])[3]")
	private WebElement helpAndSupport;
	
	@FindBy (xpath="//input[@type='text']")
	private WebElement searchbar;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement searchLogo;
	
public MenubarPom(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
   }


public void clickOnMenuButton()
{
	menuButton.click();
}
	
	
public void clickhelp()
{
	helpAndSupport.click();
}
	
public void enterKeys()
{
	searchbar.sendKeys("why this kolavari");;
}
	
public void clickOnlogo()
{
	 searchLogo.click();
}
	
	
	
	
}
