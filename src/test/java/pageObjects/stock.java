package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class stock extends BasePage {
	
	public WebDriver driver;
  

	public stock(WebDriver driver){

		super(driver);
 
	}
	
	
	
	

	@FindBy(className="stockValue_60e60a8c") WebElement becognizantstockprice;
	
	@FindBy(name="q") WebElement searchgooglestockprice;
	
	@FindBy(xpath="//span[@class=\"IsqQVc NprOob wT3VGc\"]") WebElement getgooglestockprice;
	
	@FindBy(xpath="//span[contains(text(),\"Summary\")]") WebElement summaryClick;
	
	
	@FindBy(xpath="//span[contains(text(),\"Historical Data\")]") WebElement historyClick;
	
	
	@FindBy(xpath=" //table[@class=\"W(100%) M(0) Bdcl(c)\"]//tbody//tr[1]//td[2]") WebElement marketcap;
	
	@FindBy(xpath="//table//tbody//tr/td[5]//span") List<WebElement> previoustockprice;
	
	@FindBy(xpath="//h3[@class='LC20lb MBeuO DKV0Md' and contains(text(),'CTSH - Cognizant Technology Solutions Corporation')]") WebElement yahoo;
	
	
	
	public void YahooClick() {

		yahoo.click();
	}
	
	public void HistoryClick() {

		historyClick.click();
	}
	

	public String getBeCognizantStockPrice() {
		return becognizantstockprice.getText();
	}
	
	public void searchGoogleStockPrice() {
		searchgooglestockprice.sendKeys("cognizant stock prices");
	}
	
	public String getGoogleStockPrice() {
		return getgooglestockprice.getText();
	}
	
	public void SummaryClick() {
		summaryClick.click();
	}
	
	public String  MarketCap() {
		
		return marketcap.getText();
	}
	
	
}
