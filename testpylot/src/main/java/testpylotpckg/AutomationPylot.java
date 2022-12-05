package testpylotpckg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPylot {

WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(" https://pylot.pwa.corralive.com/");
		driver.manage().window().maximize();
			
	}
	
	@Test(priority=1)
	public void login() 
	{
		  WebElement button= driver.findElement(By.xpath("//*[@class= 'Button_root__ROU4q Button_link__duEn_ btn-link UserNav_avatarButton__9exMf']"));
	      button.click();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		  driver.findElement(By.id("email")).sendKeys("ljacob@corra.com");
	      driver.findElement(By.id("password")).sendKeys("Cloudy76F");
	      driver.findElement(By.xpath("//*[text() = 'Log In']")).click();
	      driver.findElement(By.xpath("//button[@aria-label='Menu']")).click();  
	}
	
	@Test(priority=2)
	public void newsletter() throws Throwable
	{
		 WebElement myaccnt=driver.findElement(By.xpath("//nav[@class='UserNav_root__7GZb3']/ul/li[3]/div/ul/li[2]/div/a"));
	     myaccnt.click();
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//div[@class='newsletter-container box-info']/div/a")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@class='checkbox-container']/input[@id='subscription']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[@class='Button_root__ROU4q']")).click();
	}
	
    @Test(priority=3)
	public void first_address() throws Throwable
	{
    	
		driver.findElement(By.xpath("//div[@class='Account_account-container__YoAng']/div[2]/div/span[@class='Account_subhead-link__tbG0z account-subhead-link']")).click();
	    
	    WebElement add =driver.findElement(By.xpath("//div[@class='new-address']/button/span"));
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(10000));
	    wait4.until(ExpectedConditions.elementToBeClickable(add));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", add);
			 
		Thread.sleep(1000);
		WebElement fname =driver.findElement(By.xpath("//div[@class='form-grid-col']/div[2]/input[@id='firstname']"));
		fname.sendKeys("George") ;
		WebElement lname=driver.findElement(By.xpath("//div[@class='form-grid-col']/div[3]/input[@id='lastname']"));
		lname.sendKeys("Thomas");
		WebElement phone= driver.findElement(By.xpath("//div[@class='form-grid-col']/div[5]/input[@id='telephone']"));
		phone.sendKeys("5058364449");
		WebElement street= driver.findElement(By.xpath("//div[@class='form-grid-col']/div[2]/input[@id='street1']"));
		street.sendKeys("3401 Ladera Dr NW");	
		WebElement city=driver.findElement(By.xpath("//div[@class='form-grid-col']/div[4]/input[@id='city']"));
		city.sendKeys("Albuquerque");	
		WebElement zip=driver.findElement(By.xpath("//div[@class='form-inline-group']/div[2]/input[@id='postcode']"));
		zip.sendKeys("87120");
		WebElement state=driver.findElement(By.name("region"));
		Select se=new Select(state);
		se.selectByVisibleText("New York");
			
		WebElement saveaddress =driver.findElement(By.xpath("//div[@class='locate-btn-group']/button[@class='Button_root__ROU4q Button_primary__3sdwq btn-primary']"));
		WebDriverWait waitsave = new WebDriverWait(driver,Duration.ofSeconds(10000));
		waitsave.until(ExpectedConditions.elementToBeClickable(saveaddress));
		JavascriptExecutor executorsave = (JavascriptExecutor)driver;
		executorsave.executeScript("arguments[0].click();", saveaddress);	
	}
	
    @Test(priority=4)
	public void second_address() throws Throwable
	{
    	WebElement add =driver.findElement(By.xpath("//div[@class='new-address']/button/span"));
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(10000));
	    wait4.until(ExpectedConditions.elementToBeClickable(add));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", add);
			 
		Thread.sleep(1000);
		WebElement fname =driver.findElement(By.xpath("//div[@class='form-grid-col']/div[2]/input[@id='firstname']"));
		fname.sendKeys("Andrews") ;
		WebElement lname=driver.findElement(By.xpath("//div[@class='form-grid-col']/div[3]/input[@id='lastname']"));
		lname.sendKeys("George");
		WebElement phone= driver.findElement(By.xpath("//div[@class='form-grid-col']/div[5]/input[@id='telephone']"));
		phone.sendKeys("5058652020");
		WebElement street= driver.findElement(By.xpath("//div[@class='form-grid-col']/div[2]/input[@id='street1']"));
		street.sendKeys("1920 Main St NE");	
		WebElement city=driver.findElement(By.xpath("//div[@class='form-grid-col']/div[4]/input[@id='city']"));
		city.sendKeys("Los Lunas");	
		WebElement zip=driver.findElement(By.xpath("//div[@class='form-inline-group']/div[2]/input[@id='postcode']"));
		zip.sendKeys("87031");
		WebElement state=driver.findElement(By.name("region"));
		Select se=new Select(state);
		se.selectByVisibleText("New York");
			
		WebElement saveaddress =driver.findElement(By.xpath("//div[@class='locate-btn-group']/button[@class='Button_root__ROU4q Button_primary__3sdwq btn-primary']"));
		WebDriverWait waitsave = new WebDriverWait(driver,Duration.ofSeconds(10000));
		waitsave.until(ExpectedConditions.elementToBeClickable(saveaddress));
		JavascriptExecutor executorsave = (JavascriptExecutor)driver;
		executorsave.executeScript("arguments[0].click();", saveaddress);
	}
	
    @Test(priority=5)
	public void third_address() throws Throwable
	{
		WebElement add =driver.findElement(By.xpath("//div[@class='new-address']/button/span"));
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(10000));
	    wait4.until(ExpectedConditions.elementToBeClickable(add));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", add);
			 
		Thread.sleep(1000);
		WebElement fname =driver.findElement(By.xpath("//div[@class='form-grid-col']/div[2]/input[@id='firstname']"));
		fname.sendKeys("Thomas") ;
		WebElement lname=driver.findElement(By.xpath("//div[@class='form-grid-col']/div[3]/input[@id='lastname']"));
		lname.sendKeys("G");
		WebElement phone= driver.findElement(By.xpath("//div[@class='form-grid-col']/div[5]/input[@id='telephone']"));
		phone.sendKeys("5753364330");
		WebElement street= driver.findElement(By.xpath("//div[@class='form-grid-col']/div[2]/input[@id='street1']"));
		street.sendKeys("1028 New Mexico 48");	
		WebElement city=driver.findElement(By.xpath("//div[@class='form-grid-col']/div[4]/input[@id='city']"));
		city.sendKeys("Alto");	
		WebElement zip=driver.findElement(By.xpath("//div[@class='form-inline-group']/div[2]/input[@id='postcode']"));
		zip.sendKeys("88312");
		WebElement state=driver.findElement(By.name("region"));
		Select se=new Select(state);
		se.selectByVisibleText("New York");
			
		WebElement saveaddress =driver.findElement(By.xpath("//div[@class='locate-btn-group']/button[@class='Button_root__ROU4q Button_primary__3sdwq btn-primary']"));
		WebDriverWait waitsave = new WebDriverWait(driver,Duration.ofSeconds(10000));
		waitsave.until(ExpectedConditions.elementToBeClickable(saveaddress));
		JavascriptExecutor executorsave = (JavascriptExecutor)driver;
		executorsave.executeScript("arguments[0].click();", saveaddress);		
	}
	
    @Test(priority=6)
	public void editaddress() throws Throwable
	{
		 driver.findElement(By.xpath("//div[@class='Account_account-block-grid__SNMtr']/div[2]/div/div[2]/a")).click();
		 Thread.sleep(1000);
		 WebElement fname =driver.findElement(By.xpath("//div[@class='form-grid-col']/div[2]/input[@id='firstname']"));
		 fname.clear();
		 fname.sendKeys("George") ;
		 WebElement lname=driver.findElement(By.xpath("//div[@class='form-grid-col']/div[3]/input[@id='lastname']"));
		 lname.clear();
		 lname.sendKeys("Thomas");
		 WebElement phone= driver.findElement(By.xpath("//div[@class='form-grid-col']/div[5]/input[@id='telephone']"));
		 phone.clear();
		 phone.sendKeys("8765435678");
		 WebElement zip=driver.findElement(By.xpath("//div[@class='form-inline-group']/div[2]/input[@id='postcode']"));
		 zip.clear();
		 zip.sendKeys("23456");
		 WebElement saveaddress =driver.findElement(By.xpath("//div[@class='locate-btn-group']/button[@class='Button_root__ROU4q Button_primary__3sdwq btn-primary']"));
		 WebDriverWait waitsave = new WebDriverWait(driver,Duration.ofSeconds(10000));
		 waitsave.until(ExpectedConditions.elementToBeClickable(saveaddress));
		 JavascriptExecutor executorsave = (JavascriptExecutor)driver;
		 executorsave.executeScript("arguments[0].click();", saveaddress);
	}
    
    @Test(priority=7)
	public void browse() throws InterruptedException
	{
    	driver.get(" https://pylot.pwa.corralive.com/");
		driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[2]")).click();
		WebElement button= driver.findElement(By.linkText("LOAD MORE"));
		WebDriverWait waitload = new WebDriverWait(driver,Duration.ofSeconds(1000));
		waitload.until(ExpectedConditions.elementToBeClickable(button));
		JavascriptExecutor executorlink = (JavascriptExecutor)driver;
		executorlink.executeScript("arguments[0].click();", button); 
		 
		WebElement button1= driver.findElement(By.xpath("//div[@class='PlpSubcategories_plpSubcategory__aEl8D']/ul/li[1]/a"));
		WebDriverWait waitload1 = new WebDriverWait(driver,Duration.ofSeconds(1000));
		waitload1.until(ExpectedConditions.elementToBeClickable(button1));
		JavascriptExecutor executorlink1 = (JavascriptExecutor)driver;
		executorlink1.executeScript("arguments[0].click();", button1); 
		
		driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='Plpgrid_Plpgrid__e_t5w sm:grid-cols-4 grid-cols-2']/div[8]/a/div/span")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Swatch_root__LTKSi Swatch_circle__fQJcm Swatch_color__HDty7 Swatch_dark__d6yfk']")).click();
		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q PDP_add-to-cart-button__4FR37']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link CartSidebarView_cart-btn-close__zi1Ra close-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[1]")).click();
		driver.findElement(By.xpath("//div[@class='Plpgrid_Plpgrid__e_t5w sm:grid-cols-4 grid-cols-2']/div[4]/a/div/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='SwatchGroup_swatch-group__jFLg_']/span[2]/button")).click();
		driver.findElement(By.xpath("//div[@class='bg-white py-3']/div[2]/div[2]/span[2]/button")).click();
		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q PDP_add-to-cart-button__4FR37']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='Button_root__ROU4q Button_link__duEn_ btn-link CartSidebarView_cart-btn-close__zi1Ra close-btn']")).click();
	}
	
	@Test(priority=8) 
	public void filter() throws Throwable
	{
		WebElement filter=driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[3]"));
		filter.click();
		
		WebElement filterbutton= driver.findElement(By.xpath("//span[text()='Filter by']"));
		WebDriverWait filterwait = new WebDriverWait(driver,Duration.ofSeconds(1000));
		filterwait.until(ExpectedConditions.elementToBeClickable(filterbutton));
		JavascriptExecutor filterexecutorlink = (JavascriptExecutor)driver;
		filterexecutorlink.executeScript("arguments[0].click();", filterbutton); 
				
		WebElement filterbutton2= driver.findElement(By.xpath("//label[@class='FilterList_root-checkbox__BqE7_']/span/input[@id='product_checkbox_category_id_65_hr']"));
		WebDriverWait filterwait2 = new WebDriverWait(driver,Duration.ofSeconds(1000));
		filterwait2.until(ExpectedConditions.elementToBeClickable(filterbutton2));
		JavascriptExecutor filterexecutorlink2 = (JavascriptExecutor)driver;
		filterexecutorlink2.executeScript("arguments[0].click();", filterbutton2);
		
		WebElement filterbutton3= driver.findElement(By.xpath("//span[text()='Apply']"));
		WebDriverWait filterwait3 = new WebDriverWait(driver,Duration.ofSeconds(1000));
		filterwait3.until(ExpectedConditions.elementToBeClickable(filterbutton3));
		JavascriptExecutor filterexecutorlink3 = (JavascriptExecutor)driver;
		filterexecutorlink3.executeScript("arguments[0].click();", filterbutton3);
		
		WebElement filterbutton5= driver.findElement(By.xpath("//span[text()='Clear all']"));
		WebDriverWait filterwait5 = new WebDriverWait(driver,Duration.ofSeconds(1000));
		filterwait5.until(ExpectedConditions.elementToBeClickable(filterbutton5));
		JavascriptExecutor filterexecutorlink5 = (JavascriptExecutor)driver;
		filterexecutorlink5.executeScript("arguments[0].click();", filterbutton5);
	}
	
	@Test(priority=9)
	public void sort()
	{
		WebElement sort= driver.findElement(By.xpath("//div[@class='Toolbar_toggle-filters__JIZdV']/button[2]"));
		
		WebDriverWait sortwait = new WebDriverWait(driver,Duration.ofSeconds(1000));
		sortwait.until(ExpectedConditions.elementToBeClickable(sort));
		JavascriptExecutor sortexecutorlink = (JavascriptExecutor)driver;
		sortexecutorlink.executeScript("arguments[0].click();", sort);
		
		WebElement sortbutton1= driver.findElement(By.xpath("//span[text()='Price Low']"));
		WebDriverWait sortwait1 = new WebDriverWait(driver,Duration.ofSeconds(1000));
		sortwait1.until(ExpectedConditions.elementToBeClickable(sortbutton1));
		JavascriptExecutor sortexecutorlink1 = (JavascriptExecutor)driver;
		sortexecutorlink1.executeScript("arguments[0].click();", sortbutton1);
	}
	
	@Test (priority=10)
	public void loadmore()
	{
		WebElement button= driver.findElement(By.linkText("LOAD MORE"));
		WebDriverWait waitload = new WebDriverWait(driver,Duration.ofSeconds(1000));
		waitload.until(ExpectedConditions.elementToBeClickable(button));
		JavascriptExecutor executorlink = (JavascriptExecutor)driver;
		executorlink.executeScript("arguments[0].click();", button); 
		
	}
	
	@Test(priority=11)
	public void search()
	{
		WebElement search= driver.findElement(By.xpath("//nav[@class='UserNav_root__7GZb3']/ul/li[1]/button"));
		WebDriverWait searchwait = new WebDriverWait(driver,Duration.ofSeconds(1000));
	    searchwait.until(ExpectedConditions.elementToBeClickable(search));
	    JavascriptExecutor executorsearch = (JavascriptExecutor)driver;
	    executorsearch.executeScript("arguments[0].click();", search);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("jacket");
        driver.findElement(By.xpath("//div[@class='Navbar_search-display__qeScb animate-fade-in-down']/form/div/button")).click();
	}
	
	@Test(enabled=false)
	public void wishlist() throws Throwable
	{
		 
		driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[2]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='Plpgrid_Plpgrid__e_t5w sm:grid-cols-4 grid-cols-2']/div[1]/a/div")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='PDP_product-details__dGwkx']/div[4]/div/div[2]/span[2]")).click();
		driver.findElement(By.xpath("//div[@class='PDP_product-details__dGwkx']/div[4]/div[2]/div[2]/span[2]/button")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='PDP_wishlist-btn-container__ug5Sd']/div/div/div/div")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='Dropdown_dropdown-container__V6ZSB Wishlist_wishlist-dropdown__tqfGe animate-fade-in-up']/ul/li[2]/button")).click();
	
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='Confirm_modal-content__Dq49K modal-content']/form/div/input")).sendKeys("test");
		
		WebElement save =driver.findElement(By.xpath("//div[@class='Wishlist_btn-container__pVmRI']/button[1]"));
		WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(10000));
	    wait5.until(ExpectedConditions.elementToBeClickable(save));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", save);
	}
	
	@Test(priority=12)
	public void navigate() throws Throwable 
	 {		
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	    
			driver.findElement(By.xpath("//nav[@class='UserNav_root__7GZb3']/ul/li[3]/div/button")).click();
		    driver.findElement(By.xpath("//div[@class='Navbar_root__KPC00']/div/div/div/div/div[3]/div/ul/li[3]")).click();
		 
		  	driver.findElement(By.xpath("//div[@class='Plpgrid_Plpgrid__e_t5w sm:grid-cols-4 grid-cols-2']/div[7]/a/div")).click();
		    driver.findElement(By.xpath("//div[@class='PDP_product-details__dGwkx']/div[4]/div[2]/div[2]/span[3]/button")).click();
		  
		    driver.findElement(By.xpath("//button[@class='Button_root__ROU4q PDP_add-to-cart-button__4FR37']")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.xpath("//div[@class='CartSidebarView_root__Jv1Wj']/div/div[2]/button[@class='Button_root__ROU4q Button_primary__3sdwq btn-primary w-full']")).click();
		    
	 }
	
	@Test(priority=13)
	public void checkout() throws Throwable
	{
		    
		 WebElement ship=driver.findElement(By.xpath("//div[@class='Checkout_checkout-address-tiles__dgFKy']/div[4]/div/label/input[@name='shipping_address']"));
		 WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(1000));
	     wait2.until(ExpectedConditions.elementToBeClickable(ship));
	     JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", ship);
		
	      WebElement shipmethod =driver.findElement(By.xpath("//div[@class='Checkout_shipping-methods__SQTMw']/label[2]/input"));
	      WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(1000));
		  wait3.until(ExpectedConditions.elementToBeClickable(shipmethod));
		  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click();", shipmethod);
		      
		  WebElement paymethod =driver.findElement(By.xpath("//button[@class='Button_root__ROU4q TabContent_fade-button___tFWQ']"));
		  WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(10000));
	      wait4.until(ExpectedConditions.elementToBeClickable(paymethod));
		  JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		  executor2.executeScript("arguments[0].click();", paymethod);
			   
		  WebElement pay =driver.findElement(By.xpath("//div[@class='Checkout_payment-methods__KKfvS']/label[2]/input"));
		  WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(10000));
		  wait5.until(ExpectedConditions.elementToBeClickable(pay));
		  JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		  executor3.executeScript("arguments[0].click();", pay);
			
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@id='sameAsShipping']"));
			      
		  WebElement place= driver.findElement(By.xpath("//div[@class='Checkout_place-order__Z_P6l']/button[1]"));
		  WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(1000));
		  wait1.until(ExpectedConditions.elementToBeClickable(place));
		  JavascriptExecutor executors = (JavascriptExecutor)driver;
		  executors.executeScript("arguments[0].click();", place);
			  
	}
	@Test( priority=14)
	public void logout()
	{
		WebElement accnt=driver.findElement(By.xpath("//nav[@class='UserNav_root__7GZb3']/ul/li[3]/div/button"));
	    accnt.click();
		driver.findElement(By.xpath("//ul[@id='dropdown-menu']/li[7]/button/span")).click();
		driver.get("https://pylot.pwa.corralive.com/");
		
	}
	@AfterTest
	public void terminateBrowser()
	{
		driver.quit();
		
	}
}
