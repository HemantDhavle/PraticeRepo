package utilities;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager 
{
	public ChromeOptions co;
	public FirefoxOptions fo;
	public Properties prop;
	
	public OptionManager(Properties prop)
	{
		this.prop=prop;
	}
	
	public ChromeOptions chromeOption()
	{
		co = new ChromeOptions(); 
		if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		return co;
	}
	
	public FirefoxOptions firefoxOption()
	{
		fo = new FirefoxOptions(); 
		if (Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		return fo;
	}
	
}
