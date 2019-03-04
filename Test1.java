
import java.io.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class ChomeHeadlessSimulator
{
	private WebDriver driver;

	public static void main(String[] args)
	{
		ChomeHeadlessSimulator sim = null;
		try
		{
			sim = new ChomeHeadlessSimulator();
			sim.getPage("https://www.google.com");
		}
		finally
		{
			if (sim != null)
				sim.close();
		}
	}

	public ChomeHeadlessSimulator()
	{
		System.setProperty("webdriver.chrome.driver", getChromeDriverPath());  
		ChromeOptions options = new ChromeOptions();  
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
		driver = new ChromeDriver(options);  		
	}

	private static String getChromeDriverPath()
	{
		File f = new File("../ExternalLibs/chromedriver");
		return f.toString();
	}	
	
	private void close()
	{
		if (driver != null)
			driver.quit();

		driver = null;
	}

	private void getPage(String url)
	{
		driver.get(url);
	}
}
