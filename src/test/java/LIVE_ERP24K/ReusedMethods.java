package LIVE_ERP24K;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusedMethods extends RunTestCases {
  public void sleep(int toSleep) throws InterruptedException
  {
	  int toWait = toSleep*1000;
	  Thread.sleep(toWait);
  }
  
  
 
  
  
  
  
  
  public void screenshot(String sc) throws IOException 
  {
	  File source =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File Target = new File("C:\\Users\\user\\git\\ERP24K\\src\\data\\java\\TEST PROOFS\\"+sc+".jpg");
	  FileHandler.copy(source, Target);
	  /*
	  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\gopir\\eclipse-workspace\\Submit_Vehicle_Insurance_quote\\Screenshot\\"+sc+".jpg");
		Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
	  	  */
  }
  

  
  
  public void printUsingRobot(String p) throws AWTException, IOException {
	    // Create Robot instance
	    Robot robot = new Robot();

	    // Get full screen size
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Rectangle screenRect = new Rectangle(screenSize);

	    // Capture screen
	    BufferedImage screenCapture = robot.createScreenCapture(screenRect);

	    // Save screenshot to file
	    File file = new File("C:\\Users\\user\\git\\ERP24K\\src\\data\\java\\TEST PROOFS\\"+p+".png");
	    ImageIO.write(screenCapture, "png", file);
  }
  
  

}
