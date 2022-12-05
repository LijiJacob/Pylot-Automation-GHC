package testpylotpckg;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logintest {

	WebDriver driver;
	
	 @BeforeTest
	 public void setup()
	 {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	 }
	
	 @Test
	 public void main() throws IOException
	 {
		 String excelfile=".\\datafile\\TestData.xlsx";
		 FileInputStream inputstream= new FileInputStream(excelfile);
		 
		 XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
		 XSSFSheet sheet= workbook.getSheet("Sheet1");
		 int rowcount= sheet.getLastRowNum();
		 System.out.println(rowcount);
		 
		 //int columncount= sheet.getRow(0).getLastCellNum();
		 
		 for(int i=1;i<rowcount+1;i++)
		 {
			 String Email=sheet.getRow(i).getCell(0).getStringCellValue();
			 System.out.println(Email);
			 
			 String Password=sheet.getRow(i).getCell(1).getStringCellValue();
			 System.out.println(Password);
			 
			 driver.get("https://pylot.pwa.corralive.com/");
			 WebElement button= driver.findElement(By.xpath("//*[@class= 'Button_root__ROU4q Button_link__duEn_ btn-link UserNav_avatarButton__9exMf']"));
		     button.click();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		     
		     WebElement mail= driver.findElement(By.id("email"));
		     mail.clear();
		     mail.sendKeys(Email);
		     
		     WebElement pass=driver.findElement(By.id("password"));
		     pass.clear();
		     pass.sendKeys(Password);
		     
		     driver.findElement(By.xpath("//*[text() = 'Log In']")).click();
		     
		     
		     String expectedmail= "ljacob@corra.com";
		     
		     String expectpass="Cloudy76F";
		     if((Email==expectedmail)&&(Password==expectpass))
		    		 {
		    	        System.out.print("Successful Login");
		    		 }
		     
		     else
		    	 System.out.print("Unsucessfull login");
		     		 }
		 workbook.close();
	 }
}
