package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BeCognizantPage extends BasePage {
  

	public WebDriver driver;

	public BeCognizantPage(WebDriver driver){

		super(driver);
 
	}
	
	@FindBy(id="O365_MainLink_MePhoto") WebElement logo;
	
	@FindBy(id="mectrl_currentAccount_secondary") WebElement usermail;
	

	
	@FindBy(id="mectrl_currentAccount_primary") WebElement username ;

	@FindBy(xpath="//span[contains(text(),'be.cognizant')]") WebElement becognizant;
	
	@FindBy(xpath="//span[contains(text(),'Company')]") WebElement company;
	
	@FindBy(xpath="//span[contains(text(),'Acronyms')]") WebElement acronyms;

	public void profileClick() {

		logo.click();
	}

	public String getUserMail() {

		return usermail.getText();
	}

	public String getUserName() {

		 return username.getText();
	}
	public void BeCognizantClick() {

		becognizant.click();
	}
	public void CompanyClick() {

	    company.click();
	}
	public void AcronymsClick() {

		 acronyms.click();
	}
}

