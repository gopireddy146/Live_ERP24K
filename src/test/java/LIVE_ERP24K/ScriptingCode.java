package LIVE_ERP24K;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScriptingCode extends ReusedMethods {

    // --------- LOGIN ---------
    public void login() throws InterruptedException, IOException {
        driver.get("https://www.erp24k.com/auth/login");
        sleep(2);

        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("Vardhan1");
        sleep(1);
        action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        sleep(1);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password@123");
        sleep(1);
        action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        sleep(1);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CAPTCHA: ");
        String captcha = scanner.nextLine();

        driver.findElement(By.xpath("//input[@formcontrolname='captcha']")).sendKeys(captcha);
        sleep(2);

        action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        sleep(1);
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        sleep(2);

        List<WebElement> logoutBtn = driver.findElements(By.xpath("//button[text()='Log Out']"));
        if (!logoutBtn.isEmpty()) {
            logoutBtn.get(0).click();
            System.out.println("Logout button found and clicked");
        } else {
            System.out.println("Logout button not present, continuing...");
        }
    }

    // --------- DASHBOARD ---------
    public void dashboard() throws InterruptedException {
        sleep(2);
        driver.findElement(By.xpath("//*[@id=\"kt_body\"]/app-banner/div/div/div[2]/button")).click();
    }

    // --------- INVENTORY ---------
    public void inventory() throws InterruptedException {
        sleep(1);
        Actions action = new Actions(driver);
        WebElement inventory = driver.findElement(By.xpath("//span[text()='Inventory']"));
        action.moveToElement(inventory).pause(Duration.ofSeconds(1)).click().perform();
    }

 // --------- SINGLE GENERATE BARCODE (Weight) ---------
    public void singlegenerateBarcode_Wt() throws InterruptedException, AWTException {
        Actions action = new Actions(driver);

        WebElement inventory = driver.findElement(By.xpath("//button[text()='Generate Barcode (Wt)']"));
        action.moveToElement(inventory).pause(Duration.ofSeconds(2)).click().perform();

        // Supplier
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Kalyan Raj");
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);

        // Group
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Silver");
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);

        // Purity
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("800");
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);

        // Product
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Jewel Set");
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,330)");
        sleep(1);
        // buying V/A%
        driver.findElement(By.xpath("//input[@placeholder='Enter Buying V/A%']")).sendKeys("0");
        sleep(1);
        
        // gross weight
        driver.findElement(By.xpath("(//input[@placeholder='Enter Gross Weight'])[1]")).sendKeys("16.43");
        sleep(1);
        
       //Stone weight
        WebElement stoneWeight = driver.findElement(By.xpath("//input[@formcontrolname='stoneWeight']"));
        action.moveToElement(stoneWeight).pause(Duration.ofSeconds(2)).click().perform();
        sleep(2);
         // .....................ADD STONE DETAILS....................
        // ----- STONE 1 -----
        WebElement selectStone1 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
        action.moveToElement(selectStone1).pause(Duration.ofSeconds(2)).sendKeys("Purple stone").perform();
        sleep(1);
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);
        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
        sleep(1);
        driver.findElement(By.xpath("//input[@formcontrolname='weightInGram']")).sendKeys("0.5");
        sleep(1);
        driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
        WebElement addbutton1 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
        action.moveToElement(addbutton1).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);

        // ----- STONE 2 -----
        WebElement selectStone2 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
        action.moveToElement(selectStone2).pause(Duration.ofSeconds(2)).sendKeys("Black Stone").perform();
        sleep(1);
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);
        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
        sleep(1);
        driver.findElement(By.xpath("//input[@formcontrolname='weightInCarat']")).sendKeys("2");
        sleep(1);
        driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
        sleep(1);
        WebElement addbutton2 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
        action.moveToElement(addbutton2).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);

        // ----- STONE 3 -----
        WebElement selectStone3 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
        action.moveToElement(selectStone3).pause(Duration.ofSeconds(2)).sendKeys("White Stones").perform();
        sleep(1);
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);
        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
        sleep(1);
        driver.findElement(By.xpath("//input[@formcontrolname='weightInGram']")).sendKeys("2");
        sleep(1);
        driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
        WebElement addbutton3 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
        action.moveToElement(addbutton3).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);
        
        WebElement close = driver.findElement(By.xpath("//button[@class='btn-close']"));
        action.moveToElement(close).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);
     // .....................ADD STONE DETAILS....................     */
        
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,410)");
      
        // Pieces
        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[1]")).sendKeys("2");
        sleep(1);
        
        // buying stone charges
        driver.findElement(By.xpath("//input[@placeholder='Enter Buying Stone Charges']")).sendKeys("0");
        sleep(1);
      
        /*  // stone charges
         driver.findElement(By.xpath("//input[@formcontrolname='stoneAmount']")).sendKeys("312");
         sleep(1);
         
         // HUID
        //  driver.findElement(By.xpath("//input[@placeholder='Enter HUID']")).sendKeys("577897");
        sleep(1);
        
       // other charges
        driver.findElement(By.xpath("//input[@formcontrolname='otherCharges']")).sendKeys("600");
        sleep(1);  */
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,280)");
        //gender
        driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();
        sleep(1);
        
  
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-410)");
        sleep(1);
        
        // media 1
        WebElement addMedia = driver.findElement(By.xpath("//p[text()='Click to upload']"));
        action.moveToElement(addMedia).pause(Duration.ofSeconds(2)).click().perform();

        StringSelection T = new StringSelection("C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\Media\\Images\\Gold\\Jewel Set1.png");
        Thread.sleep(2000);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(T, null);
        Robot paste = new Robot();
        paste.keyPress(KeyEvent.VK_CONTROL);
        paste.keyPress(KeyEvent.VK_V);
        paste.keyRelease(KeyEvent.VK_CONTROL);
        paste.keyRelease(KeyEvent.VK_V);
        sleep(2);
        paste.keyPress(KeyEvent.VK_ENTER);
        paste.keyRelease(KeyEvent.VK_ENTER);
        sleep(1);
        // media 2
        WebElement addMedia2 = driver.findElement(By.xpath("//p[text()='Click to upload']"));
        action.moveToElement(addMedia2).pause(Duration.ofSeconds(2)).click().perform();

        StringSelection T2 = new StringSelection("C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\Media\\Images\\Gold\\Jewel Set2.png");
        Thread.sleep(2000);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(T2, null);
        Robot paste2 = new Robot();
        paste2.keyPress(KeyEvent.VK_CONTROL);
        paste2.keyPress(KeyEvent.VK_V);
        paste2.keyRelease(KeyEvent.VK_CONTROL);
        paste2.keyRelease(KeyEvent.VK_V);
        sleep(2);
        paste2.keyPress(KeyEvent.VK_ENTER);
        paste2.keyRelease(KeyEvent.VK_ENTER);
        sleep(1);

        WebElement Scrolltosub = driver.findElement(By.xpath("//button[text()='Generate Barcode']"));

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", Scrolltosub);
        sleep(1);
        WebElement submit = driver.findElement(By.xpath("//button[text()='Generate Barcode']"));
        action.moveToElement(submit).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);
    }


    // --------- MULTIPLE GENERATE BARCODE (Weight) -------------------
    public void multiplegenerateBarcode_Wt() throws InterruptedException, AWTException {
        Actions action = new Actions(driver);

        for (int i = 1; i <= 31; i++) {
            System.out.println("Iteration: " + i);

            WebElement inventory = driver.findElement(By.xpath("//button[text()='Generate Barcode (Wt)']"));
            action.moveToElement(inventory).pause(Duration.ofSeconds(2)).click().perform();

            // Supplier
            driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Kalyan Raj");
            action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
            sleep(1);
            action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            sleep(1);

            // Group
            driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Silver");
            action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
            sleep(1);
            action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            sleep(1);

            // Purity
            driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("800");
            action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
            sleep(1);
            action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            sleep(1);

            // Product
            driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Jewel Set");
            action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
            sleep(1);
            action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            sleep(1);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,330)");
            sleep(1);
            // buying V/A%
            driver.findElement(By.xpath("//input[@placeholder='Enter Buying V/A%']")).sendKeys("0");
            sleep(1);
            
            // gross weight
            driver.findElement(By.xpath("(//input[@placeholder='Enter Gross Weight'])[1]")).sendKeys("16.43");
            sleep(1);
            
           //Stone weight
            WebElement stoneWeight = driver.findElement(By.xpath("//input[@formcontrolname='stoneWeight']"));
            action.moveToElement(stoneWeight).pause(Duration.ofSeconds(2)).click().perform();
            sleep(2);
             // .....................ADD STONE DETAILS....................
            // ----- STONE 1 -----
            WebElement selectStone1 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
            action.moveToElement(selectStone1).pause(Duration.ofSeconds(2)).sendKeys("Purple stone").perform();
            sleep(1);
            action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
            sleep(1);
            action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            sleep(1);
            driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
            sleep(1);
            driver.findElement(By.xpath("//input[@formcontrolname='weightInGram']")).sendKeys("0.5");
            sleep(1);
            driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
            WebElement addbutton1 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
            action.moveToElement(addbutton1).pause(Duration.ofSeconds(2)).click().perform();
            sleep(1);

            // ----- STONE 2 -----
            WebElement selectStone2 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
            action.moveToElement(selectStone2).pause(Duration.ofSeconds(2)).sendKeys("Black Stone").perform();
            sleep(1);
            action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
            sleep(1);
            action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            sleep(1);
            driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
            sleep(1);
            driver.findElement(By.xpath("//input[@formcontrolname='weightInCarat']")).sendKeys("2");
            sleep(1);
            driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
            sleep(1);
            WebElement addbutton2 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
            action.moveToElement(addbutton2).pause(Duration.ofSeconds(2)).click().perform();
            sleep(1);

            // ----- STONE 3 -----
            WebElement selectStone3 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
            action.moveToElement(selectStone3).pause(Duration.ofSeconds(2)).sendKeys("White Stones").perform();
            sleep(1);
            action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
            sleep(1);
            action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            sleep(1);
            driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
            sleep(1);
            driver.findElement(By.xpath("//input[@formcontrolname='weightInGram']")).sendKeys("2");
            sleep(1);
            driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
            WebElement addbutton3 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
            action.moveToElement(addbutton3).pause(Duration.ofSeconds(2)).click().perform();
            sleep(1);
            
            WebElement close = driver.findElement(By.xpath("//button[@class='btn-close']"));
            action.moveToElement(close).pause(Duration.ofSeconds(2)).click().perform();
            sleep(1);
         // .....................ADD STONE DETAILS....................     */
            
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,410)");
          
            // Pieces
            driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[1]")).sendKeys("2");
            sleep(1);
            
            // buying stone charges
            driver.findElement(By.xpath("//input[@placeholder='Enter Buying Stone Charges']")).sendKeys("0");
            sleep(1);
          
            /*  // stone charges
             driver.findElement(By.xpath("//input[@formcontrolname='stoneAmount']")).sendKeys("312");
             sleep(1);
             
             // HUID
            //  driver.findElement(By.xpath("//input[@placeholder='Enter HUID']")).sendKeys("577897");
            sleep(1);
            
           // other charges
            driver.findElement(By.xpath("//input[@formcontrolname='otherCharges']")).sendKeys("600");
            sleep(1);  */
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,280)");
            //gender
            driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();
            sleep(1);
            
      
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-410)");
            sleep(1);
            
            // media 1
            WebElement addMedia = driver.findElement(By.xpath("//p[text()='Click to upload']"));
            action.moveToElement(addMedia).pause(Duration.ofSeconds(2)).click().perform();

            StringSelection T = new StringSelection("C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\Media\\Images\\Gold\\Jewel Set1.png");
            Thread.sleep(2000);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(T, null);
            Robot paste = new Robot();
            paste.keyPress(KeyEvent.VK_CONTROL);
            paste.keyPress(KeyEvent.VK_V);
            paste.keyRelease(KeyEvent.VK_CONTROL);
            paste.keyRelease(KeyEvent.VK_V);
            sleep(2);
            paste.keyPress(KeyEvent.VK_ENTER);
            paste.keyRelease(KeyEvent.VK_ENTER);
            sleep(1);
            // media 2
            WebElement addMedia2 = driver.findElement(By.xpath("//p[text()='Click to upload']"));
            action.moveToElement(addMedia2).pause(Duration.ofSeconds(2)).click().perform();

            StringSelection T2 = new StringSelection("C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\Media\\Images\\Gold\\Jewel Set2.png");
            Thread.sleep(2000);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(T2, null);
            Robot paste2 = new Robot();
            paste2.keyPress(KeyEvent.VK_CONTROL);
            paste2.keyPress(KeyEvent.VK_V);
            paste2.keyRelease(KeyEvent.VK_CONTROL);
            paste2.keyRelease(KeyEvent.VK_V);
            sleep(2);
            paste2.keyPress(KeyEvent.VK_ENTER);
            paste2.keyRelease(KeyEvent.VK_ENTER);
            sleep(1);

            WebElement Scrolltosub = driver.findElement(By.xpath("//button[text()='Generate Barcode']"));

            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].scrollIntoView(true);", Scrolltosub);
            sleep(1);
            WebElement submit = driver.findElement(By.xpath("//button[text()='Generate Barcode']"));
            action.moveToElement(submit).pause(Duration.ofSeconds(2)).click().perform();
       

            sleep(2);
        }
    }

    // --------- MORE ---------
    public void more() throws InterruptedException, IOException {
        sleep(2);
        WebElement moreElement = driver.findElement(By.xpath("//span[text()='More']"));
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(moreElement).pause(Duration.ofSeconds(2)).click().build().perform();
        screenshot("More 4");
        sleep(2);
    }

    // --------- MASTER ---------
    public void master() throws InterruptedException, IOException {
        sleep(2);
        WebElement masterElement = driver.findElement(By.xpath("//span[text()='Master']"));
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(masterElement).pause(Duration.ofSeconds(2)).click().build().perform();
        sleep(2);
        screenshot("master5");
        sleep(2);
    }

    // --------- ADD PURITY ---------
    public void addPurity() throws InterruptedException, IOException {
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
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        sleep(3);
        screenshot("Purity_Saved_List6");
    }

    // --------- PRICE ---------
    public void price() throws InterruptedException {
        sleep(2);
        WebElement moreElement = driver.findElement(By.xpath("//span[text()='More']"));
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(moreElement).pause(Duration.ofSeconds(2)).click().build().perform();
        driver.findElement(By.xpath("//span[text()='Prices']")).click();
        sleep(2);
    }

}