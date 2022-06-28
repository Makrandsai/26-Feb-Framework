package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	

	// objcet repository
	@FindBy (xpath = "//img[@alt='Kite']") private WebElement kitelogo;
	@FindBy (xpath = "//img[@alt='Zerodha']") private WebElement zerodhalogo;
	
	@FindBy (xpath = "//input[@id ='userid']") private WebElement Useridtextbox;
	@FindBy (xpath = "//input[@id ='password']") private WebElement passwordtextBox;
	@FindBy (xpath = "//button[@type='submit']") private WebElement loginbtn;
	@FindBy (xpath = "//input[@id='pin']") private WebElement pintextbox;
	@FindBy (xpath = "//button[@type='submit']") private WebElement continouebtn;
	@FindBy (xpath = "//span[@class='nickname']") private WebElement nikenamelabel;
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle()   // make return type as string
	{
		return driver.getTitle();  // return type we use here
	}

	public Boolean verifykitelogo()
	{
		
	     return	kitelogo.isDisplayed();
	}
	
	public boolean verifyzerodhalogo()
	{
	    return	zerodhalogo.isDisplayed();
	
	}
	
	public String Logintoapp() throws InterruptedException, IOException
	{
		
	//	by using the config file address
		Thread.sleep(4000);
		Useridtextbox.sendKeys(setproperty("userid"));
		Thread.sleep(4000);
		passwordtextBox.sendKeys(setproperty("password"));
		Thread.sleep(4000);
		loginbtn.click();
		Thread.sleep(4000);
		pintextbox.sendKeys(setproperty("pin"));
		Thread.sleep(4000);
		continouebtn.click();
	    return nikenamelabel.getText();
	   
		//hard coded 
//		Thread.sleep(4000);
//		Useridtextbox.sendKeys("ML6794");
//		Thread.sleep(4000);
//		passwordtextBox.sendKeys("Omsairam@4598");
//		Thread.sleep(4000);
//		loginbtn.click();
//		Thread.sleep(4000);
//		pintextbox.sendKeys("040598");
//		Thread.sleep(4000);
//		continouebtn.click();
//		
		
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
