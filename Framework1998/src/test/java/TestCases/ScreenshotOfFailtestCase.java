package TestCases;

import java.io.IOException;
import java.security.PublicKey;
import java.util.concurrent.Flow.Publisher;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.Util1;
import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class ScreenshotOfFailtestCase extends TestBase {

	
	LoginPage login;
	@BeforeMethod
	
	public void setup() throws IOException
	{
		initalization();
		login =  new LoginPage();
	}
	@Test(enabled = true)
	
	 public void verifytitletest()
	 {
		
		String title =login.verifytitle(); // here we need to compare the actul result with expceted
		
		Assert.assertEquals("Kite1 - Zerodha's fast and elegant flagship trading platform", title);
		
	 }

	@AfterMethod
	
	public void exit (ITestResult  it) throws IOException
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			
			Util1.Screenshot(it.getName());
		}
		
		driver.quit();
	}
	
}

