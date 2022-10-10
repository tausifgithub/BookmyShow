package TestBookmyshow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Uipom {
	@FindBy (xpath="//img[@alt='PUNE']")
	private WebElement selectPune;
	
	@FindBy (xpath  ="//span[@id='4']")
    private WebElement searchField;
	
	@FindBy (xpath  ="//input[@autocomplete='off']")
    private WebElement searchmovie;
	
	@FindBy (xpath  ="(//div[@class='sc-bOCYYb eRsEwz'])[2]")
    private WebElement minionsMovie;
	
	
public Uipom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	


   public void selectLocationPune()
   {
	   selectPune.click();
   }
   
   public void searchFeild()
   {
	   searchField.click();
   }
   
   public void enterMovieName(String moviename)
   {
	   searchmovie.sendKeys(moviename);
   }
   
   public void selectminion()
   {
	   minionsMovie.click();
   }
   

}
