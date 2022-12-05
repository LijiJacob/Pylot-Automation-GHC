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

public class DemoLogin {

WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pylot.pwa.corralive.com/");
		WebElement accnt=driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link UserNav_avatarButton__Zw5Lk']"));
    	accnt.click();
		
	}
	
	 @Test(dataProvider="LoginData")
		public void login(String user,String pwd,String exp) throws NoSuchElementException, InterruptedException
		{
		 	
	    	driver.findElement(By.id("email")).sendKeys(user);
	    	
	    	driver.findElement(By.id("password")).sendKeys(pwd);
	    	driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_slim__BbESG btn-slim']")).click();
	    	Thread.sleep(10000);
	    	if(exp.equalsIgnoreCase("Valid"))	
	    	{
	    		Thread.sleep(10000);
	    		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link DropdownMenu_avatarButton__qq1X_']")).click();
	    		WebElement myaccnt= driver.findElement(By.xpath("//ul[@class='DropdownMenu_dropdownMenu__2ewYO animate-fade-in-up']/li[2]/div/a"));
	    		myaccnt.click();
	    		Thread.sleep(10000);
	    		driver.findElement(By.xpath("//div[@class='newsletter-container box-info']/div/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='subscription']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class='Button_root__ROU4q']")).click();
				Thread.sleep(10000);
	    		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link DropdownMenu_avatarButton__qq1X_']")).click();
	    		Thread.sleep(10000);
	    		driver.findElement(By.xpath("//ul[@class='DropdownMenu_dropdownMenu__2ewYO animate-fade-in-up']/li[7]")).click();
	    		Thread.sleep(10000);
	    		
	    	}
	    	else if(exp.equalsIgnoreCase("Invalid"))
	    	{
	    		//Thread.sleep(1000);
	    		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link Auth_message-txt__dDVdk']")).click();
	    		Thread.sleep(10000);
	    		WebElement emailid=driver.findElement(By.xpath("//input[@class='Input_root__uxPWX']"));
	    		emailid.clear();
	    		emailid.sendKeys(user);
	    		Thread.sleep(1000);
	    		WebElement recoverbtn=driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_slim__BbESG btn-slim']"));
	    		recoverbtn.click();
	    		
	    	}
		}
	 
	 @DataProvider(name="LoginData")
	public String [][] getData() throws IOException
		{
			String path=".\\datafile\\LoginDetails.xlsx";
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
