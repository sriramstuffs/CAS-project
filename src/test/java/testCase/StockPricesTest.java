package testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.stock;
import testBase.BaseClass;
@Listeners(utilities.ExtentReportManager.class)
public class StockPricesTest extends BaseClass{
	
	
	 @Test(priority=2)
	
  public void stockCheck() throws InterruptedException {
		 
		 logger.info("**** starting StockPrice Test  *****");
			
		 logger.debug("application logs started......");

	try {
		Thread.sleep(2000);
		
		//Scrolling over until end of page
		Actions a = new Actions(driver);
		WebElement until = driver.findElement(By.xpath("//div[@class=\"a_a_beed2cf1 c_a_beed2cf1 e_a_beed2cf1\"]"));
		WheelInput.ScrollOrigin scroll = WheelInput.ScrollOrigin.fromElement(until);
		a.scrollFromOrigin(scroll, 0, 3000).perform();
		Thread.sleep(2000);
		System.out.println("Stock Details:");
	    stock s=new stock(driver);
	    
	    //capturing cognizant stock prices
	    String cognizantstockprice=s.getBeCognizantStockPrice();
	    logger.info("retrieve be.cognizant stock");
	    System.out.println("--------------------------------");
		System.out.println("BE.COGNIZANT STOCK: "+cognizantstockprice);
		
		//getting cognizant stock price from google
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.google.com/");
		logger.info("retrieve google be.cognizant stock");
		s.searchGoogleStockPrice();
		a.sendKeys(Keys.ENTER).perform();

		String GCStock = s.getGoogleStockPrice();
		System.out.println("GOOGLE BE.COGNIZANT STOCK: "+GCStock );
		
        //checking cognizant stock matches with google cognizant stock price
		if(cognizantstockprice.equals(GCStock)) {
			System.out.println("stock prices matches");
			
		}
		else {
			System.out.println("stock prices doesnt matches");
		}
		
		
		//checking current cognizant prices with previous date
		s.YahooClick();
		s.HistoryClick();
		
		
		//checking with previous dates
		List <WebElement> previousStockValues = driver.findElements(By.xpath("//table//tbody//tr/td[5]//span")); 
		int count = 0;
        
		
		for (int i = 1; i<=previousStockValues.size(); i++) {
			String var = previousStockValues.get(i).getText();
			if (var.equals(GCStock)) {
					System.out.println("found");
					count = 1;
					break;
				}
			
		}
		if(count != 1) {
			System.out.println("previous stock is not matching with current stock");
		
		}
		
		s.SummaryClick();
		
		//capturing cognizant market capitalization
		String MarketCap=s.MarketCap();
		System.out.println("MarkCap: "+MarketCap);
		
	}
	catch(Exception e) {
		logger.error("test failed..");
		logger.debug("debug logs....");
		Assert.fail();
	}
	logger.info("**** Finished StockPrice Test  ****");
	  
  }
}