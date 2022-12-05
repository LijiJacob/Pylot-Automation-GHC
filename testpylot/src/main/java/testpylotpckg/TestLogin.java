package testpylotpckg;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {

	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
    @Test(dataProvider="LoginData")
	public void login(String user,String pwd,String exp,String fname,String lname) throws Throwable
	{
    	driver.get("https://pylot.pwa.corralive.com/");
    	//Thread.sleep(10000);
		 WebElement button= driver.findElement(By.xpath("//ul[@class='UserNav_list__dJ5pz']/li[3]/button/span"));
	     button.click();
	     
	     driver.findElement(By.id("email")).sendKeys(user);
	     
	     driver.findElement(By.id("password")).sendKeys(pwd);
	     
	     driver.findElement(By.xpath("//*[text() = 'Log In']")).click(); 
	   //  WebElement form=driver.findElement(By.xpath("//div[@class='Auth_login-view-form__97bEH login-form']"));
	     	
	     try
	     {
	     if(exp.equals("Valid"))
	     {
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//button[@aria-label='Menu']")).click();  
			  Thread.sleep(10000);
			  WebElement myaccnt=driver.findElement(By.xpath("//ul[@class='DropdownMenu_dropdownMenu__2ewYO animate-fade-in-up']/li[2]/div/a"));
				 myaccnt.click();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@class='newsletter-container box-info']/div/a")).click();
				 Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@id='subscription']")).click();
				 Thread.sleep(10000);
				 driver.findElement(By.xpath("//button[@class='Button_root__ROU4q']")).click();
				// WebElement accnt=driver.findElement(By.xpath("//nav[@class='UserNav_root__7GZb3']/ul/li[3]/div/button"));
				    myaccnt.click();
				    Thread.sleep(10000);
					driver.findElement(By.xpath("//ul[@id='dropdown-menu']/li[7]/button/span")).click();
					Thread.sleep(10000);
					driver.findElement(By.xpath("//div[@class='Modal_modal__i2ht0 modal-wrapper']/div/button[@class='Button_root__ROU4q Button_link__duEn_ btn-link Modal_close-panel__H4WVz close-panel']"));
			        //Assert.assertTrue(true);
	     }
	     
	     else if(exp.equalsIgnoreCase("Invalid"))
	     {
	    	 
	    	Thread.sleep(10000);
	      driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
	      driver.findElement(By.id("fname")).sendKeys(fname);
		  driver.findElement(By.id("lname")).sendKeys(lname);
		  driver.findElement(By.id("signup-email")).sendKeys(user);
		  driver.findElement(By.id("signup-password")).sendKeys(pwd);
		  WebElement signup=driver.findElement(By.xpath("//*[text()='Sign Up']"));
		  signup.click();
		 
		  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Menu']")));
		  driver.findElement(By.xpath("//nav[@class='UserNav_root__7GZb3']/ul/li[3]/div/button")).click();
		  
		  Thread.sleep(100);
			driver.findElement(By.xpath("//ul[@id='dropdown-menu']/li[7]/button/span")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='Modal_modal__i2ht0 modal-wrapper']/div/button[@class='Button_root__ROU4q Button_link__duEn_ btn-link Modal_close-panel__H4WVz close-panel']"));
		  
	     }
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }
	     
	}
	 
	@DataProvider(name="LoginData")
	
	public String [][] getData() throws Throwable
	{
		String path=".\\datafile\\TestData.xlsx";
		Utilityclass util=new Utilityclass(path);
		
		int totalrows=util.getRowCount("Sheet1");
		int totalcols= util.getCellCount("Sheet1",1);
		
		String loginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
			 loginData[i-1][j]=util.getCellData("Sheet1", i, j);
			}
		}
				
		return loginData;
	}
	
	
	}
	
	



