package pages;

import org.openqa.selenium.WebDriver;

public class PageManager 
{
	public WebDriver driver;
	public RegistrationPage registration;
	public PageManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public RegistrationPage getRegistrationPage()
	{
		registration = new RegistrationPage(driver);
		return registration;
	}
	
	
	

}
