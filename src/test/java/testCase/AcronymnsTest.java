package testCase;

import org.testng.annotations.Test;

import pageObjects.Acronymns;
import pageObjects.BasePage;
import pageObjects.BeCognizantPage;
import pageObjects.stock;
import testBase.BaseClass;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


@Listeners(utilities.ExtentReportManager.class)
public class AcronymnsTest extends BaseClass {
  @Test(priority=1)

  public void UserInformation() {
	  

	  logger.info("**** starting Acronymns Test  *****");
		
	  logger.debug("application logs started......");
	  
	  
	  try {
		  
		  BeCognizantPage bc=new BeCognizantPage(driver);
		  logger.info("Clicking on profile");
		  
		  //clicking on cognizant profile
		  bc.profileClick();
		  logger.info("capturing user email");
		  
		  //capturing the user information
		  String mail=bc.getUserMail();
		  logger.info("capturing user name");
		  String name=bc.getUserName();
		  System.out.println("User Details:");
		  
		  System.out.println(mail);
		  System.out.println(name);
		  
		  //clicking on be.cognizant element
		  logger.info("Clicking on be.cognizant");
		  bc.BeCognizantClick();
		  Thread.sleep(2000);
	
		  //clicking on company element
		  logger.info("Clicking on company element");
		  bc.CompanyClick();
		  Thread.sleep(2000);
		  
		 //clicking on acronyms element
		  logger.info("Clicking on acronymns element");
		  bc.AcronymsClick();
		  Acronymns ac=new Acronymns(driver);
		  System.out.println("--------------------------------");
		  System.out.println("writting acronymns in excel sheet");
		  logger.info("writting acronymns elements");
		  
		  //writing acronyms in excel sheet
		  FileOutputStream file = new FileOutputStream("C:\\Users\\2308540\\Downloads\\CASproject\\CASproject\\testData\\data.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook();
		  XSSFSheet sheet = workbook.createSheet("Sheet1");
		
		  for(int row=1;row<=ac.getRowCount();row++) {
			  XSSFRow row1 = sheet.createRow(row);
				for(int col=1;col<=ac.getColCount();col++) {
					int col1 = 0;
					String val1 = driver.findElement(By.xpath("//table//tbody//tr[" + row + "]//td")).getText();
					row1.createCell(col1).setCellValue(val1);
					sheet.getRow(1);
					//taking screenshots of acronyms
					
					
					WebElement screen=driver.findElement(By.xpath("//tr["+row+"]"));
					File src =screen.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File("C:\\Users\\2308345\\eclipse-workspace\\CASproject\\screenshots\\table["+row+"].png"));
					
				}
				for (int col = 1; col <=ac.getColCount(); col++)
				{
					int col2 = 1;
					int tdEle = 2;
					String val2 = driver.findElement(By.xpath("//table//tbody//tr[" + row + "]//td[" + tdEle + "]")).getText();
					row1.createCell(col2).setCellValue(val2);

				}
				
		 }
		
		 workbook.write(file);
		 workbook.close();
		 file.close();
		 System.out.println("writting excel done");
		 System.out.println("--------------------------------");
		 logger.info("Clicking on be.cognizant");
		 bc.BeCognizantClick(); 
		 
		
	  }
	  catch(Exception e) {
		  logger.error("test failed..");
		  logger.debug("debug logs....");
		  Assert.fail();
		  
		  
	  }
	  logger.info("**** Finished Acronymns Test  ****");
  }
 

  
}