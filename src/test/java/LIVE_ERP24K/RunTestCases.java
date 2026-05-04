package LIVE_ERP24K;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

public class RunTestCases extends OpeningBrowser {
  @Test
  public void toRunTestCases() throws InterruptedException, IOException, AWTException {
	  
	  ScriptingCode code = new ScriptingCode();
	    code.login();
	    code.inventory();
	   // code.singlegenerateBarcode_Wt();
	     code.multiplegenerateBarcode_Wt();
	  //  code.dashboard();
//	   code.Estimation();
//	   code.more();
//	    code.master();
//	    code.addPurity();
//	   code.price();
	 //  code.Schemes();
	   
	  
	    
	  
	  
	  
  }

}
