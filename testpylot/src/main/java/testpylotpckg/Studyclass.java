package testpylotpckg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Studyclass {

	WebDriver driver;
	AutomationPylot refobj= new AutomationPylot();
	 
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	}
	 
	@Test(dataProvider="LoginData")
	public void login(String user,String pwd,String exp) throws Throwable
	{
		 driver.get("https://pylot.pwa.corralive.com/");
		 
		 WebElement button= driver.findElement(By.xpath("//*[@class= 'Button_root__ROU4q Button_link__duEn_ btn-link UserNav_avatarButton__9exMf']"));
	     button.click();
	     
	     driver.findElement(By.id("email")).sendKeys(user);
	     
	     driver.findElement(By.id("password")).sendKeys(pwd);
	     
	     driver.findElement(By.xpath("//*[text() = 'Log In']")).click(); 
	     
	     if(exp.equals("valid"))
	     {
	    	  
	    	  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10000));
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Menu']")));
			  WebElement accnt=driver.findElement(By.xpath("//nav[@class='UserNav_root__7GZb3']/ul/li[3]/div/button"));
			  accnt.click();
			  refobj.newsletter();
			 driver.findElement(By.xpath("//div[@class='flex']/ul/li[7]/button")).click();
			  Assert.assertTrue(true);
	     }
	     
	}
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][] = { {"ljacob@corra.com", "Cloudy76F","Valid"},
				                 {"remya@corra.com","testing@123","Valid"},
				                 {"xyz@gmail.com","abc@123","Invalid"},
				                 {"abcdef@gmail.com","ghtry56","Invalid"},
				                 {"ljacob@corra.com","advbg","Invalid"},
				                 {"remya@corra.com","adfgt","Invalid"}}; */

		
		//to get data from excel
		String path=".\\datafile\\TestData.xlsx";
		Utilityclass util=new Utilityclass(path);
		
		int totalrows=util.getRowCount("Sheet1");
		int totalcols= util.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
			 loginData[i-1][j]=util.getCellData("Sheet1", i, j);
			}
		}
				
		return loginData;
	}
	
	}

