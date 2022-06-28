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

public class DependsOnMethodTest extends TestBase {

	
	LoginPage login;
	@BeforeMethod
	
	public void setup() throws IOException
	{
		initalization();
		login =  new LoginPage();
	}
	@Test
	
	 public void verifytitletest()
	 {
		
		String title =login.verifytitle(); // here we need to compare the actul result with expceted
		
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
		
	 }
	
	// depends on method is false then other skip Not Failed
	// if depends method true then other will run otherwise skip
	@Test (dependsOnMethods = {"verifytitletest"})
	
	public void verifykitelogoTest() throws InterruptedException
	{
		
    boolean	result =	login.verifykitelogo();
    Assert.assertEquals(result, true);
		
	}
	
	@Test (dependsOnMethods = {"verifytitletest"})
	
	public void verifyzerodhalogoTest() throws InterruptedException
	{
		
	boolean	Result = login.verifyzerodhalogo();
		Assert.assertEquals(Result, true);
	}
	
	@Test (dependsOnMethods = {"verifytitletest"})
	public void LogintoappTest() throws InterruptedException, IOException
	{
	   String nikename =login.Logintoapp();
		Assert.assertEquals(nikename, "Makrand");
	}
	
	@AfterMethod
	
	public void exit ()
	{
		//driver.close();
		driver.quit();
	}
	
}
