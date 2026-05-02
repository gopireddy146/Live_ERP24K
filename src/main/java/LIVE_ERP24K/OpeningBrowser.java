package LIVE_ERP24K;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class OpeningBrowser
{
	public static WebDriver driver;
	 @BeforeMethod
	  public void beforeMethod() throws InterruptedException 
	  {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\BROWSERS\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 Thread.sleep(2000);
		 
		 
	   }

 
        @AfterClass
        public void afterClass()
        {
     	// driver.quit();
        }

}
