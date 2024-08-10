package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public WebDriver driver;
	public OptionManager om;
	public Properties getProperties() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}

	public WebDriver getDriver() throws IOException
	{
		om = new OptionManager(getProperties());
		if(driver==null)
		{
			String mavenBrowser =  getProperties().getProperty("browser");
			String cmdBrowser = System.getProperty("browser");
			String browser = (mavenBrowser!=null)?mavenBrowser:cmdBrowser;
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(om.chromeOption());
			}
			
			else if (browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(om.firefoxOption());			
				}
			
		}
		return driver;
	}
}
