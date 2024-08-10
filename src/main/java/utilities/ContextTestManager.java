package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.PageManager;

public class ContextTestManager 
{
	public WebDriver driver;
	public BaseTest baseTest;
	public PageManager pageManager;
	
	public ContextTestManager() throws IOException
	{
		baseTest = new BaseTest();
		pageManager = new PageManager(baseTest.getDriver());
	}
	
	

}
