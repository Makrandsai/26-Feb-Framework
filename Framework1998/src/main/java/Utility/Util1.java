package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;
import io.cucumber.messages.types.Source;

public class Util1 extends TestBase{

	
	public static void Screenshot(String name) throws IOException
	{
		
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dist = new File("C:\\Users\\Om Sai\\eclipse-workspace\\Framework1998\\Screenshots\\"+name+".jpeg");
		
		FileHandler.copy(Source, dist);
		
	}
}
