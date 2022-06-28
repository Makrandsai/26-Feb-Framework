package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.css.model.Value;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

	public static WebDriver driver;
	public String setproperty(String value) throws IOException // return type string

	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Om Sai\\eclipse-workspace\\Framework1998\\src\\main\\java\\Config\\Config.properties");
		prop.load(file);
		
	    return  prop.getProperty(value); // here we make return type as string 
	}
	
	public void initalization() throws IOException
	{
		
	String browsername	= setproperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome"))
	{
		ChromeOptions ch = new ChromeOptions();
		
		ch.addArguments("--disable-notifications");
		ch.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(ch);
		
	}
	
	else if (browsername.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
	
	}
	
	else if( browsername.equalsIgnoreCase("edge"))
	{
		
		System.setProperty("webdriver.egde.driver", "msedgedriver.exe");
		driver = new EdgeDriver();
		
	}
	
	else if (browsername.equalsIgnoreCase("opera"))
	{
		System.setProperty("webdriver.opera.driver", "operadriver.exe");
		driver = new OperaDriver();
		
	}
	
	else 
		{
		
		driver = new SafariDriver();
	    }
	
	
		//ChromeOptions ch = new ChromeOptions();
		//ch.addArguments("--disable-notifications");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get("https://kite.zerodha.com/");
		driver.get(setproperty("url")); // we get the url from config.properties file
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	
	
	public String readdatafromExcel(int rownum ,int colnum) throws EncryptedDocumentException, IOException
	
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\Om Sai\\eclipse-workspace\\Framework1998\\TestData\\Zerodha_1.xlsx");
	    Sheet Exceldata = WorkbookFactory.create(file).getSheet("Sheet1");
	    String value = Exceldata.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
		
	} 
	
	
}
