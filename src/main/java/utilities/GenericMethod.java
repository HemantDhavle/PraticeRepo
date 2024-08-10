package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericMethod 
{
	public WebDriver driver;
	public GenericMethod(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void enterTest(By by, String val)
	{
		driver.findElement(by).sendKeys(val);
	}
	
	public void doClick(By by)
	{
		driver.findElement(by).click();
	}

}
