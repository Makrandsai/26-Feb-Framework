package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.checkerframework.checker.units.qual.s;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.DashboradPage;
import Pages.LoginPage;
import net.bytebuddy.asm.Advice.This;

public class SoftAssertionTest extends TestBase {

	
	DashboradPage dash ;
	LoginPage login;
    @BeforeMethod 
	
	public void setup() throws IOException, InterruptedException
	{
	  initalization();
	  login = new LoginPage();
	  dash = new DashboradPage();
	  login.Logintoapp();
	 
	}
	
	@Test 
	
	
	public void verifyusernametest() throws InterruptedException
	{
		
	    String value =	dash.verifyusername();
	   
		Assert.assertEquals(value, "Makrand Vasant Temkar");
		
	}
	

	@Test
	
	
	public void verifyemailtest() throws InterruptedException
	{
		String value =	dash.verifyemail();
		SoftAssert s = new SoftAssert();
		s.assertEquals(value, "makarandtemkar1333@gmail.com");
		s.assertAll();
	  //  Assert.assertEquals(value, "1makarandtemkar1333@gmail.com");
		
	}
	
	@Test (enabled = false)
	
	public void gttplaceorderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		dash.gttplaceorder();
		
	}
	
	@AfterMethod 
	
	public void exit()
	{
		
		driver.quit(); // for opera ,edge, firefox we use quit() method. .
	    //driver.close();
	}
	
	
	
	
}
