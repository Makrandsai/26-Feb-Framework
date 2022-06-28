package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DashboradPage extends TestBase {

	
	@FindBy (xpath ="//div[@class='avatar']") private WebElement avatrbtn;
	@FindBy (xpath ="//h4[@class='username']") private WebElement usernamelabel;
	@FindBy (xpath ="//div[@class='email']") private WebElement emaillabel;
	//@FindBy (xpath ="") private WebElement avatarbtn;
	
	
	
	@FindBy (xpath ="(//button[@type='button'])[1]") private WebElement startinvestingbtn;
	@FindBy (xpath ="(//input[@type='text'])[2]") private WebElement searchtextbox;
	@FindBy (xpath ="//li[@class='search-result-item selected']") private WebElement selectshare;
	@FindBy (xpath ="//button[text()='Create GTT ']") private WebElement creategttbtn;
	@FindBy (xpath ="//input[@label='Trigger price']") private WebElement triggerpriceTextbox;
	@FindBy (xpath ="//input[@label='Qty.']") private WebElement quantitytextbox;
	@FindBy (xpath ="//input[@label='Price']") private WebElement priceTextbox;
	@FindBy (xpath ="//div[text()='Place']") private WebElement placeorderbtn;
	
	
	
	
	
	public DashboradPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyusername() throws InterruptedException
	{
		
		avatrbtn.click();
		Thread.sleep(4000);
	    return usernamelabel.getText();
		
	}
	
	public String verifyemail() throws InterruptedException
	{
		avatrbtn.click();
		Thread.sleep(4000);
	    return 	emaillabel.getText();
	}
	
	public void gttplaceorder() throws InterruptedException, EncryptedDocumentException, IOException
	{
		startinvestingbtn.click();
		//Thread.sleep(4000);
		//searchtextbox.sendKeys("INFY");  //hardcodeed
		searchtextbox.sendKeys(readdatafromExcel(0, 0));
		
		//Thread.sleep(4000);
		selectshare.click();
		//Thread.sleep(4000);
		creategttbtn.click();
		//Thread.sleep(4000);
		triggerpriceTextbox.clear();
		//Thread.sleep(4000);
		//triggerpriceTextbox.sendKeys("1400");
		triggerpriceTextbox.sendKeys(readdatafromExcel(0, 1));
		//Thread.sleep(4000);
		quantitytextbox.clear();
		//Thread.sleep(4000);
		//quantitytextbox.sendKeys("50");
		quantitytextbox.sendKeys(readdatafromExcel(0, 2));
		//Thread.sleep(4000);
		priceTextbox.clear();
		//Thread.sleep(4000);
		//priceTextbox.sendKeys("1220");
		priceTextbox.sendKeys(readdatafromExcel(0, 3));
		//Thread.sleep(4000);
		placeorderbtn.click();
		
		// makrand vasant temkar
		
	}
	
}
