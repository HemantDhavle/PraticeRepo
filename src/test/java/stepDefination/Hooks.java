package stepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ContextTestManager;

public class Hooks 
{
	public ContextTestManager contextTestManager;
	public Hooks(ContextTestManager contextTestManager)
	{
		this.contextTestManager = contextTestManager;
	}

	@Before
	public void setUp() throws IOException
	{
		String url = contextTestManager.baseTest.getProperties().getProperty("url");
		contextTestManager.baseTest.getDriver().get(url);
		contextTestManager.baseTest.getDriver().manage().window().maximize();
	
	}
	@AfterTest
	public void screenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TakesScreenshot tk= (TakesScreenshot)contextTestManager.baseTest.getDriver();
			File file = tk.getScreenshotAs(OutputType.FILE);
			byte[] arr = FileUtils.readFileToByteArray(file);
			scenario.attach(arr, "images/png", "images");
		}
	}
	
	@After
	public void tearDown() throws IOException
	{
		contextTestManager.baseTest.getDriver().quit();
	}
}
