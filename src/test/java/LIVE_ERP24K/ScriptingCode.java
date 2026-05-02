package LIVE_ERP24K;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScriptingCode extends ReusedMethods{
	
	public void login() throws InterruptedException, IOException
	{         //........... LOGIN ........                      //........... LOGIN ........
		
	driver.get("https://www.erp24k.com/auth/login");
	//screenshot("login page 1");
    sleep(2);
	Actions action = new Actions (driver);

	driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("Vardhan1");
	 sleep(1);
	action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	 sleep(1);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password@123");
	 sleep(1);
	action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	 sleep(1);
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("Enter CAPTCHA: ");
	 String captcha = scanner.nextLine();

	 driver.findElement(By.xpath("//input[@formcontrolname='captcha']")).sendKeys(captcha);
	//driver.findElement(By.xpath("//input[@formcontrolname='captcha']")).sendKeys("123456");
	 sleep(2);
	//screenshot("Valid Credentials 2");
	 sleep(1);
	action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	 sleep(1);
	driver.findElement(By.xpath("//span[text()='Sign In']")).click();
	 sleep(2);
	// driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	 List<WebElement> logoutBtn = driver.findElements(By.xpath("//button[text()='Log Out']"));

	 if (!logoutBtn.isEmpty()) {
	     logoutBtn.get(0).click();
	     System.out.println("Logout button found and clicked");
	 } else {
	     System.out.println("Logout button not present, continuing...");
	 }
	
	 
	 // driver.findElement(By.xpath("//button[text()='Skip']")).click();
	/* List<WebElement> skipBtn = driver.findElements(By.xpath("//button[text()='Skip']"));

	 if (!skipBtn.isEmpty()) {
		 skipBtn.get(0).click();
	     System.out.println("Skip button found and clicked");
	 } else {
	     System.out.println("Skip button not present, continuing...");
	 }
	 
	*/
	// screenshot("Home page 3");
	
	
	}         //........... LOGIN ........                      //........... LOGIN ........
	
	
	
	 //........... DASHBOARD ........                      //........... DASHBOARD ........
	public void dashboard() throws InterruptedException
	{
		 sleep(2);
		 driver.findElement(By.xpath("//*[@id=\"kt_body\"]/app-banner/div/div/div[2]/button")).click();
		//button[text()='×']
	}   //........... DASHBOARD ........                      //........... DASHBOARD ........
	
	
	 //........... INVENTORY ........                      //........... INVENTORY ........
		public void inventory() throws InterruptedException
		{
			 sleep(2);
			 Actions action = new Actions (driver);
			
			 WebElement inventory = driver.findElement(By.xpath("//span[text()='Inventory']"));

			 action.moveToElement(inventory).pause(Duration.ofSeconds(3)).click().perform();
			 
			 // action.moveToElement(driver.findElement(By.xpath("//span[text()='Inventory']"))).click();
			 

		
		}    //........... INVENTORY ........                      //........... INVENTORY ........
	 
	
		
		//...........SINGLE GENERATE BARCODE WEIGHT ........                      //...........SINGLE GENERATE BARCODE WEIGHT ........
				public void singlegenerateBarcode_Wt() throws InterruptedException, AWTException
				{
					 Actions action = new Actions (driver);
						
					 WebElement inventory = driver.findElement(By.xpath("//button[text()='Generate Barcode (Wt)']"));

					 action.moveToElement(inventory).pause(Duration.ofSeconds(2)).click().perform();
					  driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(" Kalyan Raj");
						action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
				         sleep(1);
				         action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).click().perform();
				         sleep(1);
				         driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Gold");
							action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
					         sleep(1);
					         action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).click().perform();
					         sleep(1);
					         driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("24");
								action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
						         sleep(1);
						         action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).click().perform();
						         sleep(1);
						         driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Harram");
									action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
							         sleep(1);
							         action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).click().perform();
							         sleep(1);
							         ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
							         driver.findElement(By.xpath("(//input[@placeholder='Enter Gross Weight'])[1]")).sendKeys("3");
							         driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[1]")).sendKeys("2");
							         sleep(1);
							         WebElement addMedia = driver.findElement(By.xpath("//p[text()='Click to upload']"));
							         action.moveToElement(addMedia).pause(Duration.ofSeconds(2)).click().perform();
							           StringSelection T = new StringSelection("C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\Media\\Images\\necklaces with ear rings.jpeg"); //to find location
							           Thread.sleep(2000);
							    
							           Toolkit.getDefaultToolkit().getSystemClipboard().setContents(T, null);  // to copy 
							           Robot paste = new Robot();
							           paste.keyPress(KeyEvent.VK_CONTROL);
							           paste.keyPress(KeyEvent.VK_V);
							           paste.keyRelease(KeyEvent.VK_CONTROL);
							           paste.keyRelease(KeyEvent.VK_V);
							           Thread.sleep(2000);
							           paste.keyPress(KeyEvent.VK_ENTER);
							           paste.keyRelease(KeyEvent.VK_ENTER);
							           sleep(1);
							           ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,350)");
							           sleep(1);
							           
							           WebElement subbmit = driver.findElement(By.xpath("//button[text()='Generate Barcode']"));
								         action.moveToElement(subbmit).pause(Duration.ofSeconds(2)).click().perform();
								         sleep(1);
				
				}   //........... SINGLE GENERATE BARCODE WEIGHT ........                      //...........SINGLE GENERATE BARCODE WEIGHT ........
		
				
				
				//........... MULTIPLE GENERATE BARCODE WEIGHT ........                      //...........MULTIPLE GENERATE BARCODE WEIGHT ........
				public void multiplegenerateBarcode_Wt() throws InterruptedException, AWTException 
				{

				    Actions action = new Actions(driver);

				    for (int i = 1; i <= 10; i++) {

				        System.out.println("Iteration: " + i);

				        WebElement inventory = driver.findElement(By.xpath("//button[text()='Generate Barcode (Wt)']"));
				        action.moveToElement(inventory).pause(Duration.ofSeconds(2)).click().perform();

				        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Kalyan Raj");
				        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				sleep(1);

				        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Gold");
				        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				        sleep(1);
				        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("24");
				        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				        sleep(1);

				        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Harram");
				        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
				        sleep(1);

				        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

				        driver.findElement(By.xpath("(//input[@placeholder='Enter Gross Weight'])[1]")).sendKeys("3");
				        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[1]")).sendKeys("2");

				        sleep(1);

				        WebElement addMedia = driver.findElement(By.xpath("//p[text()='Click to upload']"));
				        action.moveToElement(addMedia).click().perform();

				        StringSelection T = new StringSelection("C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\Media\\Images\\necklaces with ear rings.jpeg");
				        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(T, null);

				        Robot paste = new Robot();
				        sleep(1);
				        paste.keyPress(KeyEvent.VK_CONTROL);
				        paste.keyPress(KeyEvent.VK_V);
				        paste.keyRelease(KeyEvent.VK_CONTROL);
				        paste.keyRelease(KeyEvent.VK_V);

				        sleep(1);
				        paste.keyPress(KeyEvent.VK_ENTER);
				        paste.keyRelease(KeyEvent.VK_ENTER);

				        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)");
				        sleep(1);
				        WebElement submit = driver.findElement(By.xpath("//button[text()='Generate Barcode']"));
				        action.moveToElement(submit).click().perform();

				        sleep(2);// wait for next cycle
				    }
				}  //........... MULTIPLE GENERATE BARCODE WEIGHT ........                      //...........MULTIPLE GENERATE BARCODE WEIGHT ........
				
				
		
		
		
		
		
		
		
		
		
		
		public void more() throws InterruptedException, IOException 
	{    //........... MORE ........                      //........... MORE ........
		
		    sleep(2);
			WebElement moreElement = driver.findElement(By.xpath("//span[text()='More']"));
			sleep(2);
			Actions action = new Actions(driver);
			action.moveToElement(moreElement).pause(2000).click().build().perform();
			screenshot("More 4");
			sleep(2);        
			//	action.moveToElement(driver.findElement(By.xpath("//span[text()='More']"))).pause(2000).click().build().perform();

	}    //........... MORE ........                      //........... MORE ........
	
	
	
	public void master() throws InterruptedException, IOException
	{        //........... MASTER ........                      //........... MASTER ........
		     sleep(2);
			WebElement masterElement = driver.findElement(By.xpath("//span[text()='Master']"));
			sleep(2);
			Actions action = new Actions(driver);
			action.moveToElement(masterElement).pause(2000).click().build().perform();
			sleep(2); 
			screenshot("master5");
			sleep(2); 
		
	
	}       //........... MASTER ........                      //........... MASTER ........

	
	
	public void addPurity() throws InterruptedException, IOException
	{        //........... ADD PURITY ........                      //........... ADD PURITY ........
		
		     driver.findElement(By.xpath("//button[text()=' + Add Purity ']")).click();
		     sleep(1);
		     driver.findElement(By.xpath("//input[@formcontrolname='purityValue']")).sendKeys("10karat");
		     sleep(1);
		     driver.findElement(By.xpath("//input[@formcontrolname='purityPercentage']")).sendKeys("58.12");
		     sleep(1);
		     driver.findElement(By.xpath("//input[@formcontrolname='shortForm']")).sendKeys("10k");
		     sleep(1);
		     driver.findElement(By.xpath("//input[@formcontrolname='vAPercentage']")).sendKeys("2");
		     sleep(1);
		     driver.findElement(By.xpath("//button[@type='submit'and@class='btn btn-primary']")).click();
		     sleep(1);
		     ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");  // scrolls down 500px
		     sleep(3);
		     screenshot("Purity_Saved_List6");
		 
	
	}       //........... ADD PURITY ........                      //........... ADD PURITY ........

	
	
	public void price() throws InterruptedException
	{
     		//........... PRICE ........                      //........... PRICE ........
		
		sleep(2);
		WebElement moreElement = driver.findElement(By.xpath("//span[text()='More']"));
		sleep(2);
		Actions action = new Actions(driver);
		action.moveToElement(moreElement).pause(2000).click().build().perform();
		driver.findElement(By.xpath("//span[text()='Prices']")).click();
		sleep(2);       
		
		
		
	     	//........... PRICE ........                      //........... PRICE ........
	}
	
    

	
	
}
