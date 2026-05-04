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

/**
 * Beautified copy of ScriptingCode.java.
 * - Clean indentation
 * - Removed duplicate declarations and stray characters
 * - Kept original logic intact
 *
 * After verifying this file, you can replace the original ScriptingCode.java
 * with this content if desired.
 */
public class ScriptingCode_Beautified extends ReusedMethods {

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
        sleep(2);
        Actions action = new Actions(driver);
        WebElement inventory = driver.findElement(By.xpath("//span[text()='Inventory']"));
        action.moveToElement(inventory).pause(Duration.ofSeconds(3)).click().perform();
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
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Gold");
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);

        // Purity
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("22");
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);

        // Product
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Bracelet Gold");
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        // Gross Weight
        driver.findElement(By.xpath("(//input[@placeholder='Enter Gross Weight'])[1]")).sendKeys("3");
        sleep(1);
        // stone weight
        WebElement stoneWeight = driver.findElement(By.xpath("//input[@formcontrolname='stoneWeight']"));
        action.moveToElement(stoneWeight).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);
    // ............................Add Stone Details ............................
        // STONE 1
        // Select Stone
        WebElement selectStone1 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
        action.moveToElement(selectStone1).pause(Duration.ofSeconds(2)).sendKeys("Purple stone").perform();
        sleep(1);
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);
        // stone pieces
        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
        sleep(1);
        // stone weight in gram
        driver.findElement(By.xpath("//input[@formcontrolname='weightInGram']")).sendKeys("0.5");
        sleep(1);
        driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
        // add button
        WebElement addbutton1 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
        action.moveToElement(addbutton1).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);

        // STONE 2
     // Select Stone
        WebElement selectStone2 = driver.findElement(By.xpath("//div[text()='Select Stone']"));
        action.moveToElement(selectStone2).pause(Duration.ofSeconds(2)).sendKeys("Black Stone").perform();
        sleep(1);
        action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).perform();
        sleep(1);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        sleep(1);
     // stone pieces
        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[2]")).sendKeys("2");
        sleep(1);
     // stone weight in carat
        driver.findElement(By.xpath("//input[@formcontrolname='weightInCarat']")).sendKeys("2");
        sleep(1);
        driver.findElement(By.xpath("(//div[@class='modal-header'])[1]")).click();
        sleep(1);
        WebElement addbutton2 = driver.findElement(By.xpath("(//input[@value='Add'])[1]"));
        action.moveToElement(addbutton2).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);
       // close
        WebElement close = driver.findElement(By.xpath("//button[@class='btn-close']"));
        action.moveToElement(close).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);
        // ............................Add Stone Details ............................
        // pieces
        driver.findElement(By.xpath("(//input[@placeholder='Enter Pieces'])[1]")).sendKeys("2");
        sleep(1);
        // huid
        driver.findElement(By.xpath("//input[@placeholder='Enter HUID']")).sendKeys("577897");
        sleep(1);
        // stone charges
        driver.findElement(By.xpath("//input[@formcontrolname='stoneAmount']")).sendKeys("93.80");
        sleep(1);
        // gender
        driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();
        sleep(1);
         // media
        WebElement addMedia = driver.findElement(By.xpath("//p[text()='Click to upload']"));
        action.moveToElement(addMedia).pause(Duration.ofSeconds(2)).click().perform();

        StringSelection T = new StringSelection("C:\\Users\\user\\eclipse-workspace\\LIVE_ERP24K\\Media\\Images\\necklaces with ear rings.jpeg");
        Thread.sleep(2000);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(T, null);
        Robot paste = new Robot();
        paste.keyPress(KeyEvent.VK_CONTROL);
        paste.keyPress(KeyEvent.VK_V);
        paste.keyRelease(KeyEvent.VK_CONTROL);
        paste.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        paste.keyPress(KeyEvent.VK_ENTER);
        paste.keyRelease(KeyEvent.VK_ENTER);
        sleep(1);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)");
        sleep(1);
        WebElement submit = driver.findElement(By.xpath("//button[text()='Generate Barcode']"));
        action.moveToElement(submit).pause(Duration.ofSeconds(2)).click().perform();
        sleep(1);
    }

    // MULTIPLE GENERATE BARCODE (Weight)
    public void multiplegenerateBarcode_Wt() throws InterruptedException, AWTException {
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

            sleep(2);
        }
    }

    // MORE
    public void more() throws InterruptedException, IOException {
        sleep(2);
        WebElement moreElement = driver.findElement(By.xpath("//span[text()='More']"));
        sleep(2);
        Actions action = new Actions(driver);
        action.moveToElement(moreElement).pause(Duration.ofSeconds(2)).click().build().perform();
        screenshot("More 4");
        sleep(2);
    }

    // MASTER
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

    // ADD PURITY
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

    // PRICE
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
