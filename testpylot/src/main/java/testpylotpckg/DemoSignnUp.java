package testpylotpckg;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSignnUp {

WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pylot.pwa.corralive.com/");
		
		
	}
	
	 @Test(dataProvider="LoginData")
		public void signup(String fname,String lname,String email,String password) throws NoSuchElementException, InterruptedException
		{
		  WebElement accnt=driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link UserNav_avatarButton__Zw5Lk']"));
	      accnt.click();
		 driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link Auth_signup-link__c4lwY signup-link']")).click();
		 driver.findElement(By.id("fname")).sendKeys(fname);
		 driver.findElement(By.id("lname")).sendKeys(lname);
		 driver.findElement(By.id("signup-email")).sendKeys(email);
		 driver.findElement(By.id("signup-password")).sendKeys(password);
		 driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_slim__BbESG btn-slim']")).click();
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//ul[@class='UserNav_list__dJ5pz']/li[3]/div/button")).click();
 		 Thread.sleep(10000);
 		 driver.findElement(By.xpath("//ul[@class='DropdownMenu_dropdownMenu__2ewYO animate-fade-in-up']/li[7]")).click();
 		 Thread.sleep(10000);
	    }
		
	 
	 @DataProvider(name="LoginData")
	public String [][] getData() throws IOException
		{
			String path=".\\datafile\\SignUpDetails.xlsx";
			Utilityclass util=new Utilityclass(path);
			
			int totalrows=util.getRowCount("Sheet2");
			int totalcols= util.getCellCount("Sheet2",1);
			
			String loginData[][]=new String[totalrows][totalcols];
			
			for(int i=1;i<=totalrows;i++)
			{
				for(int j=0;j<totalcols;j++)
				{
				 loginData[i-1][j]=util.getCellData("Sheet2",i,j);
				}
			}
					
			return loginData;
		}
		
		@AfterClass
		public void teardown()
		{
			driver.quit();
		}

}
