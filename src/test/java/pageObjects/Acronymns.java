package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Acronymns extends BasePage{
	public   WebDriver driver;

	public Acronymns(WebDriver driver){

		super(driver);
 
	}
	
	@FindBy(xpath="//table//tr")  List<WebElement>   tablerowsize;
	
	@FindBy(xpath="//table//tr[1]//td")   List<WebElement>  tablecolsize;
 
    public   int getRowCount() {
    	return tablerowsize.size();
    }
    public  int getColCount() {
    	return tablecolsize.size();
    }
   
  
	
	
}
