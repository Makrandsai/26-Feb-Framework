package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboradPage;
import Pages.LoginPage;
import net.bytebuddy.asm.Advice.This;

public class DashboradPageTest extends TestBase {

	
	DashboradPage dash ;
	LoginPage login;
	
    @BeforeMethod (groups = "Sanity")
	
	public void setup() throws IOException, InterruptedException
	{
	  initalization();
	  login = new LoginPage();
	  dash = new DashboradPage();
	  login.Logintoapp();
	 
	}
	
	@Test (groups = "Sanity")
	
	
	public void verifyusernametest() throws InterruptedException
	{
		
	    String value =	dash.verifyusername();
		Assert.assertEquals(value, "Makrand Vasant Temkar");
	}
	

	@Test(enabled = false)
	
	
	public void verifyemailtest() throws InterruptedException
	{
	String value =	dash.verifyemail();
	Assert.assertEquals(value, "makarandtemkar1333@gmail.com");
		
	}
	
	@Test (invocationCount = 4)
	
	public void gttplaceorderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		dash.gttplaceorder();
		
	}
	
	@AfterMethod (groups = "Sanity")
	
	public void exit()
	{
		
		  driver.quit(); // for opera ,edge, firefox we use quit() method. .
	    //driver.close();
	}
	
}
