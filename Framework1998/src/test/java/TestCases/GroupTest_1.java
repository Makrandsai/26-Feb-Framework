package TestCases;

import java.io.IOException;
import java.security.PublicKey;
import java.util.concurrent.Flow.Publisher;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class GroupTest_1 extends TestBase {

	
	LoginPage login;
	@BeforeMethod (groups = "Sanity")
	
	public void setup() throws IOException
	{
		initalization();
		login =  new LoginPage();
	}
	@Test (groups = "Sanity")
	
	 public void verifytitletest()
	 {
		
		String title =login.verifytitle(); // here we need to compare the actul result with expceted
		
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
		
	 }
	  
	
	@Test (groups = "Sanity")
	
	public void verifykitelogoTest() throws InterruptedException
	{
		
    boolean	result =	login.verifykitelogo();
    Assert.assertEquals(result, true);
		
	}
	
	@Test (groups = "Regression")
	
	public void verifyzerodhalogoTest() throws InterruptedException
	{
		
	boolean	Result = login.verifyzerodhalogo();
		Assert.assertEquals(Result, true);
	}
	
	@Test (enabled = false, groups =  {"Sanity","Regression"})
	public void LogintoappTest() throws InterruptedException, IOException
	{
	   String nikename =login.Logintoapp();
		Assert.assertEquals(nikename, "Makrand");
	}
	
	@AfterMethod (groups = "Sanity")
	
	public void exit ()
	{
		//driver.close();
		driver.quit();
	}
	

}

