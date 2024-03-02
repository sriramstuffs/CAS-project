package testBase;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
 
 
public class BaseClass {
	
	
	   static public WebDriver driver;
	 
		public Logger logger;
		public Properties p;
	
	@Parameters({"browser"})
	@BeforeClass

	
	 public void setup(@Optional("edge")String br) throws InterruptedException, IOException {
		logger=LogManager.getLogger(this.getClass());
		FileReader file=new FileReader("C:\\Users\\2308540\\Downloads\\CASproject\\CASproject\\src\\test\\resources\\config.properties");
		
		p=new Properties();
		p.load(file);
		
		
		switch(br.toLowerCase()) {
			case "chrome": driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			default: System.out.println("No matching browser..");
			 return;
		}
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Thread.sleep(7000);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public String captureScreen(String tname) throws IOException {
		 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
 
	}
}